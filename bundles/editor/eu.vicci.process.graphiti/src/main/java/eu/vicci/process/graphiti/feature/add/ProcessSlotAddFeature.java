package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ProcessSlot;

public class ProcessSlotAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/processslot.pictograms";

    /**
     * Constructor for a ProcessSlot add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ProcessSlotAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "processslot");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean newIsProcessSlot = context.getNewObject() instanceof ProcessSlot;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    	
        return newIsProcessSlot && bo instanceof CompositeStep;
    }
}
