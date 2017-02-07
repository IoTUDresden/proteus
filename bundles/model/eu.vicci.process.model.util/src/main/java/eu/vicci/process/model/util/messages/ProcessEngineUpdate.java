package eu.vicci.process.model.util.messages;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.util.configuration.TopicId;
import eu.vicci.process.model.util.messages.core.IProcessEngineUpdate;

public class ProcessEngineUpdate extends WampMessage implements IProcessEngineUpdate {
	private UpdateType updateType;
	private String payload;
	
	@JsonIgnore
	private Object typedObject;
	
	public ProcessEngineUpdate() {
		super(TopicId.ENGINE_UPDATE);
	}
	
	public ProcessEngineUpdate(UpdateType updateType, String payload) {
		super(TopicId.ENGINE_UPDATE);
		this.updateType = updateType;
		this.payload = payload;
	}	

	@Override
	public UpdateType getUpdateType() {
		return updateType;
	}

	@Override
	public String getPayload() {
		return payload;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getTypedPayload(Class<T> clazz) {
		if(typedObject != null)
			return (T)typedObject;
		ObjectMapper mapper = new ObjectMapper();
		try {
			typedObject = mapper.readValue(payload, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (T)typedObject;
	}

}
