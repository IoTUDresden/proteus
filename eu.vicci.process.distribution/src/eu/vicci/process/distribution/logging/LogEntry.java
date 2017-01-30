package eu.vicci.process.distribution.logging;

import java.io.Serializable;

public class LogEntry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1326391298968450931L;
	
	private String processInstanceId = "";
	private String clientInstanceId = "";
	private String processStepId = "";
	private String clientName = "";
	private String processName = "";
	private String message = ""; //evtl hier auf Object gehen...
	private String messageType = "";
	private String timestamp = "";

	public LogEntry(String timeStamp, String clientName, String processInstanceId, String clientInstanceId, String processStepId, String processName, String message, String messageType) {
		this.processInstanceId = processInstanceId;
		this.clientInstanceId = clientInstanceId;
		this.processStepId = processStepId;
		this.processName = processName;
		this.message = message;
		this.messageType = messageType;
		this.timestamp = timeStamp;
		this.clientName = clientName;
	}

	public LogEntry() {

	}

	public String getProcessName() {
		return processName;
	}

	public String getClientInstanceId() {
		return clientInstanceId;
	}

	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public String getProcessStepId() {
		return processStepId;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public String getMessageType() {
		return messageType;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	public void setClientInstanceId(String clientInstanceId) {
		this.clientInstanceId = clientInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public void setProcessStepId(String processStepId) {
		this.processStepId = processStepId;
	}

	@Override
	public String toString() {
		return timestamp + " | " + processName + " | " + clientName + " | " + messageType + " | " + message;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}
