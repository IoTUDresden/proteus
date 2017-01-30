package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class WaitingState extends StateBase {

	public WaitingState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public State getSimpleState() {
		return State.WAITING;
	}
	
	@Override
	public void escalate() {
		processStep.onEscalate();
		processStep.setCurrentState(new EscalatedState(processStep));
		processStep.postEscalated();
	}

}
