package eu.vicci.process.model.util;

import java.io.Serializable;

import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.State;

public class ProcessInstanceInfo extends ProcessInfo implements Serializable, IProcessInstanceInfo {
	private static final long serialVersionUID = 5119467857894920870L;
	private State state;
	private String processInstanceId;
	private int instanceNumber;
	
	public ProcessInstanceInfo() {	}
	
	public ProcessInstanceInfo(String processInstanceId, int instanceNumber, State state, String processId, String processName,
			String processType, String processDescription) {
		super(processId, processName, processType, processDescription);
		this.state = state;
		this.processInstanceId = processInstanceId;
		this.instanceNumber = instanceNumber;
	}
	
	public ProcessInstanceInfo(ProcessInstance p) {
		this(p.getInstanceId(), 
				p.getInstancenumber(),
				p.getExecutionState(),
				p.getProcessStepType().getId(), 
				p.getProcessStepType().getName(), 
				p.getProcessStepType().getType(), 
				p.getProcessStepType().getDescription());	
	}

	@Override
	public State getState() {
		return state;
	}

	@Override
	public void setState(State state) {
		this.state = state;
	}

	@Override
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Override
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	public int getInstanceNumber() {
		return instanceNumber;
	}

}
