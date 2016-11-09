package eu.vicci.process.graphiti.execution.debug.model;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;

import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugElement;
import eu.vicci.process.graphiti.execution.debug.model.ProcessThread;
import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariable;

public class ProcessStackFrame extends ProcessDebugElement implements IStackFrame {
	private List<AbstractProcessVariable> variables = new ArrayList<AbstractProcessVariable>();
	
	private ProcessThread thread;

	public ProcessStackFrame(IDebugTarget target, ProcessThread thread) {
		super(target);
		this.thread = thread;
	}

	@Override
	public String getModelIdentifier() {
		return null;
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
	}

	@Override
	public void stepOver() throws DebugException {		
	}

	@Override
	public void stepReturn() throws DebugException {		
	}

	@Override
	public boolean canResume() {
		return getThread().canResume();
	}

	@Override
	public boolean canSuspend() {
		return getThread().canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return getThread().isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		getThread().resume();		
	}

	@Override
	public void suspend() throws DebugException {
		getThread().resume();		
	}

	@Override
	public boolean canTerminate() {
		return getThread().canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return getThread().isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		getThread().terminate();		
	}

	@Override
	public IThread getThread() {
		return thread;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		return variables.toArray(new IVariable[variables.size()]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return variables.size() > 0;
	}

	@Override
	public int getLineNumber() throws DebugException {
		return -1;
	}

	@Override
	public int getCharStart() throws DebugException {
		return -1;
	}

	@Override
	public int getCharEnd() throws DebugException {
		return -1;
	}

	@Override
	public String getName() throws DebugException {
		return thread.getName();
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		return new IRegisterGroup[0];
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		return false;
	}
	
	/**
	 * Adds a list of variables to this StackFrame. 
	 * If this Stackframe contains a variable which matches with its name to a given var in the list, 
	 * only the value is updated.
	 * 
	 * @param variables
	 */
	public void addVariables(List<AbstractProcessVariable> variables) throws DebugException{
		for (AbstractProcessVariable var : variables)
			addVariable(var);
	}
	
	/**
	 * Adds a  variable to this StackFrame. 
	 * If this Stackframe contains a variable which matches with its name to the given var, 
	 * only the value is updated.
	 * 
	 * @param variable
	 */
	public synchronized void addVariable(AbstractProcessVariable variable) throws DebugException{
		boolean processed = false;
		for (AbstractProcessVariable var : variables) {
			if(var.getName().equals(variable.getName())){
				var.setValue(variable.getValue());
				var.fireChangeEvent(DebugEvent.CONTENT);
				processed = true;
				break;
			}				
		}
		if(!processed)
			variables.add(variable);		
	}
}
