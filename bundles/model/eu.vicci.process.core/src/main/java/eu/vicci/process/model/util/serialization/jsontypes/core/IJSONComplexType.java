package eu.vicci.process.model.util.serialization.jsontypes.core;

import java.util.List;

import eu.vicci.process.model.sofia.DataType;

public interface IJSONComplexType extends IJSONType {

	DataType makeDataType();

	String toString();

	List<IJSONType> getSubTypes();

	void setSubTypes(List<IJSONType> subTypes);
	
	@Override
	IJSONComplexType makeCopy();

}