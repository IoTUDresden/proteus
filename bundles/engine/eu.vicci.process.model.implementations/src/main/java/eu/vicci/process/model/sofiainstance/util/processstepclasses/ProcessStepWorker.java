package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public interface ProcessStepWorker {

	List<DataTypeInstance> work(Context context);
	
	void deploy();
	
	static class Context {
		public List<DataTypeInstance> startParameter;
		public List<DataTypeInstance> endParameter;
		public String instanceId;
	}
}
