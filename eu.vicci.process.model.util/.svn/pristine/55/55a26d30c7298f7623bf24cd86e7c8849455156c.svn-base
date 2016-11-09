package eu.vicci.process.model.util.serialization.jsontypeinstances;

import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONIntegerTypeInstance;


public class JSONIntegerTypeInstance extends JSONTypeInstance implements IJSONIntegerTypeInstance{	
	private int value;
	
	public JSONIntegerTypeInstance() {
		super();
	}

	public JSONIntegerTypeInstance(IntegerTypeInstance integerType){
		super(integerType);
		value = integerType.getValue();	
	}

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public Integer getValueAsObject() {
		return Integer.valueOf(value);
	}

	@Override
	public IntegerTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		IntegerTypeInstance iti = instanceFactory.createIntegerTypeInstance();
		iti.setValue(value);
		addBaseInformationsToDataTypeInstance(iti);
		return iti;
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
	public IJSONIntegerTypeInstance makeCopy() {
		IJSONIntegerTypeInstance copy = new JSONIntegerTypeInstance();
		copyBaseInformationsToJson(copy);
		copy.setValue(value);
		return copy;
	}
	
	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		this.value = Integer.valueOf(value);	
	}
}
