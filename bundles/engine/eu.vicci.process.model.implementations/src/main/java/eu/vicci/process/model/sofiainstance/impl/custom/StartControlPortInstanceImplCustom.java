package eu.vicci.process.model.sofiainstance.impl.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.impl.StartControlPortInstanceImpl;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.sofiainstance.util.PortUtil;

/**
 * StartControlPortInstanceImplCustom is the customized implementation of the
 * instance (runtime) version of the model element StartControlPort. It does not
 * transmit any other information but the fact of being active or inactive.
 * 
 * @author Reik Mueller
 * 
 */
public class StartControlPortInstanceImplCustom extends StartControlPortInstanceImpl implements
		ActorAssignable {
	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private ActorRef actorReference = null;
	
	protected volatile State executionState = State.INACTIVE;

	/**
	 * Deploys the ProcessStep before execution.
	 * 
	 * By deploying ProcessSteps explicitly before executing them it becomes
	 * possible to validate the ProcessInstance. More over ProcessSteps that
	 * need some time for initializing (e.g. external devices) do so at a less
	 * critical point in time. Also the user has time for configuring the
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
		actorReference = LifeCycleManager.INSTANCE.createActorForStartControlPortSync(this, parent);
		PortUtil.deploy(this, mapper, actorReference);		
	}

	/**
	 * Activates the StartControlPort
	 * 
	 * By activating an StartControlPort the ProcessStep containing it gets
	 * signalized that a successor has finished working. If all StartPorts are
	 * active one criteria for executing the ProcessStep is fulfilled.
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
		executionState = State.ACTIVE;
		LifeCycleManager.INSTANCE.executeProcessStep(getProcessStepInstance());
		return true;
	}
	
	/**
	 * Deactivates this port and try´s to execute the process step.
	 */
	@Override
	public void deactivate() {
		if(!canProceed())
			return;
		executionState = State.DEACTIVATED;
		LifeCycleManager.INSTANCE.executeProcessStep(getProcessStepInstance());		
	}
	
	@Override
	public void deactivateSubSteps() {
		LOGGER.debug("{}: deactivate substeps", getPortType().getName());
		setInstanceId("StartControlPort " + getPortType().getName() + "_instance_"
				+ getInstancenumber());

		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.deactivateTransition(t);
	}

	/**
	 * Executes SubSteps of it's corresponding ProcessStep.
	 * 
	 * ProcessSteps themselves have no direct relations to other ProcessSteps
	 * but are connected via Ports and Transitions. Therefore StartPorts must
	 * not only activate their respective ProcessStep but also its SubSteps
	 * which are connected to them via Transitions. Due to the fact that only
	 * the corresponding ProcessStep can determine if the execution of SubSteps
	 * is valid, the method executeSubSteps() should be called by the
	 * ProcessStep (and only by this!) containing this StartPort.
	 */
	@Override
	public void executeSubSteps() {
		LOGGER.debug("{}: activate substeps", getPortType().getName());
		setInstanceId("StartControlPort " + getPortType().getName() + "_instance_"
				+ getInstancenumber());

		for (TransitionInstance t : getOutTransitionInstances())
			LifeCycleManager.INSTANCE.executeTransition(t);
	}

	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}
	
	@Override
	public void setExecutionState(State newExecutionState) {
		executionState = newExecutionState;
	}
	
	@Override
	public State getExecutionState() {
		return executionState;
	}
	
	/**
	 * Checks if the transition was already activated or deactivated
	 * @return true if the port can activate or deactivate
	 */
	private boolean canProceed(){
		return executionState == State.INACTIVE;
	}
}
