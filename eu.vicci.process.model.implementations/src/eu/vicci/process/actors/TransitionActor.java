package eu.vicci.process.actors;

import scala.concurrent.Future;
import akka.dispatch.Futures;
import akka.pattern.Patterns;
import eu.vicci.process.messages.CreateChildActorMessage;
import eu.vicci.process.messages.DeactivateTransitionMessage;
import eu.vicci.process.messages.ExecuteTransitionMessage;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

public final class TransitionActor extends ActorBase {
	private final TransitionInstance transitionInstance;

	public TransitionActor(TransitionInstance transitionInstance) {
		this.transitionInstance = transitionInstance;
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ExecuteTransitionMessage)
			execute((ExecuteTransitionMessage) message);
		else if (message instanceof CreateChildActorMessage)
			createChild((CreateChildActorMessage)message);
		else if (message instanceof DeactivateTransitionMessage)
			transitionInstance.deactivate();
		else
			unhandled(message);
	}
	
	private void execute(ExecuteTransitionMessage message){
		if(message.isBlockingCall())
			executeSync(message);
		else
			transitionInstance.execute(message.getParameter());
	}

	private void executeSync(ExecuteTransitionMessage message) {
		transitionInstance.execute(message.getParameter());
		Future<Boolean> future = Futures.successful(true);
		Patterns.pipe(future, context().dispatcher()).to(getSender(), getSelf());		
	}
}
