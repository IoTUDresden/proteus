package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ROSInvoke;

public class ROSInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/rosinvoke.pictograms";

    public ROSInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "rosinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isRos = context.getNewObject() instanceof ROSInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isRos && bo instanceof CompositeStep;
    }
}
