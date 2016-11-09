package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

public final class ProcessExecutedMessage {
	private final ProcessStepInstanceImplCustom processStepInstance;
	
	public ProcessExecutedMessage(ProcessStepInstanceImplCustom processStepInstance) {
		this.processStepInstance = processStepInstance;
	}

	public ProcessStepInstanceImplCustom getProcessStepInstance() {
		return processStepInstance;
	}
}
