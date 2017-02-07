package eu.vicci.process.model.util;

public class ExecuteProcessStepRequest {
	
	private String processStepModel;
	private String processStepInstance;
	private boolean alreadyExecuting;
	
	public ExecuteProcessStepRequest() {
		
	}

	public ExecuteProcessStepRequest(String processStepModel,
			String processStepInstance, boolean alreadyExecuting) {
		super();
		this.processStepModel = processStepModel;
		this.processStepInstance = processStepInstance;
		this.alreadyExecuting = alreadyExecuting;
	}

	public String getProcessStepModel() {
		return processStepModel;
	}

	public void setProcessStepModel(String processStepModel) {
		this.processStepModel = processStepModel;
	}

	public String getProcessStepInstance() {
		return processStepInstance;
	}

	public void setProcessStepInstance(String processStepInstance) {
		this.processStepInstance = processStepInstance;
	}

	public boolean isAlreadyExecuting() {
		return alreadyExecuting;
	}

	public void setAlreadyExecuting(boolean alreadyExecuting) {
		this.alreadyExecuting = alreadyExecuting;
	}
	
	

}
