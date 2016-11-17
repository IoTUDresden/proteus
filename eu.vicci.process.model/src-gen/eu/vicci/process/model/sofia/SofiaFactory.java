/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofia.SofiaPackage
 * @generated
 */
public interface SofiaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SofiaFactory eINSTANCE = eu.vicci.process.model.sofia.impl.SofiaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition</em>'.
	 * @generated
	 */
	Transition createTransition();

	/**
	 * Returns a new object of class '<em>If</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If</em>'.
	 * @generated
	 */
	If createIf();

	/**
	 * Returns a new object of class '<em>Or</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Or</em>'.
	 * @generated
	 */
	Or createOr();

	/**
	 * Returns a new object of class '<em>Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Invoke</em>'.
	 * @generated
	 */
	Invoke createInvoke();

	/**
	 * Returns a new object of class '<em>Process</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process</em>'.
	 * @generated
	 */
	Process createProcess();

	/**
	 * Returns a new object of class '<em>Complex Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Type</em>'.
	 * @generated
	 */
	ComplexType createComplexType();

	/**
	 * Returns a new object of class '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition</em>'.
	 * @generated
	 */
	Condition createCondition();

	/**
	 * Returns a new object of class '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type</em>'.
	 * @generated
	 */
	StringType createStringType();

	/**
	 * Returns a new object of class '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type</em>'.
	 * @generated
	 */
	BooleanType createBooleanType();

	/**
	 * Returns a new object of class '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Type</em>'.
	 * @generated
	 */
	IntegerType createIntegerType();

	/**
	 * Returns a new object of class '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Type</em>'.
	 * @generated
	 */
	DoubleType createDoubleType();

	/**
	 * Returns a new object of class '<em>Repeat Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repeat Loop</em>'.
	 * @generated
	 */
	RepeatLoop createRepeatLoop();

	/**
	 * Returns a new object of class '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Loop</em>'.
	 * @generated
	 */
	WhileLoop createWhileLoop();

	/**
	 * Returns a new object of class '<em>For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Loop</em>'.
	 * @generated
	 */
	ForLoop createForLoop();

	/**
	 * Returns a new object of class '<em>Process Slot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Slot</em>'.
	 * @generated
	 */
	ProcessSlot createProcessSlot();

	/**
	 * Returns a new object of class '<em>Data Mapping Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Mapping Step</em>'.
	 * @generated
	 */
	DataMappingStep createDataMappingStep();

	/**
	 * Returns a new object of class '<em>Start Control Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Control Port</em>'.
	 * @generated
	 */
	StartControlPort createStartControlPort();

	/**
	 * Returns a new object of class '<em>End Control Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Control Port</em>'.
	 * @generated
	 */
	EndControlPort createEndControlPort();

	/**
	 * Returns a new object of class '<em>Start Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Data Port</em>'.
	 * @generated
	 */
	StartDataPort createStartDataPort();

	/**
	 * Returns a new object of class '<em>End Data Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Data Port</em>'.
	 * @generated
	 */
	EndDataPort createEndDataPort();

	/**
	 * Returns a new object of class '<em>Triggered Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Triggered Event</em>'.
	 * @generated
	 */
	TriggeredEvent createTriggeredEvent();

	/**
	 * Returns a new object of class '<em>True Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Transition</em>'.
	 * @generated
	 */
	TrueTransition createTrueTransition();

	/**
	 * Returns a new object of class '<em>False Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Transition</em>'.
	 * @generated
	 */
	FalseTransition createFalseTransition();

	/**
	 * Returns a new object of class '<em>SOAP Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SOAP Invoke</em>'.
	 * @generated
	 */
	SOAPInvoke createSOAPInvoke();

	/**
	 * Returns a new object of class '<em>XMLRPC Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>XMLRPC Invoke</em>'.
	 * @generated
	 */
	XMLRPCInvoke createXMLRPCInvoke();

	/**
	 * Returns a new object of class '<em>Load Class Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Load Class Step</em>'.
	 * @generated
	 */
	LoadClassStep createLoadClassStep();

	/**
	 * Returns a new object of class '<em>Se Mi Wa Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Se Mi Wa Invoke</em>'.
	 * @generated
	 */
	SeMiWaInvoke createSeMiWaInvoke();

	/**
	 * Returns a new object of class '<em>REST Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>REST Invoke</em>'.
	 * @generated
	 */
	RESTInvoke createRESTInvoke();

	/**
	 * Returns a new object of class '<em>OS Gi Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>OS Gi Invoke</em>'.
	 * @generated
	 */
	OSGiInvoke createOSGiInvoke();

	/**
	 * Returns a new object of class '<em>Se Mi Wa Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Se Mi Wa Request</em>'.
	 * @generated
	 */
	SeMiWaRequest createSeMiWaRequest();

	/**
	 * Returns a new object of class '<em>Data Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Mapping</em>'.
	 * @generated
	 */
	DataMapping createDataMapping();

	/**
	 * Returns a new object of class '<em>Data Duplication Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Duplication Step</em>'.
	 * @generated
	 */
	DataDuplicationStep createDataDuplicationStep();

	/**
	 * Returns a new object of class '<em>ROS Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>ROS Invoke</em>'.
	 * @generated
	 */
	ROSInvoke createROSInvoke();

	/**
	 * Returns a new object of class '<em>And</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>And</em>'.
	 * @generated
	 */
	And createAnd();

	/**
	 * Returns a new object of class '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type</em>'.
	 * @generated
	 */
	CollectionType createCollectionType();

	/**
	 * Returns a new object of class '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Type</em>'.
	 * @generated
	 */
	ListType createListType();

	/**
	 * Returns a new object of class '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type</em>'.
	 * @generated
	 */
	SetType createSetType();

	/**
	 * Returns a new object of class '<em>Publish ROS Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Publish ROS Message</em>'.
	 * @generated
	 */
	PublishROSMessage createPublishROSMessage();

	/**
	 * Returns a new object of class '<em>Human Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human Task</em>'.
	 * @generated
	 */
	HumanTask createHumanTask();

	/**
	 * Returns a new object of class '<em>Escalation Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Escalation Port</em>'.
	 * @generated
	 */
	EscalationPort createEscalationPort();

	/**
	 * Returns a new object of class '<em>Open Hab Semantic Select Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Hab Semantic Select Invoke</em>'.
	 * @generated
	 */
	OpenHabSemanticSelectInvoke createOpenHabSemanticSelectInvoke();

	/**
	 * Returns a new object of class '<em>Open Hab Semantic Ask Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Hab Semantic Ask Invoke</em>'.
	 * @generated
	 */
	OpenHabSemanticAskInvoke createOpenHabSemanticAskInvoke();

	/**
	 * Returns a new object of class '<em>Open Hab Semantic Command Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Hab Semantic Command Invoke</em>'.
	 * @generated
	 */
	OpenHabSemanticCommandInvoke createOpenHabSemanticCommandInvoke();

	/**
	 * Returns a new object of class '<em>Mape K</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mape K</em>'.
	 * @generated
	 */
	MapeK createMapeK();

	/**
	 * Returns a new object of class '<em>Goal Invoke</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Goal Invoke</em>'.
	 * @generated
	 */
	GoalInvoke createGoalInvoke();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SofiaPackage getSofiaPackage();

} //SofiaFactory
