/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.ForLoop#getLoopStepWidth <em>Loop Step Width</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getForLoop()
 * @model
 * @generated
 */
public interface ForLoop extends Loop {
	/**
	 * Returns the value of the '<em><b>Loop Step Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Step Width</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Step Width</em>' reference.
	 * @see #setLoopStepWidth(StartDataPort)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getForLoop_LoopStepWidth()
	 * @model
	 * @generated
	 */
	StartDataPort getLoopStepWidth();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ForLoop#getLoopStepWidth <em>Loop Step Width</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Step Width</em>' reference.
	 * @see #getLoopStepWidth()
	 * @generated
	 */
	void setLoopStepWidth(StartDataPort value);

} // ForLoop
