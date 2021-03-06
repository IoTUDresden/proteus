package eu.vicci.process.model.sofiainstance.states;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofiainstance.MappingUtil;

public interface StateChangable {
	/**
	 * Actions to perform on the process step deployment.
	 * @param mappingUtil
	 * @param parent
	 */
	void onDeploy(MappingUtil mappingUtil, ActorRef parent);
	
	/**
	 * Actions to perform on the process execution.
	 * @return
	 */
	boolean onExecute();
	
	/**
	 * Actions to perform to kill a process step.
	 */
	void onKill();
	
	/**
	 * Actions to perform to pause a process step.
	 */
	void onPause();
	
	/**
	 * Actions to perform to resume a process step.
	 */
	void onResume();
	
	/**
	 * Actions to perform to stop a process step.
	 */
	void onStop();
	
	/**
	 * Actions to perform to escalate a process step.
	 */
	void onEscalate();
	
	/**
	 * Actions to perform, after the process has been escalated
	 */
	void postEscalated();
	
	/**
	 * Actions to perform, after the state has changed to 'Executed'
	 */
	void postExecuted();
	
	/**
	 * Actions to perform, after the process current state is set to 'Deactivated' and all
	 * subprocess has finished their execution.
	 */
	void postDeactivated();
	
	/**
	 * Actions to perform, before the process current state is set to 'Deactivated'
	 */
	void preDeactivated();
	
	/**
	 * Actions to perform, before the process is reset.
	 */
	void preReset();
	
	/**
	 * After reset a process.
	 */
	void postReset();
	
	/**
	 * Changes the current state to a new one.
	 * Calls changeExecutionState(State).
	 * @param currentState
	 */
	void setCurrentState(StateBase currentState);
}
