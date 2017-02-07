package eu.vicci.process.graphiti.validation.constraint;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;

import eu.vicci.process.graphiti.SofiaConstraint;
import eu.vicci.process.model.sofia.Identifiable;

public class UniqueIDConstraint extends SofiaConstraint {

    @Override
    public IStatus validate(IValidationContext context) {

        EObject object = context.getTarget();
        EMFEventType type = context.getEventType();
        @SuppressWarnings("unchecked")
        Map<String, EObject> objectMap = (Map<String, EObject>) context.getCurrentConstraintData();
        if (objectMap == null) {
            objectMap = new HashMap<String, EObject>();
            context.putCurrentConstraintData(objectMap);
        }

        if (type == EMFEventType.NULL) {

            if (object instanceof Identifiable) {
                String id = ((Identifiable) object).getId();
                if (id != null && id.length() != 0) {
                    if (objectMap.containsKey(id) && objectMap.get(id) != object)
                        return createFailureStatus(object, Collections.singleton(objectMap.get(id)), "ID not unique.");
                    else
                        objectMap.put(id, object);
                }
            }
        }

        return context.createSuccessStatus();
    }
}
