package eu.vicci.process.graphiti.execution.debug.events;

import eu.vicci.process.graphiti.execution.debug.events.IDebugEvent;

public abstract class AbstractEvent implements IDebugEvent {

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}
