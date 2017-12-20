package eu.vicci.process.client.core;

public class UploadAndDeployRequest {
	
	private String processdocument;
	private boolean overrideExisting = true;
	
	public UploadAndDeployRequest() {	}

	public String getProcessdocument() {
		return processdocument;
	}

	public void setProcessdocument(String processdocument) {
		this.processdocument = processdocument;
	}

	public boolean isOverrideExisting() {
		return overrideExisting;
	}

	public void setOverrideExisting(boolean overrideExisting) {
		this.overrideExisting = overrideExisting;
	}

}
