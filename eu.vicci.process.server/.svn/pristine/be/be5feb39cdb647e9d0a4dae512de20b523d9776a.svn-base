package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

public class DeployInstanceServerHandler extends AbstractRpcHandlerManageable{

	public DeployInstanceServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t1) {
		String processId = t1.arguments().get(0).asText();		
		String instanceId = processManager.deployProcessInstance(processId);
		t1.reply(instanceId);		
	}

}
