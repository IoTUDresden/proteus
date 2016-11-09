package eu.vicci.process.wampserver;

import java.net.URI;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.client.ProcessEngineClient;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.subscribers.HumanTaskResponseSubscriber;
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
import eu.vicci.process.wampserver.handlers.RemoveInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.ResumeInstanceServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveClosedHumanTaskResponses;
import eu.vicci.process.wampserver.handlers.RetrieveInstanceLogServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveInstanceStateServerHandler;
import eu.vicci.process.wampserver.handlers.RetrieveOpenHumanTaskRequestsHandler;
import eu.vicci.process.wampserver.handlers.RetrieveRecentStateChangesServerHandler;
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

public class RuntimeServer {
	private static final String DEFAULT_CONFIG_PATH = "server.conf";
	
	private final IConfigurationReader configReader;
	private final IProcessManager processManager;

	private WampRouter router;
	private WampClient serverClient;
	private String serverIdent = UUID.randomUUID().toString();
	private SimpleWampWebsocketListener server;
	
	public RuntimeServer(IProcessManager processManager, IConfigurationReader configReader){
		if(configReader == null || processManager == null)
			throw new IllegalArgumentException("args cant be null");
		this.configReader = configReader;
		this.processManager = processManager;
		this.processManager.addStateChangeListener(stateChangeListener);
		this.processManager.addHumanTaskRequestListener(humanTaskRequestListener);
		this.processManager.addProcessEngineListener(processEngineListener);
		this.processManager.setClientBuilderFactory(clientBuilderFactory);
	}
	
	public RuntimeServer(IProcessManager processManager){
		this(processManager, new ConfigurationReader(DEFAULT_CONFIG_PATH));
	}

	public String getServerIdent() {
		return serverIdent;
	}

	public void stop() {	
		processManager.removeStateChangeListener(stateChangeListener);
		processManager.removeHumanTaskRequestListener(humanTaskRequestListener);
		processManager.removeProcessEngineListener(processEngineListener);
		serverClient.close().toBlocking().last();        
        server.stop();        
        router.close().toBlocking().last();
	}

