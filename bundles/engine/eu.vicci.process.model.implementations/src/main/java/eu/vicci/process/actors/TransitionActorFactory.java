package eu.vicci.process.actors;

import akka.actor.UntypedActor;
import akka.japi.Creator;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

public final class TransitionActorFactory implements Creator<UntypedActor> {
	private static final long serialVersionUID = 1L;
	private final TransitionInstance transitionInstance;
	
	public TransitionActorFactory(TransitionInstance transitionInstance) {
		this.transitionInstance = transitionInstance;
	}	

	@Override
	public TransitionActor create() throws Exception {
		return new TransitionActor(transitionInstance);
	}

}
