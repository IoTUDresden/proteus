package eu.vicci.process.model.util.serialization.jsontypeinstances.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.DeepCopyable;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = IJSONStringTypeInstance.class, name = "IJSONStringTypeInstance"),
		@Type(value = IJSONSetTypeInstance.class, name = "IJSONSetTypeInstance"),
		@Type(value = IJSONListTypeInstance.class, name = "IJSONListTypeInstance"),
		@Type(value = IJSONIntegerTypeInstance.class, name = "IJSONIntegerTypeInstance"),
		@Type(value = IJSONDoubleTypeInstance.class, name = "IJSONDoubleTypeInstance"),
		@Type(value = IJSONComplexTypeInstance.class, name = "IJSONComplexTypeInstance"),
		@Type(value = IJSONBooleanTypeInstance.class, name = "IJSONBooleanTypeInstance") })
public interface IJSONTypeInstance extends DeepCopyable {

	String getDataTypeID();

	void setDataTypeID(String dataTypeID);

	String getName();

	void setName(String name);

	String getInstanceID();

	void setInstanceID(String instanceID);

	String getTypeClass();

	void setTypeClass(String className);

	/**
	 * Makes a instance specific to their implementation.
	 * 
	 * @param instanceFactory
	 *            the instance factory which should e used
	 * @return
	 */
	DataTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);

	Object getValueAsObject();

	String getValueString();

	String getValueStringComplete();

	DataTypeInstanceType getDataTypeInstanceType();

	void setDataTypeInstanceType(DataTypeInstanceType dataTypeInstanceType);

	IJSONType getDataType();

	void setDataType(IJSONType dataType);

	@Override
	IJSONTypeInstance makeCopy();

	/**
	 * trys to parse the value
	 * @param value
	 * @throws IllegalArgumentException
	 */
	void parseValue(String value) throws IllegalArgumentException;

}