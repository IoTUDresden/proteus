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

import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.ProcessStep;

public class TypeSection extends PropertySectionBase {

	private Text typeText;
	private Text description;
	private Text resource;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		FormData data;

		Composite composite = factory.createFlatFormComposite(parent);

		typeText = factory.createText(composite, ""); //$NON-NLS-1$
		typeText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		typeText.setLayoutData(data);
		typeText.addFocusListener(new StateFocusListener());
		typeText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		CLabel valueLabel = factory.createCLabel(composite, "Type:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(typeText, -HSPACE);
		data.top = new FormAttachment(typeText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		resource = factory.createText(composite, ""); //$NON-NLS-1$
		resource.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(typeText, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		resource.setLayoutData(data);
		resource.addFocusListener(new StateFocusListener());
		resource.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		valueLabel = factory.createCLabel(composite, "Resource:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(typeText, 0);
		data.right = new FormAttachment(resource, -HSPACE);
		data.top = new FormAttachment(resource, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		composite = factory.createFlatFormComposite(parent);

		description = factory.createText(composite, ""); //$NON-NLS-1$
		description.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(resource, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		description.setLayoutData(data);
		description.addFocusListener(new StateFocusListener());
		description.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		CLabel descriptionLabel = factory.createCLabel(composite,
				"Description:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(resource, 0);
		data.right = new FormAttachment(description, -HSPACE);
		data.top = new FormAttachment(description, 0, SWT.CENTER);
		descriptionLabel.setLayoutData(data);

	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);

			if (bo instanceof ProcessStep) {
				ProcessStep processStep = (ProcessStep) bo;
				String type = processStep.getType();
				typeText.setText(type == null ? "" : type);

				String desc = processStep.getDescription();
				description.setText(desc == null ? "" : desc);

				String res = processStep.getResource();
				resource.setText(res == null ? "" : res);
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

				final Object bo = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);

				final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
                        AttributeMap.instance().getObjectMap(bo);
				
				if (bo instanceof ProcessStep) {

					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(bo);

					editingDomain.getCommandStack().execute(

					new RecordingCommand(editingDomain) {

						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {

							String type = typeText.getText();
							String description = TypeSection.this.description.getText();
							String resour = TypeSection.this.resource.getText();
							if (type != null) {
								((ProcessStep) bo).setType(type);
								if (map != null) {
                                    org.eclipse.graphiti.mm.algorithms.Text text = map.get("type");
                                    if (text != null)
                                        text.setValue("type: " + type);
                                }
							}
							if (description != null) {
								((ProcessStep) bo).setDescription(description);

							}
							if (resour != null) {
								((ProcessStep) bo).setResource(resour);
								
								if (map != null) {
                                    org.eclipse.graphiti.mm.algorithms.Text text = map.get("resource");
                                    if (text != null)
                                        text.setValue("resource: " + resour);
                                }
							}
							featureProvider.layoutIfPossible(new LayoutContext(
									pe));
							
						}
					});
				}
			}
		}
	}
}
