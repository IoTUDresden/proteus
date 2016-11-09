package eu.vicci.process.model.implementations.tests;

import org.junit.Ignore;
import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;

public class HumanTaskInstanceTests extends ProcessExecutionTestsBase{
	private final static String PROCESS_PATH = "processes/humanTask/simpleHumanTask.diagram";
	private final static String PROCESS_ID = "_pQi34OK4EeWEcdI3io8i0w";

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	
	@Ignore
	@Test(timeout = DEFAULT_TIMEOUT)
	public void humanTaskInstanceTest() throws InterruptedException{
		ProcessStepInstance pi = uploadAndStartProcess();
		PROCESS_MANAGER.addHumanTaskRequestListener(requestListener);

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
	
	private HumanTaskRequestListener requestListener = new HumanTaskRequestListener() {		
		@Override
		public void onMessage(IHumanTaskRequest humanTaskRequest) {
			println("Received HumanTaskRequest");	
//			TODO check the values from the request
//			TODO handle the request so that the process can finish
//			TODO check the values on the end ports of the main process after execution
		}
	};
	
	private void println(String txt){
		System.out.println(txt);
	}

}
