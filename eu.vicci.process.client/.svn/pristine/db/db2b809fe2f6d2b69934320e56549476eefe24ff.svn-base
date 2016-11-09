package eu.vicci.process.client.subscribers;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.util.messages.core.IMessageReceiver;
import eu.vicci.process.model.util.messages.core.IWampMessage;
import rx.Subscriber;
import ws.wamp.jawampa.PubSubData;

public abstract class AbstractSubscriber<K extends PubSubData, S extends IWampMessage> extends Subscriber<K>{
	private static final Logger logger = LoggerFactory.getLogger(AbstractSubscriber.class);
	private ObjectMapper mapper = new ObjectMapper();
	
	private String topicId;
	
	protected IMessageReceiver<S> receiver;
	
	public AbstractSubscriber(IMessageReceiver<S> receiver, String topicId) {
		this.receiver = receiver;
		this.topicId = topicId;
	}
	
	@Override
	public void onCompleted() {
		logger.debug("completed");			
	}

	@Override
	public void onError(Throwable e) {
		logger.error(e.getMessage());		
	}
	
	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}	
	
	public void setReceiver(IMessageReceiver<S> receiver) {
		this.receiver = receiver;
	}
	
	protected <T> T convertFromJson(String json, Class<T> clazz){
		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected <T> T convertFromJson(JsonNode json, Class<T> clazz){
		try {
			return mapper.readValue(json.toString(), clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected <T> T convertFromJson(JsonNode json, TypeReference<T> reference){
		try {
			return mapper.readValue(json.toString(), reference);
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return null;
	}
}
