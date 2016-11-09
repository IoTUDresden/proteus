package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

public interface ProcessResetListener {
	/**
	 * Called when a process has been reset.
	 * @param process
	 */
	void processReset(ProcessStepInstanceImplCustom process);

}
