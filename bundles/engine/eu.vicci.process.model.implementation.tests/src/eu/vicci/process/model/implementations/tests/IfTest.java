package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class IfTest extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/ifTest.diagram";
	private final static String PROCESS_ID = "_l80fkMuxEeSKccvjc0DMJA";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	/**
	 * Tests the correct execution of an if-step.
	 * False Transitions (and all the following steps) should be in a deactivated state.
	 * @throws InterruptedException
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void ifTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkSubsteps(pi);
		checkPorts(pi);
	}

	private void checkSubsteps(ProcessStepInstance pi) {
		for (ProcessStepInstance subStep : pi.getSubSteps()) {
			// true process
			if ("_o9fbQMuxEeSKccvjc0DMJA".equals(subStep.getProcessStepType().getId()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType()
						.getName(), subStep.getExecutionState()),
						subStep.getExecutionState() == State.EXECUTED);
			// false process
			if ("_pO5UUMuxEeSKccvjc0DMJA".equals(subStep.getProcessStepType().getId()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType()
						.getName(), subStep.getExecutionState()),
						subStep.getExecutionState() == State.DEACTIVATED);
		}
	}

	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts()) {
			if ("end_exit_true".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
						port.getExecutionState() == State.ACTIVE);
			if ("end_exit_false".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
						port.getExecutionState() == State.DEACTIVATED);
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
