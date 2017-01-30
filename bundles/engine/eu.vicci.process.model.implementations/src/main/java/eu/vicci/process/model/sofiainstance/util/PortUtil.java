package eu.vicci.process.model.sofiainstance.util;

import akka.actor.ActorRef;
import eu.vicci.process.actors.ActorAssignable;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

/**
 * PortUtil is a workaround to handle complexity that normally is dealt with by
 * in inheritance. The usage of ecore makes it problematic to implement standard
 * behavior in parent classes because all generated classes need to be extended
 * to avoid problems with re-generation of code. PortUtil should only be used by
 * Ports.
 * 
 * @author Reik Mueller
 * 
 */
public class PortUtil {

	/**
	 * deploys ProcessSteps as an extra step before execution.
	 * 
	 * By deploying ProcessSteps explicitly before executing them it becomes
	 * possible to validate the ProcessInstance. More over ProcessSteps that
	 * need some time for initializing (e.g. external devices) do so at an
	 * uncritical point. Also the user has time for configuring the
	 * ProcessInstance according to his/her wishes. For every method the
	 * PortInstance needs to be committed so PortUtil can work on it.
	 * 
	 * @param pi
	 *            The PortInstance that shall be deployed
	 * @param mapper
	 *            MappingUtil is needed for the deployment process (e.g. to
	 *            avoid unwanted duplicates)
	 */
	public static void deploy(PortInstance pi, MappingUtil mapper) {
		deploy(pi, mapper, null);
	}
	
	public static void deploy(PortInstance pi, MappingUtil mapper, ActorRef parent){
		if (pi.getProcessStepInstance() == null)
			pi.setProcessStepInstance(mapper.mapProcessStep(pi.getPortType().getProcessStep()));		

		if (pi.getPortType().getOutTransitions() != null) {
			for (Transition transition : pi.getPortType().getOutTransitions()) {
				TransitionInstance ti = mapper.mapTransition(transition);
				pi.getOutTransitionInstances().add(ti);
				((ActorAssignable)ti).deploy(mapper, parent);
			}
		}		
	}
}
