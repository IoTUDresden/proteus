package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import eu.vicci.process.model.sofia.ControlPort;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.TrueTransition;

/**
 */
public class TrueTransitionCreateFeature extends
        AbstractCreateConnectionFeature {

    /**
     * Constructor for a transition create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public TrueTransitionCreateFeature(IFeatureProvider fp) {

        super(fp, "TrueTransition", "Create a TrueTransition");
    }

    /**
     * Retrieve the task linked with the given anchor's parent.
     *
     * @param anchor
     *            an anchor for the source or target of the new connection
     * @return the corresponding task, or {@code null} if there is none
     */
    private Port getState(Anchor anchor) {

        if (anchor != null) {
            Object object = getBusinessObjectForPictogramElement(anchor.getParent());

            if (object instanceof Port)
                return (Port) object;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canStartConnection(ICreateConnectionContext context) {

        Port port = getState(context.getSourceAnchor());
        return (port != null && (port.getProcessStep() instanceof If 
        		|| port.getProcessStep() instanceof OpenHabSemanticAskInvoke));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateConnectionContext context) {
        Object source = getState(context.getSourceAnchor());
        Object target = getState(context.getTargetAnchor());

        return ((source instanceof DataPort) && (target instanceof DataPort)) ||
                ((source instanceof ControlPort) && (target instanceof ControlPort));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Connection create(ICreateConnectionContext context) {

        Port source = getState(context.getSourceAnchor());
        Port target = getState(context.getTargetAnchor());

        if (source == null || target == null)
            throw new IllegalStateException("Cannot retrieve the source or target.");

        TrueTransition transition = SofiaFactory.eINSTANCE.createTrueTransition();
        transition.setId(EcoreUtil.generateUUID());
        transition.setName("TrueTransition");
        getDiagram().eResource().getContents().add(transition);
        transition.setSourcePort(source);
        transition.setTargetPort(target);

        AddConnectionContext addContext =
                new AddConnectionContext(context.getSourceAnchor(), context.getTargetAnchor());
        addContext.setNewObject(transition);

        return (Connection) getFeatureProvider().addIfPossible(addContext);
    }
}