package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.WhileLoopInstance;

public class WhileLoopInstanceImplCustom extends LoopInstanceImplCustomBase implements WhileLoopInstance {

	@Override
	public void work() {
		if(!loopConditionInstance.evaluate()){
			changeEndPortStates(State.INACTIVE);
			return;
		}
		
		checkArgs();
		doLoopStep();			
	}
	
	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		if (allSubstepsHasFinishedExecution() && loopConditionInstance.evaluate()) {
			copyEndDataPortValuesToStartDataPorts();
			if (loopConditionInstance.evaluate()) {
				resetAllSubsteps();
			} else {
				changeEndPortStates(State.INACTIVE);
				super.processExecuted(process);
			}
		} else if (allSubstepsHasFinishedExecution() && !loopConditionInstance.evaluate()) {
			changeEndPortStates(State.INACTIVE);
			super.processExecuted(process);
		}
	}

	@Override
	public void processReset(ProcessStepInstanceImplCustom process) {
		if (resetRequested) {
			super.processReset(process);
			return;
		}
		performNextStepIfPossible();
	}

	
	protected void checkArgs() {
	}
}
