package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariableGeneric;
import eu.vicci.process.graphiti.execution.debug.model.variables.StateValue;

/**
 * Variable represents the state
 */
public class StateVariable extends AbstractProcessVariableGeneric<StateValue> {
	
	/**
	 * Initial StateValue is 'inactive'
	 * @param target
	 * @param name
	 */
	public StateVariable(IDebugTarget target, String name){
		super(target, name, "state type");
		setValue("undefined");
	}

	@Override
	public void setValue(String expression) {
		setValue(new StateValue(getDebugTarget(), expression));
	}
	
	@Override
	public void setValue(IValue value) throws DebugException {
		setValue(value.getValueString());
	}
}
