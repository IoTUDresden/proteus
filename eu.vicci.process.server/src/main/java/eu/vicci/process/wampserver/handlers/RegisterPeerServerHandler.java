package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.manager.DistributionManager;
import eu.vicci.process.engine.core.ReplyState;
import ws.wamp.jawampa.Request;

public class RegisterPeerServerHandler extends AbstractRpcHandler {

	@Override
	public void onNext(Request r) {
		PeerProfile profile = convertFromJson(r.arguments().get(0), PeerProfile.class);
		DistributionManager.getInstance().registerPeer(profile);
		r.reply(ReplyState.SUCCESS);
	}

}
