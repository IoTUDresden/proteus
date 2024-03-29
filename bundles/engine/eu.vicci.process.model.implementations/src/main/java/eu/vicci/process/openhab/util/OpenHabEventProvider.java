package eu.vicci.process.openhab.util;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.media.sse.EventListener;
import org.glassfish.jersey.media.sse.EventSource;
import org.glassfish.jersey.media.sse.InboundEvent;
import org.glassfish.jersey.media.sse.SseFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.devices.util.OpenHabEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemAddedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemRemovedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStateEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemUpdatedEvent;

/**
 * Enables listening on the OpenHAB SSE.
 * 
 * @author Andre Kuehnert
 *
 */
public class OpenHabEventProvider {
	private static final Logger logger = LoggerFactory.getLogger(OpenHabEventProvider.class);

	public static final String EVENTS_PATH = "/rest/events";

	private List<EventSource> eventSources = new ArrayList<>();
	private final String serverBasePath;
	private Client client;

	/**
	 * 
	 * @param serverBasePath
	 *            e.g. http://localhost:8080
	 */
	public OpenHabEventProvider(String serverBasePath) {
		this.serverBasePath = serverBasePath;
		client = ClientBuilder.newBuilder().register(SseFeature.class).build();
	}

	/**
	 * Register a listener to OpenHab and receive only updates (e.g. temperature changed from 25 to
	 * 26 degrees).
	 * 
	 * Registers to event: smarthome/update
	 * 
	 * @param listener
	 */
	public void registerToItemState(OHEventItemStateListener listener) {
		register(new EventListener() {
			@Override
			public void onEvent(InboundEvent arg0) {
				listener.onItemState(ohEventFromInbound(arg0, OHItemStateEvent.class));
			}
		}, OpenHabEventTopics.ITEM_STATE);
	}

	/**
	 * An item has been added to the item registry. (Also called if an item name was changed ->
	 * first removed called, then added called)
	 * 
	 * @param listener
	 */
	public void registerToItemAdded(OHEventItemAddedListener listener) {
		register(new EventListener() {
			@Override
			public void onEvent(InboundEvent arg0) {
				listener.onItemAdded(ohEventFromInbound(arg0, OHItemAddedEvent.class));
			}
		}, OpenHabEventTopics.ITEM_ADDED);
	}

	/**
	 * An item has been removed from the item registry. (Also called if an item name was changed ->
	 * first removed called, then added called)
	 * 
	 * @param listener
	 */
	public void registerToItemRemoved(OHEventItemRemovedListener listener) {
		register(new EventListener() {
			@Override
			public void onEvent(InboundEvent arg0) {
				listener.onItemRemoved(ohEventFromInbound(arg0, OHItemRemovedEvent.class));
			}
		}, OpenHabEventTopics.ITEM_REMOVED);
	}

	/**
	 * An item has been updated in the item registry.
	 * 
	 * @param listener
	 */
	public void registerToItemUpdated(OHEventItemUpdatedListener listener) {
		register(new EventListener() {
			@Override
			public void onEvent(InboundEvent arg0) {
				listener.onItemUpdated(ohEventFromInbound(arg0, OHItemUpdatedEvent.class));
			}
		}, OpenHabEventTopics.ITEM_UPDATED);
	}

	private void register(EventListener listener, String path) {
		String eventName = getEventNameWithoutLastSlash(path);
		URI uri = UriBuilder.fromPath(serverBasePath).path(EVENTS_PATH).queryParam("topics", eventName).build();
		logger.debug("register to events on uri: {}", uri.toString());
		registerTo(uri, listener);
	}

	/**
	 * Register a listener to OpenHab and receive all possible events from OpenHab (e.g. temperature
	 * changed from 25 to 26 degrees, an item was added/removed....).
	 * 
	 * @param listener
	 */
	public void registerToAllEvents(EventListener listener) {
		URI uri = UriBuilder.fromPath(serverBasePath).path(EVENTS_PATH).build();
		logger.debug("register to events on uri: {}", uri.toString());
		registerTo(uri, listener);
	}

	/**
	 * Closes all event sources to which this provides is connected
	 */
	public void closeAllEventSources() {
		for (EventSource eventSource : eventSources)
			if (eventSource.isOpen())
				eventSource.close();
		eventSources.clear();
	}

	private void registerTo(URI uri, EventListener listener) {
		WebTarget target = client.target(uri);
		EventSource eventSource = new EventSource(target, false) {
			@Override
			public void onEvent(InboundEvent inboundEvent) {
				//logger.debug("received event:\n   name: {}\n   data: {}\n", inboundEvent.getName(),
				//		inboundEvent.readData(String.class));
			}
		};
		eventSource.register(listener);
		eventSource.open();
		eventSources.add(eventSource);
	}

	private String getEventNameWithoutLastSlash(String eventName) {
		if (!eventName.endsWith("/"))
			return eventName;
		int tmp = eventName.lastIndexOf("/");
		return eventName.substring(0, tmp);
	}

	private static <T extends OpenHabEvent> T ohEventFromInbound(InboundEvent event, Class<T> clazz) {		
		return OpenHabEvent.fromJson(event.readData(String.class), clazz);
	}

	// -----------------------------------------------------------------------------------------
	// Interfaces for callbacks ----------------------------------------------------------------
	// -----------------------------------------------------------------------------------------

	public static interface OHEventItemStateListener {
		void onItemState(OHItemStateEvent event);
	}

	public static interface OHEventItemAddedListener {
		void onItemAdded(OHItemAddedEvent event);
	}

	public static interface OHEventItemRemovedListener {
		void onItemRemoved(OHItemRemovedEvent event);
	}

	public static interface OHEventItemUpdatedListener {
		void onItemUpdated(OHItemUpdatedEvent event);
	}
}
