package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.CompositeStep;

public class AndAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/and.pictograms";

    /**
     * Constructor for a Task add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public AndAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "and");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean newObjIsAnd = context.getNewObject() instanceof And;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return newObjIsAnd && bo instanceof CompositeStep;
    }
}
