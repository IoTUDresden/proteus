/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.StringType;

import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>String Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.StringTypeInstanceImpl#getStringTypeType <em>String Type Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StringTypeInstanceImpl extends DataTypeInstanceImpl implements StringTypeInstance {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getStringTypeType() <em>String Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStringTypeType()
	 * @generated
	 * @ordered
	 */
	protected StringType stringTypeType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StringTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.STRING_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.STRING_TYPE_INSTANCE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType getStringTypeType() {
		if (stringTypeType != null && stringTypeType.eIsProxy()) {
			InternalEObject oldStringTypeType = (InternalEObject)stringTypeType;
			stringTypeType = (StringType)eResolveProxy(oldStringTypeType);
			if (stringTypeType != oldStringTypeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE, oldStringTypeType, stringTypeType));
			}
		}
		return stringTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringType basicGetStringTypeType() {
		return stringTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStringTypeType(StringType newStringTypeType) {
		StringType oldStringTypeType = stringTypeType;
		stringTypeType = newStringTypeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE, oldStringTypeType, stringTypeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__VALUE:
				return getValue();
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE:
				if (resolve) return getStringTypeType();
				return basicGetStringTypeType();
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
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__VALUE:
				setValue((String)newValue);
				return;
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE:
				setStringTypeType((StringType)newValue);
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
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE:
				setStringTypeType((StringType)null);
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
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SofiaInstancePackage.STRING_TYPE_INSTANCE__STRING_TYPE_TYPE:
				return stringTypeType != null;
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

} //StringTypeInstanceImpl
