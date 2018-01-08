package eu.vicci.process.client.rest.examples;

import java.util.HashMap;
import java.util.Map;

import eu.vicci.process.client.rest.ProteusRestClient;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class RunWithInputParameter extends AbstractExample {

	public static void main(String[] args) {
		new RunWithInputParameter().run();
	}

	@Override
	protected void run() {
		ProteusRestClient client = getClient();
		String diagram = readProcessDoc("processes/SimpleDataTypeProcess.diagram");

		// upload and deploy instance
		String id = client.uploadAndDeploy(diagram);
		System.out.println("Process Id: " + id);
		String instanceId = client.deployProcessInstance(id);
		System.out.println("Process Instance Id: " + instanceId);
		
		// after starting the process we want to wait, till it is finished
		enableWaitForInstance(instanceId);

		// get the instance model, which contains all created datatype instances
		ProcessInstance processInstance = client.getProcessStepInstance(instanceId);
		
		// create the input params map
		Map<String, DataTypeInstance> inputParameters = createInputParams(processInstance);

		// Once the process has an instance deployed we can execute the process
		client.startProcessInstance(instanceId, inputParameters);
		
		// this will block, till process is finished
		waitForProcess();				
		
		// after execution we can get the final values e.g. with the final state message
		IStateChangeMessage finalMessage = client.getRecentState(instanceId);	
		
		printAllEndportData(finalMessage);
	}

	private Map<String, DataTypeInstance> createInputParams(ProcessInstance processInstance) {
		
		// First step is to receive the datatype instance from the ports.
		// We can get the ports directly from the process by their names, or also by their id, or instance id.
		DataPortInstance stringPort = (DataPortInstance) processInstance.getPorts().stream()
				.filter(p -> p.getName().equals("string_port"))
				.findFirst().get();
		DataPortInstance intPort = (DataPortInstance) processInstance.getPorts().stream()
				.filter(p -> p.getName().equals("int_port"))
				.findFirst().get();
		
		// get the actual datatype instance from the ports
		StringTypeInstance stringInstance = (StringTypeInstance)stringPort.getDataInstance();
		IntegerTypeInstance intInstance = (IntegerTypeInstance)intPort.getDataInstance();
		
		// set the values
		stringInstance.setValue("Hello World");
		intInstance.setValue(12345);
		
		// add to the map, with the datatype id (not instance id!) as key
		Map<String, DataTypeInstance> params = new HashMap<>();
		params.put(stringInstance.getTypeId(), stringInstance);
		params.put(intInstance.getTypeId(), intInstance);
		
		return params;
	}
	
	private void printAllEndportData(IStateChangeMessage message){
		System.out.println("\nFinished Instance has following values:\n");
		message.getEndDataPorts().values().stream()
		.forEach(p -> 
			System.out.println(p.getDataTypeInstance().getDataType().getName() 
					+ ":  " 
					+ p.getDataTypeInstance().getValueString()));		
	}

}
