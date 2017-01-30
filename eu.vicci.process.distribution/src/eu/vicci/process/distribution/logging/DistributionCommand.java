package eu.vicci.process.distribution.logging;

import java.io.Serializable;

public class DistributionCommand implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -4303189097677194859L;


	private String commandName;
	private String command;
	private String peerName;
	private String processName;
	private String processInstanceId;
	private String peerIp;

	public DistributionCommand() {
		// TODO Auto-generated constructor stub
	}


	public String getCommandName() {
		return commandName;
	}
	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}

	public String getPeerName() {
		return peerName;
	}


	public void setPeerName(String peerName) {
		this.peerName = peerName;
	}


	public String getProcessName() {
		return processName;
	}


	public void setProcessName(String processName) {
		this.processName = processName;
	}


	public String getPeerIp() {
		return peerIp;
	}


	public void setPeerIp(String peerIp) {
		this.peerIp = peerIp;
	}


	public String getProcessInstanceId() {
		return processInstanceId;
	}


	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}


	@Override
	public String toString() {
		return "DistributionCommand [commandName=" + commandName + ", command=" + command + ", peerName=" + peerName
				+ ", processName=" + processName + ", processInstanceId=" + processInstanceId + ", peerIp=" + peerIp
				+ "]";
	}


}
