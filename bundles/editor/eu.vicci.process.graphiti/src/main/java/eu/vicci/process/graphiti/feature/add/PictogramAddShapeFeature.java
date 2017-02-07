package eu.vicci.process.graphiti.feature.add;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Ellipse;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;

import eu.vicci.process.gesture.XMLGesture;
import eu.vicci.process.graphiti.AttributeMap;

public abstract class PictogramAddShapeFeature extends AbstractAddShapeFeature implements XMLGesture {

    private class Point {

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x, y;
    }

    private Vector<String> xmlGestures = null;
    private Map<Integer, Vector<String>> strokesMap = null;
    private String sceneUri;
    private String name;

    public PictogramAddShapeFeature(IFeatureProvider fp, String uri, String name) {

        super(fp);
        sceneUri = uri;
        this.name = name;
    }

    private void linkRecursive(Shape shape, Object object) {

        link(shape, object);
        if (shape instanceof ContainerShape)
            for (Shape child : ((ContainerShape) shape).getChildren())
                linkRecursive(child, object);
    }

    private void setSize(Shape shape, int width, int height) {

        String r = Graphiti.getPeService().getPropertyValue(shape.getGraphicsAlgorithm(), "resizable");
        if (r != null && r.contains("width"))
            shape.getGraphicsAlgorithm().setWidth(width);

        if (r != null && r.contains("height"))
            shape.getGraphicsAlgorithm().setHeight(height);

        if (shape instanceof ContainerShape)
            for (Shape child : ((ContainerShape) shape).getChildren())
                setSize(child, width, height);
    }

    private void addAttributes(Shape shape, Object object) {

        if (shape.getGraphicsAlgorithm() instanceof Text) {

            String name = Graphiti.getPeService().getPropertyValue(shape, "name");
            if (name != null)
                AttributeMap.instance().addObjectMapItem(object, name, (Text) shape.getGraphicsAlgorithm());
        }

        else if (shape instanceof ContainerShape)
            for (Shape child : ((ContainerShape) shape).getChildren())
                addAttributes(child, object);
    }

    @Override
    public PictogramElement add(IAddContext context) {

        IGaService ga = Graphiti.getGaService();

        ContainerShape parent = context.getTargetContainer();
        ResourceSet set = new ResourceSetImpl();
        Resource resource = set.getResource(URI.createPlatformPluginURI(sceneUri, true), true);
        Diagram dia = (Diagram) resource.getContents().get(0);

        Shape child = dia.getChildren().get(0);
        ga.setLocation(child.getGraphicsAlgorithm(), context.getX(), context.getY());
        if (context.getWidth() != -1 && context.getHeight() != -1)
            setSize(child, context.getWidth(), context.getHeight());

        linkRecursive(child, context.getNewObject());
        addAttributes(child, context.getNewObject());
        child.setContainer(parent);
        parent.eResource().getResourceSet().getResources().add(resource);

        return child;
    }

    public Vector<String> getXMLGestures() {

        if (xmlGestures == null) {

            ResourceSet set = new ResourceSetImpl();
            Resource resource = set.getResource(URI.createPlatformPluginURI(sceneUri, true), true);
            ContainerShape shape = (ContainerShape) resource.getContents().get(0);

            strokesMap = new HashMap<Integer, Vector<String>>();
            xmlGestures = new Vector<String>();

            addGestures(shape);

            for (Vector<String> strokes : strokesMap.values()) {
                StringBuffer buf = new StringBuffer();
                buf.append("<Gesture Name=\"" + name + "\" Subject=\"test\" Speed=\"test\">\n");
                for (String stroke : strokes)
                    buf.append(stroke);
                buf.append("</Gesture>");
                xmlGestures.add(buf.toString());
            }
        }

        return xmlGestures;
    }

    private void addGestures(Shape shape) {

        for (Property property : shape.getProperties())
            if (property.getKey().equals("gesture")) {

                int index = Integer.parseInt(property.getValue());
                Vector<String> strokes = strokesMap.get(index);
                if (strokes == null) {
                    strokes = new Vector<String>();
                    strokesMap.put(index, strokes);
                }
                int strokeIndex = strokes.size();
                StringBuffer buf = new StringBuffer();
                buf.append(" <Stroke index=\"" + (strokeIndex + 1) + "\">\n");

                if (shape.getGraphicsAlgorithm() instanceof Polyline) {

                    Polyline line = (Polyline) shape.getGraphicsAlgorithm();
                    EList<org.eclipse.graphiti.mm.algorithms.styles.Point> points = line.getPoints();
                    int num = 20;
                    for (int p = 0; p < points.size() - 1; p++) {
                        org.eclipse.graphiti.mm.algorithms.styles.Point a = points.get(p);
                        org.eclipse.graphiti.mm.algorithms.styles.Point b = points.get(p + 1);
                        float dx = (b.getX() - a.getX()) / num;
                        float dy = (b.getY() - a.getY()) / num;
                        for (int i = 0; i < num; i++)
                            buf.append("<Point X=\"" + (int) (a.getX() + i * dx) + "\"" + " Y=\""
                                    + (int) (a.getY() + i * dy) + "\" T=\"0\"/>\n");
                    }
                }

                else if (shape.getGraphicsAlgorithm() instanceof Rectangle) {


                    Rectangle rectangle = ((Rectangle) shape.getGraphicsAlgorithm());
                    Point pos = new Point(rectangle.getX(), rectangle.getY());
                    Point dim = new Point(rectangle.getWidth(), rectangle.getHeight());

                    List<Point> points = new ArrayList<Point>();
                    points.add(new Point(pos.x, pos.y));
                    points.add(new Point(pos.x + dim.x, pos.y));
                    points.add(new Point(pos.x + dim.x, pos.y + dim.y));
                    points.add(new Point(pos.x, pos.y + dim.y));
                    points.add(new Point(pos.x, pos.y));

                    int num = 20;

                    for (int p = 0; p < points.size() - 1; p ++) {
                        Point a = points.get(p);
                        Point b = points.get(p + 1);
                        float dx = (b.x - a.x) / (float) num;
                        float dy = (b.y - a.y) / (float) num;
                        for (int i = 0; i < num; i++)
                            buf.append("<Point X=\"" + (int) (a.x + i * dx) + "\"" +
                                    " Y=\"" + (int) (a.y + i * dy) + "\" T=\"0\"/>\n");
                    }
                }

                else if (shape.getGraphicsAlgorithm() instanceof Ellipse) {
                    int num = 32;

                    for (int n = 0; n < num + 1; n++) {
                        double deg = (2.0 * Math.PI / num) * n;
                        double x = 100.0 * Math.cos(deg) + 600;
                        double y = 100.0 * Math.sin(deg) + 600;
                        buf.append("<Point X=\"" + (int) x + "\"" + " Y=\"" + (int) y + "\" T=\"0\"/>\n");
                    }
                }

                buf.append(" </Stroke>\n");
                strokes.add(buf.toString());
            }

        if (shape instanceof ContainerShape)
            for (Shape child : ((ContainerShape) shape).getChildren())
                addGestures(child);
    }
}