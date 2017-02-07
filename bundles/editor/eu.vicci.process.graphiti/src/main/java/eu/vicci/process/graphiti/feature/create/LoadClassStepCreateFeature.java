package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.LoadClassStep;
import eu.vicci.process.model.sofia.SofiaFactory;

public class LoadClassStepCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public LoadClassStepCreateFeature(IFeatureProvider fp) {
        super(fp, "LoadClassStep", "Create a LoadClassStep");
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

        LoadClassStep step = SofiaFactory.eINSTANCE.createLoadClassStep();
        getDiagram().eResource().getContents().add(step);

        step.setId(EcoreUtil.generateUUID());
        step.setName("LoadClassStep");

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(step);

        addGraphicalRepresentation(context, step);
        ProcessStepCreateHelper.drawNameAndType(step);

        return new Object[] { step };
    }
}