package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;
import org.eclipse.graphiti.mm.pictograms.Diagram;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.SofiaFactory;

public class ProcessCreateFeature extends AbstractCreateFeature {

    /**
     * Constructor for a create feature.
     *
     * @param fp
     *            the feature provider for which the feature is created
     */
    public ProcessCreateFeature(IFeatureProvider fp) {

        super(fp, "Process", "Create a Process");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canCreate(ICreateContext context) {
    	boolean targetIsDiagram = context.getTargetContainer() instanceof Diagram;
    	Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
    	
    	if(targetIsDiagram){
    		Diagram diagram = (Diagram) context.getTargetContainer();
    		return diagram.getChildren().size()==0;
    	}
        return bo instanceof CompositeStep;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object[] create(ICreateContext context) {

        Process process = SofiaFactory.eINSTANCE.createProcess();
        getDiagram().eResource().getContents().add(process);

        process.setName("Process");
        process.setId(EcoreUtil.generateUUID());

        Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());

        if (target instanceof CompositeStep)
            ((CompositeStep) target).getSubSteps().add(process);
        else if (target instanceof Diagram)
            getDiagram().eResource().getContents().add(process);

        addGraphicalRepresentation(context, process);
        
        ProcessStepCreateHelper.drawNameAndType(process);
        return new Object[] { process };
    }
}