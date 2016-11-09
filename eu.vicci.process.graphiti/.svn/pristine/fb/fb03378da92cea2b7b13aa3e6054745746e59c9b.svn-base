package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class ComplexTypeCreateFeature extends DataTypeCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ComplexTypeCreateFeature(IFeatureProvider fp) {
        super(fp, "Complex Type", "Create a Complex Type");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateContext context) {
        return (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof Process) ||
                (getBusinessObjectForPictogramElement(context.getTargetContainer()) instanceof ComplexType);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] create(ICreateContext context) {

        ComplexType complexType = SofiaFactory.eINSTANCE.createComplexType();
        getDiagram().eResource().getContents().add(complexType);
        
        complexType.setId(EcoreUtil.generateUUID());
        complexType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(complexType);
        else if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(complexType);

        addGraphicalRepresentation(context, complexType);

        return new Object[] { complexType };
    }
}