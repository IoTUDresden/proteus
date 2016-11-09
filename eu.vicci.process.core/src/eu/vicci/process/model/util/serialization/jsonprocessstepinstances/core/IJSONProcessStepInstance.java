package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
@JsonSubTypes({
	@Type(value = IJSONEventInstance.class, name = "IJSONEventInstance"),
	@Type(value = IJSONIfInstance.class, name = "IJSONIfInstance")
	})
public interface IJSONProcessStepInstance {
	ProcessStepInstance makeProcessStepInstance(SofiaInstanceFactory factory);

	long getDelay();

	void setDelay(long delay);

	int getState();

	void setState(int state);

	String getInstanceId();

	void setInstanceId(String instanceId);

	int getInstanceNumber();

	void setInstanceNumber(int instanceNumber);

	int getPermission();

	void setPermission(int permission);

	String getProcessInstanceId();

	void setProcessInstanceId(String processInstanceId);

	String getProcessModelId();

	void setProcessModelId(String processModelId);

	String getType();

	void setType(String type);

	List<IJSONProcessStepInstance> getSubSteps();

	void setSubSteps(List<IJSONProcessStepInstance> subSteps);

	String getModelId();

	void setModelId(String modelId);

	String getSimpleTypeName();

	void setSimpleTypeName(String simpleTypeName);
	
	List<IJSONPortInstance> getPorts();
	
	void setPorts(List<IJSONPortInstance> ports);

}