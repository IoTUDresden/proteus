package eu.vicci.process.client.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class OpenHabWaitForEventStepTests extends ProcessExecutionTestsBase{
	//events should occur in this range. else the timeout make this test fail
	private static final int TEST_TIMEOUT = 15000;
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	
	private static final String LINEAR_POTI_DIAGRAMM_PATH = "processes/OpenHabWaitForEventTest.diagram";
	private static final String LINEAR_POTI_DIAGRAMM_ID = "_9TXpkB2SEeWDEodcfEnB6A";
	
	private static final String AMB_TEMP_DIAGRAMM_PATH = "processes/OpenHabWaitForTemperature.diagram";
	private static final String AMB_TEMP_DIAGRAMM_ID = "_Wq81gB2WEeWMbKRJSpR3lg";

	/**
	 * This tests receives update events from openhab. The tests registers to the 'LinearPoti'-Item
	 * @throws InterruptedException
	 */
	@Test(timeout = TEST_TIMEOUT)
	public void loadClassStepForWaitingTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess(LINEAR_POTI_DIAGRAMM_PATH, LINEAR_POTI_DIAGRAMM_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		checkEndportsLinearPoti(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();
	}
	
	/**
	 * Receives update for temperature change for item 'AmbTemp'
	 * @throws InterruptedException
	 */
	@Test(timeout = TEST_TIMEOUT)
	public void ambienteTemptEventTest() throws InterruptedException{
		ProcessStepInstance pi = uploadAndStartProcess(AMB_TEMP_DIAGRAMM_PATH, AMB_TEMP_DIAGRAMM_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		checkEndportsAmbTemp(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();
	}
	
	private void checkEndportsAmbTemp(ProcessStepInstance pi){
		EndDataPortInstance port = (EndDataPortInstance)pi.getPorts().stream()
				.filter(p -> p instanceof EndDataPortInstance)
				.filter(p -> p.getName().equals("end_0"))
				.findFirst()
				.get();
		Object obj= port.getDataInstance().getValueAsObject();
		Double value = (Double)obj;
		
		assertTrue("the value should have changed", value > 0);
		System.out.println(String.format("\n\nvalue received by openhab: '%.1f'\n\n", value));		
	}	
	
	private void checkEndportsLinearPoti(ProcessStepInstance pi) {
		EndDataPortInstance port = (EndDataPortInstance)pi.getPorts().stream()
				.filter(p -> p instanceof EndDataPortInstance)
				.filter(p -> p.getName().equals("end_0"))
				.findFirst()
				.get();
		String value = (String)port.getDataInstance().getValueAsObject();
		assertFalse("the value should have changed", "alt".equals(value));
		System.out.println(String.format("\n\nvalue received by openhab: '%s'\n\n", value));
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
