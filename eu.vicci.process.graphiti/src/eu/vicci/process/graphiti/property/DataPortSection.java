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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import eu.vicci.process.graphiti.ProcessFeatureProvider;
import eu.vicci.process.graphiti.Util;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;

public class DataPortSection extends PropertySectionBase {

	private Text valueText;
	private static CCombo dropdown;
	private List<DataType> dataTypes = new ArrayList<DataType>();
	private Composite composite;

	@Override
	public void createControls(final Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {

		super.createControls(parent, tabbedPropertySheetPage);

		TabbedPropertySheetWidgetFactory factory = getWidgetFactory();
		composite = factory.createFlatFormComposite(parent);
		FormData data;

		valueText = factory.createText(composite, ""); //$NON-NLS-1$
		valueText.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.keyCode == SWT.CR || e.keyCode == SWT.KEYPAD_CR) {
					new StateFocusListener().focusLost(null);
				}
			}
		});

		valueText.setEditable(true);
		data = new FormData();
		data.left = new FormAttachment(0, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(50, -HSPACE);
		data.top = new FormAttachment(0, VSPACE);
		valueText.setLayoutData(data);
		valueText.addFocusListener(new StateFocusListener());

		CLabel valueLabel = factory.createCLabel(composite, "Value:"); //$NON-NLS-1$
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(valueText, -HSPACE);
		data.top = new FormAttachment(valueText, 0, SWT.CENTER);
		valueLabel.setLayoutData(data);
		valueLabel.setVisible(true);

		dropdown = factory.createCCombo(composite);
		dataTypes = Util.getAllTypesAccessible(getSelectedPictogramElement());
		dropdown.removeAll();
		dataTypes.clear();
		for (DataType type : dataTypes)
			dropdown.add(type.getName());

		dropdown.addSelectionListener(new MySelectionListener());

		data = new FormData();
		data.left = new FormAttachment(50, STANDARD_LABEL_WIDTH);
		data.right = new FormAttachment(dropdown, 200);
		data.top = new FormAttachment(0, VSPACE);
		dropdown.setLayoutData(data);

		CLabel typeLabel = factory.createCLabel(composite, "DataType:");
		data = new FormData();
		data.top = new FormAttachment(0, VSPACE);
		data.left = new FormAttachment(valueText, 0);
		data.right = new FormAttachment(dropdown, -HSPACE);
		typeLabel.setLayoutData(data);

		composite.layout(true, true);
		dropdown.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				EObject bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(getSelectedPictogramElement());
				if (bo instanceof DataPort) {
					clearMapping((DataPort) bo);
					createCheckboxes((DataPort) bo, parent);
				}
			}
		});
	}

	private void createCheckboxes(final DataPort dp, Composite parent) {
		for (Control child : parent.getChildren()) {
			if (child instanceof Composite) {
				if (((Composite) child).getToolTipText() != null && ((Composite) child).getToolTipText().equals("checkboxes")) {
					child.dispose();
					break;
				} else {
					((Composite) child).layout(true, true);
				}
			}

		}

		// if checkboxes should be shown
		if (dp.getPortDatatype() != null && dp.getPortDatatype().getMappings() != null && dp.getPortDatatype().getMappings().size() > 0) {

			boolean addedSomething = true;

			ArrayList<DataMapping> mappings = new ArrayList<DataMapping>();
			ArrayList<DataMapping> mappingsHelper = new ArrayList<DataMapping>();

			mappings.addAll(dp.getPortDatatype().getMappings());

			if (dp.getPortDatatype() instanceof ComplexType) {
				ComplexType ct = (ComplexType) dp.getPortDatatype();
				ArrayList<DataType> types = new ArrayList<DataType>();
				types.addAll(ct.getSubtypes());

				//Add Subtype mappings
				while (addedSomething) {
					addedSomething = false;
					for (DataType type : types) {
						if(type.getMappings()!=null && type.getMappings().size()>0){
							mappingsHelper.addAll(type.getMappings());
						}
						if(type instanceof ComplexType && !types.contains(type)){
							types.add(type);
							addedSomething = true;
						}
					}
					for(DataMapping mapping : mappingsHelper){
						if(!mappings.contains(mapping)){
							mappings.add(mapping);
						}
					}
				}
			}
			
			//Add Transitive Mappings (if A->B and B->C then B->C Mappings are available from DataType A
//			addedSomething = true;
//			while (addedSomething) {
//				addedSomething = false;
//				for (DataMapping mapping : mappings) {
//					for (DataMapping subMapping : mapping.getTarget().getMappings()) {
//						mappingsHelper.add(subMapping);
//					}
//				}
//				for (DataMapping mappingToAdd : mappingsHelper) {
//					if (!mappings.contains(mappingToAdd)) {
//						mappings.add(mappingToAdd);
//						addedSomething = true;
//					}
//				}
//				mappingsHelper.clear();
//			}

			// make new Checkbox-Container
			composite = new Composite(parent, SWT.NONE);
			composite.setToolTipText("checkboxes");
			composite.setLayout(new FillLayout());

			// label "Mappings"
			CLabel typeLabel = new CLabel(composite, SWT.NONE);
			typeLabel.setText("Mappings");

			// adding checkboxes
			for (final DataMapping mapping : mappings) {
				final Button b = new Button(composite, SWT.CHECK);
				b.setText(Util.shortenString(mapping.getName()));
				b.setToolTipText(mapping.getName());
				if (dp.getMappings().contains(mapping))
					b.setSelection(true);
				else
					b.setSelection(false);

				// Listener
				b.addFocusListener(new FocusListener() {
					@Override
					public void focusLost(FocusEvent e) {
						if (b.getSelection()) {
							addOrRemoveMapping(true, dp, mapping);
						} else {
							addOrRemoveMapping(false, dp, mapping);
						}
					}

					@Override
					public void focusGained(FocusEvent e) {
					}
				});
			}
			// re-layouting
			composite.layout(true, true);
		}
		// re-layouting
		parent.layout(true, true);
	}

	@Override
	public void refresh() {

		PictogramElement pe = getSelectedPictogramElement();

		if (pe != null) {

			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

			if (bo instanceof DataPort) {
				String value = ((DataPort) bo).getValue();
				valueText.setText(value == null ? "" : value);

				List<DataType> types = Util.getAllTypesAccessible(getSelectedPictogramElement());

				dropdown.removeAll();
				for (DataType type : types) {
					if (type.getName() != null)
						dropdown.add(type.getName());
				}

				DataType type = ((DataPort) bo).getPortDatatype();
				if (type != null && type.getName() != null) {
					String typeName = type.getName();
					dropdown.setText(typeName);
				}
				createCheckboxes(((DataPort) bo), composite.getParent());
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
					List<DataType> accessibleTypes = Util.getAllTypesAccessible(pe);

					if (bo instanceof DataPort) {
						DataPort port = (DataPort) bo;
						for (DataType type : accessibleTypes) {
							if (type.getName().equals(dropdown.getText())) {
								port.setPortDatatype(type);
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

	private class StateFocusListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public void focusLost(FocusEvent event) {

			final PictogramElement pe = getSelectedPictogramElement();

			if (pe != null) {

				final Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);

				if (bo instanceof DataPort) {
					final DataPort dataPort = (DataPort) bo;
					// System.out.println("port Mappings size = " +
					// dataPort.getMappings().size());
					TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
					editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {
						ProcessFeatureProvider featureProvider = getProcessFeatureProvider();

						@Override
						protected void doExecute() {
							String name = valueText.getText();
							if (name != null)
								dataPort.setValue(name);
							featureProvider.layoutIfPossible(new LayoutContext(pe));

							String typeName = dropdown.getText();
							for (DataType type : dataTypes)
								if (type.getName().equals(typeName))
									dataPort.setPortDatatype(type);

							List<DataType> accessibleTypes = Util.getAllTypesAccessible(pe);
							if (bo instanceof DataPort) {
								DataPort port = (DataPort) bo;
								for (DataType type : accessibleTypes) {
									if (type.getName().equals(dropdown.getText())) {
										port.setPortDatatype(type);
										break;
									}
								}
							}

						}
					});
				}
			}
		}
	}

	/**
	 * adds or removes a {@link DataMapping} in the {@link DataPort}'s mapping
	 * list
	 * 
	 * @param add
	 *            true if mapping should be added, false if it should be removed
	 * @param port
	 *            the {@link DataPort} to add the {@link DataMapping} to
	 * @param mapping
	 *            the {@link DataMapping} to add to the DataPort's mapping list
	 */
	private void addOrRemoveMapping(final boolean add, final DataPort port, final DataMapping mapping) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(port);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				if (add)
					port.getMappings().add(mapping);
				else
					port.getMappings().remove(mapping);
			}

		});
	}

	/**
	 * clears a {@link DataPort}'s mapping list
	 * 
	 * @param port
	 *            the {@link DataPort} to be cleared of {@link DataMapping}s
	 */
	private void clearMapping(final DataPort port) {
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(port);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				port.getMappings().clear();
			}

		});
	}
}
