package eu.vicci.process.model.util.configuration;

public final class TopicId {
	private TopicId() {	}
	
	/**
	 * Topic for state changes (e.g. for listening to {@link eu.vicci.process.model.util.messages.core.IStateChangeMessage}).
	 */
	public static final String STATE_CHANGE = "http://vicci.eu/processes/statechange";
	
	/**
	 * Topic for receiving human task requests
	 */
	public static final String HUMAN_TASK_REQ = "http://vicci.eu/processes/humantaskreq";
	
	/**
	 * Topic for receiving human task responses
	 */
	public static final String HUMAN_TASK_RESP = "http://vicci.eu/processes/humantaskresp";
	
	/**
	 * Topic for receiving engine updates, such as new process or instance deployed
	 */
	public static final String ENGINE_UPDATE = "http://vicci.eu/processes/engine/update";
	
	/**
	 * Topic for receiving the peer metrics
	 */
	public static final String PEER_METRICS = "http://vicci.eu/processes/peer/metrics";
	
}
