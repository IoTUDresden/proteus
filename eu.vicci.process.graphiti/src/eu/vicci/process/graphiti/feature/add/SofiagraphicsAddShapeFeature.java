package eu.vicci.process.graphiti.feature.add;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.ColorConstant;

import eu.vicci.process.gesture.XMLGesture;
import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.sofiagraphics.Alignment;
import eu.vicci.process.graphiti.sofiagraphics.Color;
import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.Ellipse;
import eu.vicci.process.graphiti.sofiagraphics.Gesture;
import eu.vicci.process.graphiti.sofiagraphics.Point;
import eu.vicci.process.graphiti.sofiagraphics.Polyline;
import eu.vicci.process.graphiti.sofiagraphics.Rectangle;
import eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle;
import eu.vicci.process.graphiti.sofiagraphics.Scene;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsFactory;
import eu.vicci.process.graphiti.sofiagraphics.Style;
import eu.vicci.process.graphiti.sofiagraphics.Text;
import eu.vicci.process.graphiti.sofiagraphics.Widget;

public abstract class SofiagraphicsAddShapeFeature extends AbstractAddShapeFeature implements XMLGesture {

    protected Scene scene = null;
    private Vector<String> xmlGesture = new Vector<String>();

    public SofiagraphicsAddShapeFeature(IFeatureProvider fp, String uri, String name) {

        super(fp);
        ResourceSet set = new ResourceSetImpl();
        Resource resource = set.getResource(URI.createPlatformPluginURI(uri, true), true);

        scene = (Scene) resource.getContents().get(0);
        for (Gesture gesture : scene.getGesture())
            addGesture(name, gesture.getWidget());
    }

    public PictogramElement createGraphitiUI(IAddContext context, Widget widget, ContainerShape parent) {

        Object object = context.getNewObject();
        IGaService ga = Graphiti.getGaService();
        IPeCreateService pe = Graphiti.getPeCreateService();

        if (parent == null)
            parent = context.getTargetContainer();

        Shape shape = null;
        GraphicsAlgorithm algorithm = null;
        if (!widget.isGestureOnly()) {
            if (widget.getChild() != null && widget.getChild().size() != 0) {
                shape = pe.createContainerShape(parent, false);
                pe.createChopboxAnchor(shape);
                shape.setActive(true);
            } else
                shape = pe.createShape(parent, false);
        }

        if (shape != null)
            link(shape, object);

        if (widget.isGestureOnly()) {

        } else if (widget instanceof Ellipse) {

            algorithm = ga.createEllipse(shape);

        } else if (widget instanceof Polyline) {

            Polyline polyLine = (Polyline) widget;

            int numPoints = polyLine.getPoint().size();
            int pts[] = new int[numPoints * 2];
            for (int index = 0; index < numPoints; index++) {
                Point p = polyLine.getPoint().get(index);
                float x = p.getX();
                float y = p.getY();
                if (p.isXrelative())
                    x *= parent.getGraphicsAlgorithm().getWidth();
                if (p.isYrelative())
                    y *= parent.getGraphicsAlgorithm().getHeight();
                pts[index * 2] = (int) x;
                pts[index * 2 + 1] = (int) y;
            }
            algorithm = ga.createPlainPolygon(shape, pts);

        } else if (widget instanceof RoundedRectangle) {

            RoundedRectangle rectangle = (RoundedRectangle) widget;
            Dimension corners = rectangle.getCorner();
            algorithm = ga.createRoundedRectangle(shape, (int) corners.getWidth(), (int) corners.getHeight());

        } else if (widget instanceof Rectangle) {

            algorithm = ga.createRectangle(shape);

        } else if (widget instanceof Text) {

            Text text = (Text) widget;
            algorithm = ga.createText(shape, text.getText());
            Alignment halign = text.getHalign();
            Alignment valign = text.getValign();
            if (halign != null)
                ((org.eclipse.graphiti.mm.algorithms.Text) algorithm).setHorizontalAlignment(Orientation.get(halign.getValue()));
            if (valign != null)
                ((org.eclipse.graphiti.mm.algorithms.Text) algorithm).setVerticalAlignment(Orientation.get(valign.getValue()));

            ((org.eclipse.graphiti.mm.algorithms.Text) algorithm).setFont(ga.manageDefaultFont(getDiagram(), false, true));

            String att = text.getAttributeName();
            if (att != null)
                AttributeMap.instance().addObjectMapItem(object, att,
                        (org.eclipse.graphiti.mm.algorithms.Text) algorithm);
        }

        Point pos = widget.getPos();
        Dimension dim = widget.getDim();

        if (algorithm != null) {

            if (pos != null)
                ga.setLocation(algorithm, (int) pos.getX(), (int) pos.getY());

            if (dim != null) {
                float width = dim.getWidth();
                float height = dim.getHeight();
                if (dim.isWrelative())
                    width *= parent.getGraphicsAlgorithm().getWidth();

                if (dim.isHrelative())
                    height *= parent.getGraphicsAlgorithm().getHeight();

                ga.setSize(algorithm, (int) width, (int) height);
            }
        }

        Style style = widget.getStyle();
        if (algorithm != null && style != null) {
            Color fgColor = style.getFgcolor();
            Color bgColor = style.getBgcolor();
            float lineWidth = style.getLineWidth();
            algorithm.setFilled(style.isFilled());
            algorithm.setLineWidth((int) lineWidth);
            if (fgColor != null)
                algorithm.setForeground(manageColor(new ColorConstant(((int) fgColor.getR()) * 255, ((int) fgColor.getG()) * 255, ((int) fgColor.getB()) * 255)));
            if (bgColor != null) {
                algorithm.setBackground(manageColor(new ColorConstant(((int) bgColor.getR()) * 255, ((int) bgColor.getG()) * 255, ((int) bgColor.getB()) * 255)));
                double transparency = bgColor.getA();
                algorithm.setTransparency(transparency);
            }
        }

        if (algorithm != null && parent == context.getTargetContainer()) {
            ga.setLocation(algorithm, context.getX(), context.getY());

            if (!(dim != null && dim.isNoresize())) {

                if (context.getWidth() != -1)
                    ga.setWidth(algorithm, context.getWidth());

                if (context.getHeight() != -1)
                    ga.setHeight(algorithm, context.getHeight());
            }
        }

        if (shape != null) {
            float portYPosition = widget.getPortYPosition();
            if (portYPosition != 0.0f)
                Graphiti.getPeService().setPropertyValue(shape, "portYPosition", "" + portYPosition);
        }

        for (Widget child : widget.getChild())
            createGraphitiUI(context, child, (ContainerShape) shape);

        if (shape != null)
            return shape;
        else
            return parent;
    }

