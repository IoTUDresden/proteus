package eu.vicci.process.model.util.serialization.jsonprocessstepinstances;

import org.codehaus.jackson.map.annotate.JsonDeserialize;

import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONIfInstance;
import eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core.IJSONPortInstance;

public class JSONIfInstance extends JSONProcessStepInstance implements IJSONIfInstance{
	@JsonDeserialize(as=JSONPortInstance.class)
	private IJSONPortInstance leftSide;
	@JsonDeserialize(as=JSONPortInstance.class)
	private IJSONPortInstance rightSide;
	private String expressionInstance;
	private int comparator;
	private boolean result;
	
	public JSONIfInstance() {
		super();
	}

	public JSONIfInstance(IfInstance stepInstance) {
		super(stepInstance);
		ConditionInstance conditionInstance = stepInstance.getIfConditionInstance();
		if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(conditionInstance.getLeftSide().getInstanceId()))
			leftSide = (IJSONPortInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(conditionInstance.getLeftSide().getInstanceId());
		else
			leftSide = new JSONPortInstance(conditionInstance.getLeftSide());
		
		if(JSONProcessStepInstanceSerializer.alreadySerialized.containsKey(conditionInstance.getRightSide().getInstanceId()))
			rightSide = (IJSONPortInstance) JSONProcessStepInstanceSerializer.alreadySerialized.get(conditionInstance.getRightSide().getInstanceId());
		else
			rightSide = new JSONPortInstance(conditionInstance.getRightSide());
			
		expressionInstance = conditionInstance.getExpressionInstance();
		result = conditionInstance.isResult();
	}
	
	@Override
	public IfInstance makeEventInstance(SofiaInstanceFactory factory){
		IfInstance ifInstance = (IfInstance) super.makeProcessStepInstance(factory);
		ConditionInstance conditionInstance = factory.createConditionInstance();
		conditionInstance.setLeftSide((StartDataPortInstance) leftSide.makePortInstance(factory));
		conditionInstance.setRightSide((StartDataPortInstance) leftSide.makePortInstance(factory));
		conditionInstance.setResult(result);
		ifInstance.setIfConditionInstance(conditionInstance);
		return ifInstance;		
	}

	@Override
	public IJSONPortInstance getLeftSide() {
		return leftSide;
	}

	@Override
	public void setLeftSide(IJSONPortInstance leftSide) {
		this.leftSide = leftSide;
	}

	@Override
	public IJSONPortInstance getRightSide() {
		return rightSide;
	}

	@Override
	public void setRightSide(IJSONPortInstance rightSide) {
		this.rightSide = rightSide;
	}

	@Override
	public String getExpressionInstance() {
		return expressionInstance;
	}

	@Override
	public void setExpressionInstance(String expressionInstance) {
		this.expressionInstance = expressionInstance;
	}

	@Override
	public int getComparator() {
		return comparator;
	}

	@Override
	public void setComparator(int comparator) {
		this.comparator = comparator;
	}

	@Override
	public boolean isResult() {
		return result;
	}

	@Override
	public void setResult(boolean result) {
		this.result = result;
	}

}
