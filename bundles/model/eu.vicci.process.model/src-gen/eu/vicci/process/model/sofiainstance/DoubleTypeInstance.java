/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.DoubleType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Double Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getDoubleTypeType <em>Double Type Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDoubleTypeInstance()
 * @model
 * @generated
 */
public interface DoubleTypeInstance extends DataTypeInstance {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(double)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDoubleTypeInstance_Value()
	 * @model required="true"
	 * @generated
	 */
	double getValue();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(double value);

	/**
	 * Returns the value of the '<em><b>Double Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Type Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double Type Type</em>' reference.
	 * @see #setDoubleTypeType(DoubleType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDoubleTypeInstance_DoubleTypeType()
	 * @model required="true"
	 * @generated
	 */
	DoubleType getDoubleTypeType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getDoubleTypeType <em>Double Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double Type Type</em>' reference.
	 * @see #getDoubleTypeType()
	 * @generated
	 */
	void setDoubleTypeType(DoubleType value);

} // DoubleTypeInstance
