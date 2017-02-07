/**
 */
package eu.vicci.process.model.sofiainstance.util;

import eu.vicci.process.model.sofiainstance.*;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage
 * @generated
 */
public class SofiaInstanceAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SofiaInstancePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaInstanceAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SofiaInstancePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SofiaInstanceSwitch<Adapter> modelSwitch =
		new SofiaInstanceSwitch<Adapter>() {
			@Override
			public Adapter caseProcessInstance(ProcessInstance object) {
				return createProcessInstanceAdapter();
			}
			@Override
			public Adapter caseProcessStepInstance(ProcessStepInstance object) {
				return createProcessStepInstanceAdapter();
			}
			@Override
			public Adapter caseStateful(Stateful object) {
				return createStatefulAdapter();
			}
			@Override
			public Adapter casePortInstance(PortInstance object) {
				return createPortInstanceAdapter();
			}
			@Override
			public Adapter caseInstanceIdentifiable(InstanceIdentifiable object) {
				return createInstanceIdentifiableAdapter();
			}
			@Override
			public Adapter caseEventInstance(EventInstance object) {
				return createEventInstanceAdapter();
			}
			@Override
			public Adapter caseStringTypeInstance(StringTypeInstance object) {
				return createStringTypeInstanceAdapter();
			}
			@Override
			public Adapter caseIntegerTypeInstance(IntegerTypeInstance object) {
				return createIntegerTypeInstanceAdapter();
			}
			@Override
			public Adapter caseDoubleTypeInstance(DoubleTypeInstance object) {
				return createDoubleTypeInstanceAdapter();
			}
			@Override
			public Adapter caseBooleanTypeInstance(BooleanTypeInstance object) {
				return createBooleanTypeInstanceAdapter();
			}
			@Override
			public Adapter caseTransitionInstance(TransitionInstance object) {
				return createTransitionInstanceAdapter();
			}
			@Override
			public Adapter caseDataPortInstance(DataPortInstance object) {
				return createDataPortInstanceAdapter();
			}
			@Override
			public Adapter caseControlPortInstance(ControlPortInstance object) {
				return createControlPortInstanceAdapter();
			}
			@Override
			public Adapter caseStartPortInstance(StartPortInstance object) {
				return createStartPortInstanceAdapter();
			}
			@Override
			public Adapter caseEndPortInstance(EndPortInstance object) {
				return createEndPortInstanceAdapter();
			}
			@Override
			public Adapter caseStartControlPortInstance(StartControlPortInstance object) {
				return createStartControlPortInstanceAdapter();
			}
			@Override
			public Adapter caseStartDataPortInstance(StartDataPortInstance object) {
				return createStartDataPortInstanceAdapter();
			}
			@Override
			public Adapter caseEndControlPortInstance(EndControlPortInstance object) {
				return createEndControlPortInstanceAdapter();
			}
			@Override
			public Adapter caseEndDataPortInstance(EndDataPortInstance object) {
				return createEndDataPortInstanceAdapter();
			}
			@Override
			public Adapter caseDataTypeInstance(DataTypeInstance object) {
				return createDataTypeInstanceAdapter();
			}
			@Override
			public Adapter caseConfiguration(Configuration object) {
				return createConfigurationAdapter();
			}
			@Override
			public Adapter caseMappingUtil(MappingUtil object) {
				return createMappingUtilAdapter();
			}
			@Override
			public Adapter caseIfInstance(IfInstance object) {
				return createIfInstanceAdapter();
			}
			@Override
			public Adapter caseConditionInstance(ConditionInstance object) {
				return createConditionInstanceAdapter();
			}
			@Override
			public Adapter caseTrueTransitionInstance(TrueTransitionInstance object) {
				return createTrueTransitionInstanceAdapter();
			}
			@Override
			public Adapter caseFalseTransitionInstance(FalseTransitionInstance object) {
				return createFalseTransitionInstanceAdapter();
			}
			@Override
			public Adapter caseComplexTypeInstance(ComplexTypeInstance object) {
				return createComplexTypeInstanceAdapter();
			}
			@Override
			public Adapter caseListTypeInstance(ListTypeInstance object) {
				return createListTypeInstanceAdapter();
			}
			@Override
			public Adapter caseCollectionTypeInstance(CollectionTypeInstance object) {
				return createCollectionTypeInstanceAdapter();
			}
			@Override
			public Adapter caseSetTypeInstance(SetTypeInstance object) {
				return createSetTypeInstanceAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseEscalationPortInstance(EscalationPortInstance object) {
				return createEscalationPortInstanceAdapter();
			}
			@Override
			public Adapter caseLoopInstance(LoopInstance object) {
				return createLoopInstanceAdapter();
			}
			@Override
			public Adapter caseForLoopInstance(ForLoopInstance object) {
				return createForLoopInstanceAdapter();
			}
			@Override
			public Adapter caseAndInstance(AndInstance object) {
				return createAndInstanceAdapter();
			}
			@Override
			public Adapter caseOrInstance(OrInstance object) {
				return createOrInstanceAdapter();
			}
			@Override
			public Adapter caseROSInvokeInstance(ROSInvokeInstance object) {
				return createROSInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseProcessSlotInstance(ProcessSlotInstance object) {
				return createProcessSlotInstanceAdapter();
			}
			@Override
			public Adapter caseDataDuplicationStepInstance(DataDuplicationStepInstance object) {
				return createDataDuplicationStepInstanceAdapter();
			}
			@Override
			public Adapter caseRESTInvokeInstance(RESTInvokeInstance object) {
				return createRESTInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseOSGiInvokeInstance(OSGiInvokeInstance object) {
				return createOSGiInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseSOAPInvokeInstance(SOAPInvokeInstance object) {
				return createSOAPInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseHumanTaskInstance(HumanTaskInstance object) {
				return createHumanTaskInstanceAdapter();
			}
			@Override
			public Adapter caseLoadClassStepInstance(LoadClassStepInstance object) {
				return createLoadClassStepInstanceAdapter();
			}
			@Override
			public Adapter caseSeMiWaInvokeInstance(SeMiWaInvokeInstance object) {
				return createSeMiWaInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseTriggeredEventInstance(TriggeredEventInstance object) {
				return createTriggeredEventInstanceAdapter();
			}
			@Override
			public Adapter caseXMLRPCInvokeInstance(XMLRPCInvokeInstance object) {
				return createXMLRPCInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseSeMiWaRequestInstance(SeMiWaRequestInstance object) {
				return createSeMiWaRequestInstanceAdapter();
			}
			@Override
			public Adapter caseDataMappingStepInstance(DataMappingStepInstance object) {
				return createDataMappingStepInstanceAdapter();
			}
			@Override
			public Adapter caseWhileLoopInstance(WhileLoopInstance object) {
				return createWhileLoopInstanceAdapter();
			}
			@Override
			public Adapter caseEndDataPortToStartDataPortMapInstance(Map.Entry<EndDataPortInstance, StartDataPortInstance> object) {
				return createEndDataPortToStartDataPortMapInstanceAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticInvokeInstance(OpenHabSemanticInvokeInstance object) {
				return createOpenHabSemanticInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticSelectInvokeInstance(OpenHabSemanticSelectInvokeInstance object) {
				return createOpenHabSemanticSelectInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticAskInvokeInstance(OpenHabSemanticAskInvokeInstance object) {
				return createOpenHabSemanticAskInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticCommandInvokeInstance(OpenHabSemanticCommandInvokeInstance object) {
				return createOpenHabSemanticCommandInvokeInstanceAdapter();
			}
			@Override
			public Adapter caseMapeKInstance(MapeKInstance object) {
				return createMapeKInstanceAdapter();
			}
			@Override
			public Adapter caseGoalInvokeInstance(GoalInvokeInstance object) {
				return createGoalInvokeInstanceAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ProcessInstance <em>Process Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ProcessInstance
	 * @generated
	 */
	public Adapter createProcessInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ProcessStepInstance <em>Process Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ProcessStepInstance
	 * @generated
	 */
	public Adapter createProcessStepInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.Stateful <em>Stateful</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.Stateful
	 * @generated
	 */
	public Adapter createStatefulAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.PortInstance <em>Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.PortInstance
	 * @generated
	 */
	public Adapter createPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.InstanceIdentifiable <em>Instance Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.InstanceIdentifiable
	 * @generated
	 */
	public Adapter createInstanceIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.EventInstance <em>Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.EventInstance
	 * @generated
	 */
	public Adapter createEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.StringTypeInstance <em>String Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.StringTypeInstance
	 * @generated
	 */
	public Adapter createStringTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.IntegerTypeInstance <em>Integer Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.IntegerTypeInstance
	 * @generated
	 */
	public Adapter createIntegerTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.DoubleTypeInstance <em>Double Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.DoubleTypeInstance
	 * @generated
	 */
	public Adapter createDoubleTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.BooleanTypeInstance <em>Boolean Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.BooleanTypeInstance
	 * @generated
	 */
	public Adapter createBooleanTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.TransitionInstance <em>Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.TransitionInstance
	 * @generated
	 */
	public Adapter createTransitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.DataPortInstance <em>Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.DataPortInstance
	 * @generated
	 */
	public Adapter createDataPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ControlPortInstance <em>Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ControlPortInstance
	 * @generated
	 */
	public Adapter createControlPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.StartPortInstance <em>Start Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.StartPortInstance
	 * @generated
	 */
	public Adapter createStartPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.EndPortInstance <em>End Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.EndPortInstance
	 * @generated
	 */
	public Adapter createEndPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.StartControlPortInstance <em>Start Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.StartControlPortInstance
	 * @generated
	 */
	public Adapter createStartControlPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.StartDataPortInstance <em>Start Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.StartDataPortInstance
	 * @generated
	 */
	public Adapter createStartDataPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.EndControlPortInstance <em>End Control Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.EndControlPortInstance
	 * @generated
	 */
	public Adapter createEndControlPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.EndDataPortInstance <em>End Data Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.EndDataPortInstance
	 * @generated
	 */
	public Adapter createEndDataPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.DataTypeInstance <em>Data Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.DataTypeInstance
	 * @generated
	 */
	public Adapter createDataTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.MappingUtil <em>Mapping Util</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.MappingUtil
	 * @generated
	 */
	public Adapter createMappingUtilAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.IfInstance <em>If Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.IfInstance
	 * @generated
	 */
	public Adapter createIfInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ConditionInstance <em>Condition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ConditionInstance
	 * @generated
	 */
	public Adapter createConditionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.TrueTransitionInstance <em>True Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.TrueTransitionInstance
	 * @generated
	 */
	public Adapter createTrueTransitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.FalseTransitionInstance <em>False Transition Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.FalseTransitionInstance
	 * @generated
	 */
	public Adapter createFalseTransitionInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ComplexTypeInstance <em>Complex Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ComplexTypeInstance
	 * @generated
	 */
	public Adapter createComplexTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ListTypeInstance <em>List Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ListTypeInstance
	 * @generated
	 */
	public Adapter createListTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.CollectionTypeInstance <em>Collection Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.CollectionTypeInstance
	 * @generated
	 */
	public Adapter createCollectionTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.SetTypeInstance <em>Set Type Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.SetTypeInstance
	 * @generated
	 */
	public Adapter createSetTypeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.EscalationPortInstance <em>Escalation Port Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.EscalationPortInstance
	 * @generated
	 */
	public Adapter createEscalationPortInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.LoopInstance <em>Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.LoopInstance
	 * @generated
	 */
	public Adapter createLoopInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ForLoopInstance <em>For Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ForLoopInstance
	 * @generated
	 */
	public Adapter createForLoopInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.AndInstance <em>And Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.AndInstance
	 * @generated
	 */
	public Adapter createAndInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OrInstance <em>Or Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OrInstance
	 * @generated
	 */
	public Adapter createOrInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ROSInvokeInstance <em>ROS Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ROSInvokeInstance
	 * @generated
	 */
	public Adapter createROSInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.ProcessSlotInstance <em>Process Slot Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.ProcessSlotInstance
	 * @generated
	 */
	public Adapter createProcessSlotInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance <em>Data Duplication Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.DataDuplicationStepInstance
	 * @generated
	 */
	public Adapter createDataDuplicationStepInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.RESTInvokeInstance <em>REST Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.RESTInvokeInstance
	 * @generated
	 */
	public Adapter createRESTInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OSGiInvokeInstance <em>OS Gi Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OSGiInvokeInstance
	 * @generated
	 */
	public Adapter createOSGiInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.SOAPInvokeInstance <em>SOAP Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.SOAPInvokeInstance
	 * @generated
	 */
	public Adapter createSOAPInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.HumanTaskInstance <em>Human Task Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.HumanTaskInstance
	 * @generated
	 */
	public Adapter createHumanTaskInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.LoadClassStepInstance <em>Load Class Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.LoadClassStepInstance
	 * @generated
	 */
	public Adapter createLoadClassStepInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance <em>Se Mi Wa Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaInvokeInstance
	 * @generated
	 */
	public Adapter createSeMiWaInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.TriggeredEventInstance <em>Triggered Event Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.TriggeredEventInstance
	 * @generated
	 */
	public Adapter createTriggeredEventInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance <em>XMLRPC Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.XMLRPCInvokeInstance
	 * @generated
	 */
	public Adapter createXMLRPCInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance <em>Se Mi Wa Request Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.SeMiWaRequestInstance
	 * @generated
	 */
	public Adapter createSeMiWaRequestInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.DataMappingStepInstance <em>Data Mapping Step Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.DataMappingStepInstance
	 * @generated
	 */
	public Adapter createDataMappingStepInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.WhileLoopInstance <em>While Loop Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.WhileLoopInstance
	 * @generated
	 */
	public Adapter createWhileLoopInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>End Data Port To Start Data Port Map Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEndDataPortToStartDataPortMapInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance <em>Open Hab Semantic Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticInvokeInstance
	 * @generated
	 */
	public Adapter createOpenHabSemanticInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance <em>Open Hab Semantic Select Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticSelectInvokeInstance
	 * @generated
	 */
	public Adapter createOpenHabSemanticSelectInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance <em>Open Hab Semantic Ask Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticAskInvokeInstance
	 * @generated
	 */
	public Adapter createOpenHabSemanticAskInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance <em>Open Hab Semantic Command Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.OpenHabSemanticCommandInvokeInstance
	 * @generated
	 */
	public Adapter createOpenHabSemanticCommandInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.MapeKInstance <em>Mape KInstance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.MapeKInstance
	 * @generated
	 */
	public Adapter createMapeKInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofiainstance.GoalInvokeInstance <em>Goal Invoke Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofiainstance.GoalInvokeInstance
	 * @generated
	 */
	public Adapter createGoalInvokeInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SofiaInstanceAdapterFactory
