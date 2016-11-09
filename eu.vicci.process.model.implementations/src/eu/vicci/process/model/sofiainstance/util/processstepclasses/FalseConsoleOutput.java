package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class FalseConsoleOutput implements ProcessStepWorker {
	
	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("##                                 ##");
		System.out.println("## The False Process is working... ##");
		System.out.println("##                                 ##");
		System.out.println("#####################################");
		System.out.println("#####################################");
		return parameter;
	}

	@Override
	public void deploy() {
		System.out.println("The False Process is deplyoing...");		
	}

}
