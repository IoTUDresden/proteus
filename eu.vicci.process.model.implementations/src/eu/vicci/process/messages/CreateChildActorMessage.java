package eu.vicci.process.messages;

import akka.actor.UntypedActor;
import akka.japi.Creator;

public final class CreateChildActorMessage {
	private final Creator<UntypedActor> childActorCreator;
	private final String actorName;
	
	public CreateChildActorMessage(Creator<UntypedActor> childActorCreator, String actorName) {
		this.childActorCreator = childActorCreator;
		this.actorName = actorName;
	}
	
	public Creator<UntypedActor> getChildActorFactory(){
		return childActorCreator;
	}
	
	public String getActorName(){
		return actorName;
	}
}
