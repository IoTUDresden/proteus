package eu.vicci.process.model.util.messages.core;

public interface IHumanTaskResponse extends IWampResponse, IHumanTaskMessage {

	String getProcessInstanceId();

	void setProcessInstanceId(String processInstanceId);

	/**
	 * Indicates that this response is used to reserve the
	 * {@link IHumantaskRequest}. So clients know, that this response will be
	 * handled later by some other client (which sends this response with
	 * isSentForReservation = true).
	 * 
	 * @return
	 */
	boolean isSentForReservation();

	/**
	 * Indicates that this response is used to reserve the
	 * {@link IHumantaskRequest}. So clients know, that this response will be
	 * handled later by some other client (which sends this response with
	 * isSentForReservation = true).
	 * 
	 * @param isSentForSeservation
	 *            true if the specific {@link IHumantaskRequest} should be
	 *            reserved.
	 * 
	 */
	void setSentForReservation(boolean isSentForSeservation);

	/**
	 * Gets a value indicating, that the reservation for the
	 * {@link IHumantaskRequest} will be canceled.
	 * 
	 * @return true if should be canceled
	 */
	boolean cancelReservation();

	/**
	 * Sets a value indicating, that the reservation for the
	 * {@link IHumantaskRequest} will be canceled.
	 * 
	 * @param cancelReservation
	 *            true if should be canceled
	 */
	void setCancelReservation(boolean cancelReservation);
}