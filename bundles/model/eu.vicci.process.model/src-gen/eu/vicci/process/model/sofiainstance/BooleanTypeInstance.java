/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.BooleanType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#isValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#getBooleanTypeType <em>Boolean Type Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getBooleanTypeInstance()
 * @model
 * @generated
 */
public interface BooleanTypeInstance extends DataTypeInstance {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(boolean)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getBooleanTypeInstance_Value()
	 * @model required="true"
	 * @generated
	 */
	boolean isValue();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#isValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #isValue()
	 * @generated
	 */
	void setValue(boolean value);

	/**
	 * Returns the value of the '<em><b>Boolean Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boolean Type Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boolean Type Type</em>' reference.
	 * @see #setBooleanTypeType(BooleanType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getBooleanTypeInstance_BooleanTypeType()
	 * @model required="true"
	 * @generated
	 */
	BooleanType getBooleanTypeType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#getBooleanTypeType <em>Boolean Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boolean Type Type</em>' reference.
	 * @see #getBooleanTypeType()
	 * @generated
	 */
	void setBooleanTypeType(BooleanType value);

} // BooleanTypeInstance
