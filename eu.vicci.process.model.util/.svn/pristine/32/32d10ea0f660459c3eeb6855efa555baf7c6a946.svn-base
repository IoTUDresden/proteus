package eu.vicci.process.model.util.serialization.jsontypeinstances;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONListTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypes.JSONType;
import eu.vicci.process.model.util.serialization.jsontypes.JSONTypeSerializer;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONListType;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONListTypeInstance extends JSONTypeInstance implements IJSONListTypeInstance {
	@JsonDeserialize(contentAs = JSONTypeInstance.class)
	private List<IJSONTypeInstance> subTypes = new ArrayList<IJSONTypeInstance>();
	@JsonDeserialize(as = JSONType.class)
	private IJSONType collectionType;

	public JSONListTypeInstance() {
		super();
	}

	public JSONListTypeInstance(ListTypeInstance listType) {
		super(listType);
		DataType collectionTypeDT = detectCollectionItemType(listType);
		if (collectionTypeDT == null)
			throw new IllegalArgumentException("the collection item type should not be null");
		collectionType = JSONTypeSerializer.makeJSONType(collectionTypeDT);
		addSubTypes(listType);
	}
	
	//FIXME the collection item type will be null for the list type in the 'ClientTest' 
	//in the client project - check why this happes
	private DataType detectCollectionItemType(ListTypeInstance listType){
		DataType dt = listType.getCollectionItemType();
		if(dt == null)
			dt = ((CollectionType)listType.getDataTypeType()).getCollectionItemType();
		return dt;		
	}

	private void addSubTypes(ListTypeInstance listType) {
		for (DataTypeInstance dataTypeInstance : listType.getSubtypes())
			subTypes.add(JSONTypeInstanceSerializer.makeJSONTypeInstance(dataTypeInstance));
	}

	@Override
	public List<IJSONTypeInstance> getSubTypes() {
		return subTypes;
	}

	@Override
	public void setSubTypes(List<IJSONTypeInstance> list) {
		this.subTypes = list;
	}

	@Override
	public List<IJSONTypeInstance> getValueAsObject() {
		return subTypes;
	}
	
	@Override
	public IJSONListType getDataType() {
		return (IJSONListType)super.getDataType();
	}

	@Override
	public ListTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		ListTypeInstance lti = instanceFactory.createListTypeInstance();

		for (IJSONTypeInstance subType : subTypes)
			lti.getSubtypes().add(subType.makeDataTypeInstance(instanceFactory));

		lti.setCollectionItemType(collectionType.makeDataType());
		addBaseInformationsToDataTypeInstance(lti);
		return lti;
	}

	@Override
	public String toString() {
		String subTypeString = "";
		for (IJSONTypeInstance subType : subTypes) {
			subTypeString = subTypeString + subType.toString() + "\n";
		}
		return this.getClass().getSimpleName() + "[ Elements: {\n" + subTypeString + "}, InstanceID:"
				+ this.getInstanceID() + "]";
	}

	@Override
	public String getValueStringComplete() {
		String result = "";
		for (IJSONTypeInstance item : subTypes) {
			result = result + item.getValueStringComplete() + ", ";
		}
		if (result.endsWith(", "))
			result = result.substring(0, result.length() - 2);
		return result;
	}

	@Override
	public String getValueString() {
		String result = "";
		for (IJSONTypeInstance item : subTypes)
			result = result + item.getValueString() + ", ";
		if (result.endsWith(", "))
			result = result.substring(0, result.length() - 2);
		return result;
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
	public IJSONListTypeInstance makeCopy() {
		IJSONListTypeInstance copy = new JSONListTypeInstance();
		copyBaseInformationsToJson(copy);
		copySubTypes(copy);
		copy.setCollectionType(collectionType.makeCopy());
		return copy;
	}
	
	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		throw new IllegalArgumentException("String cannot be parsed to a list at the moment");		
	}
	
	private void copySubTypes(IJSONListTypeInstance newInstance){
		List<IJSONTypeInstance> newSubs = new ArrayList<IJSONTypeInstance>();
		for (IJSONTypeInstance sub : subTypes)
			newSubs.add(sub.makeCopy());			
		newInstance.setSubTypes(newSubs);
	}
}
