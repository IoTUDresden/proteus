/**
 */
package eu.vicci.process.model.sofiainstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.Configuration#getDelay <em>Delay</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.Configuration#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.Configuration#isDecoupleNextSteps <em>Decouple Next Steps</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends InstanceIdentifiable {
	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(long)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConfiguration_Delay()
	 * @model
	 * @generated
	 */
	long getDelay();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.Configuration#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(long value);

	/**
	 * Returns the value of the '<em><b>Permission</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofiainstance.ExecutionPermission}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @see #setPermission(ExecutionPermission)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConfiguration_Permission()
	 * @model
	 * @generated
	 */
	ExecutionPermission getPermission();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.Configuration#getPermission <em>Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permission</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @see #getPermission()
	 * @generated
	 */
	void setPermission(ExecutionPermission value);

	/**
	 * Returns the value of the '<em><b>Decouple Next Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decouple Next Steps</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decouple Next Steps</em>' attribute.
	 * @see #setDecoupleNextSteps(boolean)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConfiguration_DecoupleNextSteps()
	 * @model required="true"
	 * @generated
	 */
	boolean isDecoupleNextSteps();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.Configuration#isDecoupleNextSteps <em>Decouple Next Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decouple Next Steps</em>' attribute.
	 * @see #isDecoupleNextSteps()
	 * @generated
	 */
	void setDecoupleNextSteps(boolean value);

} // Configuration
