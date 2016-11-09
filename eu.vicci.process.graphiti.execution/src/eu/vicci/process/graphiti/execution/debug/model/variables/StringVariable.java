package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariableGeneric;
import eu.vicci.process.graphiti.execution.debug.model.variables.StringValue;

public class StringVariable extends AbstractProcessVariableGeneric<StringValue> {

	public StringVariable(IDebugTarget target, String name) {
		super(target, name, "string type");
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		if(value instanceof StringValue)
			setValue((StringValue)value);
		else
			throwCantSetValue();		
	}
	
	@Override
	public void setValue(String expression) throws DebugException {
		setValue(new StringValue(getDebugTarget(), expression));
	}
}
