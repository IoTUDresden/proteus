package eu.vicci.process.model.util.serialization.jsontypeinstances;

import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONDoubleTypeInstance;

public class JSONDoubleTypeInstance extends JSONTypeInstance implements IJSONDoubleTypeInstance{	
	private double value;
	
	public JSONDoubleTypeInstance() {
		super();
	}
	
	public JSONDoubleTypeInstance(DoubleTypeInstance doubleType){
		super(doubleType);
		value = doubleType.getValue();
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public Double getValueAsObject() {
		return Double.valueOf(value);
	}
	
	@Override
	public DoubleTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		DoubleTypeInstance doubti = instanceFactory.createDoubleTypeInstance();
		doubti.setValue(value);
		addBaseInformationsToDataTypeInstance(doubti);
		return doubti;
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
	public IJSONDoubleTypeInstance makeCopy() {
		IJSONDoubleTypeInstance copy = new JSONDoubleTypeInstance();
		copyBaseInformationsToJson(copy);
		copy.setValue(value);
		return copy;
	}
	
	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		this.value = Double.valueOf(value);	
	}
}
