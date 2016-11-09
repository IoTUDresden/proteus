package eu.vicci.process.graphiti;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.mm.Property;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

public class SofiaPersistencyBehavior extends DefaultPersistencyBehavior {

    public SofiaPersistencyBehavior(DiagramBehavior diagramBehavior) {

        super(diagramBehavior);
    }

    @Override
    public Diagram loadDiagram(URI uri) {

        AttributeMap.instance().clear();
        Diagram diagram = super.loadDiagram(uri);

        // rebuild AttributeMap:
        // Attributes are saved as Properties in the GraphicsAlgorithm of a
        // PictogramElement.
        // The key of the property is "name", the value of the property is the
        // name of the Attribute
        if (diagram == null)
            return null;

        EList<PictogramLink> links = diagram.getPictogramLinks();
        for (PictogramLink link : links) {

            PictogramElement element = link.getPictogramElement();
            EList<Property> propertyList = element.getGraphicsAlgorithm().getProperties();

            Text text = null;
            String key = null;

            // find a Property with key "name"
            for (Property property : propertyList) {
                if (property.getKey().equals("name") &&
                        element.getGraphicsAlgorithm() instanceof Text) {
                    key = property.getValue();
                    text = (Text) element.getGraphicsAlgorithm();
                }
            }

            // add the attribute to all objects linked to the PictogramElement
            EList<EObject> objects = link.getBusinessObjects();
            for (EObject object : objects) {

                if (key != null && text != null)
                    AttributeMap.instance().addObjectMapItem(object, key, text, false);
            }
        }

        return diagram;
    }
}
