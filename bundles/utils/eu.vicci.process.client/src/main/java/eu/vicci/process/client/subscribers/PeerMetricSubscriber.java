package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.PeerMetrics;
import ws.wamp.jawampa.PubSubData;

public class PeerMetricSubscriber extends AbstractSubscriber<PubSubData, PeerMetrics> {

	public PeerMetricSubscriber(IMessageReceiver<PeerMetrics> receiver) {
		super(receiver, TopicId.PEER_METRICS);
	}

	@Override
	public void onNext(PubSubData arg0) {
		receiver.onMessage(convertFromJson(arg0.arguments().get(0), PeerMetrics.class));		
	}

}
