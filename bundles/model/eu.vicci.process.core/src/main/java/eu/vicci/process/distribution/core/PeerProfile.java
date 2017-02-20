package eu.vicci.process.distribution.core;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	@JsonProperty
	private List<String> devices;

	@JsonIgnore
	public String getPeerId() {
		return peerId;
	}
	
	@JsonIgnore
	public String getIp() {
		return ip;
	}
	
	@JsonIgnore
	public String getHostName() {
		return hostName;
	}
	
	@JsonIgnore
	public boolean isSuperPeer(){
		return isSuperPeer;
	}
	
	@JsonIgnore
	public void setIp(String ip){
		this.ip = ip;		
	}
	
	/**
	 * creates a new client profile. Attention: the IP must be set manually
	 * @param isSuperPeer
	 * @return
	 */
	public static PeerProfile create(boolean isSuperPeer){
		PeerProfile profile = new PeerProfile();
		profile.peerId = UUID.randomUUID().toString();
		profile.isSuperPeer = isSuperPeer;
		try {
			profile.hostName = Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			throw new RuntimeException("cant create the client profile for the peer", e);
		}
		return profile;		
	}

	public List<String> getDevices() {
		return devices;
	}

	public void setDevices(List<String> devices) {
		this.devices = devices;
	}

}
