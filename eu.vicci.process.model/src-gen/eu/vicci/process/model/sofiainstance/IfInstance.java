/**
 */
package eu.vicci.process.model.sofiainstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.IfInstance#getIfConditionInstance <em>If Condition Instance</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getIfInstance()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface IfInstance extends ProcessStepInstance {
	/**
	 * Returns the value of the '<em><b>If Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Condition Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Condition Instance</em>' containment reference.
	 * @see #setIfConditionInstance(ConditionInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getIfInstance_IfConditionInstance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConditionInstance getIfConditionInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.IfInstance#getIfConditionInstance <em>If Condition Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Condition Instance</em>' containment reference.
	 * @see #getIfConditionInstance()
	 * @generated
	 */
	void setIfConditionInstance(ConditionInstance value);

} // IfInstance
