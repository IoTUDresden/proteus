package eu.vicci.process.model.util.messages.core;

/**
 * Interface for receiving messages which are received from subscriptions
 */
public interface IMessageReceiver<T extends IWampMessage> {

	/**
	 * The incoming message.
	 * 
	 * @param arg
	 *            the values or arguments received
	 */
	void onMessage(T arg);

}
