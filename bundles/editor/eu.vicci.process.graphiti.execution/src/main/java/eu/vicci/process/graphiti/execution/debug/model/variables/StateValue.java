package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessValue;

public class StateValue extends AbstractProcessValue {
	private String value;
	
	public StateValue(IDebugTarget target, String value) {
		super(target, "state type");
		this.value = value;		
	}
	
	@Override
	public String getValueString() throws DebugException {
		return value;
	}
}
