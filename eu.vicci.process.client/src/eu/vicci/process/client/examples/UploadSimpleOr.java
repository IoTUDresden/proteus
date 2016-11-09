package eu.vicci.process.client.examples;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.util.ConfigurationReader;

public class UploadSimpleOr {
	
	public static void main(String[] args) {
		IConfigurationReader configReader = new ConfigurationReader("server.conf");
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		
		IProcessEngineClient pec = builder.fromConfig(configReader).build();
		pec.connect();
		System.out.println("Upload1");
		String processId1 = pec
				.uploadModelFile("processes/SimpleOrTest.diagram");
		System.out.println("############### ProcessId: " + processId1);
		pec.close();
	}

}
