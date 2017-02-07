package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class DeactivatedState extends StateBase {

	public DeactivatedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}
	
	@Override
	public boolean hasFinishedExecution() {
		return true;
	}
	
	@Override
	public void reset() {
		processStep.preReset();
		setInactiveIfPossible();
	}
	
	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		if (processStep.allSubstepsHasFinishedExecution())
			processStep.postDeactivated();
	}

	@Override
	public State getSimpleState() {
		return State.DEACTIVATED;
	}
	
	private void setInactiveIfPossible(){
		if(processStep.allSubstepsAreReset()){
			processStep.setCurrentState(new InactiveState(processStep));
			processStep.postReset();			
		}			
	}
}
