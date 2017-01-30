package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

/**
 * Receives informations about processes who have finished and the listener was attached to.
 */
public interface ProcessExecutedListener {
	/**
	 * Called, when a process step has executed or finished all operations (e.g. deactivated)
	 * @param process
	 */
	void processExecuted(ProcessStepInstanceImplCustom process);
}
