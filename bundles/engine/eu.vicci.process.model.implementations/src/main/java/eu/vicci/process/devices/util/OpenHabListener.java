package eu.vicci.process.devices.util;

import java.util.List;

import eu.vicci.process.devices.DeviceManager;
import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.devices.events.SensorEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemAddedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemRemovedEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStateEvent;
import eu.vicci.process.devices.util.OpenHabEvent.OHItemStatePayload;
import eu.vicci.process.model.cep.EsperEngine;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.openhab.util.IOpenHabRestClient;
import eu.vicci.process.openhab.util.OpenHabEventProvider;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemAddedListener;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemRemovedListener;
import eu.vicci.process.openhab.util.OpenHabEventProvider.OHEventItemStateListener;
import eu.vicci.openhab.util.OpenHabRestClient;

/**
 * Listener for receiving openhab events in the process engine <br>
 * <br>
 * TODO:<br>
 * - Only Sensor values are handled (states in dogont) <br>
 * - ItemAdded/Removed is handled but if the semantic layer on openhab takes too long to update the
 * model, the data received from the SAL is maybe inconsistent.
 * 
 * @author André Kühnert
 */
public class OpenHabListener {
	private static final String DEFAULT_SERVER_URI = "http://localhost:8080";

	private String openHabBaseUri = null;
	private boolean isRunning = false;
	private OpenHabEventProvider provider = null;
	private IOpenHabRestClient restClient = null;

	private OpenHabListener() {
	}

	// threadsafe lazy init.
	// https://en.wikipedia.org/wiki/Initialization-on-demand_holder_idiom
	private static class OpenHabListenerHolder {
		private static final OpenHabListener INSTANCE = new OpenHabListener();
	}

	/**
	 * Gets the singleton instance of the Listener. Lazy threadsafe implementation.
	 * 
	 * @return
	 */
	public static OpenHabListener getInstance() {
		return OpenHabListenerHolder.INSTANCE;
	}

	/**
	 * Starts the event listener with the uri stored in {@link ConfigurationManager} or on
	 * {@value #DEFAULT_SERVER_URI} if uri not stored. All State Things are received from OpenHab,
	 * mapped as sensors and added to the DeviceManager.
	 */
	public void start() {
		String uri = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.OPENHAB_URI);
		if (uri == null)
			start(DEFAULT_SERVER_URI);
		else
			start(uri);
	}

	/**
	 * Starts the event listener with the given uri on all events. All State Things are received
	 * from OpenHab, mapped as sensors and added to the DeviceManager.
	 * 
	 * @param openHabBaseUri
	 */
	public synchronized void start(String openHabBaseUri) {
		if (isRunning)
			throw new IllegalStateException("Listener already running!");
		this.openHabBaseUri = openHabBaseUri;
		startRestClientAndRegisterAllDevices();
		startEventProvider();
		isRunning = true;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public synchronized void close() {
		if (!isRunning)
			throw new IllegalStateException("Listener is not running!");
		provider.closeAllEventSources();
		isRunning = false;
		provider = null;
		restClient = null;
		openHabBaseUri = null;
	}

	private void startRestClientAndRegisterAllDevices() {
		restClient = new OpenHabRestClient(openHabBaseUri);
		getAllSensorsSemantic();
	}

	private void getAllSensorsSemantic() {
		List<Sensor> sensors = restClient.getAllSensorsSemantic();
		DeviceManager.getInstance().addDevices(sensors);
	}

	private void startEventProvider() {
		provider = new OpenHabEventProvider(openHabBaseUri);
		provider.registerToItemState(new OHEventItemStateListener() {
			@Override
			public void onItemState(OHItemStateEvent event) {
				addSensorEventToEsper(event);
			}
		});

		provider.registerToItemAdded(new OHEventItemAddedListener() {
			@Override
			public void onItemAdded(OHItemAddedEvent event) {
				// - simples solution: getAll items again, but maybe not the best performance ;)
				// - better solution: extend the oh sal for receiving semantic for specific item
				getAllSensorsSemantic();
			}
		});

		provider.registerToItemRemoved(new OHEventItemRemovedListener() {
			@Override
			public void onItemRemoved(OHItemRemovedEvent event) {
				DeviceManager.getInstance().removeDevice(event.getItemName());
			}
		});
	}

	private void addSensorEventToEsper(OHItemStateEvent openHabEvent) {
		Sensor sensor = Devicifier.createDevice(openHabEvent, restClient);
		OHItemStatePayload payload = openHabEvent.getTypedPayload();
		
		//we must cast the string value to a number if possible, otherwise you cant use it in esper as a number
		Object value = castValueToType(payload);
		SensorEvent event = new SensorEvent(sensor.getEventType(), value, openHabEvent.getTimeStamp(),
				sensor);
		EsperEngine.getInstance().sendSensorEvent(event);
	}
	
	private Object castValueToType(OHItemStatePayload payload){
		if(OH_DecimalType.equals(payload.getType()))
			return tryCastNumber(payload.getValue());
		return payload.getValue();
	}
	
	//as fallback always the string is returned
	private Object tryCastNumber(String value){
		try { return Integer.parseInt(value); } catch (Exception e) {	}	
		try { return Float.parseFloat(value); } catch (Exception e) {	}
		try { return Double.parseDouble(value); } catch (Exception e) {	 }
		try { return Long.parseLong(value); } catch (Exception e) {	 }
		return value;		
	}
	
	private static final String OH_DecimalType = "DecimalType";
}
