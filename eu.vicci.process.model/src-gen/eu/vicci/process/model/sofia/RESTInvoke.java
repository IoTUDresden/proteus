/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>REST Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.RESTInvoke#getHTTPMethod <em>HTTP Method</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.RESTInvoke#getServerUri <em>Server Uri</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getRESTInvoke()
 * @model
 * @generated
 */
public interface RESTInvoke extends Invoke {
	/**
	 * Returns the value of the '<em><b>HTTP Method</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofia.HTTPverb}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>HTTP Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>HTTP Method</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HTTPverb
	 * @see #setHTTPMethod(HTTPverb)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getRESTInvoke_HTTPMethod()
	 * @model required="true"
	 * @generated
	 */
	HTTPverb getHTTPMethod();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.RESTInvoke#getHTTPMethod <em>HTTP Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>HTTP Method</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HTTPverb
	 * @see #getHTTPMethod()
	 * @generated
	 */
	void setHTTPMethod(HTTPverb value);

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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getRESTInvoke_ServerUri()
	 * @model required="true"
	 * @generated
	 */
	String getServerUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.RESTInvoke#getServerUri <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Uri</em>' attribute.
	 * @see #getServerUri()
	 * @generated
	 */
	void setServerUri(String value);

} // RESTInvoke
