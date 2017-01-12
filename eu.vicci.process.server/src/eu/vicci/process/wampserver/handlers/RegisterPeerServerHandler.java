package eu.vicci.process.wampserver.handlers;

import eu.vicci.process.distribution.core.PeerProfile;
import ws.wamp.jawampa.Request;

public class RegisterPeerServerHandler extends AbstractRpcHandler {

	@Override
	public void onNext(Request arg0) {
		PeerProfile profile = convertFromJson(arg0.arguments().get(0), PeerProfile.class);
		//FIXME add to the distribution manager		
	}

}
