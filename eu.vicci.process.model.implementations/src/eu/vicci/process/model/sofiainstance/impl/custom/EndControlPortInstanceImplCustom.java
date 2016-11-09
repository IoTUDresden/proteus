package eu.vicci.process.model.sofiainstance.impl.custom;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.impl.EndControlPortInstanceImpl;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateChangedListener;
import eu.vicci.process.model.sofiainstance.states.PortExecutionStateListenable;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.PortUtil;

/**
 * EndControlPortInstanceImplCustom is the customized implementation of the
 * instance (runtime) version of the model element EndControlPort. It does not
 * transmit any information but only executes its outgoing transitions.
 * 
 * @author Reik Mueller
 * 
 */
public class EndControlPortInstanceImplCustom extends EndControlPortInstanceImpl implements ActorAssignable, PortExecutionStateListenable {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private final List<PortExecutionStateChangedListener> listeners = new ArrayList<>();
	private ActorRef actorReference = null;
	
	//Override the existing execution state
	protected volatile State executionState = State.INACTIVE;

	/**
	 * Deploys the EndControlPort before execution.
	 * 
	 * By deploying components of a process explicitly before executing them it
	 * becomes possible to validate the ProcessInstance. More over ProcessSteps
	 * that need some time for initializing (e.g. external devices) do so at a
	 * less critical point in time. Also the user has time for configuring the
	 * ProcessInstance according to his/her wishes.
	 * 
	 * @param mapper
	 *            MappingUtil is needed for the deployment process (e.g. to
	 *            avoid unwanted duplicates)
	 */
	@Override
	public void deploy(MappingUtil mapper) {
		deploy(mapper, null);
	}
	
	@Override
	public void deploy(MappingUtil mapper, ActorRef parent) {
		actorReference = LifeCycleManager.INSTANCE.createActorForEndPortSync(this, parent);
		PortUtil.deploy(this, mapper, actorReference);
	}

	/**
	 * Activates the EndControlPort
	 * 
	 * By activating an EndControlPort all outgoing Transition will be executed.
	 * 
	 * @param parameter
	 *            In case of an ControlPort the parameter will be empty or null
	 *            because Transitions that are only needed to control the
	 *            execution order do not transport any information but the fact
	 *            that they are activated.
	 */
	@Override
	public boolean activate(DataTypeInstance parameter) {
		if(!canProceed())
			return true;
		performActivate(parameter);
		return true;
	}
	
	/**
	 * Deactivates this port and all outgoing transitions.
	 */
	@Override
	public void deactivate() {
		if(!canProceed())
			return;
		setExecutionState(State.DEACTIVATED);
		LOGGER.debug("{}: deactivate", getPortType().getName());
		setInstanceId("EndControlPort " + getPortType().getName() + "_instance_" + getInstancenumber());
		for(TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.deactivateTransition(t);
	}

	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}
	
	@Override
	public void setExecutionState(State newExecutionState) {
		executionState = newExecutionState;
		informListeners();
	}
	
	@Override
	public State getExecutionState() {
		return executionState;
	}

	/**
	 * Checks if the transition was already activated or deactivated.
	 * @return true if the port can activate or deactivate
	 */
	private boolean canProceed(){
		return executionState == State.INACTIVE;
	}
	
	private boolean performActivate(DataTypeInstance parameter){
		LOGGER.debug("{}: activate", getPortType().getName());
		setInstanceId("EndControlPort " + getPortType().getName() + "_instance_" + getInstancenumber());
		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.executeTransitionSync(t);
		
		setExecutionState(State.ACTIVE);
		return true;		
	}
	
	@Override
	public void addPortExecutionStateChangedListener(PortExecutionStateChangedListener listener) {
		listeners.add(listener);	
	}
	
	private void informListeners() {
		for (PortExecutionStateChangedListener listener : listeners)
			LifeCycleManager.INSTANCE.portExecutionStateChanged(listener, this);		
	}
}
