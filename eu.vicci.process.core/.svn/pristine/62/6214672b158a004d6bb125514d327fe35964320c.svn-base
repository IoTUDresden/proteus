package eu.vicci.process.model.util.messages.core;

import java.util.Map;

import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public interface IHumanTaskMessage extends IWampMessage {

	/**
	 * Gets the instance id of the human task process step
	 * @return
	 */
	String getHumanTaskInstanceId();

	/**
	 * Sets the instance id of the human task process step
	 */
	void setHumanTaskInstanceId(String humanTaskInstanceId);

	/**
	 * Gets the startdataports (key: port id, value: data port dto)
	 * @return
	 */
	Map<String, IJSONDataPortInstance> getStartDataPorts();

	/**
	 * Sets the startdataports (key: port id, value: data port dto)
	 */
	void setStartDataPorts(Map<String, IJSONDataPortInstance> startDataPorts);

	/**
	 * Gets the enddataports (key: port id, value: data port dto). In case of {@link IHumanTaskResponse} 
	 * this should contain all dataports with the new values
	 * @return
	 */
	Map<String, IJSONDataPortInstance> getEndDataPorts();

	/**
	 * Sets the enddataports (key: port id, value: data port dto). In case of {@link IHumanTaskResponse} 
	 * this should contain all dataports with the new values
	 */
	void setEndDataPorts(Map<String, IJSONDataPortInstance> endDataPorts);
	
	/**
	 * Gets the endcontrol ports for the human task process step
	 * (key: port id, value: port dto)
	 * @return
	 */
	Map<String, IJSONPortInstance> getEndControlPorts();
	
	/**
	 *  Sets the endcontrol ports for the human task process step
	 * (key: port id, value: port dto)
	 * @param endControlPorts
	 */
	void setEndControlPorts(Map<String, IJSONPortInstance> endControlPorts);

	/**
	 * Gets the name of the human task process
	 * @return
	 */
	String getName();

	/**
	 * Sets the name of the human task process
	 * @param name
	 */
	void setName(String name);

	/**
	 * Gets the description of the human task process step
	 * @return
	 */
	String getDescription();

	/**
	 * Sets the description of the human task process step
	 * @param description
	 */
	void setDescription(String description);
	
	
	/**
	 * Gets the {@link HumanTaskType} (e.g. 'warning', 'error', 'information')
	 * @return
	 */
	HumanTaskType getHumanTaskType();
	
	/**
	 * Sets the {@link HumanTaskType} (e.g. 'warning', 'error', 'information')
	 * @param type
	 */
	void setHumanTaskType(HumanTaskType type);
	
	/**
	 * Gets the {@link HumanTaskUseCase} (e.g. 'CoffeeMaking')
	 * @return
	 */
	HumanTaskUseCase getHumanTaskUseCase();
	
	/**
	 * Sets the {@link HumanTaskUseCase} (e.g. 'CoffeeMaking', 'General')
	 * @param useCase
	 */
	void setHumanTaskUseCase(HumanTaskUseCase useCase);

}