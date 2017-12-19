package eu.vicci.process.model.util.configuration;

public class ConfigProperties {
	
	private ConfigProperties() {
	}
	
	public static final String PROTEUS_LOG_LEVEL = "PROTEUS_LOG_LEVEL";
	public static final String OPENHAB_URI = "OPENHAB_URI";	
	public static final String PROTEUS_SUPER_PEER_IP = "PROTEUS_SUPER_PEER_IP";
	
	public static final String START_CEP_ENGINE = "START_CEP_ENGINE";
	public static final String DEPLOY_EXISTING_PROCESSMODELS = "DEPLOY_EXISTING_PROCESSMODELS";
	public static final String PROTEUS_WAMP_REALM_NAME = "PROTEUS_WAMP_REALM_NAME";
	public static final String PROTEUS_WAMP_NAMESPACE = "PROTEUS_WAMP_NAMESPACE";
	public static final String PROTEUS_WAMP_PORT = "PROTEUS_WAMP_PORT";
	public static final String PROTEUS_HTTP_PORT = "PROTEUS_HTTP_PORT";
	
	public static final String FEEDBACK_CONTEXT_URI = "FEEDBACK_CONTEXT_URI";
	public static final String FEEDBACK_SERVICE_URI = "FEEDBACK_SERVICE_URI";
	public static final String ELASTICSEARCH_HOST = "ELASTICSEARCH_HOST";
	public static final String PROTEUS_IP_FILTER = "PROTEUS_IP_FILTER";	
	public static final String PROTEUS_DEVICES = "PROTEUS_DEVICES";
	
	public static final String START_OSGI_RUNTIME = "START_OSGI_RUNTIME";
	
	//
	// Default properties
	//
	public static final String DEFAULT_START_CEP_ENGINE = "true";
	public static final String DEFAULT_DEPLOY_EXISTING_PROCESSMODELS = "false";
	public static final String DEFAULT_PROTEUS_WAMP_REALM_NAME = "vicciRealm";
	public static final String DEFAULT_PROTEUS_WAMP_NAMESPACE = "vicciWs";
	public static final String DEFAULT_PROTEUS_WAMP_PORT = "8081";
	public static final String DEFAULT_PROTEUS_HTTP_PORT = "8082";
	
	public static final String DEFAULT_START_OSGI_RUNTIME = "false";
	


		

}
