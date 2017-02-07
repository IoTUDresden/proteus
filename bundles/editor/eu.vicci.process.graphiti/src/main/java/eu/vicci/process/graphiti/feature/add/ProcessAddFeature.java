package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Process;

public class ProcessAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/process.pictograms";

    /**
     * Constructor for a process add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ProcessAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "process");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isProcess = context.getNewObject() instanceof Process;
    	ContainerShape target = context.getTargetContainer();
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());    
        return isProcess && (target instanceof Diagram || bo instanceof CompositeStep);
    }
}
