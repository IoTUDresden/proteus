package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.PortInstance;

public interface PortExecutionStateChangedListener {
	/**
	 * Called when a port has changed his execution state
	 * @param port
	 */
	void portExecutionStateChanged(PortInstance port);

}
