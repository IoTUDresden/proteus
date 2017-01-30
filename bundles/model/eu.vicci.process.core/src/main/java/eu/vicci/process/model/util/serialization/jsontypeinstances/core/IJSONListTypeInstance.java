package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import java.util.List;

import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONListType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public interface IJSONListTypeInstance extends IJSONTypeInstance {

	List<IJSONTypeInstance> getSubTypes();

	void setSubTypes(List<IJSONTypeInstance> list);

	List<IJSONTypeInstance> getValueAsObject();
	
	@Override
	IJSONListType getDataType();

	ListTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	String toString();

	String getValueStringComplete();

	IJSONType getCollectionType();

	void setCollectionType(IJSONType collectionType);
	
	@Override
	IJSONListTypeInstance makeCopy();

}