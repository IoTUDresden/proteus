package eu.vicci.process.client;

import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;

/**
 * Builds a {@link eu.vicci.process.client.core.IProcessEngineClient}.
 */
public class ProcessEngineClientBuilder extends AbstractClientBuilder {
	
	public IProcessEngineClient build(){
		if(ip == null || port == null || name == null || namespace == null || realmName == null)
			throw new IllegalArgumentException("Some or more required objects are null");
		return new ProcessEngineClient(name, ip, port, realmName, namespace, isServer);
	}
	
	public ProcessEngineClientBuilder fromConfig(IConfigurationReader configReader){
		ip = configReader.getIp();
		port = configReader.getPort();
		namespace = configReader.getNamespace();
		realmName = configReader.getRealmName();
		return this;
	}
}
