package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.SofiaFactory;

public class OrCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public OrCreateFeature(IFeatureProvider fp) {

        super(fp, "Or", "Create an Or");
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

        Or or = SofiaFactory.eINSTANCE.createOr();
        getDiagram().eResource().getContents().add(or);

        or.setId(EcoreUtil.generateUUID());
        or.setName("Or");// needed for renaming, don't delete

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(or);

        addGraphicalRepresentation(context, or);

        return new Object[] { or };
    }
}