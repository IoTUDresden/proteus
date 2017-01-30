package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

public interface IJSONStringTypeInstance extends IJSONTypeInstance {

	String getValue();

	void setValue(String value);

	String getValueAsObject();

	StringTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();
	
	@Override
	IJSONStringTypeInstance makeCopy();

}