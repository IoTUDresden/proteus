package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import ws.wamp.jawampa.Request;

public class RemoveInstanceServerHandler extends AbstractRpcHandlerManageable {

	public RemoveInstanceServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String instanceId = t.arguments().get(0).asText();		
		String state = processManager.removeInstance(instanceId);		
		t.reply(state);		
	}

}
