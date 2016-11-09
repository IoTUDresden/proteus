package eu.vicci.process.graphiti.feature.add;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddConnectionContext;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polygon;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IColorConstant;

import eu.vicci.process.model.sofia.TrueTransition;

/**
 */
public class TrueTransitionAddFeature extends AbstractAddFeature {

    /**
     * Constructor for a transition add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public TrueTransitionAddFeature(IFeatureProvider fp) {

        super(fp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canAdd(IAddContext context) {
        return context instanceof IAddConnectionContext &&
                context.getNewObject() instanceof TrueTransition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PictogramElement add(IAddContext context) {

        TrueTransition transition = (TrueTransition) context.getNewObject();

        IGaService gaService = Graphiti.getGaService();
        IPeCreateService peCreateService = Graphiti.getPeCreateService();

        IAddConnectionContext addConnContext = (IAddConnectionContext) context;
        Connection connection = Graphiti.getPeCreateService().createFreeFormConnection(getDiagram());
        connection.setStart(addConnContext.getSourceAnchor());
        connection.setEnd(addConnContext.getTargetAnchor());

        Polyline polyline = gaService.createPolyline(connection);
        polyline.setLineWidth(1);
        polyline.setForeground(manageColor(IColorConstant.DARK_GREEN));
        addArrow(connection);
        link(connection, transition);

        ConnectionDecorator textDecorator =
                peCreateService.createConnectionDecorator(connection, true, 0.5, true);
        Text text = gaService.createDefaultText(getDiagram(), textDecorator, transition.getName());
        gaService.setLocation(text, 0, 0);

        return connection;
    }

    private Polygon addArrow(Connection connection) {

        IPeCreateService peCreateService = Graphiti.getPeCreateService();
        ConnectionDecorator cd = peCreateService.createConnectionDecorator(connection, false, 1, true);
        IGaService gaService = Graphiti.getGaService();
        Polygon polygon = gaService.createPolygon(cd, new int[] { -10, 5, 0, 0, -10, -5 });
        polygon.setForeground(manageColor(IColorConstant.DARK_GREEN));
        polygon.setBackground(manageColor(IColorConstant.DARK_GREEN));
        polygon.setLineWidth(1);
        return polygon;
    }
}
