package eu.vicci.process.engine.core;

public interface IProcessInfo {

	public String getProcessId();

	public void setProcessId(String processId);

	public String getProcessName();

	public void setProcessName(String processName);

	public String getProcessType();

	public void setProcessType(String processType);

	public String getProcessDescription();

	public void setProcessDescription(String processDescription);

}