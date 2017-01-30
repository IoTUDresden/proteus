package eu.vicci.process.messages;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public final class SetPortDataTypeInstanceMessage {	
	private final DataTypeInstance dataTypeInstance;

	public SetPortDataTypeInstanceMessage(DataTypeInstance dataTypeInstance) {
		this.dataTypeInstance = dataTypeInstance;
	}
	
	public DataTypeInstance getDataTypeInstance() {
		return dataTypeInstance;
	}
}
