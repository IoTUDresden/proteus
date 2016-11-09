package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StringType;

public class StringTypeCreateFeature extends DataTypeCreateFeature {

    public StringTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "String Type", "Create a String Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {

       return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        StringType stringType = SofiaFactory.eINSTANCE.createStringType();
        getDiagram().eResource().getContents().add(stringType);

        stringType.setId(EcoreUtil.generateUUID());
        stringType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(stringType);

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(stringType);
        
        addGraphicalRepresentation(context, stringType);

        return new Object[] { stringType };
    }
}
