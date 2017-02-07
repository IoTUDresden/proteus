package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.GoalInvoke;

public class NoGoalSetConstraint extends SofiaConstraint {
	private static final String msg = "No Goal is set";

	@Override
	public IStatus validate(IValidationContext context) {
        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type != EMFEventType.NULL || !(object instanceof GoalInvoke)) 
        	return context.createSuccessStatus();
        
        GoalInvoke goalInvoke = (GoalInvoke)object;
        return goalIsSet(goalInvoke) ? 
        		context.createSuccessStatus() : createFailureStatus(goalInvoke, msg);
	}
	
	private boolean goalIsSet(GoalInvoke goalInvoke){
		return goalInvoke.getGoal() != null && !goalInvoke.getGoal().isEmpty();		
	}

}
