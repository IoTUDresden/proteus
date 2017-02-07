/**
 */
package eu.vicci.process.model.sofiainstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ForLoopInstance#getLoopStepWidth <em>Loop Step Width</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getForLoopInstance()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface ForLoopInstance extends LoopInstance {
	/**
	 * Returns the value of the '<em><b>Loop Step Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Step Width</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Step Width</em>' reference.
	 * @see #setLoopStepWidth(StartDataPortInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getForLoopInstance_LoopStepWidth()
	 * @model
	 * @generated
	 */
	StartDataPortInstance getLoopStepWidth();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance#getLoopStepWidth <em>Loop Step Width</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Step Width</em>' reference.
	 * @see #getLoopStepWidth()
	 * @generated
	 */
	void setLoopStepWidth(StartDataPortInstance value);

} // ForLoopInstance
