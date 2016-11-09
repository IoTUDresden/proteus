package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ParallelLoopTests extends ProcessExecutionTestsBase {
	private final static int EXPECTED_LOOP_COUNT = 4; // counter value is one step highter but never used

	private final static String PROCESS_PATH = "processes/ParallelLoop.diagram";
	private final static String PROCESS_ID = "_24G9AKIlEeStLIjh5Q8KSA";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	/**
	 * Simply tests the parallel execution of two forLoops. The correct parallel execution can only
	 * checked by the console output (true working, false working -> in no order).
	 * The Test checks only the correct states of the processes, the ports, and the port values.
	 * @throws InterruptedException
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void parallelLoopTest() throws InterruptedException {
		
		
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);
		checkSubSteps(pi);
	}

	private void checkSubSteps(ProcessStepInstance pi) {
		for (ProcessStepInstance subStep : pi.getSubSteps()) {
			assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.EXECUTED);
			checkPorts(subStep);
			checkSubSteps(subStep);
		}
	}

	//All ports active?
	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts()) {
			assertTrue(
					String.format(PORT_WRONG_STATE, port.getPortType().getName(),
							port.getExecutionState()), port.getExecutionState() == State.ACTIVE);
			checkPortValue(port);
		}
	}

	//loop counter correct?
	private void checkPortValue(PortInstance port) {
		if ("start_data_load_class_left_upper".equals(port.getName())
				|| "start_data_load_class_left_lower".equals(port.getName())) {
			DataPortInstance dataPort = (DataPortInstance) port;			
			assertTrue(String.format(PORT_WRONG_VALUE, dataPort.getName(), dataPort
					.getDataInstance().getValueAsObject(), EXPECTED_LOOP_COUNT), dataPort.getDataInstance()
					.getValueAsObject().equals(EXPECTED_LOOP_COUNT));
		}
	}

	private ProcessStepInstance uploadAndStartProcess() throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(PROCESS_PATH);
		PROCESS_MANAGER.deployProcess(PROCESS_ID);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(PROCESS_ID);

		Thread.sleep(WAIT_DEPLOY_TIME);

		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, null);
		return instance;
	}

}
