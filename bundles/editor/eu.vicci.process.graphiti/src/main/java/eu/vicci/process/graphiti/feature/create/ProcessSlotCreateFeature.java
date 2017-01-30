package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ProcessSlot;
import eu.vicci.process.model.sofia.SofiaFactory;

public class ProcessSlotCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ProcessSlotCreateFeature(IFeatureProvider fp) {

        super(fp, "ProcessSlot", "Create a ProcessSlot");
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

        ProcessSlot processSlot = SofiaFactory.eINSTANCE.createProcessSlot();
        getDiagram().eResource().getContents().add(processSlot);

        processSlot.setName("ProcessSlot");
        processSlot.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(processSlot);

        addGraphicalRepresentation(context, processSlot);
        ProcessStepCreateHelper.drawNameAndType(processSlot);

        return new Object[] { processSlot };
    }
}