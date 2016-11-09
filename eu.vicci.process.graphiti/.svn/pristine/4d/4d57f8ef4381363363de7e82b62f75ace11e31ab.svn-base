package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.SofiaFactory;

public class SetTypeCreateFeature extends DataTypeCreateFeature {

    public SetTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "Set Type", "Create a Set Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {

        return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        SetType listType = SofiaFactory.eINSTANCE.createSetType();
        getDiagram().eResource().getContents().add(listType);
        
        listType.setId(EcoreUtil.generateUUID());
        listType.setName("Name");
        
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof ComplexType)
            ((ComplexType) target).getSubtypes().add(listType);

        if (target instanceof Process)
            ((Process) target).getDataTypeDefinitions().add(listType);
        
        addGraphicalRepresentation(context, listType);

        return new Object[] { listType };
    }
}
