package eu.vicci.process.distribution.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.distribution.endpoint.Client;
import eu.vicci.process.distribution.endpoint.Server;
import eu.vicci.process.distribution.logging.LogEntry;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.PingRequest;
import eu.vicci.process.model.util.messages.RemoteStepMessageManagerListener;
import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.IMetricsMessage;
import eu.vicci.process.model.util.messages.core.IPingMessage;
import eu.vicci.process.model.util.messages.core.IPingResponse;
import eu.vicci.process.model.util.messages.core.IRemoteStepResponse;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.IWampMessage;
import eu.vicci.process.model.util.messages.core.MessageType;

/**
 * Manages distributed executed process steps.
 * Is responsible for receiving commands from the MAPE-K loop for altering process execution in case of failures. 
 * @author Stefan Herrmann
 *
 */
public class DistributionManagerOLD implements IMessageReceiver {

	private static final Logger logger = LoggerFactory.getLogger(DistributionManagerOLD.class);
	private static DistributionManagerOLD dmm = null;
	private static Server serverEndpoint = null;
	private static Client producer = null;
	//Map: PeerID : Checkpoint
	private Map<String, Checkpoint> checkpoints = Collections.synchronizedMap(new HashMap<String, Checkpoint>());

	private Map<String, IRemoteStepResponse> openResponses = Collections
			.synchronizedMap(new HashMap<String, IRemoteStepResponse>());

	private Map<String, IRemoteStepResponse> closedResponses = Collections
			.synchronizedMap(new HashMap<String, IRemoteStepResponse>());

	private List<RemoteStepMessageManagerListener> listeners = Collections
			.synchronizedList(new ArrayList<RemoteStepMessageManagerListener>());
	//Mapping Instance Id : PEC
	private Map<String, IProcessEngineClient> peers = Collections
			.synchronizedMap(new HashMap<String, IProcessEngineClient>());
	// Mapping Instance ID : Process
	private Map<String, Process> processes = Collections
			.synchronizedMap(new HashMap<String, Process>());
	private List<LogEntry> log = Collections.synchronizedList(new ArrayList<LogEntry>());

	private DistributionManagerOLD() {
		logger.debug("Created Distrubtion Manager Instance");
	}

	public static synchronized DistributionManagerOLD getInstance() {
		if (dmm == null) {
			dmm = new DistributionManagerOLD();
		}
		if (producer == null)
			producer = new Client();
		return dmm;

	}

	public void addRemoteStepMessageManagerListener(RemoteStepMessageManagerListener listener) {
		listeners.add(listener);
	}

	public void removeRemoteStepMessageManagerListener(RemoteStepMessageManagerListener listener) {
		listeners.remove(listener);
	}

	/**
	 * @param remoteStepInstanceId
	 *            the instance id of the stub process
	 */
	private void handleResponse(String remoteStepInstanceId) {
		IRemoteStepResponse openResponse = openResponses.remove(remoteStepInstanceId);
		if (openResponses != null && !closedResponses.containsKey(remoteStepInstanceId)) {
			closedResponses.put(remoteStepInstanceId, openResponse);
			IProcessEngineClient peer = peers.get(remoteStepInstanceId);
			peer.close();

		} else
			logger.error("it seems that the remote process response is already handled. Instance Id: {}",
					remoteStepInstanceId);

		// pec.close();
	}

	public synchronized void remoteStepResponseHandled(IRemoteStepResponse response) {
		String rpInstanceId = response.getProcessInstanceId();
		handleResponse(rpInstanceId);
	}

	public void addRemoteStepResponse(IRemoteStepResponse response) {
		boolean result = addResponseIfNotPresent(response);
		if (result)
			informAboutRemoteStepResponseAdded(response);
	}

	/**
	 * should not inform the listeners at this point - do this after this method
	 * 
	 * @param response
	 * @return true if added
	 */
	private boolean addResponseIfNotPresent(IRemoteStepResponse response) {
		String instanceId = response.getProcessInstanceId();
		if (closedResponses.containsKey(instanceId)) {
			logger.warn("the remote step with id '{}' was already handled", instanceId);
			return false;
		}
		openResponses.put(instanceId, response);
		return true;
	}

	private void informAboutRemoteStepResponseAdded(IRemoteStepResponse response) {
		for (RemoteStepMessageManagerListener listener : listeners) {
			listener.onRemoteStepResponseAdded(response);
		} 
	}

