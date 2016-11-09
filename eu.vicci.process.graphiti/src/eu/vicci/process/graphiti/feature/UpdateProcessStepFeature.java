package eu.vicci.process.graphiti.feature;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.impl.AbstractUpdateFeature;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;

import eu.vicci.process.model.sofia.ProcessStep;

public class UpdateProcessStepFeature extends AbstractUpdateFeature {

    public UpdateProcessStepFeature(IFeatureProvider fp) {

        super(fp);
    }

    @Override
    public boolean canUpdate(IUpdateContext context) {

        Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
        return (object instanceof ProcessStep);
    }

    @Override
    public IReason updateNeeded(IUpdateContext context) {

        // retrieve name from pictogram model
        String pName = null;
        PictogramElement element = context.getPictogramElement();

        Object object = getBusinessObjectForPictogramElement(element);

        // In order to enable the capability of a ContainerShape to contain
        // multiple Text graphics, this Variable is necessary
        boolean found = false;

        if (element instanceof ContainerShape) {
            ContainerShape cs = (ContainerShape) element;
            for (Shape shape : cs.getChildren()) {
                // System.out.println(getBusinessObjectForPictogramElement(shape));
                if (shape.getGraphicsAlgorithm() instanceof Text) {

                    Text text = (Text) shape.getGraphicsAlgorithm();
                    // +getBusinessObjectForPictogramElement(shape));
                    pName = text.getValue();

                    if (pName.equals(((ProcessStep) object).getName()))
                        found = true;
                }
            }
        }

        // retrieve name from business model
        String name = null;
        String actualName = null;
        if (object instanceof ProcessStep) {
            name = ((ProcessStep) object).getName();
            actualName = ((ProcessStep) object).getName();
        }
        if (actualName != null && (actualName.equals("If") || actualName.equals("Or"))) {
            found = true;
            pName = actualName;
        }

        // update needed, if names are different
        boolean update = ((pName == null && name != null) || (pName != null && !found));

        if (update) {
            return Reason.createTrueReason("Name is out of date");

        } else
            return Reason.createFalseReason();
    }

    @Override
    public boolean update(IUpdateContext context) {

        /*
         * // retrieve name from business model String businessName = null;
         * PictogramElement pictogramElement = context.getPictogramElement();
         * Object object =
         * getBusinessObjectForPictogramElement(pictogramElement);
         *
         * if (object instanceof Loop) { businessName = ((Loop)
         * object).getName(); }
         *
         * else if (object instanceof ProcessStep) businessName = ((ProcessStep)
         * object).getName();
         *
         *
         * // Set name in pictogram model if (pictogramElement instanceof
         * ContainerShape) { ContainerShape cs = (ContainerShape)
         * pictogramElement; for (Shape shape : cs.getChildren()) { if
         * (shape.getGraphicsAlgorithm() instanceof Text) { Text text = (Text)
         * shape.getGraphicsAlgorithm();
         *
         * if (object instanceof Loop) { if (text.getValue() != ((Loop)
         * object).getName()) {
         *
         * Condition condition = ((Loop) object).getLoopCondition(); if
         * (condition != null) text.setValue("  (" + condition.toString() +
         * ")"); else text.setValue(businessName);// + // "  (Condition)");
         * return true; } else { System.out.println(text.getValue());
         * text.setValue("for" + businessName); } } } } }
         */

        return false;
    }
}
