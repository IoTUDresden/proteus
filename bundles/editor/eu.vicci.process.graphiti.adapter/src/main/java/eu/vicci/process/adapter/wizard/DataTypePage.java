package eu.vicci.process.adapter.wizard;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.ExpandItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

// TODO input for complex, list and set
// TODO complex in complex is not tested
public abstract class DataTypePage extends WizardPage {
	private static final String LBL_VALUE = "Value";
	private static final String LBL_ID = "Instance ID";
	private static final String LBL_MISSING = "ERROR: DT NAME IS MISSING";
	
	private Set<Control> errors = new HashSet<>(); 

	protected DataTypePage(String pageName) {
		super(pageName);		
	}
	
	/**
	 * Returns a list, with the filled {@link DataTypeInstance}s
	 * @return
	 */
	public abstract List<DataTypeInstance> getDataTypeInstances();
	
	protected Composite addDtField(DataTypeInstance dt, Composite parent){		
		return addDtField(dt, parent, true);
	}
	
	// TODO not in Group if its in a expand bar
	protected Composite addDtField(DataTypeInstance dt, Composite parent, boolean inGroup){		
		if(dt instanceof StringTypeInstance)
			return addStringField((StringTypeInstance)dt, parent);
		if (dt instanceof IntegerTypeInstance)
			return addIntField((IntegerTypeInstance)dt, parent);
		if (dt instanceof DoubleTypeInstance)
			return addDoubleField((DoubleTypeInstance)dt, parent);
		if (dt instanceof BooleanTypeInstance)
			return addBooleanField((BooleanTypeInstance)dt, parent);
		if (dt instanceof ComplexTypeInstance)
			return addComplexField((ComplexTypeInstance)dt, parent, !inGroup);
		
		return addNotImplementedDataType(dt, parent, inGroup);
	}
	
	private Composite addComplexField(ComplexTypeInstance dt, Composite parent, boolean inExpandBar){
		Composite container = inExpandBar? parent : createGroupContainer(dt, parent);
		ExpandBar expandBar = createExpandBarContainer(dt, container);
		
		FillLayout layout2 = new FillLayout();
		layout2.type = SWT.VERTICAL;
		container.setLayout(layout2);
		
		dt.getSubtypes().stream().forEach(st -> addComplexItem(st, expandBar, inExpandBar));
		return container;
	}
	
	private void addComplexItem(DataTypeInstance dt, ExpandBar parent, boolean inExpandBar){
		Composite control = addDtField(dt, parent, !inExpandBar);
		
		ExpandItem item = new ExpandItem(parent, SWT.NONE);		
		item.setText(dt.getName() == null ? LBL_MISSING : dt.getName());
		item.setHeight(control.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);		
		item.setControl(control);
		item.setExpanded(false);
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return errors.isEmpty();
	}

	private Composite addBooleanField(BooleanTypeInstance dt, Composite parent) {
		Composite container = createGroupContainer(dt, parent);
		GridLayout layout = createGridLayout();
		container.setLayout(layout);

		addValueLabel(dt, container);
		Button btn = new Button(container, SWT.CHECK);		
		btn.setLayoutData(createFieldGridData());
		btn.addSelectionListener(new SelectionListener() {			
			@Override
			public void widgetSelected(SelectionEvent e) {
				dt.setValue(btn.getSelection());				
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {}
		});
		
		addTypeAndInstanceInformation(dt, container);	
		return container;
	}
	
	private Composite addIntField(IntegerTypeInstance dt, Composite parent){
		Composite container = createGroupContainer(dt, parent);
		GridLayout layout = createGridLayout();
		container.setLayout(layout);

		addValueLabel(dt, container);
		Text txt = new Text(container, SWT.BORDER);
		txt.setText(Integer.toString(dt.getValue()));
		txt.setLayoutData(createFieldGridData());
		txt.addModifyListener(event -> {
			Integer v = parseInt(txt.getText());
			if(v == null){
				txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
				addError(txt);				
			}
			else {
				removeError(txt);
				txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
				dt.setValue(v.intValue());
			}
		});
		
		addTypeAndInstanceInformation(dt, container);	
		return container;
	}
	
	private void addError(Control control){
		errors.add(control);
		getWizard().getContainer().updateButtons();		
	}
	
	private void removeError(Control control){
		errors.remove(control);
		getWizard().getContainer().updateButtons();				
	}

	private Composite addDoubleField(DoubleTypeInstance dt, Composite parent) {
		Composite container = createGroupContainer(dt, parent);
		GridLayout layout = createGridLayout();
		container.setLayout(layout);

		addValueLabel(dt, container);
		Text txt = new Text(container, SWT.BORDER);
		txt.setText(Double.toString(dt.getValue()));
		txt.setLayoutData(createFieldGridData());
		txt.addModifyListener(event -> {
			Double v = parseDouble(txt.getText());
			if(v == null){
				txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_RED));
				addError(txt);
			}
			else {
				txt.setBackground(getShell().getDisplay().getSystemColor(SWT.COLOR_WHITE));
				dt.setValue(v.doubleValue());
				removeError(txt);
			}
		});
		
