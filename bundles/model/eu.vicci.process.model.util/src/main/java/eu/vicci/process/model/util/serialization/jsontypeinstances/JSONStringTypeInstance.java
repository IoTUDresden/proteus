package eu.vicci.process.model.util.serialization.jsontypeinstances;

import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONStringTypeInstance;

public class JSONStringTypeInstance extends JSONTypeInstance implements IJSONStringTypeInstance{	
	private String value;
	
	public JSONStringTypeInstance() {
		super();
	}

	public JSONStringTypeInstance(StringTypeInstance stringType){
		super(stringType);
		this.value = stringType.getValue();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public String getValueAsObject() {
		return value;
	}
	
	@Override
	public StringTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		StringTypeInstance sti = instanceFactory.createStringTypeInstance();
		sti.setValue(value);
		addBaseInformationsToDataTypeInstance(sti);
		return sti;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[ Value: "+value+", InstanceID:"+this.getInstanceID()+"]";
	}

	@Override
	public String getValueStringComplete() {
		return getName()+": "+value;
	}	
	
	@Override
	public String getValueString() {
		return value;
	}

	@Override
	public IJSONStringTypeInstance makeCopy() {
		IJSONStringTypeInstance copy = new JSONStringTypeInstance();
		copyBaseInformationsToJson(copy);
		copy.setValue(value);
		return copy;
	}

	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		this.value = value;		
	}
}
