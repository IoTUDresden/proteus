package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class InactiveState extends StateBase {
	
	public InactiveState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public boolean execute() {
		processStep.setCurrentState(new ActiveState(processStep));
		return processStep.execute();
	}

	@Override
	public void kill() {
		processStep.setCurrentState(new KilledState(processStep));
	}

	@Override
	public State getSimpleState() {
		return State.INACTIVE;
	}
}
