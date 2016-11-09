package eu.vicci.process.graphiti.execution.debug.model.variables;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IVariable;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessValue;
import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessVariable;

/**
 * Value for a port.
 * A port can contain a 'state', 'value', 'datatype'
 */
public class PortValue extends AbstractProcessValue{
//	private static final Logger logger = LoggerFactory.getLogger(PortValue.class);
	
	//variable for ports e.g. state, value, ...
	private List<AbstractProcessVariable> variables = new ArrayList<AbstractProcessVariable>();

	public PortValue(IDebugTarget target) {
		super(target, "port type");
	}
	
	@Override
	public AbstractProcessVariable[] getVariables() {
		return variables.toArray(new AbstractProcessVariable[variables.size()]);
	}
	
	@Override
	public boolean hasVariables() {
		return !variables.isEmpty();
	}
	
	/**
	 * Adds a new var, only if no other var with the same name already exists in this value.
	 * Otherwise only the value is updated.
	 * 
	 * @param variable
	 */
	public void addVariable(AbstractProcessVariable variable) throws DebugException{
		IVariable var = getVarByName(variables, variable.getName());
		if(var == null)
			variables.add(variable);
		else
			var.setValue(variable.getValue());
		
		fireChangeEvent(DebugEvent.CONTENT);
	}
}
