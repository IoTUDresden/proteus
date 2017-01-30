package eu.vicci.process.graphiti.types;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.impl.AbstractAddFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;

public abstract class DataTypeAddFeature extends AbstractAddFeature {

	private static final IColorConstant CLASS_FOREGROUND = new ColorConstant(102, 102, 102);
	private static final IColorConstant CLASS_BACKGROUND = new ColorConstant(230, 230, 230);
	private static final IColorConstant CLASS_TEXT_FOREGROUND = new ColorConstant(0, 0, 0);

	private static int yOffsetInitial = 30;
	private static int width = 100;
	private static int height = 20;
	// private static int spacing = 5;

	private String name = "wrong add method";

	static IFeatureProvider fp = null;

	public DataTypeAddFeature(IFeatureProvider fp) {
		super(fp);
		DataTypeAddFeature.fp = fp;
	}

	@Override
	public boolean canAdd(IAddContext context) {

		return context.getNewObject() instanceof ComplexType;
	}

	@Override
	public PictogramElement add(IAddContext context) {
		PictogramElement result = makeShape(CLASS_BACKGROUND, context, name);
		resizeWholeType(getDiagram(), result);

		getFeatureProvider().layoutIfPossible(new LayoutContext(result));

		return result;
	}

	/**
	 * @param backgroundColor
	 *            the background for the DataType
	 * @param context
	 *            the IAddContext in which the DataType should be added
	 * @param name
	 *            the name of the DataType
	 * @return the complete shape for the DataType
	 */

	public ContainerShape makeShape(IColorConstant backgroundColor, IAddContext context, String name) {

		int index = 0;
		if (context.getTargetContainer() != null)
			for (Shape child : context.getTargetContainer().getChildren())
				if (child instanceof ContainerShape)
					index++;
		return makeShape(index, backgroundColor, context, name);
	}

