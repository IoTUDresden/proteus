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
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class SimpleForLoopInstanceTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/ForLoopTest.diagram";
	private final static String PROCESS_ID = "_FLrGEKIiEeStLIjh5Q8KSA";

	private final static String LEFT_PORT_NAME = "start_data_left";
	private final static String RIGHT_PORT_NAME = "start_data_right";
	private final static String STEP_WIDTH_PORT_NAME = "start_step_width";
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	// Condition: For(LEFT_INPUT; LEFT_INPUT < RIGHT_INPUT; LEFT_INPUT +=
	// STEP_WIDTH_INPUT)
	private final static int LEFT_INPUT = 0; // Startvalue of the loop
	private final static int RIGHT_INPUT = 10; // Max. Value
	private final static int STEP_WIDTH_INPUT = 1; // Stepwidth
	private final static int EXPECTED_LEFT_EXIT = 9;

	@Test(timeout = DEFAULT_TIMEOUT)
	public void simpleForLoopInstanceExecuteTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkSubSteps(pi);
		for(PortInstance port : pi.getPorts())
			checkPortValue(port);
	}

	private void checkSubSteps(ProcessStepInstance instance) {
		for (ProcessStepInstance step : instance.getSubSteps()) {
			assertTrue(
					String.format(PROCESS_WRONG_STATE, step.getProcessStepType().getName(),
							step.getExecutionState()), checkProcessStepState(step));
			for (PortInstance port : step.getPorts()){
				assertTrue(
						String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
						checkProcessStepPort(port));
			checkPortValue(port);
			}
			checkSubSteps(step);
		}
	}

	private void checkPortValue(PortInstance port) {
		if(port.getName().equals("end_data_exit_left"))
			checkIntValue((DataPortInstance)port, EXPECTED_LEFT_EXIT); 		
	}
	
	private void checkIntValue(DataPortInstance port, int expectedValue){
		int current = ((IntegerTypeInstance)port.getDataInstance()).getValue();
		boolean result = current == expectedValue;
		assertTrue(String.format(PORT_WRONG_VALUE, port.getName(), current, expectedValue), result);		
	}

	private boolean checkProcessStepPort(PortInstance port) {
		if (port.getName().equals("start_data_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_data_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_step_width"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_data_for_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_data_for_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start__data_for_step_width"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_load_class_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("start_load_class_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_load_class_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_load_class_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_data_for_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_data_for_right"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_data_exit_left"))
			return port.getExecutionState() == State.ACTIVE;
		if (port.getName().equals("end_data_exit_right"))
			return port.getExecutionState() == State.ACTIVE;
		return false;
	}

	private boolean checkProcessStepState(ProcessStepInstance process) {
		if (process.getProcessStepType().getName().equals("ForLoop"))
			return process.getExecutionState() == State.EXECUTED;
		if (process.getProcessStepType().getName().equals("LoadClassStep"))
			return process.getExecutionState() == State.EXECUTED;			
		return false;
	}

	private ProcessStepInstance uploadAndStartProcess() throws InterruptedException {
		PROCESS_MANAGER.uploadModelFile(PROCESS_PATH);
		PROCESS_MANAGER.deployProcess(PROCESS_ID);
		String processInstanceId = PROCESS_MANAGER.deployProcessInstance(PROCESS_ID);
		Map<String, DataTypeInstance> inputParameters = createInputParameters(PROCESS_ID);

		Thread.sleep(WAIT_DEPLOY_TIME); // this is bad, but the process may not
										// be fully deployed
		ProcessStepInstance instance = PROCESS_MANAGER.getProcessInstanceInfos(processInstanceId);
		PROCESS_MANAGER.startProcessInstance(processInstanceId, inputParameters);
		return instance;
	}

	private Map<String, DataTypeInstance> createInputParameters(String processId) {
		Map<String, DataTypeInstance> inputData = new HashMap<String, DataTypeInstance>();
		Process p = PROCESS_MANAGER.getProcessInfos(processId);

		for (Port port : p.getPorts())
			if (port instanceof StartDataPort)
				setValueAndPutToMap(inputData, port);
		return inputData;
	}

	private void setValueAndPutToMap(Map<String, DataTypeInstance> inputData, Port port) {
		StartDataPort startDataPort = (StartDataPort) port;
		DataType dataType = startDataPort.getPortDatatype();
		String dataTypedId = dataType.getId();

		if (!(dataType instanceof IntegerType))
			return;
		IntegerType integerType = (IntegerType) dataType;
		IntegerTypeInstance integerTypeInstance = SofiaInstanceFactoryImplCustom.getInstance()
				.createIntegerTypeInstance();
		integerTypeInstance.setDataTypeType(integerType);
		integerTypeInstance.setTypeId(integerType.getId());
		integerTypeInstance.setName(integerType.getName());
		integerTypeInstance.setInstanceId(integerType.getId() + "instance");
		integerTypeInstance.setInstancenumber(1);
		if (startDataPort.getName().equals(LEFT_PORT_NAME))
			integerTypeInstance.setValue(LEFT_INPUT);
		if (startDataPort.getName().equals(RIGHT_PORT_NAME))
			integerTypeInstance.setValue(RIGHT_INPUT);
		if (startDataPort.getName().equals(STEP_WIDTH_PORT_NAME))
			integerTypeInstance.setValue(STEP_WIDTH_INPUT);
		inputData.put(dataTypedId, integerTypeInstance);
	}

}
