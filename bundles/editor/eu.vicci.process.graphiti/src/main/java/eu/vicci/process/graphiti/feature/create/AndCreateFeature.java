package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SofiaFactory;

public class AndCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public AndCreateFeature(IFeatureProvider fp) {

        super(fp, "And", "Create an And");
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

        And and = SofiaFactory.eINSTANCE.createAnd();
        getDiagram().eResource().getContents().add(and);

        and.setId(EcoreUtil.generateUUID());
        and.setName("And");// needed for renaming, don't delete

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(and);

        addGraphicalRepresentation(context, and);

        return new Object[] { and };
    }
}