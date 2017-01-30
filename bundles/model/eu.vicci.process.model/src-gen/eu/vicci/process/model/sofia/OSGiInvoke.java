/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OS Gi Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.OSGiInvoke#getServiceClassName <em>Service Class Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.OSGiInvoke#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.OSGiInvoke#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.OSGiInvoke#getBundleName <em>Bundle Name</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getOSGiInvoke()
 * @model
 * @generated
 */
public interface OSGiInvoke extends Invoke {
	/**
	 * Returns the value of the '<em><b>Service Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Class Name</em>' attribute.
	 * @see #setServiceClassName(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOSGiInvoke_ServiceClassName()
	 * @model required="true"
	 * @generated
	 */
	String getServiceClassName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OSGiInvoke#getServiceClassName <em>Service Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Class Name</em>' attribute.
	 * @see #getServiceClassName()
	 * @generated
	 */
	void setServiceClassName(String value);

	/**
	 * Returns the value of the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method Name</em>' attribute.
	 * @see #setMethodName(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOSGiInvoke_MethodName()
	 * @model required="true"
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OSGiInvoke#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Parameter Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Types</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Types</em>' attribute.
	 * @see #setParameterTypes(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOSGiInvoke_ParameterTypes()
	 * @model required="true"
	 * @generated
	 */
	String getParameterTypes();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OSGiInvoke#getParameterTypes <em>Parameter Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Types</em>' attribute.
	 * @see #getParameterTypes()
	 * @generated
	 */
	void setParameterTypes(String value);

	/**
	 * Returns the value of the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bundle Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Name</em>' attribute.
	 * @see #setBundleName(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOSGiInvoke_BundleName()
	 * @model required="true"
	 * @generated
	 */
	String getBundleName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OSGiInvoke#getBundleName <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Name</em>' attribute.
	 * @see #getBundleName()
	 * @generated
	 */
	void setBundleName(String value);

} // OSGiInvoke
