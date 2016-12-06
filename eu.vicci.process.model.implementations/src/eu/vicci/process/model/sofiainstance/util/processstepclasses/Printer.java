package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker.Context;

public class Printer implements ProcessStepWorker{

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		System.out.println("Printer says: 'I got the folowing parameter:'");
		for(DataTypeInstance s : parameter){
			System.out.println(s.serializeToXML());
		}
		return parameter;
	}

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a printer!'");		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		// TODO Auto-generated method stub
		return null;
	}
}
