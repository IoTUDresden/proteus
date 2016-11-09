package eu.vicci.process.graphiti.property;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Loop;

public class ConditionSection extends PropertySectionBase {

    private CCombo comparatorBox;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

        comparatorBox = factory.createCCombo(composite);

        List<Comparator> list = Comparator.VALUES;
        for (Comparator c : list)
            comparatorBox.add(c.getName());

        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        comparatorBox.setLayoutData(data);
        comparatorBox.addFocusListener(new StateFocusListener());
        comparatorBox.addSelectionListener(new SelectionListener() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                new StateFocusListener().focusLost(null);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                new StateFocusListener().focusLost(null);
            }
        });
        CLabel valueLabel = factory.createCLabel(composite, "Condition:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(comparatorBox, -HSPACE);
        data.top = new FormAttachment(comparatorBox, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }

    @Override
    public void refresh() {

        PictogramElement pe = getSelectedPictogramElement();

        if (pe != null) {

            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            if (bo instanceof Loop) {
                Condition cond = ((Loop) bo).getLoopCondition();
                if (cond != null)
                    comparatorBox.select(cond.getComparator().getValue());
            }
            if (bo instanceof If) {
                Condition cond = ((If) bo).getIfCondition();
                if (cond != null)
                    comparatorBox.select(cond.getComparator().getValue());
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

                if (bo instanceof Loop) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
                    editingDomain.getCommandStack().execute(
                            new RecordingCommand(editingDomain) {
                                ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                                @Override
                                protected void doExecute() {

                                    Condition cond = ((Loop) bo).getLoopCondition();
                                    if (cond != null)
                                        cond.setComparator(Comparator.get(comparatorBox.getText()));

                                    if (map != null && cond != null) {
                                        org.eclipse.graphiti.mm.algorithms.Text text = map.get("condition");
                                        if (text != null)
                                    text.setValue(cond.getComparator().getName());
                                    }

                                    featureProvider.layoutIfPossible(new LayoutContext(pe));
                                }
                            });
                }

                else if (bo instanceof If) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
                    editingDomain.getCommandStack().execute(
                            new RecordingCommand(editingDomain) {
                                ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                                @Override
                                protected void doExecute() {

                                    Condition cond = ((If) bo).getIfCondition();
                                    if (cond != null)
                                        cond.setComparator(Comparator.get(comparatorBox.getText()));

                                    if (map != null && cond != null) {
                                        org.eclipse.graphiti.mm.algorithms.Text text = map.get("condition");
                                        if (text != null)
                                            text.setValue(Util.getOperator(cond.getComparator()));
                                    }

                                    featureProvider.layoutIfPossible(new LayoutContext(pe));
                                }
                            });
                }
            }
        }
    }
}
