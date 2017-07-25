package eu.vicci.process.model.util.messages;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.JSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public class StateChangeMessage extends WampMessage implements IStateChangeMessage {
	
	private String peerId;
	private String instanceId;
	private String modelId;
	private String processInstanceId;
	private String processModelId;
	private String processId;
	private String processName;
	private State state;
	private String originalProcessInstanceId;
	
	//Map of PortID and DataInstance
	@JsonDeserialize(as=HashMap.class, keyAs=String.class, contentAs=JSONDataPortInstance.class)
	private Map<String, IJSONDataPortInstance> startDataPorts = new HashMap<String, IJSONDataPortInstance>();
	
	//Map of PortID and DataInstance
	@JsonDeserialize(as=HashMap.class, keyAs=String.class, contentAs=JSONDataPortInstance.class)
	private Map<String, IJSONDataPortInstance> endDataPorts = new HashMap<String, IJSONDataPortInstance>();		
	
	@JsonDeserialize(as=HashMap.class, keyAs=String.class, contentAs=JSONPortInstance.class)
	private Map<String, IJSONPortInstance> startControlPorts = new HashMap<String, IJSONPortInstance>();
	@JsonDeserialize(as=HashMap.class, keyAs=String.class, contentAs=JSONPortInstance.class)
	private Map<String, IJSONPortInstance> endControlPorts = new HashMap<String, IJSONPortInstance>();
	
	public StateChangeMessage() {	}
	
	public StateChangeMessage(String topic, String instanceId, String modelId,
			String processInstanceId, String processModelId, State state,
			Map<String, IJSONDataPortInstance> startDataPorts, Map<String, IJSONDataPortInstance> endDataPorts) {
		this.instanceId = instanceId;
		this.modelId = modelId;
		this.processInstanceId = processInstanceId;
		this.processModelId = processModelId;
		this.state = state;
		this.startDataPorts = startDataPorts;
		this.endDataPorts = endDataPorts;
	}

	@Override
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	@Override
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	public String getProcessModelId() {
		return processModelId;
	}

	public void setProcessModelId(String processModelId) {
		this.processModelId = processModelId;
	}

	@Override
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@Override
	public Map<String, IJSONDataPortInstance> getStartDataPorts() {
		return startDataPorts;
	}

	public void setStartDataPorts(Map<String, IJSONDataPortInstance> startDataPorts) {
		this.startDataPorts = startDataPorts;
	}

	@Override
	public Map<String, IJSONDataPortInstance> getEndDataPorts() {
		return endDataPorts;
	}

	public void setEndDataPorts(Map<String, IJSONDataPortInstance> endDataPorts) {
		this.endDataPorts = endDataPorts;
	}

	@Override
	public String getProcessId() {
		return processId;		
	}
	
	public void setProcessId(String processId){
		this.processId = processId;
	}

	@Override
	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Override
	public Map<String, IJSONPortInstance> getStartControlPorts() {
		return startControlPorts;
	}

	@Override
	public Map<String, IJSONPortInstance> getEndControlPorts() {
		return endControlPorts;
	}

	public void setStartControlPorts(Map<String, IJSONPortInstance> startControlPorts) {
		this.startControlPorts = startControlPorts;
	}

	public void setEndControlPorts(Map<String, IJSONPortInstance> endControlPorts) {
		this.endControlPorts = endControlPorts;
	}

	@Override
	public String getPeerId() {
		return peerId;
	}

	public void setPeerId(String peerId) {
		this.peerId = peerId;
	}

	@Override
	public String getOriginalProcessInstanceId() {
		return originalProcessInstanceId;
	}
	
	public void setOriginalProcessInstanceId(String originalProcessInstanceId) {
		this.originalProcessInstanceId = originalProcessInstanceId;
	}

}
