package eu.vicci.process.devices.events;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import eu.vicci.process.devices.Device;

public class EventManager {

	//TODO synchronized lists needed?
	private List<Event<? extends Device>> eventList = new LinkedList<Event<? extends Device>>();
	private List<EventType> eventTypes = new LinkedList<EventType>();
		
	private EventManager() {	}
	
	public static EventManager getInstance() {
		return EventManagerLoader.INSTANCE;
	}

	public List<Event<? extends Device>> getEventList() {
		return eventList;
	}
	
	public void addEvent(Event<? extends Device> e) {
		this.eventList.add(e);
	}
	
	public void removeEvent(Event<? extends Device> e) {
		this.eventList.remove(e);
	}

	public List<EventType> getEventTypes() {
		return eventTypes;
	}
	
	public boolean containsEventType(String type){
		return eventTypes.stream()
				.anyMatch(ev -> ev.getTypeName().equals(type));
	}
	
	/**
	 * Creates a EventType if the given one doesnt exists and returns the created object.
	 * If the EventType already exists, the existing one is returned.
	 * @param type
	 * @param clazz
	 * @return
	 */
	public EventType addEventTypeIfNotExists(String type, Class<?> clazz){
		Optional<EventType> eventType = eventTypes.stream()
				.filter(ev -> ev.getTypeName().equals(type))
				.findFirst();
		if(eventType.isPresent())
			return eventType.get();
		
		EventType newEventType = new EventType(type, clazz);
		eventTypes.add(newEventType);		
		return newEventType;
	}
	
	private static class EventManagerLoader {
		static EventManager INSTANCE = new EventManager();
	}
}
