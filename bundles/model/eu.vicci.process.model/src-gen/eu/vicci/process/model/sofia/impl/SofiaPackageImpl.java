/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.AtomicStep;
import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.ControlPort;
import eu.vicci.process.model.sofia.CpsStep;
import eu.vicci.process.model.sofia.DataDuplicationStep;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataMappingStep;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.EndControlPort;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.EndPort;
import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.Event;
import eu.vicci.process.model.sofia.FalseTransition;
import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofia.HTTPverb;
import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.Invoke;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.LoadClassStep;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.MapeK;
import eu.vicci.process.model.sofia.Nameable;
import eu.vicci.process.model.sofia.NumericType;
import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessSlot;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.PublishMessage;
import eu.vicci.process.model.sofia.PublishROSMessage;
import eu.vicci.process.model.sofia.RESTInvoke;
import eu.vicci.process.model.sofia.ROSInvoke;
import eu.vicci.process.model.sofia.RepeatLoop;
import eu.vicci.process.model.sofia.SOAPInvoke;
import eu.vicci.process.model.sofia.SeMiWaInvoke;
import eu.vicci.process.model.sofia.SeMiWaRequest;
import eu.vicci.process.model.sofia.SemanticTargetType;
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.SimpleType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.StartControlPort;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StartPort;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofia.TriggeredEvent;
import eu.vicci.process.model.sofia.TrueTransition;
import eu.vicci.process.model.sofia.WhileLoop;
import eu.vicci.process.model.sofia.XMLRPCInvoke;

