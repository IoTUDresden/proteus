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
	
	private String contextUri;
	private String feedbackServiceUri;
	
	//listeners for runtime
	private boolean startOsgiRuntime;
	private boolean startSemiwaListener;
	private boolean startOpenHabListener;
	private boolean startCepEngine;
	private boolean startXmlRpcWebServer;
	private boolean deployExistingProcessModels;

	private String elasticsearchHost;
	
	//TODO
//	- ContextUri (default: http://localhost:9000/contexts/0)
//		- FeedbackServiceUri (default: http://192.168.1.3:9000)
	
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
		
		contextUri = properties.getProperty(ConfigProperties.CONTEXT_URI);
		feedbackServiceUri = properties.getProperty(ConfigProperties.FEEDBACK_SERVICE_URI);
		elasticsearchHost = properties.getProperty(ConfigProperties.ELASTICSEARCH_HOST);
	}

	@Override
	public String getOpenHabUri() {
		return openHabUri;
	}

	@Override
	public String getContextUri() {
		return contextUri;
	}

	@Override
	public String getFeedbackServiceUri() {
		return feedbackServiceUri;
	}

	@Override
	public String getElasticsearchHost() {
		return elasticsearchHost;
	}
	
}
