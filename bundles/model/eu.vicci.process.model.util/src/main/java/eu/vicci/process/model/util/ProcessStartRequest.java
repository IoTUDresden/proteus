package eu.vicci.process.model.util;

import java.util.Map;

import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class ProcessStartRequest {
	
	private String processInstanceId;
	private boolean runInLoop;
	private Map<String, IJSONTypeInstance> ports;
	private String runningForInstanceId;

	public ProcessStartRequest() {
	}
	
	public ProcessStartRequest(String processInstanceId, Map<String, IJSONTypeInstance> ports, boolean runInLoop) {
		this(processInstanceId, null, ports, runInLoop);
	}
	
	public ProcessStartRequest(String processInstanceId, String runningForInstance, 
			Map<String, IJSONTypeInstance> ports, boolean runInLoop){
		super();
		this.processInstanceId = processInstanceId;
		this.ports = ports;
		this.runInLoop = runInLoop;
		this.runningForInstanceId = runningForInstance;		
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

	public String getRunningForInstanceId() {
		return runningForInstanceId;
	}

}
