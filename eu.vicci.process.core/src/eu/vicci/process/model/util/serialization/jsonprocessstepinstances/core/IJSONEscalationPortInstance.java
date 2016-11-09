package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONEscalationPortInstance extends IJSONPortInstance  {

	EscalationPortInstance makePortInstance(SofiaInstanceFactory factory);

	String getEscalationReason();

	void setEscalationReason(String escalationReason);

}