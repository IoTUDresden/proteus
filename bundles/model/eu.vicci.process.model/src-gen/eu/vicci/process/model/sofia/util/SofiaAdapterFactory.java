/**
 */
package eu.vicci.process.model.sofia.util;

import eu.vicci.process.model.sofia.And;
import eu.vicci.process.model.sofia.AtomicStep;
import eu.vicci.process.model.sofia.BooleanType;
import eu.vicci.process.model.sofia.CollectionType;
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
import eu.vicci.process.model.sofia.HumanTask;
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
import eu.vicci.process.model.sofia.SetType;
import eu.vicci.process.model.sofia.SimpleType;
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofia.SofiaPackage
 * @generated
 */
public class SofiaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SofiaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SofiaPackage.eINSTANCE;
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
	protected SofiaSwitch<Adapter> modelSwitch =
		new SofiaSwitch<Adapter>() {
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseIf(If object) {
				return createIfAdapter();
			}
			@Override
			public Adapter caseOr(Or object) {
				return createOrAdapter();
			}
			@Override
			public Adapter caseInvoke(Invoke object) {
				return createInvokeAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseProcess(eu.vicci.process.model.sofia.Process object) {
				return createProcessAdapter();
			}
			@Override
			public Adapter casePort(Port object) {
				return createPortAdapter();
			}
			@Override
			public Adapter caseDataPort(DataPort object) {
				return createDataPortAdapter();
			}
			@Override
			public Adapter caseControlPort(ControlPort object) {
				return createControlPortAdapter();
			}
			@Override
			public Adapter caseProcessStep(ProcessStep object) {
				return createProcessStepAdapter();
			}
			@Override
			public Adapter caseComplexType(ComplexType object) {
				return createComplexTypeAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseAtomicStep(AtomicStep object) {
				return createAtomicStepAdapter();
			}
			@Override
			public Adapter caseCompositeStep(CompositeStep object) {
				return createCompositeStepAdapter();
			}
			@Override
			public Adapter caseDataType(DataType object) {
				return createDataTypeAdapter();
			}
			@Override
			public Adapter caseSimpleType(SimpleType object) {
				return createSimpleTypeAdapter();
			}
			@Override
			public Adapter caseStringType(StringType object) {
				return createStringTypeAdapter();
			}
			@Override
			public Adapter caseNumericType(NumericType object) {
				return createNumericTypeAdapter();
			}
			@Override
			public Adapter caseBooleanType(BooleanType object) {
				return createBooleanTypeAdapter();
			}
			@Override
			public Adapter caseIntegerType(IntegerType object) {
				return createIntegerTypeAdapter();
			}
			@Override
			public Adapter caseDoubleType(DoubleType object) {
				return createDoubleTypeAdapter();
			}
			@Override
			public Adapter caseLoop(Loop object) {
				return createLoopAdapter();
			}
			@Override
			public Adapter caseRepeatLoop(RepeatLoop object) {
				return createRepeatLoopAdapter();
			}
			@Override
			public Adapter caseWhileLoop(WhileLoop object) {
				return createWhileLoopAdapter();
			}
			@Override
			public Adapter caseForLoop(ForLoop object) {
				return createForLoopAdapter();
			}
			@Override
			public Adapter caseProcessSlot(ProcessSlot object) {
				return createProcessSlotAdapter();
			}
			@Override
			public Adapter caseDataMappingStep(DataMappingStep object) {
				return createDataMappingStepAdapter();
			}
			@Override
			public Adapter caseStartControlPort(StartControlPort object) {
				return createStartControlPortAdapter();
			}
			@Override
			public Adapter caseEndControlPort(EndControlPort object) {
				return createEndControlPortAdapter();
			}
			@Override
			public Adapter caseStartDataPort(StartDataPort object) {
				return createStartDataPortAdapter();
			}
			@Override
			public Adapter caseEndDataPort(EndDataPort object) {
				return createEndDataPortAdapter();
			}
			@Override
			public Adapter caseStartPort(StartPort object) {
				return createStartPortAdapter();
			}
			@Override
			public Adapter caseEndPort(EndPort object) {
				return createEndPortAdapter();
			}
			@Override
			public Adapter caseIdentifiable(Identifiable object) {
				return createIdentifiableAdapter();
			}
			@Override
			public Adapter caseNameable(Nameable object) {
				return createNameableAdapter();
			}
			@Override
			public Adapter caseTriggeredEvent(TriggeredEvent object) {
				return createTriggeredEventAdapter();
			}
			@Override
			public Adapter caseTrueTransition(TrueTransition object) {
				return createTrueTransitionAdapter();
			}
			@Override
			public Adapter caseFalseTransition(FalseTransition object) {
				return createFalseTransitionAdapter();
			}
			@Override
			public Adapter caseSOAPInvoke(SOAPInvoke object) {
				return createSOAPInvokeAdapter();
			}
			@Override
			public Adapter caseXMLRPCInvoke(XMLRPCInvoke object) {
				return createXMLRPCInvokeAdapter();
			}
			@Override
			public Adapter caseLoadClassStep(LoadClassStep object) {
				return createLoadClassStepAdapter();
			}
			@Override
			public Adapter caseSeMiWaInvoke(SeMiWaInvoke object) {
				return createSeMiWaInvokeAdapter();
			}
			@Override
			public Adapter caseRESTInvoke(RESTInvoke object) {
				return createRESTInvokeAdapter();
			}
			@Override
			public Adapter caseOSGiInvoke(OSGiInvoke object) {
				return createOSGiInvokeAdapter();
			}
			@Override
			public Adapter caseSeMiWaRequest(SeMiWaRequest object) {
				return createSeMiWaRequestAdapter();
			}
			@Override
			public Adapter caseDataMapping(DataMapping object) {
				return createDataMappingAdapter();
			}
			@Override
			public Adapter caseDataDuplicationStep(DataDuplicationStep object) {
				return createDataDuplicationStepAdapter();
			}
			@Override
			public Adapter caseROSInvoke(ROSInvoke object) {
				return createROSInvokeAdapter();
			}
			@Override
			public Adapter caseAnd(And object) {
				return createAndAdapter();
			}
			@Override
			public Adapter caseCollectionType(CollectionType object) {
				return createCollectionTypeAdapter();
			}
			@Override
			public Adapter caseListType(ListType object) {
				return createListTypeAdapter();
			}
			@Override
			public Adapter caseSetType(SetType object) {
				return createSetTypeAdapter();
			}
			@Override
			public Adapter casePublishMessage(PublishMessage object) {
				return createPublishMessageAdapter();
			}
			@Override
			public Adapter casePublishROSMessage(PublishROSMessage object) {
				return createPublishROSMessageAdapter();
			}
			@Override
			public Adapter caseHumanTask(HumanTask object) {
				return createHumanTaskAdapter();
			}
			@Override
			public Adapter caseEscalationPort(EscalationPort object) {
				return createEscalationPortAdapter();
			}
			@Override
			public Adapter caseEndDataPortToStartDataPortMap(Map.Entry<EndDataPort, StartDataPort> object) {
				return createEndDataPortToStartDataPortMapAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticInvoke(OpenHabSemanticInvoke object) {
				return createOpenHabSemanticInvokeAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticSelectInvoke(OpenHabSemanticSelectInvoke object) {
				return createOpenHabSemanticSelectInvokeAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticAskInvoke(OpenHabSemanticAskInvoke object) {
				return createOpenHabSemanticAskInvokeAdapter();
			}
			@Override
			public Adapter caseOpenHabSemanticCommandInvoke(OpenHabSemanticCommandInvoke object) {
				return createOpenHabSemanticCommandInvokeAdapter();
			}
			@Override
			public Adapter caseCpsStep(CpsStep object) {
				return createCpsStepAdapter();
			}
			@Override
			public Adapter caseMapeK(MapeK object) {
				return createMapeKAdapter();
			}
			@Override
			public Adapter caseGoalInvoke(GoalInvoke object) {
				return createGoalInvokeAdapter();
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
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.If
	 * @generated
	 */
	public Adapter createIfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Or <em>Or</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Or
	 * @generated
	 */
	public Adapter createOrAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Invoke <em>Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Invoke
	 * @generated
	 */
	public Adapter createInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Process <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Process
	 * @generated
	 */
	public Adapter createProcessAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Port
	 * @generated
	 */
	public Adapter createPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DataPort <em>Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DataPort
	 * @generated
	 */
	public Adapter createDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ControlPort <em>Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ControlPort
	 * @generated
	 */
	public Adapter createControlPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ProcessStep <em>Process Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ProcessStep
	 * @generated
	 */
	public Adapter createProcessStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ComplexType <em>Complex Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ComplexType
	 * @generated
	 */
	public Adapter createComplexTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.AtomicStep <em>Atomic Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.AtomicStep
	 * @generated
	 */
	public Adapter createAtomicStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.CompositeStep <em>Composite Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.CompositeStep
	 * @generated
	 */
	public Adapter createCompositeStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DataType
	 * @generated
	 */
	public Adapter createDataTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.SimpleType <em>Simple Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.SimpleType
	 * @generated
	 */
	public Adapter createSimpleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.NumericType <em>Numeric Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.NumericType
	 * @generated
	 */
	public Adapter createNumericTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.IntegerType
	 * @generated
	 */
	public Adapter createIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DoubleType
	 * @generated
	 */
	public Adapter createDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Loop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Loop
	 * @generated
	 */
	public Adapter createLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.RepeatLoop <em>Repeat Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.RepeatLoop
	 * @generated
	 */
	public Adapter createRepeatLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.WhileLoop <em>While Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.WhileLoop
	 * @generated
	 */
	public Adapter createWhileLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ForLoop <em>For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ForLoop
	 * @generated
	 */
	public Adapter createForLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ProcessSlot <em>Process Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ProcessSlot
	 * @generated
	 */
	public Adapter createProcessSlotAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DataMappingStep <em>Data Mapping Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DataMappingStep
	 * @generated
	 */
	public Adapter createDataMappingStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.StartControlPort <em>Start Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.StartControlPort
	 * @generated
	 */
	public Adapter createStartControlPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.EndControlPort <em>End Control Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.EndControlPort
	 * @generated
	 */
	public Adapter createEndControlPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.StartDataPort <em>Start Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.StartDataPort
	 * @generated
	 */
	public Adapter createStartDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.EndDataPort <em>End Data Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.EndDataPort
	 * @generated
	 */
	public Adapter createEndDataPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.StartPort <em>Start Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.StartPort
	 * @generated
	 */
	public Adapter createStartPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.EndPort <em>End Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.EndPort
	 * @generated
	 */
	public Adapter createEndPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Identifiable <em>Identifiable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Identifiable
	 * @generated
	 */
	public Adapter createIdentifiableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.Nameable <em>Nameable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.Nameable
	 * @generated
	 */
	public Adapter createNameableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.TriggeredEvent <em>Triggered Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.TriggeredEvent
	 * @generated
	 */
	public Adapter createTriggeredEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.TrueTransition <em>True Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.TrueTransition
	 * @generated
	 */
	public Adapter createTrueTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.FalseTransition <em>False Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.FalseTransition
	 * @generated
	 */
	public Adapter createFalseTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.SOAPInvoke <em>SOAP Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.SOAPInvoke
	 * @generated
	 */
	public Adapter createSOAPInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.XMLRPCInvoke <em>XMLRPC Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.XMLRPCInvoke
	 * @generated
	 */
	public Adapter createXMLRPCInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.LoadClassStep <em>Load Class Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.LoadClassStep
	 * @generated
	 */
	public Adapter createLoadClassStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.SeMiWaInvoke <em>Se Mi Wa Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.SeMiWaInvoke
	 * @generated
	 */
	public Adapter createSeMiWaInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.RESTInvoke <em>REST Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.RESTInvoke
	 * @generated
	 */
	public Adapter createRESTInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.OSGiInvoke <em>OS Gi Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.OSGiInvoke
	 * @generated
	 */
	public Adapter createOSGiInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.SeMiWaRequest <em>Se Mi Wa Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.SeMiWaRequest
	 * @generated
	 */
	public Adapter createSeMiWaRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DataMapping <em>Data Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DataMapping
	 * @generated
	 */
	public Adapter createDataMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.DataDuplicationStep <em>Data Duplication Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.DataDuplicationStep
	 * @generated
	 */
	public Adapter createDataDuplicationStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ROSInvoke <em>ROS Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ROSInvoke
	 * @generated
	 */
	public Adapter createROSInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.And <em>And</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.And
	 * @generated
	 */
	public Adapter createAndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.CollectionType <em>Collection Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.CollectionType
	 * @generated
	 */
	public Adapter createCollectionTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.ListType <em>List Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.ListType
	 * @generated
	 */
	public Adapter createListTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.SetType <em>Set Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.SetType
	 * @generated
	 */
	public Adapter createSetTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.PublishMessage <em>Publish Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.PublishMessage
	 * @generated
	 */
	public Adapter createPublishMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.PublishROSMessage <em>Publish ROS Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.PublishROSMessage
	 * @generated
	 */
	public Adapter createPublishROSMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.HumanTask <em>Human Task</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.HumanTask
	 * @generated
	 */
	public Adapter createHumanTaskAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.EscalationPort <em>Escalation Port</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.EscalationPort
	 * @generated
	 */
	public Adapter createEscalationPortAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link java.util.Map.Entry <em>End Data Port To Start Data Port Map</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see java.util.Map.Entry
	 * @generated
	 */
	public Adapter createEndDataPortToStartDataPortMapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.OpenHabSemanticInvoke <em>Open Hab Semantic Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticInvoke
	 * @generated
	 */
	public Adapter createOpenHabSemanticInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke <em>Open Hab Semantic Select Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticSelectInvoke
	 * @generated
	 */
	public Adapter createOpenHabSemanticSelectInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke <em>Open Hab Semantic Ask Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticAskInvoke
	 * @generated
	 */
	public Adapter createOpenHabSemanticAskInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke <em>Open Hab Semantic Command Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.OpenHabSemanticCommandInvoke
	 * @generated
	 */
	public Adapter createOpenHabSemanticCommandInvokeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.CpsStep <em>Cps Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.CpsStep
	 * @generated
	 */
	public Adapter createCpsStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.MapeK <em>Mape K</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.MapeK
	 * @generated
	 */
	public Adapter createMapeKAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.model.sofia.GoalInvoke <em>Goal Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.model.sofia.GoalInvoke
	 * @generated
	 */
	public Adapter createGoalInvokeAdapter() {
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

} //SofiaAdapterFactory
