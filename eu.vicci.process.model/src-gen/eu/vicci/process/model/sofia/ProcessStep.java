/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.ProcessStep#getParentstep <em>Parentstep</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ProcessStep#getPorts <em>Ports</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ProcessStep#getType <em>Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ProcessStep#getDescription <em>Description</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ProcessStep#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep()
 * @model abstract="true"
 * @generated
 */
public interface ProcessStep extends Identifiable, Nameable, CpsStep {
	/**
	 * Returns the value of the '<em><b>Parentstep</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.CompositeStep#getSubSteps <em>Sub Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parentstep</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parentstep</em>' container reference.
	 * @see #setParentstep(CompositeStep)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep_Parentstep()
	 * @see eu.vicci.process.model.sofia.CompositeStep#getSubSteps
	 * @model opposite="subSteps" transient="false"
	 * @generated
	 */
	CompositeStep getParentstep();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ProcessStep#getParentstep <em>Parentstep</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parentstep</em>' container reference.
	 * @see #getParentstep()
	 * @generated
	 */
	void setParentstep(CompositeStep value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.Port}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.Port#getProcessStep <em>Process Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep_Ports()
	 * @see eu.vicci.process.model.sofia.Port#getProcessStep
	 * @model opposite="processStep" containment="true" required="true"
	 * @generated
	 */
	EList<Port> getPorts();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ProcessStep#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ProcessStep#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' attribute.
	 * @see #setResource(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getProcessStep_Resource()
	 * @model
	 * @generated
	 */
	String getResource();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.ProcessStep#getResource <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' attribute.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(String value);

} // ProcessStep
