package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

/**
 * Immutable Message for activating ports
 */
public final class ActivatePortMessage {
	private final DataTypeInstance parameter;
	private final boolean isBlockingCall;
	
	/**
	 * Default Message. Non Blocking without parameter.
	 */
	public ActivatePortMessage() {
		this(null, false);
	}
	
	/**
	 * Non Blocking with parameter.
	 * @param parameter
	 */
	public ActivatePortMessage(DataTypeInstance parameter) {
		this(parameter, false);
	}
	
	/**
	 * You can specify, if the call should block or not.
	 * @param parameter
	 * @param isBlockingCall - true, when the call should block and wait for the Future.
	 */
	public ActivatePortMessage(DataTypeInstance parameter, boolean isBlockingCall) {
		this.parameter = parameter;
		this.isBlockingCall = isBlockingCall;
	}
	
	public DataTypeInstance getParameter(){
		return parameter;
	}
	
	public boolean isBlockingCall(){
		return isBlockingCall;
	}

}
