package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Or;

public class OrAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/or.pictograms";

    /**
     * Constructor for a Task add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public OrAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "or");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isOr = context.getNewObject() instanceof Or ;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return  isOr && bo instanceof CompositeStep;
    }
}
