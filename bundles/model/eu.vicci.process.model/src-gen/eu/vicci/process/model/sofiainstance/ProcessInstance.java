/**
 */
package eu.vicci.process.model.sofiainstance;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessInstance#getRunningForInstanceId <em>Running For Instance Id</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessInstance()
 * @model
 * @generated
 */
public interface ProcessInstance extends ProcessStepInstance {
	/**
	 * Returns the value of the '<em><b>Running For Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Running For Instance Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Running For Instance Id</em>' attribute.
	 * @see #setRunningForInstanceId(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessInstance_RunningForInstanceId()
	 * @model
	 * @generated
	 */
	String getRunningForInstanceId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessInstance#getRunningForInstanceId <em>Running For Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Running For Instance Id</em>' attribute.
	 * @see #getRunningForInstanceId()
	 * @generated
	 */
	void setRunningForInstanceId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean start(Map<String, DataTypeInstance> parameters);

} // ProcessInstance
