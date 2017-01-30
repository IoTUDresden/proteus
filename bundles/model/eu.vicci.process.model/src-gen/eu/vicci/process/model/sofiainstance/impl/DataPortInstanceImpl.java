/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.DataPortInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Port Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataPortInstanceImpl#getDataInstance <em>Data Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataPortInstanceImpl extends PortInstanceImpl implements DataPortInstance {
	/**
	 * The cached value of the '{@link #getDataInstance() <em>Data Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataInstance()
	 * @generated
	 * @ordered
	 */
	protected DataTypeInstance dataInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataPortInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.DATA_PORT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeInstance getDataInstance() {
		return dataInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataInstance(DataTypeInstance newDataInstance, NotificationChain msgs) {
		DataTypeInstance oldDataInstance = dataInstance;
		dataInstance = newDataInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE, oldDataInstance, newDataInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataInstance(DataTypeInstance newDataInstance) {
		if (newDataInstance != dataInstance) {
			NotificationChain msgs = null;
			if (dataInstance != null)
				msgs = ((InternalEObject)dataInstance).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE, null, msgs);
			if (newDataInstance != null)
				msgs = ((InternalEObject)newDataInstance).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE, null, msgs);
			msgs = basicSetDataInstance(newDataInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE, newDataInstance, newDataInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE:
				return basicSetDataInstance(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE:
				return getDataInstance();
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
			case SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE:
				setDataInstance((DataTypeInstance)newValue);
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
			case SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE:
				setDataInstance((DataTypeInstance)null);
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
			case SofiaInstancePackage.DATA_PORT_INSTANCE__DATA_INSTANCE:
				return dataInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //DataPortInstanceImpl
