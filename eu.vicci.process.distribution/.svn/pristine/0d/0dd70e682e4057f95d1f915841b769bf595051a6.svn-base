package eu.vicci.process.distribution.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.distribution.core.DistributionManagerListener;
import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.core.RemoteListener;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

// TODO ping, one client, extend state change message for peerId
/**
 * Current design allows only one peer per ip.
 * <br>
 * TODO there is a chance that clients (e.g. smartCPS) cant track the state changes on the remote peer, 
 * cause the instance ids can differ.
 */
public class DistributionManager implements IDistributionManager {
	private static final Logger LOG = LoggerFactory.getLogger(DistributionManager.class);
	private static final String CLIENT_NAME = "SuperPeerDistributionManager";
	private IProcessEngineClient pec;

	private volatile Map<String, PeerProfile> registeredPeers = new HashMap<>();
	private volatile Map<String, List<String>> trackedProcessInstances = new HashMap<String, List<String>>();
	
	private List<DistributionManagerListener> distributionListeners = new ArrayList<>();

	public DistributionManager() {
		pec = createSuperPeerClient();
	}

	private StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage arg) {
			handleStateChange(arg);
		}
	};

	@Override
	public String executeRemoteProcess(String peerId, Process process, Map<String, DataTypeInstance> inputParameters) {
		LOG.info("<<<<<<<<<<<<<<<<<<<<<< Starte Remote >>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		String pid = pec.deployProcessRemote(peerId, process);
		String remoteProcessInstanceId = pec.deployProcessInstanceRemote(peerId, pid);
		
		trackProcessInstance(peerId, remoteProcessInstanceId);
		
		pec.startProcessInstanceRemote(peerId, remoteProcessInstanceId, inputParameters);
		
		return remoteProcessInstanceId;
	}

	@Override
	public void addDistributionManagerListener(DistributionManagerListener listener) {
		synchronized (distributionListeners) {
			distributionListeners.add(listener);			
		}
	}
	
	@Override
	public void removeDistributionManagerListener(DistributionManagerListener listener) {
		synchronized (distributionListeners) {
			distributionListeners.remove(listener);			
		}		
	}

	@Override
	public void addRemoteListener(RemoteListener listener) {

	}

	@Override
	public String workRemote(String ip, Process process, Map<String, DataTypeInstance> inputParameters) {
		String peerId = getPeerIdForIp(ip);		
		return executeRemoteProcess(peerId, process, inputParameters);		
	}
	
	private String getPeerIdForIp(String ip){
		synchronized (registeredPeers) {
			PeerProfile profile = registeredPeers.get(ip);
			if (profile == null)
				throw new RuntimeException("no peer was found for ip " + ip);
			return profile.getPeerId();
		}		
	}

	/**
	 * We assume that the port settings are the same as in the server.conf for
	 * all peers. The {@link DistributionManager} is running on the super peer
	 * which contains the wamp router, so we only need to connect to the wamp
	 * router on localhost. The created client can handle all peers (deploy,
	 * start instance) with the following methods:
	 * <ul>
	 * <li>{@link IProcessEngineClient#deployProcessRemote(String, Process)}
	 * </li>
	 * <li>
	 * {@link IProcessEngineClient#deployProcessInstanceRemote(String, String)}
	 * </li>
	 * <li>
	 * {@link IProcessEngineClient#startProcessInstanceRemote(String, String, Map)}
	 * </li>
	 * <ul>
	 * The peer id is used to identify the peer.
	 */
	private IProcessEngineClient createSuperPeerClient() {
		AbstractClientBuilder builder = new ProcessEngineClientBuilder();
		IProcessEngineClient pec = builder.withIp("localhost")
				.withPort(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.PORT))
				.withName(CLIENT_NAME)
				.withNamespace(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.NAMESPACE))
				.withRealmName(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.REALMNAME))
				.build();

		pec.connect();
		pec.addStateChangeListener(stateChangeListener);

		// TODO peer listener

		// pec.subscribeTo(TopicId.STATE_CHANGE, MessageType.WAMPMESSAGE, this);
		// pec.subscribeTo(TopicId.REMOTE_STEP_RESP,
		// MessageType.REMOTESTEPRESPONSE, this);
		// pec.subscribeTo(TopicId.PING_RESPONSE, MessageType.PINGRESPONSE,
		// this);
		// pec.subscribeTo(TopicId.PING_RESPONSE, MessageType.PINGRESPONSE,
		// this);
		// pec.subscribeTo(TopicId.PING, MessageType.PING, this);
		// pec.subscribeTo(TopicId.METRICS, MessageType.METRICS, this);
		return pec;
	}

	// FIXME StateChanges are not correct, e.g. the instance id in the state change must not be the same as on the superpeer, 
	// so we need additional infos (the peer id, instance id on peer and instance id on superpeer ar enough)
	private void handleStateChange(IStateChangeMessage message) {
		if(message.getPeerId() == null || message.getPeerId().isEmpty())
			return;
		if(!processHasFinished(message))
			return;
		if(!removeTrackedInstance(message.getPeerId(), message.getProcessInstanceId()))
			return;
		
		//at this point we know, that remote execution has finished and the instance on the peer was tracked
		informDistributionListeners(message);
	}
	
	private boolean removeTrackedInstance(String peerId, String instanceId){
		synchronized (trackedProcessInstances) {
			List<String> instances = trackedProcessInstances.get(peerId);
			if(instances == null || !instances.contains(instanceId))
				return false;
			return instances.remove(instanceId);
		}		
	}
	
	private void informDistributionListeners(IStateChangeMessage message){
		synchronized (distributionListeners) {
			distributionListeners.stream().forEach(l -> l.processOnPeerHasFinished(message));			
		}		
	}

	private boolean processHasFinished(IStateChangeMessage message) {
		switch (message.getState()) {
		case EXECUTED:
		case DEACTIVATED:
		case FAILED:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void registerPeer(PeerProfile profile) {
		if(!checkProfile(profile))
			return;
		synchronized (registeredPeers) {
			registeredPeers.put(profile.getIp(), profile);						
		}				
	}

	@Override
	public void unregisterPeer(PeerProfile profile) {
		if(!checkProfile(profile))
			return;		
		synchronized (registeredPeers) {
			registeredPeers.remove(profile.getIp());			
		}
	}
	
	public Map<String, PeerProfile> getRegisteredPeers(){
		Map<String, PeerProfile> tmp = new HashMap<>();
		synchronized (registeredPeers) {
			tmp.putAll(registeredPeers);						
		}
		return tmp;
	}
	
	private void trackProcessInstance(String peerId, String processInstanceId){
		synchronized (trackedProcessInstances) {
			List<String> instances = trackedProcessInstances.get(peerId);
			if(instances == null){
				instances = new ArrayList<>();
				trackedProcessInstances.put(peerId, instances);
			}
			instances.add(processInstanceId);
		}		
	}
	
	private static boolean checkProfile(PeerProfile profile){
		if(profile == null 
				|| profile.getIp() == null 
				|| profile.getPeerId() == null 
				|| profile.getIp().isEmpty() 
				|| profile.getPeerId().isEmpty()){
			LOG.error("Corrupt PeerProfile. Cant (un)register peer.");
			return false;
		}
		return true;
	}

}
