package eu.vicci.process.graphiti.execution.debug.model;

import org.eclipse.debug.core.model.DebugElement;
import org.eclipse.debug.core.model.IDebugTarget;

public abstract class ProcessDebugElement extends DebugElement  {
	
	public ProcessDebugElement(IDebugTarget target) {
		super(target);
	}


}
