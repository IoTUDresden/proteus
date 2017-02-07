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
import eu.vicci.process.graphiti.types.DataTypeAddFeature;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.Transition;

public class NameIDSection extends PropertySectionBase {

    private Text nameText;
    private Text idText;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        FormData data;

        Composite composite = factory.createFlatFormComposite(parent);

        nameText = factory.createText(composite, ""); //$NON-NLS-1$
        nameText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        nameText.setLayoutData(data);
        nameText.addFocusListener(new StateFocusListener());
        nameText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, "Name:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(nameText, -HSPACE);
        data.top = new FormAttachment(nameText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);

        composite = factory.createFlatFormComposite(parent);

        idText = factory.createText(composite, ""); //$NON-NLS-1$
        idText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        idText.setLayoutData(data);
        idText.addFocusListener(new StateFocusListener());
        idText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        valueLabel = factory.createCLabel(composite, "ID:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(idText, -HSPACE);
        data.top = new FormAttachment(idText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }

    @Override
    public void refresh() {

        PictogramElement pe = getSelectedPictogramElement();

        if (pe != null) {

            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            String name = null, id = null;
            if (bo instanceof ProcessStep) {
                name = ((ProcessStep) bo).getName();
                id = ((ProcessStep) bo).getId();
            }

            if (bo instanceof Transition) {
                name = ((Transition) bo).getName();
                id = ((Transition) bo).getId();
            }

            if (bo instanceof Port) {
                name = ((Port) bo).getName();
                id = ((Port) bo).getId();
            }
            
            if(bo instanceof DataMapping){
            	name = ((DataMapping) bo).getName();
            	id = ((DataMapping)bo).getId();
            }
            
            if(bo instanceof DataType){
            	name = ((DataType) bo).getName();
            	id = ((DataType)bo).getId();
            }
            
            nameText.setText(name == null ? "" : name);
            idText.setText(id == null ? "" : id);
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
				
                if (bo instanceof ProcessStep) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(

                    new RecordingCommand(editingDomain) {

                        ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                        @Override
                        protected void doExecute() {

                            String name = nameText.getText();
                            if (name != null){
                                ((ProcessStep) bo).setName(name);
                                if (map != null) {
                                    org.eclipse.graphiti.mm.algorithms.Text text = map.get("name");
                                    if (text != null)
                                        text.setValue("name: " + name);
                                }
                            }

                            String id = idText.getText();
                            if (id != null)
                                ((ProcessStep) bo).setId(id);

                            featureProvider.layoutIfPossible(new LayoutContext(pe));
                        }
                    });
                }

                if (bo instanceof Transition) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(

                    new RecordingCommand(editingDomain) {

                        ProcessFeatureProvider featureProvider =
                                (ProcessFeatureProvider) getDiagramTypeProvider().getFeatureProvider();

                        @Override
                        protected void doExecute() {

                            String name = nameText.getText();
                            if (name != null)
                                ((Transition) bo).setName(name);
                            String id = nameText.getText();
                            if (id != null)
                                ((Transition) bo).setId(id);

                            Util.redrawConnectionDecorator(((Transition) bo), getDiagram());

                            featureProvider.layoutIfPossible(new LayoutContext(pe));
                        }
                    });
                }

                if (bo instanceof Port) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(

                    new RecordingCommand(editingDomain) {

                        ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                        @Override
                        protected void doExecute() {

                            String name = nameText.getText();
                            if (name != null)
                                ((Port) bo).setName(name);

                            String id = idText.getText();
                            if (id != null)
                                ((Port) bo).setId(id);

                            featureProvider.layoutIfPossible(new LayoutContext(pe));
                        }
                    });
                }
                
                if (bo instanceof DataMapping) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(

                    new RecordingCommand(editingDomain) {

                        ProcessFeatureProvider featureProvider =
                                (ProcessFeatureProvider) getDiagramTypeProvider().getFeatureProvider();

                        @Override
                        protected void doExecute() {

                            String name = nameText.getText();
                            if (name != null)
                                ((DataMapping) bo).setName(name);
                            String id = nameText.getText();
                            if (id != null)
                                ((DataMapping) bo).setId(id);

                            Util.redrawConnectionDecorator(((DataMapping) bo), getDiagram());

                            featureProvider.layoutIfPossible(new LayoutContext(pe));
                        }
                    });
                }
                
                if (bo instanceof DataType) {
                	
                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);

                    editingDomain.getCommandStack().execute(

                    new RecordingCommand(editingDomain) {

                        ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                        @Override
                        protected void doExecute() {

                            String name = nameText.getText();
                            if (name != null)
                                ((DataType) bo).setName(name);
                            String id = idText.getText();
                            if (id != null)
                                ((DataType) bo).setId(id);

                            DataTypeAddFeature.resizeWholeType(getDiagram(), pe);
                            featureProvider.layoutIfPossible(new LayoutContext(pe));
                        }
                    });
                }
            }
        }
    }
}
