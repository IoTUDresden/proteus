package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

import eu.vicci.process.graphiti.execution.debug.model.ProcessDebugElement;

public abstract class AbstractProcessVariable extends ProcessDebugElement implements IVariable {
//	private static final Logger logger = LoggerFactory.getLogger(AbstractProcessVariable.class);
	
	private final String name;
	private final String referenceName;

	
	public AbstractProcessVariable(IDebugTarget target, String name, String referenceName) {
		super(target);
		this.name = name;
		this.referenceName = referenceName;
	}

	@Override
	public String getModelIdentifier() {
		return null;
	}
	
	@Override
	public void setValue(String expression) throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, "eu.vicci.process.execution.debug",
				"set variable value from String is not supported"));		
	}
	
	@Override
	public abstract void setValue(IValue value) throws DebugException;
	
	@Override
	public abstract IValue getValue();

	@Override
	public boolean supportsValueModification() {
		return false;
	}

	@Override
	public boolean verifyValue(String expression) throws DebugException {
		return false;
	}

	@Override
	public boolean verifyValue(IValue value) throws DebugException {
		return false;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return referenceName;
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		return false;
	}
	
	protected void throwCantSetValue() throws DebugException {
		throw new DebugException(new Status(IStatus.ERROR, "eu.vicci.process.execution.debug", 
				"Cant set value from IValue: " + name));			
	}
}
