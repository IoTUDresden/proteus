package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONBooleanTypeInstance extends IJSONTypeInstance{

	boolean getValue();

	void setValue(boolean value);

	Boolean getValueAsObject();

	BooleanTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();
	
	@Override
	IJSONBooleanTypeInstance makeCopy();

}