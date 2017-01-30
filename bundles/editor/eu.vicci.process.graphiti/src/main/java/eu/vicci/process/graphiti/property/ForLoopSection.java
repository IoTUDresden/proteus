package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
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

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.StartDataPort;

public class ForLoopSection extends PropertySectionBase implements FocusListener, SelectionListener {

	private CCombo startValuePortComboBox;
	private CCombo endValuePortComboBox;
	private CCombo loopStepWidthComboBox;
	private List<StartDataPort> startDataPorts = new ArrayList<StartDataPort>(); // Only IntegerType
	private TabbedPropertySheetWidgetFactory factory;
	private Composite flatFormComposite;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);

		factory = getWidgetFactory();
		flatFormComposite = factory.createFlatFormComposite(parent);

		setStartCCombo();
		setStartCLabel();

		setEndCCombo();
		setEndCLabel();

		setStepWidthCombo();
		setStepWidthLabel();
	}

	@Override
	public void refresh() {
		ForLoop loop = getLoopElement();
		if (loop == null)
			return;
		fillLists(loop);
		Condition loopCondition = loop.getLoopCondition();

		if (loopCondition == null)
			return;
		startValuePortComboBox.select(startDataPorts.indexOf(loopCondition.getLeftSide()));
		endValuePortComboBox.select(startDataPorts.indexOf(loopCondition.getRightSide()));
		loopStepWidthComboBox.select(startDataPorts.indexOf(loop.getLoopStepWidth()));
	}

	// FocusListener implementation
	@Override
	public void focusGained(FocusEvent e) {
	}

	// FocusListener implementation
	@Override
	public void focusLost(FocusEvent e) {
		final ForLoop loop = getLoopElement();
		if (loop == null)
			return;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(loop);

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				Condition loopCondition = loop.getLoopCondition();

				try {
					loopCondition.setLeftSide(startDataPorts.get(startValuePortComboBox
							.getSelectionIndex()));
					loopCondition.setRightSide(startDataPorts.get(endValuePortComboBox
							.getSelectionIndex()));
					loop.setLoopStepWidth(startDataPorts.get(loopStepWidthComboBox
							.getSelectionIndex()));
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
	}

	// SelectionListener
	@Override
	public void widgetSelected(SelectionEvent e) {
		focusLost(null);
	}

	// SelectionListener
	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
		focusLost(null);
	}

	private void fillLists(Loop loop) {
		endValuePortComboBox.removeAll();
		startValuePortComboBox.removeAll();
		loopStepWidthComboBox.removeAll();
		startDataPorts.clear();

		for (Port port : loop.getPorts()) {
			if (port instanceof StartDataPort && !startDataPorts.contains(port)
					&& ((StartDataPort) port).getPortDatatype() instanceof IntegerType) {
				endValuePortComboBox.add(port.getName());
				startValuePortComboBox.add(port.getName());
				loopStepWidthComboBox.add(port.getName());
				startDataPorts.add((StartDataPort) port);
			}
		}
	}

	private void setEndCCombo() {
		endValuePortComboBox = factory.createCCombo(flatFormComposite);
		FormData data = new FormData();

		for (DataPort c : startDataPorts)
			endValuePortComboBox.add(c.getName());

		data.left = new FormAttachment(startValuePortComboBox, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		endValuePortComboBox.setLayoutData(data);
		endValuePortComboBox.addFocusListener(this);
		endValuePortComboBox.addSelectionListener(this);
	}

	private void setEndCLabel() {
		CLabel valueLabel = factory.createCLabel(flatFormComposite, "Endvalue:"); //$NON-NLS-1$
		FormData data = new FormData();
		data.left = new FormAttachment(startValuePortComboBox, 0);
		data.right = new FormAttachment(endValuePortComboBox, -HSPACE);
		data.top = new FormAttachment(endValuePortComboBox, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}

	private void setStartCLabel() {
		CLabel valueLabel = factory.createCLabel(flatFormComposite, "Startvalue:"); //$NON-NLS-1$
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(startValuePortComboBox, -HSPACE);
		data.top = new FormAttachment(startValuePortComboBox, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}

	private void setStartCCombo() {
		FormData data = new FormData();
		startValuePortComboBox = factory.createCCombo(flatFormComposite);

		for (DataPort startDataPort : startDataPorts)
			startValuePortComboBox.add(startDataPort.getName());

		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		startValuePortComboBox.setLayoutData(data);
		startValuePortComboBox.addFocusListener(this);
		startValuePortComboBox.addSelectionListener(this);
	}

	private void setStepWidthCombo() {
		FormData data = new FormData();
		loopStepWidthComboBox = factory.createCCombo(flatFormComposite);

		for (DataPort startDataPort : startDataPorts)
			loopStepWidthComboBox.add(startDataPort.getName());

		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(startValuePortComboBox, VSPACE);
		loopStepWidthComboBox.setLayoutData(data);
		loopStepWidthComboBox.addFocusListener(this);
		loopStepWidthComboBox.addSelectionListener(this);
	}

	private void setStepWidthLabel() {
		CLabel valueLabel = factory.createCLabel(flatFormComposite, "Step Width:"); //$NON-NLS-1$
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(loopStepWidthComboBox, -HSPACE);
		data.top = new FormAttachment(loopStepWidthComboBox, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}

	private ForLoop getLoopElement() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (ForLoop) bo; //already checked in the filter
		return null;
	}
}
