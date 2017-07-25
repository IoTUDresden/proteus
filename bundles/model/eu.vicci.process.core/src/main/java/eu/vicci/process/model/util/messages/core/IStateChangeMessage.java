package eu.vicci.process.model.util.messages.core;

import java.util.Map;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

/**
 * Message for process state changes
 */
public interface IStateChangeMessage extends IWampMessage {
	
	/**
	 * The Id of the peer which sends this message. If null, the SuperPeer is sending this message.
	 * @return
	 */
	String getPeerId();
	
	
	/**
	 * Gets the instance of the original process, if this process is a remote executing copy
	 * @return
	 */
	String getOriginalProcessInstanceId();

	/**
	 * The instance id for this process
	 * @return
	 */
	String getInstanceId();

	String getModelId();

	/**
	 * The instance id of the root process
	 * @return
	 */
	String getProcessInstanceId();

	String getProcessModelId();

	State getState();

	Map<String, IJSONDataPortInstance> getStartDataPorts();

	Map<String, IJSONDataPortInstance> getEndDataPorts();
	
	/**
	 * Gets the start control ports mapped to their states, with their model id, mapped to their states
	 * @return
	 */
	Map<String, IJSONPortInstance> getStartControlPorts();
	
	/**
	 * Gets the end control ports mapped to their states, with their model id, mapped to their states
	 * @return
	 */
	Map<String, IJSONPortInstance> getEndControlPorts();
	
	/**
	 * Gets the default Process Id without _Instance and instance number suffix
	 */
	String getProcessId();	
	
	/**
	 * gets the name of the process
	 * @return
	 */
	String getProcessName();
}