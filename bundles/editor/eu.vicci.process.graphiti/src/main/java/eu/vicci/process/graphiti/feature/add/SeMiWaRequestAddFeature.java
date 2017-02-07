package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SeMiWaRequest;

public class SeMiWaRequestAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/semiwarequest.pictograms";

    /**
     * Constructor for a SeMiWaRequest add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public SeMiWaRequestAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "semiwarequest");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isSemiwa = context.getNewObject() instanceof SeMiWaRequest;
        Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isSemiwa &&bo instanceof CompositeStep;
    }
}
