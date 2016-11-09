package eu.vicci.process.graphiti.types;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.impl.ProcessImpl;

public class DataTypeCreateFeature extends AbstractCreateFeature {

    public DataTypeCreateFeature(IFeatureProvider fp, String name, String description) {

        super(fp, name, description);
    }

    @Override
    public boolean canCreate(ICreateContext context) {

        PictogramElement container = context.getTargetContainer();
        Object bo = getBusinessObjectForPictogramElement(container);
        
        return bo instanceof ComplexType || bo instanceof ProcessImpl;
    }

    @Override
    public Object[] create(ICreateContext context) {
//
//        DataType dataType = SofiaFactory.eINSTANCE.createIntegerType();
//        getDiagram().eResource().getContents().add(dataType);
//        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
//
//        if (target instanceof ComplexType)
//            ((ComplexType) target).getSubtypes().add(dataType);
//
//        addGraphicalRepresentation(context, dataType);
//
//        return new Object[] { dataType };
    	return null;
    }
}
