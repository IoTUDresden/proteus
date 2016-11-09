package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class SimpleAndTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/SimpleAndTest.diagram";
	private final static String PROCESS_ID = "_0l3mMN3REeSTcqQCXLsKHA";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	@Test(timeout = DEFAULT_TIMEOUT)
	public void simpleAndTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED) {
			Thread.sleep(SLEPPING_TIME);
		}

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);
		checkSubSteps(pi);
	}

	private void checkSubSteps(ProcessStepInstance pi) {
		for (ProcessStepInstance subStep : pi.getSubSteps()) {
			
			if("AndBottom".equals(subStep.getProcessStepType().getName()) || 
					"AndMiddle".equals(subStep.getProcessStepType().getName()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.DEACTIVATED);
			
			if("AndTop".equals(subStep.getProcessStepType().getName()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.EXECUTED);			
			
			checkPorts(subStep);
			checkSubSteps(subStep);
		}
	}

	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts()) {

			if ("end_exit_bottom".equals(port.getName()) || "end_exit_middle".equals(port.getName())
					|| "end_or_middle".equals(port.getName()) || "end_or_bottom".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getPortType().getName(),
								port.getExecutionState()), port.getExecutionState() == State.DEACTIVATED);
			
			if ("end_exit_top".equals(port.getName()) || "end_or_top".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getPortType().getName(),
								port.getExecutionState()), port.getExecutionState() == State.ACTIVE);			
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
