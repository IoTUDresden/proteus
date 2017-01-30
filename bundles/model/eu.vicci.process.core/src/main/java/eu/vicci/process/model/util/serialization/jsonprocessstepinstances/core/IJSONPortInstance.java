package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONPort;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
	@Type(value = IJSONDataPortInstance.class, name = "IJSONDataPortInstance"),
	@Type(value = IJSONEscalationPortInstance.class, name = "IJSONEscalationPortInstance")
	})
public interface IJSONPortInstance {

	String getType();

	void setType(String type);

	State getExecutionState();

	void setExecutionState(State executionState);

	String getInstanceId();

	void setInstanceId(String instanceId);

	int getInstanceNumber();

	void setInstanceNumber(int instanceNumber);

	List<IJSONTransitionInstance> getOutTransitions();

	void setOutTransitions(List<IJSONTransitionInstance> outTransitions);

	IJSONTransitionInstance getInTransitions();

	void setInTransitions(IJSONTransitionInstance inTransitions);

	String getName();

	void setName(String name);

	String getTypeId();

	void setTypeId(String typeId);

	PortInstance makePortInstance(SofiaInstanceFactory factory);

	PortInstanceType getPortInstanceType();

	void setPortInstanceType(PortInstanceType portInstanceType);

	IJSONPort getPortType();

	void setPortType(IJSONPort portType);
	
	/**
	 * Gets a value which indicates, if the portinstance will activate or deactivate.
	 * (at the moment only necessary in HumanTask)
	 * @return
	 */
	boolean getDoDeactivation();
	
	/**
	 *  Sets a value which indicates, if the portinstance will activate or deactivate.
	 * (at the moment only necessary in HumanTask)
	 */
	void setDoDeactivation(boolean doDeactivation);
}