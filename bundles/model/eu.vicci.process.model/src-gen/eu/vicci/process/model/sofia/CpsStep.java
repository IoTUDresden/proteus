/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cps Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#isCyberPhysical <em>Cyber Physical</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#getGoal <em>Goal</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#getEplQuery <em>Epl Query</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#getControlProcessId <em>Control Process Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#getControlProcess <em>Control Process</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.CpsStep#getContext <em>Context</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CpsStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cyber Physical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cyber Physical</em>' attribute.
	 * @see #setCyberPhysical(boolean)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_CyberPhysical()
	 * @model
	 * @generated
	 */
	boolean isCyberPhysical();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#isCyberPhysical <em>Cyber Physical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cyber Physical</em>' attribute.
	 * @see #isCyberPhysical()
	 * @generated
	 */
	void setCyberPhysical(boolean value);

	/**
	 * Returns the value of the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Goal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Goal</em>' attribute.
	 * @see #setGoal(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_Goal()
	 * @model
	 * @generated
	 */
	String getGoal();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#getGoal <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Goal</em>' attribute.
	 * @see #getGoal()
	 * @generated
	 */
	void setGoal(String value);

	/**
	 * Returns the value of the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Epl Query</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Epl Query</em>' attribute.
	 * @see #setEplQuery(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_EplQuery()
	 * @model
	 * @generated
	 */
	String getEplQuery();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#getEplQuery <em>Epl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Epl Query</em>' attribute.
	 * @see #getEplQuery()
	 * @generated
	 */
	void setEplQuery(String value);

	/**
	 * Returns the value of the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Process Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Process Id</em>' attribute.
	 * @see #setControlProcessId(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_ControlProcessId()
	 * @model
	 * @generated
	 */
	String getControlProcessId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#getControlProcessId <em>Control Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Process Id</em>' attribute.
	 * @see #getControlProcessId()
	 * @generated
	 */
	void setControlProcessId(String value);

	/**
	 * Returns the value of the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Control Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Control Process</em>' reference.
	 * @see #setControlProcess(eu.vicci.process.model.sofia.Process)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_ControlProcess()
	 * @model
	 * @generated
	 */
	eu.vicci.process.model.sofia.Process getControlProcess();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#getControlProcess <em>Control Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Control Process</em>' reference.
	 * @see #getControlProcess()
	 * @generated
	 */
	void setControlProcess(eu.vicci.process.model.sofia.Process value);

	/**
	 * Returns the value of the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' attribute.
	 * @see #setContext(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCpsStep_Context()
	 * @model
	 * @generated
	 */
	String getContext();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CpsStep#getContext <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' attribute.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(String value);

} // CpsStep
