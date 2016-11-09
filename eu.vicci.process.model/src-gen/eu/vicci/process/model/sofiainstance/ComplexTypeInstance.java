/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Complex Type Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ComplexTypeInstance#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getComplexTypeInstance()
 * @model
 * @generated
 */
public interface ComplexTypeInstance extends DataTypeInstance {
	/**
	 * Returns the value of the '<em><b>Subtypes</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofiainstance.DataTypeInstance}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtypes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtypes</em>' containment reference list.
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getComplexTypeInstance_Subtypes()
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo
	 * @model opposite="belongsTo" containment="true" required="true"
	 * @generated
	 */
	EList<DataTypeInstance> getSubtypes();

} // ComplexTypeInstance
