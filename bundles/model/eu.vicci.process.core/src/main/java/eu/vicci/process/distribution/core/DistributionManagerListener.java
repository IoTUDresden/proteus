package eu.vicci.process.distribution.core;

import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public interface DistributionManagerListener {
	
	/**
	 * Method is called, if a tracked process on some peer has finished
	 * @param message
	 * @param session
	 */
	void processOnPeerHasFinished(IStateChangeMessage message, DistributedSession session);

}
