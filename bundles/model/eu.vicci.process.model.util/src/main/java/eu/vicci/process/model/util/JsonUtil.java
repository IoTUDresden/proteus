package eu.vicci.process.model.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

public class JsonUtil {
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	public static JsonObject tryGetJsonObjectFromJsonArray(JsonArray array, int index){
		JsonElement out = null;
		if(array.size() <= index)
			return null;
		out = array.get(index);
		if(out == null || !out.isJsonObject())
			return null;
		return out.getAsJsonObject();		
	}
	
	public static String tryGetStringFromJsonArray(JsonArray array, int index){
		JsonElement out = null;
		if(array.size() <= index)
			return null;
		out = array.get(index);
		if( out== null || !out.isJsonPrimitive())
			return null;		
		return out.getAsString();
	}
	
	public static JsonArray tryGetJsonArray(String req){
		JsonArray obj = parse(JsonArray.class, req);			
		return obj;		
	}
	
	public static JsonObject tryGetJsonObject(String req){
		JsonObject obj = parse(JsonObject.class, req);
		return obj;
	}
	
	public static String tryGetValue(String memberName, JsonObject object){
		JsonElement obj = object.get(memberName);
		if(obj == null || !obj.isJsonPrimitive())
			return null;
		return obj.getAsString();
	}	
	
	public static String tryGetValueFromJsonObject(String memberName, String objectAsString){
		JsonObject object = parse(JsonObject.class, objectAsString);
		if(object == null)
			return null;
		JsonElement ele = object.get(memberName);
		if(!ele.isJsonPrimitive())
			return null;
		return ele.getAsString();
	}
	
	/**
	 * Trys to parse a given string to the specified json element.
	 * @param clazz
	 * @param req
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static<T extends JsonElement> T parse(Class<T> clazz, String req){
		JsonElement obj = null;
		JsonParser parser = new JsonParser();
		try {
			obj = parser.parse(req);
		} catch (JsonIOException | JsonSyntaxException e) {
			logger.error("error while parsing json string");
			e.printStackTrace();
			return null;
		}
		if(clazz.equals(JsonElement.class))
			return (T)obj;		
		if(clazz.equals(JsonArray.class)){
			if(!obj.isJsonArray())
				return null;
			return (T)obj.getAsJsonArray();
		}
		if(clazz.equals(JsonObject.class)){
			if(!obj.isJsonObject())
				return null;
			return (T)obj.getAsJsonObject();
		}
		if(clazz.equals(JsonPrimitive.class)){
			if(!obj.isJsonPrimitive())
				return null;
			return (T)obj.getAsJsonPrimitive();
		}
		if(clazz.equals(JsonNull.class)){
			if(!obj.isJsonNull())
				return null;
			return (T)obj.getAsJsonNull();
		}
		return null;
	}
}
