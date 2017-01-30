package eu.vicci.process.graphiti.property;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.LayoutContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;

public class HumanTaskSection extends PropertySectionBase {
	private CCombo useCase;
	private CCombo type;

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite composite = getWidgetFactory().createFlatFormComposite(parent);
		createType(composite);
		createUseCase(composite);
	}

	private void createUseCase(Composite parent) {
		useCase = getWidgetFactory().createCCombo(parent);
		for (HumanTaskUseCase val : HumanTaskUseCase.values())
			useCase.add(val.getName());
		useCase.addSelectionListener(dropDownListener);
		useCase.setEditable(false);

		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(type, VSPACE);
		useCase.setLayoutData(data);

		CLabel valueLabel = getWidgetFactory().createCLabel(parent, "Use Case:"); //$NON-NLS-1$
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0, 0);
		labelData.right = new FormAttachment(useCase, -HSPACE);
		labelData.top = new FormAttachment(useCase, 0, SWT.CENTER);
		valueLabel.setLayoutData(labelData);
	}

	private void createType(Composite parent) {
		type = getWidgetFactory().createCCombo(parent);
		for (HumanTaskType val : HumanTaskType.values())
			type.add(val.getName());
		type.addSelectionListener(dropDownListener);
		type.setEditable(false);

		FormData data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(100, 0);
		data.top = new FormAttachment(0, VSPACE);
		type.setLayoutData(data);

		CLabel valueLabel = getWidgetFactory().createCLabel(parent, "HT Type:"); //$NON-NLS-1$
		FormData labelData = new FormData();
		labelData.left = new FormAttachment(0, 0);
		labelData.right = new FormAttachment(type, -HSPACE);
		labelData.top = new FormAttachment(type, 0, SWT.CENTER);
		valueLabel.setLayoutData(labelData);
	}

	@Override
	public void refresh() {
		super.refresh();
		HumanTask ht = getHumanTask();
		if (ht == null)
			return;
		if (ht.getHumanTaskType() != null && type != null)
			type.select(ht.getHumanTaskType().getValue());
		else
			type.select(HumanTaskType.HINT_VALUE);
		
		if (ht.getHumanTaskUseCase() != null && useCase != null)
			useCase.select(ht.getHumanTaskUseCase().getValue());
		else
			useCase.select(HumanTaskUseCase.UNIVERSAL_VALUE);
	}

	private SelectionListener dropDownListener = new SelectionListener() {
		@Override
		public void widgetSelected(SelectionEvent e) {
			writeToModel();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {

		}
	};

	private HumanTaskType getHtType() {
		return HumanTaskType.get(type.getSelectionIndex());
	}

	private HumanTaskUseCase getHtUseCase() {
		return HumanTaskUseCase.get(useCase.getSelectionIndex());
	}

	private HumanTask getHumanTask() {
		PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof HumanTask)
				return (HumanTask) bo;
		}
		return null;
	}

	private void writeToModel() {
		final PictogramElement pe = getSelectedPictogramElement();
		if (pe != null) {
			final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			if (bo instanceof HumanTask) {
				HumanTask humanTask = (HumanTask) bo;
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
				editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
					ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

					@Override
					protected void doExecute() {
						humanTask.setHumanTaskType(getHtType());
						humanTask.setHumanTaskUseCase(getHtUseCase());
						featureProvider.layoutIfPossible(new LayoutContext(pe));
					}
				});
			}
		}
	}

}
