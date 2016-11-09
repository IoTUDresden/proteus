package eu.vicci.process.model.util.serialization.jsontypes.core;

import eu.vicci.process.model.sofia.DataType;

public interface IJSONDoubleType extends IJSONType{

	DataType makeDataType();

	@Override
	IJSONDoubleType makeCopy();
}