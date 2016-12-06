package eu.vicci.process.model.implementation.tests.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker.Context;

public class SimpleWhileLoopWorker implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		print("############# simple while loop: working #############");
		for (DataTypeInstance dataTypeInstance : parameter) {
			printData(dataTypeInstance);
			changeParameter(dataTypeInstance);						
		}		
		return parameter;
	}

	@Override
	public void deploy() {
		System.out.println("Simple while loop worker is deploying");		
	}
	
	private void changeParameter(DataTypeInstance data){
		if(!data.getDataTypeType().getName().equals("stringLeft"))
			return;
		StringTypeInstance stringData = (StringTypeInstance)data;
		String string = stringData.getValue() + "n";
		stringData.setValue(string);
	}
	
	private void printData(DataTypeInstance data){
		print(String.format("NAME: %s ID: %s",data.getName(), data.getInstanceId()));
		print(String.format("VALUE: %s",data.getValueAsObject()));
		
	}
	
	private void print(String text){
		System.out.println(text);
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		// TODO Auto-generated method stub
		return null;
	}
}
