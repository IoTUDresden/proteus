package eu.vicci.process.model.util.serialization.jsontypes.core;

import eu.vicci.process.model.sofia.DataType;

public interface IJSONIntegerType extends IJSONType {
	
	int getMin();
	
	void setMin(int min);
	
	int getMax();
	
	void setMax(int max);	

	DataType makeDataType();

	@Override
	IJSONIntegerType makeCopy();
}