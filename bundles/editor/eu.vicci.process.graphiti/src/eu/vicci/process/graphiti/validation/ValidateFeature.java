package eu.vicci.process.graphiti.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.ConstraintStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ValidateFeature extends AbstractCustomFeature {

    private IFeatureProvider featureProvider;

    public ValidateFeature(IFeatureProvider featureProvider) {

        super(featureProvider);
        this.featureProvider = featureProvider;
    }

    @Override
    public boolean canUndo(IContext arg0) {

        return false;
    }

    void flatten(IStatus status, Vector<ConstraintStatus> result) {

        if (status == null)
            return;

        if (status instanceof ConstraintStatus)
            result.add((ConstraintStatus) status);

        for (IStatus s : status.getChildren())
            flatten(s, result);
    }

    @Override
    public void execute(IContext context) {

        IBatchValidator validator =
                (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
        validator.setIncludeLiveConstraints(true);
        Diagram diagram = getDiagram();

        List<EObject> objects = new ArrayList<EObject>();
        EList<Shape> shapes = diagram.getChildren();
        for (Shape shape : shapes) {
            EObject object = (EObject) getBusinessObjectForPictogramElement(shape);
            if (object != null)
                objects.add(object);
        }
        Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

        Vector<ConstraintStatus> validationStatus = new Vector<ConstraintStatus>();

        IStatus state = validator.validate(objects);
        flatten(state, validationStatus);

        ValidationTreeDialog dialog =
                new ValidationTreeDialog(getFeatureProvider(), shell, validationStatus);
        dialog.open();
    }

    @Override
    public boolean hasDoneChanges() {

        return false;
    }

    @Override
    public boolean isAvailable(IContext context) {

        return true;
    }

    @Override
    public String getName() {

        return "Validate";
    }

    @Override
    public String getDescription() {

        return "Validate Description";
    }

    @Override
    public IFeatureProvider getFeatureProvider() {

        return featureProvider;
    }

    @Override
    public boolean canExecute(ICustomContext arg0) {

        return true;
    }

    @Override
    public void execute(ICustomContext arg0) {

    }
}
