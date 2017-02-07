package eu.vicci.process.client.handlers;

import java.util.List;

import eu.vicci.process.distribution.core.PeerProfile;
import ws.wamp.jawampa.Reply;

public class RetrieveRegisteredPeersClientHandler extends AbstractClientHandler  {
	private List<PeerProfile> peers = null;

	@SuppressWarnings("unchecked")
	@Override
	public void onNext(Reply r) {
		peers = convertFromJsonToCollectionType(r.arguments().get(0), List.class, PeerProfile.class);		
	}

	public List<PeerProfile> getPeers() {
		return peers;
	}
}
