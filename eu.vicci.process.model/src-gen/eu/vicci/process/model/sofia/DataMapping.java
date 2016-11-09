/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.DataMapping#getSource <em>Source</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.DataMapping#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataMapping()
 * @model
 * @generated
 */
public interface DataMapping extends Identifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.DataType#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' container reference.
	 * @see #setSource(DataType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataMapping_Source()
	 * @see eu.vicci.process.model.sofia.DataType#getMappings
	 * @model opposite="mappings" required="true" transient="false"
	 * @generated
	 */
	DataType getSource();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.DataMapping#getSource <em>Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' container reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(DataType value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(DataType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataMapping_Target()
	 * @model required="true"
	 * @generated
	 */
	DataType getTarget();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.DataMapping#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(DataType value);

} // DataMapping
