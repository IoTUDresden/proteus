/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stateful</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.Stateful#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.Stateful#getCpsExecutionState <em>Cps Execution State</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStateful()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface Stateful extends EObject {
	/**
	 * Returns the value of the '<em><b>Execution State</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofiainstance.State}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution State</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.State
	 * @see #setExecutionState(State)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStateful_ExecutionState()
	 * @model required="true" volatile="true"
	 * @generated
	 */
	State getExecutionState();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.Stateful#getExecutionState <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution State</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.State
	 * @see #getExecutionState()
	 * @generated
	 */
	void setExecutionState(State value);

	/**
	 * Returns the value of the '<em><b>Cps Execution State</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofiainstance.CpsState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cps Execution State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cps Execution State</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.CpsState
	 * @see #setCpsExecutionState(CpsState)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStateful_CpsExecutionState()
	 * @model
	 * @generated
	 */
	CpsState getCpsExecutionState();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.Stateful#getCpsExecutionState <em>Cps Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cps Execution State</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.CpsState
	 * @see #getCpsExecutionState()
	 * @generated
	 */
	void setCpsExecutionState(CpsState value);

} // Stateful
