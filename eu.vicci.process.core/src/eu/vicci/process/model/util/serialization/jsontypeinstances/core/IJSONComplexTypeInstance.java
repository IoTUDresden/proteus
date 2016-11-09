package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import java.util.List;

import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONComplexTypeInstance extends IJSONTypeInstance {

	List<IJSONTypeInstance> getSubTypes();

	void setSubTypes(List<IJSONTypeInstance> subTypes);

	ComplexTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();

	Object getValueAsObject();
	
	@Override
	IJSONComplexTypeInstance makeCopy();

}