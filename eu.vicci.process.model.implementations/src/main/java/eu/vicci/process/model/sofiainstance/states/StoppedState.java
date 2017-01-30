package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class StoppedState extends StateBase {

	public StoppedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public State getSimpleState() {
		return State.STOPPED;
	}

	@Override
	public boolean hasFinishedExecution() {
		return true;
	}

}
