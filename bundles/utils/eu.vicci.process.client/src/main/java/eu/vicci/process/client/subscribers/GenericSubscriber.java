package eu.vicci.process.client.subscribers;

import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.IWampMessage;
import ws.wamp.jawampa.PubSubData;

public class GenericSubscriber<T extends IWampMessage> extends AbstractSubscriber<PubSubData, T> {
	private Class<T> paramClass;

	public GenericSubscriber(IMessageReceiver<T> receiver, String topicId, Class<T> paramClass) {
		super(receiver, topicId);
		this.paramClass = paramClass;
	}

	@Override
	public void onNext(PubSubData arg0) {
		receiver.onMessage(convertFromJson(arg0.arguments().get(0), paramClass));				
	}

}
