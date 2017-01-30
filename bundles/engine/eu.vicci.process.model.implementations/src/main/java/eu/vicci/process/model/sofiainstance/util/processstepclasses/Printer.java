package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class Printer implements ProcessStepWorker{

	@Override
	public void deploy() {
		System.out.println("A ProcessStepWorker-Class was deployed by a generic ProcessStep and says: 'Hello, I am a printer!'");		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		System.out.println("Printer says: 'I got the folowing parameter:'");
		for(DataTypeInstance s : context.startParameter){
			System.out.println(s.serializeToXML());
		}
		return context.startParameter;
	}
}
