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
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.graphiti.WsdlTypeImporter;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofia.ProcessStep;

public class OSGiInvokeSection extends PropertySectionBase {

    private Text serviceClassNameText;
    private Text methodText;
    private Text parameterTypesText;
    private Text bundleNameText;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

        serviceClassNameText = factory.createText(composite, ""); //$NON-NLS-1$
        serviceClassNameText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        serviceClassNameText.setLayoutData(data);
        serviceClassNameText.addFocusListener(new StateFocusListener());
        serviceClassNameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, "Service Class Name:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(serviceClassNameText, -HSPACE);
        data.top = new FormAttachment(serviceClassNameText, 0, SWT.CENTER);
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

        parameterTypesText = factory.createText(composite, ""); //$NON-NLS-1$
        parameterTypesText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        parameterTypesText.setLayoutData(data);
        parameterTypesText.addFocusListener(new StateFocusListener());
        parameterTypesText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "Parameter Types:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(parameterTypesText, -HSPACE);
        data.top = new FormAttachment(parameterTypesText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        composite = factory.createFlatFormComposite(parent);

        bundleNameText = factory.createText(composite, ""); //$NON-NLS-1$
        bundleNameText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        bundleNameText.setLayoutData(data);
        bundleNameText.addFocusListener(new StateFocusListener());
        bundleNameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "Bundle:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(bundleNameText, -HSPACE);
        data.top = new FormAttachment(bundleNameText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }

    @Override
    public void refresh() {

        PictogramElement pe = getSelectedPictogramElement();

        if (pe != null) {

            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

            if (bo instanceof OSGiInvoke) {
                String s = ((OSGiInvoke) bo).getServiceClassName();
                serviceClassNameText.setText(s == null ? "" : s);

                s = ((OSGiInvoke) bo).getMethodName();
                methodText.setText(s == null ? "" : s);

                s = ((OSGiInvoke) bo).getParameterTypes();
                parameterTypesText.setText(s == null ? "" : s);

                s = ((OSGiInvoke) bo).getBundleName();
                bundleNameText.setText(s == null ? "" : s);
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

                if (bo instanceof OSGiInvoke) {
                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(
                            new RecordingCommand(editingDomain) {
                                ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                                @Override
                                protected void doExecute() {
                                    String s = serviceClassNameText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("service");
                                            if (text != null)
                                                text.setValue("service: " + s);
                                        }
                                        ((OSGiInvoke) bo).setServiceClassName(s);
                                    }

                                    s = methodText.getText();
                                    if (s != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("method");
                                            if (text != null) {
                                                text.setValue("method: " + s);
                                                System.out.println("width: " + text.getWidth());
                                            }
                                        }
                                        ((OSGiInvoke) bo).setMethodName(s);
                                    }

                                    s = parameterTypesText.getText();
                                    if (s != null){
                                    	 if (map != null) {
                                             org.eclipse.graphiti.mm.algorithms.Text text = map.get("parameter");
                                             if (text != null) {
                                                 text.setValue("parameter: " + s);
                                                 System.out.println("width: " + text.getWidth());
                                             }
                                         }
                                    	if(!s.equals(((OSGiInvoke)bo).getParameterTypes())){
                                    		((OSGiInvoke) bo).setParameterTypes(s);
                                    		System.out.println("s = " + s + "  wsdlUri = " + ((OSGiInvoke)bo).getParameterTypes());
                                    		CompositeStep rootParent = ((OSGiInvoke)bo).getParentstep();
                                    		while(rootParent.getParentstep()!=null && rootParent instanceof ProcessStep && rootParent != rootParent.getParentstep())
                                    			rootParent = rootParent.getParentstep();
                                    		
                                    		WsdlTypeImporter.parse(s, featureProvider, Util.getContainerForBusinessObject(getDiagram(), rootParent), getDiagram());
                                    	}
                                    }
                                    s = bundleNameText.getText();
                                    if (s != null){
                                    	 if (map != null) {
                                             org.eclipse.graphiti.mm.algorithms.Text text = map.get("bundle");
                                             if (text != null) {
                                                 text.setValue("bundle: " + s);
                                                 System.out.println("width: " + text.getWidth());
                                             }
                                         }
                                        ((OSGiInvoke) bo).setBundleName(s);

                                    }
                                    featureProvider.layoutIfPossible(new LayoutContext(pe));
                                }
                            });
                }
            }
        }
    }
}
