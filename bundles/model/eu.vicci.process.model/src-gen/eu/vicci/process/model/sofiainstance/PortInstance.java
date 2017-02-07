/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.Port;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Port Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#getPortType <em>Port Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance <em>Process Step Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#getOutTransitionInstances <em>Out Transition Instances</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#isDecoupled <em>Decoupled</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances <em>In Transition Instances</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.PortInstance#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance()
 * @model abstract="true"
 * @generated
 */
public interface PortInstance extends Stateful, InstanceIdentifiable, Nameable {
	/**
	 * Returns the value of the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port Type</em>' reference.
	 * @see #setPortType(Port)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_PortType()
	 * @model required="true"
	 * @generated
	 */
	Port getPortType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.PortInstance#getPortType <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port Type</em>' reference.
	 * @see #getPortType()
	 * @generated
	 */
	void setPortType(Port value);

	/**
	 * Returns the value of the '<em><b>Process Step Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Step Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Step Instance</em>' container reference.
	 * @see #setProcessStepInstance(ProcessStepInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_ProcessStepInstance()
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPorts
	 * @model opposite="ports" transient="false"
	 * @generated
	 */
	ProcessStepInstance getProcessStepInstance();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance <em>Process Step Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Step Instance</em>' container reference.
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	void setProcessStepInstance(ProcessStepInstance value);

	/**
	 * Returns the value of the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofiainstance.TransitionInstance}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance <em>Source Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Out Transition Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Out Transition Instances</em>' containment reference list.
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_OutTransitionInstances()
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance
	 * @model opposite="sourcePortInstance" containment="true"
	 * @generated
	 */
	EList<TransitionInstance> getOutTransitionInstances();

	/**
	 * Returns the value of the '<em><b>Decoupled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Decoupled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Decoupled</em>' attribute.
	 * @see #setDecoupled(boolean)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_Decoupled()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDecoupled();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.PortInstance#isDecoupled <em>Decoupled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Decoupled</em>' attribute.
	 * @see #isDecoupled()
	 * @generated
	 */
	void setDecoupled(boolean value);

	/**
	 * Returns the value of the '<em><b>In Transition Instances</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance <em>Target Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Transition Instances</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Transition Instances</em>' reference.
	 * @see #setInTransitionInstances(TransitionInstance)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_InTransitionInstances()
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance
	 * @model opposite="targetPortInstance"
	 * @generated
	 */
	TransitionInstance getInTransitionInstances();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances <em>In Transition Instances</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Transition Instances</em>' reference.
	 * @see #getInTransitionInstances()
	 * @generated
	 */
	void setInTransitionInstances(TransitionInstance value);

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
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getPortInstance_TypeId()
	 * @model required="true"
	 * @generated
	 */
	String getTypeId();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.PortInstance#getTypeId <em>Type Id</em>}' attribute.
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
	void deploy(MappingUtil mapper);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean activate(DataTypeInstance parameter);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deactivate();

} // PortInstance
