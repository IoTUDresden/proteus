package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.model.util.messages.HumanTaskMessageManager;
import ws.wamp.jawampa.Request;

public class RetrieveClosedHumanTaskResponses extends AbstractRpcHandler {

	@Override
	public void onNext(Request arg0) {
		arg0.reply(HumanTaskMessageManager.getInstance().getHandledResponses());		
	}

}
