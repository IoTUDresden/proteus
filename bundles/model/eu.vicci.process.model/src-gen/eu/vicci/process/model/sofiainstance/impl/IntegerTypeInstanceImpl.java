/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.IntegerType;

import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.IntegerTypeInstanceImpl#getIntegerTypeType <em>Integer Type Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerTypeInstanceImpl extends DataTypeInstanceImpl implements IntegerTypeInstance {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final int VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected int value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getIntegerTypeType() <em>Integer Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegerTypeType()
	 * @generated
	 * @ordered
	 */
	protected IntegerType integerTypeType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.INTEGER_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(int newValue) {
		int oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.INTEGER_TYPE_INSTANCE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType getIntegerTypeType() {
		if (integerTypeType != null && integerTypeType.eIsProxy()) {
			InternalEObject oldIntegerTypeType = (InternalEObject)integerTypeType;
			integerTypeType = (IntegerType)eResolveProxy(oldIntegerTypeType);
			if (integerTypeType != oldIntegerTypeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE, oldIntegerTypeType, integerTypeType));
			}
		}
		return integerTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerType basicGetIntegerTypeType() {
		return integerTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegerTypeType(IntegerType newIntegerTypeType) {
		IntegerType oldIntegerTypeType = integerTypeType;
		integerTypeType = newIntegerTypeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE, oldIntegerTypeType, integerTypeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__VALUE:
				return getValue();
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE:
				if (resolve) return getIntegerTypeType();
				return basicGetIntegerTypeType();
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
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__VALUE:
				setValue((Integer)newValue);
				return;
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE:
				setIntegerTypeType((IntegerType)newValue);
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
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE:
				setIntegerTypeType((IntegerType)null);
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
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__VALUE:
				return value != VALUE_EDEFAULT;
			case SofiaInstancePackage.INTEGER_TYPE_INSTANCE__INTEGER_TYPE_TYPE:
				return integerTypeType != null;
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //IntegerTypeInstanceImpl
