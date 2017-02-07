/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.StringType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getStringTypeType <em>String Type Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStringTypeInstance()
 * @model
 * @generated
 */
public interface StringTypeInstance extends DataTypeInstance {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStringTypeInstance_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>String Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>String Type Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>String Type Type</em>' reference.
	 * @see #setStringTypeType(StringType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getStringTypeInstance_StringTypeType()
	 * @model required="true"
	 * @generated
	 */
	StringType getStringTypeType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getStringTypeType <em>String Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Type Type</em>' reference.
	 * @see #getStringTypeType()
	 * @generated
	 */
	void setStringTypeType(StringType value);

} // StringTypeInstance
