package eu.vicci.process.client;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.ClientProfile;
import eu.vicci.process.client.core.ConnectionListener;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.client.handlers.AbstractClientHandler;
import eu.vicci.process.client.handlers.DeployInstanceHandler;
import eu.vicci.process.client.handlers.DeployModelHandler;
import eu.vicci.process.client.handlers.DeployProcessHandler;
import eu.vicci.process.client.handlers.ExecuteProcessStepHandler;
import eu.vicci.process.client.handlers.InstanceConfigurationHandler;
import eu.vicci.process.client.handlers.ModelListHandler;
import eu.vicci.process.client.handlers.PauseInstanceHandler;
import eu.vicci.process.client.handlers.ProcessDocumentHandler;
import eu.vicci.process.client.handlers.ProcessInfosHandler;
import eu.vicci.process.client.handlers.ProcessInstanceInfosHandler;
import eu.vicci.process.client.handlers.ProcessInstanceInfosReducedHandler;
import eu.vicci.process.client.handlers.ProcessInstanceListHandler;
import eu.vicci.process.client.handlers.ProcessListHandler;
import eu.vicci.process.client.handlers.RegisterClientHandler;
import eu.vicci.process.client.handlers.RemoveInstanceHandler;
import eu.vicci.process.client.handlers.ResumeInstanceHandler;
import eu.vicci.process.client.handlers.RetrieveInstanceLogHandler;
import eu.vicci.process.client.handlers.RetrieveInstanceStateHandler;
import eu.vicci.process.client.handlers.RetrieveRecentStateChangesHandler;
import eu.vicci.process.client.handlers.StartInstanceHandler;
import eu.vicci.process.client.handlers.StopInstanceHandler;
import eu.vicci.process.client.handlers.UploadAndDeployHandler;
import eu.vicci.process.client.handlers.UploadModelHandler;
import eu.vicci.process.client.subscribers.EngineUpdateSubscriber;
import eu.vicci.process.client.subscribers.HumanTaskRequestSubscriber;
import eu.vicci.process.client.subscribers.HumanTaskResponseSubscriber;
import eu.vicci.process.client.subscribers.StateChangeMessageSubscriber;
import eu.vicci.process.engine.core.ClientBuilderFactory;
import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.util.ConfigureInstanceRequest;
import eu.vicci.process.model.util.ExecuteProcessStepRequest;
import eu.vicci.process.model.util.ProcessStartRequest;
import eu.vicci.process.model.util.UploadModelRequest;
import eu.vicci.process.model.util.Utility;
import eu.vicci.process.model.util.configuration.RpcId;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.HumanTaskResponseListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsontypeinstances.JSONTypeInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import ws.wamp.jawampa.WampClient;
import ws.wamp.jawampa.WampClientBuilder;
import ws.wamp.jawampa.connection.IWampConnectorProvider;
import ws.wamp.jawampa.transport.netty.NettyWampClientConnectorProvider;
import ws.wamp.jawampa.transport.netty.NettyWampConnectionConfig;

/**
 * The Client can be used to upload, start etc. processes and receive their
 * status updates. It is also possible to register remote procedure calls on
 * this client, which can be called from any other client (or the vicci runtime
 * server). This client implementation backs a
 * {@link ws.wamp.jawampa.WampClient}.
 */
public class ProcessEngineClient implements IProcessEngineClient {
	private static final Logger logger = LoggerFactory.getLogger(ProcessEngineClient.class);
	private static final int CONNECT_TIMEOUT = 5;
	
	/**
	 * The maximum frame lenght for the payload of calls. 
	 * If this is too low, messages will not delivered and the connection get lost in the background.
	 * 
	 * Default for this is 2^24
	 */
	public static final int MAX_FRAME_PAYLOAD_LENGHT = 16777216;

	private String uuid = UUID.randomUUID().toString();

	private final String ip;
	private final String port;
	private final String name;
	private final String namespace;
	private final String realmName;
	private final boolean isServer;
	private boolean isConnected;
	private WampClient client;

