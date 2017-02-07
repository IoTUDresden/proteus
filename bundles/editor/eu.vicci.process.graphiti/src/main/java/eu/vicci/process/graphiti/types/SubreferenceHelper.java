package eu.vicci.process.graphiti.types;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;
import org.eclipse.graphiti.util.ColorConstant;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;

public class SubreferenceHelper extends AbstractAddFeature implements EObject {
	private final double TRANSPARENCY = 0.2;
	private DataType reference;
	private ComplexType parent;

	public SubreferenceHelper(IFeatureProvider fp, DataType reference, ComplexType parent) {
		super(fp);
		this.reference = reference;
		this.parent = parent;
	}

	public ContainerShape cloneContainer(ContainerShape containerToClone, ContainerShape target) {
		ContainerShape cs = cloneGraphicsAlgorithm(containerToClone, target);
		DataTypeAddFeature.resizeWholeType(getDiagram(), target);
		return cs;
	}
	
	private ContainerShape cloneGraphicsAlgorithm(Shape originalShape, ContainerShape targetContainer) {
		
		if (originalShape instanceof ContainerShape) {
			ContainerShape newContainer = Graphiti.getPeCreateService().createContainerShape(targetContainer, true);
			targetContainer.getChildren().add(newContainer);

			if (originalShape.getGraphicsAlgorithm() instanceof RoundedRectangle) {
				newContainer.setGraphicsAlgorithm(cloneRoundedRect((RoundedRectangle) originalShape.getGraphicsAlgorithm(), newContainer));
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Rectangle) {
				newContainer.setGraphicsAlgorithm(cloneRect((Rectangle) originalShape.getGraphicsAlgorithm(), newContainer));
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Text) {
				newContainer.setGraphicsAlgorithm(cloneText((Text) originalShape.getGraphicsAlgorithm(), newContainer));
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Polyline) {
				newContainer.setGraphicsAlgorithm(clonePolyline((Polyline) originalShape.getGraphicsAlgorithm(), newContainer));
			}
			for (Shape child : ((ContainerShape) originalShape).getChildren()) {
				cloneGraphicsAlgorithm(child, newContainer);
			}
			return newContainer;
		}
		else {
			if (originalShape.getGraphicsAlgorithm() instanceof RoundedRectangle) {
				cloneRoundedRect((RoundedRectangle) originalShape.getGraphicsAlgorithm(), targetContainer);
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Rectangle) {
				cloneRect((Rectangle) originalShape.getGraphicsAlgorithm(), targetContainer);
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Text) {
				cloneText((Text) originalShape.getGraphicsAlgorithm(), targetContainer);
			}
			if (originalShape.getGraphicsAlgorithm() instanceof Polyline) {
				clonePolyline((Polyline) originalShape.getGraphicsAlgorithm(), targetContainer);
			}
		}
		return targetContainer;
	}

	private RoundedRectangle cloneRoundedRect(RoundedRectangle original, ContainerShape cs) {
		IGaService gaService = Graphiti.getGaService();
		RoundedRectangle newRR = gaService.createRoundedRectangle(cs, original.getWidth(), original.getHeight());
		newRR.setBackground(manageColor(new ColorConstant(220, 220, 255)));
		newRR.setForeground(original.getForeground());
		newRR.setFilled(true);
		newRR.setCornerHeight(original.getCornerHeight());
		newRR.setCornerWidth(original.getCornerWidth());
		newRR.setLineWidth(original.getLineWidth());
		newRR.setTransparency(TRANSPARENCY);
		gaService.setLocationAndSize(newRR, 10, original.getY(), original.getWidth(), original.getHeight());
		link(cs, this);
		return newRR;
	}

	private Rectangle cloneRect(Rectangle original, ContainerShape cs) {
		IGaService gaService = Graphiti.getGaService();
		Rectangle newR = gaService.createRectangle(cs);
		newR.setBackground(manageColor(new ColorConstant(220, 220, 255)));
		newR.setForeground(original.getForeground());
		newR.setFilled(true);
		newR.setLineWidth(original.getLineWidth());
		newR.setTransparency(TRANSPARENCY);
		gaService.setLocationAndSize(newR, 10, original.getY(), original.getWidth(), original.getHeight());
		link(cs, this);
		return newR;
	}

