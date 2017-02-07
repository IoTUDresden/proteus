package eu.vicci.process.model.util.serialization.jsontypes;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONListType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONListType extends JSONType implements IJSONListType {
	@JsonDeserialize(as=JSONType.class)
	private IJSONType collectionType;
	
	public JSONListType() {
		super();
	}

	public JSONListType(ListType listType) {
		super(listType);
		collectionType = JSONTypeSerializer.makeJSONType(listType.getCollectionItemType());		
	}

	@Override
	public ListType makeDataType() {
		ListType lti = SofiaFactory.eINSTANCE.createListType();		
		addBaseInformationsToDataType(lti);
		lti.setCollectionItemType(collectionType.makeDataType());
		return lti;
	}

	@Override
	public IJSONType getCollectionType() {
		return collectionType;
	}

	@Override
	public void setCollectionType(IJSONType collectionType) {
		this.collectionType = collectionType;
	}
	
	@Override
	public IJSONListType makeCopy() {
		IJSONListType copy = new JSONListType();
		copyBaseInformationsToJson(copy);
		copy.setCollectionType(collectionType.makeCopy());
		return copy;
	}
}
