package eu.vicci.process.actors;

import eu.vicci.process.messages.CreateChildActorMessage;
import eu.vicci.process.messages.DeactivateProcessStepMessage;
import eu.vicci.process.messages.ExecuteProcessStepMessage;
import eu.vicci.process.messages.KillProcessStepMessage;
import eu.vicci.process.messages.PauseProcessStepMessage;
import eu.vicci.process.messages.PortExecutionStateChangedMessage;
import eu.vicci.process.messages.ProcessExecutedMessage;
import eu.vicci.process.messages.ProcessResetMessage;
import eu.vicci.process.messages.ResetProcessMessage;
import eu.vicci.process.messages.ResumeProcessStepMessage;
import eu.vicci.process.messages.StopProcessStepMessage;
import eu.vicci.process.messages.EscalateProcessStepMessage;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

public final class ProcessStepActor extends ActorBase {
	private final ProcessStepInstanceImplCustom processStepInstance;

	public ProcessStepActor(ProcessStepInstanceImplCustom processStepInstance) {
		this.processStepInstance = processStepInstance;
	}

	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ExecuteProcessStepMessage)
			processStepInstance.execute();
		else if (message instanceof CreateChildActorMessage)
			createChild((CreateChildActorMessage) message);
		else if (message instanceof ProcessExecutedMessage)
			processStepInstance.processExecuted(((ProcessExecutedMessage) message)
					.getProcessStepInstance());
		else if (message instanceof DeactivateProcessStepMessage)
			processStepInstance.deactivate();
		else if (message instanceof StopProcessStepMessage)
			processStepInstance.stop();
		else if (message instanceof KillProcessStepMessage)
			processStepInstance.kill();
		else if (message instanceof PauseProcessStepMessage)
			processStepInstance.pause();
		else if (message instanceof ResumeProcessStepMessage)
			processStepInstance.resume();
		else if (message instanceof ResetProcessMessage)
			processStepInstance.reset();
		else if (message instanceof ProcessResetMessage)
			processStepInstance.processReset(((ProcessResetMessage) message).getResetProcess());
		else if (message instanceof PortExecutionStateChangedMessage)
			processStepInstance
					.portExecutionStateChanged(((PortExecutionStateChangedMessage) message)
							.getPort());
		else if(message instanceof EscalateProcessStepMessage)
			processStepInstance.escalate();
		else
			unhandled(message);
	}
}
