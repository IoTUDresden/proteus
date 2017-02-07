package eu.vicci.process.model.sofiainstance.states;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

/**
 * Base Class for the process step states. The State pattern provides the
 * statemachine for the ProcessStepImplCustomBase Class.
 */
public abstract class StateBase {
	/**
	 * Underlying process step.
	 */
	protected final ProcessStepInstanceImplCustomBase processStep;

	public StateBase(ProcessStepInstanceImplCustomBase processStep) {
		this.processStep = processStep;
	}

	/**
	 * Deployes the ProcessStep if it is undeployed and sets its state to
	 * inactive.
	 * 
	 * @param mappingUtil
	 */
	public void deploy(MappingUtil mappingUtil, ActorRef parent) {
		printMessage("Can´t deploy");
	}

	/**
	 * Executes the process step and sets its state t o active, if not all
	 * startports are active or to executing, if all startports are active.
	 * 
	 * @return
	 */
	public boolean execute() {
		printMessage("Can´t execute");
		return false;
	}

	/**
	 * Kills a process step and sets its state to killed.
	 */
	public void kill() {
		printMessage("Can´t kill");
	}

	/**
	 * Pauses a process step and sets its state to paused.
	 */
	public void pause() {
		printMessage("Can´t pause");
	}

	/**
	 * Resumes a process step and sets its state to the state before paused.
	 */
	public void resume() {
		printMessage("Can´t resume");
	}

	/**
	 * Stops a process step
	 */
	public void stop() {
		printMessage("Can´t stop");
	}

	/**
	 * Working Method
	 */
	public void work() {
		printMessage("Can´t work");
	}
	
	public void escalate(){
		printMessage("Can't escalate");
	}

	/**
	 * Informs this process that a sub process or a other process, which has the
	 * current process registered as a listener, has finished execution
	 * 
	 * @param process
	 */
	public void processExecuted(ProcessStepInstanceImplCustom process) {
		printMessage("Subprocess has been executed");
	}
	
	public void processReset(ProcessStepInstanceImplCustom process){
		printMessage("Subprocess has been reset");
	}

	/**
	 * Gets the information, whether the process step is finished or has to do
	 * more operations.
	 * 
	 * @return true, if the process step is stopped/failed/killed/stopped/escalated
	 */
	public boolean hasFinishedExecution() {
		return false;
	}

	/**
	 * Resets the process state and the states from all substeps
	 */
	public void reset() {
		printMessage("Can´t restart");
	}
	
	public void portExecutionStateChanged(PortInstance port){
		printMessage("Port execution State have changed");
	}

	/**
	 * Return the simple enum state of this state
	 * 
	 * @return
	 */
	public abstract State getSimpleState();
	
	private void printMessage(String info) {
		processStep.logInfo("{}: State: {}: {}", processStep.getProcessStepType().getName(),
				getClass().getSimpleName(), info);
	}
}
