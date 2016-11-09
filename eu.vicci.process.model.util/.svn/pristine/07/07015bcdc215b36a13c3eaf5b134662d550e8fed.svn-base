package eu.vicci.process.model.util.serialization.jsontypes;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONComplexType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONComplexType extends JSONType implements IJSONComplexType {
	@JsonDeserialize(contentAs=JSONType.class)
	private List<IJSONType> subTypes = new ArrayList<IJSONType>();

	public JSONComplexType() {
		super();
	}

	public JSONComplexType(ComplexType complexType) {
		super(complexType);
		addSubTypes(complexType);
	}

	private Class<?> getItemType(DataType subType) {
		if (subType instanceof IntegerType)
			return JSONIntegerType.class;
		if (subType instanceof StringType)
			return JSONStringType.class;
		if (subType instanceof BooleanType)
			return JSONBooleanType.class;
		if (subType instanceof DoubleType)
			return JSONDoubleType.class;
		if (subType instanceof ListType)
			return JSONListType.class;
		if (subType instanceof ComplexType)
			return JSONComplexType.class;
		throw new IllegalArgumentException(
				"type currently not supported for serialization: " + subType.getClass().getCanonicalName());
	}

	private void addSubTypes(ComplexType complexType) {
		try {
			for (DataType subType : complexType.getSubtypes()) {
				Constructor<?>[] constructors = getItemType(subType).getConstructors();
				for (Constructor<?> constructor : constructors) {
					if (constructor.getParameterTypes().length == 1) {
						subTypes.add((JSONType) constructor.newInstance(subType));
						break;
					}
				}
			}
		} catch (Exception e) {
			System.err.println("missing constructor for subtype of JSONType");
			e.printStackTrace();
		}
	}

	@Override
	public DataType makeDataType() {
		ComplexType ct = SofiaFactory.eINSTANCE.createComplexType();
		for (IJSONType subType : subTypes) {
			ct.getSubtypes().add(subType.makeDataType());
		}
		addBaseInformationsToDataType(ct);
		addBelongsTo(ct);
		return ct;
	}

	@Override
	public String toString() {
		String subTypeString = "";
		for (IJSONType subType : subTypes) {
			subTypeString = subTypeString + subType.toString() + "\n";
		}
		return this.getClass().getSimpleName() + "[ Elements: {\n" + subTypeString + "}, ID:" + this.getID() + "]";
	}

	@Override
	public List<IJSONType> getSubTypes() {
		return subTypes;
	}

	@Override
	public void setSubTypes(List<IJSONType> subTypes) {
		this.subTypes = subTypes;
	}
	
	@Override
	public IJSONComplexType makeCopy() {
		IJSONComplexType copy = new JSONComplexType();
		copyBaseInformationsToJson(copy);		
		copySubTypes(copy);		
		return copy;
	}
	
	private void copySubTypes(IJSONComplexType newInstance){
		List<IJSONType> subs = new ArrayList<IJSONType>();
		for (IJSONType sub : subTypes)
			subs.add(sub.makeCopy());
		newInstance.setSubTypes(subs);
	}
	
	private void addBelongsTo(ComplexType ct) {
		for (DataType type : ct.getSubtypes())
			type.setBelongsTo(ct);		
	}
}
