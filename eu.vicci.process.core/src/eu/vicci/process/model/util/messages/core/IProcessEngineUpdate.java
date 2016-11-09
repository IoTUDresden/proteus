package eu.vicci.process.model.util.messages.core;

public interface IProcessEngineUpdate extends IWampMessage {
	
	UpdateType getUpdateType();
	
	/**
	 * See the descriptions for the update types, to get the correct payload {@link UpdateType}
	 * @return
	 */
	String getPayload();
	
	/**
	 * Returns the payload with the correct type or null, if the payload could not be converted to the given type.
	 * @param clazz
	 * @return
	 */
	<T> T getTypedPayload(Class<T> clazz);
	
	public static enum UpdateType{
		/**
		 * If a process was deployed. The payload should contain the {@link IProcessInfo} as json object.
		 */
		PROCESS_DEPLOYED,
		/**
		 * If a process instance was deployed. The payload should contain the {@link IProcessInstanceInfo} as json object
		 */
		INSTANCE_DEPLOYED
	}
}
