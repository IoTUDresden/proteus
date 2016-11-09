/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.Process#getDataTypeDefinitions <em>Data Type Definitions</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcess()
 * @model
 * @generated
 */
public interface Process extends CompositeStep {
	/**
	 * Returns the value of the '<em><b>Data Type Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Definitions</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcess_DataTypeDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataType> getDataTypeDefinitions();

} // Process
