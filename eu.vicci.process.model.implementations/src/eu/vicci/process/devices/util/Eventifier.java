package eu.vicci.process.devices.util;

import java.util.LinkedHashMap;
import java.util.Map;

import eu.vicci.process.devices.DeviceManager;
import eu.vicci.process.devices.Sensor;
import eu.vicci.process.devices.events.EventManager;
import eu.vicci.process.devices.events.EventType;
import eu.vicci.process.devices.events.SensorEvent;
import eu.vicci.process.model.cep.EsperManager;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.semiwa.common.messages.Event;

public class Eventifier {

	private SensorEvent event;
	private EventType et;
	private Sensor thisSens;

	/**
	 * Constructor for events from value messages
	 * 
	 * @param eventinfo
	 */
	@SuppressWarnings("rawtypes")
	public Eventifier(Event eventinfo) {
		int temp = eventinfo.getTopic().lastIndexOf("/");
		String uid = eventinfo.getTopic().substring(temp + 1);
		String sensing = "";

		Sensor sensor = DeviceManager.getInstance().getDeviceIfRegistered(uid, Sensor.class);
		if (sensor != null) {
			sensing = sensor.getSensing();
			thisSens = sensor;
		}

		et = EventManager.getInstance().addEventTypeIfNotExists(sensing, eventinfo.getPayload().getClass());

		long timestamp = eventinfo.getTimestamp();
		Object payload = eventinfo.getPayload();

		if (!sensing.equals("")) {
			thisSens.setEventType(et);
			SensorEvent event = createEvent(thisSens.getSensing(), payload, thisSens, timestamp);
			addEventTypeToEsper(event, thisSens);
			this.event = event;
		}
	}

	/**
	 * Constructor for events from Data Port instances
	 * 
	 * @param dpi
	 * @param sensor
	 */
	public Eventifier(DataPortInstance dpi, Sensor sensor) {

		Object latestValue = null;

		DataTypeInstance dti = dpi.getDataInstance();

		if (dti instanceof StringTypeInstance) {
			StringTypeInstance sti = (StringTypeInstance) dti;
			latestValue = sti.getValue();
		} else if (dti instanceof IntegerTypeInstance) {
			IntegerTypeInstance iti = (IntegerTypeInstance) dti;
			latestValue = iti.getValue();
		} else if (dti instanceof DoubleTypeInstance) {
			DoubleTypeInstance doti = (DoubleTypeInstance) dti;
			latestValue = doti.getValue();
		} else if (dti instanceof BooleanTypeInstance) {
			BooleanTypeInstance bti = (BooleanTypeInstance) dti;
			latestValue = bti.isValue();
		}

		SensorEvent event = createEvent(sensor.getSensing(), latestValue, sensor, System.currentTimeMillis());
		this.event = event;

		addEventTypeToEsper(event, sensor);
	}

	public SensorEvent getEvent() {
		return event;
	}

	private SensorEvent createEvent(String sensing, Object latestValue, Sensor sensor, long timestamp) {
		if (sensor.getEventType() == null)
			return null;
		SensorEvent event = new SensorEvent(sensor.getEventType(), latestValue, timestamp, sensor);
		// Add event to internal event list
		addEventTypeToEsper(event, sensor);
		EventManager.getInstance().getEventList().add(event);
		return event;
	}

	@SuppressWarnings("rawtypes")
	private void addEventTypeToEsper(SensorEvent se, Sensor sen) {
		Map<String, Object> props = new LinkedHashMap<String, Object>();
		String sensing = sen.getSensing();

		Class datatype = null;
		if (se.getValue() != null) {
			datatype = se.getValue().getClass();
			sen.setDatatype(datatype);
		}

		if (sensing == null)
			return;
		sen.setEventType(et);
		props.put("id", String.class);
		props.put("location", String.class);
		props.put("type", String.class);
		props.put("sensing", String.class);
		props.put("value", datatype.getClass());
		EsperManager.getInstance().addEventType(et.getTypeName(), props);
	}

}
