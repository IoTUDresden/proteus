package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public interface ProcessStepWorker {
	public List<DataTypeInstance> work(List<DataTypeInstance> parameter);
	public void deploy();
}