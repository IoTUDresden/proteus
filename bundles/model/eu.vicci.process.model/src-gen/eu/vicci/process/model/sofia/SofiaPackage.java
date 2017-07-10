/**
 */
package eu.vicci.process.model.sofia;

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
 * @see eu.vicci.process.model.sofia.SofiaFactory
 * @model kind="package"
 * @generated
 */
public interface SofiaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sofia";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://vicci.eu/sofia/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sofia";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SofiaPackage eINSTANCE = eu.vicci.process.model.sofia.impl.SofiaPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.IdentifiableImpl <em>Identifiable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.IdentifiableImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIdentifiable()
	 * @generated
	 */
	int IDENTIFIABLE = 33;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE__ID = 0;

	/**
	 * The number of structural features of the '<em>Identifiable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIABLE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.TransitionImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE_PORT = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_PORT = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl <em>Process Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ProcessStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcessStep()
	 * @generated
	 */
	int PROCESS_STEP = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__CYBER_PHYSICAL = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__GOAL = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__EPL_QUERY = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__CONTROL_PROCESS_ID = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__CONTROL_PROCESS = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__CONTEXT = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__PARENTSTEP = IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__PORTS = IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__TYPE = IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP__RESOURCE = IDENTIFIABLE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Process Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_STEP_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.AtomicStepImpl <em>Atomic Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.AtomicStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getAtomicStep()
	 * @generated
	 */
	int ATOMIC_STEP = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__ID = PROCESS_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__NAME = PROCESS_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__CYBER_PHYSICAL = PROCESS_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__GOAL = PROCESS_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__EPL_QUERY = PROCESS_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__CONTROL_PROCESS_ID = PROCESS_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__CONTROL_PROCESS = PROCESS_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__CONTEXT = PROCESS_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__PARENTSTEP = PROCESS_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__PORTS = PROCESS_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__TYPE = PROCESS_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__DESCRIPTION = PROCESS_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP__RESOURCE = PROCESS_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Atomic Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_STEP_FEATURE_COUNT = PROCESS_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.IfImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIf()
	 * @generated
	 */
	int IF = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>If Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__IF_CONDITION = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OrImpl <em>Or</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OrImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOr()
	 * @generated
	 */
	int OR = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Or</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OR_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.InvokeImpl <em>Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.InvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getInvoke()
	 * @generated
	 */
	int INVOKE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INVOKE_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.EventImpl <em>Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.EventImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEvent()
	 * @generated
	 */
	int EVENT = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.CompositeStepImpl <em>Composite Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.CompositeStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCompositeStep()
	 * @generated
	 */
	int COMPOSITE_STEP = 13;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__ID = PROCESS_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__NAME = PROCESS_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__CYBER_PHYSICAL = PROCESS_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__GOAL = PROCESS_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__EPL_QUERY = PROCESS_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__CONTROL_PROCESS_ID = PROCESS_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__CONTROL_PROCESS = PROCESS_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__CONTEXT = PROCESS_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__PARENTSTEP = PROCESS_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__PORTS = PROCESS_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__TYPE = PROCESS_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__DESCRIPTION = PROCESS_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__RESOURCE = PROCESS_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP__SUB_STEPS = PROCESS_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_STEP_FEATURE_COUNT = PROCESS_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ProcessImpl <em>Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ProcessImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcess()
	 * @generated
	 */
	int PROCESS = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__ID = COMPOSITE_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__NAME = COMPOSITE_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CYBER_PHYSICAL = COMPOSITE_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__GOAL = COMPOSITE_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__EPL_QUERY = COMPOSITE_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTROL_PROCESS_ID = COMPOSITE_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTROL_PROCESS = COMPOSITE_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__CONTEXT = COMPOSITE_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PARENTSTEP = COMPOSITE_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__PORTS = COMPOSITE_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__TYPE = COMPOSITE_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DESCRIPTION = COMPOSITE_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__RESOURCE = COMPOSITE_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__SUB_STEPS = COMPOSITE_STEP__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Data Type Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DATA_TYPE_DEFINITIONS = COMPOSITE_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Execution Peer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__EXECUTION_PEER = COMPOSITE_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Distributed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__DISTRIBUTED = COMPOSITE_STEP_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Remote Executing</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS__REMOTE_EXECUTING = COMPOSITE_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_FEATURE_COUNT = COMPOSITE_STEP_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.PortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OUT_TRANSITIONS = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__OPTIONAL = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROCESS_STEP = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__IN_TRANSITIONS = IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__DESCRIPTION = IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DataPortImpl <em>Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DataPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataPort()
	 * @generated
	 */
	int DATA_PORT = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__ID = PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__OUT_TRANSITIONS = PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__OPTIONAL = PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__PROCESS_STEP = PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__IN_TRANSITIONS = PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__VALUE = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__PORT_DATATYPE = PORT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT__MAPPINGS = PORT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ControlPortImpl <em>Control Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ControlPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getControlPort()
	 * @generated
	 */
	int CONTROL_PORT = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__ID = PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__NAME = PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__OUT_TRANSITIONS = PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__OPTIONAL = PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__PROCESS_STEP = PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__IN_TRANSITIONS = PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT__DESCRIPTION = PORT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Control Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.NameableImpl <em>Nameable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.NameableImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getNameable()
	 * @generated
	 */
	int NAMEABLE = 34;

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
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DataTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NAME = NAMEABLE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__ID = NAMEABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BELONGS_TO = NAMEABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__MAPPINGS = NAMEABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__PORT_MEMBERS = NAMEABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = NAMEABLE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ComplexTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getComplexType()
	 * @generated
	 */
	int COMPLEX_TYPE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__ID = DATA_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__BELONGS_TO = DATA_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__MAPPINGS = DATA_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__PORT_MEMBERS = DATA_TYPE__PORT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Subtypes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__SUBTYPES = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subreferences</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE__SUBREFERENCES = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Complex Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLEX_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ConditionImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 11;

	/**
	 * The feature id for the '<em><b>Comparator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__COMPARATOR = 0;

	/**
	 * The feature id for the '<em><b>Left Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__LEFT_SIDE = 1;

	/**
	 * The feature id for the '<em><b>Right Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__RIGHT_SIDE = 2;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.SimpleTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSimpleType()
	 * @generated
	 */
	int SIMPLE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__ID = DATA_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__BELONGS_TO = DATA_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__MAPPINGS = DATA_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE__PORT_MEMBERS = DATA_TYPE__PORT_MEMBERS;

	/**
	 * The number of structural features of the '<em>Simple Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.StringTypeImpl <em>String Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.StringTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStringType()
	 * @generated
	 */
	int STRING_TYPE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__NAME = SIMPLE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__ID = SIMPLE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__BELONGS_TO = SIMPLE_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__MAPPINGS = SIMPLE_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE__PORT_MEMBERS = SIMPLE_TYPE__PORT_MEMBERS;

	/**
	 * The number of structural features of the '<em>String Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.NumericTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getNumericType()
	 * @generated
	 */
	int NUMERIC_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__NAME = SIMPLE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__ID = SIMPLE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__BELONGS_TO = SIMPLE_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__MAPPINGS = SIMPLE_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE__PORT_MEMBERS = SIMPLE_TYPE__PORT_MEMBERS;

	/**
	 * The number of structural features of the '<em>Numeric Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.BooleanTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getBooleanType()
	 * @generated
	 */
	int BOOLEAN_TYPE = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__NAME = SIMPLE_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__ID = SIMPLE_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__BELONGS_TO = SIMPLE_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__MAPPINGS = SIMPLE_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE__PORT_MEMBERS = SIMPLE_TYPE__PORT_MEMBERS;

	/**
	 * The number of structural features of the '<em>Boolean Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_TYPE_FEATURE_COUNT = SIMPLE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.IntegerTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIntegerType()
	 * @generated
	 */
	int INTEGER_TYPE = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__NAME = NUMERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__ID = NUMERIC_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__BELONGS_TO = NUMERIC_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MAPPINGS = NUMERIC_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__PORT_MEMBERS = NUMERIC_TYPE__PORT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MIN = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE__MAX = NUMERIC_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DoubleTypeImpl <em>Double Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DoubleTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDoubleType()
	 * @generated
	 */
	int DOUBLE_TYPE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__NAME = NUMERIC_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__ID = NUMERIC_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__BELONGS_TO = NUMERIC_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__MAPPINGS = NUMERIC_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE__PORT_MEMBERS = NUMERIC_TYPE__PORT_MEMBERS;

	/**
	 * The number of structural features of the '<em>Double Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_TYPE_FEATURE_COUNT = NUMERIC_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.LoopImpl <em>Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.LoopImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getLoop()
	 * @generated
	 */
	int LOOP = 21;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__ID = COMPOSITE_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__NAME = COMPOSITE_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__CYBER_PHYSICAL = COMPOSITE_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__GOAL = COMPOSITE_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__EPL_QUERY = COMPOSITE_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__CONTROL_PROCESS_ID = COMPOSITE_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__CONTROL_PROCESS = COMPOSITE_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__CONTEXT = COMPOSITE_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__PARENTSTEP = COMPOSITE_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__PORTS = COMPOSITE_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__TYPE = COMPOSITE_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__DESCRIPTION = COMPOSITE_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__RESOURCE = COMPOSITE_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__SUB_STEPS = COMPOSITE_STEP__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__LOOP_CONDITION = COMPOSITE_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startsport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP__PORTS_COPY_TO_STARTSPORT = COMPOSITE_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_FEATURE_COUNT = COMPOSITE_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.RepeatLoopImpl <em>Repeat Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.RepeatLoopImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getRepeatLoop()
	 * @generated
	 */
	int REPEAT_LOOP = 22;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__ID = LOOP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__NAME = LOOP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__CYBER_PHYSICAL = LOOP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__GOAL = LOOP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__EPL_QUERY = LOOP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__CONTROL_PROCESS_ID = LOOP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__CONTROL_PROCESS = LOOP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__CONTEXT = LOOP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__PARENTSTEP = LOOP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__PORTS = LOOP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__TYPE = LOOP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__DESCRIPTION = LOOP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__RESOURCE = LOOP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__SUB_STEPS = LOOP__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__LOOP_CONDITION = LOOP__LOOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startsport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP__PORTS_COPY_TO_STARTSPORT = LOOP__PORTS_COPY_TO_STARTSPORT;

	/**
	 * The number of structural features of the '<em>Repeat Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPEAT_LOOP_FEATURE_COUNT = LOOP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.WhileLoopImpl <em>While Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.WhileLoopImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getWhileLoop()
	 * @generated
	 */
	int WHILE_LOOP = 23;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__ID = LOOP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__NAME = LOOP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__CYBER_PHYSICAL = LOOP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__GOAL = LOOP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__EPL_QUERY = LOOP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__CONTROL_PROCESS_ID = LOOP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__CONTROL_PROCESS = LOOP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__CONTEXT = LOOP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__PARENTSTEP = LOOP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__PORTS = LOOP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__TYPE = LOOP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__DESCRIPTION = LOOP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__RESOURCE = LOOP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__SUB_STEPS = LOOP__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__LOOP_CONDITION = LOOP__LOOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startsport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__PORTS_COPY_TO_STARTSPORT = LOOP__PORTS_COPY_TO_STARTSPORT;

	/**
	 * The number of structural features of the '<em>While Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_FEATURE_COUNT = LOOP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ForLoopImpl <em>For Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ForLoopImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getForLoop()
	 * @generated
	 */
	int FOR_LOOP = 24;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__ID = LOOP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__NAME = LOOP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__CYBER_PHYSICAL = LOOP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__GOAL = LOOP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__EPL_QUERY = LOOP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__CONTROL_PROCESS_ID = LOOP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__CONTROL_PROCESS = LOOP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__CONTEXT = LOOP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__PARENTSTEP = LOOP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__PORTS = LOOP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__TYPE = LOOP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__DESCRIPTION = LOOP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__RESOURCE = LOOP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Sub Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__SUB_STEPS = LOOP__SUB_STEPS;

	/**
	 * The feature id for the '<em><b>Loop Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__LOOP_CONDITION = LOOP__LOOP_CONDITION;

	/**
	 * The feature id for the '<em><b>Ports Copy To Startsport</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__PORTS_COPY_TO_STARTSPORT = LOOP__PORTS_COPY_TO_STARTSPORT;

	/**
	 * The feature id for the '<em><b>Loop Step Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__LOOP_STEP_WIDTH = LOOP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_FEATURE_COUNT = LOOP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ProcessSlotImpl <em>Process Slot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ProcessSlotImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcessSlot()
	 * @generated
	 */
	int PROCESS_SLOT = 25;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Process Slot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_SLOT_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DataMappingStepImpl <em>Data Mapping Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DataMappingStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataMappingStep()
	 * @generated
	 */
	int DATA_MAPPING_STEP = 26;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP__MAPPINGS = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Data Mapping Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_STEP_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.StartControlPortImpl <em>Start Control Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.StartControlPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartControlPort()
	 * @generated
	 */
	int START_CONTROL_PORT = 27;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__ID = CONTROL_PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__NAME = CONTROL_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__OUT_TRANSITIONS = CONTROL_PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__OPTIONAL = CONTROL_PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__PROCESS_STEP = CONTROL_PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__IN_TRANSITIONS = CONTROL_PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT__DESCRIPTION = CONTROL_PORT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Start Control Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_CONTROL_PORT_FEATURE_COUNT = CONTROL_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.EndControlPortImpl <em>End Control Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.EndControlPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndControlPort()
	 * @generated
	 */
	int END_CONTROL_PORT = 28;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__ID = CONTROL_PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__NAME = CONTROL_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__OUT_TRANSITIONS = CONTROL_PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__OPTIONAL = CONTROL_PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__PROCESS_STEP = CONTROL_PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__IN_TRANSITIONS = CONTROL_PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT__DESCRIPTION = CONTROL_PORT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>End Control Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_CONTROL_PORT_FEATURE_COUNT = CONTROL_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.StartDataPortImpl <em>Start Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.StartDataPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartDataPort()
	 * @generated
	 */
	int START_DATA_PORT = 29;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__ID = DATA_PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__NAME = DATA_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__OUT_TRANSITIONS = DATA_PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__OPTIONAL = DATA_PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__PROCESS_STEP = DATA_PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__IN_TRANSITIONS = DATA_PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__DESCRIPTION = DATA_PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__VALUE = DATA_PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Port Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__PORT_DATATYPE = DATA_PORT__PORT_DATATYPE;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT__MAPPINGS = DATA_PORT__MAPPINGS;

	/**
	 * The number of structural features of the '<em>Start Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_DATA_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.EndDataPortImpl <em>End Data Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.EndDataPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndDataPort()
	 * @generated
	 */
	int END_DATA_PORT = 30;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__ID = DATA_PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__NAME = DATA_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__OUT_TRANSITIONS = DATA_PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__OPTIONAL = DATA_PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__PROCESS_STEP = DATA_PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__IN_TRANSITIONS = DATA_PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__DESCRIPTION = DATA_PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__VALUE = DATA_PORT__VALUE;

	/**
	 * The feature id for the '<em><b>Port Datatype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__PORT_DATATYPE = DATA_PORT__PORT_DATATYPE;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT__MAPPINGS = DATA_PORT__MAPPINGS;

	/**
	 * The number of structural features of the '<em>End Data Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_FEATURE_COUNT = DATA_PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.StartPort <em>Start Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.StartPort
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartPort()
	 * @generated
	 */
	int START_PORT = 31;

	/**
	 * The number of structural features of the '<em>Start Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int START_PORT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.EndPort <em>End Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.EndPort
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndPort()
	 * @generated
	 */
	int END_PORT = 32;

	/**
	 * The number of structural features of the '<em>End Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_PORT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.TriggeredEventImpl <em>Triggered Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.TriggeredEventImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTriggeredEvent()
	 * @generated
	 */
	int TRIGGERED_EVENT = 35;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__ID = EVENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__NAME = EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__CYBER_PHYSICAL = EVENT__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__GOAL = EVENT__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__EPL_QUERY = EVENT__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__CONTROL_PROCESS_ID = EVENT__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__CONTROL_PROCESS = EVENT__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__CONTEXT = EVENT__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__PARENTSTEP = EVENT__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__PORTS = EVENT__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__TYPE = EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__DESCRIPTION = EVENT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__RESOURCE = EVENT__RESOURCE;

	/**
	 * The feature id for the '<em><b>EPL Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT__EPL_STATEMENT = EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Triggered Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRIGGERED_EVENT_FEATURE_COUNT = EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.TrueTransitionImpl <em>True Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.TrueTransitionImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTrueTransition()
	 * @generated
	 */
	int TRUE_TRANSITION = 36;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION__ID = TRANSITION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION__NAME = TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION__SOURCE_PORT = TRANSITION__SOURCE_PORT;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION__TARGET_PORT = TRANSITION__TARGET_PORT;

	/**
	 * The number of structural features of the '<em>True Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.FalseTransitionImpl <em>False Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.FalseTransitionImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getFalseTransition()
	 * @generated
	 */
	int FALSE_TRANSITION = 37;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION__ID = TRANSITION__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION__NAME = TRANSITION__NAME;

	/**
	 * The feature id for the '<em><b>Source Port</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION__SOURCE_PORT = TRANSITION__SOURCE_PORT;

	/**
	 * The feature id for the '<em><b>Target Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION__TARGET_PORT = TRANSITION__TARGET_PORT;

	/**
	 * The number of structural features of the '<em>False Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FALSE_TRANSITION_FEATURE_COUNT = TRANSITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl <em>SOAP Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.SOAPInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSOAPInvoke()
	 * @generated
	 */
	int SOAP_INVOKE = 38;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__SERVER_URI = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__METHOD_NAME = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Wsdl Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__WSDL_URI = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Config File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE__CONFIG_FILE = INVOKE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>SOAP Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOAP_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl <em>XMLRPC Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getXMLRPCInvoke()
	 * @generated
	 */
	int XMLRPC_INVOKE = 39;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__SERVER_URI = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__METHOD_NAME = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Parameter Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__START_PARAMETER_SEQUENCE = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>End Parameter Sequence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE__END_PARAMETER_SEQUENCE = INVOKE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>XMLRPC Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int XMLRPC_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.LoadClassStepImpl <em>Load Class Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.LoadClassStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getLoadClassStep()
	 * @generated
	 */
	int LOAD_CLASS_STEP = 40;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Delegate Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP__DELEGATE_CLASS_NAME = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Load Class Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOAD_CLASS_STEP_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.SeMiWaInvokeImpl <em>Se Mi Wa Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.SeMiWaInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSeMiWaInvoke()
	 * @generated
	 */
	int SE_MI_WA_INVOKE = 41;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__SERVICE_NAME = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Node Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE__NODE_ID = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Se Mi Wa Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.RESTInvokeImpl <em>REST Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.RESTInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getRESTInvoke()
	 * @generated
	 */
	int REST_INVOKE = 42;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>HTTP Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__HTTP_METHOD = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE__SERVER_URI = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>REST Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REST_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl <em>OS Gi Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OSGiInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOSGiInvoke()
	 * @generated
	 */
	int OS_GI_INVOKE = 43;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Service Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__SERVICE_CLASS_NAME = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__METHOD_NAME = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__PARAMETER_TYPES = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Bundle Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE__BUNDLE_NAME = INVOKE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>OS Gi Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OS_GI_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.SeMiWaRequestImpl <em>Se Mi Wa Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.SeMiWaRequestImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSeMiWaRequest()
	 * @generated
	 */
	int SE_MI_WA_REQUEST = 44;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>SSIL Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST__SSIL_STATEMENT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Se Mi Wa Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SE_MI_WA_REQUEST_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DataMappingImpl <em>Data Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DataMappingImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataMapping()
	 * @generated
	 */
	int DATA_MAPPING = 45;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING__ID = IDENTIFIABLE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING__NAME = IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING__SOURCE = IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING__TARGET = IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Data Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_MAPPING_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.DataDuplicationStepImpl <em>Data Duplication Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.DataDuplicationStepImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataDuplicationStep()
	 * @generated
	 */
	int DATA_DUPLICATION_STEP = 46;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Data Duplication Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_DUPLICATION_STEP_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ROSInvokeImpl <em>ROS Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ROSInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getROSInvoke()
	 * @generated
	 */
	int ROS_INVOKE = 47;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__SERVER_URI = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE__SERVICE_NAME = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>ROS Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROS_INVOKE_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.AndImpl <em>And</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.AndImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getAnd()
	 * @generated
	 */
	int AND = 48;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>And</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AND_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.CollectionTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCollectionType()
	 * @generated
	 */
	int COLLECTION_TYPE = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__NAME = DATA_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__ID = DATA_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__BELONGS_TO = DATA_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__MAPPINGS = DATA_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__PORT_MEMBERS = DATA_TYPE__PORT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE__COLLECTION_ITEM_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.ListTypeImpl <em>List Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.ListTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getListType()
	 * @generated
	 */
	int LIST_TYPE = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__ID = COLLECTION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__BELONGS_TO = COLLECTION_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__MAPPINGS = COLLECTION_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__PORT_MEMBERS = COLLECTION_TYPE__PORT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE__COLLECTION_ITEM_TYPE = COLLECTION_TYPE__COLLECTION_ITEM_TYPE;

	/**
	 * The number of structural features of the '<em>List Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.SetTypeImpl <em>Set Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.SetTypeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSetType()
	 * @generated
	 */
	int SET_TYPE = 51;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__NAME = COLLECTION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__ID = COLLECTION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Belongs To</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__BELONGS_TO = COLLECTION_TYPE__BELONGS_TO;

	/**
	 * The feature id for the '<em><b>Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__MAPPINGS = COLLECTION_TYPE__MAPPINGS;

	/**
	 * The feature id for the '<em><b>Port Members</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__PORT_MEMBERS = COLLECTION_TYPE__PORT_MEMBERS;

	/**
	 * The feature id for the '<em><b>Collection Item Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE__COLLECTION_ITEM_TYPE = COLLECTION_TYPE__COLLECTION_ITEM_TYPE;

	/**
	 * The number of structural features of the '<em>Set Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_TYPE_FEATURE_COUNT = COLLECTION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.PublishMessageImpl <em>Publish Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.PublishMessageImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPublishMessage()
	 * @generated
	 */
	int PUBLISH_MESSAGE = 52;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__SERVER_URI = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE__TOPIC = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Publish Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_MESSAGE_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.PublishROSMessageImpl <em>Publish ROS Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.PublishROSMessageImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPublishROSMessage()
	 * @generated
	 */
	int PUBLISH_ROS_MESSAGE = 53;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__ID = PUBLISH_MESSAGE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__NAME = PUBLISH_MESSAGE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__CYBER_PHYSICAL = PUBLISH_MESSAGE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__GOAL = PUBLISH_MESSAGE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__EPL_QUERY = PUBLISH_MESSAGE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__CONTROL_PROCESS_ID = PUBLISH_MESSAGE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__CONTROL_PROCESS = PUBLISH_MESSAGE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__CONTEXT = PUBLISH_MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__PARENTSTEP = PUBLISH_MESSAGE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__PORTS = PUBLISH_MESSAGE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__TYPE = PUBLISH_MESSAGE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__DESCRIPTION = PUBLISH_MESSAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__RESOURCE = PUBLISH_MESSAGE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Server Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__SERVER_URI = PUBLISH_MESSAGE__SERVER_URI;

	/**
	 * The feature id for the '<em><b>Topic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE__TOPIC = PUBLISH_MESSAGE__TOPIC;

	/**
	 * The number of structural features of the '<em>Publish ROS Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUBLISH_ROS_MESSAGE_FEATURE_COUNT = PUBLISH_MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.HumanTaskImpl <em>Human Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.HumanTaskImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTask()
	 * @generated
	 */
	int HUMAN_TASK = 54;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The feature id for the '<em><b>Human Task Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__HUMAN_TASK_TYPE = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Human Task Use Case</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK__HUMAN_TASK_USE_CASE = ATOMIC_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Human Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_TASK_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.EscalationPortImpl <em>Escalation Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.EscalationPortImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEscalationPort()
	 * @generated
	 */
	int ESCALATION_PORT = 55;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__ID = END_CONTROL_PORT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__NAME = END_CONTROL_PORT__NAME;

	/**
	 * The feature id for the '<em><b>Out Transitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__OUT_TRANSITIONS = END_CONTROL_PORT__OUT_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__OPTIONAL = END_CONTROL_PORT__OPTIONAL;

	/**
	 * The feature id for the '<em><b>Process Step</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__PROCESS_STEP = END_CONTROL_PORT__PROCESS_STEP;

	/**
	 * The feature id for the '<em><b>In Transitions</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__IN_TRANSITIONS = END_CONTROL_PORT__IN_TRANSITIONS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__DESCRIPTION = END_CONTROL_PORT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Escalation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT__ESCALATION_TIME = END_CONTROL_PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Escalation Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESCALATION_PORT_FEATURE_COUNT = END_CONTROL_PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.EndDataPortToStartDataPortMapImpl <em>End Data Port To Start Data Port Map</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.EndDataPortToStartDataPortMapImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndDataPortToStartDataPortMap()
	 * @generated
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP = 56;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP__VALUE = 1;

	/**
	 * The number of structural features of the '<em>End Data Port To Start Data Port Map</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_DATA_PORT_TO_START_DATA_PORT_MAP_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl <em>Open Hab Semantic Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticInvoke()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_INVOKE = 57;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__QUERY = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Server Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>With Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticSelectInvokeImpl <em>Open Hab Semantic Select Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticSelectInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticSelectInvoke()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE = 58;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__ID = OPEN_HAB_SEMANTIC_INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__NAME = OPEN_HAB_SEMANTIC_INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__GOAL = OPEN_HAB_SEMANTIC_INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__EPL_QUERY = OPEN_HAB_SEMANTIC_INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__CONTROL_PROCESS_ID = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__CONTROL_PROCESS = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__CONTEXT = OPEN_HAB_SEMANTIC_INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__PARENTSTEP = OPEN_HAB_SEMANTIC_INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__PORTS = OPEN_HAB_SEMANTIC_INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__TYPE = OPEN_HAB_SEMANTIC_INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__DESCRIPTION = OPEN_HAB_SEMANTIC_INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__RESOURCE = OPEN_HAB_SEMANTIC_INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__QUERY = OPEN_HAB_SEMANTIC_INVOKE__QUERY;

	/**
	 * The feature id for the '<em><b>Server Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__SERVER_BASE_ADDRESS = OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS;

	/**
	 * The feature id for the '<em><b>With Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE__WITH_LATEST = OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Select Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_SELECT_INVOKE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticAskInvokeImpl <em>Open Hab Semantic Ask Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticAskInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticAskInvoke()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE = 59;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__ID = OPEN_HAB_SEMANTIC_INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__NAME = OPEN_HAB_SEMANTIC_INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__GOAL = OPEN_HAB_SEMANTIC_INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__EPL_QUERY = OPEN_HAB_SEMANTIC_INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__CONTROL_PROCESS_ID = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__CONTROL_PROCESS = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__CONTEXT = OPEN_HAB_SEMANTIC_INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__PARENTSTEP = OPEN_HAB_SEMANTIC_INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__PORTS = OPEN_HAB_SEMANTIC_INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__TYPE = OPEN_HAB_SEMANTIC_INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__DESCRIPTION = OPEN_HAB_SEMANTIC_INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__RESOURCE = OPEN_HAB_SEMANTIC_INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__QUERY = OPEN_HAB_SEMANTIC_INVOKE__QUERY;

	/**
	 * The feature id for the '<em><b>Server Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__SERVER_BASE_ADDRESS = OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS;

	/**
	 * The feature id for the '<em><b>With Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE__WITH_LATEST = OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Ask Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_ASK_INVOKE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticCommandInvokeImpl <em>Open Hab Semantic Command Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticCommandInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticCommandInvoke()
	 * @generated
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE = 60;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__ID = OPEN_HAB_SEMANTIC_INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__NAME = OPEN_HAB_SEMANTIC_INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__CYBER_PHYSICAL = OPEN_HAB_SEMANTIC_INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__GOAL = OPEN_HAB_SEMANTIC_INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__EPL_QUERY = OPEN_HAB_SEMANTIC_INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__CONTROL_PROCESS_ID = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__CONTROL_PROCESS = OPEN_HAB_SEMANTIC_INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__CONTEXT = OPEN_HAB_SEMANTIC_INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__PARENTSTEP = OPEN_HAB_SEMANTIC_INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__PORTS = OPEN_HAB_SEMANTIC_INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__TYPE = OPEN_HAB_SEMANTIC_INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__DESCRIPTION = OPEN_HAB_SEMANTIC_INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__RESOURCE = OPEN_HAB_SEMANTIC_INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__QUERY = OPEN_HAB_SEMANTIC_INVOKE__QUERY;

	/**
	 * The feature id for the '<em><b>Server Base Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__SERVER_BASE_ADDRESS = OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS;

	/**
	 * The feature id for the '<em><b>With Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__WITH_LATEST = OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST;

	/**
	 * The feature id for the '<em><b>Command</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE__COMMAND = OPEN_HAB_SEMANTIC_INVOKE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Hab Semantic Command Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_HAB_SEMANTIC_COMMAND_INVOKE_FEATURE_COUNT = OPEN_HAB_SEMANTIC_INVOKE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.CpsStep <em>Cps Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.CpsStep
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCpsStep()
	 * @generated
	 */
	int CPS_STEP = 61;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__CYBER_PHYSICAL = 0;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__GOAL = 1;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__EPL_QUERY = 2;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__CONTROL_PROCESS_ID = 3;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__CONTROL_PROCESS = 4;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP__CONTEXT = 5;

	/**
	 * The number of structural features of the '<em>Cps Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPS_STEP_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.MapeKImpl <em>Mape K</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.MapeKImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getMapeK()
	 * @generated
	 */
	int MAPE_K = 62;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__ID = ATOMIC_STEP__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__NAME = ATOMIC_STEP__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__CYBER_PHYSICAL = ATOMIC_STEP__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__GOAL = ATOMIC_STEP__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__EPL_QUERY = ATOMIC_STEP__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__CONTROL_PROCESS_ID = ATOMIC_STEP__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__CONTROL_PROCESS = ATOMIC_STEP__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__CONTEXT = ATOMIC_STEP__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__PARENTSTEP = ATOMIC_STEP__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__PORTS = ATOMIC_STEP__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__TYPE = ATOMIC_STEP__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__DESCRIPTION = ATOMIC_STEP__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K__RESOURCE = ATOMIC_STEP__RESOURCE;

	/**
	 * The number of structural features of the '<em>Mape K</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPE_K_FEATURE_COUNT = ATOMIC_STEP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.impl.GoalInvokeImpl <em>Goal Invoke</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.impl.GoalInvokeImpl
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getGoalInvoke()
	 * @generated
	 */
	int GOAL_INVOKE = 63;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__ID = INVOKE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__NAME = INVOKE__NAME;

	/**
	 * The feature id for the '<em><b>Cyber Physical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__CYBER_PHYSICAL = INVOKE__CYBER_PHYSICAL;

	/**
	 * The feature id for the '<em><b>Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__GOAL = INVOKE__GOAL;

	/**
	 * The feature id for the '<em><b>Epl Query</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__EPL_QUERY = INVOKE__EPL_QUERY;

	/**
	 * The feature id for the '<em><b>Control Process Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__CONTROL_PROCESS_ID = INVOKE__CONTROL_PROCESS_ID;

	/**
	 * The feature id for the '<em><b>Control Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__CONTROL_PROCESS = INVOKE__CONTROL_PROCESS;

	/**
	 * The feature id for the '<em><b>Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__CONTEXT = INVOKE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Parentstep</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__PARENTSTEP = INVOKE__PARENTSTEP;

	/**
	 * The feature id for the '<em><b>Ports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__PORTS = INVOKE__PORTS;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__TYPE = INVOKE__TYPE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__DESCRIPTION = INVOKE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__RESOURCE = INVOKE__RESOURCE;

	/**
	 * The feature id for the '<em><b>Invoke Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__INVOKE_GOAL = INVOKE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Qualities</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__QUALITIES = INVOKE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE__LOCATION = INVOKE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Goal Invoke</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_INVOKE_FEATURE_COUNT = INVOKE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.Comparator <em>Comparator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.Comparator
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getComparator()
	 * @generated
	 */
	int COMPARATOR = 64;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.HTTPverb <em>HTT Pverb</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.HTTPverb
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHTTPverb()
	 * @generated
	 */
	int HTT_PVERB = 65;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.SemanticTargetType <em>Semantic Target Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.SemanticTargetType
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSemanticTargetType()
	 * @generated
	 */
	int SEMANTIC_TARGET_TYPE = 66;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.HumanTaskType <em>Human Task Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.HumanTaskType
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTaskType()
	 * @generated
	 */
	int HUMAN_TASK_TYPE = 67;

	/**
	 * The meta object id for the '{@link eu.vicci.process.model.sofia.HumanTaskUseCase <em>Human Task Use Case</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.model.sofia.HumanTaskUseCase
	 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTaskUseCase()
	 * @generated
	 */
	int HUMAN_TASK_USE_CASE = 68;


	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see eu.vicci.process.model.sofia.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofia.Transition#getSourcePort <em>Source Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source Port</em>'.
	 * @see eu.vicci.process.model.sofia.Transition#getSourcePort()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_SourcePort();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.Transition#getTargetPort <em>Target Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Port</em>'.
	 * @see eu.vicci.process.model.sofia.Transition#getTargetPort()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_TargetPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see eu.vicci.process.model.sofia.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofia.If#getIfCondition <em>If Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>If Condition</em>'.
	 * @see eu.vicci.process.model.sofia.If#getIfCondition()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_IfCondition();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or</em>'.
	 * @see eu.vicci.process.model.sofia.Or
	 * @generated
	 */
	EClass getOr();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.Invoke
	 * @generated
	 */
	EClass getInvoke();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event</em>'.
	 * @see eu.vicci.process.model.sofia.Event
	 * @generated
	 */
	EClass getEvent();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process</em>'.
	 * @see eu.vicci.process.model.sofia.Process
	 * @generated
	 */
	EClass getProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.Process#getDataTypeDefinitions <em>Data Type Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Type Definitions</em>'.
	 * @see eu.vicci.process.model.sofia.Process#getDataTypeDefinitions()
	 * @see #getProcess()
	 * @generated
	 */
	EReference getProcess_DataTypeDefinitions();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Process#getExecutionPeer <em>Execution Peer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Peer</em>'.
	 * @see eu.vicci.process.model.sofia.Process#getExecutionPeer()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_ExecutionPeer();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Process#isDistributed <em>Distributed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distributed</em>'.
	 * @see eu.vicci.process.model.sofia.Process#isDistributed()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_Distributed();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Process#isRemoteExecuting <em>Remote Executing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remote Executing</em>'.
	 * @see eu.vicci.process.model.sofia.Process#isRemoteExecuting()
	 * @see #getProcess()
	 * @generated
	 */
	EAttribute getProcess_RemoteExecuting();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see eu.vicci.process.model.sofia.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.Port#getOutTransitions <em>Out Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Out Transitions</em>'.
	 * @see eu.vicci.process.model.sofia.Port#getOutTransitions()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_OutTransitions();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Port#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see eu.vicci.process.model.sofia.Port#isOptional()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Optional();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofia.Port#getProcessStep <em>Process Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Process Step</em>'.
	 * @see eu.vicci.process.model.sofia.Port#getProcessStep()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_ProcessStep();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.Port#getInTransitions <em>In Transitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Transitions</em>'.
	 * @see eu.vicci.process.model.sofia.Port#getInTransitions()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_InTransitions();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Port#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see eu.vicci.process.model.sofia.Port#getDescription()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_Description();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Port</em>'.
	 * @see eu.vicci.process.model.sofia.DataPort
	 * @generated
	 */
	EClass getDataPort();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.DataPort#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see eu.vicci.process.model.sofia.DataPort#getValue()
	 * @see #getDataPort()
	 * @generated
	 */
	EAttribute getDataPort_Value();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.DataPort#getPortDatatype <em>Port Datatype</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Port Datatype</em>'.
	 * @see eu.vicci.process.model.sofia.DataPort#getPortDatatype()
	 * @see #getDataPort()
	 * @generated
	 */
	EReference getDataPort_PortDatatype();

	/**
	 * Returns the meta object for the reference list '{@link eu.vicci.process.model.sofia.DataPort#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see eu.vicci.process.model.sofia.DataPort#getMappings()
	 * @see #getDataPort()
	 * @generated
	 */
	EReference getDataPort_Mappings();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ControlPort <em>Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Port</em>'.
	 * @see eu.vicci.process.model.sofia.ControlPort
	 * @generated
	 */
	EClass getControlPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ProcessStep <em>Process Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Step</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep
	 * @generated
	 */
	EClass getProcessStep();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofia.ProcessStep#getParentstep <em>Parentstep</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parentstep</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep#getParentstep()
	 * @see #getProcessStep()
	 * @generated
	 */
	EReference getProcessStep_Parentstep();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.ProcessStep#getPorts <em>Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Ports</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep#getPorts()
	 * @see #getProcessStep()
	 * @generated
	 */
	EReference getProcessStep_Ports();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.ProcessStep#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep#getType()
	 * @see #getProcessStep()
	 * @generated
	 */
	EAttribute getProcessStep_Type();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.ProcessStep#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep#getDescription()
	 * @see #getProcessStep()
	 * @generated
	 */
	EAttribute getProcessStep_Description();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.ProcessStep#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Resource</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessStep#getResource()
	 * @see #getProcessStep()
	 * @generated
	 */
	EAttribute getProcessStep_Resource();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complex Type</em>'.
	 * @see eu.vicci.process.model.sofia.ComplexType
	 * @generated
	 */
	EClass getComplexType();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.ComplexType#getSubtypes <em>Subtypes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subtypes</em>'.
	 * @see eu.vicci.process.model.sofia.ComplexType#getSubtypes()
	 * @see #getComplexType()
	 * @generated
	 */
	EReference getComplexType_Subtypes();

	/**
	 * Returns the meta object for the reference list '{@link eu.vicci.process.model.sofia.ComplexType#getSubreferences <em>Subreferences</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subreferences</em>'.
	 * @see eu.vicci.process.model.sofia.ComplexType#getSubreferences()
	 * @see #getComplexType()
	 * @generated
	 */
	EReference getComplexType_Subreferences();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see eu.vicci.process.model.sofia.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Condition#getComparator <em>Comparator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Comparator</em>'.
	 * @see eu.vicci.process.model.sofia.Condition#getComparator()
	 * @see #getCondition()
	 * @generated
	 */
	EAttribute getCondition_Comparator();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.Condition#getLeftSide <em>Left Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Left Side</em>'.
	 * @see eu.vicci.process.model.sofia.Condition#getLeftSide()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_LeftSide();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.Condition#getRightSide <em>Right Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Right Side</em>'.
	 * @see eu.vicci.process.model.sofia.Condition#getRightSide()
	 * @see #getCondition()
	 * @generated
	 */
	EReference getCondition_RightSide();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.AtomicStep <em>Atomic Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Step</em>'.
	 * @see eu.vicci.process.model.sofia.AtomicStep
	 * @generated
	 */
	EClass getAtomicStep();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.CompositeStep <em>Composite Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Step</em>'.
	 * @see eu.vicci.process.model.sofia.CompositeStep
	 * @generated
	 */
	EClass getCompositeStep();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.CompositeStep#getSubSteps <em>Sub Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sub Steps</em>'.
	 * @see eu.vicci.process.model.sofia.CompositeStep#getSubSteps()
	 * @see #getCompositeStep()
	 * @generated
	 */
	EReference getCompositeStep_SubSteps();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see eu.vicci.process.model.sofia.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofia.DataType#getBelongsTo <em>Belongs To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Belongs To</em>'.
	 * @see eu.vicci.process.model.sofia.DataType#getBelongsTo()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_BelongsTo();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.model.sofia.DataType#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mappings</em>'.
	 * @see eu.vicci.process.model.sofia.DataType#getMappings()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Mappings();

	/**
	 * Returns the meta object for the reference list '{@link eu.vicci.process.model.sofia.DataType#getPortMembers <em>Port Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Port Members</em>'.
	 * @see eu.vicci.process.model.sofia.DataType#getPortMembers()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_PortMembers();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.SimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Type</em>'.
	 * @see eu.vicci.process.model.sofia.SimpleType
	 * @generated
	 */
	EClass getSimpleType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Type</em>'.
	 * @see eu.vicci.process.model.sofia.StringType
	 * @generated
	 */
	EClass getStringType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Type</em>'.
	 * @see eu.vicci.process.model.sofia.NumericType
	 * @generated
	 */
	EClass getNumericType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Type</em>'.
	 * @see eu.vicci.process.model.sofia.BooleanType
	 * @generated
	 */
	EClass getBooleanType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Type</em>'.
	 * @see eu.vicci.process.model.sofia.IntegerType
	 * @generated
	 */
	EClass getIntegerType();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.IntegerType#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see eu.vicci.process.model.sofia.IntegerType#getMin()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Min();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.IntegerType#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see eu.vicci.process.model.sofia.IntegerType#getMax()
	 * @see #getIntegerType()
	 * @generated
	 */
	EAttribute getIntegerType_Max();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Type</em>'.
	 * @see eu.vicci.process.model.sofia.DoubleType
	 * @generated
	 */
	EClass getDoubleType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop</em>'.
	 * @see eu.vicci.process.model.sofia.Loop
	 * @generated
	 */
	EClass getLoop();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.model.sofia.Loop#getLoopCondition <em>Loop Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Loop Condition</em>'.
	 * @see eu.vicci.process.model.sofia.Loop#getLoopCondition()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_LoopCondition();

	/**
	 * Returns the meta object for the map '{@link eu.vicci.process.model.sofia.Loop#getPortsCopyToStartsport <em>Ports Copy To Startsport</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Ports Copy To Startsport</em>'.
	 * @see eu.vicci.process.model.sofia.Loop#getPortsCopyToStartsport()
	 * @see #getLoop()
	 * @generated
	 */
	EReference getLoop_PortsCopyToStartsport();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.RepeatLoop <em>Repeat Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repeat Loop</em>'.
	 * @see eu.vicci.process.model.sofia.RepeatLoop
	 * @generated
	 */
	EClass getRepeatLoop();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.WhileLoop <em>While Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Loop</em>'.
	 * @see eu.vicci.process.model.sofia.WhileLoop
	 * @generated
	 */
	EClass getWhileLoop();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ForLoop <em>For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Loop</em>'.
	 * @see eu.vicci.process.model.sofia.ForLoop
	 * @generated
	 */
	EClass getForLoop();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.ForLoop#getLoopStepWidth <em>Loop Step Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Step Width</em>'.
	 * @see eu.vicci.process.model.sofia.ForLoop#getLoopStepWidth()
	 * @see #getForLoop()
	 * @generated
	 */
	EReference getForLoop_LoopStepWidth();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ProcessSlot <em>Process Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Slot</em>'.
	 * @see eu.vicci.process.model.sofia.ProcessSlot
	 * @generated
	 */
	EClass getProcessSlot();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DataMappingStep <em>Data Mapping Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Mapping Step</em>'.
	 * @see eu.vicci.process.model.sofia.DataMappingStep
	 * @generated
	 */
	EClass getDataMappingStep();

	/**
	 * Returns the meta object for the reference list '{@link eu.vicci.process.model.sofia.DataMappingStep#getMappings <em>Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mappings</em>'.
	 * @see eu.vicci.process.model.sofia.DataMappingStep#getMappings()
	 * @see #getDataMappingStep()
	 * @generated
	 */
	EReference getDataMappingStep_Mappings();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.StartControlPort <em>Start Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Control Port</em>'.
	 * @see eu.vicci.process.model.sofia.StartControlPort
	 * @generated
	 */
	EClass getStartControlPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.EndControlPort <em>End Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Control Port</em>'.
	 * @see eu.vicci.process.model.sofia.EndControlPort
	 * @generated
	 */
	EClass getEndControlPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.StartDataPort <em>Start Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Data Port</em>'.
	 * @see eu.vicci.process.model.sofia.StartDataPort
	 * @generated
	 */
	EClass getStartDataPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.EndDataPort <em>End Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Data Port</em>'.
	 * @see eu.vicci.process.model.sofia.EndDataPort
	 * @generated
	 */
	EClass getEndDataPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.StartPort <em>Start Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Start Port</em>'.
	 * @see eu.vicci.process.model.sofia.StartPort
	 * @generated
	 */
	EClass getStartPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.EndPort <em>End Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Port</em>'.
	 * @see eu.vicci.process.model.sofia.EndPort
	 * @generated
	 */
	EClass getEndPort();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifiable</em>'.
	 * @see eu.vicci.process.model.sofia.Identifiable
	 * @generated
	 */
	EClass getIdentifiable();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Identifiable#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see eu.vicci.process.model.sofia.Identifiable#getId()
	 * @see #getIdentifiable()
	 * @generated
	 */
	EAttribute getIdentifiable_Id();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nameable</em>'.
	 * @see eu.vicci.process.model.sofia.Nameable
	 * @generated
	 */
	EClass getNameable();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.Nameable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see eu.vicci.process.model.sofia.Nameable#getName()
	 * @see #getNameable()
	 * @generated
	 */
	EAttribute getNameable_Name();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.TriggeredEvent <em>Triggered Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Triggered Event</em>'.
	 * @see eu.vicci.process.model.sofia.TriggeredEvent
	 * @generated
	 */
	EClass getTriggeredEvent();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.TriggeredEvent#getEPLStatement <em>EPL Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>EPL Statement</em>'.
	 * @see eu.vicci.process.model.sofia.TriggeredEvent#getEPLStatement()
	 * @see #getTriggeredEvent()
	 * @generated
	 */
	EAttribute getTriggeredEvent_EPLStatement();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.TrueTransition <em>True Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Transition</em>'.
	 * @see eu.vicci.process.model.sofia.TrueTransition
	 * @generated
	 */
	EClass getTrueTransition();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.FalseTransition <em>False Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Transition</em>'.
	 * @see eu.vicci.process.model.sofia.FalseTransition
	 * @generated
	 */
	EClass getFalseTransition();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.SOAPInvoke <em>SOAP Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SOAP Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke
	 * @generated
	 */
	EClass getSOAPInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SOAPInvoke#getServerUri <em>Server Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Uri</em>'.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke#getServerUri()
	 * @see #getSOAPInvoke()
	 * @generated
	 */
	EAttribute getSOAPInvoke_ServerUri();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SOAPInvoke#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke#getMethodName()
	 * @see #getSOAPInvoke()
	 * @generated
	 */
	EAttribute getSOAPInvoke_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SOAPInvoke#getWsdlUri <em>Wsdl Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wsdl Uri</em>'.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke#getWsdlUri()
	 * @see #getSOAPInvoke()
	 * @generated
	 */
	EAttribute getSOAPInvoke_WsdlUri();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SOAPInvoke#getConfigFile <em>Config File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Config File</em>'.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke#getConfigFile()
	 * @see #getSOAPInvoke()
	 * @generated
	 */
	EAttribute getSOAPInvoke_ConfigFile();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.XMLRPCInvoke <em>XMLRPC Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XMLRPC Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke
	 * @generated
	 */
	EClass getXMLRPCInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getServerUri <em>Server Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Uri</em>'.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke#getServerUri()
	 * @see #getXMLRPCInvoke()
	 * @generated
	 */
	EAttribute getXMLRPCInvoke_ServerUri();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke#getMethodName()
	 * @see #getXMLRPCInvoke()
	 * @generated
	 */
	EAttribute getXMLRPCInvoke_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getStartParameterSequence <em>Start Parameter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Parameter Sequence</em>'.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke#getStartParameterSequence()
	 * @see #getXMLRPCInvoke()
	 * @generated
	 */
	EAttribute getXMLRPCInvoke_StartParameterSequence();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.XMLRPCInvoke#getEndParameterSequence <em>End Parameter Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Parameter Sequence</em>'.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke#getEndParameterSequence()
	 * @see #getXMLRPCInvoke()
	 * @generated
	 */
	EAttribute getXMLRPCInvoke_EndParameterSequence();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.LoadClassStep <em>Load Class Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Load Class Step</em>'.
	 * @see eu.vicci.process.model.sofia.LoadClassStep
	 * @generated
	 */
	EClass getLoadClassStep();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.LoadClassStep#getDelegateClassName <em>Delegate Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Delegate Class Name</em>'.
	 * @see eu.vicci.process.model.sofia.LoadClassStep#getDelegateClassName()
	 * @see #getLoadClassStep()
	 * @generated
	 */
	EAttribute getLoadClassStep_DelegateClassName();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.SeMiWaInvoke <em>Se Mi Wa Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Se Mi Wa Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.SeMiWaInvoke
	 * @generated
	 */
	EClass getSeMiWaInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see eu.vicci.process.model.sofia.SeMiWaInvoke#getServiceName()
	 * @see #getSeMiWaInvoke()
	 * @generated
	 */
	EAttribute getSeMiWaInvoke_ServiceName();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SeMiWaInvoke#getNodeId <em>Node Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Id</em>'.
	 * @see eu.vicci.process.model.sofia.SeMiWaInvoke#getNodeId()
	 * @see #getSeMiWaInvoke()
	 * @generated
	 */
	EAttribute getSeMiWaInvoke_NodeId();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.RESTInvoke <em>REST Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>REST Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.RESTInvoke
	 * @generated
	 */
	EClass getRESTInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.RESTInvoke#getHTTPMethod <em>HTTP Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>HTTP Method</em>'.
	 * @see eu.vicci.process.model.sofia.RESTInvoke#getHTTPMethod()
	 * @see #getRESTInvoke()
	 * @generated
	 */
	EAttribute getRESTInvoke_HTTPMethod();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.RESTInvoke#getServerUri <em>Server Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Uri</em>'.
	 * @see eu.vicci.process.model.sofia.RESTInvoke#getServerUri()
	 * @see #getRESTInvoke()
	 * @generated
	 */
	EAttribute getRESTInvoke_ServerUri();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.OSGiInvoke <em>OS Gi Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OS Gi Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke
	 * @generated
	 */
	EClass getOSGiInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OSGiInvoke#getServiceClassName <em>Service Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Class Name</em>'.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke#getServiceClassName()
	 * @see #getOSGiInvoke()
	 * @generated
	 */
	EAttribute getOSGiInvoke_ServiceClassName();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OSGiInvoke#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke#getMethodName()
	 * @see #getOSGiInvoke()
	 * @generated
	 */
	EAttribute getOSGiInvoke_MethodName();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OSGiInvoke#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Types</em>'.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke#getParameterTypes()
	 * @see #getOSGiInvoke()
	 * @generated
	 */
	EAttribute getOSGiInvoke_ParameterTypes();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OSGiInvoke#getBundleName <em>Bundle Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Bundle Name</em>'.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke#getBundleName()
	 * @see #getOSGiInvoke()
	 * @generated
	 */
	EAttribute getOSGiInvoke_BundleName();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.SeMiWaRequest <em>Se Mi Wa Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Se Mi Wa Request</em>'.
	 * @see eu.vicci.process.model.sofia.SeMiWaRequest
	 * @generated
	 */
	EClass getSeMiWaRequest();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.SeMiWaRequest#getSSILStatement <em>SSIL Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>SSIL Statement</em>'.
	 * @see eu.vicci.process.model.sofia.SeMiWaRequest#getSSILStatement()
	 * @see #getSeMiWaRequest()
	 * @generated
	 */
	EAttribute getSeMiWaRequest_SSILStatement();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DataMapping <em>Data Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Mapping</em>'.
	 * @see eu.vicci.process.model.sofia.DataMapping
	 * @generated
	 */
	EClass getDataMapping();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.model.sofia.DataMapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Source</em>'.
	 * @see eu.vicci.process.model.sofia.DataMapping#getSource()
	 * @see #getDataMapping()
	 * @generated
	 */
	EReference getDataMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.DataMapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see eu.vicci.process.model.sofia.DataMapping#getTarget()
	 * @see #getDataMapping()
	 * @generated
	 */
	EReference getDataMapping_Target();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.DataDuplicationStep <em>Data Duplication Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Duplication Step</em>'.
	 * @see eu.vicci.process.model.sofia.DataDuplicationStep
	 * @generated
	 */
	EClass getDataDuplicationStep();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ROSInvoke <em>ROS Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ROS Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.ROSInvoke
	 * @generated
	 */
	EClass getROSInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.ROSInvoke#getServerUri <em>Server Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Uri</em>'.
	 * @see eu.vicci.process.model.sofia.ROSInvoke#getServerUri()
	 * @see #getROSInvoke()
	 * @generated
	 */
	EAttribute getROSInvoke_ServerUri();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.ROSInvoke#getServiceName <em>Service Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Name</em>'.
	 * @see eu.vicci.process.model.sofia.ROSInvoke#getServiceName()
	 * @see #getROSInvoke()
	 * @generated
	 */
	EAttribute getROSInvoke_ServiceName();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And</em>'.
	 * @see eu.vicci.process.model.sofia.And
	 * @generated
	 */
	EClass getAnd();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type</em>'.
	 * @see eu.vicci.process.model.sofia.CollectionType
	 * @generated
	 */
	EClass getCollectionType();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.CollectionType#getCollectionItemType <em>Collection Item Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Collection Item Type</em>'.
	 * @see eu.vicci.process.model.sofia.CollectionType#getCollectionItemType()
	 * @see #getCollectionType()
	 * @generated
	 */
	EReference getCollectionType_CollectionItemType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List Type</em>'.
	 * @see eu.vicci.process.model.sofia.ListType
	 * @generated
	 */
	EClass getListType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Type</em>'.
	 * @see eu.vicci.process.model.sofia.SetType
	 * @generated
	 */
	EClass getSetType();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.PublishMessage <em>Publish Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publish Message</em>'.
	 * @see eu.vicci.process.model.sofia.PublishMessage
	 * @generated
	 */
	EClass getPublishMessage();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.PublishMessage#getServerUri <em>Server Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Uri</em>'.
	 * @see eu.vicci.process.model.sofia.PublishMessage#getServerUri()
	 * @see #getPublishMessage()
	 * @generated
	 */
	EAttribute getPublishMessage_ServerUri();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.PublishMessage#getTopic <em>Topic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Topic</em>'.
	 * @see eu.vicci.process.model.sofia.PublishMessage#getTopic()
	 * @see #getPublishMessage()
	 * @generated
	 */
	EAttribute getPublishMessage_Topic();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.PublishROSMessage <em>Publish ROS Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Publish ROS Message</em>'.
	 * @see eu.vicci.process.model.sofia.PublishROSMessage
	 * @generated
	 */
	EClass getPublishROSMessage();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.HumanTask <em>Human Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human Task</em>'.
	 * @see eu.vicci.process.model.sofia.HumanTask
	 * @generated
	 */
	EClass getHumanTask();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskType <em>Human Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Human Task Type</em>'.
	 * @see eu.vicci.process.model.sofia.HumanTask#getHumanTaskType()
	 * @see #getHumanTask()
	 * @generated
	 */
	EAttribute getHumanTask_HumanTaskType();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskUseCase <em>Human Task Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Human Task Use Case</em>'.
	 * @see eu.vicci.process.model.sofia.HumanTask#getHumanTaskUseCase()
	 * @see #getHumanTask()
	 * @generated
	 */
	EAttribute getHumanTask_HumanTaskUseCase();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.EscalationPort <em>Escalation Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Escalation Port</em>'.
	 * @see eu.vicci.process.model.sofia.EscalationPort
	 * @generated
	 */
	EClass getEscalationPort();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.EscalationPort#getEscalationTime <em>Escalation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Escalation Time</em>'.
	 * @see eu.vicci.process.model.sofia.EscalationPort#getEscalationTime()
	 * @see #getEscalationPort()
	 * @generated
	 */
	EAttribute getEscalationPort_EscalationTime();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>End Data Port To Start Data Port Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Data Port To Start Data Port Map</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="eu.vicci.process.model.sofia.EndDataPort"
	 *        valueType="eu.vicci.process.model.sofia.StartDataPort"
	 * @generated
	 */
	EClass getEndDataPortToStartDataPortMap();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEndDataPortToStartDataPortMap()
	 * @generated
	 */
	EReference getEndDataPortToStartDataPortMap_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEndDataPortToStartDataPortMap()
	 * @generated
	 */
	EReference getEndDataPortToStartDataPortMap_Value();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke <em>Open Hab Semantic Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticInvoke
	 * @generated
	 */
	EClass getOpenHabSemanticInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getQuery <em>Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Query</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getQuery()
	 * @see #getOpenHabSemanticInvoke()
	 * @generated
	 */
	EAttribute getOpenHabSemanticInvoke_Query();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getServerBaseAddress <em>Server Base Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Server Base Address</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticInvoke#getServerBaseAddress()
	 * @see #getOpenHabSemanticInvoke()
	 * @generated
	 */
	EAttribute getOpenHabSemanticInvoke_ServerBaseAddress();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke#isWithLatest <em>With Latest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With Latest</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticInvoke#isWithLatest()
	 * @see #getOpenHabSemanticInvoke()
	 * @generated
	 */
	EAttribute getOpenHabSemanticInvoke_WithLatest();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke <em>Open Hab Semantic Select Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Select Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke
	 * @generated
	 */
	EClass getOpenHabSemanticSelectInvoke();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke <em>Open Hab Semantic Ask Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Ask Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke
	 * @generated
	 */
	EClass getOpenHabSemanticAskInvoke();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke <em>Open Hab Semantic Command Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Hab Semantic Command Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke
	 * @generated
	 */
	EClass getOpenHabSemanticCommandInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke#getCommand <em>Command</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Command</em>'.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke#getCommand()
	 * @see #getOpenHabSemanticCommandInvoke()
	 * @generated
	 */
	EAttribute getOpenHabSemanticCommandInvoke_Command();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.CpsStep <em>Cps Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cps Step</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep
	 * @generated
	 */
	EClass getCpsStep();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.CpsStep#isCyberPhysical <em>Cyber Physical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cyber Physical</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#isCyberPhysical()
	 * @see #getCpsStep()
	 * @generated
	 */
	EAttribute getCpsStep_CyberPhysical();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.CpsStep#getGoal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Goal</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#getGoal()
	 * @see #getCpsStep()
	 * @generated
	 */
	EAttribute getCpsStep_Goal();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.CpsStep#getEplQuery <em>Epl Query</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Epl Query</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#getEplQuery()
	 * @see #getCpsStep()
	 * @generated
	 */
	EAttribute getCpsStep_EplQuery();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.CpsStep#getControlProcessId <em>Control Process Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Control Process Id</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#getControlProcessId()
	 * @see #getCpsStep()
	 * @generated
	 */
	EAttribute getCpsStep_ControlProcessId();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.model.sofia.CpsStep#getControlProcess <em>Control Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Control Process</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#getControlProcess()
	 * @see #getCpsStep()
	 * @generated
	 */
	EReference getCpsStep_ControlProcess();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.CpsStep#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Context</em>'.
	 * @see eu.vicci.process.model.sofia.CpsStep#getContext()
	 * @see #getCpsStep()
	 * @generated
	 */
	EAttribute getCpsStep_Context();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.MapeK <em>Mape K</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mape K</em>'.
	 * @see eu.vicci.process.model.sofia.MapeK
	 * @generated
	 */
	EClass getMapeK();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.model.sofia.GoalInvoke <em>Goal Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal Invoke</em>'.
	 * @see eu.vicci.process.model.sofia.GoalInvoke
	 * @generated
	 */
	EClass getGoalInvoke();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.GoalInvoke#getInvokeGoal <em>Invoke Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Invoke Goal</em>'.
	 * @see eu.vicci.process.model.sofia.GoalInvoke#getInvokeGoal()
	 * @see #getGoalInvoke()
	 * @generated
	 */
	EAttribute getGoalInvoke_InvokeGoal();

	/**
	 * Returns the meta object for the attribute list '{@link eu.vicci.process.model.sofia.GoalInvoke#getQualities <em>Qualities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Qualities</em>'.
	 * @see eu.vicci.process.model.sofia.GoalInvoke#getQualities()
	 * @see #getGoalInvoke()
	 * @generated
	 */
	EAttribute getGoalInvoke_Qualities();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.model.sofia.GoalInvoke#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see eu.vicci.process.model.sofia.GoalInvoke#getLocation()
	 * @see #getGoalInvoke()
	 * @generated
	 */
	EAttribute getGoalInvoke_Location();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofia.Comparator <em>Comparator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Comparator</em>'.
	 * @see eu.vicci.process.model.sofia.Comparator
	 * @generated
	 */
	EEnum getComparator();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofia.HTTPverb <em>HTT Pverb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HTT Pverb</em>'.
	 * @see eu.vicci.process.model.sofia.HTTPverb
	 * @generated
	 */
	EEnum getHTTPverb();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofia.SemanticTargetType <em>Semantic Target Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Semantic Target Type</em>'.
	 * @see eu.vicci.process.model.sofia.SemanticTargetType
	 * @generated
	 */
	EEnum getSemanticTargetType();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofia.HumanTaskType <em>Human Task Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Human Task Type</em>'.
	 * @see eu.vicci.process.model.sofia.HumanTaskType
	 * @generated
	 */
	EEnum getHumanTaskType();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.model.sofia.HumanTaskUseCase <em>Human Task Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Human Task Use Case</em>'.
	 * @see eu.vicci.process.model.sofia.HumanTaskUseCase
	 * @generated
	 */
	EEnum getHumanTaskUseCase();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SofiaFactory getSofiaFactory();

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
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.TransitionImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Source Port</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__SOURCE_PORT = eINSTANCE.getTransition_SourcePort();

		/**
		 * The meta object literal for the '<em><b>Target Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__TARGET_PORT = eINSTANCE.getTransition_TargetPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.IfImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>If Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__IF_CONDITION = eINSTANCE.getIf_IfCondition();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OrImpl <em>Or</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OrImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOr()
		 * @generated
		 */
		EClass OR = eINSTANCE.getOr();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.InvokeImpl <em>Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.InvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getInvoke()
		 * @generated
		 */
		EClass INVOKE = eINSTANCE.getInvoke();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.EventImpl <em>Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.EventImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEvent()
		 * @generated
		 */
		EClass EVENT = eINSTANCE.getEvent();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ProcessImpl <em>Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ProcessImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcess()
		 * @generated
		 */
		EClass PROCESS = eINSTANCE.getProcess();

		/**
		 * The meta object literal for the '<em><b>Data Type Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS__DATA_TYPE_DEFINITIONS = eINSTANCE.getProcess_DataTypeDefinitions();

		/**
		 * The meta object literal for the '<em><b>Execution Peer</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__EXECUTION_PEER = eINSTANCE.getProcess_ExecutionPeer();

		/**
		 * The meta object literal for the '<em><b>Distributed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__DISTRIBUTED = eINSTANCE.getProcess_Distributed();

		/**
		 * The meta object literal for the '<em><b>Remote Executing</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS__REMOTE_EXECUTING = eINSTANCE.getProcess_RemoteExecuting();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.PortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Out Transitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__OUT_TRANSITIONS = eINSTANCE.getPort_OutTransitions();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__OPTIONAL = eINSTANCE.getPort_Optional();

		/**
		 * The meta object literal for the '<em><b>Process Step</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PROCESS_STEP = eINSTANCE.getPort_ProcessStep();

		/**
		 * The meta object literal for the '<em><b>In Transitions</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__IN_TRANSITIONS = eINSTANCE.getPort_InTransitions();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__DESCRIPTION = eINSTANCE.getPort_Description();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DataPortImpl <em>Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DataPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataPort()
		 * @generated
		 */
		EClass DATA_PORT = eINSTANCE.getDataPort();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PORT__VALUE = eINSTANCE.getDataPort_Value();

		/**
		 * The meta object literal for the '<em><b>Port Datatype</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PORT__PORT_DATATYPE = eINSTANCE.getDataPort_PortDatatype();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PORT__MAPPINGS = eINSTANCE.getDataPort_Mappings();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ControlPortImpl <em>Control Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ControlPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getControlPort()
		 * @generated
		 */
		EClass CONTROL_PORT = eINSTANCE.getControlPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl <em>Process Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ProcessStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcessStep()
		 * @generated
		 */
		EClass PROCESS_STEP = eINSTANCE.getProcessStep();

		/**
		 * The meta object literal for the '<em><b>Parentstep</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STEP__PARENTSTEP = eINSTANCE.getProcessStep_Parentstep();

		/**
		 * The meta object literal for the '<em><b>Ports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_STEP__PORTS = eINSTANCE.getProcessStep_Ports();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP__TYPE = eINSTANCE.getProcessStep_Type();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP__DESCRIPTION = eINSTANCE.getProcessStep_Description();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_STEP__RESOURCE = eINSTANCE.getProcessStep_Resource();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ComplexTypeImpl <em>Complex Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ComplexTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getComplexType()
		 * @generated
		 */
		EClass COMPLEX_TYPE = eINSTANCE.getComplexType();

		/**
		 * The meta object literal for the '<em><b>Subtypes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_TYPE__SUBTYPES = eINSTANCE.getComplexType_Subtypes();

		/**
		 * The meta object literal for the '<em><b>Subreferences</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLEX_TYPE__SUBREFERENCES = eINSTANCE.getComplexType_Subreferences();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ConditionImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '<em><b>Comparator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONDITION__COMPARATOR = eINSTANCE.getCondition_Comparator();

		/**
		 * The meta object literal for the '<em><b>Left Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__LEFT_SIDE = eINSTANCE.getCondition_LeftSide();

		/**
		 * The meta object literal for the '<em><b>Right Side</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITION__RIGHT_SIDE = eINSTANCE.getCondition_RightSide();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.AtomicStepImpl <em>Atomic Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.AtomicStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getAtomicStep()
		 * @generated
		 */
		EClass ATOMIC_STEP = eINSTANCE.getAtomicStep();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.CompositeStepImpl <em>Composite Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.CompositeStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCompositeStep()
		 * @generated
		 */
		EClass COMPOSITE_STEP = eINSTANCE.getCompositeStep();

		/**
		 * The meta object literal for the '<em><b>Sub Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_STEP__SUB_STEPS = eINSTANCE.getCompositeStep_SubSteps();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DataTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Belongs To</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__BELONGS_TO = eINSTANCE.getDataType_BelongsTo();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__MAPPINGS = eINSTANCE.getDataType_Mappings();

		/**
		 * The meta object literal for the '<em><b>Port Members</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE__PORT_MEMBERS = eINSTANCE.getDataType_PortMembers();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.SimpleTypeImpl <em>Simple Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.SimpleTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSimpleType()
		 * @generated
		 */
		EClass SIMPLE_TYPE = eINSTANCE.getSimpleType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.StringTypeImpl <em>String Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.StringTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStringType()
		 * @generated
		 */
		EClass STRING_TYPE = eINSTANCE.getStringType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.NumericTypeImpl <em>Numeric Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.NumericTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getNumericType()
		 * @generated
		 */
		EClass NUMERIC_TYPE = eINSTANCE.getNumericType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.BooleanTypeImpl <em>Boolean Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.BooleanTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getBooleanType()
		 * @generated
		 */
		EClass BOOLEAN_TYPE = eINSTANCE.getBooleanType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.IntegerTypeImpl <em>Integer Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.IntegerTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIntegerType()
		 * @generated
		 */
		EClass INTEGER_TYPE = eINSTANCE.getIntegerType();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MIN = eINSTANCE.getIntegerType_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_TYPE__MAX = eINSTANCE.getIntegerType_Max();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DoubleTypeImpl <em>Double Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DoubleTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDoubleType()
		 * @generated
		 */
		EClass DOUBLE_TYPE = eINSTANCE.getDoubleType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.LoopImpl <em>Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.LoopImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getLoop()
		 * @generated
		 */
		EClass LOOP = eINSTANCE.getLoop();

		/**
		 * The meta object literal for the '<em><b>Loop Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__LOOP_CONDITION = eINSTANCE.getLoop_LoopCondition();

		/**
		 * The meta object literal for the '<em><b>Ports Copy To Startsport</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP__PORTS_COPY_TO_STARTSPORT = eINSTANCE.getLoop_PortsCopyToStartsport();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.RepeatLoopImpl <em>Repeat Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.RepeatLoopImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getRepeatLoop()
		 * @generated
		 */
		EClass REPEAT_LOOP = eINSTANCE.getRepeatLoop();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.WhileLoopImpl <em>While Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.WhileLoopImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getWhileLoop()
		 * @generated
		 */
		EClass WHILE_LOOP = eINSTANCE.getWhileLoop();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ForLoopImpl <em>For Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ForLoopImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getForLoop()
		 * @generated
		 */
		EClass FOR_LOOP = eINSTANCE.getForLoop();

		/**
		 * The meta object literal for the '<em><b>Loop Step Width</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_LOOP__LOOP_STEP_WIDTH = eINSTANCE.getForLoop_LoopStepWidth();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ProcessSlotImpl <em>Process Slot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ProcessSlotImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getProcessSlot()
		 * @generated
		 */
		EClass PROCESS_SLOT = eINSTANCE.getProcessSlot();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DataMappingStepImpl <em>Data Mapping Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DataMappingStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataMappingStep()
		 * @generated
		 */
		EClass DATA_MAPPING_STEP = eINSTANCE.getDataMappingStep();

		/**
		 * The meta object literal for the '<em><b>Mappings</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPING_STEP__MAPPINGS = eINSTANCE.getDataMappingStep_Mappings();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.StartControlPortImpl <em>Start Control Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.StartControlPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartControlPort()
		 * @generated
		 */
		EClass START_CONTROL_PORT = eINSTANCE.getStartControlPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.EndControlPortImpl <em>End Control Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.EndControlPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndControlPort()
		 * @generated
		 */
		EClass END_CONTROL_PORT = eINSTANCE.getEndControlPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.StartDataPortImpl <em>Start Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.StartDataPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartDataPort()
		 * @generated
		 */
		EClass START_DATA_PORT = eINSTANCE.getStartDataPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.EndDataPortImpl <em>End Data Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.EndDataPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndDataPort()
		 * @generated
		 */
		EClass END_DATA_PORT = eINSTANCE.getEndDataPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.StartPort <em>Start Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.StartPort
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getStartPort()
		 * @generated
		 */
		EClass START_PORT = eINSTANCE.getStartPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.EndPort <em>End Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.EndPort
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndPort()
		 * @generated
		 */
		EClass END_PORT = eINSTANCE.getEndPort();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.IdentifiableImpl <em>Identifiable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.IdentifiableImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getIdentifiable()
		 * @generated
		 */
		EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_Id();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.NameableImpl <em>Nameable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.NameableImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getNameable()
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
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.TriggeredEventImpl <em>Triggered Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.TriggeredEventImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTriggeredEvent()
		 * @generated
		 */
		EClass TRIGGERED_EVENT = eINSTANCE.getTriggeredEvent();

		/**
		 * The meta object literal for the '<em><b>EPL Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRIGGERED_EVENT__EPL_STATEMENT = eINSTANCE.getTriggeredEvent_EPLStatement();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.TrueTransitionImpl <em>True Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.TrueTransitionImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getTrueTransition()
		 * @generated
		 */
		EClass TRUE_TRANSITION = eINSTANCE.getTrueTransition();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.FalseTransitionImpl <em>False Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.FalseTransitionImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getFalseTransition()
		 * @generated
		 */
		EClass FALSE_TRANSITION = eINSTANCE.getFalseTransition();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl <em>SOAP Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.SOAPInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSOAPInvoke()
		 * @generated
		 */
		EClass SOAP_INVOKE = eINSTANCE.getSOAPInvoke();

		/**
		 * The meta object literal for the '<em><b>Server Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOAP_INVOKE__SERVER_URI = eINSTANCE.getSOAPInvoke_ServerUri();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOAP_INVOKE__METHOD_NAME = eINSTANCE.getSOAPInvoke_MethodName();

		/**
		 * The meta object literal for the '<em><b>Wsdl Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOAP_INVOKE__WSDL_URI = eINSTANCE.getSOAPInvoke_WsdlUri();

		/**
		 * The meta object literal for the '<em><b>Config File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOAP_INVOKE__CONFIG_FILE = eINSTANCE.getSOAPInvoke_ConfigFile();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl <em>XMLRPC Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getXMLRPCInvoke()
		 * @generated
		 */
		EClass XMLRPC_INVOKE = eINSTANCE.getXMLRPCInvoke();

		/**
		 * The meta object literal for the '<em><b>Server Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMLRPC_INVOKE__SERVER_URI = eINSTANCE.getXMLRPCInvoke_ServerUri();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMLRPC_INVOKE__METHOD_NAME = eINSTANCE.getXMLRPCInvoke_MethodName();

		/**
		 * The meta object literal for the '<em><b>Start Parameter Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMLRPC_INVOKE__START_PARAMETER_SEQUENCE = eINSTANCE.getXMLRPCInvoke_StartParameterSequence();

		/**
		 * The meta object literal for the '<em><b>End Parameter Sequence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute XMLRPC_INVOKE__END_PARAMETER_SEQUENCE = eINSTANCE.getXMLRPCInvoke_EndParameterSequence();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.LoadClassStepImpl <em>Load Class Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.LoadClassStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getLoadClassStep()
		 * @generated
		 */
		EClass LOAD_CLASS_STEP = eINSTANCE.getLoadClassStep();

		/**
		 * The meta object literal for the '<em><b>Delegate Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOAD_CLASS_STEP__DELEGATE_CLASS_NAME = eINSTANCE.getLoadClassStep_DelegateClassName();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.SeMiWaInvokeImpl <em>Se Mi Wa Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.SeMiWaInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSeMiWaInvoke()
		 * @generated
		 */
		EClass SE_MI_WA_INVOKE = eINSTANCE.getSeMiWaInvoke();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SE_MI_WA_INVOKE__SERVICE_NAME = eINSTANCE.getSeMiWaInvoke_ServiceName();

		/**
		 * The meta object literal for the '<em><b>Node Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SE_MI_WA_INVOKE__NODE_ID = eINSTANCE.getSeMiWaInvoke_NodeId();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.RESTInvokeImpl <em>REST Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.RESTInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getRESTInvoke()
		 * @generated
		 */
		EClass REST_INVOKE = eINSTANCE.getRESTInvoke();

		/**
		 * The meta object literal for the '<em><b>HTTP Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_INVOKE__HTTP_METHOD = eINSTANCE.getRESTInvoke_HTTPMethod();

		/**
		 * The meta object literal for the '<em><b>Server Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REST_INVOKE__SERVER_URI = eINSTANCE.getRESTInvoke_ServerUri();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl <em>OS Gi Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OSGiInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOSGiInvoke()
		 * @generated
		 */
		EClass OS_GI_INVOKE = eINSTANCE.getOSGiInvoke();

		/**
		 * The meta object literal for the '<em><b>Service Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_GI_INVOKE__SERVICE_CLASS_NAME = eINSTANCE.getOSGiInvoke_ServiceClassName();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_GI_INVOKE__METHOD_NAME = eINSTANCE.getOSGiInvoke_MethodName();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_GI_INVOKE__PARAMETER_TYPES = eINSTANCE.getOSGiInvoke_ParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Bundle Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OS_GI_INVOKE__BUNDLE_NAME = eINSTANCE.getOSGiInvoke_BundleName();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.SeMiWaRequestImpl <em>Se Mi Wa Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.SeMiWaRequestImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSeMiWaRequest()
		 * @generated
		 */
		EClass SE_MI_WA_REQUEST = eINSTANCE.getSeMiWaRequest();

		/**
		 * The meta object literal for the '<em><b>SSIL Statement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SE_MI_WA_REQUEST__SSIL_STATEMENT = eINSTANCE.getSeMiWaRequest_SSILStatement();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DataMappingImpl <em>Data Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DataMappingImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataMapping()
		 * @generated
		 */
		EClass DATA_MAPPING = eINSTANCE.getDataMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPING__SOURCE = eINSTANCE.getDataMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_MAPPING__TARGET = eINSTANCE.getDataMapping_Target();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.DataDuplicationStepImpl <em>Data Duplication Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.DataDuplicationStepImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getDataDuplicationStep()
		 * @generated
		 */
		EClass DATA_DUPLICATION_STEP = eINSTANCE.getDataDuplicationStep();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ROSInvokeImpl <em>ROS Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ROSInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getROSInvoke()
		 * @generated
		 */
		EClass ROS_INVOKE = eINSTANCE.getROSInvoke();

		/**
		 * The meta object literal for the '<em><b>Server Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROS_INVOKE__SERVER_URI = eINSTANCE.getROSInvoke_ServerUri();

		/**
		 * The meta object literal for the '<em><b>Service Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROS_INVOKE__SERVICE_NAME = eINSTANCE.getROSInvoke_ServiceName();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.AndImpl <em>And</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.AndImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getAnd()
		 * @generated
		 */
		EClass AND = eINSTANCE.getAnd();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.CollectionTypeImpl <em>Collection Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.CollectionTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCollectionType()
		 * @generated
		 */
		EClass COLLECTION_TYPE = eINSTANCE.getCollectionType();

		/**
		 * The meta object literal for the '<em><b>Collection Item Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_TYPE__COLLECTION_ITEM_TYPE = eINSTANCE.getCollectionType_CollectionItemType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.ListTypeImpl <em>List Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.ListTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getListType()
		 * @generated
		 */
		EClass LIST_TYPE = eINSTANCE.getListType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.SetTypeImpl <em>Set Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.SetTypeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSetType()
		 * @generated
		 */
		EClass SET_TYPE = eINSTANCE.getSetType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.PublishMessageImpl <em>Publish Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.PublishMessageImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPublishMessage()
		 * @generated
		 */
		EClass PUBLISH_MESSAGE = eINSTANCE.getPublishMessage();

		/**
		 * The meta object literal for the '<em><b>Server Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISH_MESSAGE__SERVER_URI = eINSTANCE.getPublishMessage_ServerUri();

		/**
		 * The meta object literal for the '<em><b>Topic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PUBLISH_MESSAGE__TOPIC = eINSTANCE.getPublishMessage_Topic();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.PublishROSMessageImpl <em>Publish ROS Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.PublishROSMessageImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getPublishROSMessage()
		 * @generated
		 */
		EClass PUBLISH_ROS_MESSAGE = eINSTANCE.getPublishROSMessage();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.HumanTaskImpl <em>Human Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.HumanTaskImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTask()
		 * @generated
		 */
		EClass HUMAN_TASK = eINSTANCE.getHumanTask();

		/**
		 * The meta object literal for the '<em><b>Human Task Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HUMAN_TASK__HUMAN_TASK_TYPE = eINSTANCE.getHumanTask_HumanTaskType();

		/**
		 * The meta object literal for the '<em><b>Human Task Use Case</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HUMAN_TASK__HUMAN_TASK_USE_CASE = eINSTANCE.getHumanTask_HumanTaskUseCase();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.EscalationPortImpl <em>Escalation Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.EscalationPortImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEscalationPort()
		 * @generated
		 */
		EClass ESCALATION_PORT = eINSTANCE.getEscalationPort();

		/**
		 * The meta object literal for the '<em><b>Escalation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ESCALATION_PORT__ESCALATION_TIME = eINSTANCE.getEscalationPort_EscalationTime();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.EndDataPortToStartDataPortMapImpl <em>End Data Port To Start Data Port Map</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.EndDataPortToStartDataPortMapImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getEndDataPortToStartDataPortMap()
		 * @generated
		 */
		EClass END_DATA_PORT_TO_START_DATA_PORT_MAP = eINSTANCE.getEndDataPortToStartDataPortMap();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_DATA_PORT_TO_START_DATA_PORT_MAP__KEY = eINSTANCE.getEndDataPortToStartDataPortMap_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference END_DATA_PORT_TO_START_DATA_PORT_MAP__VALUE = eINSTANCE.getEndDataPortToStartDataPortMap_Value();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl <em>Open Hab Semantic Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticInvoke()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_INVOKE = eINSTANCE.getOpenHabSemanticInvoke();

		/**
		 * The meta object literal for the '<em><b>Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_HAB_SEMANTIC_INVOKE__QUERY = eINSTANCE.getOpenHabSemanticInvoke_Query();

		/**
		 * The meta object literal for the '<em><b>Server Base Address</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS = eINSTANCE.getOpenHabSemanticInvoke_ServerBaseAddress();

		/**
		 * The meta object literal for the '<em><b>With Latest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST = eINSTANCE.getOpenHabSemanticInvoke_WithLatest();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticSelectInvokeImpl <em>Open Hab Semantic Select Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticSelectInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticSelectInvoke()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_SELECT_INVOKE = eINSTANCE.getOpenHabSemanticSelectInvoke();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticAskInvokeImpl <em>Open Hab Semantic Ask Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticAskInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticAskInvoke()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_ASK_INVOKE = eINSTANCE.getOpenHabSemanticAskInvoke();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticCommandInvokeImpl <em>Open Hab Semantic Command Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.OpenHabSemanticCommandInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getOpenHabSemanticCommandInvoke()
		 * @generated
		 */
		EClass OPEN_HAB_SEMANTIC_COMMAND_INVOKE = eINSTANCE.getOpenHabSemanticCommandInvoke();

		/**
		 * The meta object literal for the '<em><b>Command</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPEN_HAB_SEMANTIC_COMMAND_INVOKE__COMMAND = eINSTANCE.getOpenHabSemanticCommandInvoke_Command();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.CpsStep <em>Cps Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.CpsStep
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getCpsStep()
		 * @generated
		 */
		EClass CPS_STEP = eINSTANCE.getCpsStep();

		/**
		 * The meta object literal for the '<em><b>Cyber Physical</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPS_STEP__CYBER_PHYSICAL = eINSTANCE.getCpsStep_CyberPhysical();

		/**
		 * The meta object literal for the '<em><b>Goal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPS_STEP__GOAL = eINSTANCE.getCpsStep_Goal();

		/**
		 * The meta object literal for the '<em><b>Epl Query</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPS_STEP__EPL_QUERY = eINSTANCE.getCpsStep_EplQuery();

		/**
		 * The meta object literal for the '<em><b>Control Process Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPS_STEP__CONTROL_PROCESS_ID = eINSTANCE.getCpsStep_ControlProcessId();

		/**
		 * The meta object literal for the '<em><b>Control Process</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPS_STEP__CONTROL_PROCESS = eINSTANCE.getCpsStep_ControlProcess();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPS_STEP__CONTEXT = eINSTANCE.getCpsStep_Context();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.MapeKImpl <em>Mape K</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.MapeKImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getMapeK()
		 * @generated
		 */
		EClass MAPE_K = eINSTANCE.getMapeK();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.impl.GoalInvokeImpl <em>Goal Invoke</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.impl.GoalInvokeImpl
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getGoalInvoke()
		 * @generated
		 */
		EClass GOAL_INVOKE = eINSTANCE.getGoalInvoke();

		/**
		 * The meta object literal for the '<em><b>Invoke Goal</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_INVOKE__INVOKE_GOAL = eINSTANCE.getGoalInvoke_InvokeGoal();

		/**
		 * The meta object literal for the '<em><b>Qualities</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_INVOKE__QUALITIES = eINSTANCE.getGoalInvoke_Qualities();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GOAL_INVOKE__LOCATION = eINSTANCE.getGoalInvoke_Location();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.Comparator <em>Comparator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.Comparator
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getComparator()
		 * @generated
		 */
		EEnum COMPARATOR = eINSTANCE.getComparator();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.HTTPverb <em>HTT Pverb</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.HTTPverb
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHTTPverb()
		 * @generated
		 */
		EEnum HTT_PVERB = eINSTANCE.getHTTPverb();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.SemanticTargetType <em>Semantic Target Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.SemanticTargetType
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getSemanticTargetType()
		 * @generated
		 */
		EEnum SEMANTIC_TARGET_TYPE = eINSTANCE.getSemanticTargetType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.HumanTaskType <em>Human Task Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.HumanTaskType
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTaskType()
		 * @generated
		 */
		EEnum HUMAN_TASK_TYPE = eINSTANCE.getHumanTaskType();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.model.sofia.HumanTaskUseCase <em>Human Task Use Case</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.model.sofia.HumanTaskUseCase
		 * @see eu.vicci.process.model.sofia.impl.SofiaPackageImpl#getHumanTaskUseCase()
		 * @generated
		 */
		EEnum HUMAN_TASK_USE_CASE = eINSTANCE.getHumanTaskUseCase();

	}

} //SofiaPackage
