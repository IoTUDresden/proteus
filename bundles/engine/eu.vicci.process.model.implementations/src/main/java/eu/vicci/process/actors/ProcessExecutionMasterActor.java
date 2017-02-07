package eu.vicci.process.actors;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.TypedActor;
import akka.actor.TypedProps;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.pattern.Patterns;
import akka.util.Timeout;
import eu.vicci.process.messages.CreateChildActorMessage;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

/**
 * Implementation for the Master Actor(Typed) for the process execution system.
 */
public final class ProcessExecutionMasterActor implements IProcessExecutionMasterActor {
	private final static int DEFAULT_TIMEOUT = 5;
	LoggingAdapter logging;

	public ProcessExecutionMasterActor() {
		logging = Logging.getLogger(TypedActor.context().system(), this);
	}
	
	@Override
	public void sendSimpleMessage(ActorRef receiver, Object message){
		receiver.tell(message, TypedActor.context().self());
	}

	@Override
	public ActorRef createChildActor(ActorRef parent, CreateChildActorMessage message) {
		if (parent == null)
			return getActorRefWithoutParent(message);
		
		Timeout timeout = new Timeout(Duration.create(DEFAULT_TIMEOUT, TimeUnit.SECONDS));
		Future<Object> result = Patterns.ask(parent, message, timeout);

		try {
			// child of the parent actor
			return (ActorRef) Await.result(result, timeout.duration());
		} catch (Exception e) {
			e.printStackTrace();
			return getActorRefWithoutParent(message);
		}
	}

	@Override
	public Future<Object> sendMessageAndReceiveFuture(ActorRef receiver, Object message, Timeout timeout) {
		Future<Object> result = Patterns.ask(receiver, message, timeout);		
		return result;
	}

	/**
	 * Creates a execution master actor
	 * @param system
	 * @param name
	 * @return
	 */
	public static IProcessExecutionMasterActor create(ActorSystem system, String name) {
		IProcessExecutionMasterActor actor = TypedActor.get(system).typedActorOf(
				new TypedProps<ProcessExecutionMasterActor>(IProcessExecutionMasterActor.class,
						ProcessExecutionMasterActor.class), name);
		return actor;
	}
	
	private static ActorRef getActorRefWithoutParent(CreateChildActorMessage message){
		Props props = Props.create(message.getChildActorFactory());
		if(message.getActorName() == null)
			return TypedActor.context().actorOf(props);
		return TypedActor.context().actorOf(props, message.getActorName());		
	}
}
