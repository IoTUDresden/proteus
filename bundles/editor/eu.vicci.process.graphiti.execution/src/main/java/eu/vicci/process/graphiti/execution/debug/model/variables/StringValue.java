package eu.vicci.process.graphiti.execution.debug.model.variables;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;

import eu.vicci.process.graphiti.execution.debug.model.variables.AbstractProcessValue;

public class StringValue extends AbstractProcessValue {
	private String value;

	public StringValue(IDebugTarget target) {
		this(target, null);
	}
	
	public StringValue(IDebugTarget target, String value) {
		super(target, "string type");
		this.value = value;
	}
	
	@Override
	public String getValueString() throws DebugException {
		return value;
	}
	
	public void setValue(String value){
		this.value = value;
		fireChangeEvent(DebugEvent.CONTENT);
	}
}
