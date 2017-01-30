package eu.vicci.process.model.sofiainstance.util;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;

/**
 * PortInstanceThread is a helper to decouple the execution of an process. Due
 * to the fact that ProcessSteps can be distributed over several machines or
 * need much time for processing their Ports especially their StartPorts make
 * use of this Class to decouple the predecessor by giving back the control
 * immediately.
 * 
 * @author Reik Mueller
 * 
 */
public class PortInstanceThread extends Thread implements Runnable {

	private PortInstance pinstance = null;
	private DataTypeInstance parameter = null;

	/**
	 * Returns a PortInstanceThread.
	 * 
	 * @param portinstance
	 *            PortInstance that shall not block execution of the predecessor
	 * @param parameter
	 *            parameters as xml document represented in a String
	 */
	public PortInstanceThread(PortInstance portinstance, DataTypeInstance parameter) {
		System.out.println("ProcessStep decoupled by a PortThread");
		this.pinstance = portinstance;
		this.parameter = parameter;
	}

	@Override
	public void run() {
		try {
			sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		LifeCycleManager.INSTANCE.activatePort(pinstance, parameter);
	}

}
