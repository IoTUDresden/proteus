package eu.vicci.process.graphiti.feature.create;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.AbstractCreateFeature;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;

public abstract class OpenHabSemanticInvokeCreateFeatureBase extends AbstractCreateFeature {

	private String stepName;
	private OpenHabSemanticInvokeCreateFeatureFactory factory;

	/**
	 * Constructor for a create feature.
	 *
	 * @param fp
	 *            the feature provider for which the feature is created
	 */
	public OpenHabSemanticInvokeCreateFeatureBase(IFeatureProvider fp, String stepName, String description,
			OpenHabSemanticInvokeCreateFeatureFactory factory) {
		super(fp, stepName, description);
		this.stepName = stepName;
		this.factory = factory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canCreate(ICreateContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getTargetContainer());
		return bo instanceof CompositeStep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] create(ICreateContext context) {
		OpenHabSemanticInvoke invokeStep = factory.createOpenHabSemanticInvoke();
		getDiagram().eResource().getContents().add(invokeStep);

		invokeStep.setId(EcoreUtil.generateUUID());
		invokeStep.setName(stepName);

		Object target = getBusinessObjectForPictogramElement(context.getTargetContainer());
		if (target instanceof CompositeStep)
			((CompositeStep) target).getSubSteps().add(invokeStep);

		addGraphicalRepresentation(context, invokeStep);
		ProcessStepCreateHelper.drawNameAndType(invokeStep);

		return new Object[] { invokeStep };
	}
	
	public static interface OpenHabSemanticInvokeCreateFeatureFactory{
		public OpenHabSemanticInvoke createOpenHabSemanticInvoke();
	}
}
