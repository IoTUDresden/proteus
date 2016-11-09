package eu.vicci.process.model.implementation.tests.processstepclasses;

import java.util.Calendar;
import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;

public class GetSystemTimeWorker implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if(parameter.isEmpty()){
			System.err.println("There should be a startparameter with type int and name 'hours_of_day'");
			return parameter;
		}		
		DataTypeInstance instance = parameter.get(0);
		instance.parse(Integer.toString(hour));
		return parameter;
	}

	@Override
	public void deploy() {
		//nothing to do here		
	}

}
