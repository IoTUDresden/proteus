package eu.vicci.process.graphiti;

import java.util.Collections;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.model.ConstraintSeverity;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.AbstractConstraintDescriptor;
import org.eclipse.emf.validation.service.IConstraintDescriptor;

public abstract class SofiaConstraint extends AbstractModelConstraint implements
        IModelConstraint {

    public SofiaConstraint() {
        super();
    }

    protected IStatus createFailureStatus(EObject object, Set<EObject> objects, String message) {
        return new ConstraintStatus(this, object, message, objects);
    }

    protected IStatus createFailureStatus(EObject object, String message) {
        return new ConstraintStatus(this, object, message, Collections.singleton(object));
    }

    @Override
    public IConstraintDescriptor getDescriptor() {

        return new AbstractConstraintDescriptor() {

            @Override
            public boolean targetsTypeOf(EObject object) {
                return true;
            }

            @Override
            public boolean targetsEvent(Notification object) {
                return false;
            }

            @Override
            public int getStatusCode() {
                return 0;
            }

            @Override
            public ConstraintSeverity getSeverity() {
                return ConstraintSeverity.ERROR;
            }

            @Override
            public String getPluginId() {
                return "eu.vicci.process.graphiti";
            }

            @Override
            public String getName() {
                return "SofiaConstraint";
            }

            @Override
            public String getMessagePattern() {
                return "message";
            }

            @Override
            public String getId() {
                return "eu.vicci.process.graphiti.constraint.SofiaConstraint";
            }

            @Override
            public EvaluationMode<?> getEvaluationMode() {
                return EvaluationMode.BATCH;
            }

            @Override
            public String getDescription() {
                return "Constraint for validating process models";
            }

            @Override
            public String getBody() {
                return "";
            }
        };
    }

}