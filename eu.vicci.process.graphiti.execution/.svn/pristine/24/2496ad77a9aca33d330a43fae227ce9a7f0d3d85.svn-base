package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.model.IDebugTarget;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessValue;
import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariable;

public abstract class AbstractProcessVariableGeneric<T extends AbstractProcessValue> extends AbstractProcessVariable {
	
	private T value;

	public AbstractProcessVariableGeneric(IDebugTarget target, String name, String referenceName) {
		super(target, name, referenceName);
	}
	
	public void setValue(T value) {
		this.value = value;		
	}
	
	@Override
	public T getValue() {
		return value;
	}

}
