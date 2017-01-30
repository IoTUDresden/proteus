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
package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.graphiti.types.DataTypeAddFeature;
import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.DataType;

public class CollectionTypeSection extends PropertySectionBase {

	private static CCombo dropdown;
	private List<DataType> dataTypes = new ArrayList<DataType>();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		FormData data;

		Composite composite = factory.createFlatFormComposite(parent);
		composite.addFocusListener(new StateFocusListener());
		dropdown = factory.createCCombo(composite);
		dropdown.removeAll();
		dataTypes.clear();
		for (DataType type : dataTypes)
			dropdown.add(type.getName());

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(dropdown, 200);
		data.top = new FormAttachment(0, VSPACE);
		dropdown.setLayoutData(data);
		dropdown.addFocusListener(new StateFocusListener());

		CLabel typeLabel = factory.createCLabel(composite, "Element Type:");
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(dropdown, HSPACE);
		typeLabel.setLayoutData(data);
	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo instanceof CollectionType) {

				List<DataType> types = Util.getAllReferableDataTypes(getDiagram(), pe);

				dropdown.removeAll();
				for (DataType type : types) {
					if (type.getName() != null && type != bo)
						dropdown.add(type.getName());
				}

				CollectionType collection = (CollectionType) bo;
				if (collection.getCollectionItemType() != null){
					for (String dropdownItem : dropdown.getItems()) {
						if (collection.getCollectionItemType().getName().equals(dropdownItem)) {
							dropdown.select(dropdown.indexOf(dropdownItem));
							break;
						}
					}
				}
			}
		}
	}

	private class StateFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {

		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void focusLost(FocusEvent e) {

			final PictogramElement pe = getSelectedPictogramElement();

			if (pe != null) {

				final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
//				final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map = AttributeMap.instance().getObjectMap(bo);
				if (bo instanceof CollectionType) {

					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

					editingDomain.getCommandStack().execute(

					new RecordingCommand(editingDomain) {

						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {
							List<DataType> accessibleTypes = Util.getAllReferableDataTypes(getDiagram(), pe);

							for (DataType type : accessibleTypes) {
								if (type.getName().equals(dropdown.getText())) {
									((CollectionType) bo).setCollectionItemType(type);
									DataTypeAddFeature.resizeWholeType(getDiagram(), pe);
									break;
								}
							}

							featureProvider.layoutIfPossible(new LayoutContext(pe));
						}
					});
				}
			}
		}
	}
}
