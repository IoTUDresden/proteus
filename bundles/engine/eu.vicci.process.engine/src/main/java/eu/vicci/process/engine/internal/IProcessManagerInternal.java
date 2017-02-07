package eu.vicci.process.engine.internal;

import java.util.List;
import java.util.Map;

import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.ProcessInstance;

public interface IProcessManagerInternal {

	/**
	 * Id and Path
	 * @return
	 */
	Map<String, String> getUploadedProcesses();

	/**
	 * Id and Path
	 * @param uploadedProcesses
	 */
	void setUploadedProcesses(Map<String, String> uploadedProcesses);

	/**
	 * Id and Doc
	 * @return
	 */
	Map<String, Process> getDeployedprocesses();

	/**
	 * Id and Doc
	 * @param deployedprocesses
	 */
	void setDeployedprocesses(Map<String, Process> deployedprocesses);

	/**
	 * Model-Doc and Instance-Doc
	 * @return
	 */
	Map<ProcessInstance, Process> getProcessinstances();

	/**
	 * Model-Doc and Instance-Doc
	 * @param processinstances
	 */
	void setProcessinstances(Map<ProcessInstance, Process> processinstances);

	List<ProcessInstance> getRunningprocesses();

	void setRunningprocesses(List<ProcessInstance> runningprocesses);

	List<ProcessInstance> getPausedprocesses();

	void setPausedprocesses(List<ProcessInstance> pausedprocesses);

	void deleteInstance(String instanceid);

	void deleteProcess(String processid);

	Map<String, String> getPersistedinstances();

	void setPersistedinstances(Map<String, String> persistedinstances);

	String persistInstance(ProcessInstance pi);

	Process getProcess(String id);

	ProcessInstance getProcessInstance(String id);
	
	void setProcessInstancePersistor(ProcessInstancePersistor processInstancePersistor);

}