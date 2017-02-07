package eu.vicci.process.graphiti.execution.debug.model;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;

import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugElement;
import eu.vicci.process.graphiti.execution.debug.model.ProcessStackFrame;
import eu.vicci.process.graphiti.execution.debug.model.ProcessThread;

/**
 * Thread for executing a process. A process in this case is the whole process modeled in a diagram file.
 */
public class ProcessThread extends ProcessDebugElement implements IThread {
	private final String processId;	
	private final String name;
	private final String debuggerName; //visible in the debugger
	private ProcessStackFrame stackFrame;
	
	public ProcessThread(IDebugTarget target, String processId) {
		this(target, processId, processId);
	}
	
	public ProcessThread(IDebugTarget target, String processId, String name) {
		super(target);
		this.processId = processId;
		this.name = name;
		debuggerName = createDebuggerName();
		stackFrame = new ProcessStackFrame(target, this);		
	}

	@Override
	public String getModelIdentifier() {
		return null;
	}

	@Override
	public boolean canResume() {
		return getDebugTarget().canResume();
	}

	@Override
	public boolean canSuspend() {
		return getDebugTarget().canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return false;
	}

	@Override
	public void resume() throws DebugException {
		getDebugTarget().resume();		
	}

	@Override
	public void suspend() throws DebugException {
		getDebugTarget().suspend();		
	}

	@Override
	public boolean canStepInto() {
		return false;
	}

	@Override
	public boolean canStepOver() {
		return false;
	}

	@Override
	public boolean canStepReturn() {
		return false;
	}

	@Override
	public boolean isStepping() {
		return false;
	}

	@Override
	public void stepInto() throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", "stepInto() not supported"));	
	}

	@Override
	public void stepOver() throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", "stepOver() not supported"));		
	}

	@Override
	public void stepReturn() throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", "stepReturn() not supported"));		
	}

	@Override
	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		getDebugTarget().terminate();		
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		return new IStackFrame[]{stackFrame};
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		return stackFrame != null;
	}

	@Override
	public int getPriority() throws DebugException {
		return 0;
	}

	@Override
	public ProcessStackFrame getTopStackFrame() {
		return stackFrame;
	}

	@Override
	public String getName() {
		return debuggerName;
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		return null;
	}	
	
	@Override
	public int hashCode() {		
		return processId.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof ProcessThread))
			return false;
		ProcessThread t2 = (ProcessThread) obj;
		String t2Id = null;
		try {
			t2Id = t2.getVicciProcessId();
		} catch (Exception e) {
		}		
		return processId.equals(t2Id);
	}
	
	/**
	 * gets the process id 
	 * @return
	 */
	public String getVicciProcessId(){
		return processId;
	}
	
	/**
	 * gets the name of the process (e.g. SwitchLightOn)
	 * @return
	 */
	public String getVicciProcessName(){
		return name;
	}
	
	private String createDebuggerName(){
		if(processId.equals(name))
			return processId;
		else
			return name + "  ( " + processId + " )";		
	}
}
