package eu.vicci.process.wampserver;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.client.ProcessEngineClient;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.subscribers.HumanTaskResponseSubscriber;
import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.core.SuperPeerRequest;
import eu.vicci.process.engine.core.ClientBuilderFactory;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.RpcId;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.HumanTaskMessageManager;
import eu.vicci.process.model.util.messages.ProcessEngineUpdate;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.HumanTaskResponseListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import eu.vicci.process.model.util.messages.core.IProcessEngineUpdate;
import eu.vicci.process.model.util.messages.core.IProcessEngineUpdate.UpdateType;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.PeerMetrics;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
import eu.vicci.process.server.util.FeedbackServiceMonitor;
import eu.vicci.process.server.util.JacksonEncoder;
import eu.vicci.process.server.util.Util;
import eu.vicci.process.wampserver.handlers.AbstractRpcHandler;
import eu.vicci.process.wampserver.handlers.DeployInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.DeployModelServerHandler;
import eu.vicci.process.wampserver.handlers.DeployProcessServerHandler;
import eu.vicci.process.wampserver.handlers.ExecuteProcessStepServerHandler;
import eu.vicci.process.wampserver.handlers.InstanceConfigurationServerHandler;
import eu.vicci.process.wampserver.handlers.ModelListServerHandler;
import eu.vicci.process.wampserver.handlers.PauseInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessDocumentServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessInfosServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessInstanceInfosReducedServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessInstanceInfosServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessInstanceListServerHandler;
import eu.vicci.process.wampserver.handlers.ProcessListServerHandler;
import eu.vicci.process.wampserver.handlers.RegisterClientServerHandler;
import eu.vicci.process.wampserver.handlers.RegisterPeerServerHandler;
import eu.vicci.process.wampserver.handlers.RemoveInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.ResumeInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveClosedHumanTaskResponses;
import eu.vicci.process.wampserver.handlers.RetrieveInstanceLogServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveInstanceStateServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveOpenHumanTaskRequestsHandler;
import eu.vicci.process.wampserver.handlers.RetrieveRecentStateChangesServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveRegisteredPeersListServerHandler;
import eu.vicci.process.wampserver.handlers.SemanticPersonsHandler;
import eu.vicci.process.wampserver.handlers.StartInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.StopInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.UploadAndDeployServerHandler;
import eu.vicci.process.wampserver.handlers.UploadModelServerHandler;
import feign.Feign;
import feign.RetryableException;
import ws.wamp.jawampa.ApplicationError;
import ws.wamp.jawampa.WampClient;
import ws.wamp.jawampa.WampClientBuilder;
import ws.wamp.jawampa.WampRouter;
import ws.wamp.jawampa.WampRouterBuilder;
import ws.wamp.jawampa.connection.IWampConnectorProvider;
import ws.wamp.jawampa.transport.netty.NettyWampClientConnectorProvider;
import ws.wamp.jawampa.transport.netty.NettyWampConnectionConfig;
import ws.wamp.jawampa.transport.netty.SimpleWampWebsocketListener;

public class SuperPeer {
	protected static final Logger LOG = LoggerFactory.getLogger(SuperPeer.class);
	protected static final String DEFAULT_CONFIG_PATH = "server.conf";
	
	//also used for trying connect to feedback service
	private static final int PUBLISH_STATUS_SECONDS = 3;

	protected final PeerProfile peerProfile;

	private final IConfigurationReader configReader;
	private final IProcessManager processManager;

	private WampRouter router;
	private SimpleWampWebsocketListener server;
	protected WampClient serverClient;
	
	private FeedbackServiceMonitor feedbackServiceMonitor;
	private PeerStatusThread statusThread;
	
	//If feedbackservice is used.
	//Will change to false, if not configured in server.conf.
	private boolean fbsIsUsed = true;

