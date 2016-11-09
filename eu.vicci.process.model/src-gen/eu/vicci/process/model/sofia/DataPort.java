/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.DataPort#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.DataPort#getPortDatatype <em>Port Datatype</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.DataPort#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataPort()
 * @model abstract="true"
 * @generated
 */
public interface DataPort extends Port {
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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataPort_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.DataPort#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Port Datatype</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofia.DataType#getPortMembers <em>Port Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Datatype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Datatype</em>' reference.
	 * @see #setPortDatatype(DataType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataPort_PortDatatype()
	 * @see eu.vicci.process.model.sofia.DataType#getPortMembers
	 * @model opposite="portMembers" required="true"
	 * @generated
	 */
	DataType getPortDatatype();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.DataPort#getPortDatatype <em>Port Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Datatype</em>' reference.
	 * @see #getPortDatatype()
	 * @generated
	 */
	void setPortDatatype(DataType value);

	/**
	 * Returns the value of the '<em><b>Mappings</b></em>' reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofia.DataMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mappings</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mappings</em>' reference list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getDataPort_Mappings()
	 * @model
	 * @generated
	 */
	EList<DataMapping> getMappings();

} // DataPort
