package eu.vicci.process.model.util.serialization.jsonprocesssteps.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofia.Port;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
	@Type(value = IJSONDataPort.class, name = "IJSONDataPort"),
	@Type(value = IJSONEscalationPort.class, name = "IJSONDataPort")
})
public interface IJSONPort {

	String getType();

	void setType(String type);

	String getId();

	void setId(String Id);

	List<IJSONTransition> getOutTransitions();

	void setOutTransitions(List<IJSONTransition> outTransitions);

	IJSONTransition getInTransitions();

	void setInTransitions(IJSONTransition inTransitions);

	String getName();

	void setName(String name);

	PortType getPortType();

	void setPortType(PortType portType);

	Port makePort();

	boolean isOptional();

	void setOptional(boolean isOptional);
	
	/**
	 * Gets the Description of the port
	 * @return
	 */
	String getDescription();
	
	/**
	 * Sets the description for the port
	 */
	void setDescription(String description);

}