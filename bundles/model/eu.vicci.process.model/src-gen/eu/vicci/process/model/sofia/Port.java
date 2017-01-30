/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.Port#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Port#isOptional <em>Optional</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Port#getProcessStep <em>Process Step</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Port#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Port#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort()
 * @model abstract="true"
 * @generated
 */
public interface Port extends Identifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Out Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.Transition}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.Transition#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transitions</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort_OutTransitions()
	 * @see eu.vicci.process.model.sofia.Transition#getSourcePort
	 * @model opposite="sourcePort" containment="true"
	 * @generated
	 */
	EList<Transition> getOutTransitions();

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort_Optional()
	 * @model
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Port#isOptional <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Process Step</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.ProcessStep#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Step</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Step</em>' container reference.
	 * @see #setProcessStep(ProcessStep)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort_ProcessStep()
	 * @see eu.vicci.process.model.sofia.ProcessStep#getPorts
	 * @model opposite="ports" transient="false"
	 * @generated
	 */
	ProcessStep getProcessStep();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Port#getProcessStep <em>Process Step</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Step</em>' container reference.
	 * @see #getProcessStep()
	 * @generated
	 */
	void setProcessStep(ProcessStep value);

	/**
	 * Returns the value of the '<em><b>In Transitions</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.Transition#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transitions</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transitions</em>' reference.
	 * @see #setInTransitions(Transition)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort_InTransitions()
	 * @see eu.vicci.process.model.sofia.Transition#getTargetPort
	 * @model opposite="targetPort"
	 * @generated
	 */
	Transition getInTransitions();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Port#getInTransitions <em>In Transitions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Transitions</em>' reference.
	 * @see #getInTransitions()
	 * @generated
	 */
	void setInTransitions(Transition value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getPort_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Port#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

} // Port
