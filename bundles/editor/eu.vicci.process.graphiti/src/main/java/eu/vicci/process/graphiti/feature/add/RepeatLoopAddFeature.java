package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.RepeatLoop;

public class RepeatLoopAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/repeatloop.pictograms";

    public RepeatLoopAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "repeatloop");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isReapeatLoop = context.getNewObject() instanceof RepeatLoop;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isReapeatLoop && bo instanceof CompositeStep;
    }
}
