package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariableGeneric;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortListValue;

/**
 * A var which holds a list value, which contains the ports
 */
public class PortListVariable extends AbstractProcessVariableGeneric<PortListValue> {
	
	public PortListVariable(IDebugTarget target, String name){
		super(target, name, "port list type");
		setValue(new PortListValue(target));
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		if(value instanceof PortListValue)
			setValue((PortListValue) value);
		else
			throwCantSetValue();
	}
}
