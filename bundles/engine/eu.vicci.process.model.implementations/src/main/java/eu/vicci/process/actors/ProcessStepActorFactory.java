package eu.vicci.process.actors;

import akka.actor.UntypedActor;
import akka.japi.Creator;
import eu.vicci.process.model.sofiainstance.impl.custom.ProcessStepInstanceImplCustom;

public class ProcessStepActorFactory implements Creator<UntypedActor> {
	private static final long serialVersionUID = 1L;
	private final ProcessStepInstanceImplCustom instance;
	
	public ProcessStepActorFactory(ProcessStepInstanceImplCustom instance) {
		this.instance = instance;
	}
	
	@Override
	public ProcessStepActor create() throws Exception {
		return new ProcessStepActor(instance);
	}
}
