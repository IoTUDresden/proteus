package eu.vicci.process.devices.events.core;

/**
 * EventType mostly for Esper
 * 
 * @author ronsei
 *
 */
public class EventType {

	private String typeName;
	private Class<?> datatype;

	/**
	 * 
	 * @param typeName
	 *            the type name of the event (e.g. temperatureEvent)
	 * @param datatype
	 *            Java Class of data value
	 */
	public EventType(String typeName, Class<?> datatype) {
		this.typeName = typeName;
		this.datatype = datatype;
	}

	public String getTypeName() {
		return typeName;
	}

	/**
	 * Java Class of data value
	 * 
	 * @return
	 */
	public Object getDatatype() {
		return datatype;
	}
}
