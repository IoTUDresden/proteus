package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.ForLoopInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.states.ProcessExecutedListener;

public class ForLoopInstanceImplCustom extends LoopInstanceImplCustomBase implements
		ForLoopInstance, ProcessExecutedListener {

	// left side is the counter and startvalue, right side is the max value
	private StartDataPortInstance loopStepWidth;
	private int stepWidth;
	private int startValue;
	private boolean resetRequested = false;

	@Override
	public void work() {
		if(!loopConditionInstance.evaluate()){
			changeEndPortStates(State.ACTIVE);
			return;			
		}
		
		startValue = ((IntegerTypeInstance) loopConditionInstance.getLeftSide().getDataInstance())
				.getValue();
		stepWidth = ((IntegerTypeInstance) loopStepWidth.getDataInstance()).getValue();

		checkArgs();
		doLoopStep();

		if (allSubstepsHasFinishedExecution() && allEndPortsHaveTheState(State.ACTIVE)
				&& !loopConditionInstance.evaluate())
			doingEndoperations();
	}

	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		if (allSubstepsHasFinishedExecution() && loopConditionInstance.evaluate()) {
			copyEndDataPortValuesToStartDataPorts();
			increaseCounter();
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

	private void increaseCounter() {
		startValue += stepWidth;
		loopConditionInstance.getLeftSide().getDataInstance().parse(Integer.toString(startValue));
	}

	@Override
	public StartDataPortInstance getLoopStepWidth() {
		return loopStepWidth;
	}

	@Override
	public void setLoopStepWidth(StartDataPortInstance loopStepWidth) {
		this.loopStepWidth = loopStepWidth;
	}

	protected void checkArgs() {
		if (stepWidth == 0)
			throw new IllegalArgumentException(
					"Error: StepWidth is 0. This will generate an infinite loop. No Action will be performed");
	}
}
