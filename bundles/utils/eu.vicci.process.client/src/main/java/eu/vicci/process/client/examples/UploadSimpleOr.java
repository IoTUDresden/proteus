package eu.vicci.process.client.examples;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;

public class UploadSimpleOr {
	private static final String IP = "localhost";
	private static final String PORT = "8081";
	
	public static void main(String[] args) {
		IProcessEngineClient pec = new ProcessEngineClientBuilder()
				.withIp(IP)
				.withPort(PORT)
				.withName("Example Client")
				.withNamespace(ConfigProperties.DEFAULT_PROTEUS_WAMP_NAMESPACE)
				.withRealmName(ConfigProperties.DEFAULT_PROTEUS_WAMP_REALM_NAME)
				.build();	
		pec.connect();
		System.out.println("Upload1");
		String processId1 = pec
				.uploadModelFile("processes/SimpleOrTest.diagram");
		System.out.println("############### ProcessId: " + processId1);
		pec.close();
	}

}
