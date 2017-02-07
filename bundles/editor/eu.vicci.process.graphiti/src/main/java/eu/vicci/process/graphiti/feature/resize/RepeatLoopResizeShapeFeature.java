package eu.vicci.process.graphiti.feature.resize;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.RepeatLoop;
import eu.vicci.process.model.sofia.StartPort;

public class RepeatLoopResizeShapeFeature extends DefaultResizeShapeFeature {

    public RepeatLoopResizeShapeFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public boolean canResizeShape(IResizeShapeContext context) {
        if (!super.canResizeShape(context))
			return false;

		Shape shape = context.getShape();
		Object object = getBusinessObjectForPictogramElement(shape);
		return (object instanceof RepeatLoop);
    }

    void resize(Shape shape, Object object) {

        resize(shape, shape.getGraphicsAlgorithm().getWidth(), object);
    }

    void resize(Shape shape, int width, Object object) {

        Object shapeObject = getBusinessObjectForPictogramElement(shape);

        // process direct children
        if ((shape instanceof ContainerShape) && object.equals(shapeObject))
            for (Shape s : ((ContainerShape) shape).getChildren()) {
                resize(s, width, object);
                if (s.getGraphicsAlgorithm() instanceof Polyline)
                    ((Polyline) s.getGraphicsAlgorithm()).getPoints().get(1).setX(width);
            }

        if (shape.getGraphicsAlgorithm() instanceof RoundedRectangle) {

            if (object.equals(shapeObject) && (shapeObject instanceof Process))
                ((RoundedRectangle) shape.getGraphicsAlgorithm()).setWidth(width);

            else if (shapeObject instanceof StartPort)
                ((RoundedRectangle) shape.getGraphicsAlgorithm()).setX(0);

            else if (shapeObject instanceof EndPort)
                ((RoundedRectangle) shape.getGraphicsAlgorithm()).setX(width -
                        ((RoundedRectangle) shape.getGraphicsAlgorithm()).getWidth());
        }
        if (shape.getGraphicsAlgorithm() instanceof Polyline)
            ((Polyline) shape.getGraphicsAlgorithm()).getPoints().get(1).setX(400);

        if (shape.getGraphicsAlgorithm() instanceof Text) {
            if (object instanceof RepeatLoop) {
                RepeatLoop repeatLoop = (RepeatLoop) object;
                Text text = (Text) shape.getGraphicsAlgorithm();
                String id = repeatLoop.getId();
                String comparator = "";

                if (repeatLoop.getLoopCondition() != null &&
                        repeatLoop.getLoopCondition().getComparator() != null)
                    comparator = repeatLoop.getLoopCondition().getComparator().getLiteral();

                if (text.getValue().equals(id))
                    text.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);

                if (text.getValue().equals(comparator) || text.getValue().contains("(condition)")) {
                    text.setWidth(width - 8);
                    text.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
                }
            }
        }
    }

    @Override
    public void resizeShape(IResizeShapeContext context) {

        Object object = getBusinessObjectForPictogramElement(context.getShape());
        super.resizeShape(context);
        Shape container = context.getShape();
        resize(container, object);
    }

}