	public SuperPeer(IProcessManager processManager, IConfigurationReader configReader) {
		if (configReader == null || processManager == null)
			throw new IllegalArgumentException("args cant be null");
		this.configReader = configReader;
		this.processManager = processManager;
		this.processManager.addStateChangeListener(stateChangeListener);
		this.processManager.addHumanTaskRequestListener(humanTaskRequestListener);
		this.processManager.addProcessEngineListener(processEngineListener);
		this.processManager.setClientBuilderFactory(clientBuilderFactory);
		peerProfile = createPeerProfile();
	}

	public SuperPeer(IProcessManager processManager) {
		this(processManager, new ConfigurationReader(DEFAULT_CONFIG_PATH));
	}

	protected PeerProfile createPeerProfile() {
		PeerProfile profile = PeerProfile.create(true);
		addBaseInfosToPeerProfile(profile);
		return profile;
	}
	
	protected void addBaseInfosToPeerProfile(PeerProfile profile){
		profile.setIp(getIpSafe());
		profile.setDevices(configReader.getDevices());						
	}

	public void stop() {
		statusThread.stop();
		processManager.removeStateChangeListener(stateChangeListener);
		processManager.removeHumanTaskRequestListener(humanTaskRequestListener);
		processManager.removeProcessEngineListener(processEngineListener);

		serverClient.close().toBlocking().last();
		stopRouter();
	}

	protected void stopRouter() {
		server.stop();
		router.close().toBlocking().last();
	}

	public void start() throws ApplicationError {
		startWampRouterAndClient(configReader);
		operationsAfterConnection();
		serverClient.open();
		statusThread = new PeerStatusThread(PUBLISH_STATUS_SECONDS);
		statusThread.start();
	}

	private void operationsAfterConnection() {
		serverClient.statusChanged().subscribe(state -> {
			if (!(state instanceof WampClient.ConnectedState))
				return;
			registerRpcHandlers(); // registered when client is opened and connected
			subscripeToTopics(); // subscriped when client is opened and connected
			registerPeer(); // register peer when client is opened and connected and this is only peer
		});
	}

	public PeerProfile getPeerProfile() {
		return peerProfile;
	}

	/**
	 * register the peer on the super peer after the server client has connected
	 */
	protected void registerPeer() {
		// nothing to do. this is the super peer
	}

