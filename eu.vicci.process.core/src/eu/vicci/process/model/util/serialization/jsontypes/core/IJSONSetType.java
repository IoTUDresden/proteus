package eu.vicci.process.model.util.serialization.jsontypes.core;

import eu.vicci.process.model.sofia.SetType;

public interface IJSONSetType extends IJSONType {
	
	SetType makeDataType();

	IJSONType getCollectionType();

	void setCollectionType(IJSONType collectionType);
	
	@Override
	IJSONSetType makeCopy();

}
