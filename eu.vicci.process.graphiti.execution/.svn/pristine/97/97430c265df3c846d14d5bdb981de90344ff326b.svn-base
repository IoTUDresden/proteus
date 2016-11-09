package eu.vicci.process.graphiti.execution.debug.model.variables;

import java.util.List;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.swt.graphics.Image;

import eu.vicci.process.graphiti.execution.Activator;
import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugElement;

public abstract class AbstractProcessValue extends ProcessDebugElement implements IValue {
	private final String refTypeName;
	
	public AbstractProcessValue(IDebugTarget target, String refTypeName) {
		super(target);
		this.refTypeName = refTypeName;
	}

	@Override
	public String getModelIdentifier() {
		return null;
	}
	
	@Override
	public String getValueString() throws DebugException {
		return "";
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return refTypeName;
	}

	@Override
	public boolean isAllocated() throws DebugException {
		return true;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		return new IVariable[0];
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return false;
	}
	
	//FIXME how to change the default variable icons?
	public Image getImage() throws DebugException{
		return Activator.getDefault().getImage("media/debugger/localvariable_obj.png");
	}
	
	/**
	 * Returns a AbstractProcessVariable from a list with vars if the name of the var, matches to a given name.
	 * 
	 * @param vars
	 * @param name
	 * @return
	 */
	public static<T extends AbstractProcessVariable> T getVarByName(List<T> vars, String name){
		for (T abstractProcessVariable : vars)
			if(abstractProcessVariable.getName().equals(name))
				return abstractProcessVariable;
		return null;		
	}
}
