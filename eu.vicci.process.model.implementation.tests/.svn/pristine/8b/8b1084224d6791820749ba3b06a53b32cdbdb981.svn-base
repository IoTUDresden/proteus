package eu.vicci.process.client.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import eu.vicci.process.devices.Sensor;
import eu.vicci.process.model.sofiainstance.impl.custom.OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.impl.custom.OpenHabSemanticSelectInvokeInstanceImplCustom;
import eu.vicci.process.openhab.util.IOpenHabRestClient;
import eu.vicci.process.openhab.util.JsonUtil;
import eu.vicci.process.openhab.util.OpenHabItem;
import eu.vicci.process.openhab.util.OpenHabRestClient;

/**
 * Tests the openhab client. This tests need a instance of openhab running.
 * You can set the base uri via the var 'serverBaseUri'.
 * 
 * @author André Kühnert
 *
 */
//TODO a test server which returns static content would be nice, so no openhab instance would be needed
public class OpenHabRestClientTests {
	private static final String sampleResultSetPath = "resources/sampleResultSet.txt";
	private static final String serverBaseUri = "http://localhost:8080";
	private static final String REST_VERSION = ".20";
	private static IOpenHabRestClient client;

	@BeforeClass
	public static void startClient() {
		client = new OpenHabRestClient(serverBaseUri);
	}

	@AfterClass
	public static void closeClient() {
		client.close();
	}

	/**
	 * Simple test to get the current version of the openhab rest api. This test only
	 * checks if a string is returned which contains the var REST_VERSION.
	 */
	@Test
	public void restVersionTest() {
		String version = client.getOpenHabRestVersion();
		assertTrue(String.format("OpenHab rest version '%s' does not contain the expected string '%s'.",
				version, REST_VERSION), version != null && version.contains(REST_VERSION));
	}

	/**
	 * Sends a post command to the semantic layer in openhab, to switch on all possible
	 * BuildingThings
	 */
	@Test
	public void postCommandSemanticTest() {
		String response = client.postCommandSemantic(AllFunctionsWichCanBeSwitchedOn, "ON", false);
		assertFalse("The response should not be null", response == null || response.isEmpty());
		System.out.println(response);
	}

	/**
	 * Executes a query and checks if subject and type are in the vars array of the
	 * queryresult
	 */
	@Test
	public void getAllBuildingThingsSemanticTest() {
		String result = client.executeSelect(selectAllBuildingThings, true);
		JsonObject obj = JsonUtil.tryGetJsonObject(result);
		JsonElement head = obj.get("head");
		JsonArray vars = head.getAsJsonObject().get("vars").getAsJsonArray();
		String subject = vars.get(0).getAsString();
		String type = vars.get(1).getAsString();
		assertTrue(String.format("Query result error: Expected: %s Current: %s", "subject", subject),
				"subject".equals(subject));
		assertTrue(String.format("Query result error: Expected: %s Current: %s", "type", type),
				"type".equals(type));
		System.out.println(result);
	}

	/**
	 * Ask, if there are any dogont:Controllable instances in the model
	 */
	@Test
	public void askQuerySemanticTest() {
		boolean result = client.executeAsk(AskIfAnyControllable, false);
		assertTrue(
				"The ask result should be true, or arent there any BuildingThing instances in your model?",
				result);
	}
	
	/**
	 * Gets all Items from OpenHab. Fails if nothing is returned
	 */
	@Test
	public void getAllItemsTest(){
		List<OpenHabItem> items = client.getAllItems();
		assertFalse("some items should be returned by the client", items == null || items.isEmpty());
		System.out.println("\nItem Links:");
		for (OpenHabItem item : items)
			System.out.println("	" + item.getLink());
		System.out.println();		
	}
	
	@Test
	public void getAllSemanticSensorsTest(){
		List<Sensor> sensors = client.getAllSensorsSemantic();
		assertFalse("there should be sensors from the semantic layer", sensors.isEmpty());	
		for (Sensor sensor : sensors) {
			System.out.println("Sensor: ");
			System.out.println("	uid:      " + sensor.getUid());
			System.out.println("	sensing:  " + sensor.getSensing());
			System.out.println("	unit:     " + sensor.getUnit());
			System.out.println("	type:     " + sensor.getType());
			System.out.println("	eventType:" + sensor.getEventType());
			System.out.println("	dataType: " + sensor.getDatatype().getSimpleName());
		}
	}
	
