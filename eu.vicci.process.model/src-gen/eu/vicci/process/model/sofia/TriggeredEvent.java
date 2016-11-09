/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Triggered Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.TriggeredEvent#getEPLStatement <em>EPL Statement</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getTriggeredEvent()
 * @model
 * @generated
 */
public interface TriggeredEvent extends Event {
	/**
	 * Returns the value of the '<em><b>EPL Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EPL Statement</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EPL Statement</em>' attribute.
	 * @see #setEPLStatement(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getTriggeredEvent_EPLStatement()
	 * @model required="true"
	 * @generated
	 */
	String getEPLStatement();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.TriggeredEvent#getEPLStatement <em>EPL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>EPL Statement</em>' attribute.
	 * @see #getEPLStatement()
	 * @generated
	 */
	void setEPLStatement(String value);

} // TriggeredEvent
