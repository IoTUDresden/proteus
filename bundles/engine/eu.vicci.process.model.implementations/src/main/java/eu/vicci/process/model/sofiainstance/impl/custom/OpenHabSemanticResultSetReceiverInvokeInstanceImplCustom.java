package eu.vicci.process.model.sofiainstance.impl.custom;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;
import eu.vicci.process.model.util.JsonUtil;

/**
 * Base Class for all OpenHabSemanticInvoke Steps which receives ResultSets from the
 * OpenHAB Semantic Layer (e.g. Select, Command). This base implementation contains
 * methods for activating enddataports, with the values received in the semantic select.
 * 
 * The endports must contain a datatype which matches with the var name in the semantic
 * select. For Example: "Select ?temp, ?location..." the var names are temp and location.
 * The Endports which should contain these values after execution should contain a
 * datatype with the given var name.
 * 
 * ATTENTION: If the datatype name of a endport, does not match with a given var name in
 * the select statement, then these ports are neither activated nor deactivated, so this
 * process will never end at the moment and process execution does not complete!
 * 
 * @author André Kühnert
 *
 */
public abstract class OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom extends
		OpenHabSemanticInvokeInstanceImplCustom {

	private Map<String, Integer> dataInstanceNumbers = new HashMap<String, Integer>();
	private boolean endportsAreActivated = false;
	
	/**
	 * The Result Set received from the semantic layer
	 */
	protected String queryResult;

	/**
	 * Add the values from the result to the ports with DataTypeType name equal to the var
	 * name. The returned list contains all ports, which contains the new data. Non
	 * matching ports are not activated.
	 * 
	 * ATTENTION: Cause non matching ports are not activated, the process will never
	 * complete if there are such ports.
	 * 
	 */
	@Override
	public void activateDataEndPorts() {
		//TODO check why the engine will activate the ports more than one times
		if(endportsAreActivated){
			LOGGER.warn("Endports already activated");
			return;
		}
		JsonObject resultObj = getResultObject();
		JsonArray vars = getResultVars(resultObj);
		JsonArray bindings = getResultsArray(resultObj);

		if (resultObj == null || vars == null || bindings == null) {
			LOGGER.error("cant get result object. enddataports are not activated");
			return;
		}

		List<EndDataPortInstance> settedPorts = iterateOverResultsAndSetPortValues(vars, bindings);
		for (EndDataPortInstance port : settedPorts)
			LifeCycleManager.INSTANCE.activatePort(port);
		endportsAreActivated = true;
	}

	/**
	 * Add the values from the result to the ports with DataTypeType name equal to the var
	 * name. The returned list contains all ports, which contains the new data. Non
	 * matching ports are not activated.
	 * 
	 * ATTENTION: Cause non matching ports are not activated, the process will never
	 * complete if there are such ports.
	 * 
	 * @param vars
	 * @param bindings
	 * @return
	 */
	private List<EndDataPortInstance> iterateOverResultsAndSetPortValues(JsonArray vars, JsonArray bindings) {
		List<EndDataPortInstance> settedPorts = new ArrayList<>();
		for (int i = 0; i < bindings.size(); i++) {
			JsonObject row = bindings.get(i).getAsJsonObject();
			addRowToListOfSpecificEndports(vars, row, settedPorts);
		}
		return settedPorts;
	}

	private void addRowToListOfSpecificEndports(JsonArray vars, JsonObject row,
			List<EndDataPortInstance> settedPorts) {
		for (int i = 0; i < vars.size(); i++) {
			String varName = vars.get(i).getAsString();

			getPorts()
					.stream()
					.filter(port -> port instanceof EndDataPortInstance)
					.map(port -> (EndDataPortInstance) port)
					.forEach(port -> addToDataTypeInstance(port, varName, row, settedPorts));
		}
	}

	// The values are only added if the name of the var and the DataTypeType are equal
	private void addToDataTypeInstance(EndDataPortInstance port, String varName, JsonObject row,
			List<EndDataPortInstance> settedPorts) {
		DataTypeInstance typeInstance = port.getDataInstance();
		
		if(!typeInstance.getDataTypeType().getName().equals(varName))
			return;
		
		//the values are put in a list instance
		if (port.getDataInstance() instanceof ListTypeInstance){
			addToListDataTypeInstance(port, varName, row, settedPorts);
			return;
		}
		
		//only set the first value for all other types
		if(settedPorts.contains(port))
			return;
		JsonObject resultObj = row.get(varName).getAsJsonObject();
		String result = resultObj.get("value").getAsString();
		typeInstance.parse(result);
		settedPorts.add(port);
	}
	
	private void addToListDataTypeInstance(EndDataPortInstance port, String varName, JsonObject row,
			List<EndDataPortInstance> settedPorts){
		ListTypeInstance data = (ListTypeInstance) port.getDataInstance();
		JsonObject resultObj = row.get(varName).getAsJsonObject();
		String result = resultObj.get("value").getAsString();
		DataTypeInstance typeInstance = getNewDataTypeInstance(data.getCollectionItemType());
		typeInstance.parse(result);
		data.getSubtypes().add(typeInstance);

		if (!settedPorts.contains(port))
			settedPorts.add(port);		
	}

	private DataTypeInstance getNewDataTypeInstance(DataType collectionItemType) {
		if(collectionItemType == null)
			throw new IllegalArgumentException("the collection item type of a list should not be null. "
					+ "Check the process model");
		DataTypeInstance typeInstance = createDataTypeInstance(collectionItemType);
		String id = collectionItemType.getId();	
		int instanceNumber = generateInstanceNumber(collectionItemType);
		typeInstance.setTypeId(id);
		typeInstance.setDataTypeType(collectionItemType);
		typeInstance.setName(collectionItemType.getName());
		typeInstance.setIdOfOrigin(id);
		typeInstance.setInstancenumber(instanceNumber);
		typeInstance.setInstanceId(id + "_Instance_" + instanceNumber);		
		return typeInstance;
	}
	
	private int generateInstanceNumber(DataType collectionItemType){
		String id = collectionItemType.getId();
		
		Integer out = dataInstanceNumbers.get(id);
		if(out == null)
			out = 1;
		else
			out++;
		dataInstanceNumbers.put(id, out);
		return out;
	}

	private DataTypeInstance createDataTypeInstance(DataType collectionItemType) {
		int lio = collectionItemType.getClass().getSimpleName().lastIndexOf("Impl");
		if (lio < 0)
			throw new IllegalArgumentException("can not find the correct factory method for "
					+ collectionItemType.getClass().getSimpleName());	
		String split = collectionItemType.getClass().getSimpleName().substring(0, lio);
		String methodName = "create".concat(split).concat("Instance");
		DataTypeInstance instance = null;				
		
		try {
			Method createMethod = SofiaInstanceFactoryImplCustom.class.getMethod(methodName);
			Object result = createMethod.invoke(SofiaInstanceFactoryImplCustom.getInstance());
			instance = (DataTypeInstance) result;
		} catch (NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("can not find the correct factory method for "
					+ collectionItemType.getClass().getSimpleName());	
		}
		return instance;
	}

	private JsonObject getResultObject() {
		if (queryResult == null || queryResult.isEmpty())
			return null;
		JsonElement element = JsonUtil.parse(JsonElement.class, queryResult);
		if (element == null || !element.isJsonObject())
			return null;
		return element.getAsJsonObject();
	}

	private static JsonArray getResultVars(JsonObject resultObject) {
		if (resultObject == null)
			return null;
		JsonObject head = resultObject.get("head").getAsJsonObject();
		return head.get("vars").getAsJsonArray();
	}

	private static JsonArray getResultsArray(JsonObject resultObject) {
		if (resultObject == null)
			return null;
		JsonObject results = resultObject.get("results").getAsJsonObject();
		return results.get("bindings").getAsJsonArray();
	}
}
