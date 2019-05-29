package eu.vicci.process.client.rest.examples;

import eu.vicci.process.client.rest.ProteusRestClient;
import eu.vicci.process.model.sofiainstance.ProcessInstance;

/**
 * Example, how to use the REST-API in combination with
 */
public class HumanTaskExample extends AbstractExample {

	public static void main(String[] args) {
		new HumanTaskExample().run();
	}
	
	@Override
	protected void run() {
		ProteusRestClient client = getClient();
		String diagram = readProcessDoc("processes/simpleHumanTask.diagram");	
		
		String id = client.uploadAndDeploy(diagram);
		System.out.println("Process Id: " + id);
		String instanceId = client.deployProcessInstance(id);
		System.out.println("Process Instance Id: " + instanceId);
		
		enableWaitForInstance(instanceId);

		ProcessInstance processInstance = client.getProcessStepInstance(instanceId);
		
		client.startProcessInstance(instanceId);
		
		waitForProcess();		
	}
}
