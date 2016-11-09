package eu.vicci.process.model.util.serialization.jsonprocessstepinstances.core;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public interface IJSONTransitionInstance {

	TransitionInstance makeTransitionInstance(SofiaInstanceFactory factory);

}