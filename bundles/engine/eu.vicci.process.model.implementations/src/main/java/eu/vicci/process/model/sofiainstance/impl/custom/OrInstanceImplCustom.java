package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.OrInstance;
import eu.vicci.process.model.sofiainstance.StartPortInstance;
import eu.vicci.process.model.sofiainstance.State;

public class OrInstanceImplCustom extends ProcessStepInstanceImplCustom implements OrInstance{	
	
	@Override
	public boolean hasAnyDeactivatedAndRequiredStartPort() {
		//Deactivation only if all ports are deactivated.
		return getPorts().stream()
				.filter(p -> p instanceof StartPortInstance)
				.allMatch(p -> p.getExecutionState() == State.DEACTIVATED);
	}
	
	//only one active port required
	@Override
	public boolean allStartPortsActive() {		
		boolean anyActivePort = getPorts().stream()
				.filter(p -> p instanceof StartPortInstance)
				.anyMatch(p -> p.getExecutionState() == State.ACTIVE);
		
		return anyActivePort;
	}

	@Override
	public void work() {
		returnValues =  startParameter;
	}
}
