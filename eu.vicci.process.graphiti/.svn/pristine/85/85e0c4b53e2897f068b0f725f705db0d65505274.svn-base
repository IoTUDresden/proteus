package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.If;

public class IfAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/if.pictograms";

    public IfAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "if");
    }

    @Override
    public boolean canAdd(IAddContext context) {    	
    	boolean isIf = context.getNewObject() instanceof If;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return isIf && bo instanceof CompositeStep;
    }
}
