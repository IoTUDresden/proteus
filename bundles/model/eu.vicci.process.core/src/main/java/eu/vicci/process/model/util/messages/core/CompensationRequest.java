package eu.vicci.process.model.util.messages.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompensationRequest implements IWampMessage {
	/**
	 * Ip for the peer, which the process should be executed on
	 */
	@JsonProperty public String ip;
	/**
	 * the peer id where the failed process was running
	 */
	@JsonProperty public String oldPeerId;
	/**
	 * the instance id of the failed process on the remote peer
	 */
	@JsonProperty public String oldInstanceId;
	/**
	 * peer id where the new process should be executed on
	 */
	@JsonProperty public String newPeerId;
	/**
	 * the process which should be executed new
	 */
	@JsonProperty public String processId;	
	/**
	 * Instance Id for the process instance on the super peer.
	 */
	@JsonProperty public String originalInstanceId;
	
	
}
