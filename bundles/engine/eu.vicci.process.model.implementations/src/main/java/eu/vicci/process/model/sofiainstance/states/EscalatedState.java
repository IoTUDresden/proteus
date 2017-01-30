package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class EscalatedState extends StateBase {

	public EscalatedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public State getSimpleState() {
		return State.ESCALATED;
	}
	
	@Override
	public boolean hasFinishedExecution() {
		return true;
	}

}
