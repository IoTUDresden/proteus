package eu.vicci.process.semantic.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ExampleAskTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/semantic/ExampleAskProcess.diagram";
	private final static String PROCESS_ID = "__ceeMDg4EeWFsZQlVuKLeg";
	
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	@Test(timeout = DEFAULT_TIMEOUT)
	public void exampleAskTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);		
	}	
	
	private void checkPorts(ProcessStepInstance pi){
		for (PortInstance portInstance : pi.getPorts()) {
			if(portInstance.getName().equals("end_0"))
				assertTrue("Endport end_0 should be activated", 
						portInstance.getExecutionState() == State.ACTIVE);
			else if (portInstance.getName().equals("end_1")) {
				assertTrue("Endport end_1 should be deactivated", 
						portInstance.getExecutionState() == State.DEACTIVATED);				
			}			
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
