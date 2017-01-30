package eu.vicci.process.model.util.serialization.jsontypes;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONTypeSerializer implements JsonDeserializer<JSONType>, JsonSerializer<JSONType>{

	@Override
	public JSONType deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		JsonObject jsonObject = json.getAsJsonObject();
		JsonPrimitive prim = (JsonPrimitive) jsonObject.get("typeClass");
		String className = prim.getAsString();
		Class<?> klass = null;
		
		try {
	        klass = Class.forName(className);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        throw new JsonParseException(e.getMessage());
	    }
	    return context.deserialize(json, klass);
	}

	@Override
	public JsonElement serialize(JSONType jsonType, Type typeOfT, JsonSerializationContext context) {
		String className = jsonType.getTypeClass();
		Class<?> klass = null;
		
		try {
	        klass = Class.forName(className);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	        throw new JsonParseException(e.getMessage());
	    }
	    return context.serialize(jsonType, klass);
	}
	
	public static IJSONType makeJSONType(DataType dataType){
		if(dataType instanceof StringType)
			return new JSONStringType((StringType)dataType);
		if(dataType instanceof IntegerType)
			return new JSONIntegerType((IntegerType)dataType);
		if(dataType instanceof DoubleType)
			return new JSONDoubleType((DoubleType)dataType);
		if(dataType instanceof BooleanType)
			return new JSONBooleanType((BooleanType)dataType);
		if(dataType instanceof SetType)
			return new JSONSetType((SetType)dataType);
		if(dataType instanceof ListType)
			return new JSONListType((ListType)dataType);
		if(dataType instanceof ComplexType)
			return new JSONComplexType((ComplexType)dataType);
		throw new IllegalArgumentException("cant serialize datatype to jsontype: " + dataType.getClass());	
	}
	
	public static String serialize(DataType dt){
		String json = "";
		Gson gson = new GsonBuilder().registerTypeAdapter(JSONType.class, new JSONTypeSerializer()).create();
		if (dt instanceof ListType){
			json = gson.toJson(new JSONListType((ListType) dt));
			
		}
		else if (dt instanceof BooleanType)
			json = gson.toJson(new JSONBooleanType((BooleanType) dt));
		else if (dt instanceof IntegerType)
			json = gson.toJson(new JSONIntegerType((IntegerType) dt));
		else if (dt instanceof DoubleType)
			json = gson.toJson(new JSONDoubleType((DoubleType) dt));
		else if (dt instanceof StringType)
			json = gson.toJson(new JSONStringType((StringType) dt));
		else if (dt instanceof ComplexType)
			json = gson.toJson(new JSONComplexType((ComplexType) dt));
		return json;
	}
	
	public static DataType deserialize(String dataType) {

		Gson gson = new GsonBuilder().registerTypeAdapter(
				JSONType.class, new JSONTypeSerializer())
				.create();
		JsonElement json = new JsonParser().parse(dataType);
		JsonObject obj = json.getAsJsonObject();
		String typeClassName = obj.get("typeClass").getAsString();

		IJSONType jt = null;
		if (typeClassName.equals(JSONBooleanType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONBooleanType.class);
		else if (typeClassName.equals(JSONStringType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONStringType.class);
		else if (typeClassName.equals(JSONDoubleType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONDoubleType.class);
		else if (typeClassName.equals(JSONIntegerType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONIntegerType.class);
		else if (typeClassName.equals(JSONListType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONListType.class);
		else if (typeClassName.equals(JSONComplexType.class
				.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONComplexType.class);

		return jt.makeDataType();
	}
}
