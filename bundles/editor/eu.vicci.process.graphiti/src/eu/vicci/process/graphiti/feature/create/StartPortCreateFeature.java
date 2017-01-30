package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartPort;

public abstract class StartPortCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public StartPortCreateFeature(IFeatureProvider fp, String name, String description) {

        super(fp, name, description);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateContext context) {
        Object container = getBusinessObjectForPictogramElement(context.getTargetContainer());

        return (container instanceof ProcessStep);
    }

    protected abstract Port createPort();

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] create(ICreateContext context) {

        Port port = createPort();

        Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        port.setProcessStep((ProcessStep) bo);

        EList<Port> ports = port.getProcessStep().getPorts();
        int num = 0;
        for (Port p : ports)
            if (p instanceof StartPort)
                num++;

        port.setName("start_" + (num - 1));
        port.setId(EcoreUtil.generateUUID());
        addGraphicalRepresentation(context, port);

        return new Object[] { port };
    }
}