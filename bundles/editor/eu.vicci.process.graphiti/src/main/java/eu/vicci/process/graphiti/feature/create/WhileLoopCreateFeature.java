package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.WhileLoop;

public class WhileLoopCreateFeature extends AbstractCreateFeature implements
        ICreateFeature {

    public WhileLoopCreateFeature(IFeatureProvider fp) {
        super(fp, "While-Loop", "Create While-Loop");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return bo instanceof CompositeStep;
    }

    @Override
    public Object[] create(ICreateContext context) {

        WhileLoop whileLoop = SofiaFactory.eINSTANCE.createWhileLoop();
        getDiagram().eResource().getContents().add(whileLoop);

        whileLoop.setId(EcoreUtil.generateUUID());
        whileLoop.setName("While");
        Condition cond = SofiaFactory.eINSTANCE.createCondition();
        cond.setComparator(Comparator.IDENTIC);
        whileLoop.setLoopCondition(cond);

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(whileLoop);

        addGraphicalRepresentation(context, whileLoop);
        ProcessStepCreateHelper.drawNameAndType(whileLoop);

        return new Object[] { whileLoop };
    }

}
