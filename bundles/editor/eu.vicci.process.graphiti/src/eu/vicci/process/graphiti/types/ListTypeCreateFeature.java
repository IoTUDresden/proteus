package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class ListTypeCreateFeature extends DataTypeCreateFeature {

    public ListTypeCreateFeature(IFeatureProvider fp) {

        super(fp, "List Type", "Create a List Type");
    }

    @Override
    public boolean canCreate(ICreateContext context) {

        return super.canCreate(context);
    }

    @Override
    public Object[] create(ICreateContext context) {

        ListType listType = SofiaFactory.eINSTANCE.createListType();
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
