package eu.vicci.process.model.util.messages;

import org.eclipse.emf.ecore.util.EcoreUtil;

import eu.vicci.process.model.util.messages.core.IWampMessage;

public class WampMessage implements IWampMessage {	
	private String topic;
	private String messageId = EcoreUtil.generateUUID();
	private long timeStamp = System.currentTimeMillis();
	
	public WampMessage(String topic) {
		this.topic = topic;
	}
	
	public WampMessage() {	}

	@Override
	public String getTopic() {
		return topic;
	}

	@Override
	public String getMessageId() {
		return messageId;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}
}
