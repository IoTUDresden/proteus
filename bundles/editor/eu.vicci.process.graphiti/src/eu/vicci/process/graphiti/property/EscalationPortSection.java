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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.EscalationPort;

public class EscalationPortSection extends PropertySectionBase{

	private Text escalationTime;

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		FormData data;

		Composite composite = factory.createFlatFormComposite(parent);

		escalationTime = factory.createText(composite, ""); //$NON-NLS-1$
		escalationTime.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		escalationTime.setLayoutData(data);
		escalationTime.addFocusListener(new StateFocusListener());
		escalationTime.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		CLabel valueLabel = factory.createCLabel(composite, "Escalation Time:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(escalationTime, -HSPACE);
		data.top = new FormAttachment(escalationTime, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			String escalationTimeString = null;
			if (bo instanceof EscalationPort) {
				escalationTimeString = ((EscalationPort) bo).getEscalationTime()+"";
			}

			
			escalationTime.setText(escalationTimeString == null ? "" : escalationTimeString);
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

				if (bo instanceof EscalationPort) {

					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(bo);

					editingDomain.getCommandStack().execute(

					new RecordingCommand(editingDomain) {

						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {

							String escalationTimeString = escalationTime.getText();
							if (escalationTimeString != null){
								try{
								((EscalationPort) bo).setEscalationTime(Long.parseLong(escalationTimeString));
								}
								catch(NumberFormatException e){}
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
