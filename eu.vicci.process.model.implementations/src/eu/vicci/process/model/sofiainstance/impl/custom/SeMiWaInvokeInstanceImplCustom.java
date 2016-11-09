package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.SeMiWaInvokeWorker;

public class SeMiWaInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements SeMiWaInvokeInstance{

	@Override
	public void work() {
		
		SeMiWaInvokeWorker worker = new SeMiWaInvokeWorker();
		returnValues = worker.work(this);
	}
}
