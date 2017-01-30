package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONEscalationPortInstance;

public class JSONEscalationPortInstance extends JSONPortInstance implements IJSONEscalationPortInstance {
	private String escalationReason;
	
	public JSONEscalationPortInstance() {
		super();
	}
	
	public JSONEscalationPortInstance(EscalationPortInstance escalationPortInstance) {
		super(escalationPortInstance);
		escalationReason = escalationPortInstance.getEscalationReason();		
	}
	
	@Override
	public EscalationPortInstance makePortInstance(SofiaInstanceFactory factory) {
		EscalationPortInstance port = (EscalationPortInstance)super.makePortInstance(factory);
		port.setEscalationReason(escalationReason);
		return port;
	}

	@Override
	public String getEscalationReason() {
		return escalationReason;
	}

	@Override
	public void setEscalationReason(String escalationReason) {
		this.escalationReason = escalationReason;
	}

}
