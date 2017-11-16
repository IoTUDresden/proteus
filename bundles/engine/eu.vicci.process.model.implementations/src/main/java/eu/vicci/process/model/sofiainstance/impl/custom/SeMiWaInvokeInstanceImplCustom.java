package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance;

public class SeMiWaInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements SeMiWaInvokeInstance{

	@Override
	public void work() {
		throw new UnsupportedOperationException("SeMiWa support was dropped");
	}
	
}
