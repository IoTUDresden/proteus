/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMLRPC Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getStartParameterSequence <em>Start Parameter Sequence</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getEndParameterSequence <em>End Parameter Sequence</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getXMLRPCInvoke()
 * @model
 * @generated
 */
public interface XMLRPCInvoke extends Invoke {
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getXMLRPCInvoke_ServerUri()
	 * @model required="true"
	 * @generated
	 */
	String getServerUri();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getServerUri <em>Server Uri</em>}' attribute.
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getXMLRPCInvoke_MethodName()
	 * @model required="true"
	 * @generated
	 */
	String getMethodName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getMethodName <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method Name</em>' attribute.
	 * @see #getMethodName()
	 * @generated
	 */
	void setMethodName(String value);

	/**
	 * Returns the value of the '<em><b>Start Parameter Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Parameter Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Parameter Sequence</em>' attribute.
	 * @see #setStartParameterSequence(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getXMLRPCInvoke_StartParameterSequence()
	 * @model required="true"
	 * @generated
	 */
	String getStartParameterSequence();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getStartParameterSequence <em>Start Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Parameter Sequence</em>' attribute.
	 * @see #getStartParameterSequence()
	 * @generated
	 */
	void setStartParameterSequence(String value);

	/**
	 * Returns the value of the '<em><b>End Parameter Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Parameter Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Parameter Sequence</em>' attribute.
	 * @see #setEndParameterSequence(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getXMLRPCInvoke_EndParameterSequence()
	 * @model required="true"
	 * @generated
	 */
	String getEndParameterSequence();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getEndParameterSequence <em>End Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Parameter Sequence</em>' attribute.
	 * @see #getEndParameterSequence()
	 * @generated
	 */
	void setEndParameterSequence(String value);

} // XMLRPCInvoke
