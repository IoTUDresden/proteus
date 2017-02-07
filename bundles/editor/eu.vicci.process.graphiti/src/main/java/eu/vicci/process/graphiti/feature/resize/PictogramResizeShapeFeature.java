package eu.vicci.process.graphiti.feature.resize;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IResizeConfiguration;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.impl.DefaultResizeShapeFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartPort;

public class PictogramResizeShapeFeature extends DefaultResizeShapeFeature {

	public PictogramResizeShapeFeature(IFeatureProvider fp) {

		super(fp);
	}

	@Override
	public boolean canResizeShape(IResizeShapeContext context) {
		if (!super.canResizeShape(context))
			return false;

		Shape shape = context.getShape();
		Object object = getBusinessObjectForPictogramElement(shape);
		return (object instanceof If || object instanceof And || object instanceof Or);
	}

	void resize(Shape shape, int width, int height, Object object) {

		Object shapeObject = getBusinessObjectForPictogramElement(shape);
		GraphicsAlgorithm ga = shape.getGraphicsAlgorithm();

		// process direct children
		if ((shape instanceof ContainerShape) && object.equals(shapeObject))
			for (Shape s : ((ContainerShape) shape).getChildren())
				resize(s, width, height, object);

		 if (ga instanceof Text) {
		 ((Text) ga).setWidth(width);
		 ((Text) ga).setHeight(height);
		 }
		
		 if (ga instanceof Rectangle || ga instanceof RoundedRectangle) {
		 if (object.equals(shapeObject)
		 && (shapeObject instanceof Process || shapeObject instanceof
		 ProcessStep))
		 ((Rectangle) ga).setWidth(width);
		
		 else if (shapeObject instanceof StartPort)
		 ((RoundedRectangle) ga).setX(0);
		
		 else if (shapeObject instanceof EndPort)
		 ((RoundedRectangle) ga).setX(width
		 - ((RoundedRectangle) ga).getWidth());
		 }

		else if (ga instanceof Polyline) {
			Polyline poly = (Polyline) ga;

			float scaleX = (float) shape.getGraphicsAlgorithm().getWidth()
					/ (float) width;
			float scaleY = (float) shape.getGraphicsAlgorithm().getHeight()
					/ (float) height;
			for (int i = 0; i < poly.getPoints().size(); i++) {
				int preX = poly.getPoints().get(i).getX();
				int preY = poly.getPoints().get(i).getY();
				poly.getPoints().get(i).setX((int) (preX * scaleX));
				poly.getPoints().get(i).setY((int) (preY * scaleY));

			}

		}

	}

	@Override
	public IResizeConfiguration getResizeConfiguration(
			IResizeShapeContext context) {
		IResizeConfiguration config = new IResizeConfiguration() {

			@Override
			public boolean isVerticalResizeAllowed() {
				return true;
			}

			@Override
			public boolean isHorizontalResizeAllowed() {
				return false;
			}
		};
		return config;
	}

	@Override
	public void resizeShape(IResizeShapeContext context) {
		// System.out.println("resizing");
		Object object = getBusinessObjectForPictogramElement(context.getShape());
		Shape container = context.getShape();

		int preWidth = container.getGraphicsAlgorithm().getWidth();
		int preHeight = container.getGraphicsAlgorithm().getHeight();

		super.resizeShape(context);
		if (container instanceof ContainerShape
				&& (object instanceof If || object instanceof Or || object instanceof And)) {
			Util.resizeAndIfOr((ContainerShape) container, preHeight,
					context.getHeight());
		} else
			resize(container, preWidth, preHeight, object);

	}
}
