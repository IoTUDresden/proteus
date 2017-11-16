package eu.vicci.process.devices.util;

import java.util.LinkedHashMap;
import java.util.Map;

import eu.vicci.openhab.util.IOpenHabRestClient;
import eu.vicci.process.devices.DeviceManager;
import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.devices.events.EventManager;
import eu.vicci.process.devices.events.core.EventType;
import eu.vicci.process.model.cep.EsperManager;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

/**
 * Creates a device object from node registered and unregistered messages
 */
public class Devicifier {

	// no instance needed
	private Devicifier() {
	}

	/**
	 * Create Device from OpenHabEvent
	 * @param openHabEvent
	 * @param restClient
	 * @return
	 */
	public static Sensor createDevice(OpenHabEvent openHabEvent, IOpenHabRestClient restClient) {
		Sensor device = DeviceManager.getInstance()
				.getDeviceIfRegistered(openHabEvent.getItemName(), Sensor.class);
		if(device != null)
			return device;
		// TODO try to receive the values direct from openhab
		EventType eventType = EventManager.getInstance().addEventTypeIfNotExists("unknow", String.class);
		device = new Sensor(openHabEvent.getItemName(), "unknow", "unknow", eventType, String.class, "");
		DeviceManager.getInstance().addDevice(device);
		return device;
	}


	/**
	 * Create Sensor from data port instance or gets the already existing device from the
	 * device manager
	 * 
	 * @param dpi
	 * @return
	 */
	public static Sensor createDevice(DataPortInstance dpi) {
		String uid = dpi.getInstanceId();
		String location = "";
		String sensing = dpi.getPortType().getName();
		String type = sensing;

		DataTypeInstance dti = dpi.getDataInstance();

		Class<?> cls = null;

		if (dti instanceof StringTypeInstance) {
			cls = java.lang.String.class;
		} else if (dti instanceof IntegerTypeInstance) {
			cls = java.lang.Integer.class;
		} else if (dti instanceof DoubleTypeInstance) {
			cls = java.lang.Double.class;
		} else if (dti instanceof BooleanTypeInstance) {
			cls = java.lang.Boolean.class;
		}

		Sensor sensor = DeviceManager.getInstance().getDeviceIfRegistered(uid, Sensor.class);
		if (sensor != null)
			return sensor;

		EventType et = EventManager.getInstance().addEventTypeIfNotExists(sensing, cls);		

		sensor = new Sensor(uid, location, sensing, type, et, cls);
		DeviceManager.getInstance().addDevice(sensor);
		addEventTypeToEsper(et, cls);
		return sensor;
	}
	
	private static void addEventTypeToEsper(EventType eventType, Class<?> datatype){
		Map<String, Object> props = new LinkedHashMap<String, Object>();
		props.put("id", String.class);
		props.put("location", String.class);
		props.put("type", String.class);
		props.put("sensing", String.class);
		props.put("value", datatype);
		EsperManager.getInstance().addEventType(eventType.getTypeName(), props);		
	}
}
