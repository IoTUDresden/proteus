package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.StartPort;

public class NoIncomingTransitionConstraint extends SofiaConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type != EMFEventType.NULL || !(object instanceof Port)) 
        	return context.createSuccessStatus();
        
        Port port = (Port)object;
        
        if(!hasIncomingTransition(port))
        	return createFailureStatus(port, 
        			"No incoming transition for non optional startport");
        
		return context.createSuccessStatus();
	}
	
	/**
	 * Checks if there are incoming transitions, if the port is not optional and a startport.
	 */
	private boolean hasIncomingTransition(Port port){
		if(!(port instanceof StartPort))
			return true;
		if(port.getProcessStep().getParentstep() == null && port.getProcessStep() instanceof Process)
			return true;		
		return port.getInTransitions() != null || port.isOptional(); 
	}

}
