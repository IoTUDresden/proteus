package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import eu.vicci.process.model.implementation.tests.util.TestUtil;
import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.BooleanTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.DoubleTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.EndDataPortInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.IntegerTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.ListTypeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.OpenHabSemanticSelectInvokeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.StringTypeInstanceImplCustom;

/**
 * 
 * Test the correct extracting of values from a result set and the generating of the
 * output values for the specific endports.
 * 
 * @author André Kühnert
 *
 */
public class OpenHabSemanticResultSetReceiverTests {
	private static final String ERROR_VALUE = "The received values does not match with the expected one";
	private static final String ERROR_TYPE = "The expected datatypeinstance does not match with the actual one";
	private static final SofiaFactory SOFIA_FACTORY = SofiaFactoryImpl.eINSTANCE;	
	private static final String dataTypeName = "testValue";

	@Test
	public void receiveStringListTest() throws Exception {
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStepWithList(StringType.class);
		String value1 = "String_Value_1";
		String value2 = "String_Value_2";
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckListResults(processStep, jsonResult, value1, value2, StringTypeInstanceImplCustom.class);	
	}

	@Test
	public void receiveIntListTest() throws Exception {
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStepWithList(IntegerType.class);
		Integer value1 = 1;
		int value2 = 2;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckListResults(processStep, jsonResult, value1, value2, IntegerTypeInstanceImplCustom.class);	
	}
	
	@Test
	public void receiveDoubleListTest() throws Exception{
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStepWithList(DoubleType.class);
		Double value1 = 1.1;
		double value2 = 2.2;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckListResults(processStep, jsonResult, value1, value2, DoubleTypeInstanceImplCustom.class);	
	}
	
	@Test
	public void receiveBooleanListTest() throws Exception {
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStepWithList(BooleanType.class);
		Boolean value1 = true;
		boolean value2 = false;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckListResults(processStep, jsonResult, value1, value2, BooleanTypeInstanceImplCustom.class);	
	}
	
	@Test
	public void receiveStringTest() throws Exception{
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStep(StringTypeInstance.class, 
				StringType.class);
		String value1 = "String_Value_1";
		String value2 = "String_Value_2";
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckResults(processStep, jsonResult, value1, StringTypeInstanceImplCustom.class);
	}
	
	@Test
	public void receiveIntTest() throws Exception{
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStep(IntegerTypeInstance.class, 
				IntegerType.class);
		int value1 = 1;
		int value2 = 2;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckResults(processStep, jsonResult, value1, IntegerTypeInstanceImplCustom.class);		
	}
	
	@Test
	public void receiveDoubleTest() throws Exception{
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStep(DoubleTypeInstance.class, 
				DoubleType.class);
		double value1 = 1.1;
		double value2 = 2.2;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckResults(processStep, jsonResult, value1, DoubleTypeInstanceImplCustom.class);		
	}
	
	@Test
	public void receiveBooleanTest() throws Exception{
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = getProcessStep(BooleanTypeInstance.class, 
				BooleanType.class);
		boolean value1 = true;
		boolean value2 = false;
		String jsonResult = getJsonResult(value1, value2);
		processObjectsAndCheckResults(processStep, jsonResult, value1, BooleanTypeInstanceImplCustom.class);		
	}
	
	private <T extends DataTypeInstance> void processObjectsAndCheckResults(OpenHabSemanticSelectInvokeInstanceImplCustom processStep, 
			String jsonResult, Object value1, Class<T> dataTypeInstanceClass) throws Exception{
		List<EndDataPortInstance> list = processObjects(processStep, jsonResult);
		assertEquals("only 1 endport should be activated", 1, list.size());
		printAndCheckValues(list, processStep, value1, dataTypeInstanceClass);
	}
	
	private <T extends DataTypeInstance> void printAndCheckValues(List<EndDataPortInstance> list,
			OpenHabSemanticSelectInvokeInstanceImplCustom processStep, Object value1,  Class<T> dataTypeInstanceClass){
		EndDataPortInstance endDataPortInstance = list.get(0);
		DataTypeInstance dt1 = endDataPortInstance.getDataInstance();
		System.out.println();
		System.out.println("Value received: "  + dt1.getValueAsObject());
		System.out.println("Value type: " + dt1.getClass().getSimpleName());
		System.out.println();
		assertEquals(ERROR_VALUE, value1, dt1.getValueAsObject());
		assertEquals(ERROR_TYPE, dataTypeInstanceClass, dt1.getClass());
	}
	
