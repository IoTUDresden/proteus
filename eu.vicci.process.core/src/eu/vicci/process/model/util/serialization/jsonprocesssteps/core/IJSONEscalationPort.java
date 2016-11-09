package eu.vicci.process.model.util.serialization.jsonprocesssteps.core;

import eu.vicci.process.model.sofia.EscalationPort;

public interface IJSONEscalationPort extends IJSONPort{

	EscalationPort makePort();

	long getEscalationTime();

	void setEscalationTime(long escalationTime);

}