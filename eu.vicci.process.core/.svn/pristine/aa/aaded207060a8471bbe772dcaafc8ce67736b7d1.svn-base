package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import java.util.Set;

import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONSetTypeInstance extends IJSONTypeInstance {
	
	Set<IJSONTypeInstance> getSubTypes();

	void setSubTypes(Set<IJSONTypeInstance> subTypes);
	
	@Override
	IJSONSetTypeInstance makeCopy();
	
	@Override
	SetTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

}