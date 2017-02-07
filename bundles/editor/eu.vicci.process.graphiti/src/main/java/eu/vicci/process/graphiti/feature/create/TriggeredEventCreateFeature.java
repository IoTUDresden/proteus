package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.TriggeredEvent;

public class TriggeredEventCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public TriggeredEventCreateFeature(IFeatureProvider fp) {

        super(fp, "TriggeredEvent", "Create a TriggeredEvent");
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

        TriggeredEvent event = SofiaFactory.eINSTANCE.createTriggeredEvent();
        getDiagram().eResource().getContents().add(event);

        event.setName("TriggeredEvent");
        event.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(event);

        addGraphicalRepresentation(context, event);
        ProcessStepCreateHelper.drawNameAndType(event);

        return new Object[] { event };
    }
}