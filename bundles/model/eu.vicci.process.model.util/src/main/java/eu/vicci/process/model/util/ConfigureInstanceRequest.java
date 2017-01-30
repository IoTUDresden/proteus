package eu.vicci.process.model.util;

public class ConfigureInstanceRequest {
	
	private String processId;
	private String configuration;
	
	public ConfigureInstanceRequest(String processId, String configuration) {
		super();
		this.processId = processId;
		this.configuration = configuration;
	}
	
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getConfiguration() {
		return configuration;
	}
	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}
	
}
