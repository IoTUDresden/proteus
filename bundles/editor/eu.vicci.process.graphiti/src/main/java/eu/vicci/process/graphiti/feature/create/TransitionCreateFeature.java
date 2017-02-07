package eu.vicci.process.graphiti.feature.create;

import java.util.ArrayList;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateConnectionContext;
import org.eclipse.graphiti.features.context.impl.AddConnectionContext;
import org.eclipse.graphiti.features.impl.AbstractCreateConnectionFeature;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.Connection;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.ControlPort;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StartPort;
import eu.vicci.process.model.sofia.Transition;

/**
 */
public class TransitionCreateFeature extends AbstractCreateConnectionFeature {

	/**
	 * Constructor for a transition create feature.
	 * 
	 * @param fp
	 *            the feature provider for which the feature is created
	 */
	public TransitionCreateFeature(IFeatureProvider fp) {
		super(fp, "Transition", "Create a Transition");
	}

	/**
	 * Retrieve the task linked with the given anchor's parent.
	 * 
	 * @param anchor
	 *            an anchor for the source or target of the new connection
	 * @return the corresponding task, or {@code null} if there is none
	 */
	private Port getState(Anchor anchor) {

		if (anchor != null) {
			Object object = getBusinessObjectForPictogramElement(anchor.getParent());

			if (object instanceof Port)
				return (Port) object;
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canStartConnection(ICreateConnectionContext context) {

		Port port = getState(context.getSourceAnchor());
		return port != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canCreate(ICreateConnectionContext context) {
		Object source = getState(context.getSourceAnchor());
		Object target = getState(context.getTargetAnchor());
		if (target == null || source == target)
			return false;
		if (!(source instanceof Port && target instanceof Port))
			return false;

		Port sourceport = (Port) source;
		Port targetport = (Port) target;

		if (sourceport instanceof StartPort)
			if (!canAttachStartPortToTargetPort(sourceport, targetport))
				return false;

		if (sourceport instanceof EndPort)
			if (!canAttachEndPortToTargetPort(sourceport, targetport))
				return false;

		if (hasCycle(sourceport, targetport, null))
			return false;

		return sourcePortTypeEqualsTargetPortType(source, target);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Connection create(ICreateConnectionContext context) {

		Port source = getState(context.getSourceAnchor());
		Port target = getState(context.getTargetAnchor());

		if (source == null || target == null)
			throw new IllegalStateException("Cannot retrieve the source or target.");

		Transition transition = SofiaFactory.eINSTANCE.createTransition();
		transition.setId(EcoreUtil.generateUUID());
		transition.setName("transition");
		getDiagram().eResource().getContents().add(transition);
		transition.setSourcePort(source);
		transition.setTargetPort(target);

		AddConnectionContext addContext = new AddConnectionContext(context.getSourceAnchor(),
				context.getTargetAnchor());
		addContext.setNewObject(transition);

		return (Connection) getFeatureProvider().addIfPossible(addContext);
	}

	private static boolean canAttachEndPortToTargetPort(Port sourceport, Port targetport) {		
		if (targetport.getProcessStep() instanceof Process
				&& targetport instanceof EndPort
				&& !((Process) targetport.getProcessStep()).getSubSteps().contains(
						sourceport.getProcessStep()))
			return false;

		if (targetport instanceof EndPort && !(sourceOrTargetIsSupportedProcessStep(targetport)))
			return false;
		
		ProcessStep sourceStep = sourceport.getProcessStep();
		CompositeStep targetParentStep = targetport.getProcessStep().getParentstep();
		
		if(targetParentStep == null)
			if(targetIsProcess(sourceport, targetport))
				return true;
			else
				return false;

		if (targetport instanceof StartPort	&& !targetParentStep.getSubSteps().contains(sourceStep))
			return false;

		if (targetport.getProcessStep() instanceof Loop
				&& targetport instanceof EndPort
				&& !((Loop)targetport.getProcessStep()).getSubSteps().contains(sourceport.getProcessStep()))
			return false;

		return true;
	}

	private static boolean canAttachStartPortToTargetPort(Port sourceport, Port targetport) {
		if (sourceport.getProcessStep() instanceof Process
				&& !((Process) sourceport.getProcessStep()).getSubSteps().contains(
						targetport.getProcessStep()))
			return false;

		if (sourceport.getProcessStep() instanceof Loop
				&& !((Loop) sourceport.getProcessStep()).getSubSteps().contains(
						targetport.getProcessStep()))
			return false;

		if (!sourceOrTargetIsSupportedProcessStep(sourceport))
			return false;

		return true;
	}

	private static boolean sourceOrTargetIsSupportedProcessStep(Port port) {
		if (port.getProcessStep() instanceof Process)
			return true;
		if (port.getProcessStep() instanceof Loop)
			return true;
		return false;
	}

	private static boolean sourcePortTypeEqualsTargetPortType(Object source, Object target) {
		return ((source instanceof DataPort) && (target instanceof DataPort))
				|| ((source instanceof ControlPort) && (target instanceof ControlPort));
	}

	//FIXME this doesnt work correct in loops
	//at the moment you should take care for cycles
	private static boolean hasCycle(Port sourceport, Port targetport, ArrayList<ProcessStep> list) {
		return false;
//		if (sourceport.getProcessStep().getParentstep() == targetport.getProcessStep()
//				|| targetport.getProcessStep().getParentstep() == sourceport.getProcessStep()) {
//			return false;
//		}
//		if (list == null) {
//			list = new ArrayList<ProcessStep>();
//			list.add(sourceport.getProcessStep());
//		}
//		if (list.contains(targetport.getProcessStep()))
//			return true;
//		list.add(targetport.getProcessStep());
//
//		for (Port portOfTarget : targetport.getProcessStep().getPorts()) {
//			for (Transition outTrans : portOfTarget.getOutTransitions()) {
//				return hasCycle(null, outTrans.getTargetPort(), list);
//			}
//		}
//		return false;
	}
	
	private static boolean targetIsProcess(Port sourceport, Port targetport){
		return targetport.getProcessStep() instanceof Process;
			
	}
}