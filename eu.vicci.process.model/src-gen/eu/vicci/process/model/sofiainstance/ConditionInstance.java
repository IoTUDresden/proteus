/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.Condition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getExpressionInstance <em>Expression Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ConditionInstance#isResult <em>Result</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getIfConditionType <em>If Condition Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getLeftSide <em>Left Side</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getRightSide <em>Right Side</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance()
 * @model
 * @generated
 */
public interface ConditionInstance extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression Instance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression Instance</em>' attribute.
	 * @see #setExpressionInstance(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance_ExpressionInstance()
	 * @model required="true"
	 * @generated
	 */
	String getExpressionInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getExpressionInstance <em>Expression Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression Instance</em>' attribute.
	 * @see #getExpressionInstance()
	 * @generated
	 */
	void setExpressionInstance(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(boolean)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance_Result()
	 * @model required="true"
	 * @generated
	 */
	boolean isResult();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#isResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #isResult()
	 * @generated
	 */
	void setResult(boolean value);

	/**
	 * Returns the value of the '<em><b>If Condition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>If Condition Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>If Condition Type</em>' reference.
	 * @see #setIfConditionType(Condition)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance_IfConditionType()
	 * @model required="true"
	 * @generated
	 */
	Condition getIfConditionType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getIfConditionType <em>If Condition Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>If Condition Type</em>' reference.
	 * @see #getIfConditionType()
	 * @generated
	 */
	void setIfConditionType(Condition value);

	/**
	 * Returns the value of the '<em><b>Left Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Side</em>' reference.
	 * @see #setLeftSide(StartDataPortInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance_LeftSide()
	 * @model
	 * @generated
	 */
	StartDataPortInstance getLeftSide();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getLeftSide <em>Left Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left Side</em>' reference.
	 * @see #getLeftSide()
	 * @generated
	 */
	void setLeftSide(StartDataPortInstance value);

	/**
	 * Returns the value of the '<em><b>Right Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Side</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Side</em>' reference.
	 * @see #setRightSide(StartDataPortInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getConditionInstance_RightSide()
	 * @model
	 * @generated
	 */
	StartDataPortInstance getRightSide();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getRightSide <em>Right Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right Side</em>' reference.
	 * @see #getRightSide()
	 * @generated
	 */
	void setRightSide(StartDataPortInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean evaluate();

} // ConditionInstance
