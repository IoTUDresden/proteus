package eu.vicci.process.distribution.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.vicci.process.client.ProcessEngineClientBuilder;
import eu.vicci.process.client.core.AbstractClientBuilder;
import eu.vicci.process.client.core.IConfigurationReader;
import eu.vicci.process.client.core.IProcessEngineClient;
import eu.vicci.process.distribution.core.DistributedSession;
import eu.vicci.process.distribution.core.DistributionManagerListener;
import eu.vicci.process.distribution.core.IDistributionManager;
import eu.vicci.process.distribution.core.PeerProfile;
import eu.vicci.process.distribution.core.RemoteListener;
import eu.vicci.process.distribution.core.RemoteProcess;
import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.util.ConfigurationReader;
import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;
import eu.vicci.process.model.util.messages.core.CompensationRequest;
import eu.vicci.process.model.util.messages.core.FeedbackServiceListener;
import eu.vicci.process.model.util.messages.core.IStateChangeMessage;
import eu.vicci.process.model.util.messages.core.StateChangeListener;

/**
 * Current design allows only one peer per ip.
 * <br>
 * TODO there is a chance that clients (e.g. smartCPS) cant track the state changes on the remote peer, 
 * cause the instance ids can differ.
 */
public class DistributionManager implements IDistributionManager {
	private static final Logger LOG = LoggerFactory.getLogger(DistributionManager.class);
	private static final String CLIENT_NAME = "SuperPeerDistributionManager";
	private static final String TEMP_CLIENT_NAME = "SuperPeerRemoteExecutingClient";
	private IProcessEngineClient pec;

	private volatile Map<String, PeerProfile> registeredPeers = new HashMap<>();
	
	//tracked instances for each peer
	private volatile Map<String, List<String>> trackedProcessInstances = new HashMap<String, List<String>>();
	
	private List<DistributionManagerListener> distributionListeners = new ArrayList<>();
	
	private final RemoteProcessCache remoteProcessCache = new RemoteProcessCache();
	
	/**
	 * Runtime cache for the input parameters.
	 * Maps the instance id of the super-peer process-instance, to its start-parameters.
	 */	
	private Map<String, Map<String, DataTypeInstance>> inputParametersCache = new ConcurrentHashMap<>();
	
	//only present on peers
	private Optional<PeerProfile> peerProfile = Optional.empty();

	private DistributionManager() {
		pec = createSuperPeerClient(CLIENT_NAME);
		pec.addStateChangeListener(stateChangeListener);
		pec.addFeedbackServiceListener(feedbackServiceListener);
	}
	
	private static class LazyDistributionManagerHolder {
		static final DistributionManager INSTANCE = new DistributionManager();
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
			
			DistributedSession oldSession = remoteProcessCache.getSessionFor(request.originalInstanceId);
			removeTrackedInstance(oldSession);			
			Map<String, DataTypeInstance> inputParameters = inputParametersCache.remove(request.originalInstanceId);	
			RemoteProcess process = remoteProcessCache.get(request.processId);
				
			if(process == null){
				LOG.error("cant find remote process for id '{}'", request.processId);
				return;
			}
				
