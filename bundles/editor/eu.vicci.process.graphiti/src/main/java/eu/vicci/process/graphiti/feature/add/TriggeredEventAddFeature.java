package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.TriggeredEvent;

public class TriggeredEventAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/triggeredevent.pictograms";

    /**
     * Constructor for a TriggeredEvent add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public TriggeredEventAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "triggeredevent");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isTriggered = context.getNewObject() instanceof TriggeredEvent;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isTriggered && bo instanceof CompositeStep;
    }
}
