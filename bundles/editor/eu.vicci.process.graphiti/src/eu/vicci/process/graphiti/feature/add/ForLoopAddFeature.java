package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ForLoop;

public class ForLoopAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/forloop.pictograms";

    public ForLoopAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "forloop");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean newIsForLoop = context.getNewObject() instanceof ForLoop;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return newIsForLoop && bo instanceof CompositeStep;
    }
}
