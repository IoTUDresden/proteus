package eu.vicci.process.graphiti;

import java.util.Vector;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.features.ConfigurableFeatureProviderWrapper;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.CreateContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.features.context.impl.MultiDeleteInfo;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.platform.IDiagramBehavior;
import org.eclipse.graphiti.platform.IDiagramContainer;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

import eu.vicci.process.gesture.Editor;
import eu.vicci.process.gesture.GestureResultListener;
import eu.vicci.process.gesture.Result;
import eu.vicci.process.gesture.XMLGesture;
import eu.vicci.process.graphiti.feature.create.AndCreateFeature;
import eu.vicci.process.graphiti.feature.create.EndDataPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.IfCreateFeature;
import eu.vicci.process.graphiti.feature.create.OrCreateFeature;
import eu.vicci.process.graphiti.feature.create.ProcessCreateFeature;
import eu.vicci.process.graphiti.feature.create.SeMiWaInvokeCreateFeature;
import eu.vicci.process.graphiti.feature.create.StartDataPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.TransitionCreateFeature;
import eu.vicci.process.graphiti.feature.create.WhileLoopCreateFeature;
import eu.vicci.process.graphiti.types.ComplexTypeCreateFeature;

public class ProcessDiagramTypeProvider extends AbstractDiagramTypeProvider
    implements GestureResultListener {

    private ContainerShape getElementAt(ContainerShape shape, int x, int y) {

        ContainerShape fit = shape;

        for (Shape child : ((ContainerShape) shape).getChildren()) {

            GraphicsAlgorithm alg = child.getGraphicsAlgorithm();

            if (!(child instanceof ContainerShape))
                continue;

            ILocation cloc = ((ToolBehaviorProvider) toolBehaviorProviders[getCurrentToolBehaviorIndex()])
                    .getAbsoluteLocation(alg);

            if ((x >= cloc.getX()) && (x <= cloc.getX() + alg.getWidth()) && (y >= cloc.getY())
                    && (y <= alg.getHeight() + cloc.getY())) {
                ContainerShape cs = getElementAt((ContainerShape) child, x, y);
                if (cs != null)
                    fit = cs;
            }
        }
        return fit;
    }

    private IToolBehaviorProvider[] toolBehaviorProviders = null;

    /**
     * Create a Task diagram type provider.
     */
    public ProcessDiagramTypeProvider() {

        super();
        setFeatureProvider(new ConfigurableFeatureProviderWrapper(new ProcessFeatureProvider(this)));
    }

    @Override
    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() {

        if (toolBehaviorProviders == null)
            toolBehaviorProviders = new IToolBehaviorProvider[] { new ToolBehaviorProvider(this), new ReadOnlyToolBehaviorProvider(this) };

        return toolBehaviorProviders;
    }

    @Override
    public void init(Diagram diagram, IDiagramBehavior diagramBehavior) {

        super.init(diagram, diagramBehavior);
        
        IDiagramContainer container = diagramBehavior.getDiagramContainer();

        
        ProcessFeatureProvider featureProvider = getProcessFeatureProvider();
        IAddFeature[] addFeatures = featureProvider.getAddFeatures();

        if (container instanceof Editor) {
            ((Editor) container).addGestureResultListener(this);

            for (IAddFeature feature : addFeatures)
                if (feature instanceof XMLGesture) {
                    Vector<String> gestures = ((XMLGesture) feature).getXMLGestures();
                    if (gestures != null)
                        for (String g : gestures)
                            ((Editor) container).addXMLGesture(g);
                }
        }
    }

    @Override
    public void gestureDetected(Result gestureResult) {

        System.out.println("gesture detected: [" + gestureResult.getName() + "]");
        Diagram diagram = getDiagram();
        DiagramBehavior behavior = (DiagramBehavior) getDiagramBehavior();

        Point firstPos = behavior.calculateRealMouseLocation(new Point((int) gestureResult.getFirstPoint().X, (int) gestureResult.getFirstPoint().Y));
        Point lastPos = behavior.calculateRealMouseLocation(new Point((int) gestureResult.getLastPoint().X, (int) gestureResult.getLastPoint().Y));
        Point realDim = behavior.calculateRealMouseLocation(new Point((int) gestureResult.getDimensionX(), (int) gestureResult.getDimensionY()));

        ContainerShape shape = getElementAt(diagram, firstPos.x, firstPos.y);
        GraphicsAlgorithm alg = shape.getGraphicsAlgorithm();

        ILocation loc = ((ToolBehaviorProvider) toolBehaviorProviders[getCurrentToolBehaviorIndex()]).getAbsoluteLocation(alg);

        IContext context = new CreateContext();
        ((CreateContext) context).setTargetContainer(shape);
        ((CreateContext) context).setLocation(firstPos.x - loc.getX(), firstPos.y - loc.getY());
        ((CreateContext) context).setSize(realDim.x, realDim.y);

        IFeature feature = null;
        String name = gestureResult.getName();

        if (name.equals("process"))
            feature = new ProcessCreateFeature(getFeatureProvider());

        else if (name.equals("or"))
            feature = new OrCreateFeature(getFeatureProvider());

        else if (name.equals("and"))
            feature = new AndCreateFeature(getFeatureProvider());

        else if (name.equals("while"))
            feature = new WhileLoopCreateFeature(getFeatureProvider());

        else if (name.equals("complex"))
            feature = new ComplexTypeCreateFeature(getFeatureProvider());

        else if (name.equals("semiwa"))
            feature = new SeMiWaInvokeCreateFeature(getFeatureProvider());

        else if (name.equals("startPort"))
            feature = new StartDataPortCreateFeature(getFeatureProvider());

        else if (name.equals("endPort"))
            feature = new EndDataPortCreateFeature(getFeatureProvider());

        else if (name.equals("if"))
            feature = new IfCreateFeature(getFeatureProvider());

        else if (name.equals("delete")) {

            context = new DeleteContext(shape);
            MultiDeleteInfo delInfo = new MultiDeleteInfo(false, false, 1);
            ((DeleteContext) context).setMultiDeleteInfo(delInfo);
            feature = getFeatureProvider().getDeleteFeature((DeleteContext) context);
        }

        if (feature != null)
            behavior.executeFeature(feature, context);

        if (name.equals("transition")) {

            ContainerShape source = getElementAt(diagram, firstPos.x, firstPos.y);
            ContainerShape target = getElementAt(diagram, lastPos.x, lastPos.y);
            CreateConnectionContext connectionContext = new CreateConnectionContext();
            EList<Anchor> sAnchors = source.getAnchors();
            EList<Anchor> tAnchors = target.getAnchors();
            if (sAnchors != null && tAnchors != null && !sAnchors.isEmpty() && !tAnchors.isEmpty()) {
                connectionContext.setSourceAnchor(sAnchors.get(0));
                connectionContext.setTargetAnchor(tAnchors.get(0));
                connectionContext.setSourcePictogramElement(source);
                connectionContext.setTargetPictogramElement(target);
                feature = new TransitionCreateFeature(getFeatureProvider());
                behavior.executeFeature(feature, connectionContext);
            }
        }
    }
    
    private ProcessFeatureProvider getProcessFeatureProvider(){
    	return (ProcessFeatureProvider)((ConfigurableFeatureProviderWrapper)getFeatureProvider())
    			.getInnerFeatureProvider();
    }
}
