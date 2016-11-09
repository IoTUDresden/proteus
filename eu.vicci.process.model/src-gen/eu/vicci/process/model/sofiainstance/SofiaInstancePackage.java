/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstanceFactory
 * @model kind="package"
 * @generated
 */
public interface SofiaInstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sofiainstance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://vicci.eu/sofiainstance/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sofiainstance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SofiaInstancePackage eINSTANCE = eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.Stateful <em>Stateful</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.Stateful
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStateful()
	 * @generated
	 */
	int STATEFUL = 2;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL__EXECUTION_STATE = 0;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL__CPS_EXECUTION_STATE = 1;

	/**
	 * The number of structural features of the '<em>Stateful</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEFUL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl <em>Process Step Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessStepInstance()
	 * @generated
	 */
	int PROCESS_STEP_INSTANCE = 1;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__EXECUTION_STATE = STATEFUL__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE = STATEFUL__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__INSTANCE_ID = STATEFUL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__INSTANCENUMBER = STATEFUL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE = STATEFUL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__PERMISSION = STATEFUL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__DELAY = STATEFUL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__PORTS = STATEFUL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__SUB_STEPS = STATEFUL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID = STATEFUL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID = STATEFUL_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__MODEL_ID = STATEFUL_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE__CYBER_PHYSICAL = STATEFUL_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Process Step Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_INSTANCE_FEATURE_COUNT = STATEFUL_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ProcessInstanceImpl <em>Process Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ProcessInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessInstance()
	 * @generated
	 */
	int PROCESS_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Process Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl <em>Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getPortInstance()
	 * @generated
	 */
	int PORT_INSTANCE = 3;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__EXECUTION_STATE = STATEFUL__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__CPS_EXECUTION_STATE = STATEFUL__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__INSTANCE_ID = STATEFUL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__INSTANCENUMBER = STATEFUL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__NAME = STATEFUL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PORT_TYPE = STATEFUL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__PROCESS_STEP_INSTANCE = STATEFUL_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__OUT_TRANSITION_INSTANCES = STATEFUL_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__DECOUPLED = STATEFUL_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__IN_TRANSITION_INSTANCES = STATEFUL_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE__TYPE_ID = STATEFUL_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_INSTANCE_FEATURE_COUNT = STATEFUL_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.InstanceIdentifiableImpl <em>Instance Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.InstanceIdentifiableImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getInstanceIdentifiable()
	 * @generated
	 */
	int INSTANCE_IDENTIFIABLE = 4;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_IDENTIFIABLE__INSTANCE_ID = 0;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_IDENTIFIABLE__INSTANCENUMBER = 1;

	/**
	 * The number of structural features of the '<em>Instance Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_IDENTIFIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.EventInstance <em>Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.EventInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEventInstance()
	 * @generated
	 */
	int EVENT_INSTANCE = 5;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Time Stamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE__TIME_STAMP = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl <em>Data Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataTypeInstance()
	 * @generated
	 */
	int DATA_TYPE_INSTANCE = 19;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__INSTANCE_ID = INSTANCE_IDENTIFIABLE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__INSTANCENUMBER = INSTANCE_IDENTIFIABLE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__NAME = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__DATA_TYPE_TYPE = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__BELONGS_TO = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__ID_OF_ORIGIN = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE__TYPE_ID = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Data Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_INSTANCE_FEATURE_COUNT = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl <em>String Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStringTypeInstance()
	 * @generated
	 */
	int STRING_TYPE_INSTANCE = 6;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__INSTANCE_ID = DATA_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__INSTANCENUMBER = DATA_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__NAME = DATA_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__DATA_TYPE_TYPE = DATA_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__BELONGS_TO = DATA_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__ID_OF_ORIGIN = DATA_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__TYPE_ID = DATA_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__VALUE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>String Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE__STRING_TYPE_TYPE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>String Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_INSTANCE_FEATURE_COUNT = DATA_TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl <em>Integer Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getIntegerTypeInstance()
	 * @generated
	 */
	int INTEGER_TYPE_INSTANCE = 7;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__INSTANCE_ID = DATA_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__INSTANCENUMBER = DATA_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__NAME = DATA_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__DATA_TYPE_TYPE = DATA_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__BELONGS_TO = DATA_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__ID_OF_ORIGIN = DATA_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__TYPE_ID = DATA_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__VALUE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Integer Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_INSTANCE_FEATURE_COUNT = DATA_TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl <em>Double Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDoubleTypeInstance()
	 * @generated
	 */
	int DOUBLE_TYPE_INSTANCE = 8;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__INSTANCE_ID = DATA_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__INSTANCENUMBER = DATA_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__NAME = DATA_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__DATA_TYPE_TYPE = DATA_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__BELONGS_TO = DATA_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__ID_OF_ORIGIN = DATA_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__TYPE_ID = DATA_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__VALUE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Double Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Double Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_INSTANCE_FEATURE_COUNT = DATA_TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl <em>Boolean Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getBooleanTypeInstance()
	 * @generated
	 */
	int BOOLEAN_TYPE_INSTANCE = 9;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__INSTANCE_ID = DATA_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__INSTANCENUMBER = DATA_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__NAME = DATA_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__DATA_TYPE_TYPE = DATA_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__BELONGS_TO = DATA_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__ID_OF_ORIGIN = DATA_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__TYPE_ID = DATA_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__VALUE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Boolean Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE = DATA_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Boolean Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_INSTANCE_FEATURE_COUNT = DATA_TYPE_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl <em>Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTransitionInstance()
	 * @generated
	 */
	int TRANSITION_INSTANCE = 10;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__INSTANCE_ID = INSTANCE_IDENTIFIABLE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__INSTANCENUMBER = INSTANCE_IDENTIFIABLE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Transition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__TRANSITION_TYPE = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Port Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Port Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE__TARGET_PORT_INSTANCE = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_INSTANCE_FEATURE_COUNT = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.DataPortInstanceImpl <em>Data Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.DataPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataPortInstance()
	 * @generated
	 */
	int DATA_PORT_INSTANCE = 11;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__EXECUTION_STATE = PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__CPS_EXECUTION_STATE = PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__INSTANCE_ID = PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__INSTANCENUMBER = PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__NAME = PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__PORT_TYPE = PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__PROCESS_STEP_INSTANCE = PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__DECOUPLED = PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__IN_TRANSITION_INSTANCES = PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__TYPE_ID = PORT_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Data Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE__DATA_INSTANCE = PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_INSTANCE_FEATURE_COUNT = PORT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ControlPortInstanceImpl <em>Control Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ControlPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getControlPortInstance()
	 * @generated
	 */
	int CONTROL_PORT_INSTANCE = 12;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__EXECUTION_STATE = PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE = PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__INSTANCE_ID = PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__INSTANCENUMBER = PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__NAME = PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__PORT_TYPE = PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE = PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__DECOUPLED = PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES = PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE__TYPE_ID = PORT_INSTANCE__TYPE_ID;

	/**
	 * The number of structural features of the '<em>Control Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_INSTANCE_FEATURE_COUNT = PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.StartPortInstance <em>Start Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.StartPortInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartPortInstance()
	 * @generated
	 */
	int START_PORT_INSTANCE = 13;

	/**
	 * The number of structural features of the '<em>Start Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_PORT_INSTANCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.EndPortInstance <em>End Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.EndPortInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndPortInstance()
	 * @generated
	 */
	int END_PORT_INSTANCE = 14;

	/**
	 * The number of structural features of the '<em>End Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_PORT_INSTANCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.StartControlPortInstanceImpl <em>Start Control Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.StartControlPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartControlPortInstance()
	 * @generated
	 */
	int START_CONTROL_PORT_INSTANCE = 15;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__EXECUTION_STATE = CONTROL_PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE = CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__INSTANCE_ID = CONTROL_PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__INSTANCENUMBER = CONTROL_PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__NAME = CONTROL_PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__PORT_TYPE = CONTROL_PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE = CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__DECOUPLED = CONTROL_PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES = CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE__TYPE_ID = CONTROL_PORT_INSTANCE__TYPE_ID;

	/**
	 * The number of structural features of the '<em>Start Control Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_INSTANCE_FEATURE_COUNT = CONTROL_PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.StartDataPortInstanceImpl <em>Start Data Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.StartDataPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartDataPortInstance()
	 * @generated
	 */
	int START_DATA_PORT_INSTANCE = 16;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__EXECUTION_STATE = DATA_PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__CPS_EXECUTION_STATE = DATA_PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__INSTANCE_ID = DATA_PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__INSTANCENUMBER = DATA_PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__NAME = DATA_PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__PORT_TYPE = DATA_PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__PROCESS_STEP_INSTANCE = DATA_PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = DATA_PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__DECOUPLED = DATA_PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__IN_TRANSITION_INSTANCES = DATA_PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__TYPE_ID = DATA_PORT_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Data Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE__DATA_INSTANCE = DATA_PORT_INSTANCE__DATA_INSTANCE;

	/**
	 * The number of structural features of the '<em>Start Data Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_INSTANCE_FEATURE_COUNT = DATA_PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.EndControlPortInstanceImpl <em>End Control Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.EndControlPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndControlPortInstance()
	 * @generated
	 */
	int END_CONTROL_PORT_INSTANCE = 17;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__EXECUTION_STATE = CONTROL_PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE = CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__INSTANCE_ID = CONTROL_PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__INSTANCENUMBER = CONTROL_PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__NAME = CONTROL_PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__PORT_TYPE = CONTROL_PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE = CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__DECOUPLED = CONTROL_PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES = CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE__TYPE_ID = CONTROL_PORT_INSTANCE__TYPE_ID;

	/**
	 * The number of structural features of the '<em>End Control Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_INSTANCE_FEATURE_COUNT = CONTROL_PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortInstanceImpl <em>End Data Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.EndDataPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndDataPortInstance()
	 * @generated
	 */
	int END_DATA_PORT_INSTANCE = 18;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__EXECUTION_STATE = DATA_PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__CPS_EXECUTION_STATE = DATA_PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__INSTANCE_ID = DATA_PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__INSTANCENUMBER = DATA_PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__NAME = DATA_PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__PORT_TYPE = DATA_PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__PROCESS_STEP_INSTANCE = DATA_PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = DATA_PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__DECOUPLED = DATA_PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__IN_TRANSITION_INSTANCES = DATA_PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__TYPE_ID = DATA_PORT_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Data Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE__DATA_INSTANCE = DATA_PORT_INSTANCE__DATA_INSTANCE;

	/**
	 * The number of structural features of the '<em>End Data Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_INSTANCE_FEATURE_COUNT = DATA_PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 20;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__INSTANCE_ID = INSTANCE_IDENTIFIABLE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__INSTANCENUMBER = INSTANCE_IDENTIFIABLE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DELAY = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__PERMISSION = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Decouple Next Steps</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DECOUPLE_NEXT_STEPS = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = INSTANCE_IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.MappingUtilImpl <em>Mapping Util</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.MappingUtilImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getMappingUtil()
	 * @generated
	 */
	int MAPPING_UTIL = 21;

	/**
	 * The number of structural features of the '<em>Mapping Util</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_UTIL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.IfInstance <em>If Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.IfInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getIfInstance()
	 * @generated
	 */
	int IF_INSTANCE = 22;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>If Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE__IF_CONDITION_INSTANCE = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>If Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl <em>Condition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getConditionInstance()
	 * @generated
	 */
	int CONDITION_INSTANCE = 23;

	/**
	 * The feature id for the '<em><b>Expression Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE__EXPRESSION_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE__RESULT = 1;

	/**
	 * The feature id for the '<em><b>If Condition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE__IF_CONDITION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Left Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE__LEFT_SIDE = 3;

	/**
	 * The feature id for the '<em><b>Right Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE__RIGHT_SIDE = 4;

	/**
	 * The number of structural features of the '<em>Condition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_INSTANCE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.TrueTransitionInstanceImpl <em>True Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.TrueTransitionInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTrueTransitionInstance()
	 * @generated
	 */
	int TRUE_TRANSITION_INSTANCE = 24;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE__INSTANCE_ID = TRANSITION_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE__INSTANCENUMBER = TRANSITION_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Transition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE__TRANSITION_TYPE = TRANSITION_INSTANCE__TRANSITION_TYPE;

	/**
	 * The feature id for the '<em><b>Source Port Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE = TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Target Port Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE__TARGET_PORT_INSTANCE = TRANSITION_INSTANCE__TARGET_PORT_INSTANCE;

	/**
	 * The number of structural features of the '<em>True Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_INSTANCE_FEATURE_COUNT = TRANSITION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.FalseTransitionInstanceImpl <em>False Transition Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.FalseTransitionInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getFalseTransitionInstance()
	 * @generated
	 */
	int FALSE_TRANSITION_INSTANCE = 25;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE__INSTANCE_ID = TRANSITION_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE__INSTANCENUMBER = TRANSITION_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Transition Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE__TRANSITION_TYPE = TRANSITION_INSTANCE__TRANSITION_TYPE;

	/**
	 * The feature id for the '<em><b>Source Port Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE = TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE;

	/**
	 * The feature id for the '<em><b>Target Port Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE__TARGET_PORT_INSTANCE = TRANSITION_INSTANCE__TARGET_PORT_INSTANCE;

	/**
	 * The number of structural features of the '<em>False Transition Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_INSTANCE_FEATURE_COUNT = TRANSITION_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ComplexTypeInstanceImpl <em>Complex Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ComplexTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getComplexTypeInstance()
	 * @generated
	 */
	int COMPLEX_TYPE_INSTANCE = 26;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__INSTANCE_ID = DATA_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__INSTANCENUMBER = DATA_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__NAME = DATA_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__DATA_TYPE_TYPE = DATA_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__BELONGS_TO = DATA_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__ID_OF_ORIGIN = DATA_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__TYPE_ID = DATA_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE__SUBTYPES = DATA_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Complex Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_INSTANCE_FEATURE_COUNT = DATA_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.CollectionTypeInstanceImpl <em>Collection Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.CollectionTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getCollectionTypeInstance()
	 * @generated
	 */
	int COLLECTION_TYPE_INSTANCE = 28;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__INSTANCE_ID = COMPLEX_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__INSTANCENUMBER = COMPLEX_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__NAME = COMPLEX_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__DATA_TYPE_TYPE = COMPLEX_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__BELONGS_TO = COMPLEX_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__ID_OF_ORIGIN = COMPLEX_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__TYPE_ID = COMPLEX_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__SUBTYPES = COMPLEX_TYPE_INSTANCE__SUBTYPES;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE = COMPLEX_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_INSTANCE_FEATURE_COUNT = COMPLEX_TYPE_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.ListTypeInstanceImpl <em>List Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.ListTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getListTypeInstance()
	 * @generated
	 */
	int LIST_TYPE_INSTANCE = 27;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__INSTANCE_ID = COLLECTION_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__INSTANCENUMBER = COLLECTION_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__NAME = COLLECTION_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__DATA_TYPE_TYPE = COLLECTION_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__BELONGS_TO = COLLECTION_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__ID_OF_ORIGIN = COLLECTION_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__TYPE_ID = COLLECTION_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__SUBTYPES = COLLECTION_TYPE_INSTANCE__SUBTYPES;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE__COLLECTION_ITEM_TYPE = COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE;

	/**
	 * The number of structural features of the '<em>List Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_INSTANCE_FEATURE_COUNT = COLLECTION_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.SetTypeInstanceImpl <em>Set Type Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.SetTypeInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSetTypeInstance()
	 * @generated
	 */
	int SET_TYPE_INSTANCE = 29;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__INSTANCE_ID = COLLECTION_TYPE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__INSTANCENUMBER = COLLECTION_TYPE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__NAME = COLLECTION_TYPE_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Data Type Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__DATA_TYPE_TYPE = COLLECTION_TYPE_INSTANCE__DATA_TYPE_TYPE;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__BELONGS_TO = COLLECTION_TYPE_INSTANCE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Id Of Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__ID_OF_ORIGIN = COLLECTION_TYPE_INSTANCE__ID_OF_ORIGIN;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__TYPE_ID = COLLECTION_TYPE_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__SUBTYPES = COLLECTION_TYPE_INSTANCE__SUBTYPES;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE__COLLECTION_ITEM_TYPE = COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_INSTANCE_FEATURE_COUNT = COLLECTION_TYPE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.NameableImpl <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.NameableImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Nameable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMEABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.EscalationPortInstanceImpl <em>Escalation Port Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.EscalationPortInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEscalationPortInstance()
	 * @generated
	 */
	int ESCALATION_PORT_INSTANCE = 31;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__EXECUTION_STATE = END_CONTROL_PORT_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__CPS_EXECUTION_STATE = END_CONTROL_PORT_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__INSTANCE_ID = END_CONTROL_PORT_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__INSTANCENUMBER = END_CONTROL_PORT_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__NAME = END_CONTROL_PORT_INSTANCE__NAME;

	/**
	 * The feature id for the '<em><b>Port Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__PORT_TYPE = END_CONTROL_PORT_INSTANCE__PORT_TYPE;

	/**
	 * The feature id for the '<em><b>Process Step Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__PROCESS_STEP_INSTANCE = END_CONTROL_PORT_INSTANCE__PROCESS_STEP_INSTANCE;

	/**
	 * The feature id for the '<em><b>Out Transition Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__OUT_TRANSITION_INSTANCES = END_CONTROL_PORT_INSTANCE__OUT_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Decoupled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__DECOUPLED = END_CONTROL_PORT_INSTANCE__DECOUPLED;

	/**
	 * The feature id for the '<em><b>In Transition Instances</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__IN_TRANSITION_INSTANCES = END_CONTROL_PORT_INSTANCE__IN_TRANSITION_INSTANCES;

	/**
	 * The feature id for the '<em><b>Type Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__TYPE_ID = END_CONTROL_PORT_INSTANCE__TYPE_ID;

	/**
	 * The feature id for the '<em><b>Escalation Reason</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE__ESCALATION_REASON = END_CONTROL_PORT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Escalation Port Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_INSTANCE_FEATURE_COUNT = END_CONTROL_PORT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.LoopInstance <em>Loop Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.LoopInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getLoopInstance()
	 * @generated
	 */
	int LOOP_INSTANCE = 32;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Loop Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__LOOP_CONDITION_INSTANCE = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance <em>For Loop Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.ForLoopInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getForLoopInstance()
	 * @generated
	 */
	int FOR_LOOP_INSTANCE = 33;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__EXECUTION_STATE = LOOP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__CPS_EXECUTION_STATE = LOOP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__INSTANCE_ID = LOOP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__INSTANCENUMBER = LOOP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PROCESS_STEP_TYPE = LOOP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PERMISSION = LOOP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__DELAY = LOOP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PORTS = LOOP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__SUB_STEPS = LOOP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PROCESS_INSTANCE_ID = LOOP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PROCESS_MODEL_ID = LOOP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__MODEL_ID = LOOP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__CYBER_PHYSICAL = LOOP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Loop Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__LOOP_CONDITION_INSTANCE = LOOP_INSTANCE__LOOP_CONDITION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT = LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT;

	/**
	 * The feature id for the '<em><b>Loop Step Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE__LOOP_STEP_WIDTH = LOOP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For Loop Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_INSTANCE_FEATURE_COUNT = LOOP_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.AndInstance <em>And Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.AndInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getAndInstance()
	 * @generated
	 */
	int AND_INSTANCE = 34;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>And Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OrInstance <em>Or Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OrInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOrInstance()
	 * @generated
	 */
	int OR_INSTANCE = 35;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Or Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.ROSInvokeInstance <em>ROS Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.ROSInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getROSInvokeInstance()
	 * @generated
	 */
	int ROS_INVOKE_INSTANCE = 36;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>ROS Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.ProcessSlotInstance <em>Process Slot Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.ProcessSlotInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessSlotInstance()
	 * @generated
	 */
	int PROCESS_SLOT_INSTANCE = 37;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Process Slot Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance <em>Data Duplication Step Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataDuplicationStepInstance()
	 * @generated
	 */
	int DATA_DUPLICATION_STEP_INSTANCE = 38;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Data Duplication Step Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.RESTInvokeInstance <em>REST Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.RESTInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getRESTInvokeInstance()
	 * @generated
	 */
	int REST_INVOKE_INSTANCE = 39;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>REST Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OSGiInvokeInstance <em>OS Gi Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OSGiInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOSGiInvokeInstance()
	 * @generated
	 */
	int OS_GI_INVOKE_INSTANCE = 40;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>OS Gi Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.SOAPInvokeInstance <em>SOAP Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.SOAPInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSOAPInvokeInstance()
	 * @generated
	 */
	int SOAP_INVOKE_INSTANCE = 41;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>SOAP Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.HumanTaskInstanceImpl <em>Human Task Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.HumanTaskInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getHumanTaskInstance()
	 * @generated
	 */
	int HUMAN_TASK_INSTANCE = 42;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Human Task Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.LoadClassStepInstance <em>Load Class Step Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.LoadClassStepInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getLoadClassStepInstance()
	 * @generated
	 */
	int LOAD_CLASS_STEP_INSTANCE = 43;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Load Class Step Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance <em>Se Mi Wa Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSeMiWaInvokeInstance()
	 * @generated
	 */
	int SE_MI_WA_INVOKE_INSTANCE = 44;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Se Mi Wa Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.TriggeredEventInstance <em>Triggered Event Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.TriggeredEventInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTriggeredEventInstance()
	 * @generated
	 */
	int TRIGGERED_EVENT_INSTANCE = 45;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Triggered Event Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance <em>XMLRPC Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getXMLRPCInvokeInstance()
	 * @generated
	 */
	int XMLRPC_INVOKE_INSTANCE = 46;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>XMLRPC Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance <em>Se Mi Wa Request Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSeMiWaRequestInstance()
	 * @generated
	 */
	int SE_MI_WA_REQUEST_INSTANCE = 47;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Se Mi Wa Request Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.DataMappingStepInstance <em>Data Mapping Step Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.DataMappingStepInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataMappingStepInstance()
	 * @generated
	 */
	int DATA_MAPPING_STEP_INSTANCE = 48;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Data Mapping Step Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.WhileLoopInstance <em>While Loop Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.WhileLoopInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getWhileLoopInstance()
	 * @generated
	 */
	int WHILE_LOOP_INSTANCE = 49;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__EXECUTION_STATE = LOOP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__CPS_EXECUTION_STATE = LOOP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__INSTANCE_ID = LOOP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__INSTANCENUMBER = LOOP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PROCESS_STEP_TYPE = LOOP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PERMISSION = LOOP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__DELAY = LOOP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PORTS = LOOP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__SUB_STEPS = LOOP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PROCESS_INSTANCE_ID = LOOP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PROCESS_MODEL_ID = LOOP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__MODEL_ID = LOOP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__CYBER_PHYSICAL = LOOP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Loop Condition Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__LOOP_CONDITION_INSTANCE = LOOP_INSTANCE__LOOP_CONDITION_INSTANCE;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT = LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT;

	/**
	 * The number of structural features of the '<em>While Loop Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_INSTANCE_FEATURE_COUNT = LOOP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl <em>End Data Port To Start Data Port Map Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndDataPortToStartDataPortMapInstance()
	 * @generated
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE = 50;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY = 1;

	/**
	 * The number of structural features of the '<em>End Data Port To Start Data Port Map Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance <em>Open Hab Semantic Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticInvokeInstance()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE = 51;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_INSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance <em>Open Hab Semantic Select Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticSelectInvokeInstance()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE = 52;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__CPS_EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__INSTANCENUMBER = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__PROCESS_STEP_TYPE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__PERMISSION = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__DELAY = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__PORTS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__SUB_STEPS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__PROCESS_MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Select Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance <em>Open Hab Semantic Ask Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticAskInvokeInstance()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE = 53;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__CPS_EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__INSTANCENUMBER = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__PROCESS_STEP_TYPE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__PERMISSION = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__DELAY = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__PORTS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__SUB_STEPS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__PROCESS_MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Ask Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance <em>Open Hab Semantic Command Invoke Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticCommandInvokeInstance()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE = 54;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__CPS_EXECUTION_STATE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__INSTANCENUMBER = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__PROCESS_STEP_TYPE = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__PERMISSION = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__DELAY = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__PORTS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__SUB_STEPS = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__PROCESS_INSTANCE_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__PROCESS_MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__MODEL_ID = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Command Invoke Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.MapeKInstance <em>Mape KInstance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.MapeKInstance
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getMapeKInstance()
	 * @generated
	 */
	int MAPE_KINSTANCE = 55;

	/**
	 * The feature id for the '<em><b>Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__EXECUTION_STATE = PROCESS_STEP_INSTANCE__EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Cps Execution State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__CPS_EXECUTION_STATE = PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE;

	/**
	 * The feature id for the '<em><b>Instance Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__INSTANCE_ID = PROCESS_STEP_INSTANCE__INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Instancenumber</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__INSTANCENUMBER = PROCESS_STEP_INSTANCE__INSTANCENUMBER;

	/**
	 * The feature id for the '<em><b>Process Step Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__PROCESS_STEP_TYPE = PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE;

	/**
	 * The feature id for the '<em><b>Permission</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__PERMISSION = PROCESS_STEP_INSTANCE__PERMISSION;

	/**
	 * The feature id for the '<em><b>Delay</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__DELAY = PROCESS_STEP_INSTANCE__DELAY;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__PORTS = PROCESS_STEP_INSTANCE__PORTS;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__SUB_STEPS = PROCESS_STEP_INSTANCE__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Process Instance ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__PROCESS_INSTANCE_ID = PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID;

	/**
	 * The feature id for the '<em><b>Process Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__PROCESS_MODEL_ID = PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID;

	/**
	 * The feature id for the '<em><b>Model ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__MODEL_ID = PROCESS_STEP_INSTANCE__MODEL_ID;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE__CYBER_PHYSICAL = PROCESS_STEP_INSTANCE__CYBER_PHYSICAL;

	/**
	 * The number of structural features of the '<em>Mape KInstance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_KINSTANCE_FEATURE_COUNT = PROCESS_STEP_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.State <em>State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.State
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getState()
	 * @generated
	 */
	int STATE = 56;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.ExecutionPermission <em>Execution Permission</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getExecutionPermission()
	 * @generated
	 */
	int EXECUTION_PERMISSION = 57;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofiainstance.CpsState <em>Cps State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofiainstance.CpsState
	 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getCpsState()
	 * @generated
	 */
	int CPS_STATE = 58;


	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ProcessInstance <em>Process Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessInstance
	 * @generated
	 */
	EClass getProcessInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance <em>Process Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Step Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance
	 * @generated
	 */
	EClass getProcessStepInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessStepType <em>Process Step Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process Step Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessStepType()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EReference getProcessStepInstance_ProcessStepType();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permission</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPermission()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_Permission();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getDelay()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_Delay();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getPorts()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EReference getProcessStepInstance_Ports();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getSubSteps <em>Sub Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Steps</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getSubSteps()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EReference getProcessStepInstance_SubSteps();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessInstanceID <em>Process Instance ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Instance ID</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessInstanceID()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_ProcessInstanceID();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessModelID <em>Process Model ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Process Model ID</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getProcessModelID()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_ProcessModelID();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#getModelID <em>Model ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model ID</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#getModelID()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_ModelID();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance#isCyberPhysical <em>Cyber Physical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cyber Physical</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance#isCyberPhysical()
	 * @see #getProcessStepInstance()
	 * @generated
	 */
	EAttribute getProcessStepInstance_CyberPhysical();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.Stateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stateful</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Stateful
	 * @generated
	 */
	EClass getStateful();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Stateful#getExecutionState <em>Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution State</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Stateful#getExecutionState()
	 * @see #getStateful()
	 * @generated
	 */
	EAttribute getStateful_ExecutionState();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Stateful#getCpsExecutionState <em>Cps Execution State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cps Execution State</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Stateful#getCpsExecutionState()
	 * @see #getStateful()
	 * @generated
	 */
	EAttribute getStateful_CpsExecutionState();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.PortInstance <em>Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance
	 * @generated
	 */
	EClass getPortInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.PortInstance#getPortType <em>Port Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getPortType()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_PortType();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance <em>Process Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Process Step Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getProcessStepInstance()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_ProcessStepInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofiainstance.PortInstance#getOutTransitionInstances <em>Out Transition Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out Transition Instances</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getOutTransitionInstances()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_OutTransitionInstances();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.PortInstance#isDecoupled <em>Decoupled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decoupled</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#isDecoupled()
	 * @see #getPortInstance()
	 * @generated
	 */
	EAttribute getPortInstance_Decoupled();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances <em>In Transition Instances</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Transition Instances</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getInTransitionInstances()
	 * @see #getPortInstance()
	 * @generated
	 */
	EReference getPortInstance_InTransitionInstances();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.PortInstance#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Id</em>'.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance#getTypeId()
	 * @see #getPortInstance()
	 * @generated
	 */
	EAttribute getPortInstance_TypeId();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable <em>Instance Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Identifiable</em>'.
	 * @see eu.vicci.process.model.sofiainstance.InstanceIdentifiable
	 * @generated
	 */
	EClass getInstanceIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstanceId <em>Instance Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance Id</em>'.
	 * @see eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstanceId()
	 * @see #getInstanceIdentifiable()
	 * @generated
	 */
	EAttribute getInstanceIdentifiable_InstanceId();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstancenumber <em>Instancenumber</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instancenumber</em>'.
	 * @see eu.vicci.process.model.sofiainstance.InstanceIdentifiable#getInstancenumber()
	 * @see #getInstanceIdentifiable()
	 * @generated
	 */
	EAttribute getInstanceIdentifiable_Instancenumber();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.EventInstance <em>Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EventInstance
	 * @generated
	 */
	EClass getEventInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.EventInstance#getTimeStamp <em>Time Stamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Stamp</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EventInstance#getTimeStamp()
	 * @see #getEventInstance()
	 * @generated
	 */
	EAttribute getEventInstance_TimeStamp();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance <em>String Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StringTypeInstance
	 * @generated
	 */
	EClass getStringTypeInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StringTypeInstance#getValue()
	 * @see #getStringTypeInstance()
	 * @generated
	 */
	EAttribute getStringTypeInstance_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance#getStringTypeType <em>String Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>String Type Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StringTypeInstance#getStringTypeType()
	 * @see #getStringTypeInstance()
	 * @generated
	 */
	EReference getStringTypeInstance_StringTypeType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance <em>Integer Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.IntegerTypeInstance
	 * @generated
	 */
	EClass getIntegerTypeInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getValue()
	 * @see #getIntegerTypeInstance()
	 * @generated
	 */
	EAttribute getIntegerTypeInstance_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getIntegerTypeType <em>Integer Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Integer Type Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.IntegerTypeInstance#getIntegerTypeType()
	 * @see #getIntegerTypeInstance()
	 * @generated
	 */
	EReference getIntegerTypeInstance_IntegerTypeType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance <em>Double Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DoubleTypeInstance
	 * @generated
	 */
	EClass getDoubleTypeInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getValue()
	 * @see #getDoubleTypeInstance()
	 * @generated
	 */
	EAttribute getDoubleTypeInstance_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getDoubleTypeType <em>Double Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Double Type Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DoubleTypeInstance#getDoubleTypeType()
	 * @see #getDoubleTypeInstance()
	 * @generated
	 */
	EReference getDoubleTypeInstance_DoubleTypeType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance <em>Boolean Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.BooleanTypeInstance
	 * @generated
	 */
	EClass getBooleanTypeInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.vicci.process.model.sofiainstance.BooleanTypeInstance#isValue()
	 * @see #getBooleanTypeInstance()
	 * @generated
	 */
	EAttribute getBooleanTypeInstance_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance#getBooleanTypeType <em>Boolean Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Boolean Type Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.BooleanTypeInstance#getBooleanTypeType()
	 * @see #getBooleanTypeInstance()
	 * @generated
	 */
	EReference getBooleanTypeInstance_BooleanTypeType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.TransitionInstance <em>Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance
	 * @generated
	 */
	EClass getTransitionInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTransitionType <em>Transition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Transition Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance#getTransitionType()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_TransitionType();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance <em>Source Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance#getSourcePortInstance()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_SourcePortInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance <em>Target Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance#getTargetPortInstance()
	 * @see #getTransitionInstance()
	 * @generated
	 */
	EReference getTransitionInstance_TargetPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.DataPortInstance <em>Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataPortInstance
	 * @generated
	 */
	EClass getDataPortInstance();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofiainstance.DataPortInstance#getDataInstance <em>Data Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Data Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataPortInstance#getDataInstance()
	 * @see #getDataPortInstance()
	 * @generated
	 */
	EReference getDataPortInstance_DataInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ControlPortInstance <em>Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ControlPortInstance
	 * @generated
	 */
	EClass getControlPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.StartPortInstance <em>Start Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StartPortInstance
	 * @generated
	 */
	EClass getStartPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.EndPortInstance <em>End Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EndPortInstance
	 * @generated
	 */
	EClass getEndPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.StartControlPortInstance <em>Start Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Control Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StartControlPortInstance
	 * @generated
	 */
	EClass getStartControlPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.StartDataPortInstance <em>Start Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Data Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.StartDataPortInstance
	 * @generated
	 */
	EClass getStartDataPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.EndControlPortInstance <em>End Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Control Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EndControlPortInstance
	 * @generated
	 */
	EClass getEndControlPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.EndDataPortInstance <em>End Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Data Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EndDataPortInstance
	 * @generated
	 */
	EClass getEndDataPortInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance <em>Data Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance
	 * @generated
	 */
	EClass getDataTypeInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getDataTypeType <em>Data Type Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Type Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance#getDataTypeType()
	 * @see #getDataTypeInstance()
	 * @generated
	 */
	EReference getDataTypeInstance_DataTypeType();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Belongs To</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance#getBelongsTo()
	 * @see #getDataTypeInstance()
	 * @generated
	 */
	EReference getDataTypeInstance_BelongsTo();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getIdOfOrigin <em>Id Of Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id Of Origin</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance#getIdOfOrigin()
	 * @see #getDataTypeInstance()
	 * @generated
	 */
	EAttribute getDataTypeInstance_IdOfOrigin();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance#getTypeId <em>Type Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Id</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance#getTypeId()
	 * @see #getDataTypeInstance()
	 * @generated
	 */
	EAttribute getDataTypeInstance_TypeId();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Configuration#getDelay <em>Delay</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delay</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Configuration#getDelay()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Delay();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Configuration#getPermission <em>Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Permission</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Configuration#getPermission()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Permission();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Configuration#isDecoupleNextSteps <em>Decouple Next Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decouple Next Steps</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Configuration#isDecoupleNextSteps()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_DecoupleNextSteps();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.MappingUtil <em>Mapping Util</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Util</em>'.
	 * @see eu.vicci.process.model.sofiainstance.MappingUtil
	 * @generated
	 */
	EClass getMappingUtil();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.IfInstance <em>If Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.IfInstance
	 * @generated
	 */
	EClass getIfInstance();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofiainstance.IfInstance#getIfConditionInstance <em>If Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If Condition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.IfInstance#getIfConditionInstance()
	 * @see #getIfInstance()
	 * @generated
	 */
	EReference getIfInstance_IfConditionInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ConditionInstance <em>Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance
	 * @generated
	 */
	EClass getConditionInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getExpressionInstance <em>Expression Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance#getExpressionInstance()
	 * @see #getConditionInstance()
	 * @generated
	 */
	EAttribute getConditionInstance_ExpressionInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#isResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance#isResult()
	 * @see #getConditionInstance()
	 * @generated
	 */
	EAttribute getConditionInstance_Result();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getIfConditionType <em>If Condition Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>If Condition Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance#getIfConditionType()
	 * @see #getConditionInstance()
	 * @generated
	 */
	EReference getConditionInstance_IfConditionType();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getLeftSide <em>Left Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Side</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance#getLeftSide()
	 * @see #getConditionInstance()
	 * @generated
	 */
	EReference getConditionInstance_LeftSide();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.ConditionInstance#getRightSide <em>Right Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Side</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance#getRightSide()
	 * @see #getConditionInstance()
	 * @generated
	 */
	EReference getConditionInstance_RightSide();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.TrueTransitionInstance <em>True Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Transition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TrueTransitionInstance
	 * @generated
	 */
	EClass getTrueTransitionInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.FalseTransitionInstance <em>False Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Transition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.FalseTransitionInstance
	 * @generated
	 */
	EClass getFalseTransitionInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ComplexTypeInstance <em>Complex Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ComplexTypeInstance
	 * @generated
	 */
	EClass getComplexTypeInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofiainstance.ComplexTypeInstance#getSubtypes <em>Subtypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subtypes</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ComplexTypeInstance#getSubtypes()
	 * @see #getComplexTypeInstance()
	 * @generated
	 */
	EReference getComplexTypeInstance_Subtypes();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ListTypeInstance <em>List Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ListTypeInstance
	 * @generated
	 */
	EClass getListTypeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.CollectionTypeInstance <em>Collection Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.CollectionTypeInstance
	 * @generated
	 */
	EClass getCollectionTypeInstance();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofiainstance.CollectionTypeInstance#getCollectionItemType <em>Collection Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Item Type</em>'.
	 * @see eu.vicci.process.model.sofiainstance.CollectionTypeInstance#getCollectionItemType()
	 * @see #getCollectionTypeInstance()
	 * @generated
	 */
	EReference getCollectionTypeInstance_CollectionItemType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.SetTypeInstance <em>Set Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.SetTypeInstance
	 * @generated
	 */
	EClass getSetTypeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.Nameable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.vicci.process.model.sofiainstance.Nameable#getName()
	 * @see #getNameable()
	 * @generated
	 */
	EAttribute getNameable_Name();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.EscalationPortInstance <em>Escalation Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Escalation Port Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EscalationPortInstance
	 * @generated
	 */
	EClass getEscalationPortInstance();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofiainstance.EscalationPortInstance#getEscalationReason <em>Escalation Reason</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escalation Reason</em>'.
	 * @see eu.vicci.process.model.sofiainstance.EscalationPortInstance#getEscalationReason()
	 * @see #getEscalationPortInstance()
	 * @generated
	 */
	EAttribute getEscalationPortInstance_EscalationReason();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.LoopInstance <em>Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.LoopInstance
	 * @generated
	 */
	EClass getLoopInstance();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofiainstance.LoopInstance#getLoopConditionInstance <em>Loop Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Condition Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.LoopInstance#getLoopConditionInstance()
	 * @see #getLoopInstance()
	 * @generated
	 */
	EReference getLoopInstance_LoopConditionInstance();

	/**
	 * Returns the meta object for the map '{@link eu.vicci.process.model.sofiainstance.LoopInstance#getPortsCopyToStartport <em>Ports Copy To Startport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Ports Copy To Startport</em>'.
	 * @see eu.vicci.process.model.sofiainstance.LoopInstance#getPortsCopyToStartport()
	 * @see #getLoopInstance()
	 * @generated
	 */
	EReference getLoopInstance_PortsCopyToStartport();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance <em>For Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Loop Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ForLoopInstance
	 * @generated
	 */
	EClass getForLoopInstance();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance#getLoopStepWidth <em>Loop Step Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Step Width</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ForLoopInstance#getLoopStepWidth()
	 * @see #getForLoopInstance()
	 * @generated
	 */
	EReference getForLoopInstance_LoopStepWidth();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.AndInstance <em>And Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.AndInstance
	 * @generated
	 */
	EClass getAndInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OrInstance <em>Or Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OrInstance
	 * @generated
	 */
	EClass getOrInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ROSInvokeInstance <em>ROS Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ROS Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ROSInvokeInstance
	 * @generated
	 */
	EClass getROSInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.ProcessSlotInstance <em>Process Slot Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Slot Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ProcessSlotInstance
	 * @generated
	 */
	EClass getProcessSlotInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance <em>Data Duplication Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Duplication Step Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance
	 * @generated
	 */
	EClass getDataDuplicationStepInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.RESTInvokeInstance <em>REST Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>REST Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.RESTInvokeInstance
	 * @generated
	 */
	EClass getRESTInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OSGiInvokeInstance <em>OS Gi Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OS Gi Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OSGiInvokeInstance
	 * @generated
	 */
	EClass getOSGiInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.SOAPInvokeInstance <em>SOAP Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOAP Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.SOAPInvokeInstance
	 * @generated
	 */
	EClass getSOAPInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.HumanTaskInstance <em>Human Task Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Task Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.HumanTaskInstance
	 * @generated
	 */
	EClass getHumanTaskInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.LoadClassStepInstance <em>Load Class Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Class Step Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.LoadClassStepInstance
	 * @generated
	 */
	EClass getLoadClassStepInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance <em>Se Mi Wa Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Se Mi Wa Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance
	 * @generated
	 */
	EClass getSeMiWaInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.TriggeredEventInstance <em>Triggered Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triggered Event Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.TriggeredEventInstance
	 * @generated
	 */
	EClass getTriggeredEventInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance <em>XMLRPC Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMLRPC Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance
	 * @generated
	 */
	EClass getXMLRPCInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance <em>Se Mi Wa Request Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Se Mi Wa Request Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance
	 * @generated
	 */
	EClass getSeMiWaRequestInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.DataMappingStepInstance <em>Data Mapping Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Mapping Step Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.DataMappingStepInstance
	 * @generated
	 */
	EClass getDataMappingStepInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.WhileLoopInstance <em>While Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Loop Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.WhileLoopInstance
	 * @generated
	 */
	EClass getWhileLoopInstance();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>End Data Port To Start Data Port Map Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Data Port To Start Data Port Map Instance</em>'.
	 * @see java.util.Map.Entry
	 * @model features="value key" 
	 *        valueType="eu.vicci.process.model.sofiainstance.StartDataPortInstance"
	 *        keyType="eu.vicci.process.model.sofiainstance.EndDataPortInstance"
	 * @generated
	 */
	EClass getEndDataPortToStartDataPortMapInstance();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEndDataPortToStartDataPortMapInstance()
	 * @generated
	 */
	EReference getEndDataPortToStartDataPortMapInstance_Value();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEndDataPortToStartDataPortMapInstance()
	 * @generated
	 */
	EReference getEndDataPortToStartDataPortMapInstance_Key();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance <em>Open Hab Semantic Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance
	 * @generated
	 */
	EClass getOpenHabSemanticInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance <em>Open Hab Semantic Select Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Select Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance
	 * @generated
	 */
	EClass getOpenHabSemanticSelectInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance <em>Open Hab Semantic Ask Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Ask Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance
	 * @generated
	 */
	EClass getOpenHabSemanticAskInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance <em>Open Hab Semantic Command Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Command Invoke Instance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance
	 * @generated
	 */
	EClass getOpenHabSemanticCommandInvokeInstance();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofiainstance.MapeKInstance <em>Mape KInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mape KInstance</em>'.
	 * @see eu.vicci.process.model.sofiainstance.MapeKInstance
	 * @generated
	 */
	EClass getMapeKInstance();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofiainstance.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>State</em>'.
	 * @see eu.vicci.process.model.sofiainstance.State
	 * @generated
	 */
	EEnum getState();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofiainstance.ExecutionPermission <em>Execution Permission</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Permission</em>'.
	 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
	 * @generated
	 */
	EEnum getExecutionPermission();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofiainstance.CpsState <em>Cps State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cps State</em>'.
	 * @see eu.vicci.process.model.sofiainstance.CpsState
	 * @generated
	 */
	EEnum getCpsState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SofiaInstanceFactory getSofiaInstanceFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ProcessInstanceImpl <em>Process Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ProcessInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessInstance()
		 * @generated
		 */
		EClass PROCESS_INSTANCE = eINSTANCE.getProcessInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl <em>Process Step Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessStepInstance()
		 * @generated
		 */
		EClass PROCESS_STEP_INSTANCE = eINSTANCE.getProcessStepInstance();

		/**
		 * The meta object literal for the '<em><b>Process Step Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE = eINSTANCE.getProcessStepInstance_ProcessStepType();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__PERMISSION = eINSTANCE.getProcessStepInstance_Permission();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__DELAY = eINSTANCE.getProcessStepInstance_Delay();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STEP_INSTANCE__PORTS = eINSTANCE.getProcessStepInstance_Ports();

		/**
		 * The meta object literal for the '<em><b>Sub Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STEP_INSTANCE__SUB_STEPS = eINSTANCE.getProcessStepInstance_SubSteps();

		/**
		 * The meta object literal for the '<em><b>Process Instance ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID = eINSTANCE.getProcessStepInstance_ProcessInstanceID();

		/**
		 * The meta object literal for the '<em><b>Process Model ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID = eINSTANCE.getProcessStepInstance_ProcessModelID();

		/**
		 * The meta object literal for the '<em><b>Model ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__MODEL_ID = eINSTANCE.getProcessStepInstance_ModelID();

		/**
		 * The meta object literal for the '<em><b>Cyber Physical</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP_INSTANCE__CYBER_PHYSICAL = eINSTANCE.getProcessStepInstance_CyberPhysical();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.Stateful <em>Stateful</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.Stateful
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStateful()
		 * @generated
		 */
		EClass STATEFUL = eINSTANCE.getStateful();

		/**
		 * The meta object literal for the '<em><b>Execution State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL__EXECUTION_STATE = eINSTANCE.getStateful_ExecutionState();

		/**
		 * The meta object literal for the '<em><b>Cps Execution State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATEFUL__CPS_EXECUTION_STATE = eINSTANCE.getStateful_CpsExecutionState();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl <em>Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getPortInstance()
		 * @generated
		 */
		EClass PORT_INSTANCE = eINSTANCE.getPortInstance();

		/**
		 * The meta object literal for the '<em><b>Port Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__PORT_TYPE = eINSTANCE.getPortInstance_PortType();

		/**
		 * The meta object literal for the '<em><b>Process Step Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__PROCESS_STEP_INSTANCE = eINSTANCE.getPortInstance_ProcessStepInstance();

		/**
		 * The meta object literal for the '<em><b>Out Transition Instances</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__OUT_TRANSITION_INSTANCES = eINSTANCE.getPortInstance_OutTransitionInstances();

		/**
		 * The meta object literal for the '<em><b>Decoupled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_INSTANCE__DECOUPLED = eINSTANCE.getPortInstance_Decoupled();

		/**
		 * The meta object literal for the '<em><b>In Transition Instances</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_INSTANCE__IN_TRANSITION_INSTANCES = eINSTANCE.getPortInstance_InTransitionInstances();

		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_INSTANCE__TYPE_ID = eINSTANCE.getPortInstance_TypeId();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.InstanceIdentifiableImpl <em>Instance Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.InstanceIdentifiableImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getInstanceIdentifiable()
		 * @generated
		 */
		EClass INSTANCE_IDENTIFIABLE = eINSTANCE.getInstanceIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Instance Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_IDENTIFIABLE__INSTANCE_ID = eINSTANCE.getInstanceIdentifiable_InstanceId();

		/**
		 * The meta object literal for the '<em><b>Instancenumber</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE_IDENTIFIABLE__INSTANCENUMBER = eINSTANCE.getInstanceIdentifiable_Instancenumber();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.EventInstance <em>Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.EventInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEventInstance()
		 * @generated
		 */
		EClass EVENT_INSTANCE = eINSTANCE.getEventInstance();

		/**
		 * The meta object literal for the '<em><b>Time Stamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EVENT_INSTANCE__TIME_STAMP = eINSTANCE.getEventInstance_TimeStamp();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl <em>String Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStringTypeInstance()
		 * @generated
		 */
		EClass STRING_TYPE_INSTANCE = eINSTANCE.getStringTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_TYPE_INSTANCE__VALUE = eINSTANCE.getStringTypeInstance_Value();

		/**
		 * The meta object literal for the '<em><b>String Type Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRING_TYPE_INSTANCE__STRING_TYPE_TYPE = eINSTANCE.getStringTypeInstance_StringTypeType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl <em>Integer Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getIntegerTypeInstance()
		 * @generated
		 */
		EClass INTEGER_TYPE_INSTANCE = eINSTANCE.getIntegerTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE_INSTANCE__VALUE = eINSTANCE.getIntegerTypeInstance_Value();

		/**
		 * The meta object literal for the '<em><b>Integer Type Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE = eINSTANCE.getIntegerTypeInstance_IntegerTypeType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl <em>Double Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDoubleTypeInstance()
		 * @generated
		 */
		EClass DOUBLE_TYPE_INSTANCE = eINSTANCE.getDoubleTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_TYPE_INSTANCE__VALUE = eINSTANCE.getDoubleTypeInstance_Value();

		/**
		 * The meta object literal for the '<em><b>Double Type Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE = eINSTANCE.getDoubleTypeInstance_DoubleTypeType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl <em>Boolean Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getBooleanTypeInstance()
		 * @generated
		 */
		EClass BOOLEAN_TYPE_INSTANCE = eINSTANCE.getBooleanTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_TYPE_INSTANCE__VALUE = eINSTANCE.getBooleanTypeInstance_Value();

		/**
		 * The meta object literal for the '<em><b>Boolean Type Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE = eINSTANCE.getBooleanTypeInstance_BooleanTypeType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl <em>Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTransitionInstance()
		 * @generated
		 */
		EClass TRANSITION_INSTANCE = eINSTANCE.getTransitionInstance();

		/**
		 * The meta object literal for the '<em><b>Transition Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__TRANSITION_TYPE = eINSTANCE.getTransitionInstance_TransitionType();

		/**
		 * The meta object literal for the '<em><b>Source Port Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE = eINSTANCE.getTransitionInstance_SourcePortInstance();

		/**
		 * The meta object literal for the '<em><b>Target Port Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION_INSTANCE__TARGET_PORT_INSTANCE = eINSTANCE.getTransitionInstance_TargetPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.DataPortInstanceImpl <em>Data Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.DataPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataPortInstance()
		 * @generated
		 */
		EClass DATA_PORT_INSTANCE = eINSTANCE.getDataPortInstance();

		/**
		 * The meta object literal for the '<em><b>Data Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PORT_INSTANCE__DATA_INSTANCE = eINSTANCE.getDataPortInstance_DataInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ControlPortInstanceImpl <em>Control Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ControlPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getControlPortInstance()
		 * @generated
		 */
		EClass CONTROL_PORT_INSTANCE = eINSTANCE.getControlPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.StartPortInstance <em>Start Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.StartPortInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartPortInstance()
		 * @generated
		 */
		EClass START_PORT_INSTANCE = eINSTANCE.getStartPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.EndPortInstance <em>End Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.EndPortInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndPortInstance()
		 * @generated
		 */
		EClass END_PORT_INSTANCE = eINSTANCE.getEndPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.StartControlPortInstanceImpl <em>Start Control Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.StartControlPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartControlPortInstance()
		 * @generated
		 */
		EClass START_CONTROL_PORT_INSTANCE = eINSTANCE.getStartControlPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.StartDataPortInstanceImpl <em>Start Data Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.StartDataPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getStartDataPortInstance()
		 * @generated
		 */
		EClass START_DATA_PORT_INSTANCE = eINSTANCE.getStartDataPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.EndControlPortInstanceImpl <em>End Control Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.EndControlPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndControlPortInstance()
		 * @generated
		 */
		EClass END_CONTROL_PORT_INSTANCE = eINSTANCE.getEndControlPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortInstanceImpl <em>End Data Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.EndDataPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndDataPortInstance()
		 * @generated
		 */
		EClass END_DATA_PORT_INSTANCE = eINSTANCE.getEndDataPortInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl <em>Data Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataTypeInstance()
		 * @generated
		 */
		EClass DATA_TYPE_INSTANCE = eINSTANCE.getDataTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Data Type Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_INSTANCE__DATA_TYPE_TYPE = eINSTANCE.getDataTypeInstance_DataTypeType();

		/**
		 * The meta object literal for the '<em><b>Belongs To</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_INSTANCE__BELONGS_TO = eINSTANCE.getDataTypeInstance_BelongsTo();

		/**
		 * The meta object literal for the '<em><b>Id Of Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_INSTANCE__ID_OF_ORIGIN = eINSTANCE.getDataTypeInstance_IdOfOrigin();

		/**
		 * The meta object literal for the '<em><b>Type Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_TYPE_INSTANCE__TYPE_ID = eINSTANCE.getDataTypeInstance_TypeId();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Delay</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DELAY = eINSTANCE.getConfiguration_Delay();

		/**
		 * The meta object literal for the '<em><b>Permission</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__PERMISSION = eINSTANCE.getConfiguration_Permission();

		/**
		 * The meta object literal for the '<em><b>Decouple Next Steps</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__DECOUPLE_NEXT_STEPS = eINSTANCE.getConfiguration_DecoupleNextSteps();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.MappingUtilImpl <em>Mapping Util</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.MappingUtilImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getMappingUtil()
		 * @generated
		 */
		EClass MAPPING_UTIL = eINSTANCE.getMappingUtil();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.IfInstance <em>If Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.IfInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getIfInstance()
		 * @generated
		 */
		EClass IF_INSTANCE = eINSTANCE.getIfInstance();

		/**
		 * The meta object literal for the '<em><b>If Condition Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_INSTANCE__IF_CONDITION_INSTANCE = eINSTANCE.getIfInstance_IfConditionInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl <em>Condition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getConditionInstance()
		 * @generated
		 */
		EClass CONDITION_INSTANCE = eINSTANCE.getConditionInstance();

		/**
		 * The meta object literal for the '<em><b>Expression Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_INSTANCE__EXPRESSION_INSTANCE = eINSTANCE.getConditionInstance_ExpressionInstance();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION_INSTANCE__RESULT = eINSTANCE.getConditionInstance_Result();

		/**
		 * The meta object literal for the '<em><b>If Condition Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_INSTANCE__IF_CONDITION_TYPE = eINSTANCE.getConditionInstance_IfConditionType();

		/**
		 * The meta object literal for the '<em><b>Left Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_INSTANCE__LEFT_SIDE = eINSTANCE.getConditionInstance_LeftSide();

		/**
		 * The meta object literal for the '<em><b>Right Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION_INSTANCE__RIGHT_SIDE = eINSTANCE.getConditionInstance_RightSide();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.TrueTransitionInstanceImpl <em>True Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.TrueTransitionInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTrueTransitionInstance()
		 * @generated
		 */
		EClass TRUE_TRANSITION_INSTANCE = eINSTANCE.getTrueTransitionInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.FalseTransitionInstanceImpl <em>False Transition Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.FalseTransitionInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getFalseTransitionInstance()
		 * @generated
		 */
		EClass FALSE_TRANSITION_INSTANCE = eINSTANCE.getFalseTransitionInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ComplexTypeInstanceImpl <em>Complex Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ComplexTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getComplexTypeInstance()
		 * @generated
		 */
		EClass COMPLEX_TYPE_INSTANCE = eINSTANCE.getComplexTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Subtypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_TYPE_INSTANCE__SUBTYPES = eINSTANCE.getComplexTypeInstance_Subtypes();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.ListTypeInstanceImpl <em>List Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.ListTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getListTypeInstance()
		 * @generated
		 */
		EClass LIST_TYPE_INSTANCE = eINSTANCE.getListTypeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.CollectionTypeInstanceImpl <em>Collection Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.CollectionTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getCollectionTypeInstance()
		 * @generated
		 */
		EClass COLLECTION_TYPE_INSTANCE = eINSTANCE.getCollectionTypeInstance();

		/**
		 * The meta object literal for the '<em><b>Collection Item Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE = eINSTANCE.getCollectionTypeInstance_CollectionItemType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.SetTypeInstanceImpl <em>Set Type Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.SetTypeInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSetTypeInstance()
		 * @generated
		 */
		EClass SET_TYPE_INSTANCE = eINSTANCE.getSetTypeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.NameableImpl <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.NameableImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getNameable()
		 * @generated
		 */
		EClass NAMEABLE = eINSTANCE.getNameable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMEABLE__NAME = eINSTANCE.getNameable_Name();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.EscalationPortInstanceImpl <em>Escalation Port Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.EscalationPortInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEscalationPortInstance()
		 * @generated
		 */
		EClass ESCALATION_PORT_INSTANCE = eINSTANCE.getEscalationPortInstance();

		/**
		 * The meta object literal for the '<em><b>Escalation Reason</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESCALATION_PORT_INSTANCE__ESCALATION_REASON = eINSTANCE.getEscalationPortInstance_EscalationReason();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.LoopInstance <em>Loop Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.LoopInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getLoopInstance()
		 * @generated
		 */
		EClass LOOP_INSTANCE = eINSTANCE.getLoopInstance();

		/**
		 * The meta object literal for the '<em><b>Loop Condition Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_INSTANCE__LOOP_CONDITION_INSTANCE = eINSTANCE.getLoopInstance_LoopConditionInstance();

		/**
		 * The meta object literal for the '<em><b>Ports Copy To Startport</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT = eINSTANCE.getLoopInstance_PortsCopyToStartport();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance <em>For Loop Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.ForLoopInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getForLoopInstance()
		 * @generated
		 */
		EClass FOR_LOOP_INSTANCE = eINSTANCE.getForLoopInstance();

		/**
		 * The meta object literal for the '<em><b>Loop Step Width</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_LOOP_INSTANCE__LOOP_STEP_WIDTH = eINSTANCE.getForLoopInstance_LoopStepWidth();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.AndInstance <em>And Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.AndInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getAndInstance()
		 * @generated
		 */
		EClass AND_INSTANCE = eINSTANCE.getAndInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OrInstance <em>Or Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OrInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOrInstance()
		 * @generated
		 */
		EClass OR_INSTANCE = eINSTANCE.getOrInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.ROSInvokeInstance <em>ROS Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.ROSInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getROSInvokeInstance()
		 * @generated
		 */
		EClass ROS_INVOKE_INSTANCE = eINSTANCE.getROSInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.ProcessSlotInstance <em>Process Slot Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.ProcessSlotInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getProcessSlotInstance()
		 * @generated
		 */
		EClass PROCESS_SLOT_INSTANCE = eINSTANCE.getProcessSlotInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance <em>Data Duplication Step Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataDuplicationStepInstance()
		 * @generated
		 */
		EClass DATA_DUPLICATION_STEP_INSTANCE = eINSTANCE.getDataDuplicationStepInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.RESTInvokeInstance <em>REST Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.RESTInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getRESTInvokeInstance()
		 * @generated
		 */
		EClass REST_INVOKE_INSTANCE = eINSTANCE.getRESTInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OSGiInvokeInstance <em>OS Gi Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OSGiInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOSGiInvokeInstance()
		 * @generated
		 */
		EClass OS_GI_INVOKE_INSTANCE = eINSTANCE.getOSGiInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.SOAPInvokeInstance <em>SOAP Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.SOAPInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSOAPInvokeInstance()
		 * @generated
		 */
		EClass SOAP_INVOKE_INSTANCE = eINSTANCE.getSOAPInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.HumanTaskInstanceImpl <em>Human Task Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.HumanTaskInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getHumanTaskInstance()
		 * @generated
		 */
		EClass HUMAN_TASK_INSTANCE = eINSTANCE.getHumanTaskInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.LoadClassStepInstance <em>Load Class Step Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.LoadClassStepInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getLoadClassStepInstance()
		 * @generated
		 */
		EClass LOAD_CLASS_STEP_INSTANCE = eINSTANCE.getLoadClassStepInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance <em>Se Mi Wa Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSeMiWaInvokeInstance()
		 * @generated
		 */
		EClass SE_MI_WA_INVOKE_INSTANCE = eINSTANCE.getSeMiWaInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.TriggeredEventInstance <em>Triggered Event Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.TriggeredEventInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getTriggeredEventInstance()
		 * @generated
		 */
		EClass TRIGGERED_EVENT_INSTANCE = eINSTANCE.getTriggeredEventInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance <em>XMLRPC Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getXMLRPCInvokeInstance()
		 * @generated
		 */
		EClass XMLRPC_INVOKE_INSTANCE = eINSTANCE.getXMLRPCInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance <em>Se Mi Wa Request Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getSeMiWaRequestInstance()
		 * @generated
		 */
		EClass SE_MI_WA_REQUEST_INSTANCE = eINSTANCE.getSeMiWaRequestInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.DataMappingStepInstance <em>Data Mapping Step Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.DataMappingStepInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getDataMappingStepInstance()
		 * @generated
		 */
		EClass DATA_MAPPING_STEP_INSTANCE = eINSTANCE.getDataMappingStepInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.WhileLoopInstance <em>While Loop Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.WhileLoopInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getWhileLoopInstance()
		 * @generated
		 */
		EClass WHILE_LOOP_INSTANCE = eINSTANCE.getWhileLoopInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl <em>End Data Port To Start Data Port Map Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getEndDataPortToStartDataPortMapInstance()
		 * @generated
		 */
		EClass END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE = eINSTANCE.getEndDataPortToStartDataPortMapInstance();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE = eINSTANCE.getEndDataPortToStartDataPortMapInstance_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY = eINSTANCE.getEndDataPortToStartDataPortMapInstance_Key();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance <em>Open Hab Semantic Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticInvokeInstance()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_INVOKE_INSTANCE = eINSTANCE.getOpenHabSemanticInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance <em>Open Hab Semantic Select Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticSelectInvokeInstance()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE = eINSTANCE.getOpenHabSemanticSelectInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance <em>Open Hab Semantic Ask Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticAskInvokeInstance()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE = eINSTANCE.getOpenHabSemanticAskInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance <em>Open Hab Semantic Command Invoke Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getOpenHabSemanticCommandInvokeInstance()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE = eINSTANCE.getOpenHabSemanticCommandInvokeInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.MapeKInstance <em>Mape KInstance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.MapeKInstance
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getMapeKInstance()
		 * @generated
		 */
		EClass MAPE_KINSTANCE = eINSTANCE.getMapeKInstance();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.State <em>State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.State
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getState()
		 * @generated
		 */
		EEnum STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.ExecutionPermission <em>Execution Permission</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.ExecutionPermission
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getExecutionPermission()
		 * @generated
		 */
		EEnum EXECUTION_PERMISSION = eINSTANCE.getExecutionPermission();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofiainstance.CpsState <em>Cps State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofiainstance.CpsState
		 * @see eu.vicci.process.model.sofiainstance.impl.SofiaInstancePackageImpl#getCpsState()
		 * @generated
		 */
		EEnum CPS_STATE = eINSTANCE.getCpsState();

	}

} //SofiaInstancePackage
