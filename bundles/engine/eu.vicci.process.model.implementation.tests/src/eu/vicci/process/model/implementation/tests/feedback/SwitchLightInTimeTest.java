package eu.vicci.process.model.implementation.tests.feedback;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;

public class SwitchLightInTimeTest extends ProcessExecutionTestsBase {
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	
	private final static String PROCESS_PATH = "processes/feedback/FeedbackTimeLightOn.diagram";
	private final static String PROCESS_ID = "_JlWiQNDBEeWPNaYth6tMYA";

	@Test(timeout = DEFAULT_TIMEOUT)
	public void switchLightInTimeTest() throws Exception {
		ProcessStepInstance pi = uploadAndStartProcess(PROCESS_PATH, PROCESS_ID);	
		
		while (pi.getExecutionState() != State.EXECUTED) {
			Thread.sleep(SLEPPING_TIME);
		}
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
