package eu.vicci.process.model.implementation.tests.util;

import org.junit.BeforeClass;

import eu.vicci.process.model.sofiainstance.util.LifeCycleManager;


public abstract class ProcessExecutionTestsBase extends TestsBase {
	protected final static String PORT_WRONG_STATE = "The port '%s' has a wrong state. Current is: %s";
	protected final static String PROCESS_WRONG_STATE = "The process '%s' has a wrong state. Current is: %s";
	protected final static String PORT_WRONG_VALUE = "The port '%s' has a wrong value. Current: '%s' Expected: '%s'";
	
	protected final static int DEFAULT_TIMEOUT = 5000;
	protected final static int WAIT_DEPLOY_TIME = 1000;
	protected final static int SLEPPING_TIME = 400;
	
	@BeforeClass
	public static void setLCM(){
		LifeCycleManager.INSTANCE.reset();
	}
	
}
