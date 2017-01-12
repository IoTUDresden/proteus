package eu.vicci.process.wampserver;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.client.ProcessEngineClient;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.subscribers.HumanTaskResponseSubscriber;
import eu.vicci.process.distribution.core.PeerProfile;
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
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
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
	protected static final String DEFAULT_CONFIG_PATH = "server.conf";
	
	protected final PeerProfile peerProfile;
	
	private final IConfigurationReader configReader;
	private final IProcessManager processManager;

	private WampRouter router;
	private SimpleWampWebsocketListener server;
	protected WampClient serverClient;
	
//	private String serverName;
	
	public SuperPeer(IProcessManager processManager, IConfigurationReader configReader){
		if(configReader == null || processManager == null)
			throw new IllegalArgumentException("args cant be null");
//		serverName = configReader.getServerName();
		this.configReader = configReader;
		this.processManager = processManager;
		this.processManager.addStateChangeListener(stateChangeListener);
		this.processManager.addHumanTaskRequestListener(humanTaskRequestListener);
		this.processManager.addProcessEngineListener(processEngineListener);
//		this.processManager.addRemoteStepResponseListener(this);
//		this.processManager.addPingRequestListener(this);
//		this.processManager.addPingListener(this);
//		this.processManager.addMetricsListener(this);
		this.processManager.setClientBuilderFactory(clientBuilderFactory);
		peerProfile = createPeerProfile();
	}
	
	public SuperPeer(IProcessManager processManager){
		this(processManager, new ConfigurationReader(DEFAULT_CONFIG_PATH));
	}
	
	protected PeerProfile createPeerProfile(){
		return PeerProfile.create(true);
	}
	
//	public String getServerName(){
//		return serverName;
//	}
	
	public void stop() {	
		processManager.removeStateChangeListener(stateChangeListener);
		processManager.removeHumanTaskRequestListener(humanTaskRequestListener);
		processManager.removeProcessEngineListener(processEngineListener);
		
		serverClient.close().toBlocking().last();   
		stopRouter();
	}
	
	protected void stopRouter(){
        server.stop();        
        router.close().toBlocking().last();		
	}

	public void start() throws ApplicationError {
		startWampRouterAndClient(configReader);
		registerRpcHandlers(); //registered when client is opened and connected
		subscripeToTopics(); //subscriped when client is opened and connected
		registerPeer(); // register peer when client is opened and connected and this is only peer
		serverClient.open();
	}
	
	public PeerProfile getPeerProfile(){
		return peerProfile;
	}
	
	/**
	 * register the peer on the super peer after the server client has connected
	 */
	protected void registerPeer(){
		//nothing to do. this is the super peer		
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
	
	private void publishEngineUpdate(UpdateType type, Object payload){
		String payloadStr = null;
		try {	payloadStr = new ObjectMapper().writeValueAsString(payload);	} 
		catch (JsonProcessingException e) { e.printStackTrace(); }
		
		IProcessEngineUpdate update = new ProcessEngineUpdate(type, payloadStr);
		serverClient.publish(TopicId.ENGINE_UPDATE, update);		
	}
	
//	@Override
//	public void onRemoteStepResponse(IRemoteStepResponse remoteStepResponse) {
//		//publish all RemoteStepResponses to subscribed clients
//		remoteStepResponse.setClientName(serverName);
//		remoteStepResponse.setClientId(getServerIdent());
//		serverClient.publish(TopicId.REMOTE_STEP_RESP, remoteStepResponse);		
//	}
//	
//	@Override
//	public void onPingRequest(IPingRequest pingRequestMessage) {
//		PingResponse pr = new PingResponse();
//		pr.setProcessInstanceId(pingRequestMessage.getProcessInstanceId());
//		pr.setProcessName(pingRequestMessage.getProcessName());
//		pr.setClientName(pingRequestMessage.getClientName());
//		pr.setClientId(getServerIdent());
//
//		System.out.println("Server: Received Ping, send response");
//		serverClient.publish(TopicId.PING_RESPONSE, pr);		
//	}
	
	private ClientBuilderFactory clientBuilderFactory = new ClientBuilderFactory() {		
		@Override
		public AbstractClientBuilder createClientBuilder() {
			return new ProcessEngineClientBuilder();
		}
	};

//	@Override
//	public void onPing(IPingMessage message) {
//		message.setClientId(getServerIdent());
//		message.setClientName(getServerName());
//		//TODO: Client Name is wichtig
//		message.setProcessInstanceId("");
//		message.setProcessName("");
//		serverClient.publish(TopicId.PING, message);	
//	}

//	@Override
//	public void onMetric(IMetricsMessage metricsMessage) {
//		metricsMessage.setClientId(getServerIdent());
//		metricsMessage.setClientName(getServerName());
//		//TODO: send usefull information		
//		serverClient.publish(TopicId.METRICS, metricsMessage);	
//	}
	
	private void subscripeToTopics(){
		//subscriptions goes here
		serverClient.statusChanged().subscribe(state -> {
			if (!(state instanceof WampClient.ConnectedState))
				return;
			serverClient.makeSubscription(TopicId.HUMAN_TASK_RESP)
			.subscribe(new HumanTaskResponseSubscriber(humanTaskResponseListener));
//			serverClient.makeSubscription(TopicId.REMOTE_STEP_RESP)
//			.subscribe(new RemoteStepResponseSubscriber());
//			serverClient.makeSubscription(TopicId.PING_REQUEST)
//			.subscribe(new PingRequestSubscriber());
		});		
	}

	private void startWampRouterAndClient(IConfigurationReader configReader) throws ApplicationError {
		String port = configReader.getPort();
		String namespace = configReader.getNamespace();
		String realmName = configReader.getRealmName();
		startRouter(port, namespace, realmName);
		startClient(port, namespace, realmName);
	}
	
	protected void startClient(String ip, String port, String namespace, String realmName) throws ApplicationError{
		IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
		WampClientBuilder builder = new WampClientBuilder();

		builder.withConnectorProvider(connectorProvider).withUri("ws://"+ ip +":" + port + "/" + namespace)
				.withRealm(realmName).withInfiniteReconnects().withReconnectInterval(3, TimeUnit.SECONDS)
				.withConnectionConfiguration(getNettyWampConfig());
		try {
			serverClient = builder.build();
		} catch (Exception e) {
			throw new ApplicationError(e.getMessage());
		}		
	}

	//this starts the client which handles all rpc call on the server
	protected void startClient(String port, String namespace, String realmName) throws ApplicationError {
		startClient("localhost", port, namespace, realmName);
	}
	
	private NettyWampConnectionConfig getNettyWampConfig(){
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
	
	protected void registerRpcHandlers() {
		serverClient.statusChanged().subscribe(state -> {
			if (!(state instanceof WampClient.ConnectedState))
				return;

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
			
			//Register other handlers here
		});
	}
	
	protected void registerProcedure(String rpcId, AbstractRpcHandler handler){
		serverClient.registerProcedure(rpcId).subscribe(handler);		
	}
}
