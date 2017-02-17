package eu.vicci.process.model.util.messages;

import eu.vicci.process.model.util.messages.core.IWampResponse;

public class WampResponse extends WampMessage implements IWampResponse {
	private String requestId;
	private boolean completed = false;
	
	public WampResponse(String topic, String requestId) {
		this.requestId = requestId;
	}

	public WampResponse() {
		super();		
	}

	@Override
	public String getRequestId() {
		return requestId;
	}

	@Override
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	@Override
	public boolean isCompleted() {
		return completed;
	}

	@Override
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

}
