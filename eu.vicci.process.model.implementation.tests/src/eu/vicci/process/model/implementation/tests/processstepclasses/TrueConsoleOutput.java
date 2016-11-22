package eu.vicci.process.model.implementation.tests.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.util.processstepclasses.ProcessStepWorker;

public class TrueConsoleOutput implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter) {
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("##                                 ##");
		System.out.println("## The True Process is working...  ##");
		System.out.println("##                                 ##");
		System.out.println("#####################################");
		System.out.println("#####################################");
		return parameter;
	}

	@Override
	public void deploy() {
		System.out.println("The True Process is deplyoing");		
	}

	@Override
	public List<DataTypeInstance> work(List<DataTypeInstance> inParameter, List<DataTypeInstance> outParameter) {
		// TODO Auto-generated method stub
		return null;
	}

}
