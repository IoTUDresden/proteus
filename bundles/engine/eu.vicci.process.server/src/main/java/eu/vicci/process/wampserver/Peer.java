package eu.vicci.process.wampserver;

import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.engine.core.IProcessManager;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.RpcId;
import eu.vicci.process.wampserver.handlers.AbstractRpcHandler;
import ws.wamp.jawampa.ApplicationError;

public class Peer extends SuperPeer {
	private final String superPeerIp;

	public Peer(IProcessManager processManager, String superPeerIp) {
		this(processManager, new ConfigurationReader(DEFAULT_CONFIG_PATH), superPeerIp);
	}
	
	public Peer(IProcessManager processManager, IConfigurationReader configReader, String superPeerIp){
		super(processManager, configReader);
		this.superPeerIp = superPeerIp;
	}
	
	@Override
	protected PeerProfile createPeerProfile() {
		PeerProfile profile = PeerProfile.create(false);
		profile.setIp(getIpSafe());
		return profile;
	}
	
	@Override
	protected void registerProcedure(String rpcId, AbstractRpcHandler handler) {
		serverClient.registerProcedure(rpcId + RpcId.ID_SEPERATOR + peerProfile.getPeerId()).subscribe(handler);
	}
	
	@Override
	protected void startClient(String port, String namespace, String realmName) throws ApplicationError {
		startClient(superPeerIp, port, namespace, realmName);
	}
	
	@Override
	protected void registerPeer() {
		serverClient.call(RpcId.REGISTER_PEER, peerProfile).subscribe();
	}
	
	@Override
	protected void stopRouter() {
		//nothing to do. Router is on SuperPeer
	}
	
	@Override
	protected void startRouter(String port, String namespace, String realmName) throws ApplicationError {
		//nothing to do. Router is on SuperPeer
	}
	
	@Override
	protected void publishPeerStatus() {
		publishPeerMetrics();
	}

}
