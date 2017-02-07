/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open Hab Semantic Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getQuery <em>Query</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getServerBaseAddress <em>Server Base Address</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#isWithLatest <em>With Latest</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getOpenHabSemanticInvoke()
 * @model abstract="true"
 * @generated
 */
public interface OpenHabSemanticInvoke extends Invoke {
	/**
	 * Returns the value of the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Query</em>' attribute.
	 * @see #setQuery(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOpenHabSemanticInvoke_Query()
	 * @model
	 * @generated
	 */
	String getQuery();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getQuery <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' attribute.
	 * @see #getQuery()
	 * @generated
	 */
	void setQuery(String value);

	/**
	 * Returns the value of the '<em><b>Server Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Server Base Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Base Address</em>' attribute.
	 * @see #setServerBaseAddress(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOpenHabSemanticInvoke_ServerBaseAddress()
	 * @model
	 * @generated
	 */
	String getServerBaseAddress();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getServerBaseAddress <em>Server Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Base Address</em>' attribute.
	 * @see #getServerBaseAddress()
	 * @generated
	 */
	void setServerBaseAddress(String value);

	/**
	 * Returns the value of the '<em><b>With Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>With Latest</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>With Latest</em>' attribute.
	 * @see #setWithLatest(boolean)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getOpenHabSemanticInvoke_WithLatest()
	 * @model
	 * @generated
	 */
	boolean isWithLatest();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#isWithLatest <em>With Latest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>With Latest</em>' attribute.
	 * @see #isWithLatest()
	 * @generated
	 */
	void setWithLatest(boolean value);

} // OpenHabSemanticInvoke
