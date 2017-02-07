package eu.vicci.process.graphiti.validation.constraint;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.Identifiable;

public class NonEmptyIDConstraint extends SofiaConstraint {

    @Override
    public IStatus validate(IValidationContext context) {

        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();

        if (type == EMFEventType.NULL) {

            String id = null;

            if (object instanceof Identifiable)
                id = ((Identifiable) object).getId();

            if (id == null || id.length() == 0)
                return createFailureStatus(object, "ID could not be empty.");
        }

        return context.createSuccessStatus();
    }
}
