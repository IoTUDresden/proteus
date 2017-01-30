package eu.vicci.process.wampserver.handlers;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import rx.Subscriber;
import ws.wamp.jawampa.Request;

public abstract class AbstractRpcHandler extends Subscriber<Request> {
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void onCompleted() {
		
	}
	
	@Override
	public void onError(Throwable e) {
		e.printStackTrace();		
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

}
