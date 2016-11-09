package eu.vicci.process.model.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;

public class ConfigurationReader implements IConfigurationReader {
	private static final String TRUE_STR = "true";
	
	private String ip;
	private String port;
	private String path;
	private String realmName;
	private String namespace;
	private String openHabUri;
	
	//listeners for runtime
	private boolean startOsgiRuntime;
	private boolean startSemiwaListener;
	private boolean startOpenHabListener;
	private boolean startCepEngine;
	private boolean startXmlRpcWebServer;
	private boolean deployExistingProcessModels;
	
	public ConfigurationReader(String path) {
		this.path = path;
		readProperties();
	}

	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public String getPort() {
		return port;
	}
	
	@Override
	public String getNamespace(){
		return namespace;
	}
	
	@Override
	public int getPortAsInt(){
		return Integer.parseInt(port);
	}
	
	@Override
	public String getRealmName(){
		return realmName;
	}
	
	@Override
	public boolean startOsgiRuntime() {
		return startOsgiRuntime;
	}

	@Override
	public boolean startSemiwaListener() {
		return startSemiwaListener;
	}

	@Override
	public boolean startOpenHabListener() {
		return startOpenHabListener;
	}

	@Override
	public boolean startCepEngine() {
		return startCepEngine;
	}

	@Override
	public boolean startXmlRpcWebServer() {
		return startXmlRpcWebServer;
	}

	@Override
	public boolean deployExistingProcessModels() {
		return deployExistingProcessModels;
	}
	
	private void readProperties(){
		Properties properties = new Properties();
		BufferedInputStream stream = null;
		try {
			stream = new BufferedInputStream(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		try {
			properties.load(stream);
			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		setProps(properties);
	}
	
	private void setProps(Properties properties){
		ip = properties.getProperty("ip");
		port = properties.getProperty("port");
		startOsgiRuntime = TRUE_STR.equals(properties.getProperty(ConfigProperties.START_OSGI_RUNTIME));
		startSemiwaListener = TRUE_STR.equals(properties.getProperty(ConfigProperties.START_SEMIWA_LISTENER));
		startOpenHabListener = TRUE_STR.equals(properties.getProperty(ConfigProperties.START_OPENHAB_LISTENER));
		startCepEngine = TRUE_STR.equals(properties.getProperty(ConfigProperties.START_CEP_ENGINE));
		startXmlRpcWebServer = TRUE_STR.equals(properties.getProperty(ConfigProperties.START_XMLRPC_WEBSERVER));
		deployExistingProcessModels = TRUE_STR.equals(properties.getProperty(ConfigProperties.DEPLOY_EXISTING_PROCESSMODELS));		
		realmName = properties.getProperty(ConfigProperties.REALMNAME);
		namespace = properties.getProperty(ConfigProperties.NAMESPACE);
		openHabUri = properties.getProperty(ConfigProperties.OPENHAB_URI);
	}

	@Override
	public String getOpenHabUri() {
		return openHabUri;
	}
}
