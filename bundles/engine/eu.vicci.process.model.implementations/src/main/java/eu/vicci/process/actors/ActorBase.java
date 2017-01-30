package eu.vicci.process.actors;

import scala.concurrent.Future;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.dispatch.Futures;
import akka.pattern.Patterns;
import eu.vicci.process.messages.CreateChildActorMessage;

public abstract class ActorBase extends UntypedActor {
	
	/**
	 * Creates a child actor and sends the ActorRef back to the parent.
	 * This is necessary for optimal supervising.
	 * @param message
	 */
	protected void createChild(CreateChildActorMessage message) {	
		Props props = Props.create(message.getChildActorFactory());
		
		ActorRef child;		
		if(message.getActorName() == null)
			child = context().actorOf(props);
		else
			child = context().actorOf(props, message.getActorName());			
		
		Future<ActorRef> future = Futures.successful(child);
		Patterns.pipe(future, context().dispatcher()).to(getSender(), getSelf());
	}
}
