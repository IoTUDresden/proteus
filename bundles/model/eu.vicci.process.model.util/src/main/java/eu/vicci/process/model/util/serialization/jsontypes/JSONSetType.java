package eu.vicci.process.model.util.serialization.jsontypes;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONSetType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONSetType extends JSONType implements IJSONSetType {
	@JsonDeserialize(as=JSONType.class)
	private IJSONType collectionType;
	
	public JSONSetType() {
		super();
	}
	
	public JSONSetType(SetType dataType) {
		super(dataType);
	}

	@Override
	public SetType makeDataType() {
		SetType setType = SofiaFactoryImpl.eINSTANCE.createSetType();
		setType.setCollectionItemType(collectionType.makeDataType());
		return setType;
	}

	@Override
	public IJSONSetType makeCopy() {
		IJSONSetType copy = new JSONSetType();
		copyBaseInformationsToJson(copy);
		copy.setCollectionType(collectionType.makeCopy());
		return copy;
	}

	@Override
	public IJSONType getCollectionType() {
		return collectionType;
	}

	@Override
	public void setCollectionType(IJSONType collectionType) {
		this.collectionType = collectionType;
	}

}
