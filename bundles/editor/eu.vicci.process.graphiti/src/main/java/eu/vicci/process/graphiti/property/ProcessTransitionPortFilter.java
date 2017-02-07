package eu.vicci.process.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.Transition;

public class ProcessTransitionPortFilter extends AbstractPropertySectionFilter {

    @Override
    protected boolean accept(PictogramElement pe) {

        EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        return (bo instanceof ProcessStep || bo instanceof Transition || bo instanceof Port);
    }
}
