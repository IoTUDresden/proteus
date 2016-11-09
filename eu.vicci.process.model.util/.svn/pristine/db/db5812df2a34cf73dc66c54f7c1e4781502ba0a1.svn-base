package eu.vicci.process.model.util.serialization.jsontypes;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONBooleanType;


public class JSONBooleanType extends JSONType implements IJSONBooleanType{
		
	public JSONBooleanType() {
		super();
	}
	
	public JSONBooleanType(BooleanType booleanType){
		super(booleanType);
	}

	@Override
	public DataType makeDataType() {
		BooleanType bt = SofiaFactory.eINSTANCE.createBooleanType();
		addBaseInformationsToDataType(bt);
		return bt;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName()+"[ID:"+this.getID()+"]";
	}
	
	@Override
	public IJSONBooleanType makeCopy() {
		IJSONBooleanType copy = new JSONBooleanType();
		copyBaseInformationsToJson(copy);
		return copy;
	}
}
