package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class PausedState extends StateBase {

	public PausedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public void kill() {
		processStep.setCurrentState(new KilledState(processStep));
	}

	@Override
	public void resume() {
		processStep.onResume();
	}

	@Override
	public void stop() {
		processStep.setCurrentState(new StoppedState(processStep));
	}

	@Override
	public State getSimpleState() {
		return State.PAUSED;
	}
}
