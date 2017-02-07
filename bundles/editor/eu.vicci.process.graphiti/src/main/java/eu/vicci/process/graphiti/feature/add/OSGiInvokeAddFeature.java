package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.OSGiInvoke;

public class OSGiInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/osgiinvoke.pictograms";

    /**
     * Constructor for an OSGIInvoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public OSGiInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "osgiinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isOsgi = context.getNewObject() instanceof OSGiInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isOsgi && bo instanceof CompositeStep;
    }
}
