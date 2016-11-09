package eu.vicci.process.model.util;

import java.util.Map;

import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class ProcessStartRequest {
	
	private String processInstanceId;
	private boolean runInLoop;
	private Map<String, IJSONTypeInstance> ports;

	public ProcessStartRequest() {
	}
	
	public ProcessStartRequest(String processInstanceId, Map<String, IJSONTypeInstance> ports, boolean runInLoop) {
		super();
		this.processInstanceId = processInstanceId;
		this.ports = ports;
		this.runInLoop = runInLoop;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public Map<String, IJSONTypeInstance> getPorts() {
		return ports;
	}

	public boolean getRunInLoop() {
		return runInLoop;
	}
}
