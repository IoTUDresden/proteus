package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.Transition;

public class NoTargetPortConstraint extends SofiaConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type != EMFEventType.NULL || !(object instanceof Transition)) 
        	return context.createSuccessStatus();
        return validate((Transition)object, context);
	}
	
	private IStatus validate(Transition transition, IValidationContext context){
        if(transition.getSourcePort() == null)
        	return createFailureStatus(transition, "Transition has no source port");
        if(transition.getTargetPort() == null)
        	return createFailureStatus(transition, "Transition has no target port");        
		return context.createSuccessStatus();		
	}

}
