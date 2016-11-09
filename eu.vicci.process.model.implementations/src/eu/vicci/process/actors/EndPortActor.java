package eu.vicci.process.actors;

import eu.vicci.process.messages.ActivatePortMessage;
import eu.vicci.process.messages.ChangePortExecutionStateMessage;
import eu.vicci.process.messages.CreateChildActorMessage;
import eu.vicci.process.messages.DeactivatePortMessage;
import eu.vicci.process.messages.SetPortDataTypeInstanceMessage;
import eu.vicci.process.model.sofiainstance.PortInstance;

public final class EndPortActor extends PortActorBase<PortInstance> {

	public EndPortActor(PortInstance endPortInstance) {
		super(endPortInstance);
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ActivatePortMessage)
			activate((ActivatePortMessage) message);
		else if (message instanceof CreateChildActorMessage)
			createChild((CreateChildActorMessage) message);
		else if (message instanceof DeactivatePortMessage)
			portInstance.deactivate();
		else if (message instanceof ChangePortExecutionStateMessage)
			portInstance.setExecutionState(((ChangePortExecutionStateMessage) message)
					.getNewExecutionState());
		else if (message instanceof SetPortDataTypeInstanceMessage)
			setDataTypeInstance((SetPortDataTypeInstanceMessage)message);
		else
			unhandled(message);
	}
}
