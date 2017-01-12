package eu.vicci.process.distribution.core;

import java.util.Map;

import eu.vicci.process.model.sofia.Process;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;

public interface IDistributionManager {
	
	String executeRemoteProcess(String peerId, Process process, Map<String, DataTypeInstance> inputParameters);
	
	void addDistributionManagerListener(DistributionManagerListener listener);
	
	void removeDistributionManagerListener(DistributionManagerListener listener);
	
	void addRemoteListener(RemoteListener listener);
	
	/**
	 * 
	 * @param ip
	 * @param ps
	 * @param inputParameters
	 * @return returns the instance id of the remote process
	 */
	String workRemote(String ip, Process ps, Map<String, DataTypeInstance> inputParameters);
	
	void registerPeer(PeerProfile profile);
	
	void unregisterPeer(PeerProfile profile);
	
	/**
	 * Gets all currently registered peers
	 * @return
	 */
	Map<String, PeerProfile> getRegisteredPeers();

}
