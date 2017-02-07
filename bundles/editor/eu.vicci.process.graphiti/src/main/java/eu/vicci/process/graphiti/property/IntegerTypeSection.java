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
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.graphiti.types.DataTypeAddFeature;
import eu.vicci.process.model.sofia.IntegerType;

public class IntegerTypeSection extends PropertySectionBase {

	private Text minText;
	private Text maxText;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		FormData data;

		Composite composite = factory.createFlatFormComposite(parent);

		minText = factory.createText(composite, ""); //$NON-NLS-1$
		minText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		minText.setLayoutData(data);
		minText.addFocusListener(new StateFocusListener());
		minText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});


		CLabel valueLabel = factory.createCLabel(composite, "Minimum:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(minText, -HSPACE);
		data.top = new FormAttachment(minText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		composite = factory.createFlatFormComposite(parent);

		maxText = factory.createText(composite, ""); //$NON-NLS-1$
		maxText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		maxText.setLayoutData(data);
		maxText.addFocusListener(new StateFocusListener());
		maxText.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		valueLabel = factory.createCLabel(composite, "Maximum:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(maxText, -HSPACE);
		data.top = new FormAttachment(maxText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		

		minText.addVerifyListener(new NumberVerifier());
		maxText.addVerifyListener(new NumberVerifier());
	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			String min = null, max = null;

			if (bo instanceof IntegerType) {
				min = ((IntegerType) bo).getMin() + "";
				max = ((IntegerType) bo).getMax() + "";
			}

			minText.setText(min == null ? "" : min);
			maxText.setText(max == null ? "" : max);
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

				if (bo instanceof IntegerType) {

					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(bo);

					editingDomain.getCommandStack().execute(

					new RecordingCommand(editingDomain) {

						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {

							String min = minText.getText();
							if (min != null) {
								try {
									((IntegerType) bo).setMin(Integer
											.parseInt(min));
								} catch (NumberFormatException e) {
									System.out.println(min
											+ " is not an Integer");
								}
							}
							String max = maxText.getText();

							if (max != null) {
								try {
									((IntegerType) bo).setMax(Integer
											.parseInt(max));
								} catch (NumberFormatException e) {
									System.out.println(max
											+ " is not an Integer");
								}
							}
							
							try {
								DataTypeAddFeature.resizeWholeType(getDiagram(), pe);
							} catch (Exception e2) {
								e2.printStackTrace();
							}

							featureProvider.layoutIfPossible(new LayoutContext(
									pe));
						}
					});
				}
			}
		}
	}
	
	private class NumberVerifier implements VerifyListener{

		@Override
		public void verifyText(VerifyEvent e) {
			try{
				Integer.parseInt(e.text);
			}
			catch(NumberFormatException ex){
				e.doit = false;
			}
		}

		
	}
}
