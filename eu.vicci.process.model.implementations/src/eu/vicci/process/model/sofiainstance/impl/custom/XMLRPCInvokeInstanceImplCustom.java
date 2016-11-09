package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance;
import eu.vicci.process.model.sofiainstance.util.XMLRPCInvokeWorker;

public class XMLRPCInvokeInstanceImplCustom extends ProcessStepInstanceImplCustom implements XMLRPCInvokeInstance{

	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	@Override
	public void work() {
			
		XMLRPCInvokeWorker xiw = new XMLRPCInvokeWorker();
		returnValues = xiw.work(this);
	}

}