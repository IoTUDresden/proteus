/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOAP Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.SOAPInvoke#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.SOAPInvoke#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.SOAPInvoke#getWsdlUri <em>Wsdl Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.SOAPInvoke#getConfigFile <em>Config File</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getSOAPInvoke()
 * @model
 * @generated
 */
public interface SOAPInvoke extends Invoke {
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSOAPInvoke_ServerUri()
	 * @model required="true"
	 * @generated
	 */
	String getServerUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SOAPInvoke#getServerUri <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Uri</em>' attribute.
	 * @see #getServerUri()
	 * @generated
	 */
	void setServerUri(String value);

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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSOAPInvoke_MethodName()
	 * @model required="true"
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SOAPInvoke#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Wsdl Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wsdl Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wsdl Uri</em>' attribute.
	 * @see #setWsdlUri(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSOAPInvoke_WsdlUri()
	 * @model required="true"
	 * @generated
	 */
	String getWsdlUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SOAPInvoke#getWsdlUri <em>Wsdl Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wsdl Uri</em>' attribute.
	 * @see #getWsdlUri()
	 * @generated
	 */
	void setWsdlUri(String value);

	/**
	 * Returns the value of the '<em><b>Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config File</em>' attribute.
	 * @see #setConfigFile(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSOAPInvoke_ConfigFile()
	 * @model required="true"
	 * @generated
	 */
	String getConfigFile();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SOAPInvoke#getConfigFile <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config File</em>' attribute.
	 * @see #getConfigFile()
	 * @generated
	 */
	void setConfigFile(String value);

} // SOAPInvoke
