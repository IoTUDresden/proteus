package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class FailedState extends StateBase {

	public FailedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public State getSimpleState() {
		return State.FAILED;
	}

	@Override
	public boolean hasFinishedExecution() {
		return true;
	}
}
