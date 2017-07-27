package eu.vicci.process.distribution.core;

import eu.vicci.process.model.sofia.Process;

/**
 * Simple Wrapper class to store addtional infos for remote execution.
 */
public class RemoteProcess{
	private Process process;
	private boolean runCompensation;
	
	public Process getProcess() {
		return process;
	}
	
	public RemoteProcess setProcess(Process process) {
		this.process = process;
		return this;
	}
	
	public boolean isRunCompensation() {
		return runCompensation;
	}
	
	public RemoteProcess setRunCompensation(boolean runCompensation) {
		this.runCompensation = runCompensation;
		return this;
	}
	
	public String getId(){
		return process.getId();
	}
	
	public String getName(){
		return process.getName();
	}
}