	private <T extends DataTypeInstance> void processObjectsAndCheckListResults(OpenHabSemanticSelectInvokeInstanceImplCustom processStep, 
			String jsonResult, Object value1, Object value2, Class<T> dataTypeInstanceClass) throws Exception{		
		List<EndDataPortInstance> list = processObjects(processStep, jsonResult);
		assertEquals("only 1 endport should be activated", 1, list.size());
		printAndCheckListValues(list, processStep, value1, value2, dataTypeInstanceClass);		
	}
	
	private List<EndDataPortInstance> processObjects(OpenHabSemanticSelectInvokeInstanceImplCustom processStep, String jsonResult) throws Exception{
		setQueryResult(processStep, jsonResult);		
		JsonObject resultObj = getResultObj(processStep);
		JsonArray vars = getResultVars(resultObj, processStep);
		JsonArray bindings = getResultsArray(resultObj, processStep);		
		return iterateOverResultsAndSetPortValues(processStep, vars, bindings);		
	}
	
	private <T extends DataTypeInstance> void printAndCheckListValues(List<EndDataPortInstance> list,
			OpenHabSemanticSelectInvokeInstanceImplCustom processStep, Object value1, Object value2, 
			Class<T> dataTypeInstanceClass) {
		EndDataPortInstance endDataPortInstance = list.get(0);
		printAndCheckValue((ListTypeInstance)endDataPortInstance.getDataInstance(), endDataPortInstance, 
					value1, value2, dataTypeInstanceClass);				
	}
	
	private <T extends DataTypeInstance> void printAndCheckValue(ListTypeInstance listTypeInstance, EndDataPortInstance port, 
			Object value1, Object value2, Class<T> dataTypeInstanceClass){		
		assertEquals("there should be 2 values in the endport list", 2, listTypeInstance.getSubtypes().size());
		DataTypeInstance dt1 = listTypeInstance.getSubtypes().get(0);
		System.out.println();
		System.out.println("Value 1 received: "  + dt1.getValueAsObject());
		System.out.println("Value 1 type: " + dt1.getClass().getSimpleName());
		System.out.println();
		DataTypeInstance dt2 = listTypeInstance.getSubtypes().get(1);
		System.out.println("Value 2 received: "  + dt2.getValueAsObject());
		System.out.println("Value 2 type: " + dt2.getClass().getSimpleName());
		System.out.println();
		
		assertEquals(ERROR_VALUE, value1, dt1.getValueAsObject());
		assertEquals(ERROR_VALUE, value2, dt2.getValueAsObject());
		assertEquals(ERROR_TYPE, dataTypeInstanceClass, dt1.getClass());
		assertEquals(ERROR_TYPE, dataTypeInstanceClass, dt2.getClass());
	}
	
	@SuppressWarnings("unchecked")
	private List<EndDataPortInstance> iterateOverResultsAndSetPortValues(
			OpenHabSemanticSelectInvokeInstanceImplCustom processStep, JsonArray vars, JsonArray bindings) throws Exception {
		Method setValuesMethod = processStep.getClass().getSuperclass().getDeclaredMethod("iterateOverResultsAndSetPortValues", JsonArray.class, JsonArray.class);
		setValuesMethod.setAccessible(true);
		Object result = setValuesMethod.invoke(processStep, vars, bindings);
		return (List<EndDataPortInstance>) result;	
	}
	
	private void setQueryResult(OpenHabSemanticSelectInvokeInstanceImplCustom processStep, String jsonResult) throws Exception {
		Field queryResult = processStep.getClass().getSuperclass().getDeclaredField("queryResult");
		queryResult.setAccessible(true);
		queryResult.set(processStep, jsonResult);
	}
	
	private JsonArray getResultsArray(JsonObject resultObj,
			OpenHabSemanticSelectInvokeInstanceImplCustom processStep) throws Exception {
		Method getResultsArrayMethod = processStep.getClass().getSuperclass().getDeclaredMethod("getResultsArray", JsonObject.class);
		getResultsArrayMethod.setAccessible(true);
		Object result = getResultsArrayMethod.invoke(processStep, resultObj);
		return (JsonArray) result;
	}

	private JsonArray getResultVars(JsonObject resultObj,
			OpenHabSemanticSelectInvokeInstanceImplCustom processStep) throws Exception {
		Method getResultVarsMethod = processStep.getClass().getSuperclass().getDeclaredMethod("getResultVars", JsonObject.class);
		getResultVarsMethod.setAccessible(true);
		Object result = getResultVarsMethod.invoke(processStep, resultObj);
		return (JsonArray) result;
	}

