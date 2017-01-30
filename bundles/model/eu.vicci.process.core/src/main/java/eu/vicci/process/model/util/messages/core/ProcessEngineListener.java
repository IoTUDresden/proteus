package eu.vicci.process.model.util.messages.core;

import eu.vicci.process.engine.core.IProcessInfo;
import eu.vicci.process.engine.core.IProcessInstanceInfo;

/**
 * Listener for receiving updates e.g. if a new process or instance was deployed
 */
public interface ProcessEngineListener {
	
	void onProcessDeployed(IProcessInfo processInfo);
	
	void onProcessInstanceDeployed(IProcessInstanceInfo processInstanceInfo);

}
