/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.DataType;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getDataTypeType <em>Data Type Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo <em>Belongs To</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getIdOfOrigin <em>Id Of Origin</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataTypeInstance()
 * @model
 * @generated
 */
public interface DataTypeInstance extends InstanceIdentifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type Type</em>' reference.
	 * @see #setDataTypeType(DataType)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataTypeInstance_DataTypeType()
	 * @model required="true"
	 * @generated
	 */
	DataType getDataTypeType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getDataTypeType <em>Data Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type Type</em>' reference.
	 * @see #getDataTypeType()
	 * @generated
	 */
	void setDataTypeType(DataType value);

	/**
	 * Returns the value of the '<em><b>Belongs To</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.ComplexTypeInstance#getSubtypes <em>Subtypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belongs To</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belongs To</em>' container reference.
	 * @see #setBelongsTo(ComplexTypeInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataTypeInstance_BelongsTo()
	 * @see eu.vicci.process.model.sofiainstance.ComplexTypeInstance#getSubtypes
	 * @model opposite="subtypes" transient="false"
	 * @generated
	 */
	ComplexTypeInstance getBelongsTo();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo <em>Belongs To</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Belongs To</em>' container reference.
	 * @see #getBelongsTo()
	 * @generated
	 */
	void setBelongsTo(ComplexTypeInstance value);

	/**
	 * Returns the value of the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id Of Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id Of Origin</em>' attribute.
	 * @see #setIdOfOrigin(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataTypeInstance_IdOfOrigin()
	 * @model
	 * @generated
	 */
	String getIdOfOrigin();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getIdOfOrigin <em>Id Of Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id Of Origin</em>' attribute.
	 * @see #getIdOfOrigin()
	 * @generated
	 */
	void setIdOfOrigin(String value);

	/**
	 * Returns the value of the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type Id</em>' attribute.
	 * @see #setTypeId(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataTypeInstance_TypeId()
	 * @model required="true"
	 * @generated
	 */
	String getTypeId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getTypeId <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type Id</em>' attribute.
	 * @see #getTypeId()
	 * @generated
	 */
	void setTypeId(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void parse(String text);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	int compareTo(EObject o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String serializeToXML();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean deserializeFromXML(String xmlInstance);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	DataTypeInstance copy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	String serializeToJSON();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	boolean deserializeFromJSON(String jsonString);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValueFromString(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	Object getValueAsObject();

} // DataTypeInstance
