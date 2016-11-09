package eu.vicci.process.adapter;

public class AdapterConstants {
	
	// config keys for the launch files
	
	public static final String CFG_LAUNCH_VICCI_RUNTIME_URL = "VicciRuntimeUrl";
	public static final String CFG_LAUNCH_OPENHAB_URL = "OpenHabUrl";
	public static final String CFG_LAUNCH_ENGINE_ADAPTER_SERVICE = "EngineAdapterService";
	public static final String CFG_LAUNCH_FILE = "File";
	public static final String CFG_LAUNCH_PROJECT = "Project";
	public static final String CFG_LAUNCH_PORT = "Port";
	public static final String CFG_LAUNCH_REALM = "Realm";
	public static final String CFG_LAUNCH_NAMESPACE = "Namespace";
	public static final String CFG_LAUNCH_RUN_IN_LOOP = "RunInLoop";
	
	// default config values for launch
	
	public static final String DEFAULT_LAUNCH_VICCI_RUNTIME_URL = "localhost";
	public static final String DEFAULT_LAUNCH_ENGINE_ADAPTER_SERVICE  = "Client Process Engine Adapter";
	public static final String DEFAULT_LAUNCH_FILE  = "";
	public static final String DEFAULT_LAUNCH_PROJECT  = "";
	public static final String DEFAULT_LAUNCH_PORT = "8081";
	public static final String DEFAULT_LAUNCH_REALM = "vicciRealm";
	public static final String DEFAULT_LAUNCH_NAMESPACE = "vicciWs";
	public static final boolean DEFAULT_LAUNCH_RUN_IN_LOOP = false;
	
	// pref keys for preferences page
	
	public static final String PREF_HOST = "pref_Host";
	public static final String PREF_PORT = "pref_Port";
	public static final String PREF_REALM = "pref_Realm";
	public static final String PREF_NAMESPACE = "pref_Namespace";
	
	// default prefs for preferences page
	
	public static final String DEFAULT_PREF_HOST = "localhost";
	public static final String DEFAULT_PREF_PORT = "8081";
	public static final String DEFAULT_PREF_REALM = "vicciRealm";
	public static final String DEFAULT_PREF_NAMESPACE = "vicciWs";

}