	/**
	 * @param index
	 *            the index at which the DataType should be inserted
	 * @param backgroundColor
	 *            the background for the DataType
	 * @param context
	 *            the IAddContext in which the DataType should be added
	 * @param name
	 *            the name of the DataType
	 * @return the complete shape for the DataType
	 */
	public ContainerShape makeShape(int index, IColorConstant backgroundColor, IAddContext context, String name) {

		this.name = name;
		DataType object = (DataType) context.getNewObject();

		int xPosition = context.getX();
		int yPosition = context.getY();

		if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer()) instanceof ComplexType) {

			xPosition = 10;
			yPosition = getYOffsetForIndex(getDiagram(), object, index);

		}
		ContainerShape containerShape = Graphiti.getPeCreateService().createContainerShape(context.getTargetContainer(), true);
		IGaService gaService = Graphiti.getGaService();

		Rectangle rectangle = gaService.createPlainRectangle(containerShape);

		rectangle.setForeground(manageColor(CLASS_FOREGROUND));
		rectangle.setBackground(manageColor(backgroundColor));
		rectangle.setFilled(true);
		rectangle.setLineWidth(2);
		gaService.setLocationAndSize(rectangle, xPosition, yPosition, width, height);
		link(containerShape, object);

		Shape shape = Graphiti.getPeCreateService().createShape(containerShape, false);

		Text typeText = gaService.createText(shape, name);
		typeText.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
		typeText.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
		typeText.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(typeText, 4, 4, width - 8, 12);
		link(shape, object);

		AttributeMap.instance().addObjectMapItem(object, "title", typeText);

		shape = Graphiti.getPeCreateService().createShape(containerShape, false);

		Text nameText = gaService.createText(shape, object.getName());
		nameText = gaService.createText(shape, object.getName());
		nameText.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
		nameText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
		nameText.setFont(gaService.manageDefaultFont(getDiagram(), false, true));
		gaService.setLocationAndSize(nameText, 4, 4, width - 8, 12);
		link(shape, object);

		AttributeMap.instance().addObjectMapItem(object, "name", nameText);

		getFeatureProvider().getDirectEditingInfo().setActive(true);

		Graphiti.getPeCreateService().createChopboxAnchor(containerShape);

		resizeWholeType(getDiagram(), containerShape);

		return containerShape;
	}

	/**
	 * @param index
	 *            the index for which to calculate the vertical offset from
	 * @return the vertical offset of a Sub-Type with the given index
	 */
	public static int getYOffsetForIndex(Diagram diagram, DataType object, int index) {
		int result = 110;
		if (object.getBelongsTo() == null)
			return yOffsetInitial;

		ComplexType parent = object.getBelongsTo();

		DataType current = null;
		ContainerShape container = null;
		for (int i = 0; i < index; i++) {
			current = parent.getSubtypes().get(i);
			container = Util.getContainerForBusinessObject(diagram, current);
			if (container != null)
				result += container.getGraphicsAlgorithm().getHeight();
			if (i > 0)
				result += 10;
		}
		return result + yOffsetInitial;

		// return yOffsetInitial + (height + spacing) * context;
	}

	/**
	 * Calculates the optimal width for the root view depending on text widths
	 * and children widths.<br>
	 * sets the y-positions of the roots children.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param root
	 *            the top level complex type
	 * @return the width
	 */
	private static int setPositionsAndCalculateRootWidth(Diagram diagram, DataType root) {

		int result = 0;
		int currentWidth = 0;
		int currentY = yOffsetInitial;

		ArrayList<ContainerShape> usedContainers = new ArrayList<ContainerShape>();


		Map<String, Text> map = AttributeMap.instance().getObjectMap(root);
		Text name = map.get("name");
		name.setValue(root.getName());
		Text title = map.get("title");
		String nameString = name.getValue();
		String titleString = title.getValue();

		result = Util.getTextWidth(diagram, nameString + titleString, false, true) + 20;

		if (root instanceof ComplexType && ((ComplexType) root).getSubtypes() != null) {
			ComplexType rootCT = (ComplexType) root;
			ContainerShape rootContainer = Util.getContainerForBusinessObject(diagram, rootCT);
			// GraphicsAlgorithm rootGA = rootContainer.getGraphicsAlgorithm();
			for (DataType dt : rootCT.getSubreferences()) {
				ArrayList<ContainerShape> dtContainers = Util.getContainersForBusinessObject(diagram, dt);
				// GraphicsAlgorithm dtGA = dtContainer.getGraphicsAlgorithm();

				// rootContainer.getChildren().add(dtContainer);
				SubreferenceHelper sub = new SubreferenceHelper(fp, dt, (ComplexType) root);

				for (ContainerShape dtContainer : dtContainers) {
					ContainerShape subContainer = null;

					boolean alreadyExists = false;
					for (Shape child : rootContainer.getChildren()) {
						EObject childObj = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(child);
						if (childObj instanceof SubreferenceHelper && ((SubreferenceHelper) childObj).getReference() == dt) {
							alreadyExists = true;
							if (child instanceof ContainerShape)
								subContainer = (ContainerShape) child;
						}
					}

					if (!alreadyExists) {
						subContainer = sub.cloneContainer(dtContainer, rootContainer);
						rootContainer.getChildren().add(subContainer);

					}
					if (subContainer != null) {
						subContainer.getGraphicsAlgorithm().setY(currentY);
						currentY += subContainer.getGraphicsAlgorithm().getHeight() + 10;
						currentWidth = Math.max(currentWidth, subContainer.getGraphicsAlgorithm().getWidth() + 10);
					}
				}
			}
			// take the root element's children and get their width
			map = AttributeMap.instance().getObjectMap(root);
			name = map.get("name");
			title = map.get("title");

			name.setValue(root.getName());

			for (DataType type : ((ComplexType) root).getSubtypes()) {
				map = AttributeMap.instance().getObjectMap(type);
				name = map.get("name");
				title = map.get("title");

				name.setValue(type.getName());

				if (name != null && title != null) {
					nameString = name.getValue();
					titleString = title.getValue();
					currentWidth = Math.max(currentWidth, Util.getTextWidth(diagram, nameString + titleString, false, true) + 20);
					if (type instanceof ComplexType)
						currentWidth = Math.max(currentWidth, setPositionsAndCalculateRootWidth(diagram, (ComplexType) type) + 20);

				}

				ArrayList<ContainerShape> containers = Util.getContainersForBusinessObject(diagram, type);
				ContainerShape currentContainer = Util.getContainerForBusinessObject(diagram, type);

				for (int i = 0; i < containers.size(); i++) {
					if (!usedContainers.contains(containers.get(i))) {
						currentContainer = containers.get(i);
						usedContainers.add(currentContainer);
						break;
					}
				}

				GraphicsAlgorithm typeGraphic = currentContainer.getGraphicsAlgorithm();
				typeGraphic.setY(currentY);

				currentY += typeGraphic.getHeight() + 10;
			}

			Util.getContainerForBusinessObject(diagram, root).getGraphicsAlgorithm().setHeight(currentY);
		}
		if (currentWidth > result)
			result = currentWidth;
		return result + 10 - result % 10;
	}

	/**
	 * resizes the type and it's subtypes.
	 * 
	 * @param diagram
	 *            the diagram
	 * @param rootPe
	 *            the PictogramElement of the root ComplexType
	 * @param width
	 *            the width to set for the root (can be calculated via
	 *            {@link #setPositionsAndCalculateRootWidth(Diagram, ComplexType)}
	 *            )
	 */
	private static void resizeType(Diagram diagram, PictogramElement rootPe, int width) {

		Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(rootPe);
		final Map<String, Text> map = AttributeMap.instance().getObjectMap(bo);
		boolean nomap = false;
		if (map == null){
			nomap = true;
		}

		if(!nomap){
			Text text = map.get("name");
			text.setWidth(width - 8);
		}
		rootPe.getGraphicsAlgorithm().setWidth(width);

		

		if (/* bo instanceof ComplexType && */rootPe instanceof ContainerShape) {

			boolean firstLineFound = false;
			for (Shape s : ((ContainerShape) rootPe).getChildren()) {

				GraphicsAlgorithm ga = s.getGraphicsAlgorithm();
				// resize line
				ga.setWidth(width - 20);
				if (!firstLineFound && ga instanceof Polyline && ((Polyline) ga).getPoints().size() == 2) {
					((Polyline) ga).getPoints().get(1).setX(width);
					firstLineFound = true;
				}
				
				if(ga instanceof Text){
					ga.setWidth(width-10);
				}

				// resize sub types
				if (s instanceof ContainerShape)
					resizeType(diagram, s, width - 20);
			}
		}
	}

	/**
	 * takes a {@link PictogramElement} of a {@link DataType} and resizes the
	 * whole {@link ComplexType} up to it's root
	 * 
	 * @param diagram
	 *            the Diagram
	 * @param pe
	 *            The {@link DataType}'s {@link PictogramElement}
	 */
	public static void resizeWholeType(Diagram diagram, PictogramElement pe) {
		if (Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe) instanceof SubreferenceHelper) {

		} else {
			DataType bo = (DataType) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			ComplexType parent = null;
			if (bo == null)
				return;
			parent = bo.getBelongsTo();

			if (parent != null) {
				List<PictogramElement> pictogramElements = Graphiti.getLinkService().getPictogramElements(diagram, parent);
				for (PictogramElement parentPe : pictogramElements) {
					if (parentPe instanceof ContainerShape) {
						resizeWholeType(diagram, parentPe);
						return;
					}
				}
			} else {
				if (bo != null) {
					resizeType(diagram, pe, setPositionsAndCalculateRootWidth(diagram, bo));
				}
			}
		}
	}
}
