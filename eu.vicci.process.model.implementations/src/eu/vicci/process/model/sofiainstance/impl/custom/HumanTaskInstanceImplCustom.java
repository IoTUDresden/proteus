package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.HumanTaskInstance;
import eu.vicci.process.model.sofiainstance.util.HumanTaskInvokeWorker;

public class HumanTaskInstanceImplCustom extends ProcessStepInstanceImplCustom implements HumanTaskInstance {
	
	@Override
	public void work() {
		HumanTaskInvokeWorker htiw = new HumanTaskInvokeWorker(messageQueue);
		returnValues = htiw.work(this);
		if (!validateReturnValues())
			work();
	}

	private boolean validateReturnValues() {
		// TODO validation against faults in user entries (wrong types etc.)
		return true;
	}
}
