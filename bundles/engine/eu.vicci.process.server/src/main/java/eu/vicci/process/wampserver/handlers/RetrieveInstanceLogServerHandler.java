package eu.vicci.process.wampserver.handlers;

import java.util.ArrayList;
import java.util.List;

import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import ws.wamp.jawampa.Request;

public class RetrieveInstanceLogServerHandler extends AbstractRpcHandlerManageable{

	public RetrieveInstanceLogServerHandler(IProcessManager processManager) {
		super(processManager);
	}

	@Override
	public void onNext(Request t) {
		String instanceId = t.arguments().get(0).asText();
		List<IStateChangeMessage> log = processManager.getInstanceLog(instanceId);
		if(log == null)
			log = new ArrayList<>();
		t.reply(log);		
	}

}
