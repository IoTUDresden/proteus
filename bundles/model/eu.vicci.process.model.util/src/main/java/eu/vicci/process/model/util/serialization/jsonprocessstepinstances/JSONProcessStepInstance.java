package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONProcessStepInstance;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({ @Type(value = JSONEventInstance.class, name = "JSONEventInstance"),
	@Type(value = JSONIfInstance.class, name = "JSONIfInstance")})
public class JSONProcessStepInstance implements IJSONProcessStepInstance {
	private static final Logger LOG = LoggerFactory.getLogger(JSONProcessStepInstance.class);
	@JsonIgnore
	private static final String ERROR_MSG = "ERROR: Cant completely deserialize the JSONProcessStepInstance - FIXME\n";
	
	private long delay;
	private int executionState;
	private int instanceNumber;
	private int executionPermission;
	private String processInstanceId;
	private String processModelId;
	private String instanceId;
	private String modelId;
	private String type;
	private String simpleTypeName;	

	@JsonDeserialize(contentAs=JSONProcessStepInstance.class)
	private List<IJSONProcessStepInstance> subSteps = new ArrayList<IJSONProcessStepInstance>();
	@JsonDeserialize(contentAs=JSONPortInstance.class)
	private List<IJSONPortInstance> ports = new ArrayList<IJSONPortInstance>();

	public JSONProcessStepInstance() {
	}
	
	public JSONProcessStepInstance(ProcessStepInstance stepInstance) {
		type = stepInstance.getClass().getCanonicalName();
		simpleTypeName = stepInstance.getClass().getSimpleName();
		delay = stepInstance.getDelay();
		executionState = stepInstance.getExecutionState().getValue();
		instanceId = stepInstance.getInstanceId();
		instanceNumber = stepInstance.getInstancenumber();
		executionPermission = stepInstance.getPermission().getValue();
		processInstanceId = stepInstance.getProcessInstanceID();
		processModelId = stepInstance.getProcessModelID();
		modelId = stepInstance.getProcessStepType().getId();		
		
		JSONProcessStepInstanceSerializer.alreadySerialized.put(instanceId, this);
		
		for (ProcessStepInstance subStep : stepInstance.getSubSteps()) {
			if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(subStep.getInstanceId()))
				subSteps.add((JSONProcessStepInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(subStep.getInstanceId()));
			else
				subSteps.add(new JSONProcessStepInstance(subStep));
		}
		
		for(PortInstance port : stepInstance.getPorts()){
			if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(port.getInstanceId()))
				ports.add((IJSONPortInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(port.getInstanceId()));
			else
				ports.add(JSONProcessStepInstanceSerializer.makeJSONPortInstance(port));
		}
	}

	@Override
	public ProcessStepInstance makeProcessStepInstance(SofiaInstanceFactory factory){
		ProcessStepInstance result = null;
		if(JSONProcessStepInstanceSerializer.alreadyInstanciated.containsKey(instanceId)){
			return (ProcessStepInstance) JSONProcessStepInstanceSerializer.alreadyInstanciated.get(instanceId);
		}
		try{
			String tmpName = simpleTypeName;
			if(tmpName.contains("ImplCustom"))
				tmpName = tmpName.replace("ImplCustom", "");
			else if (tmpName.contains("Impl")) 
				tmpName.replace("Impl", "");				
			
			
			String methodName = "create" + tmpName;
			Method method = factory.getClass().getMethod(methodName);
			
			result = (ProcessStepInstance) method.invoke(factory);
			JSONProcessStepInstanceSerializer.alreadyInstanciated.put(instanceId, result);
			result.setDelay(delay);
			result.setPermission(ExecutionPermission.get(executionPermission));
			
			//FIXME unsupported in default factory
//			result.setExecutionState(State.get(executionState));
			result.setInstanceId(instanceId);
			result.setInstancenumber(instanceNumber);
			result.setProcessInstanceID(processInstanceId);
			result.setProcessModelID(processModelId);
			for (IJSONPortInstance jsonPort : ports)
				result.getPorts().add(jsonPort.makePortInstance(factory));
			
			for(IJSONProcessStepInstance subStep : subSteps){
				ProcessStepInstance tmp = subStep.makeProcessStepInstance(factory);
				if(tmp != null)
					result.getSubSteps().add(tmp);
			}
		}
		catch (NoSuchMethodException e) {
			LOG.error("Cant find method on SofiaFactory: {}", e.getMessage());
			LOG.error(ERROR_MSG);
		}catch(Exception e){
			LOG.error(ERROR_MSG);
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public long getDelay() {
		return delay;
	}

	@Override
	public void setDelay(long delay) {
		this.delay = delay;
	}

	@Override
	public int getState() {
		return executionState;
	}

	@Override
	public void setState(int state) {
		this.executionState = state;
	}

	@Override
	public String getInstanceId() {
		return instanceId;
	}

	@Override
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	@Override
	public int getInstanceNumber() {
		return instanceNumber;
	}

	@Override
	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}

	@Override
	public int getPermission() {
		return executionPermission;
	}

	@Override
	public void setPermission(int permission) {
		this.executionPermission = permission;
	}

	@Override
	public String getProcessInstanceId() {
		return processInstanceId;
	}

	@Override
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}

	@Override
	public String getProcessModelId() {
		return processModelId;
	}

	@Override
	public void setProcessModelId(String processModelId) {
		this.processModelId = processModelId;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public List<IJSONProcessStepInstance> getSubSteps() {
		return subSteps;
	}

	@Override
	public void setSubSteps(List<IJSONProcessStepInstance> subSteps) {
		this.subSteps = subSteps;
	}

	@Override
	public String getModelId() {
		return modelId;
	}

	@Override
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	@Override
	public String getSimpleTypeName() {
		return simpleTypeName;
	}
	@Override
	public void setSimpleTypeName(String simpleTypeName) {
		this.simpleTypeName = simpleTypeName;
	}

	@Override
	public List<IJSONPortInstance> getPorts() {
		return ports;
	}

	@Override
	public void setPorts(List<IJSONPortInstance> ports) {
		this.ports = ports;
	}
}
