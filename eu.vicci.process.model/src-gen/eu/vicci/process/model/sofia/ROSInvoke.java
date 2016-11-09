/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ROS Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.ROSInvoke#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ROSInvoke#getServiceName <em>Service Name</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getROSInvoke()
 * @model
 * @generated
 */
public interface ROSInvoke extends AtomicStep {
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getROSInvoke_ServerUri()
	 * @model required="true"
	 * @generated
	 */
	String getServerUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ROSInvoke#getServerUri <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Uri</em>' attribute.
	 * @see #getServerUri()
	 * @generated
	 */
	void setServerUri(String value);

	/**
	 * Returns the value of the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Name</em>' attribute.
	 * @see #setServiceName(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getROSInvoke_ServiceName()
	 * @model
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ROSInvoke#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

} // ROSInvoke
