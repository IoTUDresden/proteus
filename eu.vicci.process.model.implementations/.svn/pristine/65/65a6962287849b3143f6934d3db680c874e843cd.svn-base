package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class ActiveState extends StateBase {

	public ActiveState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public boolean execute() {
		if(!processStep.allStartPortsActive()){
			if(processStep.hasAnyDeactivatedAndRequiredStartPort()){				
				processStep.logInfo("Required startport(s) deactivated. Process is going to deactivate.");
				processStep.preDeactivated();
				setDeactivatedIfPossible();
				return false;
			}				
			processStep.logInfo("Process Step waiting on ports, can not be executed.");
			return false;
		}
		
		//TODO: complete denied
		switch (processStep.getPermission()) {
		case GRANTED:
			processStep.setCurrentState(new ExecutingState(processStep));
			return processStep.execute();
		case DENIED:
			return false;
		case DELAYED:
			processStep.executeDelay();
			return false;
		default:
			return false;
		}		
	}
	
	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		setDeactivatedIfPossible();		
	}

	@Override
	public State getSimpleState() {
		return State.ACTIVE;
	}
	
	private void setDeactivatedIfPossible(){
		if(processStep.allSubstepsHasFinishedExecution()){
			processStep.setCurrentState(new DeactivatedState(processStep));
			processStep.postDeactivated();
		}		
	}

}
