package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.HumanTaskRequest;
import eu.vicci.process.model.util.messages.core.HumanTaskRequestListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import ws.wamp.jawampa.PubSubData;

public class HumanTaskRequestSubscriber extends AbstractSubscriber<PubSubData, IHumanTaskRequest>{	
	
	public HumanTaskRequestSubscriber(HumanTaskRequestListener receiver) {
		super(receiver, TopicId.HUMAN_TASK_REQ);
	}

	@Override
	public void onNext(PubSubData t) {
		IHumanTaskRequest request = convertFromJson(t.arguments().get(0), HumanTaskRequest.class);
		receiver.onMessage(request);
	}

}
