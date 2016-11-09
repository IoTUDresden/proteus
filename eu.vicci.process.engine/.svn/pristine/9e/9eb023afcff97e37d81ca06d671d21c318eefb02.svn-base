package eu.vicci.process.engine;

import java.util.Map;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;

public class ProcessInstanceThread extends Thread implements Runnable {
	
	private final ProcessInstance pinstance;
	private final Map<String,DataTypeInstance> inputParameters;
	
	public ProcessInstanceThread(ProcessInstance processinstance,Map<String,DataTypeInstance> inputParameters) {
		this.pinstance = processinstance;
		this.inputParameters = inputParameters;
	}
	
	@Override
	public void run() {
		this.pinstance.start(inputParameters);
	}
	
	

}
