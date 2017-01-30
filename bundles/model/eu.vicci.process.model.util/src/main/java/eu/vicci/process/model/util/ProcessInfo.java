package eu.vicci.process.model.util;

import java.io.Serializable;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.model.sofia.Process;

public class ProcessInfo implements Serializable, IProcessInfo {	
	private static final long serialVersionUID = -547146626991315516L;
	private String processId;
	private String processName;
	private String processType;
	private String processDescription;

	public ProcessInfo() {}
	
	public ProcessInfo(String processId, String processName,
			String processType, String processDescription) {
		this.processId = processId;
		this.processName = processName;
		this.processType = processType;
		this.processDescription = processDescription;
	}
	
	public ProcessInfo(Process p) {
		this(p.getId(), p.getName(), p.getType(), p.getDescription());		
	}	

	@Override
	public String getProcessId() {
		return processId;
	}

	@Override
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	@Override
	public String getProcessName() {
		return processName;
	}

	@Override
	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Override
	public String getProcessType() {
		return processType;
	}

	@Override
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	@Override
	public String getProcessDescription() {
		return processDescription;
	}

	@Override
	public void setProcessDescription(String processDescription) {
		this.processDescription = processDescription;
	}
	
	

}
