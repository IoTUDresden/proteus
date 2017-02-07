package eu.vicci.process.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import eu.vicci.process.model.sofia.Process;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class RemoteFilter extends AbstractPropertySectionFilter {

    @Override
    protected boolean accept(PictogramElement pe) {
        EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
        return (bo instanceof Process);
    }

}
