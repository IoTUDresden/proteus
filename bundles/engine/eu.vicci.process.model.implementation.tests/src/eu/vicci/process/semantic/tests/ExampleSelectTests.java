package eu.vicci.process.semantic.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class ExampleSelectTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/semantic/ExampleSelectProcess.diagram";
	private final static String PROCESS_ID = "_zEHdADfNEeW60v5_jYYNlw";
	
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

//	@Test(timeout = DEFAULT_TIMEOUT)
	@Test
	public void exampleSelectTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);		
	}	
	
	private void checkPorts(ProcessStepInstance pi){
		PortInstance portInstance = pi.getPorts().stream()
				.filter(p -> "end_0".equals(p.getName()))
				.findFirst()
				.get();
		EndDataPortInstance port = (EndDataPortInstance)portInstance;
		ListTypeInstance list = (ListTypeInstance)port.getDataInstance();		
		assertTrue("Nothing is returned", list.getSubtypes().size() > 0);
		
		System.out.println("Select Results:");
		for (DataTypeInstance data : list.getSubtypes()) {
			Object out = data.getValueAsObject();
			System.out.println("Result: " + out);
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
