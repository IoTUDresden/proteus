package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.AttributeMap;
import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;

public class CpsSection extends PropertySectionBase {

	private Button isCps;
	private Text controlId;
	private static CCombo cProcess;
	private List<Process> processes = new ArrayList<Process>();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;

		isCps = factory.createButton(composite, "Cyber-Physical", SWT.CHECK);
		isCps.setEnabled(true);

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		isCps.setLayoutData(data);
		isCps.addFocusListener(new StateFocusListener());

		composite = factory.createFlatFormComposite(parent);

		controlId = factory.createText(composite, "");
		controlId.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(isCps, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);

		controlId.setLayoutData(data);
		controlId.addFocusListener(new StateFocusListener());
		controlId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR)
					new StateFocusListener().focusLost(null);
			}
		});

		CLabel valueLabel = factory.createCLabel(composite, "MapeProId:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(isCps, 0);
		data.right = new FormAttachment(controlId, -HSPACE);
		data.top = new FormAttachment(controlId, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		composite = factory.createFlatFormComposite(parent);
		cProcess = factory.createCCombo(composite);
		processes = Util.getAllProcessesAccessible(getSelectedPictogramElement());
		cProcess.removeAll();
		processes.clear();

		for (Process p : processes)
			cProcess.add(p.getName());
		cProcess.addSelectionListener(new MySelectionListener());

		data = new FormData();
		data.left = new FormAttachment(controlId, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		cProcess.setLayoutData(data);

		CLabel mapeProcessLabel = factory.createCLabel(composite, "MapeProcess:");
		data = new FormData();
		data.left = new FormAttachment(controlId, 0);
		data.right = new FormAttachment(cProcess, -HSPACE);
		data.top = new FormAttachment(cProcess, 0, SWT.CENTER);
		mapeProcessLabel.setLayoutData(data);

		composite.layout(true, true);
		cProcess.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
			}
		});

	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo instanceof ProcessStep) {
				ProcessStep ps = (ProcessStep) bo;
				boolean op = ps.isCyberPhysical();

				//FIXME org.eclipse.swt.SWTException: Widget is disposed
				//check why this happens
				if (isCps.isDisposed() || controlId.isDisposed() || cProcess.isDisposed())
					return;
				
				isCps.setSelection(op);
				controlId.setEnabled(true);
				cProcess.setEnabled(true);

				String cProcessId = ps.getControlProcessId();
				controlId.setText(cProcessId == null ? "" : cProcessId);

				List<Process> processes = Util.getAllProcessesAccessible(getSelectedPictogramElement());
				cProcess.removeAll();
				for (Process p : processes) {
					if (p.getName() != null)
						cProcess.add(p.getName());
				}

				Process p = ((ProcessStep) bo).getControlProcess();
				if (p != null && p.getName() != null) {
					String pName = p.getName();
					cProcess.setText(pName);
				}

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

				final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map = AttributeMap.instance()
						.getObjectMap(bo);

				if (bo instanceof ProcessStep) {
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {
							ProcessStep ps = (ProcessStep) bo;
							boolean op = isCps.getSelection();
							String cProcessId = controlId.getText();
							ps.setCyberPhysical((op));

							if (cProcessId != null) {
								ps.setControlProcessId(cProcessId);
								if (map != null) {
									org.eclipse.graphiti.mm.algorithms.Text text = map.get("MapeProcess");
									if (text != null) {
										text.setValue("MapeProcess: " + cProcessId);
									}
								}
							}

							String processName = cProcess.getText();
							for (Process p : processes)
								if (p.getName().equals(processName))
									((ProcessStep) bo).setControlProcess(p);

							List<Process> accessibleProcesses = Util.getAllProcessesAccessible(pe);
							if (bo instanceof ProcessStep) {
								ProcessStep p = (ProcessStep) bo;
								for (Process proc : accessibleProcesses) {
									if (proc.getName().equals(cProcess.getText())) {
										p.setControlProcess(proc);
									}
								}
							}

							featureProvider.layoutIfPossible(new LayoutContext(pe));
						}
					});
				}
			}
		}
	}

	private class MySelectionListener implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent event) {
			PictogramElement pe = getSelectedPictogramElement();
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {

					PictogramElement pe = getSelectedPictogramElement();
					EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					List<Process> accessibleProcesses = Util.getAllProcessesAccessible(pe);

					if (bo instanceof ProcessStep) {
						ProcessStep process = (ProcessStep) bo;
						for (Process proc : accessibleProcesses) {
							if (proc.getName().equals(cProcess.getText())) {
								process.setControlProcess((proc));
								break;
							}
						}
					}
				}
			});

		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
			// TODO Auto-generated method stub

		}
	}

}
