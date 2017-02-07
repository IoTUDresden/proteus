/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.DataType;

import eu.vicci.process.model.sofiainstance.CollectionTypeInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.CollectionTypeInstanceImpl#getCollectionItemType <em>Collection Item Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTypeInstanceImpl extends ComplexTypeInstanceImpl implements CollectionTypeInstance {
	/**
	 * The cached value of the '{@link #getCollectionItemType() <em>Collection Item Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCollectionItemType()
	 * @generated
	 * @ordered
	 */
	protected DataType collectionItemType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectionTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.COLLECTION_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getCollectionItemType() {
		return collectionItemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCollectionItemType(DataType newCollectionItemType, NotificationChain msgs) {
		DataType oldCollectionItemType = collectionItemType;
		collectionItemType = newCollectionItemType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE, oldCollectionItemType, newCollectionItemType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionItemType(DataType newCollectionItemType) {
		if (newCollectionItemType != collectionItemType) {
			NotificationChain msgs = null;
			if (collectionItemType != null)
				msgs = ((InternalEObject)collectionItemType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE, null, msgs);
			if (newCollectionItemType != null)
				msgs = ((InternalEObject)newCollectionItemType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE, null, msgs);
			msgs = basicSetCollectionItemType(newCollectionItemType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE, newCollectionItemType, newCollectionItemType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE:
				return basicSetCollectionItemType(null, msgs);
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
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE:
				return getCollectionItemType();
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
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE:
				setCollectionItemType((DataType)newValue);
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
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE:
				setCollectionItemType((DataType)null);
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
			case SofiaInstancePackage.COLLECTION_TYPE_INSTANCE__COLLECTION_ITEM_TYPE:
				return collectionItemType != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionTypeInstanceImpl
