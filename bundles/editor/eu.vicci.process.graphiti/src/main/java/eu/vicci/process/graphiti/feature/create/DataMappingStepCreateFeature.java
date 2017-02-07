package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.DataMappingStep;
import eu.vicci.process.model.sofia.SofiaFactory;

public class DataMappingStepCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public DataMappingStepCreateFeature(IFeatureProvider fp) {

        super(fp, "DataMappingStep", "Create a DataMappingStep");
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

        DataMappingStep dataMappingStep = SofiaFactory.eINSTANCE.createDataMappingStep();
        getDiagram().eResource().getContents().add(dataMappingStep);

        dataMappingStep.setName("DataMappingStep");
        dataMappingStep.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(dataMappingStep);

        addGraphicalRepresentation(context, dataMappingStep);
        ProcessStepCreateHelper.drawNameAndType(dataMappingStep);

        return new Object[] { dataMappingStep };
    }
}