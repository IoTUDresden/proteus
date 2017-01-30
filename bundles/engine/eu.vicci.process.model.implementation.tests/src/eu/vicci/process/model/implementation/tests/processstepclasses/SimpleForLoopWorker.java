package eu.vicci.process.model.implementation.tests.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;

public class SimpleForLoopWorker implements ProcessStepWorker {

	@Override
	public void deploy() {
		print("SimpleForLoopWorker: deploying");
		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		print("############# simple loop: working #############");
		for (DataTypeInstance dataTypeInstance : context.startParameter) {
			print(String.format("NAME: %s ID: %s",dataTypeInstance.getName(), dataTypeInstance.getInstanceId()));
			print(String.format("VALUE: %s",dataTypeInstance.getValueAsObject()));			
		}
		return context.startParameter;
	}
	
	private void print(String text){
		System.out.println(text);
	}
}
