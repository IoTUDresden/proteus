package eu.vicci.process.model.util.serialization.jsontypeinstances;

import eu.vicci.process.model.util.serialization.jsontypeinstances.core.DataTypeInstanceType;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONBooleanTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONDoubleTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONIntegerTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONStringTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONBooleanType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONDoubleType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONIntegerType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONStringType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONTypeInstanceUtil {
	private static final String INSTANCE_SUFFIX = "_instance_";
	
	public static IJSONIntegerTypeInstance createIntegerTypeInstance(IJSONIntegerType type, int instanceNumber){
		IJSONIntegerTypeInstance newInstance = new JSONIntegerTypeInstance();
		copyBase(type, newInstance, instanceNumber);
		newInstance.setDataTypeInstanceType(DataTypeInstanceType.IntegerTypeInstance);
		return newInstance;
	}
	
	public static IJSONDoubleTypeInstance createDoubleTypeInstance(IJSONDoubleType type, int instanceNumber){
		IJSONDoubleTypeInstance newInstance = new JSONDoubleTypeInstance();
		copyBase(type, newInstance, instanceNumber);
		newInstance.setDataTypeInstanceType(DataTypeInstanceType.DoubleTypeInstance);
		return newInstance;
	}
	
	public static IJSONStringTypeInstance createStringTypeInstance(IJSONStringType type, int instanceNumber){
		IJSONStringTypeInstance newInstance = new JSONStringTypeInstance();
		copyBase(type, newInstance, instanceNumber);
		newInstance.setDataTypeInstanceType(DataTypeInstanceType.StringTypeInstance);
		return newInstance;
	}
	
	public static IJSONBooleanTypeInstance createBooleanTypeInstance(IJSONBooleanType type, int instanceNumber){
		IJSONBooleanTypeInstance newInstance = new JSONBooleanTypeInstance();
		copyBase(type, newInstance, instanceNumber);
		newInstance.setDataTypeInstanceType(DataTypeInstanceType.StringTypeInstance);
		return newInstance;
	}
	
	private static void copyBase(IJSONType type, IJSONTypeInstance typeInstance, int instanceNumber){
		typeInstance.setDataType(type);
		typeInstance.setDataTypeID(type.getID());
		typeInstance.setInstanceID(type.getID() + INSTANCE_SUFFIX + instanceNumber);
		typeInstance.setName(type.getName());
	}
	
	public static IJSONTypeInstance createTypeInstance(IJSONType type, int instanceNumber){
		IJSONTypeInstance newInstance = null;
		switch (type.getDataTypeType()) {
		case StringType:
			newInstance = createStringTypeInstance((IJSONStringType)type, instanceNumber);
			break;
		case DoubleType:	
			newInstance = createDoubleTypeInstance((IJSONDoubleType)type, instanceNumber);
			break;
		case IntegerType:
			newInstance = createIntegerTypeInstance((IJSONIntegerType)type, instanceNumber);
			break;
		case BooleanType:
			newInstance = createBooleanTypeInstance((IJSONBooleanType)type, instanceNumber);
			break;
		default:
			throw new IllegalArgumentException("currently not supported type: " + type.getDataTypeType().name());
		}
		copyBase(type, newInstance, instanceNumber);
		return newInstance;		
	}

}
