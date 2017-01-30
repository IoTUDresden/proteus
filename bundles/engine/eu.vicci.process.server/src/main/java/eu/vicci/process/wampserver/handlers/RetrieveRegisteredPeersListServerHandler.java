package eu.vicci.process.wampserver.handlers;

import java.util.Collection;

import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.manager.DistributionManager;
import ws.wamp.jawampa.Request;

public class RetrieveRegisteredPeersListServerHandler extends AbstractRpcHandler {
	
	@Override
	public void onNext(Request r) {
		Collection<PeerProfile> profiles = DistributionManager.getInstance().getRegisteredPeers().values();
		r.reply(profiles);
	}

}
