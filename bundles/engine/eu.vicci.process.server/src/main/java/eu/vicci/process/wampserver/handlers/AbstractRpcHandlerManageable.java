package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;

public abstract class AbstractRpcHandlerManageable extends AbstractRpcHandler {
	protected IProcessManager processManager;
	
	public AbstractRpcHandlerManageable(IProcessManager processManager) {
		this.processManager = processManager;
	}

}
