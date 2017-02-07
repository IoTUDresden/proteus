package eu.vicci.process.graphiti.execution.debug.dispatcher;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;

import eu.vicci.process.graphiti.execution.debug.dispatcher.IEventProcessor;
import eu.vicci.process.graphiti.execution.debug.events.IDebugEvent;
import eu.vicci.process.graphiti.execution.debug.events.IDebuggerEvent;
import eu.vicci.process.graphiti.execution.debug.events.IModelRequest;

/**
 * The Dispatcher handles async events. The events are processed in FIFO.
 * Don´t forget to {@link #terminate()} the Dispatcher after use.
 *
 */
public class EventDispatchJob extends Job {
	private static final String name = "Process Debugger event dispatcher";

	private final List<IDebugEvent> events = new ArrayList<>();
	private final IEventProcessor host;
	private final IEventProcessor debugger;

	private boolean isTerminated = false;

	/**
	 * 
	 * @param host
	 *            handles {@link IDebuggerEvent}
	 * @param debugger
	 *            handles {@link IModelRequest}
	 */
	public EventDispatchJob(final IEventProcessor host, final IEventProcessor debugger) {
		super(name);
		this.host = host;
		this.debugger = debugger;

		setSystem(true);
	}

	/**
	 * Add a event. The event is handled async in another thread.
	 * @param event
	 */
	public void addEvent(final IDebugEvent event) {
		synchronized (events) {
			events.add(event);
		}

		synchronized (this) {
			notifyAll();
		}
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		while (!isTerminated) 
			runTillTerminated(monitor);		
		return Status.OK_STATUS;
	}
	
	/**
	 * Terminates the dispatcher.
	 */
	public void terminate(){
		isTerminated = true;
		synchronized(this){
			notifyAll();
		}
	}
	
	private void runTillTerminated(IProgressMonitor monitor){
		if(events.isEmpty())
			waitForEvents();
		if(!monitor.isCanceled()){
			IDebugEvent event = removeFirstEvent();			
			if(event != null)
				handleEvent(event);
		}
		else
			terminate();			
	}
	
	private void handleEvent(IDebugEvent event){
		if(event == null)
			return;
		if (event instanceof IDebuggerEvent)
			host.handleEvent(event);

		else if (event instanceof IModelRequest)
			debugger.handleEvent(event);

		else
			throw new RuntimeException("Unknown event detected: " + event);
		
	}
	
	private IDebugEvent removeFirstEvent(){
		IDebugEvent event = null;
		synchronized(events){
			if(!events.isEmpty())
				event = events.remove(0);				
		}
		return event;
	}
	
	private void waitForEvents(){
		synchronized (this) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}

}
