package eu.vicci.process.distribution.manager;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public class Checkpoint {

	private String processId;
	private String processInstanceId;
	private eu.vicci.process.model.sofia.Process process;
	private Map<String, DataTypeInstance> processData;
	
	public Checkpoint(Process subProcess) {
		Process copy = EcoreUtil.copy(subProcess);
		this.processId = copy.getId();
		this.process = copy;
	}
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public Process getProcess() {
		return process;
	}
	public void setProcess(Process process) {
		this.process = process;
	}
	public Map<String, DataTypeInstance> getProcessData() {
		return processData;
	}
	public void setProcessData(Map<String, DataTypeInstance>  processData) {
		this.processData = processData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((processId == null) ? 0 : processId.hashCode());
		result = prime * result + ((processInstanceId == null) ? 0 : processInstanceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checkpoint other = (Checkpoint) obj;
		if (processId == null) {
			if (other.processId != null)
				return false;
		} else if (!processId.equals(other.processId))
			return false;
		if (processInstanceId == null) {
			if (other.processInstanceId != null)
				return false;
		} else if (!processInstanceId.equals(other.processInstanceId))
			return false;
		return true;
	}
	
}
