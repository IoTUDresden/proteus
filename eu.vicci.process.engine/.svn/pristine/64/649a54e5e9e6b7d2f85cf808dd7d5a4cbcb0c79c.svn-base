package eu.vicci.process.engine.internal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.ProcessInstance;

/**
 * Process manager for extended internal use
 * @author ronsei
 *
 */

public class ProcessManagerInternal implements IProcessManagerInternal {	
	private ProcessInstancePersistor processInstancePersistor;
	
	private Map<String, String> uploadedProcesses = new HashMap<String, String>();	
	private Map<String, Process> deployedprocesses = new HashMap<String,Process>();	
	private Map<ProcessInstance, Process> processinstances = new HashMap<ProcessInstance, Process>();	
	private Map<String,String> persistedinstances = new HashMap<String, String>();	
	private List<ProcessInstance> runningprocesses = new LinkedList<ProcessInstance>();	
	private List<ProcessInstance> pausedprocesses = new LinkedList<ProcessInstance>();
	
	public ProcessManagerInternal() {	
	}	
	
	@Override
	public Map<String, String> getUploadedProcesses() {
		return uploadedProcesses;
	}

	@Override
	public void setUploadedProcesses(Map<String, String> uploadedProcesses) {
		this.uploadedProcesses = uploadedProcesses;
	}

	@Override
	public Map<String, Process> getDeployedprocesses() {
		return deployedprocesses;
	}

	@Override
	public void setDeployedprocesses(Map<String, Process> deployedprocesses) {
		this.deployedprocesses = deployedprocesses;
	}

	@Override
	public Map<ProcessInstance, Process> getProcessinstances() {
		return processinstances;
	}

	@Override
	public void setProcessinstances(Map<ProcessInstance, Process> processinstances) {
		this.processinstances = processinstances;
	}

	@Override
	public List<ProcessInstance> getRunningprocesses() {
		return runningprocesses;
	}

	@Override
	public void setRunningprocesses(List<ProcessInstance> runningprocesses) {
		this.runningprocesses = runningprocesses;
	}

	@Override
	public List<ProcessInstance> getPausedprocesses() {
		return pausedprocesses;
	}

	@Override
	public void setPausedprocesses(List<ProcessInstance> pausedprocesses) {
		this.pausedprocesses = pausedprocesses;
	}
	
	@Override
	public void deleteInstance(String instanceid) {
		
	}
	
	@Override
	public void deleteProcess(String processid) {
		
	}

	@Override
	public Map<String, String> getPersistedinstances() {
		return persistedinstances;
	}

	@Override
	public void setPersistedinstances(Map<String, String> persistedinstances) {
		this.persistedinstances = persistedinstances;
	}
	
	@Override
	public String persistInstance(ProcessInstance pi) {
		String path = processInstancePersistor.persistInstance(pi);
		return path;
	}
	
	@Override
	public Process getProcess(String id) {
		return getDeployedprocesses().get(id);
	}
	
	@Override
	public ProcessInstance getProcessInstance(String id) {
		for (ProcessInstance pi : getProcessinstances().keySet()) {
			if (pi.getInstanceId().equals(id)) {
				return pi;
			}
		}
		return null;
	}

	@Override
	public void setProcessInstancePersistor(ProcessInstancePersistor processInstancePersistor) {
		this.processInstancePersistor = processInstancePersistor;		
	}
	
}
