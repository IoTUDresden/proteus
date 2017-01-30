package eu.vicci.process.graphiti.feature.resize;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartPort;

public class ProcessResizeShapeFeature extends DefaultResizeShapeFeature {

	public ProcessResizeShapeFeature(IFeatureProvider fp) {

		super(fp);
	}

	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		if (!super.canResizeShape(context))
			return false;

		Shape shape = context.getShape();
		Object object = getBusinessObjectForPictogramElement(shape);
		return (object instanceof Process || object instanceof ProcessStep);
	}

	void resize(Shape shape, int width, Object object) {

		Object shapeObject = getBusinessObjectForPictogramElement(shape);
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// process direct children
		if ((shape instanceof ContainerShape) && object.equals(shapeObject))
			for (Shape s : ((ContainerShape) shape).getChildren())
				resize(s, width, object);

		if (ga instanceof Text) {
			((Text) ga).setWidth(width);
		}

		if (ga instanceof Rectangle || ga instanceof RoundedRectangle) {
			if (object.equals(shapeObject)
					&& (shapeObject instanceof Process || shapeObject instanceof ProcessStep))
				((Rectangle) ga).setWidth(width);

			else if (shapeObject instanceof StartPort)
				((RoundedRectangle) ga).setX(0);

			else if (shapeObject instanceof EndPort)
				((RoundedRectangle) ga).setX(width
						- ((RoundedRectangle) ga).getWidth());
		}

		else if (ga instanceof Polyline) {
			Polyline poly = (Polyline) ga;
			if (poly.getPoints().size() == 2) {
				poly.getPoints().get(1).setX(width);
			}
		}

	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		// System.out.println("resizing");
		Object object = getBusinessObjectForPictogramElement(context.getShape());
		Shape container = context.getShape();
		
		super.resizeShape(context);
		resize(container, container.getGraphicsAlgorithm().getWidth(), object);
		
	}
}
