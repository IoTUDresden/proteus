package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class BooleanTypeCreateFeature extends DataTypeCreateFeature {

    public BooleanTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "Boolean Type", "Create a Boolean Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {

        return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        BooleanType booleanType = SofiaFactory.eINSTANCE.createBooleanType();
        getDiagram().eResource().getContents().add(booleanType);
        
        booleanType.setId(EcoreUtil.generateUUID());
        booleanType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(booleanType);

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(booleanType);
        
        addGraphicalRepresentation(context, booleanType);

        return new Object[] { booleanType };
    }
}
