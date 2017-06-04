package eu.vicci.process.model.sofiainstance.util.processstepclasses;

import java.util.List;
import java.util.Optional;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

/**
 * If any found boolean start port contains true, the process will fail.
 * Used for testing the compensation in with feedback service 
 */
public class FailingStep implements ProcessStepWorker {

	@Override
	public List<DataTypeInstance> work(Context context) {
		Optional<DataTypeInstance> first = context.startParameter.stream()
				.filter(dti -> dti instanceof BooleanTypeInstance)
				.filter(dti -> ((BooleanTypeInstance)dti).isValue())
				.findAny();
		if(first.isPresent())
			throw new RuntimeException("You wanted it like this.");
			
		return context.endParameter;
	}

	@Override
	public void deploy() {
		
	}

}
