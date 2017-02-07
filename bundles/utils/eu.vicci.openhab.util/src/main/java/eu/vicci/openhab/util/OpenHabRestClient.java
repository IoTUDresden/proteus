package eu.vicci.openhab.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.UriBuilder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import eu.vicci.openhab.util.beans.ExecuteGoalCommandBean;
import eu.vicci.openhab.util.beans.Goal;
import eu.vicci.openhab.util.beans.OpenHabItem;
import eu.vicci.openhab.util.beans.Quality;
import eu.vicci.openhab.util.beans.SemanticLocation;
import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.devices.events.core.EventType;
import eu.vicci.process.model.util.JsonUtil;
import eu.vicci.process.model.util.messages.core.SemanticPerson;

/**
 * Rest Client for OpenHab. For receiving events use
 * {@link OpenHabEventProvider} instead.
 * 
 * @author André Kühnert
 *
 */
public class OpenHabRestClient implements IOpenHabRestClient {
	private static final Logger logger = LoggerFactory.getLogger(OpenHabRestClient.class);
	private final String serverBaseUri;

	private CloseableHttpClient client;

	/**
	 * Creates a new OpenHabRestClient to communicate with OpenHab via rest.
	 * This backs a {@link org.apache.http.impl.client.CloseableHttpClient
	 * CloseableHttpClient} which have to be closed after use. Call
	 * {@link #close()} to close it.
	 * 
	 * @param serverBaseUri
	 *            the Uri where OpenHab is running<br>
	 *            e.g. http://localhost:8080
	 */
	public OpenHabRestClient(String serverBaseUri) {
		this.serverBaseUri = serverBaseUri;
		client = HttpClients.createDefault();
		// enables debug logging but this lib is not available in this project
		// for now
		// WebSocketImpl.DEBUG = true;
	}

