package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class KilledState extends StateBase {

	public KilledState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public State getSimpleState() {
		return State.KILLED;
	}

	@Override
	public boolean hasFinishedExecution() {
		return true;
	}
}
