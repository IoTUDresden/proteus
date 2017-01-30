package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.XMLRPCInvoke;

public class XMLRPCInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/xmlrpcinvoke.pictograms";

    /**
     * Constructor for an XMLRPCInvoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public XMLRPCInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "xmlrpcinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isXml = context.getNewObject() instanceof XMLRPCInvoke;
        Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return isXml && bo instanceof CompositeStep;
    }
}
