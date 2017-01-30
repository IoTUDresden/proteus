package eu.vicci.process.model.util.serialization.jsontypes;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONIntegerType;

public class JSONIntegerType extends JSONType implements IJSONIntegerType {
	private int min;
	private int max;

	public JSONIntegerType() {
		super();
	}

	public JSONIntegerType(IntegerType integerType) {
		super(integerType);
		min = integerType.getMin();
		max = integerType.getMax();
	}

	@Override
	public DataType makeDataType() {
		IntegerType iti = SofiaFactory.eINSTANCE.createIntegerType();
		addBaseInformationsToDataType(iti);
		iti.setMin(min);
		iti.setMax(max);
		return iti;
	}
	
	@Override
	public IJSONIntegerType makeCopy() {
		IJSONIntegerType copy = new JSONIntegerType();
		copyBaseInformationsToJson(copy);
		copy.setMax(max);
		copy.setMin(min);
		return copy;
	}

	@Override
	public int getMin() {
		return min;
	}

	@Override
	public void setMin(int min) {
		this.min = min;
	}

	@Override
	public int getMax() {
		return max;
	}

	@Override
	public void setMax(int max) {
		this.max = max;
	}

}