			executeRemoteProcess(request.newPeerId, request.originalInstanceId, process, inputParameters);
		}
	};

	@Override
	public DistributedSession executeRemoteProcess(String peerId, String runningForInstanceId, RemoteProcess process, 
			Map<String, DataTypeInstance> inputParameters) {
		checkExecutionArgs(peerId, runningForInstanceId);
		
		LOG.info("Execute process '{}' on remote peer '{}'", process.getName(), peerId);
		
		remoteProcessCache.put(process.getId(), process);
		//we use a new client here, because existing client will block, if the call comes from 
		//feedback listener 
		IProcessEngineClient tmpPec = createSuperPeerClient(TEMP_CLIENT_NAME);
		
		String pid = tmpPec.deployProcessRemote(peerId, process.getProcess());
		String remoteProcessInstanceId = tmpPec.deployProcessInstanceRemote(peerId, pid);
		
		DistributedSession newSession = new DistributedSession(remoteProcessInstanceId, peerId);		
		trackProcessInstance(newSession);
		
		DistributedSession oldSession = remoteProcessCache.putSessionFor(runningForInstanceId, newSession);		
		informListenersAboutSessionChange(oldSession, newSession);
		
		inputParametersCache.put(runningForInstanceId, inputParameters);	
		
		tmpPec.startProcessInstanceRemote(peerId, remoteProcessInstanceId, runningForInstanceId, inputParameters);
		
		return newSession;
	}
	
	private void checkExecutionArgs(String peerId, String runningForInstanceId){
		if(runningForInstanceId == null || runningForInstanceId.isEmpty())
			throw new RuntimeException("runningForInstanceId cant be null for remote execution");
		if(peerId == null || peerId.isEmpty())
			throw new RuntimeException("peerId cant be null for remote execution");
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
	public DistributedSession workRemote(String ip, String runningForInstanceId, RemoteProcess process, 
			Map<String, DataTypeInstance> inputParameters) {
		String peerId = getPeerIdForIp(ip);		
		return executeRemoteProcess(peerId, runningForInstanceId, process, inputParameters);
	}
	
	@Override
	public RemoteProcess createRemoteProcess(Process original){
		return remoteProcessCache.createRemoteProcess(original);
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
	private IProcessEngineClient createSuperPeerClient(String name) {
		AbstractClientBuilder builder = new ProcessEngineClientBuilder();
		
		//TODO this is a workaround. prefs are not set, if we run this plugin in the editor
		//this plugin should actually not be used in editor
		//FIXME workaround wont work
		updateConfigIfNeeded();
		
		IProcessEngineClient pec = builder.withIp("localhost")
				.withPort(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.PORT))
				.withName(CLIENT_NAME)
				.withNamespace(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.NAMESPACE))
				.withRealmName(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.REALMNAME))
				.build();

		pec.connect();
		return pec;
	}

	private void updateConfigIfNeeded() {
		if(ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.PORT) != null)
			return;
		IConfigurationReader configReader = new ConfigurationReader("server.conf");
		ConfigurationManager.getInstance().updateFromConfigReader(configReader);
		
	}

	// FIXME StateChanges are not correct, e.g. the instance id in the state change must not be the same as on the superpeer, 
	// so we need additional infos (the peer id, instance id on peer and instance id on superpeer ar enough)
	private void handleStateChange(IStateChangeMessage message) {
		if(message.getPeerId() == null 
				|| message.getPeerId().isEmpty()
				|| message.getOriginalProcessInstanceId() == null
				|| message.getOriginalProcessInstanceId().isEmpty())
			return;
		
		if(!processHasFinished(message))
			return;
		
		DistributedSession session = remoteProcessCache.getSessionFor(message.getOriginalProcessInstanceId());		
		if(!removeTrackedInstance(session))
			return;		
		
		//at this point we know, that remote execution has finished and the instance on the peer was tracked
		informDistributionListeners(message, session);
	}
	
	/**
	 * @return false, if the instanceId on the given peerId is NOT tracked
	 */
	private boolean removeTrackedInstance(DistributedSession session){
		if(session == null){
			LOG.error("Cant remove a NULL Session from tracked instances");
			return false;
		}
		
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
	
	private void informListenersAboutSessionChange(DistributedSession oldSession, DistributedSession newSession){
		if(oldSession == null || newSession == null)
			return;
		
		synchronized (distributionListeners) {
			distributionListeners.stream().forEach(l -> l.remoteSessionChanged(oldSession, newSession));			
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
				&& request.newPeerId != null
				&& !request.newPeerId.isEmpty()
				&& request.processId != null
				&& !request.processId.isEmpty()
				&& request.originalInstanceId != null
				&& !request.originalInstanceId.isEmpty();
	}

}
