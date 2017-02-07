package eu.vicci.process.model.util.serialization;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.JSONPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.JSONProcessStep;
import eu.vicci.process.model.util.serialization.jsontypes.JSONTypeSerializer;

public class JSONSerializer {
	public static Map<String, Object> processed = new HashMap<String, Object>();
	public static synchronized String serialize(Object input) {
		processed.clear();
		Object object = input;
		if (input instanceof Port)
			object = new JSONPort((Port) input);

		if (input instanceof ProcessStep)
			object = new JSONProcessStep((Identifiable) input);

		if (input instanceof DataType)
			return JSONTypeSerializer.serialize((DataType) input);

		String output = "";
		ObjectMapper mapper = new ObjectMapper();
		try {
			output = mapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		
		return output;
//		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
//		xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
//		xstream.alias(object.getClass().getCanonicalName(), object.getClass());
//		return xstream.toXML(object);
	}

	public static synchronized Object deserialize(String json) {
//		XStream xstream = new XStream(new JettisonMappedXmlDriver());
//		xstream.setMode(XStream.XPATH_RELATIVE_REFERENCES);
//		return xstream.fromXML(json);
		ObjectMapper mapper = new ObjectMapper();
		Object result = null;
		try {
			result = mapper.readValue(json, Object.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	/**
	 * adds to the map of already processed Objects
	 * @param id the unique identifier of the object
	 * @param obj the object itself
	 * @return true if it could be added, false if it already exists
	 */
	public static synchronized boolean addToProcessed(String id, Object obj){
		if(processed.containsKey(id))
			return false;
		processed.put(id, obj);
		return true;
	}
	
	public static boolean hasProcessed(String id){
		return processed.containsKey(id);
	}
	
	public static Object getProcessed(String id){
		return processed.get(id);
	}
}
