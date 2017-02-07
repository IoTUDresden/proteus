package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SeMiWaInvoke;
import eu.vicci.process.model.sofia.SofiaFactory;

public class SeMiWaInvokeCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     * 
     * @param fp
     *            the feature provider for which the feature is created
     */
    public SeMiWaInvokeCreateFeature(IFeatureProvider fp) {
        super(fp, "SeMiWaInvoke", "Create a SeMiWaInvoke");
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

        SeMiWaInvoke invoke = SofiaFactory.eINSTANCE.createSeMiWaInvoke();
        getDiagram().eResource().getContents().add(invoke);

        invoke.setId(EcoreUtil.generateUUID());
        invoke.setName("SeMiWaInvoke");

        Object target = getBusinessObjectForPictogramElement(context
                .getTargetContainer());
        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(invoke);

        addGraphicalRepresentation(context, invoke);
        ProcessStepCreateHelper.drawNameAndType(invoke);

        return new Object[] { invoke };
    }
}