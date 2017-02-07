/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Escalation Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.EscalationPort#getEscalationTime <em>Escalation Time</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getEscalationPort()
 * @model
 * @generated
 */
public interface EscalationPort extends EndControlPort {
	/**
	 * Returns the value of the '<em><b>Escalation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Escalation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Escalation Time</em>' attribute.
	 * @see #setEscalationTime(long)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getEscalationPort_EscalationTime()
	 * @model required="true"
	 * @generated
	 */
	long getEscalationTime();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.EscalationPort#getEscalationTime <em>Escalation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escalation Time</em>' attribute.
	 * @see #getEscalationTime()
	 * @generated
	 */
	void setEscalationTime(long value);

} // EscalationPort
