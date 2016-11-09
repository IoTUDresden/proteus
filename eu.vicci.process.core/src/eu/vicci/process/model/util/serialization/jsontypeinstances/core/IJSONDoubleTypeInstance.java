package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONDoubleTypeInstance extends IJSONTypeInstance {

	double getValue();

	void setValue(double value);

	Double getValueAsObject();

	DoubleTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();
	
	@Override
	IJSONDoubleTypeInstance makeCopy();

}