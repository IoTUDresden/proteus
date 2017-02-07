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
 * @see eu.vicci.process.model.sofia.SofiaPackage
 * @generated
 */
public class SofiaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SofiaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiaSwitch() {
		if (modelPackage == null) {
			modelPackage = SofiaPackage.eINSTANCE;
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
			case SofiaPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseIdentifiable(transition);
				if (result == null) result = caseNameable(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.IF: {
				If if_ = (If)theEObject;
				T result = caseIf(if_);
				if (result == null) result = caseAtomicStep(if_);
				if (result == null) result = caseProcessStep(if_);
				if (result == null) result = caseIdentifiable(if_);
				if (result == null) result = caseNameable(if_);
				if (result == null) result = caseCpsStep(if_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OR: {
				Or or = (Or)theEObject;
				T result = caseOr(or);
				if (result == null) result = caseAtomicStep(or);
				if (result == null) result = caseProcessStep(or);
				if (result == null) result = caseIdentifiable(or);
				if (result == null) result = caseNameable(or);
				if (result == null) result = caseCpsStep(or);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.INVOKE: {
				Invoke invoke = (Invoke)theEObject;
				T result = caseInvoke(invoke);
				if (result == null) result = caseAtomicStep(invoke);
				if (result == null) result = caseProcessStep(invoke);
				if (result == null) result = caseIdentifiable(invoke);
				if (result == null) result = caseNameable(invoke);
				if (result == null) result = caseCpsStep(invoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.EVENT: {
				Event event = (Event)theEObject;
				T result = caseEvent(event);
				if (result == null) result = caseAtomicStep(event);
				if (result == null) result = caseProcessStep(event);
				if (result == null) result = caseIdentifiable(event);
				if (result == null) result = caseNameable(event);
				if (result == null) result = caseCpsStep(event);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PROCESS: {
				eu.vicci.process.model.sofia.Process process = (eu.vicci.process.model.sofia.Process)theEObject;
				T result = caseProcess(process);
				if (result == null) result = caseCompositeStep(process);
				if (result == null) result = caseProcessStep(process);
				if (result == null) result = caseIdentifiable(process);
				if (result == null) result = caseNameable(process);
				if (result == null) result = caseCpsStep(process);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PORT: {
				Port port = (Port)theEObject;
				T result = casePort(port);
				if (result == null) result = caseIdentifiable(port);
				if (result == null) result = caseNameable(port);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DATA_PORT: {
				DataPort dataPort = (DataPort)theEObject;
				T result = caseDataPort(dataPort);
				if (result == null) result = casePort(dataPort);
				if (result == null) result = caseIdentifiable(dataPort);
				if (result == null) result = caseNameable(dataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.CONTROL_PORT: {
				ControlPort controlPort = (ControlPort)theEObject;
				T result = caseControlPort(controlPort);
				if (result == null) result = casePort(controlPort);
				if (result == null) result = caseIdentifiable(controlPort);
				if (result == null) result = caseNameable(controlPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PROCESS_STEP: {
				ProcessStep processStep = (ProcessStep)theEObject;
				T result = caseProcessStep(processStep);
				if (result == null) result = caseIdentifiable(processStep);
				if (result == null) result = caseNameable(processStep);
				if (result == null) result = caseCpsStep(processStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.COMPLEX_TYPE: {
				ComplexType complexType = (ComplexType)theEObject;
				T result = caseComplexType(complexType);
				if (result == null) result = caseDataType(complexType);
				if (result == null) result = caseNameable(complexType);
				if (result == null) result = caseIdentifiable(complexType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.ATOMIC_STEP: {
				AtomicStep atomicStep = (AtomicStep)theEObject;
				T result = caseAtomicStep(atomicStep);
				if (result == null) result = caseProcessStep(atomicStep);
				if (result == null) result = caseIdentifiable(atomicStep);
				if (result == null) result = caseNameable(atomicStep);
				if (result == null) result = caseCpsStep(atomicStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.COMPOSITE_STEP: {
				CompositeStep compositeStep = (CompositeStep)theEObject;
				T result = caseCompositeStep(compositeStep);
				if (result == null) result = caseProcessStep(compositeStep);
				if (result == null) result = caseIdentifiable(compositeStep);
				if (result == null) result = caseNameable(compositeStep);
				if (result == null) result = caseCpsStep(compositeStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DATA_TYPE: {
				DataType dataType = (DataType)theEObject;
				T result = caseDataType(dataType);
				if (result == null) result = caseNameable(dataType);
				if (result == null) result = caseIdentifiable(dataType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.SIMPLE_TYPE: {
				SimpleType simpleType = (SimpleType)theEObject;
				T result = caseSimpleType(simpleType);
				if (result == null) result = caseDataType(simpleType);
				if (result == null) result = caseNameable(simpleType);
				if (result == null) result = caseIdentifiable(simpleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.STRING_TYPE: {
				StringType stringType = (StringType)theEObject;
				T result = caseStringType(stringType);
				if (result == null) result = caseSimpleType(stringType);
				if (result == null) result = caseDataType(stringType);
				if (result == null) result = caseNameable(stringType);
				if (result == null) result = caseIdentifiable(stringType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.NUMERIC_TYPE: {
				NumericType numericType = (NumericType)theEObject;
				T result = caseNumericType(numericType);
				if (result == null) result = caseSimpleType(numericType);
				if (result == null) result = caseDataType(numericType);
				if (result == null) result = caseNameable(numericType);
				if (result == null) result = caseIdentifiable(numericType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.BOOLEAN_TYPE: {
				BooleanType booleanType = (BooleanType)theEObject;
				T result = caseBooleanType(booleanType);
				if (result == null) result = caseSimpleType(booleanType);
				if (result == null) result = caseDataType(booleanType);
				if (result == null) result = caseNameable(booleanType);
				if (result == null) result = caseIdentifiable(booleanType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.INTEGER_TYPE: {
				IntegerType integerType = (IntegerType)theEObject;
				T result = caseIntegerType(integerType);
				if (result == null) result = caseNumericType(integerType);
				if (result == null) result = caseSimpleType(integerType);
				if (result == null) result = caseDataType(integerType);
				if (result == null) result = caseNameable(integerType);
				if (result == null) result = caseIdentifiable(integerType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DOUBLE_TYPE: {
				DoubleType doubleType = (DoubleType)theEObject;
				T result = caseDoubleType(doubleType);
				if (result == null) result = caseNumericType(doubleType);
				if (result == null) result = caseSimpleType(doubleType);
				if (result == null) result = caseDataType(doubleType);
				if (result == null) result = caseNameable(doubleType);
				if (result == null) result = caseIdentifiable(doubleType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.LOOP: {
				Loop loop = (Loop)theEObject;
				T result = caseLoop(loop);
				if (result == null) result = caseCompositeStep(loop);
				if (result == null) result = caseProcessStep(loop);
				if (result == null) result = caseIdentifiable(loop);
				if (result == null) result = caseNameable(loop);
				if (result == null) result = caseCpsStep(loop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.REPEAT_LOOP: {
				RepeatLoop repeatLoop = (RepeatLoop)theEObject;
				T result = caseRepeatLoop(repeatLoop);
				if (result == null) result = caseLoop(repeatLoop);
				if (result == null) result = caseCompositeStep(repeatLoop);
				if (result == null) result = caseProcessStep(repeatLoop);
				if (result == null) result = caseIdentifiable(repeatLoop);
				if (result == null) result = caseNameable(repeatLoop);
				if (result == null) result = caseCpsStep(repeatLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.WHILE_LOOP: {
				WhileLoop whileLoop = (WhileLoop)theEObject;
				T result = caseWhileLoop(whileLoop);
				if (result == null) result = caseLoop(whileLoop);
				if (result == null) result = caseCompositeStep(whileLoop);
				if (result == null) result = caseProcessStep(whileLoop);
				if (result == null) result = caseIdentifiable(whileLoop);
				if (result == null) result = caseNameable(whileLoop);
				if (result == null) result = caseCpsStep(whileLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.FOR_LOOP: {
				ForLoop forLoop = (ForLoop)theEObject;
				T result = caseForLoop(forLoop);
				if (result == null) result = caseLoop(forLoop);
				if (result == null) result = caseCompositeStep(forLoop);
				if (result == null) result = caseProcessStep(forLoop);
				if (result == null) result = caseIdentifiable(forLoop);
				if (result == null) result = caseNameable(forLoop);
				if (result == null) result = caseCpsStep(forLoop);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PROCESS_SLOT: {
				ProcessSlot processSlot = (ProcessSlot)theEObject;
				T result = caseProcessSlot(processSlot);
				if (result == null) result = caseAtomicStep(processSlot);
				if (result == null) result = caseProcessStep(processSlot);
				if (result == null) result = caseIdentifiable(processSlot);
				if (result == null) result = caseNameable(processSlot);
				if (result == null) result = caseCpsStep(processSlot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DATA_MAPPING_STEP: {
				DataMappingStep dataMappingStep = (DataMappingStep)theEObject;
				T result = caseDataMappingStep(dataMappingStep);
				if (result == null) result = caseAtomicStep(dataMappingStep);
				if (result == null) result = caseProcessStep(dataMappingStep);
				if (result == null) result = caseIdentifiable(dataMappingStep);
				if (result == null) result = caseNameable(dataMappingStep);
				if (result == null) result = caseCpsStep(dataMappingStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.START_CONTROL_PORT: {
				StartControlPort startControlPort = (StartControlPort)theEObject;
				T result = caseStartControlPort(startControlPort);
				if (result == null) result = caseControlPort(startControlPort);
				if (result == null) result = caseStartPort(startControlPort);
				if (result == null) result = casePort(startControlPort);
				if (result == null) result = caseIdentifiable(startControlPort);
				if (result == null) result = caseNameable(startControlPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.END_CONTROL_PORT: {
				EndControlPort endControlPort = (EndControlPort)theEObject;
				T result = caseEndControlPort(endControlPort);
				if (result == null) result = caseControlPort(endControlPort);
				if (result == null) result = caseEndPort(endControlPort);
				if (result == null) result = casePort(endControlPort);
				if (result == null) result = caseIdentifiable(endControlPort);
				if (result == null) result = caseNameable(endControlPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.START_DATA_PORT: {
				StartDataPort startDataPort = (StartDataPort)theEObject;
				T result = caseStartDataPort(startDataPort);
				if (result == null) result = caseDataPort(startDataPort);
				if (result == null) result = caseStartPort(startDataPort);
				if (result == null) result = casePort(startDataPort);
				if (result == null) result = caseIdentifiable(startDataPort);
				if (result == null) result = caseNameable(startDataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.END_DATA_PORT: {
				EndDataPort endDataPort = (EndDataPort)theEObject;
				T result = caseEndDataPort(endDataPort);
				if (result == null) result = caseDataPort(endDataPort);
				if (result == null) result = caseEndPort(endDataPort);
				if (result == null) result = casePort(endDataPort);
				if (result == null) result = caseIdentifiable(endDataPort);
				if (result == null) result = caseNameable(endDataPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.START_PORT: {
				StartPort startPort = (StartPort)theEObject;
				T result = caseStartPort(startPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.END_PORT: {
				EndPort endPort = (EndPort)theEObject;
				T result = caseEndPort(endPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.IDENTIFIABLE: {
				Identifiable identifiable = (Identifiable)theEObject;
				T result = caseIdentifiable(identifiable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.NAMEABLE: {
				Nameable nameable = (Nameable)theEObject;
				T result = caseNameable(nameable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.TRIGGERED_EVENT: {
				TriggeredEvent triggeredEvent = (TriggeredEvent)theEObject;
				T result = caseTriggeredEvent(triggeredEvent);
				if (result == null) result = caseEvent(triggeredEvent);
				if (result == null) result = caseAtomicStep(triggeredEvent);
				if (result == null) result = caseProcessStep(triggeredEvent);
				if (result == null) result = caseIdentifiable(triggeredEvent);
				if (result == null) result = caseNameable(triggeredEvent);
				if (result == null) result = caseCpsStep(triggeredEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.TRUE_TRANSITION: {
				TrueTransition trueTransition = (TrueTransition)theEObject;
				T result = caseTrueTransition(trueTransition);
				if (result == null) result = caseTransition(trueTransition);
				if (result == null) result = caseIdentifiable(trueTransition);
				if (result == null) result = caseNameable(trueTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.FALSE_TRANSITION: {
				FalseTransition falseTransition = (FalseTransition)theEObject;
				T result = caseFalseTransition(falseTransition);
				if (result == null) result = caseTransition(falseTransition);
				if (result == null) result = caseIdentifiable(falseTransition);
				if (result == null) result = caseNameable(falseTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.SOAP_INVOKE: {
				SOAPInvoke soapInvoke = (SOAPInvoke)theEObject;
				T result = caseSOAPInvoke(soapInvoke);
				if (result == null) result = caseInvoke(soapInvoke);
				if (result == null) result = caseAtomicStep(soapInvoke);
				if (result == null) result = caseProcessStep(soapInvoke);
				if (result == null) result = caseIdentifiable(soapInvoke);
				if (result == null) result = caseNameable(soapInvoke);
				if (result == null) result = caseCpsStep(soapInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.XMLRPC_INVOKE: {
				XMLRPCInvoke xmlrpcInvoke = (XMLRPCInvoke)theEObject;
				T result = caseXMLRPCInvoke(xmlrpcInvoke);
				if (result == null) result = caseInvoke(xmlrpcInvoke);
				if (result == null) result = caseAtomicStep(xmlrpcInvoke);
				if (result == null) result = caseProcessStep(xmlrpcInvoke);
				if (result == null) result = caseIdentifiable(xmlrpcInvoke);
				if (result == null) result = caseNameable(xmlrpcInvoke);
				if (result == null) result = caseCpsStep(xmlrpcInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.LOAD_CLASS_STEP: {
				LoadClassStep loadClassStep = (LoadClassStep)theEObject;
				T result = caseLoadClassStep(loadClassStep);
				if (result == null) result = caseAtomicStep(loadClassStep);
				if (result == null) result = caseProcessStep(loadClassStep);
				if (result == null) result = caseIdentifiable(loadClassStep);
				if (result == null) result = caseNameable(loadClassStep);
				if (result == null) result = caseCpsStep(loadClassStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.SE_MI_WA_INVOKE: {
				SeMiWaInvoke seMiWaInvoke = (SeMiWaInvoke)theEObject;
				T result = caseSeMiWaInvoke(seMiWaInvoke);
				if (result == null) result = caseInvoke(seMiWaInvoke);
				if (result == null) result = caseAtomicStep(seMiWaInvoke);
				if (result == null) result = caseProcessStep(seMiWaInvoke);
				if (result == null) result = caseIdentifiable(seMiWaInvoke);
				if (result == null) result = caseNameable(seMiWaInvoke);
				if (result == null) result = caseCpsStep(seMiWaInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.REST_INVOKE: {
				RESTInvoke restInvoke = (RESTInvoke)theEObject;
				T result = caseRESTInvoke(restInvoke);
				if (result == null) result = caseInvoke(restInvoke);
				if (result == null) result = caseAtomicStep(restInvoke);
				if (result == null) result = caseProcessStep(restInvoke);
				if (result == null) result = caseIdentifiable(restInvoke);
				if (result == null) result = caseNameable(restInvoke);
				if (result == null) result = caseCpsStep(restInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OS_GI_INVOKE: {
				OSGiInvoke osGiInvoke = (OSGiInvoke)theEObject;
				T result = caseOSGiInvoke(osGiInvoke);
				if (result == null) result = caseInvoke(osGiInvoke);
				if (result == null) result = caseAtomicStep(osGiInvoke);
				if (result == null) result = caseProcessStep(osGiInvoke);
				if (result == null) result = caseIdentifiable(osGiInvoke);
				if (result == null) result = caseNameable(osGiInvoke);
				if (result == null) result = caseCpsStep(osGiInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.SE_MI_WA_REQUEST: {
				SeMiWaRequest seMiWaRequest = (SeMiWaRequest)theEObject;
				T result = caseSeMiWaRequest(seMiWaRequest);
				if (result == null) result = caseAtomicStep(seMiWaRequest);
				if (result == null) result = caseProcessStep(seMiWaRequest);
				if (result == null) result = caseIdentifiable(seMiWaRequest);
				if (result == null) result = caseNameable(seMiWaRequest);
				if (result == null) result = caseCpsStep(seMiWaRequest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DATA_MAPPING: {
				DataMapping dataMapping = (DataMapping)theEObject;
				T result = caseDataMapping(dataMapping);
				if (result == null) result = caseIdentifiable(dataMapping);
				if (result == null) result = caseNameable(dataMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.DATA_DUPLICATION_STEP: {
				DataDuplicationStep dataDuplicationStep = (DataDuplicationStep)theEObject;
				T result = caseDataDuplicationStep(dataDuplicationStep);
				if (result == null) result = caseAtomicStep(dataDuplicationStep);
				if (result == null) result = caseProcessStep(dataDuplicationStep);
				if (result == null) result = caseIdentifiable(dataDuplicationStep);
				if (result == null) result = caseNameable(dataDuplicationStep);
				if (result == null) result = caseCpsStep(dataDuplicationStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.ROS_INVOKE: {
				ROSInvoke rosInvoke = (ROSInvoke)theEObject;
				T result = caseROSInvoke(rosInvoke);
				if (result == null) result = caseAtomicStep(rosInvoke);
				if (result == null) result = caseProcessStep(rosInvoke);
				if (result == null) result = caseIdentifiable(rosInvoke);
				if (result == null) result = caseNameable(rosInvoke);
				if (result == null) result = caseCpsStep(rosInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.AND: {
				And and = (And)theEObject;
				T result = caseAnd(and);
				if (result == null) result = caseAtomicStep(and);
				if (result == null) result = caseProcessStep(and);
				if (result == null) result = caseIdentifiable(and);
				if (result == null) result = caseNameable(and);
				if (result == null) result = caseCpsStep(and);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseDataType(collectionType);
				if (result == null) result = caseNameable(collectionType);
				if (result == null) result = caseIdentifiable(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.LIST_TYPE: {
				ListType listType = (ListType)theEObject;
				T result = caseListType(listType);
				if (result == null) result = caseCollectionType(listType);
				if (result == null) result = caseDataType(listType);
				if (result == null) result = caseNameable(listType);
				if (result == null) result = caseIdentifiable(listType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				T result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseDataType(setType);
				if (result == null) result = caseNameable(setType);
				if (result == null) result = caseIdentifiable(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PUBLISH_MESSAGE: {
				PublishMessage publishMessage = (PublishMessage)theEObject;
				T result = casePublishMessage(publishMessage);
				if (result == null) result = caseAtomicStep(publishMessage);
				if (result == null) result = caseProcessStep(publishMessage);
				if (result == null) result = caseIdentifiable(publishMessage);
				if (result == null) result = caseNameable(publishMessage);
				if (result == null) result = caseCpsStep(publishMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.PUBLISH_ROS_MESSAGE: {
				PublishROSMessage publishROSMessage = (PublishROSMessage)theEObject;
				T result = casePublishROSMessage(publishROSMessage);
				if (result == null) result = casePublishMessage(publishROSMessage);
				if (result == null) result = caseAtomicStep(publishROSMessage);
				if (result == null) result = caseProcessStep(publishROSMessage);
				if (result == null) result = caseIdentifiable(publishROSMessage);
				if (result == null) result = caseNameable(publishROSMessage);
				if (result == null) result = caseCpsStep(publishROSMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.HUMAN_TASK: {
				HumanTask humanTask = (HumanTask)theEObject;
				T result = caseHumanTask(humanTask);
				if (result == null) result = caseAtomicStep(humanTask);
				if (result == null) result = caseProcessStep(humanTask);
				if (result == null) result = caseIdentifiable(humanTask);
				if (result == null) result = caseNameable(humanTask);
				if (result == null) result = caseCpsStep(humanTask);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.ESCALATION_PORT: {
				EscalationPort escalationPort = (EscalationPort)theEObject;
				T result = caseEscalationPort(escalationPort);
				if (result == null) result = caseEndControlPort(escalationPort);
				if (result == null) result = caseControlPort(escalationPort);
				if (result == null) result = caseEndPort(escalationPort);
				if (result == null) result = casePort(escalationPort);
				if (result == null) result = caseIdentifiable(escalationPort);
				if (result == null) result = caseNameable(escalationPort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.END_DATA_PORT_TO_START_DATA_PORT_MAP: {
				@SuppressWarnings("unchecked") Map.Entry<EndDataPort, StartDataPort> endDataPortToStartDataPortMap = (Map.Entry<EndDataPort, StartDataPort>)theEObject;
				T result = caseEndDataPortToStartDataPortMap(endDataPortToStartDataPortMap);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE: {
				OpenHabSemanticInvoke openHabSemanticInvoke = (OpenHabSemanticInvoke)theEObject;
				T result = caseOpenHabSemanticInvoke(openHabSemanticInvoke);
				if (result == null) result = caseInvoke(openHabSemanticInvoke);
				if (result == null) result = caseAtomicStep(openHabSemanticInvoke);
				if (result == null) result = caseProcessStep(openHabSemanticInvoke);
				if (result == null) result = caseIdentifiable(openHabSemanticInvoke);
				if (result == null) result = caseNameable(openHabSemanticInvoke);
				if (result == null) result = caseCpsStep(openHabSemanticInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OPEN_HAB_SEMANTIC_SELECT_INVOKE: {
				OpenHabSemanticSelectInvoke openHabSemanticSelectInvoke = (OpenHabSemanticSelectInvoke)theEObject;
				T result = caseOpenHabSemanticSelectInvoke(openHabSemanticSelectInvoke);
				if (result == null) result = caseOpenHabSemanticInvoke(openHabSemanticSelectInvoke);
				if (result == null) result = caseInvoke(openHabSemanticSelectInvoke);
				if (result == null) result = caseAtomicStep(openHabSemanticSelectInvoke);
				if (result == null) result = caseProcessStep(openHabSemanticSelectInvoke);
				if (result == null) result = caseIdentifiable(openHabSemanticSelectInvoke);
				if (result == null) result = caseNameable(openHabSemanticSelectInvoke);
				if (result == null) result = caseCpsStep(openHabSemanticSelectInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OPEN_HAB_SEMANTIC_ASK_INVOKE: {
				OpenHabSemanticAskInvoke openHabSemanticAskInvoke = (OpenHabSemanticAskInvoke)theEObject;
				T result = caseOpenHabSemanticAskInvoke(openHabSemanticAskInvoke);
				if (result == null) result = caseOpenHabSemanticInvoke(openHabSemanticAskInvoke);
				if (result == null) result = caseInvoke(openHabSemanticAskInvoke);
				if (result == null) result = caseAtomicStep(openHabSemanticAskInvoke);
				if (result == null) result = caseProcessStep(openHabSemanticAskInvoke);
				if (result == null) result = caseIdentifiable(openHabSemanticAskInvoke);
				if (result == null) result = caseNameable(openHabSemanticAskInvoke);
				if (result == null) result = caseCpsStep(openHabSemanticAskInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.OPEN_HAB_SEMANTIC_COMMAND_INVOKE: {
				OpenHabSemanticCommandInvoke openHabSemanticCommandInvoke = (OpenHabSemanticCommandInvoke)theEObject;
				T result = caseOpenHabSemanticCommandInvoke(openHabSemanticCommandInvoke);
				if (result == null) result = caseOpenHabSemanticInvoke(openHabSemanticCommandInvoke);
				if (result == null) result = caseInvoke(openHabSemanticCommandInvoke);
				if (result == null) result = caseAtomicStep(openHabSemanticCommandInvoke);
				if (result == null) result = caseProcessStep(openHabSemanticCommandInvoke);
				if (result == null) result = caseIdentifiable(openHabSemanticCommandInvoke);
				if (result == null) result = caseNameable(openHabSemanticCommandInvoke);
				if (result == null) result = caseCpsStep(openHabSemanticCommandInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.CPS_STEP: {
				CpsStep cpsStep = (CpsStep)theEObject;
				T result = caseCpsStep(cpsStep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.MAPE_K: {
				MapeK mapeK = (MapeK)theEObject;
				T result = caseMapeK(mapeK);
				if (result == null) result = caseAtomicStep(mapeK);
				if (result == null) result = caseProcessStep(mapeK);
				if (result == null) result = caseIdentifiable(mapeK);
				if (result == null) result = caseNameable(mapeK);
				if (result == null) result = caseCpsStep(mapeK);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SofiaPackage.GOAL_INVOKE: {
				GoalInvoke goalInvoke = (GoalInvoke)theEObject;
				T result = caseGoalInvoke(goalInvoke);
				if (result == null) result = caseInvoke(goalInvoke);
				if (result == null) result = caseAtomicStep(goalInvoke);
				if (result == null) result = caseProcessStep(goalInvoke);
				if (result == null) result = caseIdentifiable(goalInvoke);
				if (result == null) result = caseNameable(goalInvoke);
				if (result == null) result = caseCpsStep(goalInvoke);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIf(If object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOr(Or object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInvoke(Invoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcess(eu.vicci.process.model.sofia.Process object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePort(Port object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataPort(DataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlPort(ControlPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessStep(ProcessStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complex Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComplexType(ComplexType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicStep(AtomicStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeStep(CompositeStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataType(DataType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleType(SimpleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Numeric Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumericType(NumericType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleType(DoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoop(Loop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repeat Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repeat Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRepeatLoop(RepeatLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>While Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWhileLoop(WhileLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Loop</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForLoop(ForLoop object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Slot</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Slot</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessSlot(ProcessSlot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapping Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapping Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMappingStep(DataMappingStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Control Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Control Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartControlPort(StartControlPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Control Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Control Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndControlPort(EndControlPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartDataPort(StartDataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Data Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndDataPort(EndDataPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartPort(StartPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndPort(EndPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifiable(Identifiable object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Triggered Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Triggered Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTriggeredEvent(TriggeredEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrueTransition(TrueTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalseTransition(FalseTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>SOAP Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SOAP Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSOAPInvoke(SOAPInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMLRPC Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMLRPC Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMLRPCInvoke(XMLRPCInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Class Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Class Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadClassStep(LoadClassStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Se Mi Wa Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Se Mi Wa Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeMiWaInvoke(SeMiWaInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>REST Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>REST Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRESTInvoke(RESTInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>OS Gi Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>OS Gi Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOSGiInvoke(OSGiInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Se Mi Wa Request</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Se Mi Wa Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSeMiWaRequest(SeMiWaRequest object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataMapping(DataMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Duplication Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Duplication Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataDuplicationStep(DataDuplicationStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ROS Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ROS Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseROSInvoke(ROSInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnd(And object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishMessage(PublishMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Publish ROS Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Publish ROS Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePublishROSMessage(PublishROSMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Human Task</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Human Task</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHumanTask(HumanTask object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Escalation Port</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Escalation Port</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEscalationPort(EscalationPort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>End Data Port To Start Data Port Map</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>End Data Port To Start Data Port Map</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEndDataPortToStartDataPortMap(Map.Entry<EndDataPort, StartDataPort> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticInvoke(OpenHabSemanticInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Select Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Select Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticSelectInvoke(OpenHabSemanticSelectInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Ask Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Ask Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticAskInvoke(OpenHabSemanticAskInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Hab Semantic Command Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Hab Semantic Command Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenHabSemanticCommandInvoke(OpenHabSemanticCommandInvoke object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cps Step</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cps Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCpsStep(CpsStep object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mape K</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mape K</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMapeK(MapeK object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Goal Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Goal Invoke</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGoalInvoke(GoalInvoke object) {
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

} //SofiaSwitch
