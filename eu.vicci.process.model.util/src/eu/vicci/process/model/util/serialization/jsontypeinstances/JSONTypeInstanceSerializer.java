package eu.vicci.process.model.util.serialization.jsontypeinstances;

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

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class JSONTypeInstanceSerializer
		implements JsonDeserializer<JSONTypeInstance>, JsonSerializer<JSONTypeInstance> {

	@Override
	public JSONTypeInstance deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
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
	public JsonElement serialize(JSONTypeInstance jsonType, Type typeOfT, JsonSerializationContext context) {
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

	public static String serialize(DataTypeInstance dti) {
		String json = "";
		Gson gson = new GsonBuilder().registerTypeAdapter(JSONTypeInstance.class, new JSONTypeInstanceSerializer())
				.create();

		json = gson.toJson(makeJSONTypeInstance(dti));

		return json;
	}

	public static IJSONTypeInstance makeJSONTypeInstance(DataTypeInstance dti) {
		if (dti instanceof ListTypeInstance)
			return new JSONListTypeInstance((ListTypeInstance) dti);
		if (dti instanceof BooleanTypeInstance)
			return new JSONBooleanTypeInstance((BooleanTypeInstance) dti);
		if (dti instanceof IntegerTypeInstance)
			return new JSONIntegerTypeInstance((IntegerTypeInstance) dti);
		if (dti instanceof DoubleTypeInstance)
			return new JSONDoubleTypeInstance((DoubleTypeInstance) dti);
		if (dti instanceof StringTypeInstance)
			return new JSONStringTypeInstance((StringTypeInstance) dti);
		if(dti instanceof SetTypeInstance)
			return new JSONSetTypeInstance((SetTypeInstance)dti);
		if (dti instanceof ComplexTypeInstance)
			return new JSONComplexTypeInstance((ComplexTypeInstance) dti);
		throw new IllegalArgumentException("cant serialize datatypeinstance to jsontypeinstance: " 
			+ dti.getClass());
	}

	/**
	 * @deprecated Should not be used anymore. The default implementation for
	 *             datatypeinstances is used, but there are some not implemented
	 *             methods (e.g. compareTo). Use
	 *             {@link #deserialize(String, SofiaInstanceFactory)} instead.
	 * @return
	 */
	@Deprecated
	public static DataTypeInstance deserialize(String dataType) {
		return deserialize(dataType, SofiaInstanceFactory.eINSTANCE);
	}

	public static DataTypeInstance deserialize(String dataType, SofiaInstanceFactory instanceFactory) {
		IJSONTypeInstance jt = makeJSONType(dataType);
		return jt.makeDataTypeInstance(instanceFactory);
	}

	public static IJSONTypeInstance makeJSONType(String dataType) {

		Gson gson = new GsonBuilder().registerTypeAdapter(JSONTypeInstance.class, new JSONTypeInstanceSerializer())
				.create();
		JsonElement json = new JsonParser().parse(dataType);
		JsonObject obj = json.getAsJsonObject();
		String typeClassName = obj.get("typeClass").getAsString();

		IJSONTypeInstance jt = null;
		if (typeClassName.equals(JSONBooleanTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONBooleanTypeInstance.class);
		else if (typeClassName.equals(JSONStringTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONStringTypeInstance.class);
		else if (typeClassName.equals(JSONDoubleTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONDoubleTypeInstance.class);
		else if (typeClassName.equals(JSONIntegerTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONIntegerTypeInstance.class);
		else if (typeClassName.equals(JSONListTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONListTypeInstance.class);
		else if (typeClassName.equals(JSONComplexTypeInstance.class.getCanonicalName()))
			jt = gson.fromJson(dataType, JSONComplexTypeInstance.class);
		return jt;
	}
}