	public void start() throws ApplicationError {
		startWampRouterAndClient(configReader);
		registerRpcHandlers(); //registered when client is opened and connected
		subscripeToTopics(); //subscriped when client is opened and connected		
		serverClient.open();
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
	
	private ClientBuilderFactory clientBuilderFactory = new ClientBuilderFactory() {		
		@Override
		public AbstractClientBuilder createClientBuilder() {
			return new ProcessEngineClientBuilder();
		}
	};
	
	private void subscripeToTopics(){
		//subscriptions goes here
		serverClient.statusChanged().subscribe(state -> {
			if (!(state instanceof WampClient.ConnectedState))
				return;
			serverClient.makeSubscription(TopicId.HUMAN_TASK_RESP)
			.subscribe(new HumanTaskResponseSubscriber(humanTaskResponseListener));
		});		
	}

	private void startWampRouterAndClient(IConfigurationReader configReader) throws ApplicationError {
		String port = configReader.getPort();
		String namespace = configReader.getNamespace();
		String realmName = configReader.getRealmName();
		startRouter(port, namespace, realmName);
		startClient(port, namespace, realmName);
	}

	//this starts the client which handles all rpc call on the server
	private void startClient(String port, String namespace, String realmName) throws ApplicationError {
		IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
		WampClientBuilder builder = new WampClientBuilder();

		builder.withConnectorProvider(connectorProvider).withUri("ws://localhost:" + port + "/" + namespace)
				.withRealm(realmName).withInfiniteReconnects().withReconnectInterval(3, TimeUnit.SECONDS)
				.withConnectionConfiguration(getNettyWampConfig());
		try {
			serverClient = builder.build();
		} catch (Exception e) {
			throw new ApplicationError(e.getMessage());
		}
	}
	
	private NettyWampConnectionConfig getNettyWampConfig(){
		return (new NettyWampConnectionConfig.Builder())
				.withMaxFramePayloadLength(ProcessEngineClient.MAX_FRAME_PAYLOAD_LENGHT).build();
	}

	private void startRouter(String port, String namespace, String realmName) throws ApplicationError {
		WampRouterBuilder routerBuilder = new WampRouterBuilder();
		routerBuilder.addRealm(realmName);
		router = routerBuilder.build();
		URI serverUri = URI.create("ws://0.0.0.0:" + port + "/" + namespace);
		server = new SimpleWampWebsocketListener(router, serverUri, null);
		server.start();
	}
	
	private void registerRpcHandlers() {
		serverClient.statusChanged().subscribe(state -> {
			if (!(state instanceof WampClient.ConnectedState))
				return;

			serverClient.registerProcedure(RpcId.LIST_MODELS)
			.subscribe(new ModelListServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.UPLOAD_MODEL)
			.subscribe(new UploadModelServerHandler(processManager));

			serverClient.registerProcedure(RpcId.DEPLOY_MODEL)
			.subscribe(new DeployModelServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.PROCESS_INFOS)
			.subscribe(new ProcessInfosServerHandler(processManager));
		
			serverClient.registerProcedure(RpcId.PROCESS_LIST)
			.subscribe(new ProcessListServerHandler(processManager));

			serverClient.registerProcedure(RpcId.PROCESS_INSTANCE_LIST)
			.subscribe(new ProcessInstanceListServerHandler(processManager));			

			serverClient.registerProcedure(RpcId.PROCESS_INSTANCE_INFOS)
			.subscribe(new ProcessInstanceInfosServerHandler(processManager));

			serverClient.registerProcedure(RpcId.START_INSTANCE)
			.subscribe(new StartInstanceServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.STOP_INSTANCE)
			.subscribe(new StopInstanceServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.PAUSE_INSTANCE)
			.subscribe(new PauseInstanceServerHandler(processManager));

			serverClient.registerProcedure(RpcId.RESUME_INSTANCE)
			.subscribe(new ResumeInstanceServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.PROCESS_DOC)
			.subscribe(new ProcessDocumentServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.INSTANCE_CONFIGURATION)
			.subscribe(new InstanceConfigurationServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.DEPLOY_INSTANCE)
			.subscribe(new DeployInstanceServerHandler(processManager));
				
			serverClient.registerProcedure(RpcId.DEPLOY_PROCESS)
			.subscribe(new DeployProcessServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.REMOVE_INSTANCE)
			.subscribe(new RemoveInstanceServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.PROCESS_INSTANCE_INFOS_REDUCED)
			.subscribe(new ProcessInstanceInfosReducedServerHandler(processManager));

			serverClient.registerProcedure(RpcId.INSTANCE_LOG)
			.subscribe(new RetrieveInstanceLogServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.INSTANCE_STATE)
			.subscribe(new RetrieveInstanceStateServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.RECENT_STATE_CHANGES)
			.subscribe(new RetrieveRecentStateChangesServerHandler(processManager));

			serverClient.registerProcedure(RpcId.EXECUTE_PROCESSSTEP)
			.subscribe(new ExecuteProcessStepServerHandler(processManager));
			
			serverClient.registerProcedure(RpcId.UPLOAD_AND_DEPLOY)
			.subscribe(new UploadAndDeployServerHandler(processManager));

			serverClient.registerProcedure(RpcId.REGISTER_CLIENT)
			.subscribe(new RegisterClientServerHandler());
			
			serverClient.registerProcedure(RpcId.OPEN_HUMAN_TASK_LIST)
			.subscribe(new RetrieveOpenHumanTaskRequestsHandler());
			
			serverClient.registerProcedure(RpcId.CLOSED_HUMAN_TASK_RESPONSE_LIST)
			.subscribe(new RetrieveClosedHumanTaskResponses());
			
			serverClient.registerProcedure(RpcId.SEMANTIC_PERSONS)
			.subscribe(new SemanticPersonsHandler());
			
			//Register other handlers here
		});
	}


	
}
