package eu.vicci.process.model.util.serialization.jsontypes;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.util.serialization.JSONSerializer;
import eu.vicci.process.model.util.serialization.jsontypes.core.IJSONType;

public class JSONMapping {		
	private String id;
	private String name;
	
	@JsonDeserialize(as=JSONType.class)
	private IJSONType source;
	@JsonDeserialize(as=JSONType.class)
	private IJSONType target;

	public JSONMapping(DataMapping mapping) {
		id = mapping.getId();
		name = mapping.getName();
		String sourceId = mapping.getSource().getId();
		String targetId = mapping.getTarget().getId();
		if(!JSONSerializer.hasProcessed(sourceId)){
			JSONSerializer.addToProcessed(sourceId, mapping.getSource());
			source = (IJSONType) JSONSerializer.getProcessed(sourceId);
		}
		if(!JSONSerializer.hasProcessed(targetId)){
			JSONSerializer.addToProcessed(targetId, mapping.getTarget());
			target = (IJSONType) JSONSerializer.getProcessed(targetId);
		}
	}
	
	public DataMapping makeMapping(){
		DataMapping result = SofiaFactory.eINSTANCE.createDataMapping();
		result.setId(id);
		result.setName(name);
		result.setSource(source.makeDataType());
		result.setTarget(target.makeDataType());
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IJSONType getSource() {
		return source;
	}

	public void setSource(IJSONType source) {
		this.source = source;
	}

	public IJSONType getTarget() {
		return target;
	}

	public void setTarget(IJSONType target) {
		this.target = target;
	}
}
