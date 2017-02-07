/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Instance Identifiable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstanceId <em>Instance Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstancenumber <em>Instancenumber</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getInstanceIdentifiable()
 * @model abstract="true"
 * @generated
 */
public interface InstanceIdentifiable extends EObject {
	/**
	 * Returns the value of the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Id</em>' attribute.
	 * @see #setInstanceId(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getInstanceIdentifiable_InstanceId()
	 * @model required="true"
	 * @generated
	 */
	String getInstanceId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstanceId <em>Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instance Id</em>' attribute.
	 * @see #getInstanceId()
	 * @generated
	 */
	void setInstanceId(String value);

	/**
	 * Returns the value of the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instancenumber</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instancenumber</em>' attribute.
	 * @see #setInstancenumber(int)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getInstanceIdentifiable_Instancenumber()
	 * @model required="true"
	 * @generated
	 */
	int getInstancenumber();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstancenumber <em>Instancenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Instancenumber</em>' attribute.
	 * @see #getInstancenumber()
	 * @generated
	 */
	void setInstancenumber(int value);

} // InstanceIdentifiable
