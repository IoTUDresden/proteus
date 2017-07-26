package eu.vicci.process.distribution.manager;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import eu.vicci.process.distribution.core.DistributedSession;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.Process;

/**
 * Simple cache holds all generated processes, which are executed on remote.
 */
public class RemoteProcessCache {
	
	private final Map<String, Process> processes = new ConcurrentHashMap<>();
	private final Map<String, DistributedSession> remoteMapping = new ConcurrentHashMap<>();
	
	/**
	 * 
	 * @param id
	 * @return the previous value associated with key, 
	 * or null if there was no mapping for key. 
	 * (A null return can also indicate that the map previously associated null with key.)
	 */
	public Process remove(String id){
		return processes.remove(id);		
	}
	
	/**
	 * 
	 * @param process
	 * @return the previous value associated with key, 
	 * or null if there was no mapping for key. 
	 * (A null return can also indicate that the map previously associated null with key.)
	 */
	public Process remove(Process process){
		return remove(process.getId());
	}
	
	/**
	 * 
	 * @param id
	 * @param process
	 * @return the previous value associated with key, 
	 * or null if there was no mapping for key. 
	 * (A null return can also indicate that the map previously associated null with key.)
	 */
	public Process put(String id, Process process){
		return processes.put(id, process);		
	}
	
	/**
	 * 
	 * @param process
	 * @return the previous value associated with key, 
	 * or null if there was no mapping for key. 
	 * (A null return can also indicate that the map previously associated null with key.)
	 */
	public Process put(Process process){
		return put(process.getId(), process);
	}
	
	/**
	 * Underlying {@link Map#get(Object)}
	 * @param id
	 * @return
	 */
	public Process get(String id){
		return processes.get(id);
	}
	
	/**
	 * Gets the {@link DistributedSession} for the given instanceId. 
	 * Use the instanceId from the superpeer process!
	 * @param instanceId
	 * @return the value to which the specified key is mapped, 
	 * or null if this map contains no mapping for the key
	 */
	public DistributedSession getSessionFor(String instanceId){
		return remoteMapping.get(instanceId);
	}
	
	/**
	 * Removes the {@link DistributedSession} for the given instance id.
	 * Use the instanceId from the superpeer process!
	 * @param instanceId
	 * @return the previous value associated with key, or null if there was no mapping for key.
	 */
	public DistributedSession removeSessionFor(String instanceId){
		return remoteMapping.remove(instanceId);
	}
	
	/**
	 * Adds a {@link DistributedSession} for the given instance id.
	 * Use the instanceId from the superpeer process!
	 * @param instanceId
	 * @param session
	 * @return
	 * the previous value associated with key, or null if there was no mapping for key. 
	 * (A null return can also indicate that the map previously associated null with key, 
	 * if the implementation supports null values.)
	 */
	public DistributedSession putSessionFor(String instanceId, DistributedSession session){
		return remoteMapping.put(instanceId, session);
	}
	
	/**
	 * Creates a new RemoteProcess or gets it from runtime cache.
	 * @param original
	 * @return
	 */
	public Process createRemoteProcess(Process original){
		Process  remote = processes.get(original.getId());	
		if(remote != null)
			return remote;
		remote = internalCreateRemoteProcess(original);
		clearOutTransitions(remote);
		put(remote);
		return remote;
	}
	
	private Process internalCreateRemoteProcess(Process original) {
		Process remoteProcess = copy(original);
		remoteProcess.setDistributed(false);
		remoteProcess.setRemoteExecuting(true);
		remoteProcess.setCyberPhysical(false);
		remoteProcess.setGoal("");
		return remoteProcess;
	}
	
	private Process copy(Process original) {
		EList<DataType> dtDefs = ((Process)getRoot(original)).getDataTypeDefinitions();		
		Copier copier = new Copier();
		Process result = (Process) copier.copy(original);
		Collection<DataType> types = copier.copyAll(dtDefs);
		result.getDataTypeDefinitions().addAll(types);
		copier.copyReferences();
		return result;
	}
	
	private CompositeStep getRoot(CompositeStep step) {
		if (step.getParentstep() == null)
			return step;
		return getRoot(step.getParentstep());
	}
	
	private void clearOutTransitions(Process remoteProcess) {
		remoteProcess.getPorts().stream()
		.filter(p -> p instanceof EndPort)
		.forEach(p -> p.getOutTransitions().clear());
	}

}
