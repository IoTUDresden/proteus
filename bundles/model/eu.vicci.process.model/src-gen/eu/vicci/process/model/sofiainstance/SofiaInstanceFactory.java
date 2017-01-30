/**
 */
package eu.vicci.process.model.sofiainstance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage
 * @generated
 */
public interface SofiaInstanceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SofiaInstanceFactory eINSTANCE = eu.vicci.process.model.sofiainstance.impl.SofiaInstanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Instance</em>'.
	 * @generated
	 */
	ProcessInstance createProcessInstance();

	/**
	 * Returns a new object of class '<em>Process Step Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Step Instance</em>'.
	 * @generated
	 */
	ProcessStepInstance createProcessStepInstance();

	/**
	 * Returns a new object of class '<em>String Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Type Instance</em>'.
	 * @generated
	 */
	StringTypeInstance createStringTypeInstance();

	/**
	 * Returns a new object of class '<em>Integer Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Type Instance</em>'.
	 * @generated
	 */
	IntegerTypeInstance createIntegerTypeInstance();

	/**
	 * Returns a new object of class '<em>Double Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Type Instance</em>'.
	 * @generated
	 */
	DoubleTypeInstance createDoubleTypeInstance();

	/**
	 * Returns a new object of class '<em>Boolean Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Type Instance</em>'.
	 * @generated
	 */
	BooleanTypeInstance createBooleanTypeInstance();

	/**
	 * Returns a new object of class '<em>Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Instance</em>'.
	 * @generated
	 */
	TransitionInstance createTransitionInstance();

	/**
	 * Returns a new object of class '<em>Start Control Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Control Port Instance</em>'.
	 * @generated
	 */
	StartControlPortInstance createStartControlPortInstance();

	/**
	 * Returns a new object of class '<em>Start Data Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Data Port Instance</em>'.
	 * @generated
	 */
	StartDataPortInstance createStartDataPortInstance();

	/**
	 * Returns a new object of class '<em>End Control Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Control Port Instance</em>'.
	 * @generated
	 */
	EndControlPortInstance createEndControlPortInstance();

	/**
	 * Returns a new object of class '<em>End Data Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>End Data Port Instance</em>'.
	 * @generated
	 */
	EndDataPortInstance createEndDataPortInstance();

	/**
	 * Returns a new object of class '<em>Data Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Instance</em>'.
	 * @generated
	 */
	DataTypeInstance createDataTypeInstance();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Mapping Util</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping Util</em>'.
	 * @generated
	 */
	MappingUtil createMappingUtil();

	/**
	 * Returns a new object of class '<em>Condition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Condition Instance</em>'.
	 * @generated
	 */
	ConditionInstance createConditionInstance();

	/**
	 * Returns a new object of class '<em>True Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>True Transition Instance</em>'.
	 * @generated
	 */
	TrueTransitionInstance createTrueTransitionInstance();

	/**
	 * Returns a new object of class '<em>False Transition Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>False Transition Instance</em>'.
	 * @generated
	 */
	FalseTransitionInstance createFalseTransitionInstance();

	/**
	 * Returns a new object of class '<em>Complex Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Complex Type Instance</em>'.
	 * @generated
	 */
	ComplexTypeInstance createComplexTypeInstance();

	/**
	 * Returns a new object of class '<em>List Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>List Type Instance</em>'.
	 * @generated
	 */
	ListTypeInstance createListTypeInstance();

	/**
	 * Returns a new object of class '<em>Collection Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type Instance</em>'.
	 * @generated
	 */
	CollectionTypeInstance createCollectionTypeInstance();

	/**
	 * Returns a new object of class '<em>Set Type Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Type Instance</em>'.
	 * @generated
	 */
	SetTypeInstance createSetTypeInstance();

	/**
	 * Returns a new object of class '<em>Escalation Port Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Escalation Port Instance</em>'.
	 * @generated
	 */
	EscalationPortInstance createEscalationPortInstance();

	/**
	 * Returns a new object of class '<em>Human Task Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Human Task Instance</em>'.
	 * @generated
	 */
	HumanTaskInstance createHumanTaskInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SofiaInstancePackage getSofiaInstancePackage();

} //SofiaInstanceFactory
