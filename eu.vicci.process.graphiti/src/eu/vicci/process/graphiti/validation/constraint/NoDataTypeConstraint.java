package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.DataPort;

public class NoDataTypeConstraint extends SofiaConstraint {

	@Override
	public IStatus validate(IValidationContext context) {
        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type != EMFEventType.NULL || !(object instanceof DataPort)) 
        	return context.createSuccessStatus();
        DataPort port = (DataPort)object;
        if(!dataTypeIsSet(port))
        	return createFailureStatus(port, "No DataType is set");        
        return context.createSuccessStatus();
	}
	
	//checks if a datatype is set
	private boolean dataTypeIsSet(DataPort port){
		return port.getPortDatatype() != null;
	}

}
