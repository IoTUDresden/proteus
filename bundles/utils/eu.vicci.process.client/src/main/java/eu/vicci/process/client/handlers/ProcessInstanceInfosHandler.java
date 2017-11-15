package eu.vicci.process.client.handlers;

import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.impl.SofiaInstanceFactoryImpl;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONProcessStepInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;
import ws.wamp.jawampa.Reply;

public class ProcessInstanceInfosHandler extends AbstractClientHandler {
	private static final SofiaInstanceFactory FACTORY = SofiaInstanceFactoryImpl.eINSTANCE;
	private ProcessInstance processInstance;

	@Override
	public void onNext(Reply t) {
		IJSONProcessStepInstance processInstanceInfos = convertFromJson(t.arguments().get(0), JSONProcessStepInstance.class);
		processInstance = (ProcessInstance) processInstanceInfos.makeProcessStepInstance(FACTORY);
	}

	@Override
	public void onCompleted() {
		state = ReplyState.SUCCESS;
		super.onCompleted();
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}
}
