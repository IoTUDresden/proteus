/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.DoubleType;

import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Double Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DoubleTypeInstanceImpl#getDoubleTypeType <em>Double Type Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DoubleTypeInstanceImpl extends DataTypeInstanceImpl implements DoubleTypeInstance {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final double VALUE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected double value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDoubleTypeType() <em>Double Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoubleTypeType()
	 * @generated
	 * @ordered
	 */
	protected DoubleType doubleTypeType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoubleTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.DOUBLE_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(double newValue) {
		double oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleType getDoubleTypeType() {
		if (doubleTypeType != null && doubleTypeType.eIsProxy()) {
			InternalEObject oldDoubleTypeType = (InternalEObject)doubleTypeType;
			doubleTypeType = (DoubleType)eResolveProxy(oldDoubleTypeType);
			if (doubleTypeType != oldDoubleTypeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE, oldDoubleTypeType, doubleTypeType));
			}
		}
		return doubleTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleType basicGetDoubleTypeType() {
		return doubleTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDoubleTypeType(DoubleType newDoubleTypeType) {
		DoubleType oldDoubleTypeType = doubleTypeType;
		doubleTypeType = newDoubleTypeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE, oldDoubleTypeType, doubleTypeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__VALUE:
				return getValue();
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE:
				if (resolve) return getDoubleTypeType();
				return basicGetDoubleTypeType();
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
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__VALUE:
				setValue((Double)newValue);
				return;
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE:
				setDoubleTypeType((DoubleType)newValue);
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
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE:
				setDoubleTypeType((DoubleType)null);
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
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__VALUE:
				return value != VALUE_EDEFAULT;
			case SofiaInstancePackage.DOUBLE_TYPE_INSTANCE__DOUBLE_TYPE_TYPE:
				return doubleTypeType != null;
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

} //DoubleTypeInstanceImpl
