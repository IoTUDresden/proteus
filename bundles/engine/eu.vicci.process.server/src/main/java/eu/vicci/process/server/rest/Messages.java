package eu.vicci.process.server.rest;

public class Messages {
	
	private Messages() {	}
	
	public static final String ERR_MISSING_PROCESS_DOC = "Missing or empty process document.";
	public static final String ERR_PROCESS_NOT_CREATED = "Process could not be created.";
	public static final String ERR_EXISTING_PROCESS_NO_OVERRIDE = "The process with the id '%s' is already deployed in the engine. Change flag 'overrideExisiting' to true, to override the existing process.";
	public static final String ERR_COULD_NOT_DEPLOY_PROCESS = "Process could not be deployed.";
	public static final String ERR_MISSING_PROCESS_ID = "Missing process id.";
	public static final String ERR_PROCESS_WITH_ID_NOT_FOUND = "Process with id '%s' could not be found.";
	public static final String ERR_COULD_NOT_DEPLOY_INSTANCE_FOR_ID = "Instance could not deployed for '%s'.";
	public static final String ERR_PROCESS_INSTANCE_WITH_ID_NOT_FOUND = "ProcessInstance with id '%s' could not be found.";	
	public static final String ERR_MISSING_INSTANCE_ID = "Instance id cant be null or empty";
	public static final String ERR_STATE_NOT_FOUND_FOR = "Cant find the latest state message for process instance '{}'";


}
