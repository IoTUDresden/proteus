/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.DataDuplicationStep;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataMappingStep;
import eu.vicci.process.model.sofia.DoubleType;
import eu.vicci.process.model.sofia.EndControlPort;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.FalseTransition;
import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofia.HTTPverb;
import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.sofia.If;
import eu.vicci.process.model.sofia.IntegerType;
import eu.vicci.process.model.sofia.Invoke;
import eu.vicci.process.model.sofia.ListType;
import eu.vicci.process.model.sofia.LoadClassStep;
import eu.vicci.process.model.sofia.MapeK;
import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke;
import eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke;
import eu.vicci.process.model.sofia.Or;
import eu.vicci.process.model.sofia.ProcessSlot;
import eu.vicci.process.model.sofia.PublishROSMessage;
import eu.vicci.process.model.sofia.RESTInvoke;
import eu.vicci.process.model.sofia.ROSInvoke;
import eu.vicci.process.model.sofia.RepeatLoop;
import eu.vicci.process.model.sofia.SOAPInvoke;
import eu.vicci.process.model.sofia.SeMiWaInvoke;
import eu.vicci.process.model.sofia.SeMiWaRequest;
import eu.vicci.process.model.sofia.SemanticTargetType;
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.StartControlPort;
import eu.vicci.process.model.sofia.StartDataPort;
import eu.vicci.process.model.sofia.StringType;
import eu.vicci.process.model.sofia.Transition;
import eu.vicci.process.model.sofia.TriggeredEvent;
import eu.vicci.process.model.sofia.TrueTransition;
import eu.vicci.process.model.sofia.WhileLoop;
import eu.vicci.process.model.sofia.XMLRPCInvoke;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SofiaFactoryImpl extends EFactoryImpl implements SofiaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SofiaFactory init() {
		try {
			SofiaFactory theSofiaFactory = (SofiaFactory)EPackage.Registry.INSTANCE.getEFactory(SofiaPackage.eNS_URI);
			if (theSofiaFactory != null) {
				return theSofiaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SofiaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SofiaPackage.TRANSITION: return createTransition();
			case SofiaPackage.IF: return createIf();
			case SofiaPackage.OR: return createOr();
			case SofiaPackage.INVOKE: return createInvoke();
			case SofiaPackage.PROCESS: return createProcess();
			case SofiaPackage.COMPLEX_TYPE: return createComplexType();
			case SofiaPackage.CONDITION: return createCondition();
			case SofiaPackage.STRING_TYPE: return createStringType();
			case SofiaPackage.BOOLEAN_TYPE: return createBooleanType();
			case SofiaPackage.INTEGER_TYPE: return createIntegerType();
			case SofiaPackage.DOUBLE_TYPE: return createDoubleType();
			case SofiaPackage.REPEAT_LOOP: return createRepeatLoop();
			case SofiaPackage.WHILE_LOOP: return createWhileLoop();
			case SofiaPackage.FOR_LOOP: return createForLoop();
			case SofiaPackage.PROCESS_SLOT: return createProcessSlot();
			case SofiaPackage.DATA_MAPPING_STEP: return createDataMappingStep();
			case SofiaPackage.START_CONTROL_PORT: return createStartControlPort();
			case SofiaPackage.END_CONTROL_PORT: return createEndControlPort();
			case SofiaPackage.START_DATA_PORT: return createStartDataPort();
			case SofiaPackage.END_DATA_PORT: return createEndDataPort();
			case SofiaPackage.TRIGGERED_EVENT: return createTriggeredEvent();
			case SofiaPackage.TRUE_TRANSITION: return createTrueTransition();
			case SofiaPackage.FALSE_TRANSITION: return createFalseTransition();
			case SofiaPackage.SOAP_INVOKE: return createSOAPInvoke();
			case SofiaPackage.XMLRPC_INVOKE: return createXMLRPCInvoke();
			case SofiaPackage.LOAD_CLASS_STEP: return createLoadClassStep();
			case SofiaPackage.SE_MI_WA_INVOKE: return createSeMiWaInvoke();
			case SofiaPackage.REST_INVOKE: return createRESTInvoke();
			case SofiaPackage.OS_GI_INVOKE: return createOSGiInvoke();
			case SofiaPackage.SE_MI_WA_REQUEST: return createSeMiWaRequest();
			case SofiaPackage.DATA_MAPPING: return createDataMapping();
			case SofiaPackage.DATA_DUPLICATION_STEP: return createDataDuplicationStep();
			case SofiaPackage.ROS_INVOKE: return createROSInvoke();
			case SofiaPackage.AND: return createAnd();
			case SofiaPackage.COLLECTION_TYPE: return createCollectionType();
			case SofiaPackage.LIST_TYPE: return createListType();
			case SofiaPackage.SET_TYPE: return createSetType();
			case SofiaPackage.PUBLISH_ROS_MESSAGE: return createPublishROSMessage();
			case SofiaPackage.HUMAN_TASK: return createHumanTask();
			case SofiaPackage.ESCALATION_PORT: return createEscalationPort();
			case SofiaPackage.END_DATA_PORT_TO_START_DATA_PORT_MAP: return (EObject)createEndDataPortToStartDataPortMap();
			case SofiaPackage.OPEN_HAB_SEMANTIC_SELECT_INVOKE: return createOpenHabSemanticSelectInvoke();
			case SofiaPackage.OPEN_HAB_SEMANTIC_ASK_INVOKE: return createOpenHabSemanticAskInvoke();
			case SofiaPackage.OPEN_HAB_SEMANTIC_COMMAND_INVOKE: return createOpenHabSemanticCommandInvoke();
			case SofiaPackage.MAPE_K: return createMapeK();
			case SofiaPackage.GOAL_INVOKE: return createGoalInvoke();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SofiaPackage.COMPARATOR:
				return createComparatorFromString(eDataType, initialValue);
			case SofiaPackage.HTT_PVERB:
				return createHTTPverbFromString(eDataType, initialValue);
			case SofiaPackage.SEMANTIC_TARGET_TYPE:
				return createSemanticTargetTypeFromString(eDataType, initialValue);
			case SofiaPackage.HUMAN_TASK_TYPE:
				return createHumanTaskTypeFromString(eDataType, initialValue);
			case SofiaPackage.HUMAN_TASK_USE_CASE:
				return createHumanTaskUseCaseFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SofiaPackage.COMPARATOR:
				return convertComparatorToString(eDataType, instanceValue);
			case SofiaPackage.HTT_PVERB:
				return convertHTTPverbToString(eDataType, instanceValue);
			case SofiaPackage.SEMANTIC_TARGET_TYPE:
				return convertSemanticTargetTypeToString(eDataType, instanceValue);
			case SofiaPackage.HUMAN_TASK_TYPE:
				return convertHumanTaskTypeToString(eDataType, instanceValue);
			case SofiaPackage.HUMAN_TASK_USE_CASE:
				return convertHumanTaskUseCaseToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Or createOr() {
		OrImpl or = new OrImpl();
		return or;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Invoke createInvoke() {
		InvokeImpl invoke = new InvokeImpl();
		return invoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public eu.vicci.process.model.sofia.Process createProcess() {
		ProcessImpl process = new ProcessImpl();
		return process;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType createComplexType() {
		ComplexTypeImpl complexType = new ComplexTypeImpl();
		return complexType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition createCondition() {
		ConditionImpl condition = new ConditionImpl();
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType createStringType() {
		StringTypeImpl stringType = new StringTypeImpl();
		return stringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType createBooleanType() {
		BooleanTypeImpl booleanType = new BooleanTypeImpl();
		return booleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType createIntegerType() {
		IntegerTypeImpl integerType = new IntegerTypeImpl();
		return integerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleType createDoubleType() {
		DoubleTypeImpl doubleType = new DoubleTypeImpl();
		return doubleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepeatLoop createRepeatLoop() {
		RepeatLoopImpl repeatLoop = new RepeatLoopImpl();
		return repeatLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WhileLoop createWhileLoop() {
		WhileLoopImpl whileLoop = new WhileLoopImpl();
		return whileLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForLoop createForLoop() {
		ForLoopImpl forLoop = new ForLoopImpl();
		return forLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessSlot createProcessSlot() {
		ProcessSlotImpl processSlot = new ProcessSlotImpl();
		return processSlot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMappingStep createDataMappingStep() {
		DataMappingStepImpl dataMappingStep = new DataMappingStepImpl();
		return dataMappingStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartControlPort createStartControlPort() {
		StartControlPortImpl startControlPort = new StartControlPortImpl();
		return startControlPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndControlPort createEndControlPort() {
		EndControlPortImpl endControlPort = new EndControlPortImpl();
		return endControlPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPort createStartDataPort() {
		StartDataPortImpl startDataPort = new StartDataPortImpl();
		return startDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndDataPort createEndDataPort() {
		EndDataPortImpl endDataPort = new EndDataPortImpl();
		return endDataPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TriggeredEvent createTriggeredEvent() {
		TriggeredEventImpl triggeredEvent = new TriggeredEventImpl();
		return triggeredEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueTransition createTrueTransition() {
		TrueTransitionImpl trueTransition = new TrueTransitionImpl();
		return trueTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseTransition createFalseTransition() {
		FalseTransitionImpl falseTransition = new FalseTransitionImpl();
		return falseTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SOAPInvoke createSOAPInvoke() {
		SOAPInvokeImpl soapInvoke = new SOAPInvokeImpl();
		return soapInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMLRPCInvoke createXMLRPCInvoke() {
		XMLRPCInvokeImpl xmlrpcInvoke = new XMLRPCInvokeImpl();
		return xmlrpcInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadClassStep createLoadClassStep() {
		LoadClassStepImpl loadClassStep = new LoadClassStepImpl();
		return loadClassStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeMiWaInvoke createSeMiWaInvoke() {
		SeMiWaInvokeImpl seMiWaInvoke = new SeMiWaInvokeImpl();
		return seMiWaInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RESTInvoke createRESTInvoke() {
		RESTInvokeImpl restInvoke = new RESTInvokeImpl();
		return restInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OSGiInvoke createOSGiInvoke() {
		OSGiInvokeImpl osGiInvoke = new OSGiInvokeImpl();
		return osGiInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeMiWaRequest createSeMiWaRequest() {
		SeMiWaRequestImpl seMiWaRequest = new SeMiWaRequestImpl();
		return seMiWaRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataMapping createDataMapping() {
		DataMappingImpl dataMapping = new DataMappingImpl();
		return dataMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataDuplicationStep createDataDuplicationStep() {
		DataDuplicationStepImpl dataDuplicationStep = new DataDuplicationStepImpl();
		return dataDuplicationStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ROSInvoke createROSInvoke() {
		ROSInvokeImpl rosInvoke = new ROSInvokeImpl();
		return rosInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public And createAnd() {
		AndImpl and = new AndImpl();
		return and;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionType createCollectionType() {
		CollectionTypeImpl collectionType = new CollectionTypeImpl();
		return collectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListType createListType() {
		ListTypeImpl listType = new ListTypeImpl();
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetType createSetType() {
		SetTypeImpl setType = new SetTypeImpl();
		return setType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishROSMessage createPublishROSMessage() {
		PublishROSMessageImpl publishROSMessage = new PublishROSMessageImpl();
		return publishROSMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTask createHumanTask() {
		HumanTaskImpl humanTask = new HumanTaskImpl();
		return humanTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EscalationPort createEscalationPort() {
		EscalationPortImpl escalationPort = new EscalationPortImpl();
		return escalationPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EndDataPort, StartDataPort> createEndDataPortToStartDataPortMap() {
		EndDataPortToStartDataPortMapImpl endDataPortToStartDataPortMap = new EndDataPortToStartDataPortMapImpl();
		return endDataPortToStartDataPortMap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenHabSemanticSelectInvoke createOpenHabSemanticSelectInvoke() {
		OpenHabSemanticSelectInvokeImpl openHabSemanticSelectInvoke = new OpenHabSemanticSelectInvokeImpl();
		return openHabSemanticSelectInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenHabSemanticAskInvoke createOpenHabSemanticAskInvoke() {
		OpenHabSemanticAskInvokeImpl openHabSemanticAskInvoke = new OpenHabSemanticAskInvokeImpl();
		return openHabSemanticAskInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OpenHabSemanticCommandInvoke createOpenHabSemanticCommandInvoke() {
		OpenHabSemanticCommandInvokeImpl openHabSemanticCommandInvoke = new OpenHabSemanticCommandInvokeImpl();
		return openHabSemanticCommandInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapeK createMapeK() {
		MapeKImpl mapeK = new MapeKImpl();
		return mapeK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GoalInvoke createGoalInvoke() {
		GoalInvokeImpl goalInvoke = new GoalInvokeImpl();
		return goalInvoke;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Comparator createComparatorFromString(EDataType eDataType, String initialValue) {
		Comparator result = Comparator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertComparatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPverb createHTTPverbFromString(EDataType eDataType, String initialValue) {
		HTTPverb result = HTTPverb.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHTTPverbToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SemanticTargetType createSemanticTargetTypeFromString(EDataType eDataType, String initialValue) {
		SemanticTargetType result = SemanticTargetType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSemanticTargetTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTaskType createHumanTaskTypeFromString(EDataType eDataType, String initialValue) {
		HumanTaskType result = HumanTaskType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHumanTaskTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTaskUseCase createHumanTaskUseCaseFromString(EDataType eDataType, String initialValue) {
		HumanTaskUseCase result = HumanTaskUseCase.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHumanTaskUseCaseToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaPackage getSofiaPackage() {
		return (SofiaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SofiaPackage getPackage() {
		return SofiaPackage.eINSTANCE;
	}

} //SofiaFactoryImpl
