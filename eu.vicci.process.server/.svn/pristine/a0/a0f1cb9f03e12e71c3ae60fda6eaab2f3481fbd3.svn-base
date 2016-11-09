package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.client.core.ClientProfile;
import eu.vicci.process.engine.core.ReplyState;
import eu.vicci.process.model.util.client.ClientManager;
import ws.wamp.jawampa.Request;

public class RegisterClientServerHandler extends AbstractRpcHandler {

	@Override
	public void onNext(Request t) {
		System.out.println(t.arguments().get(0).toString());
		ClientProfile cp = convertFromJson(t.arguments().get(0), ClientProfile.class);
		ClientManager.getInstance().addClient(cp);
		t.reply(ReplyState.SUCCESS);
	}

}
