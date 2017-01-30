/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Se Mi Wa Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getServiceName <em>Service Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getNodeId <em>Node Id</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getSeMiWaInvoke()
 * @model
 * @generated
 */
public interface SeMiWaInvoke extends Invoke {
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSeMiWaInvoke_ServiceName()
	 * @model required="true"
	 * @generated
	 */
	String getServiceName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getServiceName <em>Service Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Name</em>' attribute.
	 * @see #getServiceName()
	 * @generated
	 */
	void setServiceName(String value);

	/**
	 * Returns the value of the '<em><b>Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node Id</em>' attribute.
	 * @see #setNodeId(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSeMiWaInvoke_NodeId()
	 * @model required="true"
	 * @generated
	 */
	String getNodeId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getNodeId <em>Node Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node Id</em>' attribute.
	 * @see #getNodeId()
	 * @generated
	 */
	void setNodeId(String value);

} // SeMiWaInvoke
