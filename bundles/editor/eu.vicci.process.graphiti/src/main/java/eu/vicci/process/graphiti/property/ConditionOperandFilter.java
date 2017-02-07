package eu.vicci.process.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import eu.vicci.process.model.sofia.If;

public class ConditionOperandFilter extends AbstractPropertySectionFilter {

    @Override
    protected boolean accept(PictogramElement pe) {

        EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        return (bo instanceof If);
    }
}
