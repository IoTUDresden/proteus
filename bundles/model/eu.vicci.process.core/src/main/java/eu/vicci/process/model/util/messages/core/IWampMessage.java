package eu.vicci.process.model.util.messages.core;

public interface IWampMessage {
	
	/**
	 * Gets the timestamp, when the message was created.
	 * @return
	 */
	long getTimestamp();
	
	/**
	 * Gets the id of this message.
	 * @return
	 */
	String getMessageId();

}