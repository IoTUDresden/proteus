package eu.vicci.process.client.rest.examples;

import eu.vicci.process.client.rest.ProteusRestClient;

/**
 * Example how to use the PROtEUS REST API and the new {@link ProteusRestClient}.
 * 
 * @author andre
 */
public class UploadAndRunProcess extends AbstractExample {

	public static void main(String[] args) {
		new UploadAndRunProcess().run();
	}

	protected void run() {
		// Create a REST client
		ProteusRestClient restClient = getClient();
		
		// Read in the complete process file.
		String doc = readProcessDoc("processes/SimpleOrTest.diagram");

		// Upload the process definition and deploy the process in the engine, 
		// so that the process is available for the environment.
		// At the moment 'override existing' (overrides existing process models in the engine) will have no effect, 
		// but the default value (true) is used. Better restart
		// the engine, if the process model has changed.
		String id = restClient.uploadAndDeploy(doc);
		System.out.println("Process Id: " + id);
		
		// Once a process is uploaded, you can deploy process instances, which are available for execution.
		// It is not necessary to uploadAndDeploy() a process definition again, once a process was uploaded.
		// If you want to execute the process again, just deploy a new instance and work with it.
		String instanceId = restClient.deployProcessInstance(id);
		System.out.println("Process Instance Id: " + instanceId);
		
		// Once the process has an instance deployed we can execute the process
		restClient.startProcessInstance(instanceId);
	}
	


}
