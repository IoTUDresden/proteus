package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class SimpleOrTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/SimpleOrTest.diagram";
	private final static String PROCESS_ID = "_dv1Y0Mi4EeSKccvjc0DMJA";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	@Test(timeout = DEFAULT_TIMEOUT)
	public void simpleOrTest() throws InterruptedException {
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
			
			if("OrTop".equals(subStep.getProcessStepType().getName()) || 
					"OrMiddle".equals(subStep.getProcessStepType().getName()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.EXECUTED);
			
			if("OrBottom".equals(subStep.getProcessStepType().getName()))
				assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.DEACTIVATED);			
			
			checkPorts(subStep);
			checkSubSteps(subStep);
		}
	}

	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts()) {

			if ("end_exit_top".equals(port.getName()) || "end_exit_middle".equals(port.getName())
					|| "end_or_middle".equals(port.getName()) || "end_or_top".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getPortType().getName(),
								port.getExecutionState()), port.getExecutionState() == State.ACTIVE);
			
			if ("end_exit_bottom".equals(port.getName()) || "end_or_bottom".equals(port.getName()))
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getPortType().getName(),
								port.getExecutionState()), port.getExecutionState() == State.DEACTIVATED);			
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
