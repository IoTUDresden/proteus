package eu.vicci.process.model.util.logging;

import java.util.List;

import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public class InstanceLogger {
	
	private String processInstanceId;
	private ProcessInstance processInstance;
	private List<IStateChangeMessage> loggingMessages;
	private IStateChangeMessage recentLoggingMessage;
	
	public InstanceLogger(ProcessInstance processInstance, List<IStateChangeMessage> loggingMessages ) {
		this.processInstance = processInstance;
		this.loggingMessages = loggingMessages;
		this.processInstanceId = processInstance.getProcessInstanceID();
	}
	
	public void logStateMessage(IStateChangeMessage message){
		loggingMessages.add(message);
		recentLoggingMessage = message;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public List<IStateChangeMessage> getLoggingMessages() {
		return loggingMessages;
	}

	public void setLoggingMessages(List<IStateChangeMessage> loggingMessages) {
		this.loggingMessages = loggingMessages;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	public IStateChangeMessage getRecentLoggingMessage() {
		return recentLoggingMessage;
	}

	public void setRecentLoggingMessage(IStateChangeMessage recentLoggingMessage) {
		this.recentLoggingMessage = recentLoggingMessage;
	}
	
	

}
