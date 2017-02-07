package eu.vicci.process.graphiti.types;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.impl.DefaultMoveShapeFeature;
import org.eclipse.graphiti.services.Graphiti;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;

public class DataTypeMoveShapeFeature extends DefaultMoveShapeFeature {

	public DataTypeMoveShapeFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canMoveShape(IMoveShapeContext context) {
		EObject target = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());
		if(target instanceof ComplexType){
			return true;
		}
		
		return super.canMoveShape(context);
	}
	
	@Override
	public void moveShape(IMoveShapeContext context) {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getPictogramElement());
		EObject target = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(context.getTargetContainer());
		if(target instanceof ComplexType && bo instanceof DataType){
			ComplexType targetCT = (ComplexType) target;
			DataType boCT = (DataType) bo;
			
			targetCT.getSubreferences().add(boCT);
			DataTypeAddFeature.resizeWholeType(getDiagram(), context.getTargetContainer());
			return;
		}
		super.moveShape(context);
	}

}
