package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.HumanTaskResponse;
import eu.vicci.process.model.util.messages.core.HumanTaskResponseListener;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;
import ws.wamp.jawampa.PubSubData;

public class HumanTaskResponseSubscriber extends AbstractSubscriber<PubSubData, IHumanTaskResponse> {	
	
	public HumanTaskResponseSubscriber(HumanTaskResponseListener receiver) {
		super(receiver, TopicId.HUMAN_TASK_RESP);
	}	

	@Override
	public void onNext(PubSubData t) {
		HumanTaskResponse response = convertFromJson(t.arguments().get(0), HumanTaskResponse.class);
		receiver.onMessage(response);		
	}
}
