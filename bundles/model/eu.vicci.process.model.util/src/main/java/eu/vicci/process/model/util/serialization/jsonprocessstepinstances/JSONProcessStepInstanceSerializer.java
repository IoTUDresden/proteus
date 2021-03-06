package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;

public class JSONProcessStepInstanceSerializer {
	public static Map<String, Object> alreadyInstanciated = new ConcurrentHashMap<String, Object>();
	public static Map<String, Object> alreadySerialized = new ConcurrentHashMap<String, Object>();

	public static synchronized String serialize(ProcessStepInstance instance) {
		alreadySerialized.clear();
		IJSONProcessStepInstance jsonProcess = new JSONProcessStepInstance(instance);
		ObjectMapper mapper = new ObjectMapper();
		String result = null;
		try {
			result = mapper.writeValueAsString(jsonProcess);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static synchronized ProcessStepInstance deserialize(String json, SofiaInstanceFactory factory) {
		alreadyInstanciated.clear();

		ObjectMapper mapper = new ObjectMapper();
		ProcessStepInstance result = null;
		try {
			result = ((JSONProcessStepInstance) mapper.readValue(json, JSONProcessStepInstance.class))
					.makeProcessStepInstance(factory);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public static IJSONProcessStepInstance makeJSONProcessStepInstance(ProcessStepInstance processStepInstance){
		return new JSONProcessStepInstance(processStepInstance);
	}
	
	public static IJSONPortInstance makeJSONPortInstance(PortInstance port){
		if(port instanceof EscalationPortInstance)
			return new JSONEscalationPortInstance((EscalationPortInstance)port);
		if(port instanceof DataPortInstance)
			return new JSONDataPortInstance((DataPortInstance)port);
		return new JSONPortInstance(port);
	}

}
