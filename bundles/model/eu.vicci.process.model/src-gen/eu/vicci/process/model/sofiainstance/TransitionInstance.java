/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.Transition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTransitionType <em>Transition Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance <em>Source Port Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance <em>Target Port Instance</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getTransitionInstance()
 * @model
 * @generated
 */
public interface TransitionInstance extends InstanceIdentifiable {
	/**
	 * Returns the value of the '<em><b>Transition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition Type</em>' reference.
	 * @see #setTransitionType(Transition)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getTransitionInstance_TransitionType()
	 * @model required="true"
	 * @generated
	 */
	Transition getTransitionType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTransitionType <em>Transition Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition Type</em>' reference.
	 * @see #getTransitionType()
	 * @generated
	 */
	void setTransitionType(Transition value);

	/**
	 * Returns the value of the '<em><b>Source Port Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.PortInstance#getOutTransitionInstances <em>Out Transition Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Port Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Port Instance</em>' container reference.
	 * @see #setSourcePortInstance(PortInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getTransitionInstance_SourcePortInstance()
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getOutTransitionInstances
	 * @model opposite="outTransitionInstances" required="true" transient="false"
	 * @generated
	 */
	PortInstance getSourcePortInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance <em>Source Port Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Port Instance</em>' container reference.
	 * @see #getSourcePortInstance()
	 * @generated
	 */
	void setSourcePortInstance(PortInstance value);

	/**
	 * Returns the value of the '<em><b>Target Port Instance</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances <em>In Transition Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Port Instance</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Port Instance</em>' reference.
	 * @see #setTargetPortInstance(PortInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getTransitionInstance_TargetPortInstance()
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances
	 * @model opposite="inTransitionInstances" required="true"
	 * @generated
	 */
	PortInstance getTargetPortInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance <em>Target Port Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Port Instance</em>' reference.
	 * @see #getTargetPortInstance()
	 * @generated
	 */
	void setTargetPortInstance(PortInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deploy(MappingUtil mapper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean execute(DataTypeInstance parameter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deactivate();

} // TransitionInstance
