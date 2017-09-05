package eu.vicci.process.model.util.messages.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

//FIXME move to other package and extend WampMessage
public class PeerMetrics implements IWampMessage {
	
	@JsonProperty
	public String peerId;
	@JsonProperty
	public boolean hasBattery = false;
	@JsonProperty
	public Integer batteryStatus;	
	
	@JsonIgnore
	public long getTimestamp() {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public void setTimestamp(long timestamp) {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public String getMessageId() {
		throw new UnsupportedOperationException();
	}
	
	@JsonIgnore
	public void setMessageId(String messageId) {
		throw new UnsupportedOperationException();
	}
	

}
