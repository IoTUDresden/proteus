package eu.vicci.process.distribution.core;

import eu.vicci.process.model.util.messages.core.IStateChangeMessage;

public interface DistributionManagerListener {
	
	void processOnPeerHasFinished(IStateChangeMessage message);

}
