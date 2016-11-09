package eu.vicci.process.model.util.serialization.jsontypes.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofia.DataType;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
	@Type(value = IJSONStringType.class, name = "IJSONStringType"),
	@Type(value = IJSONListType.class, name = "IJSONListType"),
	@Type(value = IJSONIntegerType.class, name = "IJSONIntegerType"),
	@Type(value = IJSONDoubleType.class, name = "IJSONDoubleType"),
	@Type(value = IJSONComplexType.class, name = "IJSONComplexType"),
	@Type(value = IJSONBooleanType.class, name = "IJSONBooleanType"),
	@Type(value = IJSONSetType.class, name = "IJSONSetType")
})
public interface IJSONType extends DeepCopyable {

	String getName();

	void setName(String name);

	String getID();

	void setID(String instanceID);

	String getTypeClass();

	void setTypeClass(String className);

	DataType makeDataType();

	DataTypeType getDataTypeType();

	void setDataTypeType(DataTypeType dataTypeType);
	
	@Override
	IJSONType makeCopy();

}