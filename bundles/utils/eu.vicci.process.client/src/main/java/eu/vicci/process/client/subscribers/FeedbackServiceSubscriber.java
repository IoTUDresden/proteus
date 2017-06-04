package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.CompensationRequest;
import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import ws.wamp.jawampa.PubSubData;

public class FeedbackServiceSubscriber extends AbstractSubscriber<PubSubData, CompensationRequest> {

	public FeedbackServiceSubscriber(IMessageReceiver<CompensationRequest> receiver) {
		super(receiver, TopicId.FEEDBACK_COMPENSATION);
	}

	@Override
	public void onNext(PubSubData arg0) {
		receiver.onMessage(convertFromJson(arg0, CompensationRequest.class));		
	}

}
