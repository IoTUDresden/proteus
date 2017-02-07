/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.CollectionType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.CollectionTypeImpl#getCollectionItemType <em>Collection Item Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectionTypeImpl extends DataTypeImpl implements CollectionType {
	/**
	 * The cached value of the '{@link #getCollectionItemType() <em>Collection Item Type</em>}' reference.
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
	protected CollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getCollectionItemType() {
		if (collectionItemType != null && collectionItemType.eIsProxy()) {
			InternalEObject oldCollectionItemType = (InternalEObject)collectionItemType;
			collectionItemType = (DataType)eResolveProxy(oldCollectionItemType);
			if (collectionItemType != oldCollectionItemType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE, oldCollectionItemType, collectionItemType));
			}
		}
		return collectionItemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetCollectionItemType() {
		return collectionItemType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCollectionItemType(DataType newCollectionItemType) {
		DataType oldCollectionItemType = collectionItemType;
		collectionItemType = newCollectionItemType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE, oldCollectionItemType, collectionItemType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE:
				if (resolve) return getCollectionItemType();
				return basicGetCollectionItemType();
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
			case SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE:
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
			case SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE:
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
			case SofiaPackage.COLLECTION_TYPE__COLLECTION_ITEM_TYPE:
				return collectionItemType != null;
		}
		return super.eIsSet(featureID);
	}

} //CollectionTypeImpl
