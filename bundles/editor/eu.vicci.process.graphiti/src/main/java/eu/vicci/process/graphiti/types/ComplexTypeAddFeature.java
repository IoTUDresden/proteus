package eu.vicci.process.graphiti.types;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.features.impl.AbstractAddShapeFeature;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Font;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Process;

public class ComplexTypeAddFeature extends AbstractAddShapeFeature {

    private static final IColorConstant CLASS_FOREGROUND =
            new ColorConstant(102, 102, 102);
    private static final IColorConstant CLASS_BACKGROUND =
            new ColorConstant(230, 230, 230);
    private static final IColorConstant CLASS_TEXT_FOREGROUND =
            new ColorConstant(0, 0, 0);

    private static final String label = "Complex Type";

    /**
     * Constructor for an Invoke add feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ComplexTypeAddFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public boolean canAdd(IAddContext context) {
        return context.getNewObject() instanceof ComplexType &&
                (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Process ||
                        getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ComplexType);
    }

    @Override
    public PictogramElement add(IAddContext context) {

        ComplexType object = (ComplexType) context.getNewObject();

        IGaService gaService = Graphiti.getGaService();

        Font titleFont = gaService.manageDefaultFont(getDiagram(), false, true);
        int textWidth = Util.getTextWidth(getDiagram(), label + " " + object.getName(), titleFont);

        int width = Math.max(120, textWidth);
        int height = 40;

        ContainerShape containerShape =
                Graphiti.getPeCreateService().createContainerShape(context.getTargetContainer(), true);

        RoundedRectangle roundedRectangle = gaService.createPlainRoundedRectangle(containerShape, 10, 10);

        roundedRectangle.setForeground(manageColor(CLASS_FOREGROUND));
        roundedRectangle.setBackground(manageColor(CLASS_BACKGROUND));
        roundedRectangle.setFilled(true);
        roundedRectangle.setLineWidth(2);

        link(containerShape, object);

        Shape lineShape = Graphiti.getPeCreateService().createShape(containerShape, false);
        Polyline polyline = gaService.createPolyline(lineShape, new int[] { 0, 20, width, 20 });
        polyline.setForeground(manageColor(CLASS_FOREGROUND));
        polyline.setLineWidth(2);
        link(lineShape, object);

        Shape shape = Graphiti.getPeCreateService().createShape(containerShape, false);
        Text titleText = gaService.createText(shape, label);
        titleText.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
        titleText.setHorizontalAlignment(Orientation.ALIGNMENT_LEFT);
        titleText.setFont(titleFont);
        gaService.setLocationAndSize(titleText, 4, 4, width - 8, 12);
        link(shape, object);

        AttributeMap.instance().addObjectMapItem(object, "title", titleText);

        shape = Graphiti.getPeCreateService().createShape(containerShape, false);

        Text nameText = gaService.createText(shape, object.getName());
        nameText.setForeground(manageColor(CLASS_TEXT_FOREGROUND));
        nameText.setHorizontalAlignment(Orientation.ALIGNMENT_RIGHT);
        nameText.setFont(titleFont);
        gaService.setLocationAndSize(nameText, 0, 4, width - 8, 12);
        link(shape, object);

        AttributeMap.instance().addObjectMapItem(object, "name", nameText);

        getFeatureProvider().getDirectEditingInfo().setActive(true);

        Graphiti.getPeCreateService().createChopboxAnchor(containerShape);

        ComplexType target = object.getBelongsTo();
        if (target != null) {
            gaService.setLocationAndSize(roundedRectangle, 10, 30, width, height);
            DataTypeAddFeature.resizeWholeType(getDiagram(),
                    Util.getContainerForBusinessObject(getDiagram(), target));

        } else {
            gaService.setLocationAndSize(roundedRectangle, context.getX(),
                    context.getY(), width, height);
        }

        DataTypeAddFeature.resizeWholeType(getDiagram(), containerShape);

        getFeatureProvider().layoutIfPossible(new LayoutContext(containerShape));

        return containerShape;
    }
}
