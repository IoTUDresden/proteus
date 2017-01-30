package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONDataPort;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;


public interface IJSONDataPortInstance extends IJSONPortInstance {

	DataPortInstance makePortInstance(SofiaInstanceFactory factory);	
	
	IJSONTypeInstance getDataTypeInstance();
	
	void setDataTypeInstance(IJSONTypeInstance dataTypeInstance);
	
	@Override
	IJSONDataPort getPortType();
}