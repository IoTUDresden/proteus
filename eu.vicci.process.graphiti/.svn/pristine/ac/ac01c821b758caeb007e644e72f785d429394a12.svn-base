package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.WhileLoop;

public class WhileLoopAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/whileloop.pictograms";

    public WhileLoopAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "whileloop");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isWhile = context.getNewObject() instanceof WhileLoop;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return  isWhile && bo instanceof CompositeStep;
    }
}
