package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.HumanTask;

public class HumanTaskAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/humantask.pictograms";

    /**
     * Constructor for a process add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public HumanTaskAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "human_task");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isHumanTask = context.getNewObject() instanceof HumanTask;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return isHumanTask && bo instanceof CompositeStep;
    }
}
