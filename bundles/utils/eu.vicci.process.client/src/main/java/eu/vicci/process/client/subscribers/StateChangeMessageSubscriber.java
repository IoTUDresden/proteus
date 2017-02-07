package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.StateChangeMessage;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;
import ws.wamp.jawampa.PubSubData;

public class StateChangeMessageSubscriber extends AbstractSubscriber<PubSubData, IStateChangeMessage> {

	public StateChangeMessageSubscriber(StateChangeListener listener) {
		super(listener, TopicId.STATE_CHANGE);
	}	

	@Override
	public void onNext(PubSubData t) {
		receiver.onMessage(convertFromJson(t.arguments().get(0), StateChangeMessage.class));		
	}

}
