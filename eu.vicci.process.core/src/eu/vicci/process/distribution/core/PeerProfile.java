package eu.vicci.process.distribution.core;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Client Profile for a peer. Use {@link PeerProfile#create()} to create a new client profile
 */
public class PeerProfile {
	
	@JsonProperty
	private String peerId;
	
	@JsonProperty
	private String ip;
	
	@JsonProperty
	private String hostName;

	
	public String getPeerId() {
		return peerId;
	}

	public String getIp() {
		return ip;
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public static PeerProfile create(){
		PeerProfile profile = new PeerProfile();
		profile.peerId = UUID.randomUUID().toString();
		try {
			profile.ip = Inet4Address.getLocalHost().getHostAddress();
			profile.hostName = Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException("cant create the client profile for the peer");
		}
		return profile;		
	}

}
