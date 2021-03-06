package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Request;

public class StopInstanceServerHandler extends AbstractRpcHandlerManageable {

	public StopInstanceServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String instanceId = t.arguments().get(0).asText();		
		processManager.stopProcessInstance(instanceId);	
		t.reply(ReplyState.SUCCESS);
	}

}
