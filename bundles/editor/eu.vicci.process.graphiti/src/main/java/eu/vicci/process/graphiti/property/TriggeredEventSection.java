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
import eu.vicci.process.model.sofia.TriggeredEvent;

public class TriggeredEventSection extends PropertySectionBase {

    private Text eplText;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

        super.createControls(parent, tabbedPropertySheetPage);

        TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
        Composite composite = factory.createFlatFormComposite(parent);
        FormData data;

        eplText = factory.createText(composite, ""); //$NON-NLS-1$
        eplText.setEditable(true);
        data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE);
        eplText.setLayoutData(data);
        eplText.addFocusListener(new StateFocusListener());
        eplText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
                    new StateFocusListener().focusLost(null);
            }
        });

        CLabel valueLabel = factory.createCLabel(composite, "EPLStatement:"); //$NON-NLS-1$
        data = new FormData();
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(eplText, -HSPACE);
        data.top = new FormAttachment(eplText, 0, SWT.CENTER);
        valueLabel.setLayoutData(data);
    }

    @Override
    public void refresh() {

        PictogramElement pe = getSelectedPictogramElement();

        if (pe != null) {

            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

            if (bo instanceof TriggeredEvent) {
                String epl = ((TriggeredEvent) bo).getEPLStatement();
                eplText.setText(epl == null ? "" : epl);
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

                if (bo instanceof TriggeredEvent) {

                    TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
                    editingDomain.getCommandStack().execute(
                            new RecordingCommand(editingDomain) {
                                ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                                @Override
                                protected void doExecute() {
                                    String epl = eplText.getText();
                                    if (epl != null) {
                                        if (map != null) {
                                            org.eclipse.graphiti.mm.algorithms.Text text = map.get("EPL");
                                            if (text != null)
                                                text.setValue("EPL: " + epl);
                                        }
                                        ((TriggeredEvent) bo).setEPLStatement(epl);
                                    }
                                    featureProvider.layoutIfPossible(new LayoutContext(pe));
                                }
                            });
                }
            }
        }
    }
}