	@Override
	public String getOpenHabRestVersion() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(REST_PATH).build();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String json = getStringFromResponse(response);
		if (json == null || json.isEmpty())
			return null;
		return JsonUtil.tryGetValueFromJsonObject("version", json);
	}

	@Override
	public String executeSelect(String queryStmt, boolean withLatest) {
		URI uri = getUriForSelectOrAsk(queryStmt, withLatest, SELECT_PATH);
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String json = getStringFromResponse(response);
		return json;
	}

	@Override
	public boolean executeAsk(String queryStmt, boolean withLatest) {
		URI uri = getUriForSelectOrAsk(queryStmt, withLatest, ASK_PATH);
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String json = getStringFromResponse(response);
		if (json == null || json.isEmpty()) {
			logger.error("Error while executing ask");
			return false;
		}
		return getBooleanFromJson(json);
	}

	@Override
	public String postCommandSemantic(String queryStmt, String command, boolean withLatest) {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(COMMAND_PATH).build();
		HttpPost post = new HttpPost(uri);
		JsonObject object = getPostCommandEntityAsJson(queryStmt, command, withLatest);
		String objString = object.toString();
		HttpEntity entity = new StringEntity(objString, ContentType.APPLICATION_JSON);
		post.setEntity(entity);
		logger.debug("post entity: {}", objString);
		CloseableHttpResponse response = executeRequest(post);
		String json = getStringFromResponse(response);
		return json;
	}

	@Override
	public String getLocationForItem(String itemName) {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(SELECT_PATH).path(itemName).path(SEMANTIC_LOCATION_PATH)
				.build();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String out = getStringFromResponse(response);
		if (out == null || out.compareToIgnoreCase("null") == 0)
			return null;
		return out;
	}

	@Override
	public String getSemanticType(String itemName) {
		return null;
	}

	@Override
	public List<OpenHabItem> getAllItems() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(ITEMS_PATH).build();
		List<OpenHabItem> list = receiveList(uri, new TypeToken<ArrayList<OpenHabItem>>() {
		});
		return list == null ? new ArrayList<>() : list;
	}

	@Override
	public List<SemanticPerson> getSemanticPersons() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(SEMANTIC_PERSONS).build();
		return receiveList(uri, new TypeToken<ArrayList<SemanticPerson>>() {
		});
	}

	@Override
	public void close() {
		try {
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Sensor> getAllSensorsSemantic() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(SEMANTIC_SENSOR_PATH).build();
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String json = getStringFromResponse(response);
		return getSensorListFromJson(json);
	}

	@Override
	public void postCommand(OpenHabItem item, String command) {
		throw new UnsupportedOperationException("not implemented yet");
	}

	@Override
	public List<SemanticLocation> getAllLocations() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(SEMANTIC_LOCATIONS_PATH).build();
		return receiveList(uri, new TypeToken<ArrayList<SemanticLocation>>() {
		});
	}

	@Override
	public List<Quality> getAllQualities() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(GOAL_QUALITY_PATH).build();
		return receiveList(uri, new TypeToken<ArrayList<Quality>>() {
		});
	}

	@Override
	public List<Goal> getAllGoals() {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(GOAL_GOAL_PATH).build();
		return receiveList(uri, new TypeToken<ArrayList<Goal>>() {
		});
	}

	@Override
	public boolean executeGoal(ExecuteGoalCommandBean cmd) {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(GOAL_EXECUTE_GOAL_PATH).build();
		HttpPost post = new HttpPost(uri);
		String objString = getObjectAsJson(cmd);
		if(objString == null){
			logger.error("Cant executeGoal. Parameter is null");
			return false;
		}
			
		HttpEntity entity = new StringEntity(objString, ContentType.APPLICATION_JSON);
		post.setEntity(entity);
		logger.debug("post entity: {}", objString);
		CloseableHttpResponse response = executeRequest(post);
		boolean isOk = isStatusOk(response.getStatusLine().getStatusCode());
		closeResponseSafely(response);
		return isOk;
	}

	/**
	 * Receives a List from the given URI per GET REQUEST.
	 * 
	 * @param uri
	 * @param token
	 *            type token, for conversion from json
	 * @return null if request fails
	 */
	private <T> T receiveList(URI uri, TypeToken<T> token) {
		HttpGet get = new HttpGet(uri);
		CloseableHttpResponse response = executeRequest(get);
		String json = getStringFromResponse(response);
		return getObjectListFromJson(json, token);
	}

	private URI getUriForSelectOrAsk(String queryStmt, boolean withLatest, String path) {
		URI uri = UriBuilder.fromPath(serverBaseUri).path(path).queryParam("statement", "{stmt}")
				.queryParam("withlatest", "{withlatest}").build(queryStmt, withLatest);
		return uri;
	}

	/**
	 * Gets the String from the response and close the response.
	 * 
	 * @param response
	 * @return
	 */
	private String getStringFromResponse(CloseableHttpResponse response) {
		if (response == null)
			return null;
		if (!isStatusOk(response.getStatusLine().getStatusCode()))
			return null;
		String out = null;
		try {
			out = EntityUtils.toString(response.getEntity());
		} catch (IOException e) {
			logger.error("error while reading entity from response");
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return out;
	}

	/**
	 * tries to convert the object to a json string.
	 * 
	 * @param src
	 * @return null if src is null or conversion failed
	 */
	private String getObjectAsJson(Object src) {
		try {
			if (src != null)
				return new Gson().toJson(src);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("failed to convert object from class {} to json", src.getClass().getSimpleName());
		}
		return null;
	}
	
	private void closeResponseSafely(CloseableHttpResponse response){
		if(response == null) return;
		try {
			response.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean isStatusOk(int statusCode) {
		switch (statusCode) {
		case 200:
		case 201:
			return true;
		default:
			logger.error("Response status code not ok: {}", statusCode);
			return false;
		}
	}

	private CloseableHttpResponse executeRequest(HttpUriRequest request) {
		CloseableHttpResponse response = null;
		try {
			response = client.execute(request);
		} catch (IOException e) {
			logger.error("error while executing httpget: {}", request.getURI().toString());
			e.printStackTrace();
		}
		return response;
	}

	private boolean getBooleanFromJson(String json) {
		JsonObject obj = JsonUtil.tryGetJsonObject(json);
		JsonElement element = obj.get("result");
		return element.getAsBoolean();
	}

	private JsonObject getPostCommandEntityAsJson(String statement, String command, boolean withLatest) {
		JsonObject object = new JsonObject();
		String tmp = statement.replace("\t", " "); // Problems with tabstops in
													// the query
		object.addProperty("statement", tmp);
		object.addProperty("command", command);
		object.addProperty("withlatest", withLatest);
		return object;
	}

	// ?instance ?shortName ?openHabName ?typeName ?location ?thingName ?unit
	// ?symbol
	private List<Sensor> getSensorListFromJson(String json) {
		List<Sensor> list = new ArrayList<>();
		JsonObject object = JsonUtil.tryGetJsonObject(json);
		JsonObject res = object.getAsJsonObject("results");
		JsonArray results = res.getAsJsonArray("bindings");
		Iterator<JsonElement> it = results.iterator();
		while (it.hasNext()) {
			JsonObject obj = (JsonObject) it.next();
			String uid = getObjectValueAsString("openHabName", "value", obj);
			String type = getObjectValueAsString("typeName", "value", obj);
			String location = getObjectValueAsString("location", "value", obj);
			String unit = getObjectValueAsString("symbol", "value", object);

			EventType et = new EventType(type, String.class);
			Sensor sensor = new Sensor(uid, location, type, et, String.class, unit);
			list.add(sensor);
		}
		return list;
	}

	private <T> T getObjectListFromJson(String json, TypeToken<T> token) {
		if (json == null)
			return null;

		Gson gson = new Gson();
		T result = null;
		try {
			result = gson.fromJson(json, token.getType());
		} catch (Exception e) {
			logger.error(ERR_JSON_CONVERT, token.getType().getClass().getName(), json);
		}
		return result;
	}

	private String getObjectValueAsString(String memberName, String memberValueField, JsonObject object) {
		if (!object.has(memberName))
			return null;
		return object.getAsJsonObject(memberName).get(memberValueField).getAsString();
	}

}
