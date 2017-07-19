package eu.vicci.process.client.core;

import java.util.List;
import java.util.Map;

import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.util.messages.core.CompensationRequest;
import eu.vicci.process.model.util.messages.core.FeedbackServiceListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.IWampMessage;
import eu.vicci.process.model.sofia.Process;

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
	 * Adds a {@link FeedbackServiceListener} to receive updates for a feedback service (e.g. reexecution on an other peer)
	 * @param request
	 */
	void addFeedbackServiceListener(FeedbackServiceListener listener);
	
	/**
	 * Removes the {@link FeedbackServiceListener}
	 * @param request
	 */
	void removeFeedbackServiceListener(FeedbackServiceListener listener);

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
	
	/**
	 * Publish a {@link CompensationRequest}. Forces the engine to re-execute a process on an other peer.
	 * @param request
	 */
	void publishCompensationRequest(CompensationRequest request);
	
	/**
	 * Deploys the process on a peer with the given id. Same as
	 * {@link #deployProcess(Process)} but the process is deployed on the peer
	 * with the given id.
	 * 
	 * @param clientId
	 * @param process
	 * @return
	 */
	String deployProcessRemote(String peerId, Process process);

	/**
	 * Deploys an process instance for the given process on a peer. Same as
	 * {@link #deployProcessInstance(String)} but the instance is deployed on
	 * the peer with the given id.
	 * 
	 * @param peerId
	 * @param processId
	 * @return
	 */
	String deployProcessInstanceRemote(String peerId, String processId);

	/**
	 * Starts the instance on a peer. Same as
	 * {@link #startProcessInstance(String, Map)} but the instance is started on
	 * the peer with the given id.
	 * 
	 * @param peerId
	 * @param processInstanceId
	 * @param inputParameters
	 * @return
	 */
	String startProcessInstanceRemote(String peerId, String processInstanceId,
			Map<String, DataTypeInstance> inputParameters);
	
	/**
	 * Gets all registered {@link PeerProfile}s which are registered on the SuperPeer
	 * @return
	 */
	List<PeerProfile> getRegisteredPeers();
	
	/**
	 * Subscribe to a generic topic
	 * @param topicId
	 * @param receiver
	 * @param paramClass
	 */
	public <T extends IWampMessage> void subscribeToTopic(String topicId, IMessageReceiver<T> receiver, Class<T> paramClass);

}