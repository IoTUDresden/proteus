/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.Transition#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Transition#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getTransition()
 * @model
 * @generated
 */
public interface Transition extends Identifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Source Port</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.Port#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port</em>' container reference.
	 * @see #setSourcePort(Port)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getTransition_SourcePort()
	 * @see eu.vicci.process.model.sofia.Port#getOutTransitions
	 * @model opposite="outTransitions" required="true" transient="false"
	 * @generated
	 */
	Port getSourcePort();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Transition#getSourcePort <em>Source Port</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port</em>' container reference.
	 * @see #getSourcePort()
	 * @generated
	 */
	void setSourcePort(Port value);

	/**
	 * Returns the value of the '<em><b>Target Port</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.Port#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port</em>' reference.
	 * @see #setTargetPort(Port)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getTransition_TargetPort()
	 * @see eu.vicci.process.model.sofia.Port#getInTransitions
	 * @model opposite="inTransitions" required="true"
	 * @generated
	 */
	Port getTargetPort();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Transition#getTargetPort <em>Target Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port</em>' reference.
	 * @see #getTargetPort()
	 * @generated
	 */
	void setTargetPort(Port value);

} // Transition
