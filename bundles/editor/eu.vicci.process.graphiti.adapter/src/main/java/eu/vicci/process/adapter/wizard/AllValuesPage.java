package eu.vicci.process.adapter.wizard;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class AllValuesPage extends DataTypePage {
	private List<DataTypeInstance> dataTypeInstances;

	public AllValuesPage(List<DataTypeInstance> dataTypeInstances) {
		super("AllStartValues");
		setTitle("Set Start Values");
		setDescription("Set all start values to execute the process with.");
		this.dataTypeInstances = dataTypeInstances;
	}

	@Override
	public void createControl(Composite parent) {
		FillLayout layout = new FillLayout();
		layout.type = SWT.VERTICAL;
		parent.setLayout(layout);
		
		dataTypeInstances.stream().forEach(dt -> addDtField(dt, parent));
		setControl(parent);
	}

	@Override
	public List<DataTypeInstance> getDataTypeInstances() {
		return dataTypeInstances;
	}

}
