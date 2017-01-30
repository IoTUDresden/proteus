package eu.vicci.process.graphiti.execution.debug.model;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;

import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugElement;
import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugTarget;

/**
 * At the Moment the only process in debugging a process.
 * The process handles the termination of the debugging/debugging target
 */
public class ProcessDebugProcess extends ProcessDebugElement implements IProcess {
	private static final String label = "Process Execution Process";
	
	
	public ProcessDebugProcess(ProcessDebugTarget target) {
		super(target);
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
	public String getModelIdentifier() {
		return null;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public IStreamsProxy getStreamsProxy() {
		return null;
	}

	@Override
	public void setAttribute(String key, String value) {
		
	}

	@Override
	public String getAttribute(String key) {
		return null;
	}

	@Override
	public int getExitValue() throws DebugException {
		return 0;
	}

}
