/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.CompositeStep#getSubSteps <em>Sub Steps</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getCompositeStep()
 * @model abstract="true"
 * @generated
 */
public interface CompositeStep extends ProcessStep {
	/**
	 * Returns the value of the '<em><b>Sub Steps</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.ProcessStep}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.ProcessStep#getParentstep <em>Parentstep</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Steps</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCompositeStep_SubSteps()
	 * @see eu.vicci.process.model.sofia.ProcessStep#getParentstep
	 * @model opposite="parentstep" containment="true"
	 * @generated
	 */
	EList<ProcessStep> getSubSteps();

} // CompositeStep
