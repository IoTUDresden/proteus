package eu.vicci.process.graphiti.feature.add;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StartPort;

public class StartDataPortAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/startdataport.pictograms";

    public StartDataPortAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "startPort");
    }

    @Override
    public boolean canAdd(IAddContext context) {
        return ((getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ProcessStep) &&
                 (context.getNewObject() instanceof StartDataPort));
    }

    @Override
    public PictogramElement add(IAddContext context) {

        ContainerShape target = context.getTargetContainer();
        PictogramElement element = super.add(context);
        Port port = (Port) context.getNewObject();
        int yOffset = 0;
        String pos = Graphiti.getPeService().getPropertyValue(target, "portYPosition");
        if (pos != null)
            yOffset = (int) Float.parseFloat(pos);

        int numPorts = 0;
        EList<Port> ports = port.getProcessStep().getPorts();
        for (Port p : ports)
            if (p instanceof StartPort)
                numPorts++;

        IGaService gaService = Graphiti.getGaService();

        gaService.setLocation(element.getGraphicsAlgorithm(),
                0, yOffset + 15 * (numPorts - 1));

        Util.resizeContainerOnPortAdd(context, element);

        return element;
    }
}