import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SofiaPackageImpl extends EPackageImpl implements SofiaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ifEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass invokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass complexTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass conditionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numericTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repeatLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processSlotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMappingStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startControlPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endControlPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startDataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endDataPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiableEClass = null;

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
	private EClass triggeredEventEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trueTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falseTransitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass soapInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmlrpcInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadClassStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seMiWaInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass restInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass osGiInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seMiWaRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataDuplicationStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rosInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass publishROSMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass humanTaskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass escalationPortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass endDataPortToStartDataPortMapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticSelectInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticAskInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openHabSemanticCommandInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpsStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapeKEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass goalInvokeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum comparatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum httPverbEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum semanticTargetTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum humanTaskTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum humanTaskUseCaseEEnum = null;

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
	 * @see eu.vicci.process.model.sofia.SofiaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SofiaPackageImpl() {
		super(eNS_URI, SofiaFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SofiaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SofiaPackage init() {
		if (isInited) return (SofiaPackage)EPackage.Registry.INSTANCE.getEPackage(SofiaPackage.eNS_URI);

		// Obtain or create and register package
		SofiaPackageImpl theSofiaPackage = (SofiaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SofiaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SofiaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theSofiaPackage.createPackageContents();

		// Initialize created meta-data
		theSofiaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSofiaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SofiaPackage.eNS_URI, theSofiaPackage);
		return theSofiaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransition() {
		return transitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_SourcePort() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransition_TargetPort() {
		return (EReference)transitionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIf() {
		return ifEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIf_IfCondition() {
		return (EReference)ifEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOr() {
		return orEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInvoke() {
		return invokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvent() {
		return eventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcess() {
		return processEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcess_DataTypeDefinitions() {
		return (EReference)processEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_ExecutionPeer() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_Distributed() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcess_RemoteExecuting() {
		return (EAttribute)processEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_OutTransitions() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Optional() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_ProcessStep() {
		return (EReference)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_InTransitions() {
		return (EReference)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPort_Description() {
		return (EAttribute)portEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataPort() {
		return dataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataPort_Value() {
		return (EAttribute)dataPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_PortDatatype() {
		return (EReference)dataPortEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataPort_Mappings() {
		return (EReference)dataPortEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlPort() {
		return controlPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessStep() {
		return processStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessStep_Parentstep() {
		return (EReference)processStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessStep_Ports() {
		return (EReference)processStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStep_Type() {
		return (EAttribute)processStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStep_Description() {
		return (EAttribute)processStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProcessStep_Resource() {
		return (EAttribute)processStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComplexType() {
		return complexTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexType_Subtypes() {
		return (EReference)complexTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComplexType_Subreferences() {
		return (EReference)complexTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCondition() {
		return conditionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCondition_Comparator() {
		return (EAttribute)conditionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_LeftSide() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCondition_RightSide() {
		return (EReference)conditionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicStep() {
		return atomicStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeStep() {
		return compositeStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeStep_SubSteps() {
		return (EReference)compositeStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_BelongsTo() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_Mappings() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataType_PortMembers() {
		return (EReference)dataTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleType() {
		return simpleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumericType() {
		return numericTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerType() {
		return integerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerType_Min() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerType_Max() {
		return (EAttribute)integerTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleType() {
		return doubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoop() {
		return loopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_LoopCondition() {
		return (EReference)loopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoop_PortsCopyToStartsport() {
		return (EReference)loopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRepeatLoop() {
		return repeatLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWhileLoop() {
		return whileLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForLoop() {
		return forLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForLoop_LoopStepWidth() {
		return (EReference)forLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessSlot() {
		return processSlotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMappingStep() {
		return dataMappingStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMappingStep_Mappings() {
		return (EReference)dataMappingStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartControlPort() {
		return startControlPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndControlPort() {
		return endControlPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartDataPort() {
		return startDataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndDataPort() {
		return endDataPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartPort() {
		return startPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndPort() {
		return endPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiable() {
		return identifiableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifiable_Id() {
		return (EAttribute)identifiableEClass.getEStructuralFeatures().get(0);
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
	public EClass getTriggeredEvent() {
		return triggeredEventEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTriggeredEvent_EPLStatement() {
		return (EAttribute)triggeredEventEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrueTransition() {
		return trueTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFalseTransition() {
		return falseTransitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSOAPInvoke() {
		return soapInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSOAPInvoke_ServerUri() {
		return (EAttribute)soapInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSOAPInvoke_MethodName() {
		return (EAttribute)soapInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSOAPInvoke_WsdlUri() {
		return (EAttribute)soapInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSOAPInvoke_ConfigFile() {
		return (EAttribute)soapInvokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMLRPCInvoke() {
		return xmlrpcInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMLRPCInvoke_ServerUri() {
		return (EAttribute)xmlrpcInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMLRPCInvoke_MethodName() {
		return (EAttribute)xmlrpcInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMLRPCInvoke_StartParameterSequence() {
		return (EAttribute)xmlrpcInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getXMLRPCInvoke_EndParameterSequence() {
		return (EAttribute)xmlrpcInvokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoadClassStep() {
		return loadClassStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoadClassStep_DelegateClassName() {
		return (EAttribute)loadClassStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeMiWaInvoke() {
		return seMiWaInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeMiWaInvoke_ServiceName() {
		return (EAttribute)seMiWaInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeMiWaInvoke_NodeId() {
		return (EAttribute)seMiWaInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRESTInvoke() {
		return restInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRESTInvoke_HTTPMethod() {
		return (EAttribute)restInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRESTInvoke_ServerUri() {
		return (EAttribute)restInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOSGiInvoke() {
		return osGiInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOSGiInvoke_ServiceClassName() {
		return (EAttribute)osGiInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOSGiInvoke_MethodName() {
		return (EAttribute)osGiInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOSGiInvoke_ParameterTypes() {
		return (EAttribute)osGiInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOSGiInvoke_BundleName() {
		return (EAttribute)osGiInvokeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSeMiWaRequest() {
		return seMiWaRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSeMiWaRequest_SSILStatement() {
		return (EAttribute)seMiWaRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataMapping() {
		return dataMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapping_Source() {
		return (EReference)dataMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataMapping_Target() {
		return (EReference)dataMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataDuplicationStep() {
		return dataDuplicationStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getROSInvoke() {
		return rosInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getROSInvoke_ServerUri() {
		return (EAttribute)rosInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getROSInvoke_ServiceName() {
		return (EAttribute)rosInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnd() {
		return andEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionType() {
		return collectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionType_CollectionItemType() {
		return (EReference)collectionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetType() {
		return setTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishMessage() {
		return publishMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishMessage_ServerUri() {
		return (EAttribute)publishMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPublishMessage_Topic() {
		return (EAttribute)publishMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPublishROSMessage() {
		return publishROSMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHumanTask() {
		return humanTaskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHumanTask_HumanTaskType() {
		return (EAttribute)humanTaskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHumanTask_HumanTaskUseCase() {
		return (EAttribute)humanTaskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEscalationPort() {
		return escalationPortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEscalationPort_EscalationTime() {
		return (EAttribute)escalationPortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEndDataPortToStartDataPortMap() {
		return endDataPortToStartDataPortMapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndDataPortToStartDataPortMap_Key() {
		return (EReference)endDataPortToStartDataPortMapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEndDataPortToStartDataPortMap_Value() {
		return (EReference)endDataPortToStartDataPortMapEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticInvoke() {
		return openHabSemanticInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenHabSemanticInvoke_Query() {
		return (EAttribute)openHabSemanticInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenHabSemanticInvoke_ServerBaseAddress() {
		return (EAttribute)openHabSemanticInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenHabSemanticInvoke_WithLatest() {
		return (EAttribute)openHabSemanticInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticSelectInvoke() {
		return openHabSemanticSelectInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticAskInvoke() {
		return openHabSemanticAskInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOpenHabSemanticCommandInvoke() {
		return openHabSemanticCommandInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOpenHabSemanticCommandInvoke_Command() {
		return (EAttribute)openHabSemanticCommandInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCpsStep() {
		return cpsStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpsStep_CyberPhysical() {
		return (EAttribute)cpsStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpsStep_Goal() {
		return (EAttribute)cpsStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpsStep_EplQuery() {
		return (EAttribute)cpsStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpsStep_ControlProcessId() {
		return (EAttribute)cpsStepEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCpsStep_ControlProcess() {
		return (EReference)cpsStepEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCpsStep_Context() {
		return (EAttribute)cpsStepEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMapeK() {
		return mapeKEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGoalInvoke() {
		return goalInvokeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoalInvoke_InvokeGoal() {
		return (EAttribute)goalInvokeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoalInvoke_Qualities() {
		return (EAttribute)goalInvokeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getGoalInvoke_Location() {
		return (EAttribute)goalInvokeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getComparator() {
		return comparatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHTTPverb() {
		return httPverbEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSemanticTargetType() {
		return semanticTargetTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHumanTaskType() {
		return humanTaskTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getHumanTaskUseCase() {
		return humanTaskUseCaseEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaFactory getSofiaFactory() {
		return (SofiaFactory)getEFactoryInstance();
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
		transitionEClass = createEClass(TRANSITION);
		createEReference(transitionEClass, TRANSITION__SOURCE_PORT);
		createEReference(transitionEClass, TRANSITION__TARGET_PORT);

		ifEClass = createEClass(IF);
		createEReference(ifEClass, IF__IF_CONDITION);

		orEClass = createEClass(OR);

		invokeEClass = createEClass(INVOKE);

		eventEClass = createEClass(EVENT);

		processEClass = createEClass(PROCESS);
		createEReference(processEClass, PROCESS__DATA_TYPE_DEFINITIONS);
		createEAttribute(processEClass, PROCESS__EXECUTION_PEER);
		createEAttribute(processEClass, PROCESS__DISTRIBUTED);
		createEAttribute(processEClass, PROCESS__REMOTE_EXECUTING);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__OUT_TRANSITIONS);
		createEAttribute(portEClass, PORT__OPTIONAL);
		createEReference(portEClass, PORT__PROCESS_STEP);
		createEReference(portEClass, PORT__IN_TRANSITIONS);
		createEAttribute(portEClass, PORT__DESCRIPTION);

		dataPortEClass = createEClass(DATA_PORT);
		createEAttribute(dataPortEClass, DATA_PORT__VALUE);
		createEReference(dataPortEClass, DATA_PORT__PORT_DATATYPE);
		createEReference(dataPortEClass, DATA_PORT__MAPPINGS);

		controlPortEClass = createEClass(CONTROL_PORT);

		processStepEClass = createEClass(PROCESS_STEP);
		createEReference(processStepEClass, PROCESS_STEP__PARENTSTEP);
		createEReference(processStepEClass, PROCESS_STEP__PORTS);
		createEAttribute(processStepEClass, PROCESS_STEP__TYPE);
		createEAttribute(processStepEClass, PROCESS_STEP__DESCRIPTION);
		createEAttribute(processStepEClass, PROCESS_STEP__RESOURCE);

		complexTypeEClass = createEClass(COMPLEX_TYPE);
		createEReference(complexTypeEClass, COMPLEX_TYPE__SUBTYPES);
		createEReference(complexTypeEClass, COMPLEX_TYPE__SUBREFERENCES);

		conditionEClass = createEClass(CONDITION);
		createEAttribute(conditionEClass, CONDITION__COMPARATOR);
		createEReference(conditionEClass, CONDITION__LEFT_SIDE);
		createEReference(conditionEClass, CONDITION__RIGHT_SIDE);

		atomicStepEClass = createEClass(ATOMIC_STEP);

		compositeStepEClass = createEClass(COMPOSITE_STEP);
		createEReference(compositeStepEClass, COMPOSITE_STEP__SUB_STEPS);

		dataTypeEClass = createEClass(DATA_TYPE);
		createEReference(dataTypeEClass, DATA_TYPE__BELONGS_TO);
		createEReference(dataTypeEClass, DATA_TYPE__MAPPINGS);
		createEReference(dataTypeEClass, DATA_TYPE__PORT_MEMBERS);

		simpleTypeEClass = createEClass(SIMPLE_TYPE);

		stringTypeEClass = createEClass(STRING_TYPE);

		numericTypeEClass = createEClass(NUMERIC_TYPE);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);

		integerTypeEClass = createEClass(INTEGER_TYPE);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__MIN);
		createEAttribute(integerTypeEClass, INTEGER_TYPE__MAX);

		doubleTypeEClass = createEClass(DOUBLE_TYPE);

		loopEClass = createEClass(LOOP);
		createEReference(loopEClass, LOOP__LOOP_CONDITION);
		createEReference(loopEClass, LOOP__PORTS_COPY_TO_STARTSPORT);

		repeatLoopEClass = createEClass(REPEAT_LOOP);

		whileLoopEClass = createEClass(WHILE_LOOP);

		forLoopEClass = createEClass(FOR_LOOP);
		createEReference(forLoopEClass, FOR_LOOP__LOOP_STEP_WIDTH);

		processSlotEClass = createEClass(PROCESS_SLOT);

		dataMappingStepEClass = createEClass(DATA_MAPPING_STEP);
		createEReference(dataMappingStepEClass, DATA_MAPPING_STEP__MAPPINGS);

		startControlPortEClass = createEClass(START_CONTROL_PORT);

		endControlPortEClass = createEClass(END_CONTROL_PORT);

		startDataPortEClass = createEClass(START_DATA_PORT);

		endDataPortEClass = createEClass(END_DATA_PORT);

		startPortEClass = createEClass(START_PORT);

		endPortEClass = createEClass(END_PORT);

		identifiableEClass = createEClass(IDENTIFIABLE);
		createEAttribute(identifiableEClass, IDENTIFIABLE__ID);

		nameableEClass = createEClass(NAMEABLE);
		createEAttribute(nameableEClass, NAMEABLE__NAME);

		triggeredEventEClass = createEClass(TRIGGERED_EVENT);
		createEAttribute(triggeredEventEClass, TRIGGERED_EVENT__EPL_STATEMENT);

		trueTransitionEClass = createEClass(TRUE_TRANSITION);

		falseTransitionEClass = createEClass(FALSE_TRANSITION);

		soapInvokeEClass = createEClass(SOAP_INVOKE);
		createEAttribute(soapInvokeEClass, SOAP_INVOKE__SERVER_URI);
		createEAttribute(soapInvokeEClass, SOAP_INVOKE__METHOD_NAME);
		createEAttribute(soapInvokeEClass, SOAP_INVOKE__WSDL_URI);
		createEAttribute(soapInvokeEClass, SOAP_INVOKE__CONFIG_FILE);

		xmlrpcInvokeEClass = createEClass(XMLRPC_INVOKE);
		createEAttribute(xmlrpcInvokeEClass, XMLRPC_INVOKE__SERVER_URI);
		createEAttribute(xmlrpcInvokeEClass, XMLRPC_INVOKE__METHOD_NAME);
		createEAttribute(xmlrpcInvokeEClass, XMLRPC_INVOKE__START_PARAMETER_SEQUENCE);
		createEAttribute(xmlrpcInvokeEClass, XMLRPC_INVOKE__END_PARAMETER_SEQUENCE);

		loadClassStepEClass = createEClass(LOAD_CLASS_STEP);
		createEAttribute(loadClassStepEClass, LOAD_CLASS_STEP__DELEGATE_CLASS_NAME);

		seMiWaInvokeEClass = createEClass(SE_MI_WA_INVOKE);
		createEAttribute(seMiWaInvokeEClass, SE_MI_WA_INVOKE__SERVICE_NAME);
		createEAttribute(seMiWaInvokeEClass, SE_MI_WA_INVOKE__NODE_ID);

		restInvokeEClass = createEClass(REST_INVOKE);
		createEAttribute(restInvokeEClass, REST_INVOKE__HTTP_METHOD);
		createEAttribute(restInvokeEClass, REST_INVOKE__SERVER_URI);

		osGiInvokeEClass = createEClass(OS_GI_INVOKE);
		createEAttribute(osGiInvokeEClass, OS_GI_INVOKE__SERVICE_CLASS_NAME);
		createEAttribute(osGiInvokeEClass, OS_GI_INVOKE__METHOD_NAME);
		createEAttribute(osGiInvokeEClass, OS_GI_INVOKE__PARAMETER_TYPES);
		createEAttribute(osGiInvokeEClass, OS_GI_INVOKE__BUNDLE_NAME);

		seMiWaRequestEClass = createEClass(SE_MI_WA_REQUEST);
		createEAttribute(seMiWaRequestEClass, SE_MI_WA_REQUEST__SSIL_STATEMENT);

		dataMappingEClass = createEClass(DATA_MAPPING);
		createEReference(dataMappingEClass, DATA_MAPPING__SOURCE);
		createEReference(dataMappingEClass, DATA_MAPPING__TARGET);

		dataDuplicationStepEClass = createEClass(DATA_DUPLICATION_STEP);

		rosInvokeEClass = createEClass(ROS_INVOKE);
		createEAttribute(rosInvokeEClass, ROS_INVOKE__SERVER_URI);
		createEAttribute(rosInvokeEClass, ROS_INVOKE__SERVICE_NAME);

		andEClass = createEClass(AND);

		collectionTypeEClass = createEClass(COLLECTION_TYPE);
		createEReference(collectionTypeEClass, COLLECTION_TYPE__COLLECTION_ITEM_TYPE);

		listTypeEClass = createEClass(LIST_TYPE);

		setTypeEClass = createEClass(SET_TYPE);

		publishMessageEClass = createEClass(PUBLISH_MESSAGE);
		createEAttribute(publishMessageEClass, PUBLISH_MESSAGE__SERVER_URI);
		createEAttribute(publishMessageEClass, PUBLISH_MESSAGE__TOPIC);

		publishROSMessageEClass = createEClass(PUBLISH_ROS_MESSAGE);

		humanTaskEClass = createEClass(HUMAN_TASK);
		createEAttribute(humanTaskEClass, HUMAN_TASK__HUMAN_TASK_TYPE);
		createEAttribute(humanTaskEClass, HUMAN_TASK__HUMAN_TASK_USE_CASE);

		escalationPortEClass = createEClass(ESCALATION_PORT);
		createEAttribute(escalationPortEClass, ESCALATION_PORT__ESCALATION_TIME);

		endDataPortToStartDataPortMapEClass = createEClass(END_DATA_PORT_TO_START_DATA_PORT_MAP);
		createEReference(endDataPortToStartDataPortMapEClass, END_DATA_PORT_TO_START_DATA_PORT_MAP__KEY);
		createEReference(endDataPortToStartDataPortMapEClass, END_DATA_PORT_TO_START_DATA_PORT_MAP__VALUE);

		openHabSemanticInvokeEClass = createEClass(OPEN_HAB_SEMANTIC_INVOKE);
		createEAttribute(openHabSemanticInvokeEClass, OPEN_HAB_SEMANTIC_INVOKE__QUERY);
		createEAttribute(openHabSemanticInvokeEClass, OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS);
		createEAttribute(openHabSemanticInvokeEClass, OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST);

		openHabSemanticSelectInvokeEClass = createEClass(OPEN_HAB_SEMANTIC_SELECT_INVOKE);

		openHabSemanticAskInvokeEClass = createEClass(OPEN_HAB_SEMANTIC_ASK_INVOKE);

		openHabSemanticCommandInvokeEClass = createEClass(OPEN_HAB_SEMANTIC_COMMAND_INVOKE);
		createEAttribute(openHabSemanticCommandInvokeEClass, OPEN_HAB_SEMANTIC_COMMAND_INVOKE__COMMAND);

		cpsStepEClass = createEClass(CPS_STEP);
		createEAttribute(cpsStepEClass, CPS_STEP__CYBER_PHYSICAL);
		createEAttribute(cpsStepEClass, CPS_STEP__GOAL);
		createEAttribute(cpsStepEClass, CPS_STEP__EPL_QUERY);
		createEAttribute(cpsStepEClass, CPS_STEP__CONTROL_PROCESS_ID);
		createEReference(cpsStepEClass, CPS_STEP__CONTROL_PROCESS);
		createEAttribute(cpsStepEClass, CPS_STEP__CONTEXT);

		mapeKEClass = createEClass(MAPE_K);

		goalInvokeEClass = createEClass(GOAL_INVOKE);
		createEAttribute(goalInvokeEClass, GOAL_INVOKE__INVOKE_GOAL);
		createEAttribute(goalInvokeEClass, GOAL_INVOKE__QUALITIES);
		createEAttribute(goalInvokeEClass, GOAL_INVOKE__LOCATION);

		// Create enums
		comparatorEEnum = createEEnum(COMPARATOR);
		httPverbEEnum = createEEnum(HTT_PVERB);
		semanticTargetTypeEEnum = createEEnum(SEMANTIC_TARGET_TYPE);
		humanTaskTypeEEnum = createEEnum(HUMAN_TASK_TYPE);
		humanTaskUseCaseEEnum = createEEnum(HUMAN_TASK_USE_CASE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		transitionEClass.getESuperTypes().add(this.getIdentifiable());
		transitionEClass.getESuperTypes().add(this.getNameable());
		ifEClass.getESuperTypes().add(this.getAtomicStep());
		orEClass.getESuperTypes().add(this.getAtomicStep());
		invokeEClass.getESuperTypes().add(this.getAtomicStep());
		eventEClass.getESuperTypes().add(this.getAtomicStep());
		processEClass.getESuperTypes().add(this.getCompositeStep());
		portEClass.getESuperTypes().add(this.getIdentifiable());
		portEClass.getESuperTypes().add(this.getNameable());
		dataPortEClass.getESuperTypes().add(this.getPort());
		controlPortEClass.getESuperTypes().add(this.getPort());
		processStepEClass.getESuperTypes().add(this.getIdentifiable());
		processStepEClass.getESuperTypes().add(this.getNameable());
		processStepEClass.getESuperTypes().add(this.getCpsStep());
		complexTypeEClass.getESuperTypes().add(this.getDataType());
		atomicStepEClass.getESuperTypes().add(this.getProcessStep());
		compositeStepEClass.getESuperTypes().add(this.getProcessStep());
		dataTypeEClass.getESuperTypes().add(this.getNameable());
		dataTypeEClass.getESuperTypes().add(this.getIdentifiable());
		simpleTypeEClass.getESuperTypes().add(this.getDataType());
		stringTypeEClass.getESuperTypes().add(this.getSimpleType());
		numericTypeEClass.getESuperTypes().add(this.getSimpleType());
		booleanTypeEClass.getESuperTypes().add(this.getSimpleType());
		integerTypeEClass.getESuperTypes().add(this.getNumericType());
		doubleTypeEClass.getESuperTypes().add(this.getNumericType());
		loopEClass.getESuperTypes().add(this.getCompositeStep());
		repeatLoopEClass.getESuperTypes().add(this.getLoop());
		whileLoopEClass.getESuperTypes().add(this.getLoop());
		forLoopEClass.getESuperTypes().add(this.getLoop());
		processSlotEClass.getESuperTypes().add(this.getAtomicStep());
		dataMappingStepEClass.getESuperTypes().add(this.getAtomicStep());
		startControlPortEClass.getESuperTypes().add(this.getControlPort());
		startControlPortEClass.getESuperTypes().add(this.getStartPort());
		endControlPortEClass.getESuperTypes().add(this.getControlPort());
		endControlPortEClass.getESuperTypes().add(this.getEndPort());
		startDataPortEClass.getESuperTypes().add(this.getDataPort());
		startDataPortEClass.getESuperTypes().add(this.getStartPort());
		endDataPortEClass.getESuperTypes().add(this.getDataPort());
		endDataPortEClass.getESuperTypes().add(this.getEndPort());
		triggeredEventEClass.getESuperTypes().add(this.getEvent());
		trueTransitionEClass.getESuperTypes().add(this.getTransition());
		falseTransitionEClass.getESuperTypes().add(this.getTransition());
		soapInvokeEClass.getESuperTypes().add(this.getInvoke());
		xmlrpcInvokeEClass.getESuperTypes().add(this.getInvoke());
		loadClassStepEClass.getESuperTypes().add(this.getAtomicStep());
		seMiWaInvokeEClass.getESuperTypes().add(this.getInvoke());
		restInvokeEClass.getESuperTypes().add(this.getInvoke());
		osGiInvokeEClass.getESuperTypes().add(this.getInvoke());
		seMiWaRequestEClass.getESuperTypes().add(this.getAtomicStep());
		dataMappingEClass.getESuperTypes().add(this.getIdentifiable());
		dataMappingEClass.getESuperTypes().add(this.getNameable());
		dataDuplicationStepEClass.getESuperTypes().add(this.getAtomicStep());
		rosInvokeEClass.getESuperTypes().add(this.getAtomicStep());
		andEClass.getESuperTypes().add(this.getAtomicStep());
		collectionTypeEClass.getESuperTypes().add(this.getDataType());
		listTypeEClass.getESuperTypes().add(this.getCollectionType());
		setTypeEClass.getESuperTypes().add(this.getCollectionType());
		publishMessageEClass.getESuperTypes().add(this.getAtomicStep());
		publishROSMessageEClass.getESuperTypes().add(this.getPublishMessage());
		humanTaskEClass.getESuperTypes().add(this.getAtomicStep());
		escalationPortEClass.getESuperTypes().add(this.getEndControlPort());
		openHabSemanticInvokeEClass.getESuperTypes().add(this.getInvoke());
		openHabSemanticSelectInvokeEClass.getESuperTypes().add(this.getOpenHabSemanticInvoke());
		openHabSemanticAskInvokeEClass.getESuperTypes().add(this.getOpenHabSemanticInvoke());
		openHabSemanticCommandInvokeEClass.getESuperTypes().add(this.getOpenHabSemanticInvoke());
		mapeKEClass.getESuperTypes().add(this.getAtomicStep());
		goalInvokeEClass.getESuperTypes().add(this.getInvoke());

		// Initialize classes and features; add operations and parameters
		initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransition_SourcePort(), this.getPort(), this.getPort_OutTransitions(), "sourcePort", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransition_TargetPort(), this.getPort(), this.getPort_InTransitions(), "targetPort", null, 1, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ifEClass, If.class, "If", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIf_IfCondition(), this.getCondition(), null, "ifCondition", null, 1, 1, If.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orEClass, Or.class, "Or", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(invokeEClass, Invoke.class, "Invoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(eventEClass, Event.class, "Event", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processEClass, eu.vicci.process.model.sofia.Process.class, "Process", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcess_DataTypeDefinitions(), this.getDataType(), null, "dataTypeDefinitions", null, 0, -1, eu.vicci.process.model.sofia.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcess_ExecutionPeer(), ecorePackage.getEString(), "executionPeer", null, 0, 1, eu.vicci.process.model.sofia.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcess_Distributed(), ecorePackage.getEBoolean(), "distributed", null, 0, 1, eu.vicci.process.model.sofia.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcess_RemoteExecuting(), ecorePackage.getEBoolean(), "remoteExecuting", null, 0, 1, eu.vicci.process.model.sofia.Process.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_OutTransitions(), this.getTransition(), this.getTransition_SourcePort(), "outTransitions", null, 0, -1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Optional(), ecorePackage.getEBoolean(), "optional", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_ProcessStep(), this.getProcessStep(), this.getProcessStep_Ports(), "processStep", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPort_InTransitions(), this.getTransition(), this.getTransition_TargetPort(), "inTransitions", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPort_Description(), ecorePackage.getEString(), "description", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataPortEClass, DataPort.class, "DataPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDataPort_Value(), ecorePackage.getEString(), "value", null, 0, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataPort_PortDatatype(), this.getDataType(), this.getDataType_PortMembers(), "portDatatype", null, 1, 1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataPort_Mappings(), this.getDataMapping(), null, "mappings", null, 0, -1, DataPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(controlPortEClass, ControlPort.class, "ControlPort", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(processStepEClass, ProcessStep.class, "ProcessStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessStep_Parentstep(), this.getCompositeStep(), this.getCompositeStep_SubSteps(), "parentstep", null, 0, 1, ProcessStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcessStep_Ports(), this.getPort(), this.getPort_ProcessStep(), "ports", null, 1, -1, ProcessStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStep_Type(), ecorePackage.getEString(), "type", null, 1, 1, ProcessStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStep_Description(), ecorePackage.getEString(), "description", null, 0, 1, ProcessStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProcessStep_Resource(), ecorePackage.getEString(), "resource", null, 0, 1, ProcessStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(complexTypeEClass, ComplexType.class, "ComplexType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComplexType_Subtypes(), this.getDataType(), this.getDataType_BelongsTo(), "subtypes", null, 0, -1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComplexType_Subreferences(), this.getDataType(), null, "subreferences", null, 0, -1, ComplexType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(conditionEClass, Condition.class, "Condition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCondition_Comparator(), this.getComparator(), "comparator", null, 1, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_LeftSide(), this.getStartDataPort(), null, "leftSide", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCondition_RightSide(), this.getStartDataPort(), null, "rightSide", null, 0, 1, Condition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicStepEClass, AtomicStep.class, "AtomicStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(compositeStepEClass, CompositeStep.class, "CompositeStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeStep_SubSteps(), this.getProcessStep(), this.getProcessStep_Parentstep(), "subSteps", null, 0, -1, CompositeStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeEClass, DataType.class, "DataType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataType_BelongsTo(), this.getComplexType(), this.getComplexType_Subtypes(), "belongsTo", null, 0, 1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_Mappings(), this.getDataMapping(), this.getDataMapping_Source(), "mappings", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataType_PortMembers(), this.getDataPort(), this.getDataPort_PortDatatype(), "portMembers", null, 0, -1, DataType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleTypeEClass, SimpleType.class, "SimpleType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(numericTypeEClass, NumericType.class, "NumericType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerType_Min(), ecorePackage.getEInt(), "min", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIntegerType_Max(), ecorePackage.getEInt(), "max", null, 0, 1, IntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleTypeEClass, DoubleType.class, "DoubleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(loopEClass, Loop.class, "Loop", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLoop_LoopCondition(), this.getCondition(), null, "loopCondition", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoop_PortsCopyToStartsport(), this.getEndDataPortToStartDataPortMap(), null, "portsCopyToStartsport", null, 0, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repeatLoopEClass, RepeatLoop.class, "RepeatLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(whileLoopEClass, WhileLoop.class, "WhileLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forLoopEClass, ForLoop.class, "ForLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForLoop_LoopStepWidth(), this.getStartDataPort(), null, "loopStepWidth", null, 0, 1, ForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(processSlotEClass, ProcessSlot.class, "ProcessSlot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataMappingStepEClass, DataMappingStep.class, "DataMappingStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMappingStep_Mappings(), this.getDataMapping(), null, "mappings", null, 0, -1, DataMappingStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startControlPortEClass, StartControlPort.class, "StartControlPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endControlPortEClass, EndControlPort.class, "EndControlPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startDataPortEClass, StartDataPort.class, "StartDataPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endDataPortEClass, EndDataPort.class, "EndDataPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(startPortEClass, StartPort.class, "StartPort", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(endPortEClass, EndPort.class, "EndPort", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(identifiableEClass, Identifiable.class, "Identifiable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifiable_Id(), ecorePackage.getEString(), "id", null, 1, 1, Identifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameableEClass, Nameable.class, "Nameable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameable_Name(), ecorePackage.getEString(), "name", null, 1, 1, Nameable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(triggeredEventEClass, TriggeredEvent.class, "TriggeredEvent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTriggeredEvent_EPLStatement(), ecorePackage.getEString(), "EPLStatement", null, 1, 1, TriggeredEvent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(trueTransitionEClass, TrueTransition.class, "TrueTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falseTransitionEClass, FalseTransition.class, "FalseTransition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(soapInvokeEClass, SOAPInvoke.class, "SOAPInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSOAPInvoke_ServerUri(), ecorePackage.getEString(), "serverUri", null, 1, 1, SOAPInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSOAPInvoke_MethodName(), ecorePackage.getEString(), "methodName", null, 1, 1, SOAPInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSOAPInvoke_WsdlUri(), ecorePackage.getEString(), "wsdlUri", null, 1, 1, SOAPInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSOAPInvoke_ConfigFile(), ecorePackage.getEString(), "configFile", null, 1, 1, SOAPInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(xmlrpcInvokeEClass, XMLRPCInvoke.class, "XMLRPCInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getXMLRPCInvoke_ServerUri(), ecorePackage.getEString(), "serverUri", null, 1, 1, XMLRPCInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMLRPCInvoke_MethodName(), ecorePackage.getEString(), "methodName", null, 1, 1, XMLRPCInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMLRPCInvoke_StartParameterSequence(), ecorePackage.getEString(), "startParameterSequence", null, 1, 1, XMLRPCInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getXMLRPCInvoke_EndParameterSequence(), ecorePackage.getEString(), "endParameterSequence", null, 1, 1, XMLRPCInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loadClassStepEClass, LoadClassStep.class, "LoadClassStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoadClassStep_DelegateClassName(), ecorePackage.getEString(), "delegateClassName", null, 0, 1, LoadClassStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seMiWaInvokeEClass, SeMiWaInvoke.class, "SeMiWaInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeMiWaInvoke_ServiceName(), ecorePackage.getEString(), "serviceName", null, 1, 1, SeMiWaInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSeMiWaInvoke_NodeId(), ecorePackage.getEString(), "nodeId", null, 1, 1, SeMiWaInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(restInvokeEClass, RESTInvoke.class, "RESTInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRESTInvoke_HTTPMethod(), this.getHTTPverb(), "HTTPMethod", null, 1, 1, RESTInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRESTInvoke_ServerUri(), ecorePackage.getEString(), "ServerUri", null, 1, 1, RESTInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(osGiInvokeEClass, OSGiInvoke.class, "OSGiInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOSGiInvoke_ServiceClassName(), ecorePackage.getEString(), "serviceClassName", null, 1, 1, OSGiInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOSGiInvoke_MethodName(), ecorePackage.getEString(), "methodName", null, 1, 1, OSGiInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOSGiInvoke_ParameterTypes(), ecorePackage.getEString(), "parameterTypes", null, 1, 1, OSGiInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOSGiInvoke_BundleName(), ecorePackage.getEString(), "bundleName", null, 1, 1, OSGiInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(seMiWaRequestEClass, SeMiWaRequest.class, "SeMiWaRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSeMiWaRequest_SSILStatement(), ecorePackage.getEString(), "SSILStatement", null, 1, 1, SeMiWaRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataMappingEClass, DataMapping.class, "DataMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataMapping_Source(), this.getDataType(), this.getDataType_Mappings(), "source", null, 1, 1, DataMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataMapping_Target(), this.getDataType(), null, "target", null, 1, 1, DataMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataDuplicationStepEClass, DataDuplicationStep.class, "DataDuplicationStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rosInvokeEClass, ROSInvoke.class, "ROSInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getROSInvoke_ServerUri(), ecorePackage.getEString(), "serverUri", null, 1, 1, ROSInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getROSInvoke_ServiceName(), ecorePackage.getEString(), "serviceName", null, 0, 1, ROSInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andEClass, And.class, "And", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(collectionTypeEClass, CollectionType.class, "CollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionType_CollectionItemType(), this.getDataType(), null, "collectionItemType", null, 1, 1, CollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setTypeEClass, SetType.class, "SetType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(publishMessageEClass, PublishMessage.class, "PublishMessage", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPublishMessage_ServerUri(), ecorePackage.getEString(), "serverUri", null, 0, 1, PublishMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPublishMessage_Topic(), ecorePackage.getEString(), "topic", null, 0, 1, PublishMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(publishROSMessageEClass, PublishROSMessage.class, "PublishROSMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(humanTaskEClass, HumanTask.class, "HumanTask", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getHumanTask_HumanTaskType(), this.getHumanTaskType(), "humanTaskType", null, 1, 1, HumanTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHumanTask_HumanTaskUseCase(), this.getHumanTaskUseCase(), "humanTaskUseCase", null, 1, 1, HumanTask.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(escalationPortEClass, EscalationPort.class, "EscalationPort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEscalationPort_EscalationTime(), ecorePackage.getELong(), "escalationTime", null, 1, 1, EscalationPort.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(endDataPortToStartDataPortMapEClass, Map.Entry.class, "EndDataPortToStartDataPortMap", !IS_ABSTRACT, !IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEndDataPortToStartDataPortMap_Key(), this.getEndDataPort(), null, "key", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEndDataPortToStartDataPortMap_Value(), this.getStartDataPort(), null, "value", null, 0, 1, Map.Entry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openHabSemanticInvokeEClass, OpenHabSemanticInvoke.class, "OpenHabSemanticInvoke", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenHabSemanticInvoke_Query(), ecorePackage.getEString(), "query", null, 0, 1, OpenHabSemanticInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenHabSemanticInvoke_ServerBaseAddress(), ecorePackage.getEString(), "serverBaseAddress", null, 0, 1, OpenHabSemanticInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOpenHabSemanticInvoke_WithLatest(), ecorePackage.getEBoolean(), "withLatest", null, 0, 1, OpenHabSemanticInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openHabSemanticSelectInvokeEClass, OpenHabSemanticSelectInvoke.class, "OpenHabSemanticSelectInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openHabSemanticAskInvokeEClass, OpenHabSemanticAskInvoke.class, "OpenHabSemanticAskInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(openHabSemanticCommandInvokeEClass, OpenHabSemanticCommandInvoke.class, "OpenHabSemanticCommandInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOpenHabSemanticCommandInvoke_Command(), ecorePackage.getEString(), "command", null, 0, 1, OpenHabSemanticCommandInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpsStepEClass, CpsStep.class, "CpsStep", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCpsStep_CyberPhysical(), ecorePackage.getEBoolean(), "cyberPhysical", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpsStep_Goal(), ecorePackage.getEString(), "goal", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpsStep_EplQuery(), ecorePackage.getEString(), "eplQuery", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpsStep_ControlProcessId(), ecorePackage.getEString(), "controlProcessId", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCpsStep_ControlProcess(), this.getProcess(), null, "controlProcess", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCpsStep_Context(), ecorePackage.getEString(), "context", null, 0, 1, CpsStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mapeKEClass, MapeK.class, "MapeK", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(goalInvokeEClass, GoalInvoke.class, "GoalInvoke", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGoalInvoke_InvokeGoal(), ecorePackage.getEString(), "invokeGoal", null, 0, 1, GoalInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalInvoke_Qualities(), ecorePackage.getEString(), "qualities", null, 0, -1, GoalInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGoalInvoke_Location(), ecorePackage.getEString(), "location", null, 0, 1, GoalInvoke.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(comparatorEEnum, Comparator.class, "Comparator");
		addEEnumLiteral(comparatorEEnum, Comparator.GREATER_THAN);
		addEEnumLiteral(comparatorEEnum, Comparator.SMALLER_THAN);
		addEEnumLiteral(comparatorEEnum, Comparator.GREATER_THAN_OR_EQUAL);
		addEEnumLiteral(comparatorEEnum, Comparator.SMALLER_THAN_OR_EQUAL);
		addEEnumLiteral(comparatorEEnum, Comparator.EQUAL);
		addEEnumLiteral(comparatorEEnum, Comparator.DISTINCT);
		addEEnumLiteral(comparatorEEnum, Comparator.IDENTIC);

		initEEnum(httPverbEEnum, HTTPverb.class, "HTTPverb");
		addEEnumLiteral(httPverbEEnum, HTTPverb.PUT);
		addEEnumLiteral(httPverbEEnum, HTTPverb.GET);
		addEEnumLiteral(httPverbEEnum, HTTPverb.POST);
		addEEnumLiteral(httPverbEEnum, HTTPverb.DELETE);

		initEEnum(semanticTargetTypeEEnum, SemanticTargetType.class, "SemanticTargetType");
		addEEnumLiteral(semanticTargetTypeEEnum, SemanticTargetType.ASK_QUERY);
		addEEnumLiteral(semanticTargetTypeEEnum, SemanticTargetType.SELECT_QUERY);
		addEEnumLiteral(semanticTargetTypeEEnum, SemanticTargetType.POST_COMMAND);

		initEEnum(humanTaskTypeEEnum, HumanTaskType.class, "HumanTaskType");
		addEEnumLiteral(humanTaskTypeEEnum, HumanTaskType.HINT);
		addEEnumLiteral(humanTaskTypeEEnum, HumanTaskType.WARNING);
		addEEnumLiteral(humanTaskTypeEEnum, HumanTaskType.INTERACTION);
		addEEnumLiteral(humanTaskTypeEEnum, HumanTaskType.ERROR);

		initEEnum(humanTaskUseCaseEEnum, HumanTaskUseCase.class, "HumanTaskUseCase");
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.UNIVERSAL);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.COFFEE);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.HEATING);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.ORDER);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.PLANTS);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.BELL);
		addEEnumLiteral(humanTaskUseCaseEEnum, HumanTaskUseCase.HEALTH);

		// Create resource
		createResource(eNS_URI);
	}

} //SofiaPackageImpl
