package eu.vicci.process.devices.events;

import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.devices.events.core.EventType;

/**
 * Immutable Sensor Event. Some properties are mirrored (additional properties with values
 * encapsulated e.g. by the sensor) in order for the complete event processing by esper.
 */
public class SensorEvent extends Event<Sensor> {
	private Object value;
	private String sensing;
	private Class<?> datatype;

	public SensorEvent(EventType eventType, Object value, long timestamp, Sensor device) {
		super(eventType, timestamp, device);
		this.value = value;
		this.sensing = device.getSensing();
		this.datatype = device.getDatatype();
	}

	public Sensor getSensor() {
		return getDevice();
	}

	public Object getValue() {
		return value;
	}

	public Class<?> getDatatype() {
		return datatype;
	}

	public String getSensing() {
		return sensing;
	}
}
