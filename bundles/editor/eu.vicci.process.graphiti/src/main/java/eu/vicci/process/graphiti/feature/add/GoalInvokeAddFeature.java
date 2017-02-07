package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.GoalInvoke;

public class GoalInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/goalinvoke.pictograms";

    /**
     * Constructor for a process add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public GoalInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "goalInvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isGoalInvoke = context.getNewObject() instanceof GoalInvoke;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return isGoalInvoke && bo instanceof CompositeStep;
    }

}