	private JsonObject getResultObj(OpenHabSemanticSelectInvokeInstanceImplCustom processStep) throws Exception {
		Method getResultObjMethod = processStep.getClass().getSuperclass().getDeclaredMethod("getResultObject");
		getResultObjMethod.setAccessible(true);
		Object result = getResultObjMethod.invoke(processStep);
		return (JsonObject) result;
	}
	
	private static String getJsonResult(String value1, String value2){
		return getJsonResult("String", value1, value2);
	}
	
	private static String getJsonResult(boolean value1, boolean value2){
		return getJsonResult("Boolean", value1, value2);
	}
	
	private static String getJsonResult(double value1, double value2){
		return getJsonResult("Double", value1, value2);
	}
	
	private static String getJsonResult(int value1, int value2){
		return getJsonResult("Integer", value1, value2);
	}
	
	private static String getJsonResult(String typeName, Object value1, Object value2){		
		return String.format(jsonResult, dataTypeName, dataTypeName, typeName, value1, dataTypeName, typeName, value2);
	}
	
	//gets process step with simple datatype in the endport
	private static <T extends DataTypeInstance, K extends DataType> OpenHabSemanticSelectInvokeInstanceImplCustom getProcessStep(
			Class<T> dataTypeInstanceClass, Class<K> dataTypeClass) throws Exception {
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = new OpenHabSemanticSelectInvokeInstanceImplCustom();
		DataTypeInstance dataTypeInstance = TestUtil.createDataTypeInstance(dataTypeInstanceClass, null);	
		DataType dataType = getDataType(dataTypeClass);
		dataType.setName(dataTypeName);
		dataTypeInstance.setName(dataTypeName);
		dataTypeInstance.setDataTypeType(dataType);
		EndDataPortInstance endportInstance = getEndport("endport_1", dataTypeInstance);
		processStep.getPorts().add(endportInstance);
		return processStep;
	}
	
	//gets a process step with listdatatype in the endport
	private static <T extends DataType> OpenHabSemanticSelectInvokeInstanceImplCustom getProcessStepWithList(
			Class<T> collectionItemTypeClass) throws Exception {
		OpenHabSemanticSelectInvokeInstanceImplCustom processStep = new OpenHabSemanticSelectInvokeInstanceImplCustom();
		DataTypeInstance dataTypeInstance = getListTypeInstance(collectionItemTypeClass, dataTypeName);
		EndDataPortInstance endportInstance = getEndport("endport_list_1", dataTypeInstance);
		processStep.getPorts().add(endportInstance);
		return processStep;
	}
	
	private static EndDataPortInstance getEndport(String name, DataTypeInstance dataTypeInstance){
		EndDataPortInstance endportInstance = new EndDataPortInstanceImplCustom();
		String id = UUID.randomUUID().toString() + "_Instance";
		endportInstance.setName(name);
		endportInstance.setInstanceId(id);
		endportInstance.setDataInstance(dataTypeInstance);
		return endportInstance;
	}
	
	private static <T extends DataType> ListTypeInstance getListTypeInstance(
			Class<T> collectionItemTypeClass, String name) throws Exception {
		ListTypeInstance list = new ListTypeInstanceImplCustom();
		String id = UUID.randomUUID().toString();

		DataType listType = SofiaFactoryImpl.eINSTANCE.createListType();
		listType.setName(name);
		listType.setId(id);

		DataType collectionItemType = getDataType(collectionItemTypeClass);
		list.setCollectionItemType(collectionItemType);
		list.setName(name);
		list.setInstanceId(id + "_Instance");
		list.setDataTypeType(listType);
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	private static<T extends DataType> T getDataType(Class<T> dataTypeClass) throws Exception{
		String createMethod = "create" + dataTypeClass.getSimpleName();
		Method method = SOFIA_FACTORY.getClass().getMethod(createMethod);
		T dataTypeInstance = (T) method.invoke(SOFIA_FACTORY);
		return dataTypeInstance;
	}
	
	private static final String jsonResult = ""
	+ "{"
	+ "	  \"head\": {"
	+ "	    \"vars\": ["
	+ "	      \"%s\""
	+ "	    ]"
	+ "	  },"
	+ "	  \"results\": {"
	+ "	    \"bindings\": ["
	+ "	      {"
	+ "	        \"%s\": {"
	+ "	          \"type\": \"%s\","
	+ "	          \"value\": \"%s\""
	+ "	        }"
	+ "	      },"
	+ "	      {"
	+ "	        \"%s\": {"
	+ "	          \"type\": \"%s\","
	+ "	          \"value\": \"%s\""
	+ "	        }"
	+ "	      }"
	+ "	    ]"
	+ "	  }"
	+ "	}";	

}
