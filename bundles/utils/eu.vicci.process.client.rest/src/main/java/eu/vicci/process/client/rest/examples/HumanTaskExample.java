package eu.vicci.process.client.rest.examples;

import eu.vicci.process.client.rest.ProteusRestClient;
import eu.vicci.process.model.util.messages.HumanTaskResponse;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;

/**
 * Example, how to use the REST-API in combination with HumanTask
 */
public class HumanTaskExample extends AbstractExample {

	public static void main(String[] args) {
		new HumanTaskExample().run();
	}
	
	@Override
	protected void run() {
		ProteusRestClient client = getClient();
		String diagram = readProcessDoc("processes/wizard/tinkerforge_ambientLight.diagram");	
		
		String id = client.uploadAndDeploy(diagram);
		System.out.println("Process Id: " + id);
		
		//_IjP9YI0LEemo-tbczAUMtw
		
//		String instanceId = client.deployProcessInstance(id);
//		System.out.println("Process Instance Id: " + instanceId);
//		
//		enableWaitForInstance(instanceId);

//		ProcessInstance processInstance = client.getProcessStepInstance(instanceId);
		
//		client.startProcessInstance(instanceId);
		
//		waitForProcess();		
	}
	
	/**
	 * Creates a basic response according to request. E.g. fills the ports with the 
	 * with the values from the request, sets the humantask instance id, ...
	 * @param request
	 * @return
	 */
	public static IHumanTaskResponse createResponseFromRequest(IHumanTaskRequest request){
		IHumanTaskResponse response = new HumanTaskResponse();
		response.setHumanTaskInstanceId(request.getHumanTaskInstanceId());		
		response.setEndDataPorts(request.getEndDataPorts());
		response.setStartDataPorts(request.getStartDataPorts());
		response.setDescription(request.getDescription());
		response.setHumanTaskType(request.getHumanTaskType());
		response.setHumanTaskUseCase(request.getHumanTaskUseCase());
		response.setEndControlPorts(request.getEndControlPorts());
		response.setName(request.getName());
		return response;		
	}
}
