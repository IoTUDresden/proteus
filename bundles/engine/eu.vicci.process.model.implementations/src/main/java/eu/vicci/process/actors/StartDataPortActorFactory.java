package eu.vicci.process.actors;

import akka.actor.UntypedActor;
import akka.japi.Creator;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;

public final class StartDataPortActorFactory implements Creator<UntypedActor> {
	private static final long serialVersionUID = 1L;
	private final StartDataPortInstance portInstance;
	
	public StartDataPortActorFactory(StartDataPortInstance portInstance) {
		this.portInstance = portInstance;
	}

	@Override
	public StartDataPortActor create() throws Exception {
		return new StartDataPortActor(portInstance);
	}
}
