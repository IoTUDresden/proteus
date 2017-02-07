package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.SofiaFactory;

public class HumanTaskCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public HumanTaskCreateFeature(IFeatureProvider fp) {

        super(fp, "HumanTask", "Create a Human Task");
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

    	HumanTask humanTask = SofiaFactory.eINSTANCE.createHumanTask();
        getDiagram().eResource().getContents().add(humanTask);

        humanTask.setName("HumanTask");
        humanTask.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(humanTask);

        addGraphicalRepresentation(context, humanTask);
        ProcessStepCreateHelper.drawNameAndType(humanTask);

        return new Object[] { humanTask };
    }
}