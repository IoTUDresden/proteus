package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.Nameable;

public class NonEmptyNameConstraint extends SofiaConstraint {

    @Override
    public IStatus validate(IValidationContext context) {

        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type == EMFEventType.NULL) {

            String name = null;

            if (object instanceof Nameable)
                name = ((Nameable) object).getName();

            if (name == null || name.length() == 0)
                return createFailureStatus(object, "Name could not be empty.");
        }

        return context.createSuccessStatus();
    }
}
