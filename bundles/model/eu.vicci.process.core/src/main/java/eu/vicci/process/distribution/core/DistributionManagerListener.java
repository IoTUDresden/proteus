package eu.vicci.process.distribution.core;

import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public interface DistributionManagerListener {
	
	/**
	 * Method is called, if a tracked process on some peer has finished
	 * @param message
	 * @param session
	 */
	void processOnPeerHasFinished(IStateChangeMessage message, DistributedSession session);
	
	/**
	 * Gets called if the remote session changes (e.g. on compensation)
	 * @param oldSession
	 * @param newSession
	 */
	void remoteSessionChanged(DistributedSession oldSession, DistributedSession newSession);

}
