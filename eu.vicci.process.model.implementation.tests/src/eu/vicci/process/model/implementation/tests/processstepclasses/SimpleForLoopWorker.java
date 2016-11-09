package eu.vicci.process.model.implementation.tests.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;

public class SimpleForLoopWorker implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		print("############# simple loop: working #############");
		for (DataTypeInstance dataTypeInstance : parameter) {
			print(String.format("NAME: %s ID: %s",dataTypeInstance.getName(), dataTypeInstance.getInstanceId()));
			print(String.format("VALUE: %s",dataTypeInstance.getValueAsObject()));			
		}
		return parameter;
	}

	@Override
	public void deploy() {
		print("SimpleForLoopWorker: deploying");
		
	}
	
	private void print(String text){
		System.out.println(text);
	}
}