    private void addGesture(String name, EList<Widget> widgets) {

        StringBuffer buf = new StringBuffer();
        buf.append("<Gesture Name=\"" + name +"\" Subject=\"test\" Speed=\"test\">\n");
        int index = 1;
        for (Widget widget : widgets) {
            buf.append(" <Stroke index=\"" + index++ + "\">\n");

            if (widget instanceof Polyline) {
                Polyline line = (Polyline) widget;
                EList<Point> points = line.getPoint();
                int num = 20;
                for (int p = 0; p < points.size() - 1; p ++) {
                    Point a = points.get(p);
                    Point b = points.get(p + 1);
                    float dx = (b.getX() - a.getX()) / num;
                    float dy = (b.getY() - a.getY()) / num;
                    for (int i = 0; i < num; i++)
                        buf.append("<Point X=\"" + (int) (a.getX() + i * dx) + "\"" +
                                " Y=\"" + (int) (a.getY() + i * dy) + "\" T=\"0\"/>\n");
                }
            }

            else if (widget instanceof Rectangle) {

                Rectangle rectangle = (Rectangle) widget;
                Point pos = rectangle.getPos();
                Dimension dim = rectangle.getDim();
                List<Point> points = new ArrayList<Point>();
                Point p00 = SofiagraphicsFactory.eINSTANCE.createPoint();
                p00.setX(pos.getX()); p00.setY(pos.getY());

                Point p10 = SofiagraphicsFactory.eINSTANCE.createPoint();
                p10.setX(pos.getX() + dim.getWidth()); p10.setY(pos.getY());

                Point p11 = SofiagraphicsFactory.eINSTANCE.createPoint();
                p11.setX(pos.getX() + dim.getWidth()); p11.setY(pos.getY() + dim.getHeight());

                Point p01 = SofiagraphicsFactory.eINSTANCE.createPoint();
                p01.setX(pos.getX()); p01.setY(pos.getY() + dim.getHeight());

                points.add(p00);
                points.add(p10);
                points.add(p11);
                points.add(p01);
                points.add(p00);

                int num = 20;

                for (int p = 0; p < points.size() - 1; p ++) {
                    Point a = points.get(p);
                    Point b = points.get(p + 1);
                    float dx = (b.getX() - a.getX()) / num;
                    float dy = (b.getY() - a.getY()) / num;
                    for (int i = 0; i < num; i++)
                        buf.append("<Point X=\"" + (int) (a.getX() + i * dx) + "\"" +
                                " Y=\"" + (int) (a.getY() + i * dy) + "\" T=\"0\"/>\n");
                }
            }

            else if (widget instanceof Ellipse) {

                int num = 48;

                for (int n = 0; n < num + 1; n ++) {
                    double deg = (2.0 * Math.PI / num) * n;
                    double x = 100.0 * Math.cos(deg) + 100;
                    double y = 100.0 * Math.sin(deg) + 100;
                    buf.append("<Point X=\"" + (int) x + "\"" +
                            " Y=\"" + (int) y + "\" T=\"0\"/>\n");
                }
            }
            buf.append(" </Stroke>\n");
        }
        buf.append(" </Gesture>\n");
        xmlGesture.add(buf.toString());
    }

    @Override
    public PictogramElement add(IAddContext context) {

        PictogramElement element = createGraphitiUI(context, scene.getRoot(), null);
        return element;
    }

    @Override
    public Vector<String> getXMLGestures() {

        return null;
        // return xmlGesture;
    }
}