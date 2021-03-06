package eu.vicci.process.engine.internal;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.engine.ProcessInstanceThread;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.MappingUtilImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;
import eu.vicci.process.model.util.logging.LoggingManager;
import eu.vicci.process.model.util.messages.MessageQueue;

public class ProcessInstanceExecutor {
	private static final Logger logger = LoggerFactory.getLogger(ProcessInstanceExecutor.class);
	public static final String INSTANCE_PREFIX = "_instance_";
	
	private final IProcessManagerInternal processManager;
	private final IProcessManager processManagerPublic;
	private MessageQueue messageQueue;
	
	public ProcessInstanceExecutor(IProcessManagerInternal processManager, MessageQueue messageQueue, IProcessManager processManagerPublic){
		this.processManager = processManager;	
		this.messageQueue = messageQueue;
		this.processManagerPublic = processManagerPublic;
	}	
	
	public void setMessageQueue(MessageQueue messageQueue){
		this.messageQueue = messageQueue;
	}
	
	public ProcessInstance deploy(String processid){		
		Process process = processManager.getDeployedprocesses().get(processid);			
		List<ProcessInstance> existinginstances = new LinkedList<ProcessInstance>();		
		Map<ProcessInstance, Process> instantiatedprocesses = processManager.getProcessinstances();
	
		//Find out number of existing instances of one process
		for (ProcessInstance pi1 : instantiatedprocesses.keySet()) {
			if (pi1.getProcessStepType().getId().equals(process.getId())) {
				existinginstances.add(pi1);
			}
		}
		
		int number = existinginstances.size() + 1;
		String instanceid = processid + INSTANCE_PREFIX + number;
		
		MappingUtilImplCustom mapper = new MappingUtilImplCustom();
		mapper.setInstanceNumber(number);
		ProcessInstance processinstance = (ProcessInstance)mapper.mapProcessStep((ProcessStep)process);
		
		processinstance.setProcessStepType(process);
		
		processinstance.setInstancenumber(number);
		
		processinstance.setInstanceId(instanceid);
		processinstance.setProcessInstanceID(instanceid);
		processinstance.setProcessModelID(processid);
		
		processManager.getProcessinstances().put(processinstance, process);
		LoggingManager.getInstance().createLoggingForInstance(processinstance);
		processinstance.deploy(mapper);
		
		if(processinstance instanceof ProcessStepInstanceImplCustomBase){
			ProcessStepInstanceImplCustomBase tmp = (ProcessStepInstanceImplCustomBase) processinstance;
			addMessageQueue(tmp);
			addProcessManager(tmp);
		}
		
		return processinstance;
	}
	
	public String configure(String processinstanceid, Configuration conf){
		System.out.println("Processexecutor.configure()");
		ProcessInstance processinstance = processManager.getProcessInstance(processinstanceid);
		processinstance.configure(conf);
		return ReplyState.SUCCESS;
	}
	
	public String execute(String processinstanceid, String runningForInstanceId, Map<String,DataTypeInstance> inputParameters) {
		System.out.println("ProcessInstanceExecutor: processinstanceid: " + processinstanceid);
		ProcessInstance processinstance = processManager.getProcessInstance(processinstanceid);
		
		if(processinstance == null){
			logger.error("cant get process instance with instance id: {}", processinstanceid);
			return ReplyState.ERROR;
		}
		
		processinstance.setRunningForInstanceId(runningForInstanceId);
		Thread pit = new ProcessInstanceThread(processinstance, inputParameters);
		pit.start();
		
		return processinstance.getInstanceId();		
	}
	
	private void addProcessManager(ProcessStepInstanceImplCustomBase root){
		root.setProcessManager(processManagerPublic);
		root.getSubSteps().stream().filter(step -> step instanceof ProcessStepInstanceImplCustomBase)
		.forEach(step -> addProcessManager((ProcessStepInstanceImplCustomBase)step));		
	}
	
	private void addMessageQueue(ProcessStepInstanceImplCustomBase root){
		root.setMessageQueue(messageQueue);
		root.getSubSteps().stream()
		.filter(step -> step instanceof ProcessStepInstanceImplCustomBase)
		.forEach(step -> addMessageQueue((ProcessStepInstanceImplCustomBase)step));
	}
}
