package eu.vicci.process.model.util.serialization.jsonprocesssteps;

import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONEscalationPort;

public class JSONEscalationPort extends JSONPort implements IJSONEscalationPort {
	private long escalationTime;
	
	public JSONEscalationPort() {
	}
	
	public JSONEscalationPort(EscalationPort escalationPort) {
		super(escalationPort);
		escalationTime = escalationPort.getEscalationTime();		
	}
	
	@Override
	public EscalationPort makePort() {
		EscalationPort port = (EscalationPort)super.makePort();
		port.setEscalationTime(escalationTime);
		return port;
	}
	
	@Override
	public long getEscalationTime() {
		return escalationTime;
	}
	
	@Override
	public void setEscalationTime(long escalationTime) {
		this.escalationTime = escalationTime;
	}

}
