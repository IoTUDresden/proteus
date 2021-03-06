package eu.vicci.process.distribution.core;

import java.util.Map;

import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public interface IDistributionManager {
	
	DistributedSession executeRemoteProcess(String peerId, String runningForInstanceId, RemoteProcess process, Map<String, DataTypeInstance> inputParameters);
	
	void addDistributionManagerListener(DistributionManagerListener listener);
	
	void removeDistributionManagerListener(DistributionManagerListener listener);
	
	void addRemoteListener(RemoteListener listener);
	
	/**
	 * @return the peerId
	 */
	String getPeerId();
	
	/**
	 * @return true if the current instance is acting as SuperPeer
	 */
	boolean isSuperPeer();
	
	/**
	 * 
	 * @param ip
	 * @param runningForInstanceId
	 * @param ps
	 * @param inputParameters
	 * @return returns a distributed session
	 */
	DistributedSession workRemote(String ip, String runningForInstanceId, RemoteProcess ps, Map<String, DataTypeInstance> inputParameters);
	
	void registerPeer(PeerProfile profile);
	
	void unregisterPeer(PeerProfile profile);
	
	/**
	 * Gets all currently registered peers
	 * @return
	 */
	Map<String, PeerProfile> getRegisteredPeers();
	
	/**
	 * Creates a new process copy or gets it from runtime cache.
	 * @param original
	 * @return copied process
	 */
	RemoteProcess createRemoteProcess(Process original);

}
