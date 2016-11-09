package eu.vicci.process.graphiti.execution.debug.dispatcher;

import eu.vicci.process.graphiti.execution.debug.events.IDebugEvent;

public interface IEventProcessor {
	
	void handleEvent(IDebugEvent event);

}