	private Text cloneText(Text original, ContainerShape cs) {
		Shape shape = Graphiti.getPeCreateService().createShape(cs, false);
		IGaService gaService = Graphiti.getGaService();
		Text newText = gaService.createText(shape, original.getValue());
		newText.setBackground(original.getBackground());
		newText.setForeground(original.getForeground());
		newText.setFont(original.getFont());
		newText.setFilled(original.getFilled());
		newText.setLineWidth(original.getLineWidth());
		newText.setTransparency(TRANSPARENCY);
		newText.setHorizontalAlignment(original.getHorizontalAlignment());
		newText.setVerticalAlignment(original.getVerticalAlignment());
		if(original.getValue().contains("Type"))
			newText.setValue(original.getValue()+" ref");
		gaService.setLocationAndSize(newText, original.getX(), original.getY(), original.getWidth(), original.getHeight());
		link(shape, this);
		return newText;
	}

	private Polyline clonePolyline(Polyline original, ContainerShape cs) {
		Shape shape = Graphiti.getPeCreateService().createShape(cs, false);
		IGaService gaService = Graphiti.getGaService();
		Polyline newPL = gaService.createPolyline(shape);
		newPL.setBackground(manageColor(new ColorConstant(220, 220, 255)));
		newPL.setForeground(original.getForeground());
		newPL.setFilled(original.getFilled());
		for (Point p : original.getPoints()) {
			newPL.getPoints().add(gaService.createPoint(p.getX(), p.getY()));
		}
		newPL.setLineWidth(original.getLineWidth());
		newPL.setTransparency(TRANSPARENCY);
		gaService.setLocationAndSize(newPL, original.getX(), original.getY(), original.getWidth(), original.getHeight());
		link(shape, this);
		return newPL;
	}

	@Override
	public PictogramElement add(IAddContext arg0) {
		return null;
	}

	@Override
	public boolean canAdd(IAddContext arg0) {
		return false;
	}

	@Override
	public EList<Adapter> eAdapters() {
		return null;
	}

	@Override
	public boolean eDeliver() {
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {

	}

	@Override
	public void eNotify(Notification notification) {

	}

	@Override
	public EClass eClass() {
		return null;
	}

	@Override
	public Resource eResource() {
		return null;
	}

	@Override
	public EObject eContainer() {
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return null;
	}

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {

	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return null;
	}

	public static class SubreferenceDeleteFeature extends DefaultDeleteFeature {
		public SubreferenceDeleteFeature(IFeatureProvider fp) {
			super(fp);
		}

		@Override
		public boolean canDelete(IDeleteContext context) {

			boolean canDelete = super.canDelete(context);

			if (canDelete) {

				Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
				return (object instanceof SubreferenceHelper);
			}

			return canDelete;
		}

		/**
		 * @see org.eclipse.graphiti.func.IDelete#delete(org.eclipse.graphiti.features
		 *      .context.IDeleteContext)
		 */
		@Override
		public void delete(IDeleteContext context) {

			Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());

			if (!(object instanceof SubreferenceHelper)) {
				return;
			}

			SubreferenceHelper sub = (SubreferenceHelper) object;

			for (DataType ref : sub.parent.getSubreferences()) {
				if (ref.toString().equals(sub.reference.toString())) {
					sub.parent.getSubreferences().remove(ref);
					break;
				}
			}

			for (PictogramElement pe : Graphiti.getLinkService().getPictogramElements(getDiagram(), sub.parent)) {
				if (pe instanceof ContainerShape) {
					ContainerShape cont = (ContainerShape) pe;
					for (Shape child : cont.getChildren()) {
						if (child instanceof ContainerShape) {
							child.setGraphicsAlgorithm(null);
							removeAllChildren((ContainerShape) child);
							cont.getChildren().remove(child);
							DataTypeAddFeature.resizeWholeType(getDiagram(), cont);
							break;
						}
					}
				}
			}
		}
	}

	private static void removeAllChildren(ContainerShape container){
		for(int i=0; i<container.getChildren().size(); i++){
			Shape child = container.getChildren().get(i);
			if(child instanceof ContainerShape){
				removeAllChildren((ContainerShape) child);
			}
		}
		while(container.getChildren().size()>0){
			container.getChildren().remove(container.getChildren().size()-1);
		}
	}
	
	public DataType getReference() {
		return reference;
	}
}