	public String work(String ip, Process ps, Map<String, DataTypeInstance> inputParameters) {
		Integer peerNumber = peers.size() + 1;
		IProcessEngineClient pec = createNewPeerConnection(ip, "aPeer" + peerNumber);
		String remoteInstId = executeRemoteProcess(pec, ps, inputParameters);
		logger.debug("Remote id: " + remoteInstId);
		
		createCheckpoint(ps, inputParameters, remoteInstId);

		processes.put(remoteInstId, ps);
		peers.put(remoteInstId, pec);

		return remoteInstId;
	}

	private void createCheckpoint(Process ps, Map<String, DataTypeInstance> inputParameters, String remoteInstId) {
		Checkpoint newCheckpoint = new Checkpoint(ps);
		newCheckpoint.setProcessInstanceId(remoteInstId);
		newCheckpoint.setProcessData(inputParameters);
		checkpoints.put(remoteInstId, newCheckpoint);
	}

	public String executeRemoteProcess(IProcessEngineClient pec, Process ps,
			Map<String, DataTypeInstance> inputParameters) {
		logger.info("<<<<<<<<<<<<<<<<<<<<<< Starte Remote >>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String pid = pec.deployProcess(ps);
		//pingPeer(pec, pid, ps.getName());
		// get
		logger.info("PID: " + pid);

		logger.info("Deploy SubprocessTest Instance...");
		String remoteProcessInstanceId = pec.deployProcessInstance(pid);
		
		logger.info("Subprocess Instance ID: " + remoteProcessInstanceId);

		logger.info("Start execution...");
		//pingPeer(pec, remoteProcessInstanceId, ps.getName());

		String state = pec.startProcessInstance(remoteProcessInstanceId, inputParameters);
		logger.info("State: " + state); // Warum ist der State hier immer
												// null?
		return remoteProcessInstanceId;
	}

	
	public void onMessage(MessageType messageType, Object arg) {
		// TODO: Multiplexing between connections!
		//System.out.println();
		//System.out.println("received message from type: " + messageType.name());
		String processInstanceId = "";
		String clientInstanceId = "";
		String processStepId = "";
		String processName = "";
		String messagePayload = "";
		String ts = "";
		String clientName = "";
		if (arg instanceof IRemoteStepResponse) {
			IRemoteStepResponse message = (IRemoteStepResponse) arg;
			addRemoteStepResponse(message);
			processInstanceId = message.getProcessInstanceId();
			processStepId = message.getProcessStepId();
			processName = message.getName();
			messagePayload = "executed";
			clientName = message.getClientName();
			clientInstanceId = message.getClientId();
			ts = String.valueOf(message.getTimeStamp());
			logger.debug("Recieved Response: " + message + " Instance: " + message.getProcessInstanceId());
			//TODO: sende zweite nachricht mit status von remoteprocess
		} else if (arg instanceof IStateChangeMessage) {
			IStateChangeMessage message = (IStateChangeMessage) arg;
			processInstanceId = message.getProcessInstanceId();
			processName = message.getProcessName();
			processStepId = message.getInstanceId();
			//clientName = message.getClientName();
			ts = String.valueOf(message.getTimeStamp());
			messagePayload = message.getState().getName();
			logger.debug("[PEER]: " + message.getTimeStamp() + " " + message.getProcessName() + " to state "
					+ message.getState() + " instance: " + message.getProcessInstanceId());
		} else if (arg instanceof IPingResponse) {
			IPingResponse message = (IPingResponse) arg;
			processInstanceId = message.getProcessInstanceId();
			processName = message.getProcessName();
			clientName = message.getClientName();
			clientInstanceId = message.getClientId();
			processStepId = message.getProcessStepId();

			ts = String.valueOf(message.getTimeStamp());
			messagePayload = ts;
			logger.debug("[PEER]: PINGPONG ");
		} else if (arg instanceof IPingMessage) {
			IPingMessage message = (IPingMessage) arg;
			processInstanceId = message.getProcessInstanceId();
			processName = message.getProcessName();
			clientName = message.getClientName();
			clientInstanceId = message.getClientId();
			ts = String.valueOf(message.getTimeStamp());

			logger.debug("[PEER]: Ping Message ");
		} else if (arg instanceof IMetricsMessage) {
			IMetricsMessage message = (IMetricsMessage) arg;
			processInstanceId = message.getProcessInstanceId();
			processName = message.getProcessName();
			clientName = message.getClientName();
			clientInstanceId = message.getClientId();
			processStepId = message.getProcessStepId();
			
			ts = String.valueOf(message.getTimeStamp());
			messagePayload = message.getProvidedState()+ " : "+message.getMetric();

			logger.debug("[PEER]: Metrics Message:  "+message.getMetric());
		}
		if (processInstanceId != "" && peers.containsKey(processInstanceId) && clientName == "") {
//			clientInstanceId = peers.get(processInstanceId).getUuid();
//			clientName = peers.get(processInstanceId).getName();
			System.out.println("DM: Name: "+clientName+" Iid"+clientInstanceId);
		}

		LogEntry newLogEntry = new LogEntry(ts, clientName, processInstanceId, clientInstanceId, processStepId, processName, messagePayload,
				messageType.name());
		//logger.debug("Log: " + newLogEntry);
		log.add(newLogEntry);
		producer.sendMessage(newLogEntry);
		saveLogToJSON();
	}

	private void saveLogToJSON() {

		try {
			final ObjectMapper mapper = new ObjectMapper();
			//logger.debug("Saving Log");
			mapper.writeValue(new File("C:\\\\Temp\\log.json"), log);

			String jsonInString = mapper.writeValueAsString(log);
			//logger.debug("Log:" + jsonInString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private IProcessEngineClient createNewPeerConnection(String ip, String name) {
		AbstractClientBuilder builder = new ProcessEngineClientBuilder();
		IProcessEngineClient pec = builder.withIp(ip).withPort("8081").withName(name).withNamespace("vicciWs")
				.withRealmName("vicciRealm").build();

		pec.connect();
//		pec.subscribeTo(TopicId.STATE_CHANGE, MessageType.WAMPMESSAGE, this);
//		pec.subscribeTo(TopicId.REMOTE_STEP_RESP, MessageType.REMOTESTEPRESPONSE, this);
//		pec.subscribeTo(TopicId.PING_RESPONSE, MessageType.PINGRESPONSE, this);
//		pec.subscribeTo(TopicId.PING_RESPONSE, MessageType.PINGRESPONSE, this);
//		pec.subscribeTo(TopicId.PING, MessageType.PING, this);
//		pec.subscribeTo(TopicId.METRICS, MessageType.METRICS, this);
		return pec;
	}

	public void pingPeer(IProcessEngineClient pec, String processInstanceId, String name) {
		// Lieber die ID vom Peer mitgeben?
		logger.debug("Sending Ping Request");
		PingRequest ping = new PingRequest();
		ping.setProcessInstanceId(processInstanceId);
		ping.setProcessName(name);
		ping.setClientId(pec.getUuid());
		ping.setClientName(pec.getName());
		pec.publishPing(ping);
	}
	
	public String switchPeerCommand(String peerIp, String peerName, String processName){
		// send stop to old peer
		// get CP, new Peer connection
		//
		String remoteStepInstanceId;
		String newInstanceId = null;
		logger.debug("Received Switch Peer Command: Process "+processName+" to "+peerName);
		// Find Instance id to Process Name:
		Optional<String> instanceId = processes.entrySet().stream()
								        .filter(map -> processName.equals(map.getValue().getName()))
								        .map(map -> map.getKey()).findFirst();
		
		if (instanceId.isPresent())
		{
			remoteStepInstanceId = instanceId.get();

			IProcessEngineClient oldPec = peers.get(remoteStepInstanceId);
			//TODO: not working:
			logger.debug("Stopping old process....");
			//oldPec.stopProcessInstance(remoteStepInstanceId);
			logger.debug("Done, close connection");
			oldPec.close();
			
			IProcessEngineClient newPec = createNewPeerConnection(peerIp, peerName);
			Checkpoint cp = checkpoints.get(remoteStepInstanceId);
			
			Process process = cp.getProcess();
			
			newInstanceId = executeRemoteProcess(newPec, process, cp.getProcessData());
			
			cp.setProcessInstanceId(newInstanceId);
			
			peers.remove(remoteStepInstanceId);
			processes.remove(remoteStepInstanceId);
			checkpoints.remove(remoteStepInstanceId);
			
			checkpoints.put(newInstanceId, cp);
			peers.put(newInstanceId, newPec);
			processes.put(newInstanceId, process);
			//
		} else {
			logger.error("Process unknown: "+processName);
			
		}
		
		return newInstanceId;
	}

	@Override
	public void onMessage(IWampMessage arg) {
		// TODO Auto-generated method stub
		
	}
}
