/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Load Class Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.LoadClassStep#getDelegateClassName <em>Delegate Class Name</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getLoadClassStep()
 * @model
 * @generated
 */
public interface LoadClassStep extends AtomicStep {
	/**
	 * Returns the value of the '<em><b>Delegate Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delegate Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delegate Class Name</em>' attribute.
	 * @see #setDelegateClassName(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getLoadClassStep_DelegateClassName()
	 * @model
	 * @generated
	 */
	String getDelegateClassName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.LoadClassStep#getDelegateClassName <em>Delegate Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delegate Class Name</em>' attribute.
	 * @see #getDelegateClassName()
	 * @generated
	 */
	void setDelegateClassName(String value);

} // LoadClassStep
