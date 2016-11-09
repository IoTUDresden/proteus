package eu.vicci.process.graphiti.execution.debug.model;

import org.eclipse.debug.core.model.Breakpoint;

public class ProcessBreakpoint extends Breakpoint {
	public static final String ID = "eu.vicci.process.graphiti.execution.debug.model.processBreakpoint";
	
	private final String instanceId;
	private final String processId;
	
	public ProcessBreakpoint(String instanceId, String processId) {
		this.instanceId = instanceId;
		this.processId = processId;
		if(instanceId == null || processId == null)
			throw new IllegalArgumentException("instanceId or processId for a breakpoint cant be null");
	}

	@Override
	public String getModelIdentifier() {
		return instanceId;
	}
	
	public String getProcessId(){
		return processId;
	}
	
}
