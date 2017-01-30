/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Publish Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.PublishMessage#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.PublishMessage#getTopic <em>Topic</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getPublishMessage()
 * @model abstract="true"
 * @generated
 */
public interface PublishMessage extends AtomicStep {
	/**
	 * Returns the value of the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Uri</em>' attribute.
	 * @see #setServerUri(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPublishMessage_ServerUri()
	 * @model
	 * @generated
	 */
	String getServerUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.PublishMessage#getServerUri <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Uri</em>' attribute.
	 * @see #getServerUri()
	 * @generated
	 */
	void setServerUri(String value);

	/**
	 * Returns the value of the '<em><b>Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Topic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Topic</em>' attribute.
	 * @see #setTopic(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPublishMessage_Topic()
	 * @model
	 * @generated
	 */
	String getTopic();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.PublishMessage#getTopic <em>Topic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Topic</em>' attribute.
	 * @see #getTopic()
	 * @generated
	 */
	void setTopic(String value);

} // PublishMessage
