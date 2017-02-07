/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.IntegerType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getIntegerTypeType <em>Integer Type Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getIntegerTypeInstance()
 * @model
 * @generated
 */
public interface IntegerTypeInstance extends DataTypeInstance {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(int)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getIntegerTypeInstance_Value()
	 * @model required="true"
	 * @generated
	 */
	int getValue();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(int value);

	/**
	 * Returns the value of the '<em><b>Integer Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Type Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Type Type</em>' reference.
	 * @see #setIntegerTypeType(IntegerType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getIntegerTypeInstance_IntegerTypeType()
	 * @model required="true"
	 * @generated
	 */
	IntegerType getIntegerTypeType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getIntegerTypeType <em>Integer Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Type Type</em>' reference.
	 * @see #getIntegerTypeType()
	 * @generated
	 */
	void setIntegerTypeType(IntegerType value);

} // IntegerTypeInstance
