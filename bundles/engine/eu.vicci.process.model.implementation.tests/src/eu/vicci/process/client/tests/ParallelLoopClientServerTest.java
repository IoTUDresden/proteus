package eu.vicci.process.client.tests;

import org.junit.Ignore;
import org.junit.Test;

import eu.vicci.process.client.ProcessEngineClient;
import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.implementation.tests.util.DefaultServerSettings;
import eu.vicci.process.runtime.tests.util.VicciTestRuntime;

/**
 * This test should test the proper execution of a process, 
 * which is uploaded by a client and then executed by the server.
 */
public class ParallelLoopClientServerTest {
	private static final int SLEEP_TIME = 1000;
	private static final int DEPLOY_TIME = 500;
	private static final int TIMEOUT = 5000;
	
	private static IProcessEngineClient pec;
	

	@Test
	@Ignore
	public void parallelLoopClientServerTest() throws InterruptedException {
		 // start the runtime
		VicciTestRuntime.startRuntime();		

		Thread.sleep(SLEEP_TIME); // wait for complete start
		
		startClient();
		uploadAndStartProcess();
		Thread.sleep(TIMEOUT);
	}
	
	private void uploadAndStartProcess() throws InterruptedException{
		String processId = pec.uploadModelFile("processes/ForLoopTest.diagram");
		pec.deployProcess(processId);
		Thread.sleep(DEPLOY_TIME);
		String instanceId = pec.deployProcessInstance(processId);
		Thread.sleep(DEPLOY_TIME);
		pec.startProcessInstance(instanceId, null);		
	}
	
	
	private void startClient(){
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		builder
		.withName("TestClient")
		.withIp(DefaultServerSettings.CLIENT_IP)
		.withPort(DefaultServerSettings.CLIENT_PORT)
		.withRealmName(ProcessEngineClient.DEFAULT_REALM)
		.withNamespace(ProcessEngineClient.DEFAULT_NAMESPACE);
		pec = builder.build();
		pec.connect();
	}
}
