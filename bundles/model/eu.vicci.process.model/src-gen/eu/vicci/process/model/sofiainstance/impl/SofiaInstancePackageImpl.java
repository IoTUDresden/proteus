/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.SofiaPackage;

import eu.vicci.process.model.sofiainstance.AndInstance;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.CollectionTypeInstance;
import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.ControlPortInstance;
import eu.vicci.process.model.sofiainstance.CpsState;
import eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance;
import eu.vicci.process.model.sofiainstance.DataMappingStepInstance;
import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndControlPortInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.EndPortInstance;
import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.EventInstance;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.FalseTransitionInstance;
import eu.vicci.process.model.sofiainstance.ForLoopInstance;
import eu.vicci.process.model.sofiainstance.GoalInvokeInstance;
import eu.vicci.process.model.sofiainstance.HumanTaskInstance;
import eu.vicci.process.model.sofiainstance.IfInstance;
import eu.vicci.process.model.sofiainstance.InstanceIdentifiable;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.ListTypeInstance;
import eu.vicci.process.model.sofiainstance.LoadClassStepInstance;
import eu.vicci.process.model.sofiainstance.LoopInstance;
import eu.vicci.process.model.sofiainstance.MapeKInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.Nameable;
import eu.vicci.process.model.sofiainstance.OSGiInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance;
import eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance;
import eu.vicci.process.model.sofiainstance.OrInstance;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.ProcessSlotInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.RESTInvokeInstance;
import eu.vicci.process.model.sofiainstance.ROSInvokeInstance;
import eu.vicci.process.model.sofiainstance.SOAPInvokeInstance;
import eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance;
import eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance;
import eu.vicci.process.model.sofiainstance.SetTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstanceFactory;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.StartControlPortInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.StartPortInstance;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.Stateful;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.TransitionInstance;
import eu.vicci.process.model.sofiainstance.TriggeredEventInstance;
import eu.vicci.process.model.sofiainstance.TrueTransitionInstance;
import eu.vicci.process.model.sofiainstance.WhileLoopInstance;
import eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SofiaInstancePackageImpl extends EPackageImpl implements SofiaInstancePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processStepInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statefulEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceIdentifiableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startControlPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startDataPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endControlPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endDataPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingUtilEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueTransitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseTransitionInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass escalationPortInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forLoopInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rosInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSlotInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDuplicationStepInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osGiInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soapInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanTaskInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadClassStepInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seMiWaInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggeredEventInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlrpcInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seMiWaRequestInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMappingStepInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileLoopInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endDataPortToStartDataPortMapInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticSelectInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticAskInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticCommandInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapeKInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalInvokeInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum stateEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionPermissionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum cpsStateEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SofiaInstancePackageImpl() {
		super(eNS_URI, SofiaInstanceFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link SofiaInstancePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SofiaInstancePackage init() {
		if (isInited) return (SofiaInstancePackage)EPackage.Registry.INSTANCE.getEPackage(SofiaInstancePackage.eNS_URI);

		// Obtain or create and register package
		SofiaInstancePackageImpl theSofiaInstancePackage = (SofiaInstancePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SofiaInstancePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SofiaInstancePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SofiaPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSofiaInstancePackage.createPackageContents();

		// Initialize created meta-data
		theSofiaInstancePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSofiaInstancePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SofiaInstancePackage.eNS_URI, theSofiaInstancePackage);
		return theSofiaInstancePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessInstance() {
		return processInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessInstance_RunningForInstanceId() {
		return (EAttribute)processInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessStepInstance() {
		return processStepInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessStepInstance_ProcessStepType() {
		return (EReference)processStepInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_Permission() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_Delay() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessStepInstance_Ports() {
		return (EReference)processStepInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessStepInstance_SubSteps() {
		return (EReference)processStepInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_ProcessInstanceID() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_ProcessModelID() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_ModelID() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStepInstance_CyberPhysical() {
		return (EAttribute)processStepInstanceEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStateful() {
		return statefulEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateful_ExecutionState() {
		return (EAttribute)statefulEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStateful_CpsExecutionState() {
		return (EAttribute)statefulEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortInstance() {
		return portInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_PortType() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_ProcessStepInstance() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_OutTransitionInstances() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortInstance_Decoupled() {
		return (EAttribute)portInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortInstance_InTransitionInstances() {
		return (EReference)portInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortInstance_TypeId() {
		return (EAttribute)portInstanceEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceIdentifiable() {
		return instanceIdentifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceIdentifiable_InstanceId() {
		return (EAttribute)instanceIdentifiableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInstanceIdentifiable_Instancenumber() {
		return (EAttribute)instanceIdentifiableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEventInstance() {
		return eventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEventInstance_TimeStamp() {
		return (EAttribute)eventInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringTypeInstance() {
		return stringTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringTypeInstance_Value() {
		return (EAttribute)stringTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringTypeInstance_StringTypeType() {
		return (EReference)stringTypeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerTypeInstance() {
		return integerTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerTypeInstance_Value() {
		return (EAttribute)integerTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIntegerTypeInstance_IntegerTypeType() {
		return (EReference)integerTypeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleTypeInstance() {
		return doubleTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleTypeInstance_Value() {
		return (EAttribute)doubleTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDoubleTypeInstance_DoubleTypeType() {
		return (EReference)doubleTypeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanTypeInstance() {
		return booleanTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanTypeInstance_Value() {
		return (EAttribute)booleanTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanTypeInstance_BooleanTypeType() {
		return (EReference)booleanTypeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransitionInstance() {
		return transitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionInstance_TransitionType() {
		return (EReference)transitionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionInstance_SourcePortInstance() {
		return (EReference)transitionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransitionInstance_TargetPortInstance() {
		return (EReference)transitionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPortInstance() {
		return dataPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPortInstance_DataInstance() {
		return (EReference)dataPortInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlPortInstance() {
		return controlPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartPortInstance() {
		return startPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPortInstance() {
		return endPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartControlPortInstance() {
		return startControlPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartDataPortInstance() {
		return startDataPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndControlPortInstance() {
		return endControlPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndDataPortInstance() {
		return endDataPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeInstance() {
		return dataTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeInstance_DataTypeType() {
		return (EReference)dataTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeInstance_BelongsTo() {
		return (EReference)dataTypeInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeInstance_IdOfOrigin() {
		return (EAttribute)dataTypeInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataTypeInstance_TypeId() {
		return (EAttribute)dataTypeInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Delay() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_Permission() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConfiguration_DecoupleNextSteps() {
		return (EAttribute)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingUtil() {
		return mappingUtilEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIfInstance() {
		return ifInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIfInstance_IfConditionInstance() {
		return (EReference)ifInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConditionInstance() {
		return conditionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionInstance_ExpressionInstance() {
		return (EAttribute)conditionInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConditionInstance_Result() {
		return (EAttribute)conditionInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionInstance_IfConditionType() {
		return (EReference)conditionInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionInstance_LeftSide() {
		return (EReference)conditionInstanceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConditionInstance_RightSide() {
		return (EReference)conditionInstanceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueTransitionInstance() {
		return trueTransitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseTransitionInstance() {
		return falseTransitionInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexTypeInstance() {
		return complexTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexTypeInstance_Subtypes() {
		return (EReference)complexTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListTypeInstance() {
		return listTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeInstance() {
		return collectionTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTypeInstance_CollectionItemType() {
		return (EReference)collectionTypeInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTypeInstance() {
		return setTypeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameable() {
		return nameableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameable_Name() {
		return (EAttribute)nameableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEscalationPortInstance() {
		return escalationPortInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEscalationPortInstance_EscalationReason() {
		return (EAttribute)escalationPortInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopInstance() {
		return loopInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopInstance_LoopConditionInstance() {
		return (EReference)loopInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopInstance_PortsCopyToStartport() {
		return (EReference)loopInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForLoopInstance() {
		return forLoopInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForLoopInstance_LoopStepWidth() {
		return (EReference)forLoopInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAndInstance() {
		return andInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrInstance() {
		return orInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getROSInvokeInstance() {
		return rosInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSlotInstance() {
		return processSlotInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataDuplicationStepInstance() {
		return dataDuplicationStepInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRESTInvokeInstance() {
		return restInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOSGiInvokeInstance() {
		return osGiInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSOAPInvokeInstance() {
		return soapInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHumanTaskInstance() {
		return humanTaskInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadClassStepInstance() {
		return loadClassStepInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeMiWaInvokeInstance() {
		return seMiWaInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggeredEventInstance() {
		return triggeredEventInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMLRPCInvokeInstance() {
		return xmlrpcInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeMiWaRequestInstance() {
		return seMiWaRequestInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMappingStepInstance() {
		return dataMappingStepInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileLoopInstance() {
		return whileLoopInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndDataPortToStartDataPortMapInstance() {
		return endDataPortToStartDataPortMapInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndDataPortToStartDataPortMapInstance_Value() {
		return (EReference)endDataPortToStartDataPortMapInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndDataPortToStartDataPortMapInstance_Key() {
		return (EReference)endDataPortToStartDataPortMapInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticInvokeInstance() {
		return openHabSemanticInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticSelectInvokeInstance() {
		return openHabSemanticSelectInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticAskInvokeInstance() {
		return openHabSemanticAskInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticCommandInvokeInstance() {
		return openHabSemanticCommandInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapeKInstance() {
		return mapeKInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalInvokeInstance() {
		return goalInvokeInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getState() {
		return stateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionPermission() {
		return executionPermissionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCpsState() {
		return cpsStateEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaInstanceFactory getSofiaInstanceFactory() {
		return (SofiaInstanceFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		processInstanceEClass = createEClass(PROCESS_INSTANCE);
		createEAttribute(processInstanceEClass, PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID);

		processStepInstanceEClass = createEClass(PROCESS_STEP_INSTANCE);
		createEReference(processStepInstanceEClass, PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__PERMISSION);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__DELAY);
		createEReference(processStepInstanceEClass, PROCESS_STEP_INSTANCE__PORTS);
		createEReference(processStepInstanceEClass, PROCESS_STEP_INSTANCE__SUB_STEPS);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__MODEL_ID);
		createEAttribute(processStepInstanceEClass, PROCESS_STEP_INSTANCE__CYBER_PHYSICAL);

		statefulEClass = createEClass(STATEFUL);
		createEAttribute(statefulEClass, STATEFUL__EXECUTION_STATE);
		createEAttribute(statefulEClass, STATEFUL__CPS_EXECUTION_STATE);

		portInstanceEClass = createEClass(PORT_INSTANCE);
		createEReference(portInstanceEClass, PORT_INSTANCE__PORT_TYPE);
		createEReference(portInstanceEClass, PORT_INSTANCE__PROCESS_STEP_INSTANCE);
		createEReference(portInstanceEClass, PORT_INSTANCE__OUT_TRANSITION_INSTANCES);
		createEAttribute(portInstanceEClass, PORT_INSTANCE__DECOUPLED);
		createEReference(portInstanceEClass, PORT_INSTANCE__IN_TRANSITION_INSTANCES);
		createEAttribute(portInstanceEClass, PORT_INSTANCE__TYPE_ID);

		instanceIdentifiableEClass = createEClass(INSTANCE_IDENTIFIABLE);
		createEAttribute(instanceIdentifiableEClass, INSTANCE_IDENTIFIABLE__INSTANCE_ID);
		createEAttribute(instanceIdentifiableEClass, INSTANCE_IDENTIFIABLE__INSTANCENUMBER);

		eventInstanceEClass = createEClass(EVENT_INSTANCE);
		createEAttribute(eventInstanceEClass, EVENT_INSTANCE__TIME_STAMP);

		stringTypeInstanceEClass = createEClass(STRING_TYPE_INSTANCE);
		createEAttribute(stringTypeInstanceEClass, STRING_TYPE_INSTANCE__VALUE);
		createEReference(stringTypeInstanceEClass, STRING_TYPE_INSTANCE__STRING_TYPE_TYPE);

		integerTypeInstanceEClass = createEClass(INTEGER_TYPE_INSTANCE);
		createEAttribute(integerTypeInstanceEClass, INTEGER_TYPE_INSTANCE__VALUE);
		createEReference(integerTypeInstanceEClass, INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE);

		doubleTypeInstanceEClass = createEClass(DOUBLE_TYPE_INSTANCE);
		createEAttribute(doubleTypeInstanceEClass, DOUBLE_TYPE_INSTANCE__VALUE);
		createEReference(doubleTypeInstanceEClass, DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE);

		booleanTypeInstanceEClass = createEClass(BOOLEAN_TYPE_INSTANCE);
		createEAttribute(booleanTypeInstanceEClass, BOOLEAN_TYPE_INSTANCE__VALUE);
		createEReference(booleanTypeInstanceEClass, BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE);

		transitionInstanceEClass = createEClass(TRANSITION_INSTANCE);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__TRANSITION_TYPE);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE);
		createEReference(transitionInstanceEClass, TRANSITION_INSTANCE__TARGET_PORT_INSTANCE);

		dataPortInstanceEClass = createEClass(DATA_PORT_INSTANCE);
		createEReference(dataPortInstanceEClass, DATA_PORT_INSTANCE__DATA_INSTANCE);

		controlPortInstanceEClass = createEClass(CONTROL_PORT_INSTANCE);

		startPortInstanceEClass = createEClass(START_PORT_INSTANCE);

		endPortInstanceEClass = createEClass(END_PORT_INSTANCE);

		startControlPortInstanceEClass = createEClass(START_CONTROL_PORT_INSTANCE);

		startDataPortInstanceEClass = createEClass(START_DATA_PORT_INSTANCE);

		endControlPortInstanceEClass = createEClass(END_CONTROL_PORT_INSTANCE);

		endDataPortInstanceEClass = createEClass(END_DATA_PORT_INSTANCE);

		dataTypeInstanceEClass = createEClass(DATA_TYPE_INSTANCE);
		createEReference(dataTypeInstanceEClass, DATA_TYPE_INSTANCE__DATA_TYPE_TYPE);
		createEReference(dataTypeInstanceEClass, DATA_TYPE_INSTANCE__BELONGS_TO);
		createEAttribute(dataTypeInstanceEClass, DATA_TYPE_INSTANCE__ID_OF_ORIGIN);
		createEAttribute(dataTypeInstanceEClass, DATA_TYPE_INSTANCE__TYPE_ID);

		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__DELAY);
		createEAttribute(configurationEClass, CONFIGURATION__PERMISSION);
		createEAttribute(configurationEClass, CONFIGURATION__DECOUPLE_NEXT_STEPS);

		mappingUtilEClass = createEClass(MAPPING_UTIL);

		ifInstanceEClass = createEClass(IF_INSTANCE);
		createEReference(ifInstanceEClass, IF_INSTANCE__IF_CONDITION_INSTANCE);

		conditionInstanceEClass = createEClass(CONDITION_INSTANCE);
		createEAttribute(conditionInstanceEClass, CONDITION_INSTANCE__EXPRESSION_INSTANCE);
		createEAttribute(conditionInstanceEClass, CONDITION_INSTANCE__RESULT);
		createEReference(conditionInstanceEClass, CONDITION_INSTANCE__IF_CONDITION_TYPE);
		createEReference(conditionInstanceEClass, CONDITION_INSTANCE__LEFT_SIDE);
		createEReference(conditionInstanceEClass, CONDITION_INSTANCE__RIGHT_SIDE);

		trueTransitionInstanceEClass = createEClass(TRUE_TRANSITION_INSTANCE);

		falseTransitionInstanceEClass = createEClass(FALSE_TRANSITION_INSTANCE);

		complexTypeInstanceEClass = createEClass(COMPLEX_TYPE_INSTANCE);
		createEReference(complexTypeInstanceEClass, COMPLEX_TYPE_INSTANCE__SUBTYPES);

		listTypeInstanceEClass = createEClass(LIST_TYPE_INSTANCE);

		collectionTypeInstanceEClass = createEClass(COLLECTION_TYPE_INSTANCE);
		createEReference(collectionTypeInstanceEClass, COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE);

		setTypeInstanceEClass = createEClass(SET_TYPE_INSTANCE);

		nameableEClass = createEClass(NAMEABLE);
		createEAttribute(nameableEClass, NAMEABLE__NAME);

		escalationPortInstanceEClass = createEClass(ESCALATION_PORT_INSTANCE);
		createEAttribute(escalationPortInstanceEClass, ESCALATION_PORT_INSTANCE__ESCALATION_REASON);

		loopInstanceEClass = createEClass(LOOP_INSTANCE);
		createEReference(loopInstanceEClass, LOOP_INSTANCE__LOOP_CONDITION_INSTANCE);
		createEReference(loopInstanceEClass, LOOP_INSTANCE__PORTS_COPY_TO_STARTPORT);

		forLoopInstanceEClass = createEClass(FOR_LOOP_INSTANCE);
		createEReference(forLoopInstanceEClass, FOR_LOOP_INSTANCE__LOOP_STEP_WIDTH);

		andInstanceEClass = createEClass(AND_INSTANCE);

		orInstanceEClass = createEClass(OR_INSTANCE);

		rosInvokeInstanceEClass = createEClass(ROS_INVOKE_INSTANCE);

		processSlotInstanceEClass = createEClass(PROCESS_SLOT_INSTANCE);

		dataDuplicationStepInstanceEClass = createEClass(DATA_DUPLICATION_STEP_INSTANCE);

		restInvokeInstanceEClass = createEClass(REST_INVOKE_INSTANCE);

		osGiInvokeInstanceEClass = createEClass(OS_GI_INVOKE_INSTANCE);

		soapInvokeInstanceEClass = createEClass(SOAP_INVOKE_INSTANCE);

		humanTaskInstanceEClass = createEClass(HUMAN_TASK_INSTANCE);

		loadClassStepInstanceEClass = createEClass(LOAD_CLASS_STEP_INSTANCE);

		seMiWaInvokeInstanceEClass = createEClass(SE_MI_WA_INVOKE_INSTANCE);

		triggeredEventInstanceEClass = createEClass(TRIGGERED_EVENT_INSTANCE);

		xmlrpcInvokeInstanceEClass = createEClass(XMLRPC_INVOKE_INSTANCE);

		seMiWaRequestInstanceEClass = createEClass(SE_MI_WA_REQUEST_INSTANCE);

		dataMappingStepInstanceEClass = createEClass(DATA_MAPPING_STEP_INSTANCE);

		whileLoopInstanceEClass = createEClass(WHILE_LOOP_INSTANCE);

		endDataPortToStartDataPortMapInstanceEClass = createEClass(END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE);
		createEReference(endDataPortToStartDataPortMapInstanceEClass, END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE);
		createEReference(endDataPortToStartDataPortMapInstanceEClass, END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY);

		openHabSemanticInvokeInstanceEClass = createEClass(OPEN_HAB_SEMANTIC_INVOKE_INSTANCE);

		openHabSemanticSelectInvokeInstanceEClass = createEClass(OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE);

		openHabSemanticAskInvokeInstanceEClass = createEClass(OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE);

		openHabSemanticCommandInvokeInstanceEClass = createEClass(OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE);

		mapeKInstanceEClass = createEClass(MAPE_KINSTANCE);

		goalInvokeInstanceEClass = createEClass(GOAL_INVOKE_INSTANCE);

		// Create enums
		stateEEnum = createEEnum(STATE);
		executionPermissionEEnum = createEEnum(EXECUTION_PERMISSION);
		cpsStateEEnum = createEEnum(CPS_STATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		SofiaPackage theSofiaPackage = (SofiaPackage)EPackage.Registry.INSTANCE.getEPackage(SofiaPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		processInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		processStepInstanceEClass.getESuperTypes().add(this.getStateful());
		processStepInstanceEClass.getESuperTypes().add(this.getInstanceIdentifiable());
		portInstanceEClass.getESuperTypes().add(this.getStateful());
		portInstanceEClass.getESuperTypes().add(this.getInstanceIdentifiable());
		portInstanceEClass.getESuperTypes().add(this.getNameable());
		eventInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		stringTypeInstanceEClass.getESuperTypes().add(this.getDataTypeInstance());
		integerTypeInstanceEClass.getESuperTypes().add(this.getDataTypeInstance());
		doubleTypeInstanceEClass.getESuperTypes().add(this.getDataTypeInstance());
		booleanTypeInstanceEClass.getESuperTypes().add(this.getDataTypeInstance());
		transitionInstanceEClass.getESuperTypes().add(this.getInstanceIdentifiable());
		dataPortInstanceEClass.getESuperTypes().add(this.getPortInstance());
		controlPortInstanceEClass.getESuperTypes().add(this.getPortInstance());
		startControlPortInstanceEClass.getESuperTypes().add(this.getControlPortInstance());
		startControlPortInstanceEClass.getESuperTypes().add(this.getStartPortInstance());
		startDataPortInstanceEClass.getESuperTypes().add(this.getDataPortInstance());
		startDataPortInstanceEClass.getESuperTypes().add(this.getStartPortInstance());
		endControlPortInstanceEClass.getESuperTypes().add(this.getControlPortInstance());
		endControlPortInstanceEClass.getESuperTypes().add(this.getEndPortInstance());
		endDataPortInstanceEClass.getESuperTypes().add(this.getDataPortInstance());
		endDataPortInstanceEClass.getESuperTypes().add(this.getEndPortInstance());
		dataTypeInstanceEClass.getESuperTypes().add(this.getInstanceIdentifiable());
		dataTypeInstanceEClass.getESuperTypes().add(this.getNameable());
		configurationEClass.getESuperTypes().add(this.getInstanceIdentifiable());
		ifInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		trueTransitionInstanceEClass.getESuperTypes().add(this.getTransitionInstance());
		falseTransitionInstanceEClass.getESuperTypes().add(this.getTransitionInstance());
		complexTypeInstanceEClass.getESuperTypes().add(this.getDataTypeInstance());
		listTypeInstanceEClass.getESuperTypes().add(this.getCollectionTypeInstance());
		collectionTypeInstanceEClass.getESuperTypes().add(this.getComplexTypeInstance());
		setTypeInstanceEClass.getESuperTypes().add(this.getCollectionTypeInstance());
		escalationPortInstanceEClass.getESuperTypes().add(this.getEndControlPortInstance());
		loopInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		forLoopInstanceEClass.getESuperTypes().add(this.getLoopInstance());
		andInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		orInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		rosInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		processSlotInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		dataDuplicationStepInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		restInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		osGiInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		soapInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		humanTaskInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		loadClassStepInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		seMiWaInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		triggeredEventInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		xmlrpcInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		seMiWaRequestInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		dataMappingStepInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		whileLoopInstanceEClass.getESuperTypes().add(this.getLoopInstance());
		openHabSemanticInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		openHabSemanticSelectInvokeInstanceEClass.getESuperTypes().add(this.getOpenHabSemanticInvokeInstance());
		openHabSemanticAskInvokeInstanceEClass.getESuperTypes().add(this.getOpenHabSemanticInvokeInstance());
		openHabSemanticCommandInvokeInstanceEClass.getESuperTypes().add(this.getOpenHabSemanticInvokeInstance());
		mapeKInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());
		goalInvokeInstanceEClass.getESuperTypes().add(this.getProcessStepInstance());

		// Initialize classes and features; add operations and parameters
		initEClass(processInstanceEClass, ProcessInstance.class, "ProcessInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProcessInstance_RunningForInstanceId(), ecorePackage.getEString(), "runningForInstanceId", null, 0, 1, ProcessInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(processInstanceEClass, ecorePackage.getEBoolean(), "start", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(this.getDataTypeInstance());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(processStepInstanceEClass, ProcessStepInstance.class, "ProcessStepInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessStepInstance_ProcessStepType(), theSofiaPackage.getProcessStep(), null, "processStepType", null, 1, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_Permission(), this.getExecutionPermission(), "permission", null, 1, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_Delay(), ecorePackage.getELong(), "delay", null, 0, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessStepInstance_Ports(), this.getPortInstance(), this.getPortInstance_ProcessStepInstance(), "ports", null, 1, -1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessStepInstance_SubSteps(), this.getProcessStepInstance(), null, "subSteps", null, 0, -1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_ProcessInstanceID(), ecorePackage.getEString(), "processInstanceID", null, 0, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_ProcessModelID(), ecorePackage.getEString(), "processModelID", null, 0, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_ModelID(), ecorePackage.getEString(), "modelID", null, 1, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStepInstance_CyberPhysical(), ecorePackage.getEBoolean(), "cyberPhysical", null, 0, 1, ProcessStepInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(processStepInstanceEClass, ecorePackage.getEBoolean(), "execute", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "stop", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "pause", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "kill", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(processStepInstanceEClass, null, "deploy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingUtil(), "mapper", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(processStepInstanceEClass, ecorePackage.getEString(), "configure", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getConfiguration(), "Configuration", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "escalate", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "resume", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(processStepInstanceEClass, null, "deactivate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(statefulEClass, Stateful.class, "Stateful", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStateful_ExecutionState(), this.getState(), "executionState", null, 1, 1, Stateful.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStateful_CpsExecutionState(), this.getCpsState(), "cpsExecutionState", null, 0, 1, Stateful.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portInstanceEClass, PortInstance.class, "PortInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortInstance_PortType(), theSofiaPackage.getPort(), null, "portType", null, 1, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortInstance_ProcessStepInstance(), this.getProcessStepInstance(), this.getProcessStepInstance_Ports(), "processStepInstance", null, 0, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortInstance_OutTransitionInstances(), this.getTransitionInstance(), this.getTransitionInstance_SourcePortInstance(), "outTransitionInstances", null, 0, -1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortInstance_Decoupled(), ecorePackage.getEBoolean(), "decoupled", "false", 1, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPortInstance_InTransitionInstances(), this.getTransitionInstance(), this.getTransitionInstance_TargetPortInstance(), "inTransitionInstances", null, 0, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPortInstance_TypeId(), ecorePackage.getEString(), "typeId", null, 1, 1, PortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(portInstanceEClass, null, "deploy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingUtil(), "mapper", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(portInstanceEClass, ecorePackage.getEBoolean(), "activate", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataTypeInstance(), "parameter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(portInstanceEClass, null, "deactivate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(instanceIdentifiableEClass, InstanceIdentifiable.class, "InstanceIdentifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstanceIdentifiable_InstanceId(), ecorePackage.getEString(), "instanceId", null, 1, 1, InstanceIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstanceIdentifiable_Instancenumber(), ecorePackage.getEInt(), "instancenumber", null, 1, 1, InstanceIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eventInstanceEClass, EventInstance.class, "EventInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEventInstance_TimeStamp(), ecorePackage.getEDate(), "timeStamp", null, 1, 1, EventInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringTypeInstanceEClass, StringTypeInstance.class, "StringTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringTypeInstance_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStringTypeInstance_StringTypeType(), theSofiaPackage.getStringType(), null, "stringTypeType", null, 1, 1, StringTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerTypeInstanceEClass, IntegerTypeInstance.class, "IntegerTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerTypeInstance_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntegerTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIntegerTypeInstance_IntegerTypeType(), theSofiaPackage.getIntegerType(), null, "integerTypeType", null, 1, 1, IntegerTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleTypeInstanceEClass, DoubleTypeInstance.class, "DoubleTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleTypeInstance_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDoubleTypeInstance_DoubleTypeType(), theSofiaPackage.getDoubleType(), null, "doubleTypeType", null, 1, 1, DoubleTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanTypeInstanceEClass, BooleanTypeInstance.class, "BooleanTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanTypeInstance_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBooleanTypeInstance_BooleanTypeType(), theSofiaPackage.getBooleanType(), null, "booleanTypeType", null, 1, 1, BooleanTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transitionInstanceEClass, TransitionInstance.class, "TransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransitionInstance_TransitionType(), theSofiaPackage.getTransition(), null, "transitionType", null, 1, 1, TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionInstance_SourcePortInstance(), this.getPortInstance(), this.getPortInstance_OutTransitionInstances(), "sourcePortInstance", null, 1, 1, TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransitionInstance_TargetPortInstance(), this.getPortInstance(), this.getPortInstance_InTransitionInstances(), "targetPortInstance", null, 1, 1, TransitionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(transitionInstanceEClass, null, "deploy", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMappingUtil(), "mapper", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(transitionInstanceEClass, ecorePackage.getEBoolean(), "execute", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getDataTypeInstance(), "parameter", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(transitionInstanceEClass, null, "deactivate", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dataPortInstanceEClass, DataPortInstance.class, "DataPortInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataPortInstance_DataInstance(), this.getDataTypeInstance(), null, "dataInstance", null, 1, 1, DataPortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlPortInstanceEClass, ControlPortInstance.class, "ControlPortInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startPortInstanceEClass, StartPortInstance.class, "StartPortInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(startPortInstanceEClass, null, "executeSubSteps", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(startPortInstanceEClass, null, "deactivateSubSteps", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(endPortInstanceEClass, EndPortInstance.class, "EndPortInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startControlPortInstanceEClass, StartControlPortInstance.class, "StartControlPortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startDataPortInstanceEClass, StartDataPortInstance.class, "StartDataPortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endControlPortInstanceEClass, EndControlPortInstance.class, "EndControlPortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endDataPortInstanceEClass, EndDataPortInstance.class, "EndDataPortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeInstanceEClass, DataTypeInstance.class, "DataTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeInstance_DataTypeType(), theSofiaPackage.getDataType(), null, "dataTypeType", null, 1, 1, DataTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataTypeInstance_BelongsTo(), this.getComplexTypeInstance(), this.getComplexTypeInstance_Subtypes(), "belongsTo", null, 0, 1, DataTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeInstance_IdOfOrigin(), ecorePackage.getEString(), "idOfOrigin", null, 0, 1, DataTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataTypeInstance_TypeId(), ecorePackage.getEString(), "typeId", null, 1, 1, DataTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(dataTypeInstanceEClass, null, "parse", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "text", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeInstanceEClass, ecorePackage.getEInt(), "compareTo", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEObject(), "o", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeInstanceEClass, ecorePackage.getEString(), "serializeToXML", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeInstanceEClass, ecorePackage.getEBoolean(), "deserializeFromXML", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "xmlInstance", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeInstanceEClass, this.getDataTypeInstance(), "copy", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeInstanceEClass, ecorePackage.getEString(), "serializeToJSON", 1, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeInstanceEClass, ecorePackage.getEBoolean(), "deserializeFromJSON", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "jsonString", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(dataTypeInstanceEClass, null, "setValueFromString", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(dataTypeInstanceEClass, ecorePackage.getEJavaObject(), "getValueAsObject", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_Delay(), ecorePackage.getELong(), "delay", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Permission(), this.getExecutionPermission(), "permission", null, 0, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_DecoupleNextSteps(), ecorePackage.getEBoolean(), "decoupleNextSteps", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingUtilEClass, MappingUtil.class, "MappingUtil", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(mappingUtilEClass, this.getPortInstance(), "mapPort", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSofiaPackage.getPort(), "port", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappingUtilEClass, this.getProcessStepInstance(), "mapProcessStep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSofiaPackage.getProcessStep(), "processStep", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappingUtilEClass, this.getTransitionInstance(), "mapTransition", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSofiaPackage.getTransition(), "transition", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappingUtilEClass, null, "addProcessStepInstance", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getProcessStepInstance(), "instance", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappingUtilEClass, this.getDataTypeInstance(), "mapDataType", 1, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSofiaPackage.getDataType(), "dataType", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(ifInstanceEClass, IfInstance.class, "IfInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIfInstance_IfConditionInstance(), this.getConditionInstance(), null, "ifConditionInstance", null, 1, 1, IfInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionInstanceEClass, ConditionInstance.class, "ConditionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConditionInstance_ExpressionInstance(), ecorePackage.getEString(), "expressionInstance", null, 1, 1, ConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConditionInstance_Result(), ecorePackage.getEBoolean(), "result", null, 1, 1, ConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionInstance_IfConditionType(), theSofiaPackage.getCondition(), null, "ifConditionType", null, 1, 1, ConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionInstance_LeftSide(), this.getStartDataPortInstance(), null, "leftSide", null, 0, 1, ConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConditionInstance_RightSide(), this.getStartDataPortInstance(), null, "rightSide", null, 0, 1, ConditionInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(conditionInstanceEClass, ecorePackage.getEBoolean(), "evaluate", 1, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(trueTransitionInstanceEClass, TrueTransitionInstance.class, "TrueTransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseTransitionInstanceEClass, FalseTransitionInstance.class, "FalseTransitionInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(complexTypeInstanceEClass, ComplexTypeInstance.class, "ComplexTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexTypeInstance_Subtypes(), this.getDataTypeInstance(), this.getDataTypeInstance_BelongsTo(), "subtypes", null, 1, -1, ComplexTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listTypeInstanceEClass, ListTypeInstance.class, "ListTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTypeInstanceEClass, CollectionTypeInstance.class, "CollectionTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTypeInstance_CollectionItemType(), theSofiaPackage.getDataType(), null, "collectionItemType", null, 1, 1, CollectionTypeInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setTypeInstanceEClass, SetTypeInstance.class, "SetTypeInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Nameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(escalationPortInstanceEClass, EscalationPortInstance.class, "EscalationPortInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEscalationPortInstance_EscalationReason(), ecorePackage.getEString(), "escalationReason", null, 1, 1, EscalationPortInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopInstanceEClass, LoopInstance.class, "LoopInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoopInstance_LoopConditionInstance(), this.getConditionInstance(), null, "loopConditionInstance", null, 1, 1, LoopInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopInstance_PortsCopyToStartport(), this.getEndDataPortToStartDataPortMapInstance(), null, "portsCopyToStartport", null, 0, -1, LoopInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forLoopInstanceEClass, ForLoopInstance.class, "ForLoopInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForLoopInstance_LoopStepWidth(), this.getStartDataPortInstance(), null, "loopStepWidth", null, 0, 1, ForLoopInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andInstanceEClass, AndInstance.class, "AndInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(orInstanceEClass, OrInstance.class, "OrInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rosInvokeInstanceEClass, ROSInvokeInstance.class, "ROSInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processSlotInstanceEClass, ProcessSlotInstance.class, "ProcessSlotInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataDuplicationStepInstanceEClass, DataDuplicationStepInstance.class, "DataDuplicationStepInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(restInvokeInstanceEClass, RESTInvokeInstance.class, "RESTInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(osGiInvokeInstanceEClass, OSGiInvokeInstance.class, "OSGiInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(soapInvokeInstanceEClass, SOAPInvokeInstance.class, "SOAPInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(humanTaskInstanceEClass, HumanTaskInstance.class, "HumanTaskInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loadClassStepInstanceEClass, LoadClassStepInstance.class, "LoadClassStepInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(seMiWaInvokeInstanceEClass, SeMiWaInvokeInstance.class, "SeMiWaInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(triggeredEventInstanceEClass, TriggeredEventInstance.class, "TriggeredEventInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmlrpcInvokeInstanceEClass, XMLRPCInvokeInstance.class, "XMLRPCInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(seMiWaRequestInstanceEClass, SeMiWaRequestInstance.class, "SeMiWaRequestInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataMappingStepInstanceEClass, DataMappingStepInstance.class, "DataMappingStepInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileLoopInstanceEClass, WhileLoopInstance.class, "WhileLoopInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endDataPortToStartDataPortMapInstanceEClass, Map.Entry.class, "EndDataPortToStartDataPortMapInstance", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndDataPortToStartDataPortMapInstance_Value(), this.getStartDataPortInstance(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndDataPortToStartDataPortMapInstance_Key(), this.getEndDataPortInstance(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openHabSemanticInvokeInstanceEClass, OpenHabSemanticInvokeInstance.class, "OpenHabSemanticInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openHabSemanticSelectInvokeInstanceEClass, OpenHabSemanticSelectInvokeInstance.class, "OpenHabSemanticSelectInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openHabSemanticAskInvokeInstanceEClass, OpenHabSemanticAskInvokeInstance.class, "OpenHabSemanticAskInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openHabSemanticCommandInvokeInstanceEClass, OpenHabSemanticCommandInvokeInstance.class, "OpenHabSemanticCommandInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mapeKInstanceEClass, MapeKInstance.class, "MapeKInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalInvokeInstanceEClass, GoalInvokeInstance.class, "GoalInvokeInstance", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(stateEEnum, State.class, "State");
		addEEnumLiteral(stateEEnum, State.ACTIVE);
		addEEnumLiteral(stateEEnum, State.INACTIVE);
		addEEnumLiteral(stateEEnum, State.EXECUTING);
		addEEnumLiteral(stateEEnum, State.EXECUTED);
		addEEnumLiteral(stateEEnum, State.PAUSED);
		addEEnumLiteral(stateEEnum, State.STOPPED);
		addEEnumLiteral(stateEEnum, State.FAILED);
		addEEnumLiteral(stateEEnum, State.KILLED);
		addEEnumLiteral(stateEEnum, State.WAITING);
		addEEnumLiteral(stateEEnum, State.UNDEPLOYED);
		addEEnumLiteral(stateEEnum, State.ESCALATED);
		addEEnumLiteral(stateEEnum, State.DEACTIVATED);

		initEEnum(executionPermissionEEnum, ExecutionPermission.class, "ExecutionPermission");
		addEEnumLiteral(executionPermissionEEnum, ExecutionPermission.DELAYED);
		addEEnumLiteral(executionPermissionEEnum, ExecutionPermission.DENIED);
		addEEnumLiteral(executionPermissionEEnum, ExecutionPermission.GRANTED);
		addEEnumLiteral(executionPermissionEEnum, ExecutionPermission.SYNCHRONIZED);

		initEEnum(cpsStateEEnum, CpsState.class, "CpsState");
		addEEnumLiteral(cpsStateEEnum, CpsState.FINISHED);
		addEEnumLiteral(cpsStateEEnum, CpsState.SATISFIED);

		// Create resource
		createResource(eNS_URI);
	}

} //SofiaInstancePackageImpl
