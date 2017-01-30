package eu.vicci.process.graphiti.property;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
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
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.Process;

public class RemoteSection extends PropertySectionBase {
	private Button isDistributed;
	private Text exPeer;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;

		isDistributed = factory.createButton(composite, "Distributed", SWT.CHECK);
		isDistributed.setEnabled(true);

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		isDistributed.setLayoutData(data);
		isDistributed.addFocusListener(focusListener);

		composite = factory.createFlatFormComposite(parent);

		exPeer = factory.createText(composite, "");
		exPeer.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(isDistributed, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);

		exPeer.setLayoutData(data);
		exPeer.addFocusListener(focusListener);

		CLabel valueLabel = factory.createCLabel(composite, "Execution Peer:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(isDistributed, 0);
		data.right = new FormAttachment(exPeer, -HSPACE);
		data.top = new FormAttachment(exPeer, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		composite.layout(true, true);
	}

	private Process getProcessElement() {
		EObject bo = Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
		if (bo != null)
			return (Process) bo;
		return null;
	}

	@Override
	public void refresh() {
		Process p = getProcessElement();
		if (p == null)
			return;
		// FIXME org.eclipse.swt.SWTException: Widget is disposed
		// check why this happens
		if (isDistributed.isDisposed() || exPeer.isDisposed())
			return;

		isDistributed.setSelection(p.isDistributed());
		exPeer.setEnabled(true);
		exPeer.setText(p.getExecutionPeer() == null ? "" : p.getExecutionPeer());

	}
	
	private FocusListener focusListener = new FocusListener() {		
		@Override
		public void focusLost(FocusEvent e) {			
		}
		
		@Override
		public void focusGained(FocusEvent e) {
			final Process pe = getProcessElement();
			if (pe == null)
				return;

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(pe);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
				ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

				@Override
				protected void doExecute() {
					pe.setDistributed(isDistributed.getSelection());
					String executionPeer = exPeer.getText();
					if (executionPeer != null && !executionPeer.isEmpty())
						pe.setExecutionPeer(executionPeer);
					featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
				}
			});
			
		}
	};
}
