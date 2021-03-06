package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class TrueConsoleOutput implements ProcessStepWorker {

	@Override
	public void deploy() {
		System.out.println("The True Process is deplyoing");		
	}

	@Override
	public List<DataTypeInstance> work(Context context) {
		System.out.println("#####################################");
		System.out.println("#####################################");
		System.out.println("##                                 ##");
		System.out.println("## The True Process is working...  ##");
		System.out.println("##                                 ##");
		System.out.println("#####################################");
		System.out.println("#####################################");
		return context.startParameter;
	}

}
