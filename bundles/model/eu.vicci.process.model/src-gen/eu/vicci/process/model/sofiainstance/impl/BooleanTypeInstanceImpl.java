/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.BooleanType;

import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl#isValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.BooleanTypeInstanceImpl#getBooleanTypeType <em>Boolean Type Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanTypeInstanceImpl extends DataTypeInstanceImpl implements BooleanTypeInstance {
	/**
	 * The default value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isValue()
	 * @generated
	 * @ordered
	 */
	protected boolean value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBooleanTypeType() <em>Boolean Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBooleanTypeType()
	 * @generated
	 * @ordered
	 */
	protected BooleanType booleanTypeType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.BOOLEAN_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(boolean newValue) {
		boolean oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType getBooleanTypeType() {
		if (booleanTypeType != null && booleanTypeType.eIsProxy()) {
			InternalEObject oldBooleanTypeType = (InternalEObject)booleanTypeType;
			booleanTypeType = (BooleanType)eResolveProxy(oldBooleanTypeType);
			if (booleanTypeType != oldBooleanTypeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE, oldBooleanTypeType, booleanTypeType));
			}
		}
		return booleanTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanType basicGetBooleanTypeType() {
		return booleanTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBooleanTypeType(BooleanType newBooleanTypeType) {
		BooleanType oldBooleanTypeType = booleanTypeType;
		booleanTypeType = newBooleanTypeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE, oldBooleanTypeType, booleanTypeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__VALUE:
				return isValue();
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE:
				if (resolve) return getBooleanTypeType();
				return basicGetBooleanTypeType();
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
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__VALUE:
				setValue((Boolean)newValue);
				return;
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE:
				setBooleanTypeType((BooleanType)newValue);
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
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE:
				setBooleanTypeType((BooleanType)null);
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
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__VALUE:
				return value != VALUE_EDEFAULT;
			case SofiaInstancePackage.BOOLEAN_TYPE_INSTANCE__BOOLEAN_TYPE_TYPE:
				return booleanTypeType != null;
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

} //BooleanTypeInstanceImpl
