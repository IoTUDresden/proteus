package eu.vicci.process.devices.util;

import com.google.gson.Gson;

/**
 * Simple immutable object to hold the event information from OpenHab. This object is used to
 * generate informations from the received json content with the help of gson. <br>
 * 
 * <br>
 * <br>
 * 
 * event: message <br>
 * data:
 * {"topic":"smarthome/items/Button2_2/state","payload":"{\"type\":\"OnOffType\",\"value\":\"ON\"}",
 * "type":"ItemStateEvent"}
 * 
 * <br>
 * <br>
 * 
 * event: message <br>
 * data: {"topic":"smarthome/items/viccirobot_robot_setCurrentLocation_1/command","payload":
 * "{\"type\":\"StringType\",\"value\":\"O: 14, 12 15,13\"}","type":"ItemCommandEvent"}
 * 
 * <br>
 * <br>
 * 
 * 
 * event: message <br>
 * data: {"topic":"smarthome/items/viccirobot_robot_setCurrentLocation_1/statechanged","payload":
 * "{\"type\":\"StringType\",\"value\":\"O: 14, 12 15,13\",\"oldType\":\"UnDefType\",\"oldValue\":\"NULL\"}"
 * ,"type":"ItemStateChangedEvent"}
 * 
 * <br>
 * <br>
 * 
 * event: message <br>
 * data:{"topic":"smarthome/items/fingerscanner_identify_firstinstance_channel_person/added",
 * "payload":
 * "{\"type\":\"StringItem\",\"name\":\"fingerscanner_identify_firstinstance_channel_person\",\"label\":\"Identified\",\"tags\":[],\"groupNames\":[]}"
 * ,"type":"ItemAddedEvent"}
 * 
 * <br>
 * <br>
 * 
 * event: message <br>
 * data: {"topic":"smarthome/items/fingerscanner_identify_channelPerson_1/removed","payload":
 * "{\"type\":\"StringItem\",\"name\":\"fingerscanner_identify_channelPerson_1\",\"label\":\"Identified\",\"tags\":[],\"groupNames\":[]}"
 * ,"type":"ItemRemovedEvent"}
 * 
 * <br>
 * <br>
 * 
 * @author André Kühnert
 *
 */
public class OpenHabEvent {
	private String topic;
	protected String payload;
	private String type;

	private String itemName = null;
	private long timeStamp = 0;

	public OpenHabEvent() {
		timeStamp = System.currentTimeMillis();
	}

	public String getTopic() {
		return topic;
	}

	/**
	 * The time stamp is generated, when the event is received on this machine and this object is
	 * generated.
	 * 
	 * @return
	 */
	public long getTimeStamp() {
		return timeStamp;
	}

	public String getItemName() {
		if (itemName != null)
			return itemName;
		setItemNameFromTopic();
		return itemName;
	}

	public String getPayload() {
		return payload;
	}

	public String getType() {
		return type;
	}

	private void setItemNameFromTopic() {
		int last = topic.lastIndexOf("/");
		String temp = topic.substring(0, last);
		last = temp.lastIndexOf("/");
		itemName = temp.substring(last + 1);
	}

	public static OpenHabEvent fromJson(String json) {
		Gson gson = new Gson();
		OpenHabEvent tmp = gson.fromJson(json, OpenHabEvent.class);

		if (OHItemAddedEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemAddedEvent.class);
		if (OHItemRemovedEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemRemovedEvent.class);
		if (OHItemUpdatedEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemUpdatedEvent.class);
		if (OHItemStateChangedEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemStateChangedEvent.class);
		if (OHItemStateEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemStateEvent.class);
		if (OHItemCommandEvent.TYPE_ID.equals(tmp.type))
			return gson.fromJson(json, OHItemCommandEvent.class);
		return tmp;
	}

	/**
	 * Gets the typed event or null if the event is from other type than the given.
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("unchecked") // check is done
	public static <T extends OpenHabEvent> T fromJson(String json, Class<T> clazz) {
		OpenHabEvent tmp = fromJson(json);
		if (tmp.getClass().equals(clazz))
			return (T) tmp;
		return null;
	}

	// -----------------------------------------------------------------------------------------
	// Custom Event Implementation -------------------------------------------------------------
	// -----------------------------------------------------------------------------------------

	public static abstract class OpenHabTypedEvent<T> extends OpenHabEvent {
		protected transient T typedPayload;

		public T getTypedPayload() {
			if (typedPayload == null)
				typedPayload = createPayload();
			return typedPayload;
		}

		protected abstract T createPayload();
	}

	public static class OHItemAddedEvent extends OpenHabTypedEvent<OHItemAddedPayload> {
		public static final String TYPE_ID = "ItemAddedEvent";

		@Override
		protected OHItemAddedPayload createPayload() {
			return new Gson().fromJson(payload, OHItemAddedPayload.class);
		}
	}

	public static class OHItemRemovedEvent extends OpenHabTypedEvent<OHItemRemovedPayload> {
		public static final String TYPE_ID = "ItemRemovedEvent";

		@Override
		protected OHItemRemovedPayload createPayload() {
			return new Gson().fromJson(payload, OHItemRemovedPayload.class);
		}
	}

	public static class OHItemUpdatedEvent extends OpenHabTypedEvent<String> {
		public static final String TYPE_ID = "ItemUpdatedEvent";
		// TODO dont know when this event is triggered and how it looks :(

		@Override
		protected String createPayload() {
			return payload;
		}
	}

	public static class OHItemStateChangedEvent extends OpenHabTypedEvent<OHItemStateChangedPayload> {
		public static final String TYPE_ID = "ItemStateChangedEvent";

		@Override
		protected OHItemStateChangedPayload createPayload() {
			return new Gson().fromJson(payload, OHItemStateChangedPayload.class);
		}
	}

	public static class OHItemStateEvent extends OpenHabTypedEvent<OHItemStatePayload> {
		public static final String TYPE_ID = "ItemStateEvent";

		@Override
		protected OHItemStatePayload createPayload() {
			return new Gson().fromJson(payload, OHItemStatePayload.class);
		}
	}

	public static class OHItemCommandEvent extends OpenHabTypedEvent<OHItemCommandPayload> {
		public static final String TYPE_ID = "ItemCommandEvent";

		@Override
		protected OHItemCommandPayload createPayload() {
			return new Gson().fromJson(payload, OHItemCommandPayload.class);
		}
	}

	// -----------------------------------------------------------------------------------------
	// Custom Payload Implementation -----------------------------------------------------------
	// -----------------------------------------------------------------------------------------

	public static class OHItemAddedPayload {
		private String type;
		private String name;
		private String label;
		private String[] tags;
		private String[] groupNames;

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public String getLabel() {
			return label;
		}

		public String[] getTags() {
			return tags;
		}

		public String[] getGroupNames() {
			return groupNames;
		}
	}

	public static class OHItemStateChangedPayload extends OHItemStatePayload {
		private String oldType;
		private String oldValue;

		public String getOldType() {
			return oldType;
		}

		public String getOldValue() {
			return oldValue;
		}
	}

	public static class OHItemStatePayload {
		private String type;
		private String value;

		public String getType() {
			return type;
		}

		public String getValue() {
			return value;
		}
	}

	public static class OHItemCommandPayload extends OHItemStatePayload {
		// looks exactly like the state payload
	}

	public static class OHItemRemovedPayload extends OHItemAddedPayload {
		// looks exactly like the added payload
	}

}
