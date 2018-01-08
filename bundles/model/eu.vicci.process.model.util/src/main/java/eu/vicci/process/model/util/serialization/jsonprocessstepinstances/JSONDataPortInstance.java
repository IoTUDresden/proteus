package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocesssteps.core.IJSONDataPort;
import eu.vicci.process.model.util.serialization.jsontypeinstances.JSONTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.JSONTypeInstanceSerializer;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class JSONDataPortInstance extends JSONPortInstance implements IJSONDataPortInstance {
	@JsonDeserialize(as=JSONTypeInstance.class)
	private IJSONTypeInstance dataTypeInstance;
	
	public JSONDataPortInstance() {
		super();
	}
	
	public JSONDataPortInstance(DataPortInstance dataPortInstance) {
		super(dataPortInstance);
		dataTypeInstance = JSONTypeInstanceSerializer
				.makeJSONTypeInstance(dataPortInstance.getDataInstance());
	}
	
	@Override
	public DataPortInstance makePortInstance(SofiaInstanceFactory factory) {
		DataPortInstance port = (DataPortInstance)super.makePortInstance(factory);
		port.setDataInstance(dataTypeInstance.makeDataTypeInstance(factory));
		return port;
	}

	@Override
	public IJSONTypeInstance getDataTypeInstance() {
		return dataTypeInstance;
	}

	@Override
	public void setDataTypeInstance(IJSONTypeInstance dataTypeInstance) {
		this.dataTypeInstance = dataTypeInstance;
	}


	@Override
	public IJSONDataPort getPortType() {
		return (IJSONDataPort)super.getPortType();
	}
}
