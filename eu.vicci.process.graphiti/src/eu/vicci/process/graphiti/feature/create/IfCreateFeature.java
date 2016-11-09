package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.SofiaFactory;

public class IfCreateFeature extends AbstractCreateFeature implements
        ICreateFeature {

    public IfCreateFeature(IFeatureProvider fp) {
        super(fp, "If", "Create an If");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	ContainerShape target = context.getTargetContainer();
    	Object bo = getBusinessObjectForPictogramElement(target);    	
        return bo instanceof CompositeStep;
    }

    @Override
    public Object[] create(ICreateContext context) {

        If iF = SofiaFactory.eINSTANCE.createIf();
        getDiagram().eResource().getContents().add(iF);

        iF.setId(EcoreUtil.generateUUID());
        iF.setName("If"); // needed for renaming, don't delete
        Condition cond = SofiaFactory.eINSTANCE.createCondition();
        cond.setComparator(Comparator.IDENTIC);
        iF.setIfCondition(cond);

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(iF);

        addGraphicalRepresentation(context, iF);

        return new Object[] { iF };
    }

}
