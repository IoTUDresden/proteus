package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofia.SofiaFactory;

public class GoalInvokeCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public GoalInvokeCreateFeature(IFeatureProvider fp) {

        super(fp, "GoalInvoke", "Create a Goal Invoke");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateContext context) {
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return bo instanceof CompositeStep;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] create(ICreateContext context) {

    	GoalInvoke goalInvoke = SofiaFactory.eINSTANCE.createGoalInvoke();
        getDiagram().eResource().getContents().add(goalInvoke);

        goalInvoke.setName("GoalInvoke");
        goalInvoke.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(goalInvoke);

        addGraphicalRepresentation(context, goalInvoke);
        ProcessStepCreateHelper.drawNameAndType(goalInvoke);

        return new Object[] { goalInvoke };
    }

}
