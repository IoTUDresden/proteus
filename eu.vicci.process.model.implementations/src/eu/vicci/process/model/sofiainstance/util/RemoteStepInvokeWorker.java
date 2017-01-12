package eu.vicci.process.model.sofiainstance.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.distribution.core.DistributedSession;
import eu.vicci.process.distribution.core.DistributionManagerListener;
import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.DistributingProcessInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.states.StateBase;
import eu.vicci.process.model.sofiainstance.states.WaitingState;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public class RemoteStepInvokeWorker {
	private static final Logger LOGGER = LoggerFactory.getLogger(RemoteStepInvokeWorker.class);

	public List<DataTypeInstance> returnedData = new LinkedList<DataTypeInstance>();

	private CountDownLatch responseReceived;
	
	private DistributedSession remoteSession;

	private DistributingProcessInstanceImplCustom processInstance;
	private IDistributionManager distributionManager = DistributionManager.getInstance();	
	
	private IStateChangeMessage finalMessage;
	
	public RemoteStepInvokeWorker(DistributingProcessInstanceImplCustom processInstance, IDistributionManager distributionManager){
		this.processInstance = processInstance;
		this.distributionManager = distributionManager;
		checkArgs();
	}
	
	/**
	 * Gets the Data End Ports with the data and the state.
	 * @return
	 */
	public Map<String, IJSONDataPortInstance> getEndDataPorts(){
		return finalMessage.getEndDataPorts();
	}
	
	/**
	 * Gets the Control End Ports with state.
	 * @return
	 */
	public Map<String, IJSONPortInstance> getEndControlPorts(){
		return finalMessage.getEndControlPorts();
	}

	private void checkArgs() {
		if (processInstance == null)
			throw new IllegalArgumentException("worker does not contain a process instance to execute remote");
	
		if (distributionManager == null)
			throw new IllegalArgumentException("no DistributionManager available. "
					+ "Cant remote execute process. At the moment no option implemented to execute the process local in this case");
	}

	/**
	 * Delegates the work to the defined peer and waits (blocks) till the work is done.
	 * After work was done, you can get the results via {@link #getEndControlPorts()} and {@link #getEndDataPorts()}.
	 */
	public void work() {
		LOGGER.debug("---->>>> Executing distributed Process Step");

		responseReceived = new CountDownLatch(1);

		Process process = (Process) processInstance.getProcessStepType();

		String ip = process.getExecutionPeer();
		if (ip == null || ip.isEmpty())
			throw new RuntimeException("no remote peer defined in process");

		StateBase oldState = processInstance.getCurrentState();
		processInstance.setCurrentState(new WaitingState(processInstance));

		Process remoteProcess = createRemoteProcess(process);
		clearOutTransitions(remoteProcess);

		distributionManager.addDistributionManagerListener(listener);
		remoteSession = distributionManager.workRemote(ip, remoteProcess, null);

		try {
			// blocks till response was received
			responseReceived.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LOGGER.debug("---- Remote Execution Returned");

		distributionManager.removeDistributionManagerListener(listener);
		processInstance.setCurrentState(oldState);
		
		//createDataTypeInstancesFromResponse();
	}
	
	private DistributionManagerListener listener = new DistributionManagerListener() {		
		@Override
		public void processOnPeerHasFinished(IStateChangeMessage message, DistributedSession session) {
			if(remoteSession.equals(session))
				return;
			finalMessage = message;
			responseReceived.countDown();		
		}
	};

	//TODO copy the dataype definitions or the process wont run with datatypes defined in the ports
	private Process createRemoteProcess(Process original) {
		Process remoteProcess = (Process) EcoreUtil.copy(original);
		remoteProcess.setDistributed(false);
		remoteProcess.setRemoteExecuting(true);
		remoteProcess.setCyberPhysical(false);
		remoteProcess.setGoal("");
		return remoteProcess;
	}

	private void clearOutTransitions(Process remoteProcess) {
		remoteProcess.getPorts().stream().filter(p -> p instanceof EndPort).forEach(p -> p.getOutTransitions().clear());
	}

//	private Process createDataTypeInstances(ProcessStepInstanceImplCustom psi, ProcessStep pm, Process copyProcess) {
//		List<DataType> datatypeDefinitions = null;
//		if (pm.getParentstep() instanceof Process) {
//			Process parentProcess = (Process) pm.getParentstep();
//			EList<DataType> origDTD = parentProcess.getDataTypeDefinitions();
//			datatypeDefinitions = (List<DataType>) EcoreUtil.copyAll(origDTD);
//			copyProcess.getDataTypeDefinitions().addAll(datatypeDefinitions);
//
//			// datatypeDefinitions.clear();
//			// TODO: iterate over ports
//		}
//		// if (datatypeDefinitions != null)
//		// for (DataType dataType : datatypeDefinitions) {
//		// DataType copyDataType = EcoreUtil.copy(dataType);
//		// //copyDataType.getPortMembers().addAll(dataType.getPortMembers());
//		// test.getDataTypeDefinitions().add(copyDataType);
//		// }
//
//		for (Port port : pm.getPorts()) {
//			System.out.println("Port: " + port);
//
//			if (port instanceof DataPort) {
//				DataPort dataPort = (DataPort) port;
//				DataType dt = dataPort.getPortDatatype();
//				if (datatypeDefinitions != null) {
//					if (datatypeDefinitions.contains(dt)) {
//						Integer index = datatypeDefinitions.indexOf(dt);
//						DataType oldDt = EcoreUtil.copy(datatypeDefinitions.get(index));
//						oldDt.getPortMembers().add(dataPort);
//					} else {
//						DataType dtCopy = EcoreUtil.copy(dataPort.getPortDatatype());
//
//						dtCopy.getPortMembers().add(dataPort);
//						datatypeDefinitions.add(dtCopy);
//					}
//				}
//			}
//		}
//		return copyProcess;
//	}

//	private void createDataTypeInstancesFromResponse() {
//		receivedResponse.getEndDataPorts().values().stream().forEach(port -> {
//			DataTypeInstance dti = port.getDataTypeInstance()
//					.makeDataTypeInstance(SofiaInstanceFactoryImplCustom.getInstance());
//			returnedData.add(dti);
//		});
//	}

	// public Map<String, DataTypeInstance> getReturnedPortInstances() {
	// if (receivedResponse == null)
	// return null;
	// return receivedResponse.getEndDataPorts();
	// }

//	private HashMap<String, DataTypeInstance> createRemoteProcessStartData(ProcessStepInstanceImplCustom psi) {
//		List<DataTypeInstance> data = psi.getStartParameter();
//
//		HashMap<String, DataTypeInstance> remoteDataTypeObjects = new HashMap<String, DataTypeInstance>();
//
//		for (PortInstance port : psi.getPorts()) {
//			System.out.println("Port: " + port.getName() + " Id: " + port.getTypeId());
//
//			if (port instanceof StartDataPortInstance) {
//
//				StartDataPortInstance sdpInst = (StartDataPortInstance) port;
//				DataType dt = ((DataPort) port.getPortType()).getPortDatatype();
//				String dtId = dt.getId();
//				remoteDataTypeObjects.put(dtId, sdpInst.getDataInstance());
//
//			}
//
//		}
//		return remoteDataTypeObjects;
//	}

//	@Override
//	public void onRemoteStepResponseAdded(IRemoteStepResponse response) {
//		if (!remoteProcessInstanceId.equals(response.getProcessInstanceId())) {
//			System.err.println("Fehler: Falsche ProcessInstance ID");
//			// TODO: update der PIID wenn Peer sich geändert hat
//			receivedResponse = response;
//			responseReceived.countDown();
//			return;
//		} else {
//			receivedResponse = response;
//			responseReceived.countDown();
//		}
//		// TODO: Remove Listener
//		// HumanTaskMessageManager.getInstance().removeHumanTaskMessageManagerListener(this);
//	}

}
