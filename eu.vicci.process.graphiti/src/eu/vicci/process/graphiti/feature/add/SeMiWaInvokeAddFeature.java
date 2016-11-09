package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SeMiWaInvoke;

public class SeMiWaInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/semiwainvoke.pictograms";

    public SeMiWaInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "semiwainvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isSemiwa = context.getNewObject() instanceof SeMiWaInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isSemiwa && bo instanceof CompositeStep;
    }
}
