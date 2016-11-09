package eu.vicci.process.actors;

import scala.concurrent.Future;
import akka.actor.ActorRef;
import akka.util.Timeout;
import eu.vicci.process.messages.CreateChildActorMessage;

/**
 * Interface for the Master Actor(Typed) for the process execution system.
 */
public interface IProcessExecutionMasterActor {
	
	/**
	 * Sends a message to the receiver. The sender will be this process execution master.
	 * Async Call.
	 * @param receiver
	 * @param message
	 */
	void sendSimpleMessage(ActorRef receiver, Object message);	
	
	/**
	 * Creates a child Actor and return its reference. If the parent is null, the child is applied 
	 * to the ExecutionMasterActor. Blocking Call.
	 * @param parent
	 * @param message
	 * @return
	 */
	ActorRef createChildActor(ActorRef parent, CreateChildActorMessage message);
	
	/**
	 * Sends a message and receives a future. It can than be used to wait for a result and block
	 * the execution if needed (e.g. synchronus calls)
	 * @param receiver
	 * @param message
	 * @param timeout
	 * @return
	 */
	Future<Object> sendMessageAndReceiveFuture(ActorRef receiver, Object message, Timeout timeout);
}
