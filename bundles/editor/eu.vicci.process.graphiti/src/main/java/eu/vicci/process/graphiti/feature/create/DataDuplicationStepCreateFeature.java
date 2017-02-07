package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.DataDuplicationStep;
import eu.vicci.process.model.sofia.SofiaFactory;

public class DataDuplicationStepCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public DataDuplicationStepCreateFeature(IFeatureProvider fp) {

        super(fp, "DataDuplicationStep", "Create a DataDuplicationStep");
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

        DataDuplicationStep dataDuplicationStep = SofiaFactory.eINSTANCE.createDataDuplicationStep();
        getDiagram().eResource().getContents().add(dataDuplicationStep);

        dataDuplicationStep.setName("DataDuplicationStep");
        dataDuplicationStep.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(dataDuplicationStep);

        addGraphicalRepresentation(context, dataDuplicationStep);
        ProcessStepCreateHelper.drawNameAndType(dataDuplicationStep);

        return new Object[] { dataDuplicationStep };
    }
}