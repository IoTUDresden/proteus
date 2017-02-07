/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.CollectionType#getCollectionItemType <em>Collection Item Type</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getCollectionType()
 * @model
 * @generated
 */
public interface CollectionType extends DataType {
	/**
	 * Returns the value of the '<em><b>Collection Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Item Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Item Type</em>' reference.
	 * @see #setCollectionItemType(DataType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getCollectionType_CollectionItemType()
	 * @model required="true"
	 * @generated
	 */
	DataType getCollectionItemType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.CollectionType#getCollectionItemType <em>Collection Item Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Item Type</em>' reference.
	 * @see #getCollectionItemType()
	 * @generated
	 */
	void setCollectionItemType(DataType value);

} // CollectionType
