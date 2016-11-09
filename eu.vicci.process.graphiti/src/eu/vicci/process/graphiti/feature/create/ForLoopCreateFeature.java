package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class ForLoopCreateFeature extends AbstractCreateFeature implements
        ICreateFeature {

    public ForLoopCreateFeature(IFeatureProvider fp) {
        super(fp, "For-Loop", "Create For-Loop");
    }

    @Override
    public boolean canCreate(ICreateContext context) {
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
        return bo instanceof Process || bo instanceof Loop;
    }

    @Override
    public Object[] create(ICreateContext context) {
        ForLoop forLoop = SofiaFactory.eINSTANCE.createForLoop();
        getDiagram().eResource().getContents().add(forLoop);

        forLoop.setName("ForLoop");
        forLoop.setId(EcoreUtil.generateUUID());
        Condition cond = SofiaFactory.eINSTANCE.createCondition();
        cond.setComparator(Comparator.IDENTIC);
        forLoop.setLoopCondition(cond);
        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(forLoop);

        addGraphicalRepresentation(context, forLoop);
        ProcessStepCreateHelper.drawNameAndType(forLoop);

        return new Object[] { forLoop };
    }

}
