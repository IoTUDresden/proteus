/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.*;

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
public class SofiaInstanceFactoryImpl extends EFactoryImpl implements SofiaInstanceFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SofiaInstanceFactory init() {
		try {
			SofiaInstanceFactory theSofiaInstanceFactory = (SofiaInstanceFactory)EPackage.Registry.INSTANCE.getEFactory(SofiaInstancePackage.eNS_URI);
			if (theSofiaInstanceFactory != null) {
				return theSofiaInstanceFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SofiaInstanceFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaInstanceFactoryImpl() {
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
			case SofiaInstancePackage.PROCESS_INSTANCE: return createProcessInstance();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE: return createProcessStepInstance();
			case SofiaInstancePackage.STRING_TYPE_INSTANCE: return createStringTypeInstance();
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE: return createIntegerTypeInstance();
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE: return createDoubleTypeInstance();
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE: return createBooleanTypeInstance();
			case SofiaInstancePackage.TRANSITION_INSTANCE: return createTransitionInstance();
			case SofiaInstancePackage.START_CONTROL_PORT_INSTANCE: return createStartControlPortInstance();
			case SofiaInstancePackage.START_DATA_PORT_INSTANCE: return createStartDataPortInstance();
			case SofiaInstancePackage.END_CONTROL_PORT_INSTANCE: return createEndControlPortInstance();
			case SofiaInstancePackage.END_DATA_PORT_INSTANCE: return createEndDataPortInstance();
			case SofiaInstancePackage.DATA_TYPE_INSTANCE: return createDataTypeInstance();
			case SofiaInstancePackage.CONFIGURATION: return createConfiguration();
			case SofiaInstancePackage.MAPPING_UTIL: return createMappingUtil();
			case SofiaInstancePackage.CONDITION_INSTANCE: return createConditionInstance();
			case SofiaInstancePackage.TRUE_TRANSITION_INSTANCE: return createTrueTransitionInstance();
			case SofiaInstancePackage.FALSE_TRANSITION_INSTANCE: return createFalseTransitionInstance();
			case SofiaInstancePackage.COMPLEX_TYPE_INSTANCE: return createComplexTypeInstance();
			case SofiaInstancePackage.LIST_TYPE_INSTANCE: return createListTypeInstance();
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE: return createCollectionTypeInstance();
			case SofiaInstancePackage.SET_TYPE_INSTANCE: return createSetTypeInstance();
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE: return createEscalationPortInstance();
			case SofiaInstancePackage.HUMAN_TASK_INSTANCE: return createHumanTaskInstance();
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE: return (EObject)createEndDataPortToStartDataPortMapInstance();
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
			case SofiaInstancePackage.STATE:
				return createStateFromString(eDataType, initialValue);
			case SofiaInstancePackage.EXECUTION_PERMISSION:
				return createExecutionPermissionFromString(eDataType, initialValue);
			case SofiaInstancePackage.CPS_STATE:
				return createCpsStateFromString(eDataType, initialValue);
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
			case SofiaInstancePackage.STATE:
				return convertStateToString(eDataType, instanceValue);
			case SofiaInstancePackage.EXECUTION_PERMISSION:
				return convertExecutionPermissionToString(eDataType, instanceValue);
			case SofiaInstancePackage.CPS_STATE:
				return convertCpsStateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessInstance createProcessInstance() {
		ProcessInstanceImpl processInstance = new ProcessInstanceImpl();
		return processInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStepInstance createProcessStepInstance() {
		ProcessStepInstanceImpl processStepInstance = new ProcessStepInstanceImpl();
		return processStepInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringTypeInstance createStringTypeInstance() {
		StringTypeInstanceImpl stringTypeInstance = new StringTypeInstanceImpl();
		return stringTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerTypeInstance createIntegerTypeInstance() {
		IntegerTypeInstanceImpl integerTypeInstance = new IntegerTypeInstanceImpl();
		return integerTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleTypeInstance createDoubleTypeInstance() {
		DoubleTypeInstanceImpl doubleTypeInstance = new DoubleTypeInstanceImpl();
		return doubleTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanTypeInstance createBooleanTypeInstance() {
		BooleanTypeInstanceImpl booleanTypeInstance = new BooleanTypeInstanceImpl();
		return booleanTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionInstance createTransitionInstance() {
		TransitionInstanceImpl transitionInstance = new TransitionInstanceImpl();
		return transitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartControlPortInstance createStartControlPortInstance() {
		StartControlPortInstanceImpl startControlPortInstance = new StartControlPortInstanceImpl();
		return startControlPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance createStartDataPortInstance() {
		StartDataPortInstanceImpl startDataPortInstance = new StartDataPortInstanceImpl();
		return startDataPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndControlPortInstance createEndControlPortInstance() {
		EndControlPortInstanceImpl endControlPortInstance = new EndControlPortInstanceImpl();
		return endControlPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndDataPortInstance createEndDataPortInstance() {
		EndDataPortInstanceImpl endDataPortInstance = new EndDataPortInstanceImpl();
		return endDataPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeInstance createDataTypeInstance() {
		DataTypeInstanceImpl dataTypeInstance = new DataTypeInstanceImpl();
		return dataTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingUtil createMappingUtil() {
		MappingUtilImpl mappingUtil = new MappingUtilImpl();
		return mappingUtil;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionInstance createConditionInstance() {
		ConditionInstanceImpl conditionInstance = new ConditionInstanceImpl();
		return conditionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrueTransitionInstance createTrueTransitionInstance() {
		TrueTransitionInstanceImpl trueTransitionInstance = new TrueTransitionInstanceImpl();
		return trueTransitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalseTransitionInstance createFalseTransitionInstance() {
		FalseTransitionInstanceImpl falseTransitionInstance = new FalseTransitionInstanceImpl();
		return falseTransitionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexTypeInstance createComplexTypeInstance() {
		ComplexTypeInstanceImpl complexTypeInstance = new ComplexTypeInstanceImpl();
		return complexTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListTypeInstance createListTypeInstance() {
		ListTypeInstanceImpl listTypeInstance = new ListTypeInstanceImpl();
		return listTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionTypeInstance createCollectionTypeInstance() {
		CollectionTypeInstanceImpl collectionTypeInstance = new CollectionTypeInstanceImpl();
		return collectionTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetTypeInstance createSetTypeInstance() {
		SetTypeInstanceImpl setTypeInstance = new SetTypeInstanceImpl();
		return setTypeInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EscalationPortInstance createEscalationPortInstance() {
		EscalationPortInstanceImpl escalationPortInstance = new EscalationPortInstanceImpl();
		return escalationPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTaskInstance createHumanTaskInstance() {
		HumanTaskInstanceImpl humanTaskInstance = new HumanTaskInstanceImpl();
		return humanTaskInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EndDataPortInstance, StartDataPortInstance> createEndDataPortToStartDataPortMapInstance() {
		EndDataPortToStartDataPortMapInstanceImpl endDataPortToStartDataPortMapInstance = new EndDataPortToStartDataPortMapInstanceImpl();
		return endDataPortToStartDataPortMapInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createStateFromString(EDataType eDataType, String initialValue) {
		State result = State.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionPermission createExecutionPermissionFromString(EDataType eDataType, String initialValue) {
		ExecutionPermission result = ExecutionPermission.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionPermissionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CpsState createCpsStateFromString(EDataType eDataType, String initialValue) {
		CpsState result = CpsState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCpsStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaInstancePackage getSofiaInstancePackage() {
		return (SofiaInstancePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SofiaInstancePackage getPackage() {
		return SofiaInstancePackage.eINSTANCE;
	}

} //SofiaInstanceFactoryImpl
