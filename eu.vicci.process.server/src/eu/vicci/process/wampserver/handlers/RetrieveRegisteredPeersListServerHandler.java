package eu.vicci.process.wampserver.handlers;

import java.util.List;

import eu.vicci.process.client.core.ClientProfile;
import eu.vicci.process.model.util.client.ClientManager;
import ws.wamp.jawampa.Request;

public class RetrieveRegisteredPeersListServerHandler extends AbstractRpcHandler {
	
	@Override
	public void onNext(Request r) {
		//FIXME NOT client profiles -> peers!
		List<ClientProfile> profiles = ClientManager.getInstance().getClients();
		r.reply(profiles);
	}

}
