/**
 */
package eu.vicci.process.model.sofiainstance;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Port Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.DataPortInstance#getDataInstance <em>Data Instance</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataPortInstance()
 * @model abstract="true"
 * @generated
 */
public interface DataPortInstance extends PortInstance {
	/**
	 * Returns the value of the '<em><b>Data Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Instance</em>' containment reference.
	 * @see #setDataInstance(DataTypeInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getDataPortInstance_DataInstance()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DataTypeInstance getDataInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.DataPortInstance#getDataInstance <em>Data Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Instance</em>' containment reference.
	 * @see #getDataInstance()
	 * @generated
	 */
	void setDataInstance(DataTypeInstance value);

} // DataPortInstance
