package eu.vicci.process.client.rest.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import eu.vicci.process.client.rest.ProteusRestClient;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

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
		
		// we get the finished instance
		ProcessInstance finishedInstance = client.getProcessStepInstance(instanceId);	
		
		printAllEndportData(finishedInstance);
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
		
		// add to the map, with the datatype instance id as key
		Map<String, DataTypeInstance> params = new HashMap<>();
		params.put(stringInstance.getInstanceId(), stringInstance);
		params.put(intInstance.getInstanceId(), intInstance);
		
		return params;
	}
	
	private void printAllEndportData(ProcessInstance processInstance){
		System.out.println("\nFinished Instance has following values:\n");
		List<EndDataPortInstance> endDataPorts = processInstance.getPorts().stream()
				.filter(p -> p instanceof EndDataPort)
				.map(p -> (EndDataPortInstance)p)
				.collect(Collectors.toList());
		
		endDataPorts.stream()
		.forEach(p -> 
			System.out.println(p.getName() + ":  " + p.getDataInstance().getValueAsObject()));
		
	}

}
