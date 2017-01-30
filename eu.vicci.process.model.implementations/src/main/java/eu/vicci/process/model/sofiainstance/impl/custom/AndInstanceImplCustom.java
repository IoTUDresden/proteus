package eu.vicci.process.model.sofiainstance.impl.custom;

import eu.vicci.process.model.sofiainstance.AndInstance;

/**
 * Implementation of AndInstance.
 * All StartPorts have to be activated or this process and outgoing ports will be deactivated. 
 *
 */
public class AndInstanceImplCustom extends ProcessStepInstanceImplCustom implements AndInstance {
	
	/**
	 * The work to be done by the ProcessStep.<br>
	 * <br>
	 * Please fill in here all necessary business logic.
	 */
	public void work() {
		returnValues =  startParameter;
	}

}
