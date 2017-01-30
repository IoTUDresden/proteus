/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.ComplexType#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.ComplexType#getSubreferences <em>Subreferences</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getComplexType()
 * @model
 * @generated
 */
public interface ComplexType extends DataType {
	/**
	 * Returns the value of the '<em><b>Subtypes</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataType}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.DataType#getBelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtypes</em>' containment reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getComplexType_Subtypes()
	 * @see eu.vicci.process.model.sofia.DataType#getBelongsTo
	 * @model opposite="belongsTo" containment="true"
	 * @generated
	 */
	EList<DataType> getSubtypes();

	/**
	 * Returns the value of the '<em><b>Subreferences</b></em>' reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subreferences</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subreferences</em>' reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getComplexType_Subreferences()
	 * @model
	 * @generated
	 */
	EList<DataType> getSubreferences();

} // ComplexType
