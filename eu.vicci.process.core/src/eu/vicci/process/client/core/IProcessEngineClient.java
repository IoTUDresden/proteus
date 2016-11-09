package eu.vicci.process.client.core;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;

public interface IProcessEngineClient extends IProcessManager {

	/**
	 * Adds a listener to receive events, if the client gets disconnected or
	 * connected
	 * 
	 * @param listener
	 */
	void addConnectionListener(ConnectionListener listener);

	/**
	 * removes the listener
	 * 
	 * @param listener
	 */
	void removeConnectionListener(ConnectionListener listener);

	/**
	 * Connect to server
	 * 
	 * @return
	 */
	boolean connect();

	/**
	 * closes the connection
	 */
	void close();

	/**
	 * Returnes the connected state.
	 * 
	 * @return
	 */
	boolean isConnected();

	/**
	 * 
	 * Registers this client with all its possible procedure ids by the server.
	 * The router in the Server handles all the connection stuff. Only possible
	 * procedure ids are needed, so that you know which rpc you can call on a
	 * specific client.
	 * @return {@link ReplyState}
	 */
	String registerProcessExecutionClient();

	String getUuid();

	String getIp();

	String getPort();

	boolean isServer();

	String getName();

	void publish(String topic, Object payload);

	void publishHumanTask(IHumanTaskRequest payload);

}