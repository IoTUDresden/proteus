package eu.vicci.process.client.core;

public interface IConfigurationReader {

	String getIp();

	String getPort();

	String getNamespace();

	int getPortAsInt();

	String getRealmName();

	boolean startOsgiRuntime();

	boolean startSemiwaListener();

	boolean startOpenHabListener();

	boolean startCepEngine();

	boolean startXmlRpcWebServer();

	boolean deployExistingProcessModels();
	
	String getOpenHabUri();

}