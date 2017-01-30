package eu.vicci.process.actors;

import akka.actor.UntypedActor;
import akka.japi.Creator;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;

public final class StartControlPortActorFactory implements Creator<UntypedActor> {
	private static final long serialVersionUID = 1L;
	private final StartControlPortInstance portInstance;
	
	public StartControlPortActorFactory(StartControlPortInstance portInstance) {
		this.portInstance = portInstance;
	}

	@Override
	public StartControlPortActor create() throws Exception {
		return new StartControlPortActor(portInstance);
	}
}
