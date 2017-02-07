/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.Loop#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Loop#getPortsCopyToStartsport <em>Ports Copy To Startsport</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getLoop()
 * @model abstract="true"
 * @generated
 */
public interface Loop extends CompositeStep {
	/**
	 * Returns the value of the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Condition</em>' containment reference.
	 * @see #setLoopCondition(Condition)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getLoop_LoopCondition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Condition getLoopCondition();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Loop#getLoopCondition <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Condition</em>' containment reference.
	 * @see #getLoopCondition()
	 * @generated
	 */
	void setLoopCondition(Condition value);

	/**
	 * Returns the value of the '<em><b>Ports Copy To Startsport</b></em>' map.
	 * The key is of type {@link eu.vicci.process.model.sofia.EndDataPort},
	 * and the value is of type {@link eu.vicci.process.model.sofia.StartDataPort},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports Copy To Startsport</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports Copy To Startsport</em>' map.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getLoop_PortsCopyToStartsport()
	 * @model mapType="eu.vicci.process.model.sofia.EndDataPortToStartDataPortMap<eu.vicci.process.model.sofia.EndDataPort, eu.vicci.process.model.sofia.StartDataPort>"
	 * @generated
	 */
	EMap<EndDataPort, StartDataPort> getPortsCopyToStartsport();

} // Loop
