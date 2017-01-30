package eu.vicci.process.model.sofiainstance.states;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustomBase;

public class UndeployedState extends StateBase {

	public UndeployedState(ProcessStepInstanceImplCustomBase processStep) {
		super(processStep);
	}

	@Override
	public void deploy(MappingUtil mappingUtil, ActorRef parent) {
		processStep.onDeploy(mappingUtil, parent);
		processStep.setCurrentState(new InactiveState(processStep));		
	}

	@Override
	public void kill() {
		processStep.setCurrentState(new KilledState(processStep));
	}

	@Override
	public void stop() {
		processStep.setCurrentState(new StoppedState(processStep));
	}

	@Override
	public State getSimpleState() {
		return State.UNDEPLOYED;
	}

}
