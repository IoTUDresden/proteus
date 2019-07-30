package eu.vicci.process.model.util.messages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;

//TODO periodisch ueberpruefen ob reservierungen noch aktuell sind, ansonsten request neu senden
// evtl. Reservierung von 5 Minuten festlegen oder Zeit mitsenden?
/**
 * Server HumanTaskMessageManager. The Manager should inform his listeners only, if new responses
 * (which are not {@link IHumanTaskResponse#cancelReservation()} and/or not
 * {@link IHumanTaskResponse#isSentForReservation()}) are added.
 */
public class HumanTaskMessageManager {
	private static final Logger logger = LoggerFactory.getLogger(HumanTaskMessageManager.class);

	private static HumanTaskMessageManager htmm = null;

	// all requests or responses are mapped to the instance id of the human task
	private Map<String, IHumanTaskRequest> openRequests = Collections
			.synchronizedMap(new HashMap<String, IHumanTaskRequest>());
	private Map<String, IHumanTaskResponse> openResponses = Collections
			.synchronizedMap(new HashMap<String, IHumanTaskResponse>());
	private Map<String, IHumanTaskRequest> closedRequests = Collections
			.synchronizedMap(new HashMap<String, IHumanTaskRequest>());
	private Map<String, IHumanTaskResponse> closedResponses = Collections
			.synchronizedMap(new HashMap<String, IHumanTaskResponse>());

	private List<HumanTaskMessageManagerListener> listeners = 
			new CopyOnWriteArrayList<HumanTaskMessageManagerListener>(
					new ArrayList<HumanTaskMessageManagerListener>());

	private HumanTaskMessageManager() {
	}

	public static synchronized HumanTaskMessageManager getInstance() {
		if (htmm == null) {
			htmm = new HumanTaskMessageManager();
		}
		return htmm;
	}

	/**
	 * Adds an {@link IHumanTaskResponse} to this manager.
	 * 
	 * @param response
	 */
	public synchronized void addHumanTaskResponse(IHumanTaskResponse response) {
		if (response.cancelReservation())
			cancelReservation(response);
		else {
			addResponseIfNotPresent(response);
			// only inform the listeners if this is not a reservation
			if (!response.isSentForReservation())
				informAboutHumanTaskResponseAdded(response);
		}
	}

	/**
	 * Informs this manager that a response was used to handle a human task request.
	 * 
	 * @param response
	 */
	public synchronized void humanTaskResponseHandled(IHumanTaskResponse response) {
		String htInstanceId = response.getHumanTaskInstanceId();
		handleRequest(htInstanceId);
		handleResponse(htInstanceId);
	}

	/**
	 * Adds an {@link HumanTaskMessageManagerListener}.
	 * 
	 * @param listener
	 */
	public void addHumanTaskMessageManagerListener(HumanTaskMessageManagerListener listener) {
		listeners.add(listener);
	}

	/**
	 * Removes an {@link HumanTaskMessageManagerListener}.
	 * 
	 * @param listener
	 */
	public void removeHumanTaskMessageManagerListener(HumanTaskMessageManagerListener listener) {
		listeners.remove(listener);
	}

	/**
	 * Gets all open requests <key: human task instance id, value: IHumanTaskRequest>
	 * 
	 * @return
	 */
	public Map<String, IHumanTaskRequest> getOpenRequest() {
		return openRequests;
	}
	
	/**
	 * Adds an HumanTaskRequest
	 * @param request
	 */
	public void AddOpenRequest(IHumanTaskRequest request){
		String htInstanceId = request.getHumanTaskInstanceId();
		if(!openRequests.containsKey(htInstanceId)){
			openRequests.put(htInstanceId, request);
		}
	}
	
	/**
	 * Removes the open request if still present.
	 */
	public void RemoveOpenRequestIfStillPresent(String requestInstanceId) {
		if(openRequests.containsKey(requestInstanceId)){
			openRequests.remove(requestInstanceId);
		}
	}

	/**
	 * Gets all responses which are handled by the process engine
	 * 
	 * @return
	 */
	public Map<String, IHumanTaskResponse> getHandledResponses() {
		return closedResponses;
	}

	/**
	 * should not inform the listeners at this point - do this after this method
	 * 
	 * @param response
	 * @return true if added
	 */
	private boolean addResponseIfNotPresent(IHumanTaskResponse response) {
		String htInstanceId = response.getHumanTaskInstanceId();
		if (closedRequests.containsKey(htInstanceId)) {
			logger.warn("the human task with id '{}' was already handled", htInstanceId);
			return false;
		}
		openResponses.put(htInstanceId, response);
		return true;
	}

	private void cancelReservation(IHumanTaskResponse response) {
		String htInstanceId = response.getHumanTaskInstanceId();
		IHumanTaskResponse old = openResponses.remove(htInstanceId);
		if (old == null)
			logger.warn("there was no open response for human task '{}'", htInstanceId);

		if (!openRequests.containsKey(htInstanceId))
			logger.warn("there is no open request for human task '{}'", htInstanceId);
		else
			informAboutCancelation(response, openRequests.get(htInstanceId));
	}

	private void handleResponse(String humanTaskInstanceId) {
		IHumanTaskResponse openResponse = openResponses.remove(humanTaskInstanceId);
		if (openResponses != null && !closedResponses.containsKey(humanTaskInstanceId))
			closedResponses.put(humanTaskInstanceId, openResponse);
		else
			logger.error("it seems that the human task response is already handled. Instance Id: {}",
					humanTaskInstanceId);
	}

	private void handleRequest(String humanTaskInstanceId) {
		IHumanTaskRequest openRequest = openRequests.remove(humanTaskInstanceId);
		if (openRequest != null && !closedRequests.containsKey(humanTaskInstanceId))
			closedRequests.put(humanTaskInstanceId, openRequest);
		else
			logger.error("it seems that the human task request is already handled. Instance Id: {}",
					humanTaskInstanceId);
	}

	private void informAboutCancelation(IHumanTaskResponse oldResponse, IHumanTaskRequest request) {
			for (HumanTaskMessageManagerListener listener : listeners) {
				listener.onHumanTaskResponseCanceled(oldResponse, request);
			}
	}

	private void informAboutHumanTaskResponseAdded(final IHumanTaskResponse response) {
		for (HumanTaskMessageManagerListener listener : listeners) {
			listener.onHumanTaskResponseAdded(response);
		}
	}

}
