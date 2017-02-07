package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.State;

public final class ChangePortExecutionStateMessage {	
	private State newExecutionState;

	public ChangePortExecutionStateMessage(State newExecutionState) {
		this.newExecutionState = newExecutionState;
	}

	public State getNewExecutionState() {
		return newExecutionState;
	}
}
