package eu.vicci.process.model.util.serialization.jsonprocesssteps.core;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import eu.vicci.process.model.sofia.Transition;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public interface IJSONTransition {

	Transition makeTransition();

}