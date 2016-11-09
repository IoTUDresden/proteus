/**
 */
package eu.vicci.process.model.sofiainstance.util;

import eu.vicci.process.model.sofiainstance.*;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage
 * @generated
 */
public class SofiaInstanceSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SofiaInstancePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaInstanceSwitch() {
		if (modelPackage == null) {
			modelPackage = SofiaInstancePackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SofiaInstancePackage.PROCESS_INSTANCE: {
				ProcessInstance processInstance = (ProcessInstance)theEObject;
				T result = caseProcessInstance(processInstance);
				if (result == null) result = caseProcessStepInstance(processInstance);
				if (result == null) result = caseStateful(processInstance);
				if (result == null) result = caseInstanceIdentifiable(processInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE: {
				ProcessStepInstance processStepInstance = (ProcessStepInstance)theEObject;
				T result = caseProcessStepInstance(processStepInstance);
				if (result == null) result = caseStateful(processStepInstance);
				if (result == null) result = caseInstanceIdentifiable(processStepInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.STATEFUL: {
				Stateful stateful = (Stateful)theEObject;
				T result = caseStateful(stateful);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.PORT_INSTANCE: {
				PortInstance portInstance = (PortInstance)theEObject;
				T result = casePortInstance(portInstance);
				if (result == null) result = caseStateful(portInstance);
				if (result == null) result = caseInstanceIdentifiable(portInstance);
				if (result == null) result = caseNameable(portInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.INSTANCE_IDENTIFIABLE: {
				InstanceIdentifiable instanceIdentifiable = (InstanceIdentifiable)theEObject;
				T result = caseInstanceIdentifiable(instanceIdentifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.EVENT_INSTANCE: {
				EventInstance eventInstance = (EventInstance)theEObject;
				T result = caseEventInstance(eventInstance);
				if (result == null) result = caseProcessStepInstance(eventInstance);
				if (result == null) result = caseStateful(eventInstance);
				if (result == null) result = caseInstanceIdentifiable(eventInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.STRING_TYPE_INSTANCE: {
				StringTypeInstance stringTypeInstance = (StringTypeInstance)theEObject;
				T result = caseStringTypeInstance(stringTypeInstance);
				if (result == null) result = caseDataTypeInstance(stringTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(stringTypeInstance);
				if (result == null) result = caseNameable(stringTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE: {
				IntegerTypeInstance integerTypeInstance = (IntegerTypeInstance)theEObject;
				T result = caseIntegerTypeInstance(integerTypeInstance);
				if (result == null) result = caseDataTypeInstance(integerTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(integerTypeInstance);
				if (result == null) result = caseNameable(integerTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE: {
				DoubleTypeInstance doubleTypeInstance = (DoubleTypeInstance)theEObject;
				T result = caseDoubleTypeInstance(doubleTypeInstance);
				if (result == null) result = caseDataTypeInstance(doubleTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(doubleTypeInstance);
				if (result == null) result = caseNameable(doubleTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE: {
				BooleanTypeInstance booleanTypeInstance = (BooleanTypeInstance)theEObject;
				T result = caseBooleanTypeInstance(booleanTypeInstance);
				if (result == null) result = caseDataTypeInstance(booleanTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(booleanTypeInstance);
				if (result == null) result = caseNameable(booleanTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.TRANSITION_INSTANCE: {
				TransitionInstance transitionInstance = (TransitionInstance)theEObject;
				T result = caseTransitionInstance(transitionInstance);
				if (result == null) result = caseInstanceIdentifiable(transitionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.DATA_PORT_INSTANCE: {
				DataPortInstance dataPortInstance = (DataPortInstance)theEObject;
				T result = caseDataPortInstance(dataPortInstance);
				if (result == null) result = casePortInstance(dataPortInstance);
				if (result == null) result = caseStateful(dataPortInstance);
				if (result == null) result = caseInstanceIdentifiable(dataPortInstance);
				if (result == null) result = caseNameable(dataPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.CONTROL_PORT_INSTANCE: {
				ControlPortInstance controlPortInstance = (ControlPortInstance)theEObject;
				T result = caseControlPortInstance(controlPortInstance);
				if (result == null) result = casePortInstance(controlPortInstance);
				if (result == null) result = caseStateful(controlPortInstance);
				if (result == null) result = caseInstanceIdentifiable(controlPortInstance);
				if (result == null) result = caseNameable(controlPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.START_PORT_INSTANCE: {
				StartPortInstance startPortInstance = (StartPortInstance)theEObject;
				T result = caseStartPortInstance(startPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.END_PORT_INSTANCE: {
				EndPortInstance endPortInstance = (EndPortInstance)theEObject;
				T result = caseEndPortInstance(endPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.START_CONTROL_PORT_INSTANCE: {
				StartControlPortInstance startControlPortInstance = (StartControlPortInstance)theEObject;
				T result = caseStartControlPortInstance(startControlPortInstance);
				if (result == null) result = caseControlPortInstance(startControlPortInstance);
				if (result == null) result = caseStartPortInstance(startControlPortInstance);
				if (result == null) result = casePortInstance(startControlPortInstance);
				if (result == null) result = caseStateful(startControlPortInstance);
				if (result == null) result = caseInstanceIdentifiable(startControlPortInstance);
				if (result == null) result = caseNameable(startControlPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.START_DATA_PORT_INSTANCE: {
				StartDataPortInstance startDataPortInstance = (StartDataPortInstance)theEObject;
				T result = caseStartDataPortInstance(startDataPortInstance);
				if (result == null) result = caseDataPortInstance(startDataPortInstance);
				if (result == null) result = caseStartPortInstance(startDataPortInstance);
				if (result == null) result = casePortInstance(startDataPortInstance);
				if (result == null) result = caseStateful(startDataPortInstance);
				if (result == null) result = caseInstanceIdentifiable(startDataPortInstance);
				if (result == null) result = caseNameable(startDataPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.END_CONTROL_PORT_INSTANCE: {
				EndControlPortInstance endControlPortInstance = (EndControlPortInstance)theEObject;
				T result = caseEndControlPortInstance(endControlPortInstance);
				if (result == null) result = caseControlPortInstance(endControlPortInstance);
				if (result == null) result = caseEndPortInstance(endControlPortInstance);
				if (result == null) result = casePortInstance(endControlPortInstance);
				if (result == null) result = caseStateful(endControlPortInstance);
				if (result == null) result = caseInstanceIdentifiable(endControlPortInstance);
				if (result == null) result = caseNameable(endControlPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.END_DATA_PORT_INSTANCE: {
				EndDataPortInstance endDataPortInstance = (EndDataPortInstance)theEObject;
				T result = caseEndDataPortInstance(endDataPortInstance);
				if (result == null) result = caseDataPortInstance(endDataPortInstance);
				if (result == null) result = caseEndPortInstance(endDataPortInstance);
				if (result == null) result = casePortInstance(endDataPortInstance);
				if (result == null) result = caseStateful(endDataPortInstance);
				if (result == null) result = caseInstanceIdentifiable(endDataPortInstance);
				if (result == null) result = caseNameable(endDataPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.DATA_TYPE_INSTANCE: {
				DataTypeInstance dataTypeInstance = (DataTypeInstance)theEObject;
				T result = caseDataTypeInstance(dataTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(dataTypeInstance);
				if (result == null) result = caseNameable(dataTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = caseInstanceIdentifiable(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.MAPPING_UTIL: {
				MappingUtil mappingUtil = (MappingUtil)theEObject;
				T result = caseMappingUtil(mappingUtil);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.IF_INSTANCE: {
				IfInstance ifInstance = (IfInstance)theEObject;
				T result = caseIfInstance(ifInstance);
				if (result == null) result = caseProcessStepInstance(ifInstance);
				if (result == null) result = caseStateful(ifInstance);
				if (result == null) result = caseInstanceIdentifiable(ifInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.CONDITION_INSTANCE: {
				ConditionInstance conditionInstance = (ConditionInstance)theEObject;
				T result = caseConditionInstance(conditionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.TRUE_TRANSITION_INSTANCE: {
				TrueTransitionInstance trueTransitionInstance = (TrueTransitionInstance)theEObject;
				T result = caseTrueTransitionInstance(trueTransitionInstance);
				if (result == null) result = caseTransitionInstance(trueTransitionInstance);
				if (result == null) result = caseInstanceIdentifiable(trueTransitionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.FALSE_TRANSITION_INSTANCE: {
				FalseTransitionInstance falseTransitionInstance = (FalseTransitionInstance)theEObject;
				T result = caseFalseTransitionInstance(falseTransitionInstance);
				if (result == null) result = caseTransitionInstance(falseTransitionInstance);
				if (result == null) result = caseInstanceIdentifiable(falseTransitionInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.COMPLEX_TYPE_INSTANCE: {
				ComplexTypeInstance complexTypeInstance = (ComplexTypeInstance)theEObject;
				T result = caseComplexTypeInstance(complexTypeInstance);
				if (result == null) result = caseDataTypeInstance(complexTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(complexTypeInstance);
				if (result == null) result = caseNameable(complexTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.LIST_TYPE_INSTANCE: {
				ListTypeInstance listTypeInstance = (ListTypeInstance)theEObject;
				T result = caseListTypeInstance(listTypeInstance);
				if (result == null) result = caseCollectionTypeInstance(listTypeInstance);
				if (result == null) result = caseComplexTypeInstance(listTypeInstance);
				if (result == null) result = caseDataTypeInstance(listTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(listTypeInstance);
				if (result == null) result = caseNameable(listTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE: {
				CollectionTypeInstance collectionTypeInstance = (CollectionTypeInstance)theEObject;
				T result = caseCollectionTypeInstance(collectionTypeInstance);
				if (result == null) result = caseComplexTypeInstance(collectionTypeInstance);
				if (result == null) result = caseDataTypeInstance(collectionTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(collectionTypeInstance);
				if (result == null) result = caseNameable(collectionTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.SET_TYPE_INSTANCE: {
				SetTypeInstance setTypeInstance = (SetTypeInstance)theEObject;
				T result = caseSetTypeInstance(setTypeInstance);
				if (result == null) result = caseCollectionTypeInstance(setTypeInstance);
				if (result == null) result = caseComplexTypeInstance(setTypeInstance);
				if (result == null) result = caseDataTypeInstance(setTypeInstance);
				if (result == null) result = caseInstanceIdentifiable(setTypeInstance);
				if (result == null) result = caseNameable(setTypeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.NAMEABLE: {
				Nameable nameable = (Nameable)theEObject;
				T result = caseNameable(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE: {
				EscalationPortInstance escalationPortInstance = (EscalationPortInstance)theEObject;
				T result = caseEscalationPortInstance(escalationPortInstance);
				if (result == null) result = caseEndControlPortInstance(escalationPortInstance);
				if (result == null) result = caseControlPortInstance(escalationPortInstance);
				if (result == null) result = caseEndPortInstance(escalationPortInstance);
				if (result == null) result = casePortInstance(escalationPortInstance);
				if (result == null) result = caseStateful(escalationPortInstance);
				if (result == null) result = caseInstanceIdentifiable(escalationPortInstance);
				if (result == null) result = caseNameable(escalationPortInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.LOOP_INSTANCE: {
				LoopInstance loopInstance = (LoopInstance)theEObject;
				T result = caseLoopInstance(loopInstance);
				if (result == null) result = caseProcessStepInstance(loopInstance);
				if (result == null) result = caseStateful(loopInstance);
				if (result == null) result = caseInstanceIdentifiable(loopInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.FOR_LOOP_INSTANCE: {
				ForLoopInstance forLoopInstance = (ForLoopInstance)theEObject;
				T result = caseForLoopInstance(forLoopInstance);
				if (result == null) result = caseLoopInstance(forLoopInstance);
				if (result == null) result = caseProcessStepInstance(forLoopInstance);
				if (result == null) result = caseStateful(forLoopInstance);
				if (result == null) result = caseInstanceIdentifiable(forLoopInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.AND_INSTANCE: {
				AndInstance andInstance = (AndInstance)theEObject;
				T result = caseAndInstance(andInstance);
				if (result == null) result = caseProcessStepInstance(andInstance);
				if (result == null) result = caseStateful(andInstance);
				if (result == null) result = caseInstanceIdentifiable(andInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OR_INSTANCE: {
				OrInstance orInstance = (OrInstance)theEObject;
				T result = caseOrInstance(orInstance);
				if (result == null) result = caseProcessStepInstance(orInstance);
				if (result == null) result = caseStateful(orInstance);
				if (result == null) result = caseInstanceIdentifiable(orInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.ROS_INVOKE_INSTANCE: {
				ROSInvokeInstance rosInvokeInstance = (ROSInvokeInstance)theEObject;
				T result = caseROSInvokeInstance(rosInvokeInstance);
				if (result == null) result = caseProcessStepInstance(rosInvokeInstance);
				if (result == null) result = caseStateful(rosInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(rosInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.PROCESS_SLOT_INSTANCE: {
				ProcessSlotInstance processSlotInstance = (ProcessSlotInstance)theEObject;
				T result = caseProcessSlotInstance(processSlotInstance);
				if (result == null) result = caseProcessStepInstance(processSlotInstance);
				if (result == null) result = caseStateful(processSlotInstance);
				if (result == null) result = caseInstanceIdentifiable(processSlotInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.DATA_DUPLICATION_STEP_INSTANCE: {
				DataDuplicationStepInstance dataDuplicationStepInstance = (DataDuplicationStepInstance)theEObject;
				T result = caseDataDuplicationStepInstance(dataDuplicationStepInstance);
				if (result == null) result = caseProcessStepInstance(dataDuplicationStepInstance);
				if (result == null) result = caseStateful(dataDuplicationStepInstance);
				if (result == null) result = caseInstanceIdentifiable(dataDuplicationStepInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.REST_INVOKE_INSTANCE: {
				RESTInvokeInstance restInvokeInstance = (RESTInvokeInstance)theEObject;
				T result = caseRESTInvokeInstance(restInvokeInstance);
				if (result == null) result = caseProcessStepInstance(restInvokeInstance);
				if (result == null) result = caseStateful(restInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(restInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OS_GI_INVOKE_INSTANCE: {
				OSGiInvokeInstance osGiInvokeInstance = (OSGiInvokeInstance)theEObject;
				T result = caseOSGiInvokeInstance(osGiInvokeInstance);
				if (result == null) result = caseProcessStepInstance(osGiInvokeInstance);
				if (result == null) result = caseStateful(osGiInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(osGiInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.SOAP_INVOKE_INSTANCE: {
				SOAPInvokeInstance soapInvokeInstance = (SOAPInvokeInstance)theEObject;
				T result = caseSOAPInvokeInstance(soapInvokeInstance);
				if (result == null) result = caseProcessStepInstance(soapInvokeInstance);
				if (result == null) result = caseStateful(soapInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(soapInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.HUMAN_TASK_INSTANCE: {
				HumanTaskInstance humanTaskInstance = (HumanTaskInstance)theEObject;
				T result = caseHumanTaskInstance(humanTaskInstance);
				if (result == null) result = caseProcessStepInstance(humanTaskInstance);
				if (result == null) result = caseStateful(humanTaskInstance);
				if (result == null) result = caseInstanceIdentifiable(humanTaskInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.LOAD_CLASS_STEP_INSTANCE: {
				LoadClassStepInstance loadClassStepInstance = (LoadClassStepInstance)theEObject;
				T result = caseLoadClassStepInstance(loadClassStepInstance);
				if (result == null) result = caseProcessStepInstance(loadClassStepInstance);
				if (result == null) result = caseStateful(loadClassStepInstance);
				if (result == null) result = caseInstanceIdentifiable(loadClassStepInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.SE_MI_WA_INVOKE_INSTANCE: {
				SeMiWaInvokeInstance seMiWaInvokeInstance = (SeMiWaInvokeInstance)theEObject;
				T result = caseSeMiWaInvokeInstance(seMiWaInvokeInstance);
				if (result == null) result = caseProcessStepInstance(seMiWaInvokeInstance);
				if (result == null) result = caseStateful(seMiWaInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(seMiWaInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.TRIGGERED_EVENT_INSTANCE: {
				TriggeredEventInstance triggeredEventInstance = (TriggeredEventInstance)theEObject;
				T result = caseTriggeredEventInstance(triggeredEventInstance);
				if (result == null) result = caseProcessStepInstance(triggeredEventInstance);
				if (result == null) result = caseStateful(triggeredEventInstance);
				if (result == null) result = caseInstanceIdentifiable(triggeredEventInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.XMLRPC_INVOKE_INSTANCE: {
				XMLRPCInvokeInstance xmlrpcInvokeInstance = (XMLRPCInvokeInstance)theEObject;
				T result = caseXMLRPCInvokeInstance(xmlrpcInvokeInstance);
				if (result == null) result = caseProcessStepInstance(xmlrpcInvokeInstance);
				if (result == null) result = caseStateful(xmlrpcInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(xmlrpcInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.SE_MI_WA_REQUEST_INSTANCE: {
				SeMiWaRequestInstance seMiWaRequestInstance = (SeMiWaRequestInstance)theEObject;
				T result = caseSeMiWaRequestInstance(seMiWaRequestInstance);
				if (result == null) result = caseProcessStepInstance(seMiWaRequestInstance);
				if (result == null) result = caseStateful(seMiWaRequestInstance);
				if (result == null) result = caseInstanceIdentifiable(seMiWaRequestInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.DATA_MAPPING_STEP_INSTANCE: {
				DataMappingStepInstance dataMappingStepInstance = (DataMappingStepInstance)theEObject;
				T result = caseDataMappingStepInstance(dataMappingStepInstance);
				if (result == null) result = caseProcessStepInstance(dataMappingStepInstance);
				if (result == null) result = caseStateful(dataMappingStepInstance);
				if (result == null) result = caseInstanceIdentifiable(dataMappingStepInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.WHILE_LOOP_INSTANCE: {
				WhileLoopInstance whileLoopInstance = (WhileLoopInstance)theEObject;
				T result = caseWhileLoopInstance(whileLoopInstance);
				if (result == null) result = caseLoopInstance(whileLoopInstance);
				if (result == null) result = caseProcessStepInstance(whileLoopInstance);
				if (result == null) result = caseStateful(whileLoopInstance);
				if (result == null) result = caseInstanceIdentifiable(whileLoopInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE: {
				@SuppressWarnings("unchecked") Map.Entry<EndDataPortInstance, StartDataPortInstance> endDataPortToStartDataPortMapInstance = (Map.Entry<EndDataPortInstance, StartDataPortInstance>)theEObject;
				T result = caseEndDataPortToStartDataPortMapInstance(endDataPortToStartDataPortMapInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OPEN_HAB_SEMANTIC_INVOKE_INSTANCE: {
				OpenHabSemanticInvokeInstance openHabSemanticInvokeInstance = (OpenHabSemanticInvokeInstance)theEObject;
				T result = caseOpenHabSemanticInvokeInstance(openHabSemanticInvokeInstance);
				if (result == null) result = caseProcessStepInstance(openHabSemanticInvokeInstance);
				if (result == null) result = caseStateful(openHabSemanticInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(openHabSemanticInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OPEN_HAB_SEMANTIC_SELECT_INVOKE_INSTANCE: {
				OpenHabSemanticSelectInvokeInstance openHabSemanticSelectInvokeInstance = (OpenHabSemanticSelectInvokeInstance)theEObject;
				T result = caseOpenHabSemanticSelectInvokeInstance(openHabSemanticSelectInvokeInstance);
				if (result == null) result = caseOpenHabSemanticInvokeInstance(openHabSemanticSelectInvokeInstance);
				if (result == null) result = caseProcessStepInstance(openHabSemanticSelectInvokeInstance);
				if (result == null) result = caseStateful(openHabSemanticSelectInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(openHabSemanticSelectInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OPEN_HAB_SEMANTIC_ASK_INVOKE_INSTANCE: {
				OpenHabSemanticAskInvokeInstance openHabSemanticAskInvokeInstance = (OpenHabSemanticAskInvokeInstance)theEObject;
				T result = caseOpenHabSemanticAskInvokeInstance(openHabSemanticAskInvokeInstance);
				if (result == null) result = caseOpenHabSemanticInvokeInstance(openHabSemanticAskInvokeInstance);
				if (result == null) result = caseProcessStepInstance(openHabSemanticAskInvokeInstance);
				if (result == null) result = caseStateful(openHabSemanticAskInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(openHabSemanticAskInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.OPEN_HAB_SEMANTIC_COMMAND_INVOKE_INSTANCE: {
				OpenHabSemanticCommandInvokeInstance openHabSemanticCommandInvokeInstance = (OpenHabSemanticCommandInvokeInstance)theEObject;
				T result = caseOpenHabSemanticCommandInvokeInstance(openHabSemanticCommandInvokeInstance);
				if (result == null) result = caseOpenHabSemanticInvokeInstance(openHabSemanticCommandInvokeInstance);
				if (result == null) result = caseProcessStepInstance(openHabSemanticCommandInvokeInstance);
				if (result == null) result = caseStateful(openHabSemanticCommandInvokeInstance);
				if (result == null) result = caseInstanceIdentifiable(openHabSemanticCommandInvokeInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaInstancePackage.MAPE_KINSTANCE: {
				MapeKInstance mapeKInstance = (MapeKInstance)theEObject;
				T result = caseMapeKInstance(mapeKInstance);
				if (result == null) result = caseProcessStepInstance(mapeKInstance);
				if (result == null) result = caseStateful(mapeKInstance);
				if (result == null) result = caseInstanceIdentifiable(mapeKInstance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessInstance(ProcessInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Step Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Step Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessStepInstance(ProcessStepInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stateful</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stateful</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateful(Stateful object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortInstance(PortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstanceIdentifiable(InstanceIdentifiable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventInstance(EventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringTypeInstance(StringTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerTypeInstance(IntegerTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleTypeInstance(DoubleTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanTypeInstance(BooleanTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionInstance(TransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPortInstance(DataPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlPortInstance(ControlPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartPortInstance(StartPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndPortInstance(EndPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Control Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Control Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartControlPortInstance(StartControlPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Data Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Data Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartDataPortInstance(StartDataPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Control Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Control Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndControlPortInstance(EndControlPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Data Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Data Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndDataPortInstance(EndDataPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataTypeInstance(DataTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapping Util</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapping Util</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMappingUtil(MappingUtil object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfInstance(IfInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionInstance(ConditionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueTransitionInstance(TrueTransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Transition Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseTransitionInstance(FalseTransitionInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexTypeInstance(ComplexTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListTypeInstance(ListTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeInstance(CollectionTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetTypeInstance(SetTypeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nameable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNameable(Nameable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Escalation Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Escalation Port Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEscalationPortInstance(EscalationPortInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopInstance(LoopInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Loop Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Loop Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForLoopInstance(ForLoopInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndInstance(AndInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrInstance(OrInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ROS Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ROS Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseROSInvokeInstance(ROSInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Slot Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Slot Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSlotInstance(ProcessSlotInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Duplication Step Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Duplication Step Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataDuplicationStepInstance(DataDuplicationStepInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>REST Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>REST Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRESTInvokeInstance(RESTInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OS Gi Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OS Gi Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOSGiInvokeInstance(OSGiInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SOAP Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SOAP Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSOAPInvokeInstance(SOAPInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human Task Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human Task Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHumanTaskInstance(HumanTaskInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Class Step Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Class Step Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadClassStepInstance(LoadClassStepInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Se Mi Wa Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Se Mi Wa Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeMiWaInvokeInstance(SeMiWaInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Triggered Event Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Triggered Event Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriggeredEventInstance(TriggeredEventInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMLRPC Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMLRPC Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMLRPCInvokeInstance(XMLRPCInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Se Mi Wa Request Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Se Mi Wa Request Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeMiWaRequestInstance(SeMiWaRequestInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapping Step Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapping Step Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMappingStepInstance(DataMappingStepInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Loop Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Loop Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileLoopInstance(WhileLoopInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Data Port To Start Data Port Map Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Data Port To Start Data Port Map Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndDataPortToStartDataPortMapInstance(Map.Entry<EndDataPortInstance, StartDataPortInstance> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticInvokeInstance(OpenHabSemanticInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Select Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Select Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticSelectInvokeInstance(OpenHabSemanticSelectInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Ask Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Ask Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticAskInvokeInstance(OpenHabSemanticAskInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Command Invoke Instance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Command Invoke Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticCommandInvokeInstance(OpenHabSemanticCommandInvokeInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mape KInstance</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mape KInstance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapeKInstance(MapeKInstance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //SofiaInstanceSwitch