	/**
	 * Reads the Jena result set from json
	 * 
	 * @throws IOException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws NoSuchFieldException
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws InvocationTargetException 
	 */
	@Test
	public void readResultSetFromJsonTest() throws Exception {
		StringBuilder builder = new StringBuilder();
		Files.lines(Paths.get(sampleResultSetPath)).forEach(line -> builder.append(line));
		OpenHabSemanticResultSetReceiverInvokeInstanceImplCustom step = 
				new OpenHabSemanticSelectInvokeInstanceImplCustom();
		
		Field resultField = step.getClass().getSuperclass().getDeclaredField("queryResult");
		resultField.setAccessible(true);
		resultField.set(step, builder.toString());
		
		Method getResultObjMethod = step.getClass().getSuperclass().getDeclaredMethod("getResultObject");
		getResultObjMethod.setAccessible(true);
		Method getResultVarsMethod = step.getClass().getSuperclass().getDeclaredMethod("getResultVars", JsonObject.class);
		getResultVarsMethod.setAccessible(true);
		Method getResultsArrayMethod = step.getClass().getSuperclass().getDeclaredMethod("getResultsArray", JsonObject.class);
		getResultsArrayMethod.setAccessible(true);
		
		JsonObject resultObj = (JsonObject)getResultObjMethod.invoke(step);
		assertNotNull("Cant read result set", resultObj);
		
		JsonArray varArray = (JsonArray)getResultVarsMethod.invoke(step, resultObj);
		assertNotNull("The var array in the result set head should not be null", varArray);
		assertEquals("subject", varArray.get(0).getAsString());
		assertEquals("type",  varArray.get(1).getAsString());
		
		JsonArray results = (JsonArray)getResultsArrayMethod.invoke(step, resultObj);
		assertNotNull("the bindings in results should not be null", results);
		String firstSubject = results.get(0).getAsJsonObject()
				.get("subject").getAsJsonObject().get("value").getAsString();
		String firstType = results.get(0).getAsJsonObject()
				.get("type").getAsJsonObject().get("value").getAsString();
		String secondSubject = results.get(1).getAsJsonObject()
				.get("subject").getAsJsonObject().get("value").getAsString();
		String secondType = results.get(1).getAsJsonObject()
				.get("type").getAsJsonObject().get("value").getAsString();
		
		assertEquals("http://elite.polito.it/ontologies/dogont.owl#Thing_yahooweather_weather_berlin", 
				firstSubject);
		assertEquals("http://elite.polito.it/ontologies/dogont.owl#SingleTemperatureSensor", 
				firstType);
		assertEquals("http://elite.polito.it/ontologies/dogont.owl#Thing_fingerscanner_identify_25b1defb", 
				secondSubject);
		assertEquals("http://elite.polito.it/ontologies/dogont.owl#AccessControlSystem", 
				secondType);
	}

	/**
	 * Only tests, if the uri is correct build and encoded
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@Test
	public void simpleUriFormatTest() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "getUriForSelectOrAsk";
		Method method = client.getClass().getDeclaredMethod(methodName, String.class, boolean.class,
				String.class);
		method.setAccessible(true);
		URI uri = (URI) method.invoke(client, selectAllBuildingThings, true, IOpenHabRestClient.SELECT_PATH);
		String formatted = uri.toString();
		assertTrue(
				String.format("Uri has wrong format. Expected: %s\n Current: %s", formattedUri, formatted),
				formattedUri.equals(formatted));
	}

	private static final String AskIfAnyControllable = ""
			+ "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"
			+ "PREFIX dogont: <http://elite.polito.it/ontologies/dogont.owl#>" + "ASK" + "{"
			+ "   ?subject rdf:type ?type ." + "	?type rdfs:subClassOf* dogont:Controllable ." + "}";

	private static final String AllFunctionsWichCanBeSwitchedOn = ""
			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
			+ "PREFIX dogont: <http://elite.polito.it/ontologies/dogont.owl#> "
			+ "SELECT DISTINCT ?subject ?func " + "	WHERE { " + "	?subject dogont:hasFunctionality ?func . "
			+ "	?func dogont:hasCommand ?cmd. " + "	?cmd a dogont:OnCommand . " + "}";

	private static final String formattedUri = "http://localhost:8080/rest/semantic/select"
			+ "?statement=PREFIX+rdf:%3Chttp://www.w3.org/1999/02/22-rdf-syntax-ns%23%3E"
			+ "PREFIX+rdfs:%3Chttp://www.w3.org/2000/01/rdf-schema%23%3EPREFIX+dogont:+%3C"
			+ "http://elite.polito.it/ontologies/dogont.owl%23%3ESELECT+*+WHERE+%7B+%09"
			+ "?subject+rdf:type+?type+.%09?type+rdfs:subClassOf*+dogont:BuildingThing+.%7D&withlatest=true";

	private static final String selectAllBuildingThings = ""
			+ "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
			+ "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"
			+ "PREFIX dogont: <http://elite.polito.it/ontologies/dogont.owl#>" + "SELECT * " + "WHERE { "
			+ "	?subject rdf:type ?type ." + "	?type rdfs:subClassOf* dogont:BuildingThing ." + "}";
}
