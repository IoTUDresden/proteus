package eu.vicci.process.graphiti.property;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke;

public class OpenHabSemanticCommandInvokeSection extends PropertySectionBase {
	
	private static final String[] COMMANDS = new String[] { "ON", "OFF", "TOGGLE", "UP", "DOWN", "PLAY", "STOP" };
	
	private CCombo commandCombo;
	
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
//		Composite commandComposite = factory.createFlatFormComposite(parent);
		createCommandPart(factory, parent);		
	}
	
	@Override
	public void refresh() {
		super.refresh();
		OpenHabSemanticCommandInvoke openhab = getOpenHabElement();
		if (openhab == null)
			return;
		setCommand(openhab);
	}
	
	
	private void createCommandPart(TabbedPropertySheetWidgetFactory factory, Composite parent) {
		Composite commandComposite = factory.createFlatFormComposite(parent);
		Label commandLabel = factory.createLabel(commandComposite, "Command:");
		commandCombo = factory.createCCombo(commandComposite);
		commandCombo.setItems(COMMANDS);
		commandCombo.select(0);
		commandCombo.setEditable(true);
		commandCombo.addFocusListener(new FocusListener() {
			private String oldValue = "";

			@Override
			public void focusLost(FocusEvent e) {
				if (!oldValue.equals(commandCombo.getText()))
					writeToModel();
			}

			@Override
			public void focusGained(FocusEvent e) {
				oldValue = commandCombo.getText();
			}
		});
		
		// combo
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		formData.right = new FormAttachment(100, 0);
		formData.top = new FormAttachment(0, ITabbedPropertyConstants.VSPACE);
		commandCombo.setLayoutData(formData);
		// label
		formData = new FormData();
		formData.left = new FormAttachment(0, 0);
		formData.right = new FormAttachment(commandCombo, ITabbedPropertyConstants.HSPACE);
		formData.top = new FormAttachment(commandCombo, 0, SWT.CENTER);
		commandLabel.setLayoutData(formData);
	}
	
	private void setCommand(OpenHabSemanticCommandInvoke openhab) {
		List<String> tmp = Arrays.asList(COMMANDS);
		String command = openhab.getCommand();
		int index = tmp.lastIndexOf(command);
		if (index < 0)
			if(command == null)
				commandCombo.select(0);
			else 
				commandCombo.setText(command);
		else
			commandCombo.select(index);
	}
	
	private OpenHabSemanticCommandInvoke getOpenHabElement() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (OpenHabSemanticCommandInvoke) bo;
		return null;
	}
	
	private void writeToModel() {
		final OpenHabSemanticCommandInvoke openhab = getOpenHabElement();
		if (openhab == null)
			return;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(openhab);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				try {
					openhab.setCommand(commandCombo.getText());
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}

}
