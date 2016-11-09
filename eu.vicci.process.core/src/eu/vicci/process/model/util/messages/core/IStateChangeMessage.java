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