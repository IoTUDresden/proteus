package eu.vicci.process.model.util.serialization.jsontypes;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.util.serialization.JSONSerializer;
import eu.vicci.process.model.util.serialization.jsontypes.core.DataTypeType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = JSONIntegerType.class, name = "JSONIntegerType"),
		@Type(value = JSONStringType.class, name = "JSONStringType"),
		@Type(value = JSONBooleanType.class, name = "JSONBooleanType"),
		@Type(value = JSONDoubleType.class, name = "JSONDoubleType"),
		@Type(value = JSONListType.class, name = "JSONListType"),
		@Type(value = JSONComplexType.class, name = "JSONComplexType"),
		@Type(value = JSONSetType.class, name = "JSONSetType") })
public abstract class JSONType implements IJSONType {
	private String name;
	private String id;
	private String typeClass;
	private DataTypeType dataTypeType;

	public JSONType() {
	}

	public JSONType(DataType dataType) {
		name = dataType.getName();
		id = dataType.getId();
		typeClass = this.getClass().getCanonicalName();
		setPrivateDataTypeType(dataType);
		JSONSerializer.addToProcessed(id, this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getID() {
		return id;
	}

	@Override
	public void setID(String instanceID) {
		this.id = instanceID;
	}

	@Override
	public String getTypeClass() {
		return typeClass;
	}

	@Override
	public void setTypeClass(String className) {
		this.typeClass = className;
	}

	@Override
	public abstract DataType makeDataType();

	protected void addBaseInformationsToDataType(DataType dti) {
		dti.setId(id);
		dti.setName(name);
	}
	
	/**
	 * Used for deep copy
	 * @param type
	 */
	protected void copyBaseInformationsToJson(IJSONType type){
		type.setID(id);
		type.setName(name);
		type.setDataTypeType(dataTypeType);		
	}

	@Override
	public DataTypeType getDataTypeType() {
		return dataTypeType;
	}

	@Override
	public void setDataTypeType(DataTypeType dataTypeType) {
		this.dataTypeType = dataTypeType;
	}

	private void setPrivateDataTypeType(DataType dataType) {
		if (dataType instanceof StringType)
			dataTypeType = DataTypeType.StringType;
		else if (dataType instanceof DoubleType)
			dataTypeType = DataTypeType.DoubleType;
		else if (dataType instanceof BooleanType)
			dataTypeType = DataTypeType.BooleanType;
		else if (dataType instanceof SetType)
			dataTypeType = DataTypeType.SetType;
		else if (dataType instanceof ComplexType)
			dataTypeType = DataTypeType.ComplexType;
		else if (dataType instanceof IntegerType)
			dataTypeType = DataTypeType.IntegerType;
		else if (dataType instanceof ListType)
			dataTypeType = DataTypeType.ListType;
		else
			throw new IllegalArgumentException("Not know type for serialization dto: " + dataType.getClass());
	}

}
