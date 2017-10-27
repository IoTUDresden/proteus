package eu.vicci.process.model.sofiainstance.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.distribution.core.DistributedSession;
import eu.vicci.process.distribution.core.DistributionManagerListener;
import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.core.RemoteProcess;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.DistributingProcessInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.states.StateBase;
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

	private volatile IStateChangeMessage finalMessage;

	public RemoteStepInvokeWorker(DistributingProcessInstanceImplCustom processInstance,
			IDistributionManager distributionManager) {
		this.processInstance = processInstance;
		this.distributionManager = distributionManager;
		checkArgs();
	}

	/**
	 * Gets the Data End Ports with the data and the state.
	 * 
	 * @return
	 */
	public Map<String, IJSONDataPortInstance> getEndDataPorts() {
		return finalMessage.getEndDataPorts();
	}
	
	/**
	 * Check if the final Message was received. 
	 * If the process was maybe compensation and compensation was failing.
	 * @return
	 */
	public boolean receivedFinalMessage(){
		return finalMessage != null;
	}

	/**
	 * Gets the Control End Ports with state.
	 * 
	 * @return
	 */
	public Map<String, IJSONPortInstance> getEndControlPorts() {
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
	 * Delegates the work to the defined peer and waits (blocks) till the work
	 * is done. After work was done, you can get the results via
	 * {@link #getEndControlPorts()} and {@link #getEndDataPorts()}.
	 */
	public void work() {
		LOGGER.debug("---->>>> Executing distributed Process Step");

		responseReceived = new CountDownLatch(1);

		Process process = (Process) processInstance.getProcessStepType();

		String ip = process.getExecutionPeer();
		if (ip == null || ip.isEmpty())
			throw new RuntimeException("no remote peer defined in process");

		StateBase oldState = processInstance.getCurrentState();
//		processInstance.setCurrentState(new WaitingState(processInstance));

		RemoteProcess remoteProcess = distributionManager.createRemoteProcess(process);
		Map<String, DataTypeInstance> inputParameters = getInputParameters();

		distributionManager.addDistributionManagerListener(listener);
		remoteSession = distributionManager.workRemote(ip, processInstance.getInstanceId(), remoteProcess, inputParameters);

		try {
			// blocks till response was received
			responseReceived.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		LOGGER.debug("---- Remote Execution Returned");

		distributionManager.removeDistributionManagerListener(listener);
//		processInstance.setCurrentState(oldState);

//		 createDataTypeInstancesFromResponse();
	}
	
	public void forceFinish(){
		responseReceived.countDown();
	}

	private Map<String, DataTypeInstance> getInputParameters() {
		if(!processInstance.getPorts().stream().anyMatch(p -> p instanceof StartDataPortInstance))
			return null;
		Map<String, DataTypeInstance> result = new HashMap<>();
		
		processInstance.getPorts().stream()
		.filter(p -> p instanceof StartDataPortInstance)
		.map(StartDataPortInstance.class::cast)
		.map(StartDataPortInstance::getDataInstance)
		.forEach(dti -> result.put(dti.getDataTypeType().getId(), dti));		
		
		return result;
	}

	private DistributionManagerListener listener = new DistributionManagerListener() {
		@Override
		public void processOnPeerHasFinished(IStateChangeMessage message, DistributedSession session) {
			if (!remoteSession.equals(session))
				return;			
			State messageState = message.getState();
			
			//if final message is null, process will go to failed state
			if(messageState != State.FAILED && messageState != State.DEACTIVATED)
				finalMessage = message;
			
			responseReceived.countDown();
		}
		
		@Override
		public void remoteSessionChanged(DistributedSession oldSession, DistributedSession newSession) {
			if(!remoteSession.equals(oldSession))
				return;
			remoteSession = newSession;
		}
	};

}