	private StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage arg) {
			serverClient.publish(TopicId.STATE_CHANGE, arg);
		}
	};

	private HumanTaskRequestListener humanTaskRequestListener = new HumanTaskRequestListener() {
		@Override
		public void onMessage(IHumanTaskRequest arg) {
			serverClient.publish(TopicId.HUMAN_TASK_REQ, arg);
		}
	};

	private ProcessEngineListener processEngineListener = new ProcessEngineListener() {
		@Override
		public void onProcessInstanceDeployed(IProcessInstanceInfo processInstanceInfo) {
			publishEngineUpdate(UpdateType.INSTANCE_DEPLOYED, processInstanceInfo);
		}

		@Override
		public void onProcessDeployed(IProcessInfo processInfo) {
			publishEngineUpdate(UpdateType.PROCESS_DEPLOYED, processInfo);
		}
	};

	private HumanTaskResponseListener humanTaskResponseListener = new HumanTaskResponseListener() {
		@Override
		public void onMessage(IHumanTaskResponse arg) {
			HumanTaskMessageManager.getInstance().addHumanTaskResponse(arg);
		}
	};

	private void publishEngineUpdate(UpdateType type, Object payload) {
		String payloadStr = null;
		try {
			payloadStr = new ObjectMapper().writeValueAsString(payload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		IProcessEngineUpdate update = new ProcessEngineUpdate(type, payloadStr);
		serverClient.publish(TopicId.ENGINE_UPDATE, update);
	}

	private ClientBuilderFactory clientBuilderFactory = new ClientBuilderFactory() {
		@Override
		public AbstractClientBuilder createClientBuilder() {
			return new ProcessEngineClientBuilder();
		}
	};

	private void subscripeToTopics() {
		// subscriptions goes here

		serverClient.makeSubscription(TopicId.HUMAN_TASK_RESP)
				.subscribe(new HumanTaskResponseSubscriber(humanTaskResponseListener));
	}

	private void startWampRouterAndClient(IConfigurationReader configReader) throws ApplicationError {
		String port = configReader.getPort();
		String namespace = configReader.getNamespace();
		String realmName = configReader.getRealmName();
		startRouter(port, namespace, realmName);
		startClient(port, namespace, realmName);
	}

	protected void startClient(String ip, String port, String namespace, String realmName) throws ApplicationError {
		IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
		WampClientBuilder builder = new WampClientBuilder();

		builder.withConnectorProvider(connectorProvider).withUri("ws://" + ip + ":" + port + "/" + namespace)
				.withRealm(realmName).withInfiniteReconnects().withReconnectInterval(3, TimeUnit.SECONDS)
				.withConnectionConfiguration(getNettyWampConfig());
		try {
			serverClient = builder.build();
		} catch (Exception e) {
			throw new ApplicationError(e.getMessage());
		}
	}

	// this starts the client which handles all rpc call on the server
	protected void startClient(String port, String namespace, String realmName) throws ApplicationError {
		startClient("localhost", port, namespace, realmName);
	}

	private NettyWampConnectionConfig getNettyWampConfig() {
		return (new NettyWampConnectionConfig.Builder())
				.withMaxFramePayloadLength(ProcessEngineClient.MAX_FRAME_PAYLOAD_LENGHT).build();
	}

	protected void startRouter(String port, String namespace, String realmName) throws ApplicationError {
		WampRouterBuilder routerBuilder = new WampRouterBuilder();
		routerBuilder.addRealm(realmName);
		router = routerBuilder.build();
		URI serverUri = URI.create("ws://0.0.0.0:" + port + "/" + namespace);
		server = new SimpleWampWebsocketListener(router, serverUri, null);
		server.start();
	}
	
	private SuperPeerRequest superPeerRequest;
	
	private void createSuperPeerRequest(){
		superPeerRequest = new SuperPeerRequest();
		superPeerRequest.profile = peerProfile;
		superPeerRequest.port = configReader.getPort();
		superPeerRequest.namespace = configReader.getNamespace();
		superPeerRequest.realm = configReader.getRealmName();		
	}
	
	private void requestingFeedbackMonitor(){
		if(this instanceof Peer) return;
		if(feedbackServiceMonitor == null) createFeedbackServiceMonitor();
		if(superPeerRequest == null)createSuperPeerRequest();
		
		try { 
			feedbackServiceMonitor.requestingMonitoring(superPeerRequest);
		} catch (NullPointerException e) {
			LOG.info("Feedback Service Client not initialized. SuperPeer will not request the FBS.");
		} catch (RetryableException e) {
			LOG.error("error while connecting feedback-service: {}", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void registerRpcHandlers() {
		registerProcedure(RpcId.LIST_MODELS, new ModelListServerHandler(processManager));
		registerProcedure(RpcId.UPLOAD_MODEL, new UploadModelServerHandler(processManager));
		registerProcedure(RpcId.DEPLOY_MODEL, new DeployModelServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_INFOS, new ProcessInfosServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_LIST, new ProcessListServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_INSTANCE_LIST, new ProcessInstanceListServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_INSTANCE_INFOS, new ProcessInstanceInfosServerHandler(processManager));
		registerProcedure(RpcId.START_INSTANCE, new StartInstanceServerHandler(processManager));
		registerProcedure(RpcId.STOP_INSTANCE, new StopInstanceServerHandler(processManager));
		registerProcedure(RpcId.PAUSE_INSTANCE, new PauseInstanceServerHandler(processManager));
		registerProcedure(RpcId.RESUME_INSTANCE, new ResumeInstanceServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_DOC, new ProcessDocumentServerHandler(processManager));
		registerProcedure(RpcId.INSTANCE_CONFIGURATION, new InstanceConfigurationServerHandler(processManager));
		registerProcedure(RpcId.DEPLOY_INSTANCE, new DeployInstanceServerHandler(processManager));
		registerProcedure(RpcId.DEPLOY_PROCESS, new DeployProcessServerHandler(processManager));
		registerProcedure(RpcId.REMOVE_INSTANCE, new RemoveInstanceServerHandler(processManager));
		registerProcedure(RpcId.PROCESS_INSTANCE_INFOS_REDUCED, new ProcessInstanceInfosReducedServerHandler(processManager));
		registerProcedure(RpcId.INSTANCE_LOG, new RetrieveInstanceLogServerHandler(processManager));
		registerProcedure(RpcId.INSTANCE_STATE, new RetrieveInstanceStateServerHandler(processManager));
		registerProcedure(RpcId.RECENT_STATE_CHANGES, new RetrieveRecentStateChangesServerHandler(processManager));
		registerProcedure(RpcId.EXECUTE_PROCESSSTEP, new ExecuteProcessStepServerHandler(processManager));
		registerProcedure(RpcId.UPLOAD_AND_DEPLOY, new UploadAndDeployServerHandler(processManager));
		registerProcedure(RpcId.REGISTER_CLIENT, new RegisterClientServerHandler());
		registerProcedure(RpcId.OPEN_HUMAN_TASK_LIST, new RetrieveOpenHumanTaskRequestsHandler());
		registerProcedure(RpcId.CLOSED_HUMAN_TASK_RESPONSE_LIST, new RetrieveClosedHumanTaskResponses());
		registerProcedure(RpcId.SEMANTIC_PERSONS, new SemanticPersonsHandler());
		registerProcedure(RpcId.REGISTERED_PEERS, new RetrieveRegisteredPeersListServerHandler());
		registerProcedure(RpcId.REGISTER_PEER, new RegisterPeerServerHandler());

		// Register other handlers here
	}

	protected void registerProcedure(String rpcId, AbstractRpcHandler handler) {
		serverClient.registerProcedure(rpcId).subscribe(handler);
	}
	
	protected void createFeedbackServiceMonitor(){
		String feedbackHost = configReader.getFeedbackServiceUri();
		fbsIsUsed = feedbackHost != null && !feedbackHost.isEmpty();
		if(!fbsIsUsed) return;
		if(!feedbackHost.startsWith("http://")) feedbackHost = "http://" + feedbackHost;
		
		feedbackServiceMonitor = Feign.builder()
				.encoder(new JacksonEncoder())
				.target(FeedbackServiceMonitor.class, feedbackHost);		
	}
	
	protected String getIpSafe(){
		String ip = Util.getLocalIpWithFilter();
		if(ip == null || ip.isEmpty())
			throw new RuntimeException("Cant find the ip of this host. Maybe check the ip filter in the config file.");
		LOG.debug("Runtime exposes IP: {}", ip);
		return ip;		
	}
	
	protected void publishPeerMetrics(){
		PeerMetrics metrics = new PeerMetrics();
		metrics.peerId = peerProfile.getPeerId();
		metrics.hasBattery = Util.systemHasBattery();
		metrics.batteryStatus = Util.getSystemBatteryStatus();
		
		if(serverClient != null)
			serverClient.publish(TopicId.PEER_METRICS, metrics);
	}
	
	protected void publishPeerStatus(){
		if(fbsIsUsed)
			requestingFeedbackMonitor();
		publishPeerMetrics();
	}
	
	private class PeerStatusThread implements Runnable {
		private final int timeout;
		private boolean terminate = false;
		
		private PeerStatusThread(int seconds){
			timeout = 1000 * seconds;		
		}
		
		private void start(){
			Thread thread = new Thread(this);
			thread.setName(PeerStatusThread.class.getSimpleName());
			thread.setDaemon(true);
			thread.start();		
		}

		@Override
		public void run() {
			while (!terminate) {
				publishPeerStatus();
				try {
					Thread.sleep(timeout);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}		
			}			
		}
		
		private void stop(){
			terminate = true;			
		}	

	}
	
}
