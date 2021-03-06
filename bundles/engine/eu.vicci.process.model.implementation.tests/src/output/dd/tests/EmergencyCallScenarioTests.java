package output.dd.tests;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class EmergencyCallScenarioTests extends ProcessExecutionTestsBase {
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	private static final String EM_FILE_PATH = "processes/outputdd/EmergencyCallScenario.diagram";
	private static final String EM_FILE_ID = "_WYJQcCAWEeW9na1xO2iWuA";

	@Test
	public void emergencyCallScenarioTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess(EM_FILE_PATH, EM_FILE_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();
	}
	
	private ProcessStepInstance uploadAndStartProcess(String path, String processId) throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(path);
		PROCESS_MANAGER.deployProcess(processId);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(processId);

		Thread.sleep(WAIT_DEPLOY_TIME);

		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, null);
		return instance;
	}

}
