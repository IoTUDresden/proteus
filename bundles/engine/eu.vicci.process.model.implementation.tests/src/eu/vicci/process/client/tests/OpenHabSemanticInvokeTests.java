package eu.vicci.process.client.tests;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

//TODO tests doesnt run anymore because of the refactoring
public class OpenHabSemanticInvokeTests extends ProcessExecutionTestsBase {
	private static final int TEST_TIMEOUT = 10000;
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();
	private static final String SELECT_DIAGRAMM_PATH = "processes/OpenHabInvokeSelect.diagram";
	private static final String SELECT_DIAGRAMM_ID = "_rYC6YBP4EeWb76jtUfG7PQ";
	private static final String ASK_DIAGRAMM_PATH = "processes/OpenHabInvokeAsk.diagram";
	private static final String ASK_DIAGRAMM_ID = "_BB1-YBdcEeWFxqgkeNtIPg";
	private static final String COMMAND_DIAGRAMM_PATH = "processes/OpenHabInvokeCommand.diagram";
	private static final String COMMAND_DIAGRAMM_ID = "_-olVEBdoEeWxpIbj1YvqNA";

	/**
	 * Tests the Process step by invoking a select on the semantic layer.
	 * The select gets all subjects and their functionalities, which can be switched on.
	 * @throws Exception 
	 */
	@Test(timeout = TEST_TIMEOUT)
	public void invokeSelectTest() throws Exception {
		ProcessStepInstance pi = uploadAndStartProcess(SELECT_DIAGRAMM_PATH, SELECT_DIAGRAMM_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		checkSelectAndAskEndports(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();
	}
	
	/**
	 * Executes an Ask query on the semantic layer.
	 * The result should be true, and so the true transitions activated and the false transitions deactivated
	 * @throws Exception
	 */
	@Test(timeout = TEST_TIMEOUT)
	public void invokeAskTest() throws Exception {
		ProcessStepInstance pi = uploadAndStartProcess(ASK_DIAGRAMM_PATH, ASK_DIAGRAMM_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		checkAskEndports(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();				
	}
	
	/**
	 * Sends a command to all functions, which can be switched on.
	 * @throws Exception
	 */
	@Test(timeout = TEST_TIMEOUT)
	public void invokeCommandTest() throws Exception {
		ProcessStepInstance pi = uploadAndStartProcess(COMMAND_DIAGRAMM_PATH, COMMAND_DIAGRAMM_ID);
		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);
		checkSelectAndAskEndports(pi);
		LifeCycleManager.INSTANCE.stopActorSystem();		
	}
	
	private void checkAskEndports(ProcessStepInstance pi){
		for (PortInstance portInstance : pi.getPorts()) {
			if(!(portInstance instanceof EndControlPortInstance))
				continue;
			
			EndControlPortInstance port = (EndControlPortInstance)portInstance;
			if("end_exit_0".equals(port.getName()))
				assertTrue(String.format("The port '%s' should be in an active state", port.getName()), 
					port.getExecutionState() == State.ACTIVE);
			else if ("end_exit_1".equals(port.getName()))
				assertTrue(String.format("The port '%s' should be in an deactivated state", port.getName()), 
						port.getExecutionState() == State.DEACTIVATED);
		}
	}
	
	//this only checks if something returned
	private void checkSelectAndAskEndports(ProcessStepInstance pi) {
		for (PortInstance portInstance : pi.getPorts()) {
			if(!(portInstance instanceof EndDataPortInstance))
				continue;
			
			EndDataPortInstance port = (EndDataPortInstance)portInstance;
			ListTypeInstance list = (ListTypeInstance)port.getDataInstance();
			
			assertTrue("Nothing is returned", list.getSubtypes().size() > 0);
			System.out.println();
			System.out.println(String.format("Data in endport '%s':", port.getName()));
			
			for (DataTypeInstance data : list.getSubtypes()){
				Object out = data.getValueAsObject();
				assertTrue("Nothing is returned", out != null && !((String)out).isEmpty());
				System.out.print(String.format("	Data:%s\n", out));
			}
		}
		System.out.println();
	}

	@After
	public void resetAfterTest(){
		LifeCycleManager.INSTANCE.reset();
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
