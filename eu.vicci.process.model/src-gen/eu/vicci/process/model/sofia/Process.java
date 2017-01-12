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
 *   <li>{@link eu.vicci.process.model.sofia.Process#getExecutionPeer <em>Execution Peer</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Process#isDistributed <em>Distributed</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Process#isRemoteExecuting <em>Remote Executing</em>}</li>
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

	/**
	 * Returns the value of the '<em><b>Execution Peer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Peer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Peer</em>' attribute.
	 * @see #setExecutionPeer(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcess_ExecutionPeer()
	 * @model
	 * @generated
	 */
	String getExecutionPeer();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Process#getExecutionPeer <em>Execution Peer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Peer</em>' attribute.
	 * @see #getExecutionPeer()
	 * @generated
	 */
	void setExecutionPeer(String value);

	/**
	 * Returns the value of the '<em><b>Distributed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Distributed</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Distributed</em>' attribute.
	 * @see #setDistributed(boolean)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcess_Distributed()
	 * @model
	 * @generated
	 */
	boolean isDistributed();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Process#isDistributed <em>Distributed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Distributed</em>' attribute.
	 * @see #isDistributed()
	 * @generated
	 */
	void setDistributed(boolean value);

	/**
	 * Returns the value of the '<em><b>Remote Executing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remote Executing</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remote Executing</em>' attribute.
	 * @see #setRemoteExecuting(boolean)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcess_RemoteExecuting()
	 * @model
	 * @generated
	 */
	boolean isRemoteExecuting();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Process#isRemoteExecuting <em>Remote Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remote Executing</em>' attribute.
	 * @see #isRemoteExecuting()
	 * @generated
	 */
	void setRemoteExecuting(boolean value);

} // Process
