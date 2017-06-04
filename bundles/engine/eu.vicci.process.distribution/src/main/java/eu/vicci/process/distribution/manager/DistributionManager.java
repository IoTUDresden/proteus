package eu.vicci.process.distribution.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.distribution.core.DistributedSession;
import eu.vicci.process.distribution.core.DistributionManagerListener;
import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.core.RemoteListener;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.CompensationRequest;
import eu.vicci.process.model.util.messages.core.FeedbackServiceListener;
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
	
	//tracked instances for each peer
	private volatile Map<String, List<String>> trackedProcessInstances = new HashMap<String, List<String>>();
	
	private List<DistributionManagerListener> distributionListeners = new ArrayList<>();
	
	//runtime cache for remote processes (pid, p)
	private Map<String, Process> remoteProcessesCache = new HashMap<>();
	
	//runtime cache for the input parameters
	private Map<DistributedSession, Map<String, DataTypeInstance>> inputParametersCache = new HashMap<>();
	
	//only present on peers
	private Optional<PeerProfile> peerProfile = Optional.empty();

	private DistributionManager() {
		pec = createSuperPeerClient();
	}
	
	private static class LazyDistributionManagerHolder {
		private static final DistributionManager INSTANCE = new DistributionManager();
   }
	
	public static DistributionManager getInstance(){
		return LazyDistributionManagerHolder.INSTANCE;
	}

	private StateChangeListener stateChangeListener = new StateChangeListener() {
		@Override
		public void onMessage(IStateChangeMessage arg) {
			handleStateChange(arg);
		}
	};
	
	private FeedbackServiceListener feedbackServiceListener = new FeedbackServiceListener() {		
		@Override
		public void onMessage(CompensationRequest request) {
			if(!checkArgs(request)){ 
				LOG.error("CompensationRequest is missing required parameters");
				return;
			}
			
			DistributedSession session = new DistributedSession(request.oldInstanceId, request.oldPeerId);
			Map<String, DataTypeInstance> inputParameters = inputParametersCache.remove(session);			
			removeTrackedInstance(session);
			Process process = remoteProcessesCache.get(request.processId);
			if(process == null){
				LOG.error("cant find remote process for id '{}'", request.processId);
				return;
			}
			
			executeRemoteProcess(request.newPeerId, process, inputParameters);
		}
	};

	@Override
	public DistributedSession executeRemoteProcess(String peerId, Process process, Map<String, DataTypeInstance> inputParameters) {
		LOG.info("<<<<<<<<<<<<<<<<<<<<<< Start Remote >>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		remoteProcessesCache.put(process.getId(), process);
		
		String pid = pec.deployProcessRemote(peerId, process);
		String remoteProcessInstanceId = pec.deployProcessInstanceRemote(peerId, pid);
		
		DistributedSession session = new DistributedSession(remoteProcessInstanceId, peerId);
		trackProcessInstance(session);
		inputParametersCache.put(session, inputParameters);
		
		pec.startProcessInstanceRemote(peerId, remoteProcessInstanceId, inputParameters);
		
		return session;
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
	public DistributedSession workRemote(String ip, Process process, Map<String, DataTypeInstance> inputParameters) {
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
		pec.addFeedbackServiceListener(feedbackServiceListener);

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
		DistributedSession session = new DistributedSession(message.getInstanceId(), message.getPeerId());
		if(!removeTrackedInstance(session))
			return;
		
		//at this point we know, that remote execution has finished and the instance on the peer was tracked
		informDistributionListeners(message, session);
	}
	
	/**
	 * @return false, if the instanceId on the given peerId is NOT tracked
	 */
	private boolean removeTrackedInstance(DistributedSession session){
		synchronized (trackedProcessInstances) {
			List<String> instances = trackedProcessInstances.get(session.getPeerId());
			if(instances == null || !instances.contains(session.getRemoteInstanceId()))
				return false;
			return instances.remove(session.getRemoteInstanceId());
		}		
	}
	
	private void informDistributionListeners(IStateChangeMessage message, DistributedSession session){
		synchronized (distributionListeners) {
			distributionListeners.stream().forEach(l -> l.processOnPeerHasFinished(message, session));			
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
	
	@Override
	public boolean isSuperPeer(){
		return peerProfile.isPresent() && peerProfile.get().isSuperPeer();		
	}
	
	@Override
	public String getPeerId(){
		if(peerProfile.isPresent())
			return peerProfile.get().getPeerId();
		return null;
	}
	
	public void setPeerProfile(PeerProfile profile){
		if(profile == null || peerProfile.isPresent())
			throw new RuntimeException("The PeerProfile can only be set once and cant be set to null");
		peerProfile = Optional.of(profile);
	}
	
	private void trackProcessInstance(DistributedSession session){
		synchronized (trackedProcessInstances) {
			String peerId = session.getPeerId();
			List<String> instances = trackedProcessInstances.get(session.getPeerId());
			if(instances == null){
				instances = new ArrayList<>();
				trackedProcessInstances.put(peerId, instances);
			}
			instances.add(session.getRemoteInstanceId());
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
	
	private static boolean checkArgs(CompensationRequest request){
		return request != null 
				&& request.oldInstanceId != null 
				&& !request.oldInstanceId.isEmpty()
				&& request.newPeerId != null
				&& !request.newPeerId.isEmpty()
				&& request.processId != null
				&& !request.processId.isEmpty();
	}

}
