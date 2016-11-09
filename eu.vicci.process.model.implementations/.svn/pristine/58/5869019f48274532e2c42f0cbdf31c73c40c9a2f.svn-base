package eu.vicci.process.actors;

import akka.actor.UntypedActor;
import akka.japi.Creator;
import eu.vicci.process.model.sofiainstance.PortInstance;

public final class EndPortActorFactory implements Creator<UntypedActor> {
	private static final long serialVersionUID = 1L;
	private final PortInstance portInstance;
	
	public EndPortActorFactory(PortInstance portInstance) {
		this.portInstance = portInstance;
	}

	@Override
	public EndPortActor create() throws Exception {
		return new EndPortActor(portInstance);
	}
}
