/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.CollectionTypeInstance#getCollectionItemType <em>Collection Item Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getCollectionTypeInstance()
 * @model
 * @generated
 */
public interface CollectionTypeInstance extends ComplexTypeInstance {
	/**
	 * Returns the value of the '<em><b>Collection Item Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Item Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Item Type</em>' containment reference.
	 * @see #setCollectionItemType(DataType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getCollectionTypeInstance_CollectionItemType()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataType getCollectionItemType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.CollectionTypeInstance#getCollectionItemType <em>Collection Item Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Item Type</em>' containment reference.
	 * @see #getCollectionItemType()
	 * @generated
	 */
	void setCollectionItemType(DataType value);

} // CollectionTypeInstance
