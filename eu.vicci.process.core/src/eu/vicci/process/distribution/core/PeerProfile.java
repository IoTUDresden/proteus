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
	
	@JsonProperty
	private boolean isSuperPeer;

	
	public String getPeerId() {
		return peerId;
	}

	public String getIp() {
		return ip;
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public boolean isSuperPeer(){
		return isSuperPeer;
	}
	
	public static PeerProfile create(boolean isSuperPeer){
		PeerProfile profile = new PeerProfile();
		profile.peerId = UUID.randomUUID().toString();
		profile.isSuperPeer = isSuperPeer;
		try {
			profile.ip = Inet4Address.getLocalHost().getHostAddress();
			profile.hostName = Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException("cant create the client profile for the peer");
		}
		return profile;		
	}

}
