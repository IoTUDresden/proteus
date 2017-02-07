package eu.vicci.process.graphiti.feature.add;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;

public class EndDataPortAddFeature extends PictogramAddShapeFeature {

    static String SCENE_URI = "eu.vicci.process.graphiti/model/enddataport.pictograms";

    public EndDataPortAddFeature(IFeatureProvider fp) {

        super(fp, SCENE_URI, "endPort");
    }

    @Override
    public boolean canAdd(IAddContext context) {
        return ((getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ProcessStep) &&
                 (context.getNewObject() instanceof EndDataPort));
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
            if (p instanceof EndPort)
                numPorts++;

        IGaService gaService = Graphiti.getGaService();

        gaService.setLocation(element.getGraphicsAlgorithm(),
                target.getGraphicsAlgorithm().getWidth() - element.getGraphicsAlgorithm().getWidth(),
                yOffset + 15 * (numPorts - 1));

        Util.resizeContainerOnPortAdd(context, element);
        //Graphiti.getPeCreateService().createChopboxAnchor(element);

        return element;
    }
}
