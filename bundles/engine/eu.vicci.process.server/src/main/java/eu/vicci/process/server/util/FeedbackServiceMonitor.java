package eu.vicci.process.server.util;

import eu.vicci.process.distribution.core.SuperPeerRequest;
import feign.RequestLine;

public interface FeedbackServiceMonitor {
	
	/**
	 * Sends a request to the fb service, to monitor operations on this superpeer.
	 * After this request, the fb service should try to connect via wamp connection.
	 * @param request
	 */
	@RequestLine("POST /proteus/superPeerRequesting")
	void requestingMonitoring(SuperPeerRequest request);

}
