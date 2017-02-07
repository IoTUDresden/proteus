package output.dd.tests;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class VentScenarioTest extends ProcessExecutionTestsBase {
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	private static final String VENT_FILE_PATH = "processes/outputdd/VentScenario.diagram";
	private static final String VENT_FILE_ID = "_GCUXsB_5EeWrJeSdTf3jzQ";

	@Test
	public void ventScenarionTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess(VENT_FILE_PATH, VENT_FILE_ID);
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
