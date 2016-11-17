package eu.vicci.process.devices.core;

import eu.vicci.process.devices.events.core.EventType;

public class Sensor extends Device {

	private String sensing;
	private String unit;
	private String type;
	private EventType eventType;
	private Class<?> datatype;

	/**
	 * 
	 * @deprecated this has to be refactored. what exactly is the difference between type
	 *             and eventtype? Are these types needed in the sensor? or only in the event?
	 * 
	 * @param uid
	 *            Uid for the Device
	 * @param location
	 *            Location, where the device is located
	 * @param sensing
	 *            what does this device measure?
	 * @param type
	 * 
	 * @param eventType
	 * 
	 * @param datatype
	 *            The class in which the value is represented (e.g. float or double for
	 *            temperature)
	 */
	@Deprecated
	public Sensor(String uid, String location, String sensing, String type, EventType eventType,
			Class<?> datatype) {
		super(uid, location);
		this.sensing = sensing;
		this.type = type;// TODO is this needed cause et exists
		this.eventType = eventType; // TODO is this enough
		this.datatype = datatype;
	}

	public Sensor(String uid, String location, String sensing, EventType eventType, Class<?> datatype,
			String unit) {
		super(uid, location);
		this.sensing = sensing;
		this.type = eventType.getTypeName();
		this.eventType = eventType;
		this.datatype = datatype;
		this.unit = unit;
	}

	public String getSensing() {
		return sensing;
	}

	public String getUnit() {
		return unit;
	}

	public Class<?> getDatatype() {
		return datatype;
	}

	/**
	 * The Class should be immutable
	 * 
	 * @param datatype
	 */
	@Deprecated
	public void setDatatype(Class<?> datatype) {
		this.datatype = datatype;
	}

	public String getType() {
		return type;
	}

	public EventType getEventType() {
		return eventType;
	}

	/**
	 * The Class should be immutable
	 * 
	 * @param eventType
	 */
	@Deprecated
	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}
}
