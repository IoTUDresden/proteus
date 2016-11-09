package eu.vicci.process.model.util.serialization.jsontypeinstances;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONComplexTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class JSONComplexTypeInstance extends JSONTypeInstance implements IJSONComplexTypeInstance {
	@JsonDeserialize(contentAs=JSONTypeInstance.class)
	private List<IJSONTypeInstance> subTypes = new ArrayList<IJSONTypeInstance>();

	public JSONComplexTypeInstance() {
		super();
	}

	public JSONComplexTypeInstance(ComplexTypeInstance complexType) {
		super(complexType);
		addSubtypes(complexType);
	}

	@Override
	public List<IJSONTypeInstance> getSubTypes() {
		return subTypes;
	}

	@Override
	public void setSubTypes(List<IJSONTypeInstance> subTypes) {
		this.subTypes = subTypes;
	}

	@Override
	public ComplexTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		ComplexTypeInstance cti = instanceFactory.createComplexTypeInstance();
		for (IJSONTypeInstance subType : subTypes)
			cti.getSubtypes().add(subType.makeDataTypeInstance(instanceFactory));
		addBaseInformationsToDataTypeInstance(cti);
		addBelongsTo(cti);
		return cti;
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
	public Object getValueAsObject() {
		// Complex Types contains no direct values
		return null;
	}

	private void addBelongsTo(ComplexTypeInstance parent) {
		for (DataTypeInstance child : parent.getSubtypes())
			child.setBelongsTo(parent);
	}

	private void addSubtypes(ComplexTypeInstance complexType) {
		for (DataTypeInstance subtype : complexType.getSubtypes())
			subTypes.add(JSONTypeInstanceSerializer.makeJSONTypeInstance(subtype));
	}

	@Override
	public IJSONComplexTypeInstance makeCopy() {
		IJSONComplexTypeInstance copy = new JSONComplexTypeInstance();
		copyBaseInformationsToJson(copy);
		copySubTypes(copy);
		return copy;
	}
	
	private void copySubTypes(IJSONComplexTypeInstance newInstance){
		List<IJSONTypeInstance> newSubs = new ArrayList<IJSONTypeInstance>();
		for (IJSONTypeInstance sub : subTypes)
			newSubs.add(sub.makeCopy());			
		newInstance.setSubTypes(newSubs);
	}
	
	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		throw new IllegalArgumentException("String cannot be parsed to complex type");
	}
}
