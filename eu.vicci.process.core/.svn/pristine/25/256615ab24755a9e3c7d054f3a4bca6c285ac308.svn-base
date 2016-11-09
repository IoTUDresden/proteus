package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;

public interface IJSONIfInstance extends IJSONProcessStepInstance {

	IfInstance makeEventInstance(SofiaInstanceFactory factory);

	IJSONPortInstance getLeftSide();

	void setLeftSide(IJSONPortInstance leftSide);

	IJSONPortInstance getRightSide();

	void setRightSide(IJSONPortInstance rightSide);

	String getExpressionInstance();

	void setExpressionInstance(String expressionInstance);

	int getComparator();

	void setComparator(int comparator);

	boolean isResult();

	void setResult(boolean result);

}