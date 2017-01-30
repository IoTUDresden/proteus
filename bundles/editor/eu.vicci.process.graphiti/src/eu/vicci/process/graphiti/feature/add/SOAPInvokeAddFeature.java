package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.SOAPInvoke;

public class SOAPInvokeAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/soapinvoke.pictograms";

    public SOAPInvokeAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "soapinvoke");
    }

    @Override
    public boolean canAdd(IAddContext context) {
    	boolean isSoap = context.getNewObject() instanceof SOAPInvoke;
        Object bo = (getBusinessObjectForPictogramElement(context.getTargetContainer()));
        return isSoap && bo instanceof CompositeStep;
    }
}
