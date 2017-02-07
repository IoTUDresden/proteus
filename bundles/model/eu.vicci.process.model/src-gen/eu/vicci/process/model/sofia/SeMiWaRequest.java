/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Se Mi Wa Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.SeMiWaRequest#getSSILStatement <em>SSIL Statement</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getSeMiWaRequest()
 * @model
 * @generated
 */
public interface SeMiWaRequest extends AtomicStep {
	/**
	 * Returns the value of the '<em><b>SSIL Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SSIL Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SSIL Statement</em>' attribute.
	 * @see #setSSILStatement(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getSeMiWaRequest_SSILStatement()
	 * @model required="true"
	 * @generated
	 */
	String getSSILStatement();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.SeMiWaRequest#getSSILStatement <em>SSIL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SSIL Statement</em>' attribute.
	 * @see #getSSILStatement()
	 * @generated
	 */
	void setSSILStatement(String value);

} // SeMiWaRequest
