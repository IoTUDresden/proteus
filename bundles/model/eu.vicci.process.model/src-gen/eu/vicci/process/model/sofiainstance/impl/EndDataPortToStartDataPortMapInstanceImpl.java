/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>End Data Port To Start Data Port Map Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl#getTypedValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.EndDataPortToStartDataPortMapInstanceImpl#getTypedKey <em>Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EndDataPortToStartDataPortMapInstanceImpl extends EObjectImpl implements BasicEMap.Entry<EndDataPortInstance,StartDataPortInstance> {
	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected StartDataPortInstance value;

	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected EndDataPortInstance key;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EndDataPortToStartDataPortMapInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance getTypedValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (StartDataPortInstance)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance basicGetTypedValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedValue(StartDataPortInstance newValue) {
		StartDataPortInstance oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndDataPortInstance getTypedKey() {
		if (key != null && key.eIsProxy()) {
			InternalEObject oldKey = (InternalEObject)key;
			key = (EndDataPortInstance)eResolveProxy(oldKey);
			if (key != oldKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY, oldKey, key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndDataPortInstance basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(EndDataPortInstance newKey) {
		EndDataPortInstance oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE:
				if (resolve) return getTypedValue();
				return basicGetTypedValue();
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY:
				if (resolve) return getTypedKey();
				return basicGetTypedKey();
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
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE:
				setTypedValue((StartDataPortInstance)newValue);
				return;
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY:
				setTypedKey((EndDataPortInstance)newValue);
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
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE:
				setTypedValue((StartDataPortInstance)null);
				return;
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY:
				setTypedKey((EndDataPortInstance)null);
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
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__VALUE:
				return value != null;
			case SofiaInstancePackage.END_DATA_PORT_TO_START_DATA_PORT_MAP_INSTANCE__KEY:
				return key != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndDataPortInstance getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKey(EndDataPortInstance key) {
		setTypedKey(key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPortInstance setValue(StartDataPortInstance value) {
		StartDataPortInstance oldValue = getValue();
		setTypedValue(value);
		return oldValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<EndDataPortInstance, StartDataPortInstance> getEMap() {
		EObject container = eContainer();
		return container == null ? null : (EMap<EndDataPortInstance, StartDataPortInstance>)container.eGet(eContainmentFeature());
	}

} //EndDataPortToStartDataPortMapInstanceImpl
