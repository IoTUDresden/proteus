package eu.vicci.process.graphiti.feature;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.graphiti.ui.features.DefaultDeleteFeature;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Event;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Invoke;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.StartPort;

public class PortDeleteFeature extends DefaultDeleteFeature {

	public PortDeleteFeature(IFeatureProvider fp) {

		super(fp);
	}

	@Override
	public boolean canDelete(IDeleteContext context) {
		if (!super.canDelete(context))
			return false;

		Object object = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return (object instanceof Port);
	}

	PictogramElement getProcessPictogram(PictogramElement element) {

		Object object = getBusinessObjectForPictogramElement(element);

		if (object instanceof ProcessStep)
			return element;

		else if (element.eContainer() instanceof PictogramElement)
			return getProcessPictogram((PictogramElement) element.eContainer());

		return null;
	}

	/*
	 * @see org.eclipse.graphiti.func.IDelete#delete(org.eclipse.graphiti.features
	 * .context.IDeleteContext)
	 */
	@Override
	public void delete(IDeleteContext context) {
		IGaService gaService = Graphiti.getGaService();
		IPeService peService = Graphiti.getPeService();

		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		int bottom = 0;

		if (!(bo instanceof Port))
			return;

		ProcessStep step = ((Port) bo).getProcessStep();

		super.delete(context);

		int yOffset = 0;
		if (step instanceof Process)
			yOffset = 25;
		else if (step instanceof Invoke)
			yOffset = 25;
		else if (step instanceof Event)
			yOffset = 25;
		else if (step instanceof Or)
			yOffset = 0;

		if (bo instanceof StartPort && step != null) {

			EList<Port> ports = step.getPorts();

			int index = 0;
			for (Port port : ports) {
				if (!(port instanceof StartPort))
					continue;

				// TODO no renaming of ports
				// port.setName("start_" + index);
				Object[] pictogramElements = peService.getLinkedPictogramElements(new EObject[] { port },
						getDiagram());
				for (Object element : pictogramElements) {
					if (element instanceof ContainerShape) {
						gaService.setLocationAndSize(((ContainerShape) element).getGraphicsAlgorithm(), 0,
								yOffset + 15 * index, ((ContainerShape) element).getGraphicsAlgorithm()
										.getWidth(), ((ContainerShape) element).getGraphicsAlgorithm()
										.getHeight());
					}
				}
				index++;
			}
		}

		if (bo instanceof EndPort) {
			// PictogramElement processElement =
			// getProcessPictogram(context.getPictogramElement());
			// width = processElement.getGraphicsAlgorithm().getWidth();

			EList<Port> ports = step.getPorts();

			int index = 0;
			for (Port port : ports) {
				if (!(port instanceof EndPort))
					continue;

				// TODO no renaming of ports
				// port.setName("end_" + index);
				Object[] pictogramElements = peService.getLinkedPictogramElements(new EObject[] { port },
						getDiagram());
				for (Object element : pictogramElements) {
					if (element instanceof ContainerShape) {
						gaService.setLocationAndSize(((ContainerShape) element).getGraphicsAlgorithm(),
								((ContainerShape) element).getGraphicsAlgorithm().getX(), yOffset + 15
										* index,
								((ContainerShape) element).getGraphicsAlgorithm().getWidth(),
								((ContainerShape) element).getGraphicsAlgorithm().getHeight());
					}
				}
				index++;

			}
		}

		System.out.println(step.getPorts().size());
		if (step instanceof If || step instanceof Or) {
			bottom = 40;
			ContainerShape cont = Util.getContainerForBusinessObject(getDiagram(), step);
			for (Port port : step.getPorts()) {
				GraphicsAlgorithm ga = Util.getContainerForBusinessObject(getDiagram(), port)
						.getGraphicsAlgorithm();
				if (bottom < ga.getHeight())
					bottom = ga.getHeight();
			}
			if (context.getPictogramElement() instanceof ContainerShape)
				Util.resizeAndIfOr(cont, cont.getGraphicsAlgorithm().getHeight(), bottom);
		}
		for (PictogramElement pe : peService.getAllContainedPictogramElements(getDiagram()))
			updatePictogramElement(pe);
	}
}
