package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.List;

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
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.StartDataPort;

public class ConditionOperandSection extends PropertySectionBase {

	private CCombo leftOperand;
	private CCombo rightOperand;
	private List<StartDataPort> list = new ArrayList<StartDataPort>();

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		Composite composite = factory.createFlatFormComposite(parent);
		FormData data;


		leftOperand = factory.createCCombo(composite);

		for (DataPort startDataPort : list)
			leftOperand.add(startDataPort.getName());

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, 0);
		data.top = new FormAttachment(0, VSPACE);
		leftOperand.setLayoutData(data);
		leftOperand.addFocusListener(new StateFocusListener());
		leftOperand.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new StateFocusListener().focusLost(null);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				new StateFocusListener().focusLost(null);
			}
		});
		CLabel valueLabel = factory.createCLabel(composite, "Left:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(leftOperand, -HSPACE);
		data.top = new FormAttachment(leftOperand, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);

		rightOperand = factory.createCCombo(composite);

		for (DataPort c : list)
			rightOperand.add(c.getName());

		data = new FormData();
		data.left = new FormAttachment(leftOperand, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		rightOperand.setLayoutData(data);
		rightOperand.addFocusListener(new StateFocusListener());
		rightOperand.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new StateFocusListener().focusLost(null);
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				new StateFocusListener().focusLost(null);
			}
		});
		valueLabel = factory.createCLabel(composite, "Right:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(leftOperand, 0);
		data.right = new FormAttachment(rightOperand, -HSPACE);
		data.top = new FormAttachment(rightOperand, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
	}

	private void fillList(){
		list.clear();
		rightOperand.removeAll();
		leftOperand.removeAll();
		EObject bo = Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(
						getSelectedPictogramElement());
		if (bo instanceof If) {
			If iF = (If) bo;
			for (Port port : iF.getPorts()) {
				if (port instanceof StartDataPort && !list.contains(port)) {
					list.add((StartDataPort) port);
					rightOperand.add(port.getName());
					leftOperand.add(port.getName());
				}
			}
		}
	}
	
	@Override
	public void refresh() {
		
		PictogramElement pe = getSelectedPictogramElement();

		
		
		if (pe != null) {
			fillList();
			Object bo = Graphiti.getLinkService()
					.getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof If) {
				Condition cond = ((If) bo).getIfCondition();
				if (cond != null) {
					leftOperand.select(list.indexOf(cond.getLeftSide()));
					rightOperand.select(list.indexOf(cond.getRightSide()));
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

				final Object bo = Graphiti.getLinkService()
						.getBusinessObjectForLinkedPictogramElement(pe);
//				final Map<String, org.eclipse.graphiti.mm.algorithms.Text> map = AttributeMap
//						.instance().getObjectMap(bo);

				if (bo instanceof If) {

					TransactionalEditingDomain editingDomain = TransactionUtil
							.getEditingDomain(bo);
					editingDomain.getCommandStack().execute(
							new RecordingCommand(editingDomain) {
								ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

								@Override
								protected void doExecute() {

									Condition cond = ((If) bo).getIfCondition();
									if (cond != null) {
										try {
											cond.setLeftSide(list.get(leftOperand
													.getSelectionIndex()));
											cond.setRightSide(list.get(rightOperand
													.getSelectionIndex()));
										} catch (ArrayIndexOutOfBoundsException e) {
										}
									}

									featureProvider
											.layoutIfPossible(new LayoutContext(
													pe));
								}
							});
				}
			}
		}
	}
}
