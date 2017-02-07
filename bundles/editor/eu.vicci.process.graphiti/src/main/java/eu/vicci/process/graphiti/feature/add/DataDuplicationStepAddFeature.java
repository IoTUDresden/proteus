package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.DataDuplicationStep;

public class DataDuplicationStepAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/dataduplicationstep.pictograms";

    /**
     * Constructor for an Invoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public DataDuplicationStepAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "dataduplicationstep");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isDataDupl = context.getNewObject() instanceof DataDuplicationStep;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isDataDupl && bo instanceof CompositeStep;
    }
}
