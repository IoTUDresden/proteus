package eu.vicci.process.devices.events;

import eu.vicci.process.devices.Device;

/**
 * Base Class for Events used by the EsperEngine. Events should be immutable, so that
 * events can not be modified, after they have been created.
 * 
 * @see<a href=
 *        "http://www.espertech.com/esper/release-5.2.0/esper-reference/html/api.html#api-runtime"
 *        >Esper API Runtime Documentation</a>
 * 
 * @param <T>
 */
public abstract class Event<T extends Device> {

	protected long timestamp;
	protected T device;
	protected EventType eventType;
	protected String uid;
	protected String location;

	/**
	 * 
	 * @param eventType
	 *            the type of the event
	 * @param timestamp
	 * @param device
	 *            the device which triggers the event
	 */
	public Event(EventType eventType, long timestamp, T device) {
		this.timestamp = timestamp;
		this.device = device;
		this.eventType = eventType;
		this.uid = device.getUid();
		this.location = device.getLocation();
	}

	/**
	 * the name of the event (e.g. temperatureEvent)
	 * 
	 * @return
	 */
	public String getTypeName() {
		return eventType.getTypeName();
	}

	/**
	 * Gets the EventType
	 * 
	 * @return
	 */
	public EventType getEventType() {
		return eventType;
	}

	public long getTimestamp() {
		return timestamp;
	}

	/**
	 * gets the device which triggers the event
	 * 
	 * @return
	 */
	public T getDevice() {
		return device;
	}

	public String getDeviceLocation() {
		return location;
	}

	public String getDeviceUid() {
		return uid;
	}
}
