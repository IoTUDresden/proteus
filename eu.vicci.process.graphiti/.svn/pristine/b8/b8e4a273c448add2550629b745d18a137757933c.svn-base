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
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.WhileLoop;

public class WhileLoopSection extends PropertySectionBase implements FocusListener, SelectionListener{
	
	private TabbedPropertySheetWidgetFactory factory;
	private Composite flatFormComposite;	
	private CCombo conditionLeftValueCCombo;
	private CCombo conditionRightValueCCombo;	
	private List<StartDataPort> startDataPorts = new ArrayList<StartDataPort>();
	
	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		factory = getWidgetFactory();
		flatFormComposite = factory.createFlatFormComposite(parent);
		setConditionLeftCCombo();
		setConditionLeftCLabel();		
		setConditionRightCCombo();
		setConditionRightCLabel();
	}
	
	@Override
	public void refresh() {
		super.refresh();
		WhileLoop loop = getLoopElement();
		if (loop == null)
			return;
		fillLists(loop);
		Condition loopCondition = loop.getLoopCondition();

		if (loopCondition == null)
			return;
		conditionLeftValueCCombo.select(startDataPorts.indexOf(loopCondition.getLeftSide()));
		conditionRightValueCCombo.select(startDataPorts.indexOf(loopCondition.getRightSide()));
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

	// FocusListener implementation
	@Override
	public void focusGained(FocusEvent e) {
	}

	// FocusListener implementation
	@Override
	public void focusLost(FocusEvent e) {
		final WhileLoop loop = getLoopElement();
		if (loop == null)
			return;
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(loop);

		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
			ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

			@Override
			protected void doExecute() {
				Condition loopCondition = loop.getLoopCondition();

				try {
					loopCondition.setLeftSide(startDataPorts.get(conditionLeftValueCCombo
							.getSelectionIndex()));
					loopCondition.setRightSide(startDataPorts.get(conditionRightValueCCombo
							.getSelectionIndex()));
				} catch (ArrayIndexOutOfBoundsException e) {
				}

				featureProvider.layoutIfPossible(new LayoutContext(getSelectedPictogramElement()));
			}
		});
		
	}
	
	private void setConditionRightCCombo(){
		conditionRightValueCCombo = factory.createCCombo(flatFormComposite);
		FormData data = new FormData();

		for (DataPort c : startDataPorts)
			conditionRightValueCCombo.add(c.getName());

		data.left = new FormAttachment(conditionLeftValueCCombo, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		conditionRightValueCCombo.setLayoutData(data);
		conditionRightValueCCombo.addFocusListener(this);
		conditionRightValueCCombo.addSelectionListener(this);
	}
	
	private void setConditionLeftCCombo() {
		FormData data = new FormData();
		conditionLeftValueCCombo = factory.createCCombo(flatFormComposite);

		for (DataPort startDataPort : startDataPorts)
			conditionLeftValueCCombo.add(startDataPort.getName());

		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		conditionLeftValueCCombo.setLayoutData(data);
		conditionLeftValueCCombo.addFocusListener(this);
		conditionLeftValueCCombo.addSelectionListener(this);
	}
	
	private void setConditionLeftCLabel() {
		CLabel valueLabel = factory.createCLabel(flatFormComposite, "Left:"); //$NON-NLS-1$
		FormData data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(conditionLeftValueCCombo, -HSPACE);
		data.top = new FormAttachment(conditionLeftValueCCombo, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}
	
	private void setConditionRightCLabel() {
		CLabel valueLabel = factory.createCLabel(flatFormComposite, "Right:"); //$NON-NLS-1$
		FormData data = new FormData();
		data.left = new FormAttachment(conditionLeftValueCCombo, 0);
		data.right = new FormAttachment(conditionRightValueCCombo, -HSPACE);
		data.top = new FormAttachment(conditionRightValueCCombo, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}
	
	private WhileLoop getLoopElement() {
		EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (bo != null)
			return (WhileLoop) bo; //already checked in the filter
		return null;
	}
	
	private void fillLists(Loop loop) {
		conditionLeftValueCCombo.removeAll();
		conditionRightValueCCombo.removeAll();
		startDataPorts.clear();

		for (Port port : loop.getPorts()) {
			if (port instanceof StartDataPort && !startDataPorts.contains(port)) {
				conditionLeftValueCCombo.add(port.getName());
				conditionRightValueCCombo.add(port.getName());
				startDataPorts.add((StartDataPort) port);
			}
		}
	}
}
