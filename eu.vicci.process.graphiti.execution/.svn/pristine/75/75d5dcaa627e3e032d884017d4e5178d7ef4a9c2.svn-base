package eu.vicci.process.graphiti.execution.debug.model.variables;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessValue;
import eu.vicci.process.graphiti.execution.debug.model.variables.PortVariable;

/**
 * The value holds all ports for the var
 */
public class PortListValue extends AbstractProcessValue {
	private List<PortVariable> ports = new ArrayList<>();

	public PortListValue(IDebugTarget target) {
		super(target, "port list type");
	}
	
	@Override
	public IVariable[] getVariables() {
		return ports.toArray(new IVariable[ports.size()]);
	}
	
	public void addVariable(PortVariable variable) throws DebugException{
		PortVariable loc = getVarByName(ports, variable.getName());
		if(loc == null)
			ports.add(variable);
		else
			loc.setValue(variable.getValue());
		
		fireChangeEvent(DebugEvent.CONTENT);
	}
	
	@Override
	public boolean hasVariables() {
		return !ports.isEmpty();
	}
}
