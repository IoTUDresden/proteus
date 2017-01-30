package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariableGeneric;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortValue;

/**
 * Represents the var which holds the value from process ports e.g. StartDataPorts
 */
public class PortVariable extends AbstractProcessVariableGeneric<PortValue> {
	
	public PortVariable(IDebugTarget target, String name) throws DebugException{
		super(target, name, "port type");	
		setValue(new PortValue(target));
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		if(value instanceof PortValue)
			setValue((PortValue) value);
		else
			throwCantSetValue();
	}

}
