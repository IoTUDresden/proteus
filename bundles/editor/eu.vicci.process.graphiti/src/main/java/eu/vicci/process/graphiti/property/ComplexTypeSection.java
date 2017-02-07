package eu.vicci.process.graphiti.property;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertyConstants;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.Util;
import eu.vicci.process.graphiti.types.DataTypeAddFeature;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;

public class ComplexTypeSection extends GFPropertySection implements ITabbedPropertyConstants {

	private static CCombo dropdown;
	private List<DataType> dataTypes = new ArrayList<DataType>();
	private Composite composite;
	private Button addButton;

	@Override
	public void createControls(final Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;

		dropdown = factory.createCCombo(composite);
		dropdown.removeAll();
		dataTypes.clear();
		for (DataType type : dataTypes)
			dropdown.add(type.getName());

		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(dropdown, 200);
		data.top = new FormAttachment(0, VSPACE);
		dropdown.setLayoutData(data);

		CLabel typeLabel = factory.createCLabel(composite, "Reference:");
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(dropdown, HSPACE);
		typeLabel.setLayoutData(data);

		addButton = factory.createButton(composite, "Add", SWT.NONE);
		data = new FormData();
		data.top = new FormAttachment(0, 0);
		data.left = new FormAttachment(dropdown, 0);
		data.right = new FormAttachment(addButton, 100);
		addButton.setLayoutData(data);

		addButton.addSelectionListener(new MyClickListener());

		composite.layout(true, true);
	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo instanceof ComplexType) {

				List<DataType> types = Util.getAllReferableDataTypes(getDiagram(), pe);

				dropdown.removeAll();
				for (DataType type : types) {
					if (type.getName() != null && type != bo)
						dropdown.add(type.getName());
				}
			}
		}
	}

	private class MyClickListener implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent e) {
			PictogramElement pe = getSelectedPictogramElement();
			EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {

					PictogramElement pe = getSelectedPictogramElement();
					EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
					List<DataType> accessibleTypes = Util.getAllReferableDataTypes(getDiagram(), pe);

					if (bo instanceof ComplexType) {
						ComplexType complexType = (ComplexType) bo;
						for (DataType type : accessibleTypes) {
							if (type.getName().equals(dropdown.getText())) {
								complexType.getSubreferences().add(type);
								DataTypeAddFeature.resizeWholeType(getDiagram(), pe);
								break;
							}
						}
					}
				}
			});
			
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}
	}
}