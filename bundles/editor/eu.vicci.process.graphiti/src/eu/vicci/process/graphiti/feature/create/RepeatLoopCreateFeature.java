package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.RepeatLoop;
import eu.vicci.process.model.sofia.SofiaFactory;

public class RepeatLoopCreateFeature extends AbstractCreateFeature implements
        ICreateFeature {

    public RepeatLoopCreateFeature(IFeatureProvider fp) {
        super(fp, "Repeat-Loop", "Create Repeat-Loop");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return bo instanceof CompositeStep;
    }

    @Override
    public Object[] create(ICreateContext context) {
        RepeatLoop repeatLoop = SofiaFactory.eINSTANCE.createRepeatLoop();
        getDiagram().eResource().getContents().add(repeatLoop);

        repeatLoop.setId(EcoreUtil.generateUUID());
        repeatLoop.setName("RepeatLoop");
        Condition cond = SofiaFactory.eINSTANCE.createCondition();
        cond.setComparator(Comparator.IDENTIC);
        repeatLoop.setLoopCondition(cond);

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(repeatLoop);

        addGraphicalRepresentation(context, repeatLoop);
        ProcessStepCreateHelper.drawNameAndType(repeatLoop);

        return new Object[] { repeatLoop };
    }

}
