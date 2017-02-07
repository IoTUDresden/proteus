/**
 */
package eu.vicci.process.model.sofiainstance;

import java.util.Map;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessInstance()
 * @model
 * @generated
 */
public interface ProcessInstance extends ProcessStepInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean start(Map<String, DataTypeInstance> parameters);

} // ProcessInstance
