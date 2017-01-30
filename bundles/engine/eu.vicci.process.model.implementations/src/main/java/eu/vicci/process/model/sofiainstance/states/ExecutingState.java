package eu.vicci.process.model.sofiainstance.states;

import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class ExecutingState extends StateBase {
	private boolean allreadyExecuted = false;
	private boolean executionSuccess = false;
	private boolean endoperationsCalled = false;

	public ExecutingState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public boolean execute() {
		if (allreadyExecuted)
			return executionSuccess;

		allreadyExecuted = true;
		try {
			executionSuccess = processStep.onExecute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (executionSuccess && processStep.allSubstepsHasFinishedExecution())
			if(processStep.allEndPortsAreDeactivatedOrActivated())
				setExecuted();
			else{
				processStep.doingEndoperations();
				endoperationsCalled = true;
			}
		else if (!executionSuccess)
			processStep.setCurrentState(new FailedState(processStep));

		return executionSuccess;
	}

	@Override
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		setExecutedOrDoingEndoperations();
	}
	
	@Override
	public void portExecutionStateChanged(PortInstance port) {
		setExecutedOrDoingEndoperations();
	}

	@Override
	public State getSimpleState() {
		return State.EXECUTING;
	}
	
	@Override
	public void escalate() {
		processStep.onEscalate();
		processStep.setCurrentState(new EscalatedState(processStep));
		processStep.postEscalated();
	}

	private void setExecuted() {
//		processStep.doingEndoperations();
		processStep.setCurrentState(new ExecutedState(processStep));
		processStep.postExecuted();
	}

	private boolean isAllFinished() {
		return processStep.allSubstepsHasFinishedExecution()
				&& processStep.allEndPortsAreDeactivatedOrActivated();
	}
	
	private void setExecutedOrDoingEndoperations(){
		if(isAllFinished())
			setExecuted();
		else if (!endoperationsCalled && processStep.allSubstepsHasFinishedExecution()){
			processStep.doingEndoperations();
			endoperationsCalled = true;
		}		
	}
}
