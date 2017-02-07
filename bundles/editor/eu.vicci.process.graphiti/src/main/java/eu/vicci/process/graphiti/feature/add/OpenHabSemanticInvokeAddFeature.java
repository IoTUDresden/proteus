package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;

public class OpenHabSemanticInvokeAddFeature extends PictogramAddShapeFeature {
    static String SCENE_URI = "eu.vicci.process.graphiti/model/openhabsemanticinvoke.pictograms";

    /**
     * Constructor for an Invoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public OpenHabSemanticInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "openhabsemanticinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isOh = context.getNewObject() instanceof OpenHabSemanticInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isOh && bo instanceof CompositeStep;
    }

}
