/**
 */
package eu.vicci.process.model.sofia;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Human Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskType <em>Human Task Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskUseCase <em>Human Task Use Case</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getHumanTask()
 * @model
 * @generated
 */
public interface HumanTask extends AtomicStep {
	/**
	 * Returns the value of the '<em><b>Human Task Type</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofia.HumanTaskType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Human Task Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Human Task Type</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HumanTaskType
	 * @see #setHumanTaskType(HumanTaskType)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getHumanTask_HumanTaskType()
	 * @model required="true"
	 * @generated
	 */
	HumanTaskType getHumanTaskType();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskType <em>Human Task Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Human Task Type</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HumanTaskType
	 * @see #getHumanTaskType()
	 * @generated
	 */
	void setHumanTaskType(HumanTaskType value);

	/**
	 * Returns the value of the '<em><b>Human Task Use Case</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.model.sofia.HumanTaskUseCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Human Task Use Case</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Human Task Use Case</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HumanTaskUseCase
	 * @see #setHumanTaskUseCase(HumanTaskUseCase)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getHumanTask_HumanTaskUseCase()
	 * @model required="true"
	 * @generated
	 */
	HumanTaskUseCase getHumanTaskUseCase();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.HumanTask#getHumanTaskUseCase <em>Human Task Use Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Human Task Use Case</em>' attribute.
	 * @see eu.vicci.process.model.sofia.HumanTaskUseCase
	 * @see #getHumanTaskUseCase()
	 * @generated
	 */
	void setHumanTaskUseCase(HumanTaskUseCase value);

} // HumanTask