	private List<ConnectionListener> connectionListeners = new ArrayList<>();
	private List<StateChangeListener> stateChangeListeners = new ArrayList<>();
	private List<HumanTaskRequestListener> humanTaskRequestListeners = new ArrayList<>();
	private List<HumanTaskResponseListener> humanTaskResponseListeners = new ArrayList<>();
	private List<ProcessEngineListener> processEngineListeners = new ArrayList<>();

	public static final String DEFAULT_REALM = "vicciRealm";
	public static final String DEFAULT_NAMESPACE = "vicciWs";

	/**
	 * Default constructor. For a more readable code you can use the
	 * {@link eu.vicci.process.client.ProcessEngineClientBuilder}.
	 * 
	 * @param name
	 * @param ip
	 * @param port
	 * @param realmName
	 * @param namespace
	 * @param isServer
	 */
	public ProcessEngineClient(String name, String ip, String port, String realmName, String namespace,
			boolean isServer) {
		this.name = name;
		this.ip = ip;
		this.port = port;
		this.namespace = namespace;
		this.realmName = realmName;
		this.isServer = isServer;

		// Initialize the models
		SofiaPackage.eINSTANCE.eClass();
		SofiaInstancePackage.eINSTANCE.eClass();
		PictogramsPackage.eINSTANCE.eClass();

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("diagram", new XMIResourceFactoryImpl());
		m.put("sofia", new XMIResourceFactoryImpl());
		m.put("sofiainstance", new XMIResourceFactoryImpl());
	}

