package eu.vicci.process.wampserver.handlers;

import java.util.List;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Request;

public class RetrieveRecentStateChangesServerHandler extends AbstractRpcHandlerManageable{

	public RetrieveRecentStateChangesServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		List<IStateChangeMessage> stateChanges = processManager.getRecentStateChanges();
		t.reply(stateChanges);		
	}

}
