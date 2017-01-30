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
import eu.vicci.process.model.sofia.XMLRPCInvoke;

public class XMLRPCInvokeSection extends PropertySectionBase {

    private Text serverText;
    private Text methodText;
    private Text startParameterText;
    private Text endParameterText;
    
    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

        super.createControls(parent, tabbedPropertySheetPage);
        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

        serverText = factory.createText(composite, ""); //$NON-NLS-1$
        serverText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        serverText.setLayoutData(data);
        serverText.addFocusListener(new StateFocusListener());
        serverText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, "Server URI:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(serverText, -HSPACE);
        data.top = new FormAttachment(serverText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        composite = factory.createFlatFormComposite(parent);

        methodText = factory.createText(composite, ""); //$NON-NLS-1$
        methodText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        methodText.setLayoutData(data);
        methodText.addFocusListener(new StateFocusListener());
        methodText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "Method:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(methodText, -HSPACE);
        data.top = new FormAttachment(methodText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
        

        composite = factory.createFlatFormComposite(parent);

        startParameterText = factory.createText(composite, ""); //$NON-NLS-1$
        startParameterText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        startParameterText.setLayoutData(data);
        startParameterText.addFocusListener(new StateFocusListener());
        startParameterText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "Start Param. Seq.:"); //$NON-NLS-1$
        valueLabel.setToolTipText("Start Parameter Sequence");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(startParameterText, -HSPACE);
        data.top = new FormAttachment(startParameterText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
        

        composite = factory.createFlatFormComposite(parent);

        endParameterText = factory.createText(composite, ""); //$NON-NLS-1$
        endParameterText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        endParameterText.setLayoutData(data);
        endParameterText.addFocusListener(new StateFocusListener());
        endParameterText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "End Param. Seq.:"); //$NON-NLS-1$
        valueLabel.setToolTipText("End Parameter Sequence");
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(endParameterText, -HSPACE);
        data.top = new FormAttachment(endParameterText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
        
    }

    @Override
    public void refresh() {

        PictogramElement pe = getSelectedPictogramElement();

        if (pe != null) {

            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

            if (bo instanceof XMLRPCInvoke) {
                String s = ((XMLRPCInvoke) bo).getServerUri();
                serverText.setText(s == null ? "" : s);

                s = ((XMLRPCInvoke) bo).getMethodName();
                methodText.setText(s == null ? "" : s);
                
                s = ((XMLRPCInvoke) bo).getStartParameterSequence();
                startParameterText.setText(s == null ? "" : s);
                
                s = ((XMLRPCInvoke) bo).getEndParameterSequence();
                endParameterText.setText(s == null ? "" : s);
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
                final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map =
                        AttributeMap.instance().getObjectMap(bo);

                if (bo instanceof XMLRPCInvoke) {
                    TransactionalEditingDomain editingDomain =
                            TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(
                            new RecordingCommand(editingDomain) {
                                ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                                @Override
                                protected void doExecute() {
                                    String s = serverText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("server");
                                            if (text != null)
                                                text.setValue("server: " + s);
                                        }
                                        ((XMLRPCInvoke) bo).setServerUri(s);
                                    }

                                    s = methodText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("method");
                                            if (text != null)
                                                text.setValue("method: " + s);
                                        }
                                        ((XMLRPCInvoke) bo).setMethodName(s);
                                    }

                                    s = startParameterText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("startseq");
                                            if (text != null)
                                                text.setValue("start sequence: " + s);
                                        }
                                        ((XMLRPCInvoke) bo).setStartParameterSequence(s);
                                    }
                                    
                                    s = endParameterText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("endseq");
                                            if (text != null)
                                                text.setValue("end sequence: " + s);
                                        }
                                        ((XMLRPCInvoke) bo).setEndParameterSequence(s);
                                    }
                                    
                                    featureProvider.layoutIfPossible(new LayoutContext(pe));
                                }
                            });
                }
            }
        }
    }
}
