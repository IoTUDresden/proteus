/**
 */
package eu.vicci.process.model.sofiainstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Escalation Port Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.EscalationPortInstance#getEscalationReason <em>Escalation Reason</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getEscalationPortInstance()
 * @model
 * @generated
 */
public interface EscalationPortInstance extends EndControlPortInstance {
	/**
	 * Returns the value of the '<em><b>Escalation Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escalation Reason</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escalation Reason</em>' attribute.
	 * @see #setEscalationReason(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getEscalationPortInstance_EscalationReason()
	 * @model required="true"
	 * @generated
	 */
	String getEscalationReason();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.EscalationPortInstance#getEscalationReason <em>Escalation Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escalation Reason</em>' attribute.
	 * @see #getEscalationReason()
	 * @generated
	 */
	void setEscalationReason(String value);

} // EscalationPortInstance
