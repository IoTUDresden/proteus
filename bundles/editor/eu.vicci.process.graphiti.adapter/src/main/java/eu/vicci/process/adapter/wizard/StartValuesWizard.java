package eu.vicci.process.adapter.wizard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.wizard.Wizard;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class StartValuesWizard extends Wizard {
	private AllValuesPage allValuesPage;
	private Map<String, DataTypeInstance> startValues = null;
	
	public StartValuesWizard(List<DataTypeInstance> dataTypeInstances) {
		super();
		allValuesPage = new AllValuesPage(dataTypeInstances);
		setHelpAvailable(false);
		setNeedsProgressMonitor(false);
	}
	
	@Override
	public void addPages() {
		addPage(allValuesPage);
	}
	
	public Map<String, DataTypeInstance> getStartValues(){
		return startValues;
	}
	
	@Override
	public boolean canFinish() {
		return allValuesPage.canFlipToNextPage();
	}

	@Override
	public boolean performFinish() {
		createStartValues();
		return true;
	}
	
	private void createStartValues(){
		List<DataTypeInstance> dataTypeInstances = allValuesPage.getDataTypeInstances();
		if(dataTypeInstances == null)
			return;
		
		startValues = new HashMap<String, DataTypeInstance>();
		dataTypeInstances.stream()
		.forEach(dt -> startValues.put(dt.getDataTypeType().getId(), dt));
	}

}
