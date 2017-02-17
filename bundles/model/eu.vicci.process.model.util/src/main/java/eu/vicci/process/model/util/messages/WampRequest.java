package eu.vicci.process.model.util.messages;

import eu.vicci.process.model.util.messages.core.IWampRequest;

public class WampRequest extends WampMessage implements IWampRequest {	
	private boolean responded = false;
	
	public WampRequest(String topic, boolean responded) {
		this.responded = responded;		
	}
	
	public WampRequest() {	}
	
	@Override
	public boolean isResponded() {
		return responded;
	}

	@Override
	public void setResponded(boolean responded) {
		this.responded = responded;
	}
}
