package eu.vicci.process.graphiti.execution.debug;

import eu.vicci.process.graphiti.execution.debug.dispatcher.EventDispatchJob;
import eu.vicci.process.graphiti.execution.debug.dispatcher.IEventProcessor;
import eu.vicci.process.graphiti.execution.debug.events.DebuggerStartedEvent;
import eu.vicci.process.graphiti.execution.debug.events.IDebugEvent;
import eu.vicci.process.graphiti.execution.debug.events.ResumedEvent;
import eu.vicci.process.graphiti.execution.debug.events.StateChangedEvent;
import eu.vicci.process.graphiti.execution.debug.events.TerminateEvent;
import eu.vicci.process.graphiti.execution.debug.events.TerminatedEvent;
import eu.vicci.process.graphiti.execution.interpreter.ProcessInterpreter;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class ProcessDebugger implements IDebugger, IEventProcessor {
	
	private EventDispatchJob dispatcher;
	private final ProcessInterpreter interpreter;
	
	public ProcessDebugger(final ProcessInterpreter interpreter) {
		this.interpreter = interpreter;
	}

	@Override
	public void loaded() {
		fireEvent(new DebuggerStartedEvent());		
	}

	@Override
	public void terminated() {
		fireEvent(new TerminatedEvent());		
	}

	@Override
	public void resumed() {
		fireEvent(new ResumedEvent());		
	}

	@Override
	public void handleEvent(IDebugEvent event) {
		if(event instanceof TerminateEvent)
			interpreter.terminate();		
	}
	
	public void processStateChanged(IStateChangeMessage message){
		fireEvent(new StateChangedEvent(message));
	}
	
	public void setEventDispatcher(final EventDispatchJob dispatcher){
		this.dispatcher = dispatcher;
	}	
	
	/**
	 * Pass an event to the {@link EventDispatchJob} where it is handled
	 * asynchronously.
	 * 
	 * @param event
	 *            event to handle
	 */
	private void fireEvent(final IDebugEvent event){
		dispatcher.addEvent(event);
	}

}
