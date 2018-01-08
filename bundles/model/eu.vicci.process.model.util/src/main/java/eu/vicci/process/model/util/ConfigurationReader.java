package eu.vicci.process.model.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;

/**
 * This Config Reader reads the runtime config file (in most cases server.conf) 
 * and some environment variables.
 * Sets default values, if no config is specified.
 */
public class ConfigurationReader implements IConfigurationReader {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigurationReader.class);
	private static final String TRUE_STR = "true";
	private static final String LIST_SEPARATOR = ",";
	
	private static final String ERR_PARSE_HTTP_PORT = "cant parse the given value to integer for {}. Please check your config.";
	
	private String ip;
	private String port;
	private String path;
	private String realmName;
	private String namespace;
	private String openHabUri;
	private int httpPort = 0;
	
	private String superPeerIp;
	
	private String contextUri;
	private String feedbackServiceUri;
	
	//listeners for runtime
	private boolean startOsgiRuntime;
	private boolean startOpenHabListener;
	private boolean startCepEngine;
	private boolean deployExistingProcessModels;

	private String elasticsearchHost;	
	
	private String ipFilter;
	private List<String> devices;
	
	public ConfigurationReader(){
		readProperties();
	}
	
	
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
	public boolean startOpenHabListener() {
		return startOpenHabListener;
	}

	@Override
	public boolean startCepEngine() {
		return startCepEngine;
	}

	@Override
	public boolean deployExistingProcessModels() {
		return deployExistingProcessModels;
	}
	
	@Override
	public String getIpFilter() {
		return ipFilter;
	}
	
	private void readPropertiesFromFile(){
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
	
	private void readPropertiesFromEnvironment(){
		ip = System.getenv(ConfigProperties.PROTEUS_SUPER_PEER_IP);
		port = System.getenv(ConfigProperties.PROTEUS_WAMP_PORT);
		realmName = System.getenv(ConfigProperties.PROTEUS_WAMP_REALM_NAME);
		namespace = System.getenv(ConfigProperties.PROTEUS_WAMP_NAMESPACE);
		String tmpDeploy = System.getenv(ConfigProperties.DEPLOY_EXISTING_PROCESSMODELS);
		deployExistingProcessModels =  TRUE_STR.equals(tmpDeploy) 
				|| (tmpDeploy == null && TRUE_STR.equals(ConfigProperties.DEFAULT_DEPLOY_EXISTING_PROCESSMODELS));
		
		openHabUri = System.getenv(ConfigProperties.OPENHAB_URI);
		startOpenHabListener = openHabUri != null;	
		String tmpCep = System.getenv(ConfigProperties.START_CEP_ENGINE);
		startCepEngine = tmpCep == null || TRUE_STR.equals(tmpCep);	
		
		elasticsearchHost = System.getenv(ConfigProperties.ELASTICSEARCH_HOST);
		superPeerIp = System.getenv(ConfigProperties.PROTEUS_SUPER_PEER_IP);
		ipFilter = System.getenv(ConfigProperties.PROTEUS_IP_FILTER);
		devices = splitValue(System.getenv(ConfigProperties.PROTEUS_DEVICES), LIST_SEPARATOR);		
		
		String tmpOsgi = System.getenv(ConfigProperties.START_OSGI_RUNTIME);
		startOsgiRuntime = TRUE_STR.equals(tmpOsgi) ||
				(tmpOsgi == null && TRUE_STR.equals(ConfigProperties.DEFAULT_START_OSGI_RUNTIME));
		
		String tmpHttpPort = System.getenv(ConfigProperties.PROTEUS_HTTP_PORT);
		tmpHttpPort = tmpHttpPort == null ? ConfigProperties.DEFAULT_PROTEUS_HTTP_PORT : tmpHttpPort;
		try {
			httpPort = Integer.parseInt(tmpHttpPort);				
		} catch (NumberFormatException e) {
			LOG.error(ERR_PARSE_HTTP_PORT, ConfigProperties.PROTEUS_HTTP_PORT);
		}	
	}
	
	private void readProperties(){
		if(path == null)
			readPropertiesFromEnvironment();
		else
			readPropertiesFromFile();
		setDefaultValues();	
	}
	
	private void setProps(Properties properties){
		ip = properties.getProperty(ConfigProperties.PROTEUS_SUPER_PEER_IP);
		port = properties.getProperty(ConfigProperties.PROTEUS_WAMP_PORT);
		realmName = properties.getProperty(ConfigProperties.PROTEUS_WAMP_REALM_NAME);
		namespace = properties.getProperty(ConfigProperties.PROTEUS_WAMP_NAMESPACE);
		String tmpDeploy = properties.getProperty(ConfigProperties.DEPLOY_EXISTING_PROCESSMODELS);
		deployExistingProcessModels =  TRUE_STR.equals(tmpDeploy) 
				|| (tmpDeploy == null && TRUE_STR.equals(ConfigProperties.DEFAULT_DEPLOY_EXISTING_PROCESSMODELS));
		
		openHabUri = properties.getProperty(ConfigProperties.OPENHAB_URI);
		startOpenHabListener = openHabUri != null;	
		String tmpCep = properties.getProperty(ConfigProperties.START_CEP_ENGINE);
		startCepEngine = tmpCep == null || TRUE_STR.equals(tmpCep);	
		
		elasticsearchHost = properties.getProperty(ConfigProperties.ELASTICSEARCH_HOST);
		superPeerIp = properties.getProperty(ConfigProperties.PROTEUS_SUPER_PEER_IP);
		ipFilter = properties.getProperty(ConfigProperties.PROTEUS_IP_FILTER);
		devices = splitValue(properties.getProperty(ConfigProperties.PROTEUS_DEVICES), LIST_SEPARATOR);	
		
		String tmpOsgi = properties.getProperty(ConfigProperties.START_OSGI_RUNTIME);
		startOsgiRuntime = TRUE_STR.equals(tmpOsgi) ||
				(tmpOsgi == null && TRUE_STR.equals(ConfigProperties.DEFAULT_START_OSGI_RUNTIME));
		
		String tmpHttpPort = properties.getProperty(ConfigProperties.PROTEUS_HTTP_PORT);
		tmpHttpPort = tmpHttpPort == null ? ConfigProperties.DEFAULT_PROTEUS_HTTP_PORT : tmpHttpPort;
		try {
			httpPort = Integer.parseInt(tmpHttpPort);				
		} catch (NumberFormatException e) {
			LOG.error(ERR_PARSE_HTTP_PORT, ConfigProperties.PROTEUS_HTTP_PORT);
		}	
	}
	
	private void setDefaultValues(){
		if(port == null) port = ConfigProperties.DEFAULT_PROTEUS_WAMP_PORT;
		if(realmName == null) realmName = ConfigProperties.DEFAULT_PROTEUS_WAMP_REALM_NAME;
		if(namespace == null) namespace = ConfigProperties.DEFAULT_PROTEUS_WAMP_NAMESPACE;
	}
	
	private List<String> splitValue(String value, String separator){
		List<String> tmp = new ArrayList<>();
		if(value == null) return tmp;
		String[] split = value.split(separator);
		for (int i = 0; i < split.length; i++) {
			String out = split[i].trim();
			tmp.add(out);			
		}
		return tmp;
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

	public String getSuperPeerIp() {
		return superPeerIp;
	}

	@Override
	public List<String> getDevices() {
		return devices;
	}

	@Override
	public int getHttpPort() {
		return httpPort;
	}	
}
