package eu.vicci.process.distribution.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import eu.vicci.process.distribution.core.PeerProfile;

public class SuperPeerRequest {
	
	@JsonProperty
	public PeerProfile profile;
	
	@JsonProperty
	public String port;
	
	@JsonProperty
	public String namespace;
	
	@JsonProperty
	public String realm;

}
