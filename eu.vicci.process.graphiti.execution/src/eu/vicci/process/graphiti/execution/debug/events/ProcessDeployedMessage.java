package eu.vicci.process.graphiti.execution.debug.events;

import eu.vicci.process.graphiti.execution.debug.events.AbstractEvent;
import eu.vicci.process.graphiti.execution.debug.events.IDebuggerEvent;

public class ProcessDeployedMessage extends AbstractEvent implements IDebuggerEvent {
	private String processId;
	
	public ProcessDeployedMessage(String processId) {
		this.processId = processId;
	}

	public String getProcessId() {
		return processId;
	}

}
