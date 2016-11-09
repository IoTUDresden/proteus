package eu.vicci.process.model.util.messages;

import eu.vicci.process.model.util.messages.core.IHumanTaskRequest;
import eu.vicci.process.model.util.messages.core.IHumanTaskResponse;

/**
 * Listen on the {@link HumanTaskMessageManager} for {@link IHumanTaskResponse}s
 */
public interface HumanTaskMessageManagerListener {

	/**
	 * Called if a new {@link IHumanTaskResponse} was added to the {@link HumanTaskMessageManager}
	 * 
	 * @param response
	 */
	void onHumanTaskResponseAdded(IHumanTaskResponse response);

	/**
	 * Called if a reservation was canceled.
	 * 
	 * @param oldResponse
	 *            the response which sends the cancelation
	 * @param request
	 *            the specific open request
	 */
	void onHumanTaskResponseCanceled(IHumanTaskResponse oldResponse, IHumanTaskRequest request);
}
