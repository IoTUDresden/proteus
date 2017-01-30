/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.HumanTask;
import eu.vicci.process.model.sofia.HumanTaskType;
import eu.vicci.process.model.sofia.HumanTaskUseCase;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Human Task</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.HumanTaskImpl#getHumanTaskType <em>Human Task Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.HumanTaskImpl#getHumanTaskUseCase <em>Human Task Use Case</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HumanTaskImpl extends AtomicStepImpl implements HumanTask {
	/**
	 * The default value of the '{@link #getHumanTaskType() <em>Human Task Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHumanTaskType()
	 * @generated
	 * @ordered
	 */
	protected static final HumanTaskType HUMAN_TASK_TYPE_EDEFAULT = HumanTaskType.HINT;

	/**
	 * The cached value of the '{@link #getHumanTaskType() <em>Human Task Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHumanTaskType()
	 * @generated
	 * @ordered
	 */
	protected HumanTaskType humanTaskType = HUMAN_TASK_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getHumanTaskUseCase() <em>Human Task Use Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHumanTaskUseCase()
	 * @generated
	 * @ordered
	 */
	protected static final HumanTaskUseCase HUMAN_TASK_USE_CASE_EDEFAULT = HumanTaskUseCase.UNIVERSAL;

	/**
	 * The cached value of the '{@link #getHumanTaskUseCase() <em>Human Task Use Case</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHumanTaskUseCase()
	 * @generated
	 * @ordered
	 */
	protected HumanTaskUseCase humanTaskUseCase = HUMAN_TASK_USE_CASE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HumanTaskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.HUMAN_TASK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTaskType getHumanTaskType() {
		return humanTaskType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHumanTaskType(HumanTaskType newHumanTaskType) {
		HumanTaskType oldHumanTaskType = humanTaskType;
		humanTaskType = newHumanTaskType == null ? HUMAN_TASK_TYPE_EDEFAULT : newHumanTaskType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.HUMAN_TASK__HUMAN_TASK_TYPE, oldHumanTaskType, humanTaskType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HumanTaskUseCase getHumanTaskUseCase() {
		return humanTaskUseCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHumanTaskUseCase(HumanTaskUseCase newHumanTaskUseCase) {
		HumanTaskUseCase oldHumanTaskUseCase = humanTaskUseCase;
		humanTaskUseCase = newHumanTaskUseCase == null ? HUMAN_TASK_USE_CASE_EDEFAULT : newHumanTaskUseCase;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.HUMAN_TASK__HUMAN_TASK_USE_CASE, oldHumanTaskUseCase, humanTaskUseCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_TYPE:
				return getHumanTaskType();
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_USE_CASE:
				return getHumanTaskUseCase();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_TYPE:
				setHumanTaskType((HumanTaskType)newValue);
				return;
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_USE_CASE:
				setHumanTaskUseCase((HumanTaskUseCase)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_TYPE:
				setHumanTaskType(HUMAN_TASK_TYPE_EDEFAULT);
				return;
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_USE_CASE:
				setHumanTaskUseCase(HUMAN_TASK_USE_CASE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_TYPE:
				return humanTaskType != HUMAN_TASK_TYPE_EDEFAULT;
			case SofiaPackage.HUMAN_TASK__HUMAN_TASK_USE_CASE:
				return humanTaskUseCase != HUMAN_TASK_USE_CASE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (humanTaskType: ");
		result.append(humanTaskType);
		result.append(", humanTaskUseCase: ");
		result.append(humanTaskUseCase);
		result.append(')');
		return result.toString();
	}

} //HumanTaskImpl
