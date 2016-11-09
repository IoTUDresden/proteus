package eu.vicci.process.graphiti.execution.debug.events;

import eu.vicci.process.graphiti.execution.debug.events.AbstractEvent;
import eu.vicci.process.graphiti.execution.debug.events.IDebuggerEvent;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class StateChangedEvent extends AbstractEvent implements IDebuggerEvent {
	
	private final IStateChangeMessage message;
	
	public StateChangedEvent(final IStateChangeMessage message) {
		this.message = message;
	}
	
	public IStateChangeMessage getMessage(){
		return message;
	}

}
