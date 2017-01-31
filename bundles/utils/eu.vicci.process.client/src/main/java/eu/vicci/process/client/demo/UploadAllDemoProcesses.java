package eu.vicci.process.client.demo;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.model.util.ConfigurationReader;

public class UploadAllDemoProcesses {
	private static final String path = "processes/demo/";
	private static final String[] models = { "HomematicDoorAndLight", "KodiNotificationDemo", "KodiSoundAndPicture", 
			"EMDemo", "ResetAll", "MoveRobotToPerson", "YouHaveAVisitor", "StackedProcess" };
	
	private IProcessEngineClient pec;

	public static void main(String[] args) {
		UploadAllDemoProcesses demo = new UploadAllDemoProcesses();
		demo.run();
	}

	public void run() {
		pec = createClient();
		pec.connect();
		uploadAll();
	}
	
	private void uploadAll(){
		for (int i = 0; i < models.length; i++) {
			String id = pec.uploadModelFile(path + models[i] + ".diagram");	
			pec.deployProcess(id);
		}
	}

	private IProcessEngineClient createClient() {
		IConfigurationReader configReader = getConfigurationReader();
		ProcessEngineClientBuilder builder = new ProcessEngineClientBuilder();
		return builder.fromConfig(configReader).build();
	}
	
	private IConfigurationReader getConfigurationReader(){
		return new ConfigurationReader("server.conf");
	}

}