package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import eu.vicci.process.engine.ProcessManagerPublic;
import eu.vicci.process.model.implementation.tests.util.ProcessExecutionTestsBase;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

public class SimpleWhileLoopTests extends ProcessExecutionTestsBase {
	private final static String PROCESS_PATH = "processes/WhileLoopTest.diagram";
	private final static String PROCESS_ID = "_3XpKEKMUEeStLIjh5Q8KSA";

	private final static String LEFT_PORT_NAME = "start_left";
	private final static String RIGHT_PORT_NAME = "start_right";
	private final static ProcessManagerPublic PROCESS_MANAGER = new ProcessManagerPublic();

	private final static String LEFT_INPUT = "";
	private final static String RIGHT_INPUT = "nnnn";

	@Test(timeout = DEFAULT_TIMEOUT)
	public void simpleWhileLoopExecuteTest() throws InterruptedException {
		ProcessStepInstance pi = uploadAndStartProcess();

		while (pi.getExecutionState() != State.EXECUTED)
			Thread.sleep(SLEPPING_TIME);

		LifeCycleManager.INSTANCE.stopActorSystem();
		checkPorts(pi);
		checkSubsteps(pi);
	}

	private void checkSubsteps(ProcessStepInstance pi) {
		for (ProcessStepInstance subStep : pi.getSubSteps()) {
			assertTrue(String.format(PROCESS_WRONG_STATE, subStep.getProcessStepType().getName(),
					subStep.getExecutionState()), subStep.getExecutionState() == State.EXECUTED);
			checkPorts(subStep);
			checkSubsteps(subStep);
		}

	}

	private void checkPorts(ProcessStepInstance pi) {
		for (PortInstance port : pi.getPorts()) {
			assertTrue(String.format(PORT_WRONG_STATE, port.getName(), port.getExecutionState()),
					port.getExecutionState() == State.ACTIVE);			
			
			if ("end_left".equals(port.getName()) || "start_while_left".equals(port.getName())) {
				DataPortInstance dataPort = (DataPortInstance) port;
				String value = (String) dataPort.getDataInstance().getValueAsObject();
				assertTrue(String.format(PORT_WRONG_VALUE, port.getName(), value, RIGHT_INPUT),
						value.equals(RIGHT_INPUT));
			}
		}
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

		if (!(dataType instanceof StringType))
			return;
		StringType stringType = (StringType) dataType;
		StringTypeInstance integerTypeInstance = SofiaInstanceFactoryImplCustom.getInstance()
				.createStringTypeInstance();
		integerTypeInstance.setDataTypeType(stringType);
		integerTypeInstance.setTypeId(stringType.getId());
		integerTypeInstance.setName(stringType.getName());
		integerTypeInstance.setInstanceId(stringType.getId() + "instance");
		integerTypeInstance.setInstancenumber(1);
		if (startDataPort.getName().equals(LEFT_PORT_NAME))
			integerTypeInstance.setValue(LEFT_INPUT);
		if (startDataPort.getName().equals(RIGHT_PORT_NAME))
			integerTypeInstance.setValue(RIGHT_INPUT);
		inputData.put(dataTypedId, integerTypeInstance);
	}

}
