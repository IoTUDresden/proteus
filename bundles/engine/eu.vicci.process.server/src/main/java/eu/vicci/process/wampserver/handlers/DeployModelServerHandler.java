package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

public class DeployModelServerHandler extends AbstractRpcHandlerManageable {

	public DeployModelServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String processId = t.arguments().get(0).asText();		
		String id = processManager.deployProcess(processId);		
		t.reply(id);		
	}
}
