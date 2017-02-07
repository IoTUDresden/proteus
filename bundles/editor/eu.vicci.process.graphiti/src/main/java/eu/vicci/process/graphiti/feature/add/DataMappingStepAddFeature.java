package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.DataMappingStep;

public class DataMappingStepAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/datamappingstep.pictograms";

    /**
     * Constructor for an Invoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public DataMappingStepAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "datamappingstep");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isDataMapping = context.getNewObject() instanceof DataMappingStep;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isDataMapping && bo instanceof CompositeStep;
    }
}
