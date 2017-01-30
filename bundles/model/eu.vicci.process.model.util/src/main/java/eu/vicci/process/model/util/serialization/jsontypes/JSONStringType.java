package eu.vicci.process.model.util.serialization.jsontypes;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONStringType;

public class JSONStringType extends JSONType implements IJSONStringType {

	public JSONStringType() {
		super();
	}

	public JSONStringType(StringType stringType) {
		super(stringType);
	}

	@Override
	public DataType makeDataType() {
		StringType sti = SofiaFactory.eINSTANCE.createStringType();
		addBaseInformationsToDataType(sti);
		return sti;
	}
	
	@Override
	public IJSONStringType makeCopy() {
		IJSONStringType copy = new JSONStringType();
		copyBaseInformationsToJson(copy);
		return copy;
	}

}
