package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

public final class ProcessResetMessage {
	
	private ProcessStepInstanceImplCustom resetProcess;

	public ProcessStepInstanceImplCustom getResetProcess() {
		return resetProcess;
	}

	public ProcessResetMessage(ProcessStepInstanceImplCustom resetProcess) {
		this.resetProcess = resetProcess;
	}

}
