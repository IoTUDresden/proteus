/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.Condition#getComparator <em>Comparator</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Condition#getLeftSide <em>Left Side</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.Condition#getRightSide <em>Right Side</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getCondition()
 * @model
 * @generated
 */
public interface Condition extends EObject {
	/**
	 * Returns the value of the '<em><b>Comparator</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofia.Comparator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comparator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comparator</em>' attribute.
	 * @see eu.vicci.process.model.sofia.Comparator
	 * @see #setComparator(Comparator)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCondition_Comparator()
	 * @model required="true"
	 * @generated
	 */
	Comparator getComparator();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Condition#getComparator <em>Comparator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comparator</em>' attribute.
	 * @see eu.vicci.process.model.sofia.Comparator
	 * @see #getComparator()
	 * @generated
	 */
	void setComparator(Comparator value);

	/**
	 * Returns the value of the '<em><b>Left Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Side</em>' reference.
	 * @see #setLeftSide(StartDataPort)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCondition_LeftSide()
	 * @model
	 * @generated
	 */
	StartDataPort getLeftSide();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Condition#getLeftSide <em>Left Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Side</em>' reference.
	 * @see #getLeftSide()
	 * @generated
	 */
	void setLeftSide(StartDataPort value);

	/**
	 * Returns the value of the '<em><b>Right Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Side</em>' reference.
	 * @see #setRightSide(StartDataPort)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCondition_RightSide()
	 * @model
	 * @generated
	 */
	StartDataPort getRightSide();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.Condition#getRightSide <em>Right Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Side</em>' reference.
	 * @see #getRightSide()
	 * @generated
	 */
	void setRightSide(StartDataPort value);

} // Condition
