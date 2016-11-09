package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Request;

public class RetrieveInstanceStateServerHandler extends AbstractRpcHandlerManageable {

	public RetrieveInstanceStateServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String instanceId = t.arguments().get(0).asText();
		IStateChangeMessage scm = processManager.getInstanceState(instanceId);
		t.reply(scm);		
	}
}
