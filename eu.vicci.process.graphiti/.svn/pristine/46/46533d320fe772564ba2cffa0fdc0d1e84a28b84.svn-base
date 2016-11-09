package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class DoubleTypeCreateFeature extends DataTypeCreateFeature {

    public DoubleTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "Double Type", "Create a Double Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        DoubleType doubleType = SofiaFactory.eINSTANCE.createDoubleType();
        getDiagram().eResource().getContents().add(doubleType);

        doubleType.setId(EcoreUtil.generateUUID());
        doubleType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(doubleType);

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(doubleType);
        
        addGraphicalRepresentation(context, doubleType);

        return new Object[] { doubleType };
    }
}
