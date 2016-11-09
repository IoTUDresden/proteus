package eu.vicci.process.model.util.serialization.jsontypeinstances;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONBooleanTypeInstance;

public class JSONBooleanTypeInstance extends JSONTypeInstance implements IJSONBooleanTypeInstance{	
	private boolean value;
	
	public JSONBooleanTypeInstance() {
		super();
	}
	
	public JSONBooleanTypeInstance(BooleanTypeInstance booleanType){
		super(booleanType);
		this.value = booleanType.isValue();
	}

	@Override
	public boolean getValue() {
		return value;
	}

	@Override
	public void setValue(boolean value) {
		this.value = value;
	}
	
	@Override
	public Boolean getValueAsObject() {
		return Boolean.valueOf(value);
	}
	
	@Override
	public BooleanTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		BooleanTypeInstance bti = instanceFactory.createBooleanTypeInstance();
		bti.setValue(value);
		addBaseInformationsToDataTypeInstance(bti);
		return bti;
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
		return String.valueOf(value);
	}

	@Override
	public IJSONBooleanTypeInstance makeCopy() {
		IJSONBooleanTypeInstance copy = new JSONBooleanTypeInstance();
		copyBaseInformationsToJson(copy);
		copy.setValue(value);
		return copy;
	}
	
	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		this.value = Boolean.parseBoolean(value);
	}
	
}
