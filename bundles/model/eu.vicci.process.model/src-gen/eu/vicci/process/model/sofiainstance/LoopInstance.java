/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.LoopInstance#getLoopConditionInstance <em>Loop Condition Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.LoopInstance#getPortsCopyToStartport <em>Ports Copy To Startport</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getLoopInstance()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LoopInstance extends ProcessStepInstance {
	/**
	 * Returns the value of the '<em><b>Loop Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Loop Condition Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Condition Instance</em>' containment reference.
	 * @see #setLoopConditionInstance(ConditionInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getLoopInstance_LoopConditionInstance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ConditionInstance getLoopConditionInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.LoopInstance#getLoopConditionInstance <em>Loop Condition Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Condition Instance</em>' containment reference.
	 * @see #getLoopConditionInstance()
	 * @generated
	 */
	void setLoopConditionInstance(ConditionInstance value);

	/**
	 * Returns the value of the '<em><b>Ports Copy To Startport</b></em>' map.
	 * The key is of type {@link eu.vicci.process.model.sofiainstance.EndDataPortInstance},
	 * and the value is of type {@link eu.vicci.process.model.sofiainstance.StartDataPortInstance},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports Copy To Startport</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports Copy To Startport</em>' map.
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getLoopInstance_PortsCopyToStartport()
	 * @model mapType="eu.vicci.process.model.sofiainstance.EndDataPortToStartDataPortMapInstance<eu.vicci.process.model.sofiainstance.EndDataPortInstance, eu.vicci.process.model.sofiainstance.StartDataPortInstance>"
	 * @generated
	 */
	EMap<EndDataPortInstance, StartDataPortInstance> getPortsCopyToStartport();

} // LoopInstance
