/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *
 * </copyright>
 *
 *******************************************************************************/
package eu.vicci.process.graphiti;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.graphiti.datatypes.ILocation;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.impl.CreateConnectionContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.ConnectionCreationToolEntry;
import org.eclipse.graphiti.palette.impl.ObjectCreationToolEntry;
import org.eclipse.graphiti.palette.impl.PaletteCompartmentEntry;
import org.eclipse.graphiti.palette.impl.StackEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;

import eu.vicci.process.graphiti.feature.RenameTaskFeature;
import eu.vicci.process.graphiti.feature.create.EndPortCreateFeature;
import eu.vicci.process.graphiti.feature.create.StartPortCreateFeature;
import eu.vicci.process.graphiti.types.DataTypeCreateFeature;
import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Invoke;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;

public class ToolBehaviorProvider extends DefaultToolBehaviorProvider {

	public ToolBehaviorProvider(IDiagramTypeProvider dtp) {
		super(dtp);
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {

		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();

		// set the generic context buttons
		setGenericContextButtons(data, pe, CONTEXT_BUTTON_DELETE | CONTEXT_BUTTON_UPDATE);

		// add one domain specific context-button, which offers all
		// available connection-features as drag&drop features...
		CreateConnectionContext ccc = new CreateConnectionContext();
		ccc.setSourcePictogramElement(pe);
		Anchor anchor = null;
		if (pe instanceof Anchor) {
			anchor = (Anchor) pe;

		} else if (pe instanceof AnchorContainer) {
			// assume, that our shapes always have chopbox anchors
			anchor = Graphiti.getPeService().getChopboxAnchor((AnchorContainer) pe);
		}

		if (anchor == null)
			return data;

		EList<EObject> bos = anchor.getParent().getLink().getBusinessObjects();
		for (EObject bo : bos) {

			if (bo instanceof Port) {
				ProcessStep step = ((Port) bo).getProcessStep();
				if (step instanceof If || step instanceof Or || step instanceof And) {
					return data;
				}
			}
		}

		ccc.setSourceAnchor(anchor);

		// create context button and add all applicable features
		ContextButtonEntry button = new ContextButtonEntry(null, context);
		button.setText("Create connection"); //$NON-NLS-1$
		ICreateConnectionFeature[] features = getFeatureProvider().getCreateConnectionFeatures();
		for (ICreateConnectionFeature feature : features)
			if (feature.isAvailable(ccc) && feature.canStartConnection(ccc)) {
				button.addDragAndDropFeature(feature);

				button.setIconId(IPlatformImageConstants.PRE);
			}

		// add context button, if it contains at least one feature
		if (button.getDragAndDropFeatures().size() > 0)
			data.getDomainSpecificContextButtons().add(button);
		data.getPadLocation().setX(data.getPadLocation().getX() - 30);
		data.getPadLocation().setWidth(data.getPadLocation().getWidth() + 30);
		return data;
	}

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {

		// create a sub-menu for all custom features
		ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
		subMenu.setText("Cu&stom"); //$NON-NLS-1$
		subMenu.setDescription("Custom features submenu"); //$NON-NLS-1$
		// display sub-menu hierarchical or flat
		subMenu.setSubmenu(true);

		// create a menu-entry in the sub-menu for each custom feature
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);

		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context)) {
				ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
				subMenu.add(menuEntry);
			}
		}

		IContextMenuEntry ret[] = new IContextMenuEntry[] { subMenu };
		return ret;
	}

	@Override
	public ILocation getAbsoluteLocation(GraphicsAlgorithm ga) {

		return super.getAbsoluteLocation(ga);
	}

	@Override
	public IPaletteCompartmentEntry[] getPalette() {

		List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

		// add compartments from super class
		IPaletteCompartmentEntry[] superCompartments = super.getPalette();
		for (IPaletteCompartmentEntry entry : superCompartments) {
			entry.setInitiallyOpen(false);
		}
		ret.add(superCompartments[0]);
		// for (int i = 0; i < superCompartments.length; i++){
		// ret.add(superCompartments[i]);
		// }

		// add new compartment after "Objects" for DataTypes
		PaletteCompartmentEntry objectCompartmentEntry = new PaletteCompartmentEntry("Objects", null); //$NON-NLS-1$
		ret.add(objectCompartmentEntry);
		objectCompartmentEntry.setInitiallyOpen(false);

		PaletteCompartmentEntry typesCompartmentEntry = new PaletteCompartmentEntry("Types", null); //$NON-NLS-1$
		typesCompartmentEntry.setInitiallyOpen(false);
		ret.add(typesCompartmentEntry);

		PaletteCompartmentEntry portsCompartmentEntry = new PaletteCompartmentEntry("Ports", null); //$NON-NLS-1$
		portsCompartmentEntry.setInitiallyOpen(false);
		ret.add(portsCompartmentEntry);

		// for (IToolEntry e : superCompartments[1].getToolEntries()){
		// if(e.getLabel().contains("Type"))
		// typesCompartmentEntry.addToolEntry(e);
		// else
		// objectCompartmentEntry.addToolEntry(e);
		// }

		for (ICreateFeature cf : getFeatureProvider().getCreateFeatures()) {
			ObjectCreationToolEntry newToolEntry = new ObjectCreationToolEntry(cf.getCreateName(),
					cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId(), cf);

			if (cf instanceof DataTypeCreateFeature)
				typesCompartmentEntry.addToolEntry(newToolEntry);
			else if (cf instanceof StartPortCreateFeature || cf instanceof EndPortCreateFeature)
				portsCompartmentEntry.addToolEntry(newToolEntry);
			else
				objectCompartmentEntry.addToolEntry(newToolEntry);
		}

		// add new compartment at the end of the existing compartments
		PaletteCompartmentEntry compartmentEntry = new PaletteCompartmentEntry("Stacked", null); //$NON-NLS-1$
		compartmentEntry.setInitiallyOpen(false);
		ret.add(compartmentEntry);

		// add new stack entry to new compartment
		StackEntry stackEntry = new StackEntry("EObject", "EObject", null); //$NON-NLS-1$ //$NON-NLS-2$
		compartmentEntry.addToolEntry(stackEntry);

		// add all create-features to the new stack-entry
		IFeatureProvider featureProvider = getFeatureProvider();
		ICreateFeature[] createFeatures = featureProvider.getCreateFeatures();

		for (ICreateFeature cf : createFeatures) {
			ObjectCreationToolEntry objectCreationToolEntry = new ObjectCreationToolEntry(cf.getCreateName(),
					cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId(), cf);

			stackEntry.addCreationToolEntry(objectCreationToolEntry);
		}

		// add all create-connection-features to the new stack-entry
		ICreateConnectionFeature[] createConnectionFeatures = featureProvider.getCreateConnectionFeatures();

		for (ICreateConnectionFeature cf : createConnectionFeatures) {
			ConnectionCreationToolEntry connectionCreationToolEntry = new ConnectionCreationToolEntry(
					cf.getCreateName(), cf.getCreateDescription(), cf.getCreateImageId(), cf.getCreateLargeImageId());
			connectionCreationToolEntry.addCreateConnectionFeature(cf);
			stackEntry.addCreationToolEntry(connectionCreationToolEntry);
		}

		return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
	}

	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {

		ICustomFeature customFeature = new RenameTaskFeature(getFeatureProvider());

		// canExecute() tests especially if the context contains a Task
		if (customFeature.canExecute(context))
			return customFeature;

		return super.getDoubleClickFeature(context);
	}

	@Override
	public GraphicsAlgorithm[] getClickArea(PictogramElement pe) {

		IFeatureProvider featureProvider = getFeatureProvider();
		Object object = featureProvider.getBusinessObjectForPictogramElement(pe);
		if (object instanceof Invoke) {
			GraphicsAlgorithm ga = pe.getGraphicsAlgorithm();
			return new GraphicsAlgorithm[] { ga };
		}
		return super.getClickArea(pe);
	}

	@Override
	public GraphicsAlgorithm getSelectionBorder(PictogramElement pe) {

		if (pe instanceof ContainerShape) {
			GraphicsAlgorithm invisible = pe.getGraphicsAlgorithm();
			if (!invisible.getLineVisible()) {
				EList<GraphicsAlgorithm> graphicsAlgorithmChildren = invisible.getGraphicsAlgorithmChildren();
				if (!graphicsAlgorithmChildren.isEmpty())
					return graphicsAlgorithmChildren.get(0);
			}
		}
		return super.getSelectionBorder(pe);
	}

	@Override
	public Object getToolTip(GraphicsAlgorithm ga) {

		PictogramElement pe = ga.getPictogramElement();
		Object object = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		if (object instanceof Invoke) {
			String name = ((Invoke) object).getId();
			if (name != null && !(name.length() == 0))
				return name;
		}
		return super.getToolTip(ga);
	}
}
