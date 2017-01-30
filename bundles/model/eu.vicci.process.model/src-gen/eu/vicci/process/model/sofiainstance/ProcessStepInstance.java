/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.ProcessStep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Step Instance</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessStepType <em>Process Step Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getDelay <em>Delay</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPorts <em>Ports</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getSubSteps <em>Sub Steps</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessInstanceID <em>Process Instance ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessModelID <em>Process Model ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getModelID <em>Model ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#isCyberPhysical <em>Cyber Physical</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance()
 * @model
 * @generated
 */
public interface ProcessStepInstance extends Stateful, InstanceIdentifiable {
	/**
	 * Returns the value of the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Step Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Step Type</em>' reference.
	 * @see #setProcessStepType(ProcessStep)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_ProcessStepType()
	 * @model required="true"
	 * @generated
	 */
	ProcessStep getProcessStepType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessStepType <em>Process Step Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Step Type</em>' reference.
	 * @see #getProcessStepType()
	 * @generated
	 */
	void setProcessStepType(ProcessStep value);

	/**
	 * Returns the value of the '<em><b>Permission</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofiainstance.ExecutionPermission}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Permission</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Permission</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @see #setPermission(ExecutionPermission)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_Permission()
	 * @model required="true"
	 * @generated
	 */
	ExecutionPermission getPermission();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPermission <em>Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Permission</em>' attribute.
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @see #getPermission()
	 * @generated
	 */
	void setPermission(ExecutionPermission value);

	/**
	 * Returns the value of the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Delay</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Delay</em>' attribute.
	 * @see #setDelay(long)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_Delay()
	 * @model
	 * @generated
	 */
	long getDelay();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getDelay <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Delay</em>' attribute.
	 * @see #getDelay()
	 * @generated
	 */
	void setDelay(long value);

	/**
	 * Returns the value of the '<em><b>Ports</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofiainstance.PortInstance}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance <em>Process Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ports</em>' containment reference list.
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_Ports()
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance
	 * @model opposite="processStepInstance" containment="true" required="true"
	 * @generated
	 */
	EList<PortInstance> getPorts();

	/**
	 * Returns the value of the '<em><b>Sub Steps</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.model.sofiainstance.ProcessStepInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Steps</em>' containment reference list.
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_SubSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<ProcessStepInstance> getSubSteps();

	/**
	 * Returns the value of the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Instance ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Instance ID</em>' attribute.
	 * @see #setProcessInstanceID(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_ProcessInstanceID()
	 * @model
	 * @generated
	 */
	String getProcessInstanceID();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessInstanceID <em>Process Instance ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Instance ID</em>' attribute.
	 * @see #getProcessInstanceID()
	 * @generated
	 */
	void setProcessInstanceID(String value);

	/**
	 * Returns the value of the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Model ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Model ID</em>' attribute.
	 * @see #setProcessModelID(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_ProcessModelID()
	 * @model
	 * @generated
	 */
	String getProcessModelID();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessModelID <em>Process Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Model ID</em>' attribute.
	 * @see #getProcessModelID()
	 * @generated
	 */
	void setProcessModelID(String value);

	/**
	 * Returns the value of the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Model ID</em>' attribute.
	 * @see #setModelID(String)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_ModelID()
	 * @model required="true"
	 * @generated
	 */
	String getModelID();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getModelID <em>Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model ID</em>' attribute.
	 * @see #getModelID()
	 * @generated
	 */
	void setModelID(String value);

	/**
	 * Returns the value of the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cyber Physical</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cyber Physical</em>' attribute.
	 * @see #setCyberPhysical(boolean)
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getProcessStepInstance_CyberPhysical()
	 * @model
	 * @generated
	 */
	boolean isCyberPhysical();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#isCyberPhysical <em>Cyber Physical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cyber Physical</em>' attribute.
	 * @see #isCyberPhysical()
	 * @generated
	 */
	void setCyberPhysical(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean execute();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void stop();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void pause();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void kill();

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
	 * @model
	 * @generated
	 */
	String configure(Configuration Configuration);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void escalate();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resume();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void deactivate();

} // ProcessStepInstance
