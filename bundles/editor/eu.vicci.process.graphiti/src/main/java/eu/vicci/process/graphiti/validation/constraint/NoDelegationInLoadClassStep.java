package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.LoadClassStep;

public class NoDelegationInLoadClassStep extends SofiaConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type != EMFEventType.NULL || !(object instanceof LoadClassStep)) 
        	return context.createSuccessStatus();
        
        LoadClassStep step = (LoadClassStep)object;
        
        if(step.getDelegateClassName() == null || step.getDelegateClassName().isEmpty())
        	return createFailureStatus(step, 
        			"No delegate class name Set");
        
		return context.createSuccessStatus();
	}

}
