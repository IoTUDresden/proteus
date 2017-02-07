package eu.vicci.process.graphiti.execution.util;

public class StringResource {
	
	private StringResource() {	}
	
	
	public static final String ERR_OPEN_EDITOR = "error while opening the process execution editor";
	
	public static final String ERR_CONFIG_WRONG = "config in launcher wrong";
	
	public static final String ERR_CONFIG_WRONG_MSG = "The config for executing this process step is wrong. ";
	
	public static final String ERR_CANT_CONNECT = "Cant connect to process engine";
	
	public static final String ERR_MODEL_HANDLING_FAILED = "model upload / deployment or start instance failed";
	
	public static final String ERR_RECEIVE_INSTANCE_FAILED = "receiving the process instance failed";
	
	public static final String ERR_FILE_NOT_FOUND = "file not found";
	
	public static final String TT_OPENHAB_URI = "Enter the OpenHAB base URI here e.g. http://192.168.2.5:8080. "
			+ "Leave empty if no OH Instance is running.";
	
	public static final String TT_VICCI_RUNTIME_URL = "Enter the Vicci Runtime Url here. "
			+ "If the Process is run via 'Local Process Engine Adapter' this is ignored";
	
	public static final String TT_RUN_IN_LOOP = "Select this, if the Process should run in a Loop "
			+ "(a new instance is started, after this process was executed)";
	
	public static final String TT_PORT = "The Port on which the vicci runtime is listening.";
	
	public static final String TT_REALM = "The realm for the vicci runtime wamp server";
	
	public static final String TT_NAMESPACE = "The namespace for the vicci runtime.";
	
	public static final String TT_ENGINE_ADAPTER_SERVICE = "Select the service, which should run the process. "
			+ "Client services are needing a running vicci runtime on the specified target.";
	
	public static final String ERR_ROOT_PROCESS_NOT_FOUND = "The root process was not found. "
					+ "Process models should always have a root process, which contains all other processes";
	

}
