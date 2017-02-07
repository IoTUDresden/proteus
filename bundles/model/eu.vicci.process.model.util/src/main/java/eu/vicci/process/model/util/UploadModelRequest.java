package eu.vicci.process.model.util;

public class UploadModelRequest {
	
	private String processId;
	private byte[] processDoc;
	private String processDocXML;
	boolean isDiagram;
	boolean isCompressed;
	private boolean overrideExisting;
	
	public UploadModelRequest() {
		
	}
	
	public UploadModelRequest(String processId, byte[] processDoc,
			boolean isDiagram) {
		this(processId, processDoc, isDiagram, false);
	}
	
	public UploadModelRequest(String processId, byte[] processDoc,
			boolean isDiagram, boolean overrideExisting) {
		super();
		this.processId = processId;
		this.processDoc = processDoc;
		this.isDiagram = isDiagram;
		this.isCompressed = true;
		this.setOverrideExisting(overrideExisting);
	}
	
	public UploadModelRequest(String processId, String processDocXML,
			boolean isDiagram) {
		super();
		this.processId = processId;
		this.processDocXML = processDocXML;
		this.isDiagram = isDiagram;
		this.isCompressed = false;
	}
	
	

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public byte[] getProcessDoc() {
		return processDoc;
	}

	public void setProcessDoc(byte[] processDoc) {
		this.processDoc = processDoc;
	}

	public boolean isDiagram() {
		return isDiagram;
	}

	public void setDiagram(boolean isDiagram) {
		this.isDiagram = isDiagram;
	}

	public String getProcessDocXML() {
		return processDocXML;
	}

	public void setProcessDocXML(String processDocXML) {
		this.processDocXML = processDocXML;
	}

	public boolean isCompressed() {
		return isCompressed;
	}

	public void setCompressed(boolean isCompressed) {
		this.isCompressed = isCompressed;
	}

	public boolean isOverrideExisting() {
		return overrideExisting;
	}

	public void setOverrideExisting(boolean overrideExisting) {
		this.overrideExisting = overrideExisting;
	}
}
