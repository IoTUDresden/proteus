package eu.vicci.process.semantic.demo;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class DingDongSemanticTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/semanticDemo/DingDongSemantic.diagram";
	private final static String PROCESS_ID = "_sRpZUGahEeWJtZBNMKgZGA";
	
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	@Test
	public void dingDongSemanticTest() throws Exception {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();	
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
