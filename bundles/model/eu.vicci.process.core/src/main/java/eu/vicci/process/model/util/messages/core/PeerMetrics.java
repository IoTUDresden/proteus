package eu.vicci.process.model.util.messages.core;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeerMetrics implements IWampMessage {
	
	@JsonProperty
	public String peerId;
	@JsonProperty
	public boolean hasBattery = false;
	@JsonProperty
	public Integer batteryStatus;
	

}