		addTypeAndInstanceInformation(dt, container);	
		return container;
	}

	private Composite addStringField(StringTypeInstance dt, Composite parent){
		Composite container = createGroupContainer(dt, parent);
		GridLayout layout = createGridLayout();
		container.setLayout(layout);

		addValueLabel(dt, container);
		Text txt = new Text(container, SWT.BORDER);
		txt.setText(dt.getValue() == null ? "" : dt.getValue());
		txt.setLayoutData(createFieldGridData());
		txt.addModifyListener(event -> {
			dt.setValue(txt.getText());
		});
		
		addTypeAndInstanceInformation(dt, container);
		return container;
	}
	
	private void addValueLabel(DataTypeInstance dt, Composite parent){
		Label lbl = new Label(parent, SWT.NONE);
		lbl.setText(LBL_VALUE);
	}
	
	private GridLayout createGridLayout(){
		GridLayout layout = new GridLayout(2, false);
		return layout;
	}
	
	private GridData createLblGridData(){
		GridData data = new GridData();
		return data;		
	}
	
	private GridData createFieldGridData(){
		GridData data = new GridData();
		data.grabExcessHorizontalSpace = true;
		data.horizontalAlignment = SWT.FILL;
		return data;		
	}
	
	private void addTypeAndInstanceInformation(DataTypeInstance dt, Composite parent){
		Label type = new Label(parent, SWT.NONE);
		type.setText(LBL_ID);
		type.setLayoutData(createLblGridData());
		
		Text instanceId = new Text(parent, SWT.BORDER);
		instanceId.setText(dt.getInstanceId());
		instanceId.setLayoutData(createFieldGridData());
		instanceId.setEnabled(false);
	}
	
	private Group createGroupContainer(DataTypeInstance dt, Composite parent){
		Group group = new Group(parent, SWT.SHADOW_ETCHED_IN);
		String name = dt.getName() == null ? LBL_MISSING : dt.getName();
		group.setText(name);
		return group;
	}
	
	private ExpandBar createExpandBarContainer(DataTypeInstance dt, Composite parent){
		ExpandBar expandBar = new ExpandBar(parent, SWT.V_SCROLL);
		return expandBar;
	}
	
	private Integer parseInt(String text){
		Integer out = null;
		try {
			out = Integer.parseInt(text);	
		} catch (NumberFormatException e) {}
		return out;
	}
	
	private Double parseDouble(String text){
		Double out = null;
		try {
			out = Double.parseDouble(text);	
		} catch (NumberFormatException e) {}
		return out;
	}
	
	private static final String ERROR_STR = "ERROR";
	private static final String ERROR_NOT_IMPL = "DataType not implemented yet";
	
	private Composite addNotImplementedDataType(DataTypeInstance dt, Composite parent, boolean inGroup){
		Composite container = createGroupContainer(dt, parent);
		GridLayout layout = createGridLayout();
		container.setLayout(layout);
		
		Label lbl = new Label(container, SWT.NONE);
		lbl.setText(ERROR_STR);
		
		Text txt = new Text(container, SWT.BORDER);
		txt.setText(ERROR_NOT_IMPL);
		txt.setEditable(false);
		txt.setBackground(new Color(null, 255, 0, 0));
		addError(txt); // this prevents the dialog from finishing
		return container;		
	}

}
