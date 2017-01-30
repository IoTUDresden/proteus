package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.LoadClassStep;

public class LoadClassStepAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/loadclassstep.pictograms";

    /**
     * Constructor for a LoadClassStep add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public LoadClassStepAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "loadclassstep");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isLoadClass = context.getNewObject() instanceof LoadClassStep;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isLoadClass && bo instanceof CompositeStep;
    }
}
