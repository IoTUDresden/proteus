package eu.vicci.process.client.subscribers;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;
import eu.vicci.process.model.util.ProcessInfo;
import eu.vicci.process.model.util.ProcessInstanceInfo;
import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.ProcessEngineUpdate;
import eu.vicci.process.model.util.messages.core.IProcessEngineUpdate;
import eu.vicci.process.model.util.messages.core.ProcessEngineListener;
import ws.wamp.jawampa.PubSubData;

public class EngineUpdateSubscriber extends AbstractSubscriber<PubSubData, IProcessEngineUpdate> {
	private ProcessEngineListener engineListener;

	public EngineUpdateSubscriber(ProcessEngineListener engineListener) {
		super(null, TopicId.ENGINE_UPDATE); // we dont need the internal engine
											// listener so we just pass null
		this.engineListener = engineListener;
	}

	@Override
	public void onNext(PubSubData arg0) {
		IProcessEngineUpdate update = convertFromJson(arg0.arguments().get(0), ProcessEngineUpdate.class);
		processUpdate(update);
	}

	private void processUpdate(IProcessEngineUpdate update) {
		if (update == null)
			return;
		switch (update.getUpdateType()) {
		case PROCESS_DEPLOYED:
			processDeployed(update);
			break;
		case INSTANCE_DEPLOYED:
			instanceDeployed(update);
			break;
		default:
			break;
		}
	}

	private void processDeployed(IProcessEngineUpdate update) {
		IProcessInfo info = update.getTypedPayload(ProcessInfo.class);
		if (info != null)
			engineListener.onProcessDeployed(info);
	}

	private void instanceDeployed(IProcessEngineUpdate update) {
		IProcessInstanceInfo info = update.getTypedPayload(ProcessInstanceInfo.class);
		if (info != null)
			engineListener.onProcessInstanceDeployed(info);
	}

}
