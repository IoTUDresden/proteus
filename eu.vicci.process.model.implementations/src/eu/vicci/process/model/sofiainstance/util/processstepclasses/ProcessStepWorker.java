package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public interface ProcessStepWorker {
	
	/**
	 * @deprecated use ProcessStepWorker::work(ProcessStepWorker.Context) instead
	 */
	@Deprecated 
	List<DataTypeInstance> work(List<DataTypeInstance> parameter);

	List<DataTypeInstance> work(Context context);
	
	void deploy();
	
	static class Context {
		public List<DataTypeInstance> startParameter;
		public List<DataTypeInstance> endParameter;
		public String instanceId;
	}
}
