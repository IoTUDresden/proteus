package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONIntegerTypeInstance extends IJSONTypeInstance {

	int getValue();

	void setValue(int value);

	Integer getValueAsObject();

	IntegerTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();
	
	@Override
	IJSONIntegerTypeInstance makeCopy();

}