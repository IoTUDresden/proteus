/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.DataType#getBelongsTo <em>Belongs To</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.DataType#getMappings <em>Mappings</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.DataType#getPortMembers <em>Port Members</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataType()
 * @model abstract="true"
 * @generated
 */
public interface DataType extends Nameable, Identifiable {
	/**
	 * Returns the value of the '<em><b>Belongs To</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.ComplexType#getSubtypes <em>Subtypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Belongs To</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Belongs To</em>' container reference.
	 * @see #setBelongsTo(ComplexType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataType_BelongsTo()
	 * @see eu.vicci.process.model.sofia.ComplexType#getSubtypes
	 * @model opposite="subtypes" transient="false"
	 * @generated
	 */
	ComplexType getBelongsTo();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.DataType#getBelongsTo <em>Belongs To</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Belongs To</em>' container reference.
	 * @see #getBelongsTo()
	 * @generated
	 */
	void setBelongsTo(ComplexType value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataMapping}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.DataMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataType_Mappings()
	 * @see eu.vicci.process.model.sofia.DataMapping#getSource
	 * @model opposite="source" containment="true"
	 * @generated
	 */
	EList<DataMapping> getMappings();

	/**
	 * Returns the value of the '<em><b>Port Members</b></em>' reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataPort}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.DataPort#getPortDatatype <em>Port Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Members</em>' reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataType_PortMembers()
	 * @see eu.vicci.process.model.sofia.DataPort#getPortDatatype
	 * @model opposite="portDatatype"
	 * @generated
	 */
	EList<DataPort> getPortMembers();

} // DataType
