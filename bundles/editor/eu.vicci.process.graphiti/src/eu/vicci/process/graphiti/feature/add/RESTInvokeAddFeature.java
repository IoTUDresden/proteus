package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.RESTInvoke;

public class RESTInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/restinvoke.pictograms";

    /**
     * Constructor for an Invoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public RESTInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "restinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isRest = context.getNewObject() instanceof RESTInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isRest && bo instanceof CompositeStep;
    }
}
