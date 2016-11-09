package eu.vicci.process.actors;

import scala.concurrent.Future;
import akka.dispatch.Futures;
import akka.pattern.Patterns;
import eu.vicci.process.messages.ActivatePortMessage;
import eu.vicci.process.messages.SetPortDataTypeInstanceMessage;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;

public abstract class PortActorBase<T extends PortInstance> extends ActorBase {
	protected final T portInstance;
	
	public PortActorBase(T portInstance) {
		this.portInstance = portInstance;
	}
	
	protected void setDataTypeInstance(SetPortDataTypeInstanceMessage message) {
//		if(!(portInstance instanceof DataPortInstance)){
//			unhandled(message);
//			return;
//		}		
		DataPortInstance port = (DataPortInstance) portInstance;
		port.setDataInstance(message.getDataTypeInstance());
		Future<Boolean> future = Futures.successful(true);
		Patterns.pipe(future, context().dispatcher()).to(getSender(), getSelf());
	}
	
	protected void activate(ActivatePortMessage message){
		if(message.isBlockingCall())
			activateSync(message);
		else
			portInstance.activate(message.getParameter());
	}
	
	private void activateSync(ActivatePortMessage message){
		portInstance.activate(message.getParameter());
		Future<Boolean> future = Futures.successful(true);
		Patterns.pipe(future, context().dispatcher()).to(getSender(), getSelf());		
	}
}
