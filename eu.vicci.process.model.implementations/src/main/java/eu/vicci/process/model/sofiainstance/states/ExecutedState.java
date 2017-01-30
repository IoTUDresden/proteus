package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class ExecutedState extends StateBase {

	public ExecutedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public boolean execute() {		
		return false;
	}
	
	@Override
	public void reset() {
		processStep.preReset();
		setInactiveIfPossible();
	}
	
	@Override
	public void processReset(ProcessStepInstanceImplCustom process) {
		setInactiveIfPossible();		
	}

	@Override
	public State getSimpleState() {
		return State.EXECUTED;
	}

	@Override
	public boolean hasFinishedExecution() {
		return true;
	}
	
	private void setInactiveIfPossible(){
		if(processStep.allSubstepsAreReset()){
			processStep.setCurrentState(new InactiveState(processStep));
			processStep.postReset();			
		}			
	}
}