	/**
	 * Connects to the server. Returns, if the client is connected.
	 */
	@Override
	public boolean connect() {
		IWampConnectorProvider connectorProvider = new NettyWampClientConnectorProvider();
		WampClientBuilder builder = new WampClientBuilder();
		CountDownLatch waitTillConnected = new CountDownLatch(1);

		try {
			builder.withConnectorProvider(connectorProvider).withUri("ws://" + ip + ":" + port + "/" + namespace)
					.withRealm(realmName).withInfiniteReconnects().withReconnectInterval(3, TimeUnit.SECONDS)
					.withConnectionConfiguration(getNettyWampConfig());

			client = builder.build();
			registerRpcHandlers(waitTillConnected);
			client.open();
			boolean noTimeoutHappened = waitTillConnected.await(CONNECT_TIMEOUT, TimeUnit.SECONDS);
			return noTimeoutHappened;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private NettyWampConnectionConfig getNettyWampConfig(){
		return (new NettyWampConnectionConfig.Builder()).withMaxFramePayloadLength(MAX_FRAME_PAYLOAD_LENGHT).build();
	}

	private void subscribe() {
		client.makeSubscription(TopicId.STATE_CHANGE)
				.subscribe(new StateChangeMessageSubscriber(stateChangeMessageListener));
		client.makeSubscription(TopicId.HUMAN_TASK_REQ)
				.subscribe(new HumanTaskRequestSubscriber(humanTaskRequestListener));
		client.makeSubscription(TopicId.HUMAN_TASK_RESP)
				.subscribe(new HumanTaskResponseSubscriber(humanTaskResponseListener));
		client.makeSubscription(TopicId.ENGINE_UPDATE).subscribe(new EngineUpdateSubscriber(privateEngineListner));
	}

	private void registerRpcHandlers(final CountDownLatch waitTillConnected) {
		client.statusChanged().subscribe(state -> {
			if (state instanceof WampClient.ConnectedState) {
				subscribe();
				
				isConnected = true;

				// at this point the client is connected and the method
				// connect()
				// should return true
				waitTillConnected.countDown();

				informConnectionListeners(true);
			}

			if (state instanceof WampClient.DisconnectedState) {
				isConnected = false;
				informConnectionListeners(false);
			}
		});

	}

	/**
	 * Registers this client with all its possible procedure ids by the server.
	 * The router in the Server handles all the connection stuff. Only possible
	 * procedure ids are needed, so that you know which rpc you can call on a
	 * specific client.
	 */
	@Override
	public String registerProcessExecutionClient() {
		RegisterClientHandler rch = new RegisterClientHandler();
		ClientProfile cp = new ClientProfile(name, uuid);
		cp.addTopic("printHello");

		client.registerProcedure(cp.getRpcBase() + "printHello").subscribe(request -> {
			System.out.println("#### This is a procedure which can be executed by some client ####");
		});

		// Register possible RPC here and add this to the client profile

		callRpc(RpcId.REGISTER_CLIENT, rch, cp);
		return rch.getState();
	}

	@Override
	public String getUuid() {
		return uuid;
	}

	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public String getPort() {
		return port;
	}

	@Override
	public boolean isServer() {
		return isServer;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void publish(String topic, Object payload) {
		client.publish(topic, payload);
	}

	@Override
	public void publishHumanTask(IHumanTaskRequest payload) {
		publish(TopicId.HUMAN_TASK_REQ, payload);
	}
	
	/**
	 * Upload a process model document (either *.sofia or *.diagram)
	 * 
	 * @return {@link ReplyState}
	 */
	@Override
	public String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram) {
		return uploadProcessDefinition(processid, processdocument, isDiagram, false);
	}

	@Override
	public String uploadProcessDefinition(String processid, String processdocument, boolean isDiagram,
			boolean overrideExisting) {
		// Reduce process document, i.e. delete graphical information
		if (isDiagram) {
			Process model = getProcessFromDocument(processdocument);
			processdocument = getProcessAsString(model, null);
			isDiagram = false;
		}

		byte[] compressed = Utility.compress(processdocument);

		UploadModelRequest input = new UploadModelRequest(processid, compressed, isDiagram, overrideExisting);
		UploadModelHandler umh = new UploadModelHandler();
		callRpc(RpcId.UPLOAD_MODEL, umh, input);
		String state = umh.getState();
		return state;
	}

	/**
	 * Calls the given RPC and waits till its finished
	 * 
	 * @param rpcId
	 * @param receiver
	 * @param payload
	 */
	private void callRpc(String rpcId, AbstractClientHandler receiver, Object payload) {
		if (payload == null)
			client.call(rpcId).subscribe(receiver);
		else
			client.call(rpcId, payload).subscribe(receiver);

		try {
			boolean isCountDown = receiver.await();
			if (!isCountDown)
				logger.error("Timeout while waiting for reply for rpc: '{}'", rpcId);
		} catch (InterruptedException e) {
			logger.error("Waiting for rpc was interrupted: '{}'", rpcId);
		}
	}

	private void callRpc(String rpcId, AbstractClientHandler receiver) {
		callRpc(rpcId, receiver, null);
	}

	@Override
	public String uploadAndDeploy(Process process) {
		String text = getProcessAsString(process, null);
		printModel(text);
		byte[] compressed = Utility.compress(text);

		UploadModelRequest input = new UploadModelRequest(process.getId(), compressed, false);
		UploadAndDeployHandler uadh = new UploadAndDeployHandler();
		callRpc(RpcId.UPLOAD_AND_DEPLOY, uadh, input);
		return uadh.getState();
	}
	
	@Override
	public String deployProcess(String processid) {
		DeployModelHandler dmh = new DeployModelHandler();
		callRpc(RpcId.DEPLOY_MODEL, dmh, processid);
		return dmh.getState();
	}
	
	@Override
	public String deployProcess(Process process) {
		return deployProcessRemote(null, process);
	}
	
	@Override
	public String deployProcessRemote(String peerId, Process process) {
		String text = getProcessAsString(process, null);
		String processId = process.getId();

		printModel(text);
		byte[] compressed = Utility.compress(text);

		UploadModelRequest input = new UploadModelRequest(processId, compressed, false);
		DeployProcessHandler dmh = new DeployProcessHandler();
		callRpc(createRpcId(peerId, RpcId.DEPLOY_PROCESS), dmh, input);
		return processId;
	}

	@Override
	public String deployProcessInstance(String processId) {
		return deployProcessInstanceRemote(null, processId);
	}
	
	@Override
	public String deployProcessInstanceRemote(String peerId, String processId) {
		DeployInstanceHandler dih = new DeployInstanceHandler();
		callRpc(createRpcId(peerId, RpcId.DEPLOY_INSTANCE), dih, processId);
		System.out.println("Instance ID: " + dih.getInstanceId());
		return dih.getInstanceId();
	}
	
	private static String createRpcId(String peerId, String rpcId){
		return peerId == null ? rpcId : rpcId + RpcId.ID_SEPERATOR + peerId;
	}


	@Override
	public String configureProcessInstance(String processInstanceId, String configuration) {
		InstanceConfigurationHandler ich = new InstanceConfigurationHandler();
		ConfigureInstanceRequest input = new ConfigureInstanceRequest(processInstanceId, configuration);
		callRpc(RpcId.INSTANCE_CONFIGURATION, ich, input);
		return ich.getState();
	}

	@Override
	public String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters) {
		return startProcessInstance(processInstanceId, inputParameters, false);
	}

	@Override
	public String startProcessInstance(String processInstanceId, Map<String, DataTypeInstance> inputParameters,
			boolean runInLoop) {
		return internalStartProcessInstance(null, processInstanceId, inputParameters, runInLoop);
	}
	
	@Override
	public String startProcessInstanceRemote(String peerId, String processInstanceId,
			Map<String, DataTypeInstance> inputParameters) {
		return internalStartProcessInstance(peerId, processInstanceId, inputParameters, false);
	}
	
	private String internalStartProcessInstance(String peerId, String processInstanceId, Map<String, DataTypeInstance> inputParameters,
			boolean runInLoop) {
		// TODO run in loop
		
		StartInstanceHandler sih = new StartInstanceHandler();
		Map<String, IJSONTypeInstance> ports = new HashMap<String, IJSONTypeInstance>();

		if (inputParameters != null) {
			for (String dtId : inputParameters.keySet()) {
				DataTypeInstance dti = inputParameters.get(dtId);
				IJSONTypeInstance json = JSONTypeInstanceSerializer.makeJSONTypeInstance(dti);
				ports.put(dtId, json);
			}
		} else {
			ports = null;
		}

		ProcessStartRequest input = new ProcessStartRequest(processInstanceId, ports, runInLoop);
		callRpc(createRpcId(peerId, RpcId.START_INSTANCE), sih, input);
		return null;		
	}

	@Override
	public String stopProcessInstance(String processInstanceId) {
		StopInstanceHandler stih = new StopInstanceHandler();
		callRpc(RpcId.STOP_INSTANCE, stih, processInstanceId);
		return stih.getState();
	}

	@Override
	public String pauseProcessInstance(String processInstanceId) {
		PauseInstanceHandler pih = new PauseInstanceHandler();
		callRpc(RpcId.PAUSE_INSTANCE, pih, processInstanceId);
		return pih.getState();
	}

	@Override
	public String resumeProcessInstance(String processInstanceId) {
		ResumeInstanceHandler rih = new ResumeInstanceHandler();
		callRpc(RpcId.RESUME_INSTANCE, rih, processInstanceId);
		return rih.getState();
	}

	@Override
	public String getProcessDefinition(String processid) {
		ProcessDocumentHandler pdh = new ProcessDocumentHandler();
		callRpc(RpcId.PROCESS_DOC, pdh, processid);
		return pdh.getDocument();
	}

	@Override
	public List<String> listUploadedProcessDefinitions() {
		ModelListHandler mlh = new ModelListHandler();
		callRpc(RpcId.LIST_MODELS, mlh);
		return mlh.getModelList();
	}

	@Override
	public List<IProcessInfo> listDeployedProcesses() {
		ProcessListHandler plh = new ProcessListHandler();
		callRpc(RpcId.PROCESS_LIST, plh);
		return plh.getProcessInfos();
	}

	@Override
	public Process getProcessInfos(String processId) {
		ProcessInfosHandler pih = new ProcessInfosHandler();
		callRpc(RpcId.PROCESS_INFOS, pih, processId);
		return pih.getProcess();
	}

	@Override
	public ProcessInstance getProcessInstanceInfos(String processInstanceId) {
		ProcessInstanceInfosHandler piih = new ProcessInstanceInfosHandler();
		callRpc(RpcId.PROCESS_INSTANCE_INFOS, piih, processInstanceId);
		return piih.getProcessInstance();
	}

	@Override
	public Map<String, String> getProcessInstanceInfosReduced(String processInstanceId) {
		ProcessInstanceInfosReducedHandler piirh = new ProcessInstanceInfosReducedHandler();
		callRpc(RpcId.PROCESS_INSTANCE_INFOS_REDUCED, piirh, processInstanceId);
		return piirh.getProcessStepInstances();
	}

	@Override
	public List<IProcessInstanceInfo> listProcessInstances() {
		ProcessInstanceListHandler pilh = new ProcessInstanceListHandler();
		callRpc(RpcId.PROCESS_INSTANCE_LIST, pilh);
		return pilh.getProcessInstanceList();
	}

	@Override
	public String uploadModelFile(String filepath) {
		return uploadModelFile(filepath, false);
	}

	@Override
	public String uploadModelFile(String filepath, boolean overrideExisting) {
		Process model = null;
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(org.eclipse.emf.common.util.URI.createURI(filepath), true);

		if (filepath.endsWith(EXT_DIAGRAM)) {
			model = (Process) resource.getContents().get(1);
		} else {
			model = (Process) resource.getContents().get(0);
		}

		String modelId = model.getId();
		String text = getProcessAsString(model, null);
		printModel(text);
		return uploadProcessDefinition(modelId, text, false, overrideExisting);
	}

	@Override
	public String removeInstance(String processInstanceId) {
		RemoveInstanceHandler rih = new RemoveInstanceHandler();
		callRpc(RpcId.REMOVE_INSTANCE, rih, processInstanceId);
		return rih.getState();
	}

	@Override
	public IStateChangeMessage getInstanceState(String processInstanceId) {
		RetrieveInstanceStateHandler rish = new RetrieveInstanceStateHandler();
		callRpc(RpcId.INSTANCE_STATE, rish, processInstanceId);
		return rish.getScm();
	}

	@Override
	public List<IStateChangeMessage> getInstanceLog(String processInstanceId) {
		RetrieveInstanceLogHandler rilh = new RetrieveInstanceLogHandler();
		callRpc(RpcId.INSTANCE_LOG, rilh, processInstanceId);
		return rilh.getInstanceLog();
	}

	@Override
	public List<IStateChangeMessage> getRecentStateChanges() {
		RetrieveRecentStateChangesHandler rrsch = new RetrieveRecentStateChangesHandler();
		callRpc(RpcId.RECENT_STATE_CHANGES, rrsch);
		return rrsch.getRecentStateChanges();
	}

	@Override
	public ProcessStepInstance executeProcessStep(ProcessStepInstance psi, ProcessStep ps, boolean alreadyExecuting) {
		if (alreadyExecuting)
			return null;
		String text1 = "";
		XMLProcessor processor = new XMLProcessor();
		Resource res = ps.eResource();

		try {
			text1 = processor.saveToString(res, Collections.EMPTY_MAP);
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		String processInstanceString = JSONProcessStepInstanceSerializer.serialize(psi);
		ExecuteProcessStepRequest epr = new ExecuteProcessStepRequest();
		epr.setProcessStepInstance(processInstanceString);
		epr.setProcessStepModel(text1);
		ExecuteProcessStepHandler epsh = new ExecuteProcessStepHandler();

		callRpc(RpcId.EXECUTE_PROCESSSTEP, epsh, epr);

		String psiReturnString = epsh.getProcessInstanceString();
		ProcessStepInstance psiReturn = JSONProcessStepInstanceSerializer.deserialize(psiReturnString,
				SofiaInstanceFactory.eINSTANCE);
		return psiReturn;
	}

	@Override
	public void close() {
		client.close().toBlocking().last();
	}

	@Override
	public void setClientBuilderFactory(ClientBuilderFactory factory) {
		// not interested on this method for client
	}

	@Override
	public AbstractClientBuilder createNewClientBuilder() {
		// not interested on this method for client
		return null;
	}

	@Override
	public void loadExistingModels() {
		// not interested in this at the moment
	}

	@Override
	public Map<String, String> getUploadedProcesses() {
		// not interested in this at the moment
		return null;
	}

	@Override
	public void addConnectionListener(ConnectionListener listener) {
		if (!connectionListeners.contains(listener))
			connectionListeners.add(listener);
	}

	@Override
	public void removeConnectionListener(ConnectionListener listener) {
		connectionListeners.remove(listener);
	}

	@Override
	public void addStateChangeListener(StateChangeListener stateChangeListener) {
		if (!stateChangeListeners.contains(stateChangeListener))
			stateChangeListeners.add(stateChangeListener);
	}

	@Override
	public void removeStateChangeListener(StateChangeListener stateChangeListener) {
		stateChangeListeners.remove(stateChangeListener);
	}

	@Override
	public void addHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener) {
		if (!humanTaskRequestListeners.contains(humanTaskRequestListener))
			humanTaskRequestListeners.add(humanTaskRequestListener);
	}

	@Override
	public void removeHumanTaskRequestListener(HumanTaskRequestListener humanTaskRequestListener) {
		humanTaskRequestListeners.remove(humanTaskRequestListener);
	}

	@Override
	public void addProcessEngineListener(ProcessEngineListener listener) {
		if (!processEngineListeners.contains(listener))
			processEngineListeners.add(listener);
	}

	@Override
	public void removeProcessEngineListener(ProcessEngineListener listener) {
		processEngineListeners.remove(listener);
	}

	@Override
	public void addHumanTaskResponseLister(HumanTaskResponseListener listener) {
		if (!humanTaskResponseListeners.contains(listener))
			humanTaskResponseListeners.add(listener);
	}

	@Override
	public void removeHumanTaskResponseListener(HumanTaskResponseListener listener) {
		humanTaskResponseListeners.remove(listener);
	}

	private static String getProcessAsString(Process process, Map<?, ?> options) {
		String text = "";
		XMLResourceImpl resource = new XMLResourceImpl();
		XMLProcessor processor = new XMLProcessor();
		resource.getContents().add(process);

		try {
			text = processor.saveToString(resource, options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	private static Process getProcessFromDocument(String document) {
		XMLResourceImpl res = new XMLResourceImpl();
		try {
			res.load(new InputSource(new StringReader(document)), null);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return (Process) res.getContents().get(1);
	}

	private void informConnectionListeners(boolean connected) {
		for (ConnectionListener connectionListener : connectionListeners) {
			if (connected)
				connectionListener.onConnect();
			else
				connectionListener.onDisconnect();
		}
	}

	private StateChangeListener stateChangeMessageListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage arg) {
			stateChangeListeners.stream().forEach(l -> l.onMessage(arg));
		}
	};

	private HumanTaskRequestListener humanTaskRequestListener = new HumanTaskRequestListener() {
		@Override
		public void onMessage(IHumanTaskRequest arg) {
			humanTaskRequestListeners.stream().forEach(l -> l.onMessage(arg));
		}
	};

	private HumanTaskResponseListener humanTaskResponseListener = new HumanTaskResponseListener() {
		@Override
		public void onMessage(IHumanTaskResponse arg) {
			humanTaskResponseListeners.stream().forEach(l -> l.onMessage(arg));
		}
	};

	private ProcessEngineListener privateEngineListner = new ProcessEngineListener() {
		@Override
		public void onProcessInstanceDeployed(IProcessInstanceInfo processInstanceInfo) {
			processEngineListeners.stream().forEach(l -> l.onProcessInstanceDeployed(processInstanceInfo));
		}

		@Override
		public void onProcessDeployed(IProcessInfo processInfo) {
			processEngineListeners.stream().forEach(l -> l.onProcessDeployed(processInfo));
		}
	};

	@Override
	public boolean isConnected() {
		return isConnected;
	}

	private void printModel(String text) {
		System.out.println("Text: \n" + text);
	}





}
