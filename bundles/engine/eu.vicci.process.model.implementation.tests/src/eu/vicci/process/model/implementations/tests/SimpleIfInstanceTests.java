package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

/**
 * Simple tests for the execution of processes which includes if instances
 */
public class SimpleIfInstanceTests extends ProcessExecutionTestsBase{
	// if(left >= right) model
	private final static String PROCESS_PATH_GOE = "processes/simpleIfTest.diagram";
	private final static String PROCESS_ID_GOE = "_iILBYGjZEeShcLw9BC8iqA";

	private final static String LEFT_PORT_NAME = "start_left";
	private final static String RIGHT_PORT_NAME = "start_right";

	private final static int LEFT_INPUT = 20;
	private final static int RIGHT_INPUT = 20;

	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	/**
	 * Checks the execution of a if instance with the condition 20>=20. This
	 * test will fail, if the process can´t get into the state 'executed'
	 * because of the timeout. If the Test failed, because of time out, check if
	 * the process can reach the state 'executed'. Checks also the execution of
	 * the LoadClassStep implementation.
	 * 
	 * @throws InterruptedException
	 *             Thread is sleeping while waiting for the process to get into
	 *             the state 'executed'.
	 */
	@Test(timeout = DEFAULT_TIMEOUT)
	public void simpleIfInstanceExecuteTest() throws InterruptedException {
		ProcessInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME); // waiting for the execution to
											// complete
		LifeCycleManager.INSTANCE.stopActorSystem();
		checkSubSteps(pi);
	}

	private void checkSubSteps(ProcessStepInstance instance) {
		for (ProcessStepInstance step : instance.getSubSteps()) {
			assertTrue(
					String.format(PROCESS_WRONG_STATE, step.getProcessStepType().getName(),
							step.getExecutionState()), checkProcessStepState(step));
			for (PortInstance port : step.getPorts())
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
						checkProcessStepPort(port));
			checkSubSteps(step);
		}
	}

	private boolean checkProcessStepPort(PortInstance port) {
		if (port.getName().equals("start_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_if_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_if_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_if_control"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_if_control_2"))
			return port.getExecutionState() == State.DEACTIVATED;
		if (port.getName().equals("start_true_process"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_load_class_true"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_false_process"))
			return port.getExecutionState() == State.DEACTIVATED;
		if (port.getName().equals("start_load_class_false"))
			return port.getExecutionState() == State.DEACTIVATED;
		if (port.getName().equals("end_true_control"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_false_control"))
			return port.getExecutionState() == State.DEACTIVATED;
		if (port.getName().equals("end_false_control_exit"))
			return port.getExecutionState() == State.DEACTIVATED;
		if (port.getName().equals("end_true_control_exit"))
			return port.getExecutionState() == State.ACTIVE;
		return false;
	}

	private boolean checkProcessStepState(ProcessStepInstance process) {
		if (process.getProcessStepType().getName().equals("If"))
			return process.getExecutionState() == State.EXECUTED;
		if (process.getProcessStepType().getName().equals("TrueProcess"))
			return process.getExecutionState() == State.EXECUTED;
		if (process.getProcessStepType().getName().equals("FalseProcess"))
			return process.getExecutionState() == State.DEACTIVATED;
		if (process.getProcessStepType().getName().equals("LoadClassStepFalse"))
			return process.getExecutionState() == State.DEACTIVATED;
		if (process.getProcessStepType().getName().equals("LoadClassStepTrue"))
			return process.getExecutionState() == State.EXECUTED;
		return false;
	}

	private ProcessInstance uploadAndStartProcess() throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(PROCESS_PATH_GOE);
		PROCESS_MANAGER.deployProcess(PROCESS_ID_GOE);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(PROCESS_ID_GOE);
		Map<String, DataTypeInstance> inputParameters = createInputParameters(PROCESS_ID_GOE,
				LEFT_INPUT, RIGHT_INPUT);

		Thread.sleep(SLEPPING_TIME); // this is bad, but the process may not be
										// fully deployed

		ProcessInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, inputParameters);
		return instance;
	}

	private static Map<String, DataTypeInstance> createInputParameters(String processId,
			int leftValue, int rightValue) {
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		Process p = PROCESS_MANAGER.getProcessInfos(processId);

		StartDataPort sdp = null;
		DataType dt = null;
		String dtId = null;

		for (Port port : p.getPorts())
			if (port instanceof StartDataPort)
				setValueAndPutToMap(sdp, dt, dtId, inputData, leftValue, rightValue, port);
		return inputData;
	}

	private static void setValueAndPutToMap(StartDataPort sdp, DataType dt, String dtId,
			Map<String, DataTypeInstance> inputData, int leftValue, int rightValue, Port port) {
		sdp = (StartDataPort) port;
		dt = sdp.getPortDatatype();
		dtId = dt.getId();

		if (!(dt instanceof IntegerType))
			return;
		IntegerType it = (IntegerType) dt;
		IntegerTypeInstance iti = SofiaInstanceFactoryImplCustom.getInstance()
				.createIntegerTypeInstance();
		iti.setTypeId(it.getId());
		iti.setName(it.getName());
		iti.setInstanceId(it.getId() + "instance");
		iti.setInstancenumber(1);
		iti.setDataTypeType(it);
		if (sdp.getName().equals(LEFT_PORT_NAME))
			iti.setValue(leftValue);
		if (sdp.getName().equals(RIGHT_PORT_NAME))
			iti.setValue(rightValue);
		inputData.put(dtId, iti);

	}
}
