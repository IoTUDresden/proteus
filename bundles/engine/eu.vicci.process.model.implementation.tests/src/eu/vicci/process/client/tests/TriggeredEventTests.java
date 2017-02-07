package eu.vicci.process.client.tests;

import static org.junit.Assert.fail;

import org.junit.Test;

import eu.vicci.process.devices.util.OpenHabListener;
import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

//TODO use the jersey test framework, so no openhab instance is needed
//https://jersey.java.net/documentation/latest/test-framework.html
public class TriggeredEventTests extends ProcessExecutionTestsBase {
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	private static final String SIMPLE_DIAGRAMM_PATH = "processes/events/EsperTestProcess.diagram";
	private static final String SIMPLE_DIAGRAMM_ID = "_9yYYUEsaEeWiovmKAU6XPg";

	private static final String PLACEHOLDER_DIAGRAMM_PATH = "";
	private static final String PLACEHOLDER_DIAGRAMM_ID = "";

	/**
	 * Triggered Events Test, which listen to all SensorEvents. If you switch something
	 * ON, the process should go in the executed state.
	 * 
	 * @throws Exception
	 */
	@Test
	public void simpleTriggeredEventTest() throws Exception {		
		OpenHabListener.getInstance().start();	
		ProcessStepInstance pi = uploadAndStartProcess(SIMPLE_DIAGRAMM_PATH, SIMPLE_DIAGRAMM_ID);

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		OpenHabListener.getInstance().close();
		LifeCycleManager.INSTANCE.stopActorSystem();
	}

	/**
	 * Triggered Events Test, which listen to all SensorEvents for the item
	 * "Health_Button" If you switch these switch ON, the process should go in the
	 * executed state.
	 * 
	 * @throws Exception
	 */
	@Test
	public void triggeredEventWithPlaceHolderTest() throws Exception {
		//TODO make a process step
		fail("not implemented");
		OpenHabListener.getInstance().start();	
		ProcessStepInstance pi = uploadAndStartProcess(PLACEHOLDER_DIAGRAMM_PATH, PLACEHOLDER_DIAGRAMM_ID);

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		OpenHabListener.getInstance().close();
		LifeCycleManager.INSTANCE.stopActorSystem();
	}

	private ProcessStepInstance uploadAndStartProcess(String path, String processId)
			throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(path);
		PROCESS_MANAGER.deployProcess(processId);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(processId);

		Thread.sleep(WAIT_DEPLOY_TIME);

		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, null);
		return instance;
	}

//	private static void addEventTypeToEsper(EventType eventType, Class<?> datatype) {
//		Map<String, Object> props = new LinkedHashMap<String, Object>();
//		props.put("id", String.class);
//		props.put("location", String.class);
//		props.put("type", String.class);
//		props.put("sensing", String.class);
//		props.put("value", datatype);
//		EsperManager.getInstance().addEventType(eventType.getTypeName(), props);
//	}

	// not used at the moment but maybe needed as an example
	// private static final String EPL_STMT =
	// "select * from SensingTodo where value = 'ON'";
}
