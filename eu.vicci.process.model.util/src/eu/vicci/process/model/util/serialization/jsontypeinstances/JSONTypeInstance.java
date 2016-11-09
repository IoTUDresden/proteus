package eu.vicci.process.model.util.serialization.jsontypeinstances;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.DataTypeInstanceType;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypes.JSONType;
import eu.vicci.process.model.util.serialization.jsontypes.JSONTypeSerializer;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

/**
 * Base class for de-/serializing {@link DataTypeInstance}s
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
@JsonSubTypes({
	@Type( value=JSONIntegerTypeInstance.class, name="JSONIntegerTypeInstance"),
	@Type( value=JSONStringTypeInstance.class, name="JSONStringTypeInstance"),
	@Type( value=JSONBooleanTypeInstance.class, name="JSONBooleanTypeInstance"),
	@Type( value=JSONDoubleTypeInstance.class, name="JSONDoubleTypeInstance"),
	@Type( value=JSONListTypeInstance.class, name="JSONListTypeInstance"),
	@Type( value=JSONComplexTypeInstance.class, name="JSONComplexTypeInstance"),
	@Type( value=JSONSetTypeInstance.class, name="JSONSetTypeInstance")
})
public abstract class JSONTypeInstance implements IJSONTypeInstance {
	private String name;
	private String dataTypeID;
	private String instanceID;
	// FIXME using the json annotation will make this easier
	//after removing, check if all rpc´s still work
	@Deprecated
	private String typeClass;
	private DataTypeInstanceType dataTypeInstanceType;
	
	@JsonDeserialize(as=JSONType.class)
	private IJSONType dataType;

	public JSONTypeInstance() {
	}

	public JSONTypeInstance(DataTypeInstance dataType) {
		this.name = dataType.getName();
		this.dataTypeID = dataType.getTypeId();
		this.instanceID = dataType.getInstanceId();
		this.typeClass = this.getClass().getCanonicalName();
		setDataTypeInstanceAndDataType(dataType);
	}

	@Override
	public String getDataTypeID() {
		return dataTypeID;
	}

	@Override
	public void setDataTypeID(String dataTypeID) {
		this.dataTypeID = dataTypeID;
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
	public String getInstanceID() {
		return instanceID;
	}

	@Override
	public void setInstanceID(String instanceID) {
		this.instanceID = instanceID;
	}

	@Override
	public String getTypeClass() {
		return typeClass;
	}

	@Override
	public void setTypeClass(String className) {
		this.typeClass = className;
	}

	/**
	 * Makes a instance specific to their implementation.
	 * 
	 * @param instanceFactory
	 *            the instance factory which should e used
	 * @return
	 */
	@Override
	public abstract DataTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory);
	
	@Override
	@JsonIgnore
	public abstract Object getValueAsObject();

	protected void addBaseInformationsToDataTypeInstance(DataTypeInstance dti) {
		dti.setInstanceId(instanceID);
		dti.setName(name);
		dti.setTypeId(dataTypeID);
		dti.setDataTypeType(dataType.makeDataType());
	}
	
	/**
	 * Needed for the deep copy. Copys some things like instance id, name, type id, ...
	 * Immutable objects are the same, other objects are copied.
	 */
	protected void copyBaseInformationsToJson(IJSONTypeInstance newInstance){
		newInstance.setInstanceID(instanceID);
		newInstance.setName(name);
		newInstance.setDataTypeID(dataTypeID);
		newInstance.setDataTypeInstanceType(dataTypeInstanceType);
		newInstance.setDataType(dataType.makeCopy());
	}

	@Override
	@JsonIgnore
	public String getValueString() {
		return getValueStringComplete().replace("_instance", "");
	}

	@Override
	@JsonIgnore
	public abstract String getValueStringComplete();

	@Override
	public DataTypeInstanceType getDataTypeInstanceType() {
		return dataTypeInstanceType;
	}

	@Override
	public void setDataTypeInstanceType(DataTypeInstanceType dataTypeInstanceType) {
		this.dataTypeInstanceType = dataTypeInstanceType;
	}
	
	private void setDataTypeInstanceAndDataType(DataTypeInstance dataTypeInstance) {
		if (dataTypeInstance instanceof StringTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.StringTypeInstance;
		else if (dataTypeInstance instanceof DoubleTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.DoubleTypeInstance;
		else if (dataTypeInstance instanceof BooleanTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.BooleanTypeInstance;
		else if (dataTypeInstance instanceof SetTypeInstance) 
			dataTypeInstanceType = DataTypeInstanceType.SetTypeInstance;
		else if (dataTypeInstance instanceof ComplexTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.ComplexTypeInstance;
		else if (dataTypeInstance instanceof IntegerTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.IntegerTypeInstance;
		else if (dataTypeInstance instanceof ListTypeInstance)
			dataTypeInstanceType = DataTypeInstanceType.ListTypeInstance;		
		else
			throw new IllegalArgumentException("Not know type for serialization dto: " + dataTypeInstance.getClass());
		
		dataType = JSONTypeSerializer.makeJSONType(dataTypeInstance.getDataTypeType());
	}

	@Override
	public IJSONType getDataType() {
		return dataType;
	}

	@Override
	public void setDataType(IJSONType dataType) {
		this.dataType = dataType;
	}

}
