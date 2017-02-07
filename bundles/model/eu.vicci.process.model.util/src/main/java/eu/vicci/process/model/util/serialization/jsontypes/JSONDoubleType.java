package eu.vicci.process.model.util.serialization.jsontypes;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONDoubleType;

public class JSONDoubleType extends JSONType implements IJSONDoubleType {

	public JSONDoubleType() {
		super();
	}

	public JSONDoubleType(DoubleType doubleType) {
		super(doubleType);
	}

	@Override
	public DataType makeDataType() {
		DoubleType doubti = SofiaFactory.eINSTANCE.createDoubleType();
		super.addBaseInformationsToDataType(doubti);
		return doubti;
	}
	
	@Override
	public IJSONDoubleType makeCopy() {
		IJSONDoubleType copy = new JSONDoubleType();
		copyBaseInformationsToJson(copy);
		return copy;
	}
}
