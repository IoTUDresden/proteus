package eu.vicci.process.model.sofiainstance.impl.custom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;

/**
 * TransitionInstanceImplCustom is the custom implementation of
 * TransitionInstance (the runtime variant of the Transition, which is only used
 * for modeling). The class extends the automatically generated class
 * TransitionInstanceImpl.
 * 
 * @author Reik Mueller
 * 
 */
public class TransitionInstanceImplCustom extends TransitionInstanceImpl implements ActorAssignable {	
	private final Logger LOGGER = LoggerFactory.getLogger(getClass().getSimpleName());
	private ActorRef actorReference = null;

	/**
	 * In this context deploying means to create the instance version of the
	 * target port.
	 * 
	 * @param mapper
	 *            MappingUtil is needed to perform the mapping process
	 */
	@Override
	public void deploy(MappingUtil mapper) {
		deploy(mapper, null);
	}
	
	@Override
	public void deploy(MappingUtil mapper, ActorRef parent) {
		actorReference = LifeCycleManager.INSTANCE.createActorForTransitionSync(this, parent);
		if (getTransitionType().getTargetPort() == null)
			return;
		
		setTargetPortInstance(mapper.mapPort(getTransitionType().getTargetPort()));
		ActorAssignable targetPort = (ActorAssignable)getTargetPortInstance();
		targetPort.deploy(mapper, parent);
	}
	
	/**
	 * Deactivates the target port from this transition
	 */
	@Override
	public void deactivate() {
		LOGGER.debug("{}: deactivate", getTransitionType().getName());
		if (getTransitionType().getTargetPort() != null)
			LifeCycleManager.INSTANCE.deactivatePort(getTargetPortInstance());
		else 
			LOGGER.error("{} has no endport!", getTransitionType().getName());
	}

	/**
	 * Executes the Transition which basically means to activate the target port
	 * and passing parameters.
	 * 
	 * @param parameter
	 *            A String containing an XML document that consists all
	 *            parameters
	 */
	@Override
	public boolean execute(DataTypeInstance parameter) {		
		LOGGER.debug("{}: execute", getTransitionType().getName());
		
		if (getTransitionType().getTargetPort() != null)
			LifeCycleManager.INSTANCE.activatePortSync(getTargetPortInstance(), parameter);
		else 
			LOGGER.error("{} has no endport!", getTransitionType().getName());
		
		return true;
	}

	@Override
	public ActorRef getActorReference() {
		return actorReference;
	}
}
