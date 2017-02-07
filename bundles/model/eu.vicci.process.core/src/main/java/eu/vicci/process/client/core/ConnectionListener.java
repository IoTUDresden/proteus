package eu.vicci.process.client.core;

/**
 * Listener to receive changes on the connection state for {@link IProcessEngineClient}
 */
public interface ConnectionListener {
	
	/**
	 * called if the client gets connected
	 */
	void onConnect();
	/**
	 * called if the client gets disconnected
	 */
	void onDisconnect();

}
