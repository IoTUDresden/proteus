package eu.vicci.process.model.util.messages;

import java.util.Calendar;
import java.util.UUID;

import eu.vicci.process.model.util.messages.core.IWampMessage;

public class WampMessage implements IWampMessage {	
	
	private long timestamp = Calendar.getInstance().getTimeInMillis();
	private String messageId = UUID.randomUUID().toString();

	@Override
	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timeStamp) {
		this.timestamp = timeStamp;
	}

	@Override
	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	


}
