package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public final class ExecuteTransitionMessage {
	private final DataTypeInstance parameter;
	private final boolean isBlockingCall;
	
	public ExecuteTransitionMessage(DataTypeInstance parameter)	{
		this(parameter, false);
	}
	
	public ExecuteTransitionMessage() {
		this(null, false);
	}
	
	public ExecuteTransitionMessage(DataTypeInstance parameter, boolean isBlockingCall){
		this.parameter = parameter;
		this.isBlockingCall = isBlockingCall;		
	}

	public DataTypeInstance getParameter() {
		return parameter;
	}
	
	public boolean isBlockingCall(){
		return isBlockingCall;
	}
}
