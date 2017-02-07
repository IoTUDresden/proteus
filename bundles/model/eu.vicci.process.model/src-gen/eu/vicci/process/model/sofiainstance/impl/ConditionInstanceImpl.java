/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.Condition;

import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl#getExpressionInstance <em>Expression Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl#isResult <em>Result</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl#getIfConditionType <em>If Condition Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl#getLeftSide <em>Left Side</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConditionInstanceImpl#getRightSide <em>Right Side</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConditionInstanceImpl extends EObjectImpl implements ConditionInstance {
	/**
	 * The default value of the '{@link #getExpressionInstance() <em>Expression Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionInstance()
	 * @generated
	 * @ordered
	 */
	protected static final String EXPRESSION_INSTANCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExpressionInstance() <em>Expression Instance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpressionInstance()
	 * @generated
	 * @ordered
	 */
	protected String expressionInstance = EXPRESSION_INSTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResult()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResult()
	 * @generated
	 * @ordered
	 */
	protected boolean result = RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIfConditionType() <em>If Condition Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIfConditionType()
	 * @generated
	 * @ordered
	 */
	protected Condition ifConditionType;

	/**
	 * The cached value of the '{@link #getLeftSide() <em>Left Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftSide()
	 * @generated
	 * @ordered
	 */
	protected StartDataPortInstance leftSide;

	/**
	 * The cached value of the '{@link #getRightSide() <em>Right Side</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightSide()
	 * @generated
	 * @ordered
	 */
	protected StartDataPortInstance rightSide;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.CONDITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExpressionInstance() {
		return expressionInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpressionInstance(String newExpressionInstance) {
		String oldExpressionInstance = expressionInstance;
		expressionInstance = newExpressionInstance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONDITION_INSTANCE__EXPRESSION_INSTANCE, oldExpressionInstance, expressionInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResult(boolean newResult) {
		boolean oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONDITION_INSTANCE__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getIfConditionType() {
		if (ifConditionType != null && ifConditionType.eIsProxy()) {
			InternalEObject oldIfConditionType = (InternalEObject)ifConditionType;
			ifConditionType = (Condition)eResolveProxy(oldIfConditionType);
			if (ifConditionType != oldIfConditionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE, oldIfConditionType, ifConditionType));
			}
		}
		return ifConditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition basicGetIfConditionType() {
		return ifConditionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIfConditionType(Condition newIfConditionType) {
		Condition oldIfConditionType = ifConditionType;
		ifConditionType = newIfConditionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE, oldIfConditionType, ifConditionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance getLeftSide() {
		if (leftSide != null && leftSide.eIsProxy()) {
			InternalEObject oldLeftSide = (InternalEObject)leftSide;
			leftSide = (StartDataPortInstance)eResolveProxy(oldLeftSide);
			if (leftSide != oldLeftSide) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE, oldLeftSide, leftSide));
			}
		}
		return leftSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance basicGetLeftSide() {
		return leftSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftSide(StartDataPortInstance newLeftSide) {
		StartDataPortInstance oldLeftSide = leftSide;
		leftSide = newLeftSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE, oldLeftSide, leftSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance getRightSide() {
		if (rightSide != null && rightSide.eIsProxy()) {
			InternalEObject oldRightSide = (InternalEObject)rightSide;
			rightSide = (StartDataPortInstance)eResolveProxy(oldRightSide);
			if (rightSide != oldRightSide) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE, oldRightSide, rightSide));
			}
		}
		return rightSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance basicGetRightSide() {
		return rightSide;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightSide(StartDataPortInstance newRightSide) {
		StartDataPortInstance oldRightSide = rightSide;
		rightSide = newRightSide;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE, oldRightSide, rightSide));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean evaluate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.CONDITION_INSTANCE__EXPRESSION_INSTANCE:
				return getExpressionInstance();
			case SofiaInstancePackage.CONDITION_INSTANCE__RESULT:
				return isResult();
			case SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE:
				if (resolve) return getIfConditionType();
				return basicGetIfConditionType();
			case SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE:
				if (resolve) return getLeftSide();
				return basicGetLeftSide();
			case SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE:
				if (resolve) return getRightSide();
				return basicGetRightSide();
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
			case SofiaInstancePackage.CONDITION_INSTANCE__EXPRESSION_INSTANCE:
				setExpressionInstance((String)newValue);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__RESULT:
				setResult((Boolean)newValue);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE:
				setIfConditionType((Condition)newValue);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE:
				setLeftSide((StartDataPortInstance)newValue);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE:
				setRightSide((StartDataPortInstance)newValue);
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
			case SofiaInstancePackage.CONDITION_INSTANCE__EXPRESSION_INSTANCE:
				setExpressionInstance(EXPRESSION_INSTANCE_EDEFAULT);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__RESULT:
				setResult(RESULT_EDEFAULT);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE:
				setIfConditionType((Condition)null);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE:
				setLeftSide((StartDataPortInstance)null);
				return;
			case SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE:
				setRightSide((StartDataPortInstance)null);
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
			case SofiaInstancePackage.CONDITION_INSTANCE__EXPRESSION_INSTANCE:
				return EXPRESSION_INSTANCE_EDEFAULT == null ? expressionInstance != null : !EXPRESSION_INSTANCE_EDEFAULT.equals(expressionInstance);
			case SofiaInstancePackage.CONDITION_INSTANCE__RESULT:
				return result != RESULT_EDEFAULT;
			case SofiaInstancePackage.CONDITION_INSTANCE__IF_CONDITION_TYPE:
				return ifConditionType != null;
			case SofiaInstancePackage.CONDITION_INSTANCE__LEFT_SIDE:
				return leftSide != null;
			case SofiaInstancePackage.CONDITION_INSTANCE__RIGHT_SIDE:
				return rightSide != null;
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
		result.append(" (expressionInstance: ");
		result.append(expressionInstance);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}

} //ConditionInstanceImpl
