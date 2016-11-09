package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ProcessInProcessTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/ProcessInProcessTest.diagram";
	private final static String PROCESS_ID = "_J2evQE1_EeW9IJJXOVTrxw";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	private final static String expectedOut = "HelloWorld";

	@Test(timeout = DEFAULT_TIMEOUT)
	public void processInProcessTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		checkPorts(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();
	}

	private void checkPorts(ProcessStepInstance pi) {

		EndDataPortInstance endDatadPort = (EndDataPortInstance) pi.getPorts().stream()
				.filter(p -> p.getName().equals("end_1")).findFirst().get();

		EndControlPortInstance endControlPort = (EndControlPortInstance) pi.getPorts().stream()
				.filter(p -> p.getName().equals("end_0")).findFirst().get();

		Object out = endDatadPort.getDataInstance().getValueAsObject();
		assertEquals(String.format(PORT_WRONG_VALUE, endDatadPort.getName(), out.toString(), expectedOut),
				expectedOut, out.toString());
		assertEquals(String.format(PORT_WRONG_STATE, endControlPort.getName(), State.ACTIVE),
				endControlPort.getExecutionState(), State.ACTIVE);
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
