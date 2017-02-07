package eu.vicci.process.model.util.serialization.jsontypeinstances;

import java.util.LinkedHashSet;
import java.util.Set;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONSetTypeInstance;
import eu.vicci.process.model.util.serialization.jsontypeinstances.core.IJSONTypeInstance;

public class JSONSetTypeInstance extends JSONTypeInstance implements IJSONSetTypeInstance {

	@JsonDeserialize(as=LinkedHashSet.class, contentAs = JSONTypeInstance.class)
	private Set<IJSONTypeInstance> subTypes;

	public JSONSetTypeInstance() {
		super();
	}

	public JSONSetTypeInstance(SetTypeInstance dataTypeInstance) {
		super(dataTypeInstance);
	}

	@Override
	public SetTypeInstance makeDataTypeInstance(SofiaInstanceFactory instanceFactory) {
		SetTypeInstance setTypeInstance = instanceFactory.createSetTypeInstance();
		addBaseInformationsToDataTypeInstance(setTypeInstance);
		return setTypeInstance;
	}

	@Override
	public Set<IJSONTypeInstance> getValueAsObject() {
		return subTypes;
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
	public Set<IJSONTypeInstance> getSubTypes() {
		return subTypes;
	}

	@Override
	public void setSubTypes(Set<IJSONTypeInstance> subTypes) {
		this.subTypes = subTypes;
	}
	
	@Override
	public IJSONSetTypeInstance makeCopy() {
		IJSONSetTypeInstance copy = new JSONSetTypeInstance();
		copyBaseInformationsToJson(copy);
		copySubTypes(copy);
		return copy;
	}
	
	private void copySubTypes(IJSONSetTypeInstance newInstance){
		Set<IJSONTypeInstance> newSubs = new LinkedHashSet<IJSONTypeInstance>();
		for (IJSONTypeInstance sub : subTypes)
			newSubs.add(sub.makeCopy());			
		newInstance.setSubTypes(newSubs);
	}

	@Override
	public void parseValue(String value) throws IllegalArgumentException {
		throw new IllegalArgumentException("String cannot be parsed to a set at the moment");		
	}

}
