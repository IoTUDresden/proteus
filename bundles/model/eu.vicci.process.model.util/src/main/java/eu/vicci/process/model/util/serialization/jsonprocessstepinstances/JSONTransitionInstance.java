package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.FalseTransitionInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.TrueTransitionInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONTransitionInstance;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class JSONTransitionInstance implements IJSONTransitionInstance {
	private String instanceId;
	private int instanceNumber;
	private String type;

	@JsonDeserialize(as=JSONPortInstance.class)
	private IJSONPortInstance sourcePortInstance;
	@JsonDeserialize(as=JSONPortInstance.class)
	private IJSONPortInstance targetPortInstance;
	
	public JSONTransitionInstance() {
		super();
	}

	public JSONTransitionInstance(TransitionInstance transition) {
		instanceId = transition.getInstanceId();
		type = transition.getClass().getCanonicalName();
		instanceNumber = transition.getInstancenumber();
		
		JSONProcessStepInstanceSerializer.alreadySerialized.put(instanceId, this);		
		
		if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(transition.getSourcePortInstance().getInstanceId()))
			sourcePortInstance = (IJSONPortInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(transition.getSourcePortInstance().getInstanceId());
		else
			sourcePortInstance = new JSONPortInstance(transition.getSourcePortInstance());
		
		if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(transition.getTargetPortInstance().getInstanceId()))
			targetPortInstance = (IJSONPortInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(transition.getTargetPortInstance().getInstanceId());
		else
			targetPortInstance = new JSONPortInstance(transition.getTargetPortInstance());		
	}
	
	@Override
	public TransitionInstance makeTransitionInstance(SofiaInstanceFactory factory){
		TransitionInstance transition = null;
		if(instanceId != null && JSONProcessStepInstanceSerializer.alreadyInstanciated.containsKey(instanceId))
			return (TransitionInstance) JSONProcessStepInstanceSerializer.alreadyInstanciated.get(instanceId);
		
		if(TrueTransitionInstance.class.getCanonicalName().equals(type))
			transition = factory.createTrueTransitionInstance();
		if(FalseTransitionInstance.class.getCanonicalName().equals(type))
			transition = factory.createFalseTransitionInstance();
		else
			transition = factory.createTransitionInstance();
		
		transition.setInstanceId(instanceId);
		transition.setInstancenumber(instanceNumber);
		transition.setSourcePortInstance(sourcePortInstance.makePortInstance(factory));
		transition.setTargetPortInstance(targetPortInstance.makePortInstance(factory));
		
		JSONProcessStepInstanceSerializer.alreadyInstanciated.put(instanceId, transition);
		return transition;		
	}
	
	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public int getInstanceNumber() {
		return instanceNumber;
	}

	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IJSONPortInstance getSourcePortInstance() {
		return sourcePortInstance;
	}

	public void setSourcePortInstance(IJSONPortInstance sourcePortInstance) {
		this.sourcePortInstance = sourcePortInstance;
	}

	public IJSONPortInstance getTargetPortInstance() {
		return targetPortInstance;
	}

	public void setTargetPortInstance(IJSONPortInstance targetPortInstance) {
		this.targetPortInstance = targetPortInstance;
	}

}
