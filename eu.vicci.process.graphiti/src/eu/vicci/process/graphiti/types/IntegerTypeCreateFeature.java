package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class IntegerTypeCreateFeature extends DataTypeCreateFeature {

    public IntegerTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "Integer Type", "Create an Integer Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        IntegerType integerType = SofiaFactory.eINSTANCE.createIntegerType();
        getDiagram().eResource().getContents().add(integerType);

        integerType.setId(EcoreUtil.generateUUID());
        integerType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(integerType);

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(integerType);
        
        addGraphicalRepresentation(context, integerType);

        return new Object[] { integerType };
    }
}
