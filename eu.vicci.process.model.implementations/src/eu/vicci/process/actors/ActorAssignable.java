package eu.vicci.process.actors;

import akka.actor.ActorRef;
import eu.vicci.process.model.sofiainstance.MappingUtil;

public interface ActorAssignable {
	
	void deploy(MappingUtil mapper, ActorRef parent);
	
	ActorRef getActorReference();
}
