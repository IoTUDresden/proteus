package eu.vicci.process.model.util.serialization.jsonprocesssteps;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONDataPort;
import eu.vicci.process.model.util.serialization.jsontypes.JSONType;
import eu.vicci.process.model.util.serialization.jsontypes.JSONTypeSerializer;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONDataPort extends JSONPort implements IJSONDataPort {
	@JsonDeserialize(as=JSONType.class)
	private IJSONType dataType;
	private String value;
	
	public JSONDataPort() {
		super();
	}
	
	public JSONDataPort(DataPort dataPort) {
		super(dataPort);
		dataType = JSONTypeSerializer.makeJSONType(dataPort.getPortDatatype());		
	}
	
	@Override
	public DataPort makePort() {
		DataPort dataPort = (DataPort)super.makePort();
		dataPort.setPortDatatype(dataType.makeDataType());
		dataPort.setValue(value);
		return dataPort;
	}

	@Override
	public IJSONType getDataType() {
		return dataType;
	}

	@Override
	public void setDataType(IJSONType dataType) {
		this.dataType = dataType;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}

}
