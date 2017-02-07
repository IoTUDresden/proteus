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
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.Port;

public class PortSection extends PropertySectionBase {

    private Button optional;
    private Text portDescription;

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
        super.createControls(parent, tabbedPropertySheetPage);
        Composite composite = getWidgetFactory().createFlatFormComposite(parent);
        createDescription(composite);
        createOptional(composite);
    }
    
    private void createOptional(Composite parent){
        optional = getWidgetFactory().createButton(parent, "optional", SWT.CHECK);
        optional.setEnabled(true);        
        FormData data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(portDescription, VSPACE);
        optional.setLayoutData(data);
        optional.addFocusListener(new OptionalFocusListener());    	
    }
    
    private void createDescription(Composite parent){
        portDescription = getWidgetFactory().createText(parent, "");
        FormData data = new FormData();
        data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
        data.right = new FormAttachment(100, 0);
        data.top = new FormAttachment(0, VSPACE); 
        portDescription.setLayoutData(data);
        portDescription.addFocusListener(new DescriptionFocusListener());
        
        CLabel valueLabel = getWidgetFactory().createCLabel(parent, "Description:"); //$NON-NLS-1$
        FormData labelData = new FormData();
        labelData.left = new FormAttachment(0, 0);
        labelData.right = new FormAttachment(portDescription, -HSPACE);
        labelData.top = new FormAttachment(portDescription, 0, SWT.CENTER);
        valueLabel.setLayoutData(labelData);
    }

    @Override
    public void refresh() {
        PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            if (bo instanceof Port) {
            	Port port = (Port)bo;
                optional.setSelection(port.isOptional());
                //cannot pass null to text
                portDescription.setText(port.getDescription() == null ? "" : port.getDescription());
            }
        }
    }
   
    
    private class DescriptionFocusListener implements FocusListener{
    	private String oldDesc = "";
		@Override
		public void focusGained(FocusEvent e) {
			oldDesc = portDescription.getText();			
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(!oldDesc.equals(portDescription.getText()))
				writeToModel();			
		}    	
    }

    private class OptionalFocusListener implements FocusListener {
    	private boolean oldValue = false;

        @Override
        public void focusGained(FocusEvent e) {
        	oldValue = optional.getSelection();
        }

        @Override
        public void focusLost(FocusEvent e) {
        	if(oldValue != optional.getSelection())
        		writeToModel();
        }
    }
    
    private void writeToModel(){
        final PictogramElement pe = getSelectedPictogramElement();
        if (pe != null) {
            final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
            if (bo instanceof Port) {
            	Port port = (Port)bo;
                TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
                editingDomain.getCommandStack().execute(
                        new RecordingCommand(editingDomain) {
                            ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

                            @Override
                            protected void doExecute() {
                                port.setOptional(optional.getSelection());
                                port.setDescription(portDescription.getText());
                                featureProvider.layoutIfPossible(new LayoutContext(pe));
                            }
                        });
            }
        }
    }
}
