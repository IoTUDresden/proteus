/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.DataType;

import eu.vicci.process.model.sofiainstance.ComplexTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.Nameable;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl#getDataTypeType <em>Data Type Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl#getBelongsTo <em>Belongs To</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl#getIdOfOrigin <em>Id Of Origin</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.DataTypeInstanceImpl#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataTypeInstanceImpl extends InstanceIdentifiableImpl implements DataTypeInstance {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDataTypeType() <em>Data Type Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataTypeType;

	/**
	 * The default value of the '{@link #getIdOfOrigin() <em>Id Of Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOfOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_OF_ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIdOfOrigin() <em>Id Of Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdOfOrigin()
	 * @generated
	 * @ordered
	 */
	protected String idOfOrigin = ID_OF_ORIGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected String typeId = TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.DATA_TYPE_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataTypeType() {
		if (dataTypeType != null && dataTypeType.eIsProxy()) {
			InternalEObject oldDataTypeType = (InternalEObject)dataTypeType;
			dataTypeType = (DataType)eResolveProxy(oldDataTypeType);
			if (dataTypeType != oldDataTypeType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE, oldDataTypeType, dataTypeType));
			}
		}
		return dataTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetDataTypeType() {
		return dataTypeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataTypeType(DataType newDataTypeType) {
		DataType oldDataTypeType = dataTypeType;
		dataTypeType = newDataTypeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE, oldDataTypeType, dataTypeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexTypeInstance getBelongsTo() {
		if (eContainerFeatureID() != SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO) return null;
		return (ComplexTypeInstance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBelongsTo(ComplexTypeInstance newBelongsTo, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBelongsTo, SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBelongsTo(ComplexTypeInstance newBelongsTo) {
		if (newBelongsTo != eInternalContainer() || (eContainerFeatureID() != SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO && newBelongsTo != null)) {
			if (EcoreUtil.isAncestor(this, newBelongsTo))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBelongsTo != null)
				msgs = ((InternalEObject)newBelongsTo).eInverseAdd(this, SofiaInstancePackage.COMPLEX_TYPE_INSTANCE__SUBTYPES, ComplexTypeInstance.class, msgs);
			msgs = basicSetBelongsTo(newBelongsTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO, newBelongsTo, newBelongsTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getIdOfOrigin() {
		return idOfOrigin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdOfOrigin(String newIdOfOrigin) {
		String oldIdOfOrigin = idOfOrigin;
		idOfOrigin = newIdOfOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_TYPE_INSTANCE__ID_OF_ORIGIN, oldIdOfOrigin, idOfOrigin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeId(String newTypeId) {
		String oldTypeId = typeId;
		typeId = newTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.DATA_TYPE_INSTANCE__TYPE_ID, oldTypeId, typeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void parse(String text) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int compareTo(EObject o) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String serializeToXML() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean deserializeFromXML(String xmlInstance) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeInstance copy() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String serializeToJSON() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean deserializeFromJSON(String jsonString) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueFromString(String value) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getValueAsObject() {
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBelongsTo((ComplexTypeInstance)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				return basicSetBelongsTo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				return eInternalContainer().eInverseRemove(this, SofiaInstancePackage.COMPLEX_TYPE_INSTANCE__SUBTYPES, ComplexTypeInstance.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME:
				return getName();
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE:
				if (resolve) return getDataTypeType();
				return basicGetDataTypeType();
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				return getBelongsTo();
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__ID_OF_ORIGIN:
				return getIdOfOrigin();
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__TYPE_ID:
				return getTypeId();
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
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE:
				setDataTypeType((DataType)newValue);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				setBelongsTo((ComplexTypeInstance)newValue);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__ID_OF_ORIGIN:
				setIdOfOrigin((String)newValue);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__TYPE_ID:
				setTypeId((String)newValue);
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
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE:
				setDataTypeType((DataType)null);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				setBelongsTo((ComplexTypeInstance)null);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__ID_OF_ORIGIN:
				setIdOfOrigin(ID_OF_ORIGIN_EDEFAULT);
				return;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__TYPE_ID:
				setTypeId(TYPE_ID_EDEFAULT);
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
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__DATA_TYPE_TYPE:
				return dataTypeType != null;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__BELONGS_TO:
				return getBelongsTo() != null;
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__ID_OF_ORIGIN:
				return ID_OF_ORIGIN_EDEFAULT == null ? idOfOrigin != null : !ID_OF_ORIGIN_EDEFAULT.equals(idOfOrigin);
			case SofiaInstancePackage.DATA_TYPE_INSTANCE__TYPE_ID:
				return TYPE_ID_EDEFAULT == null ? typeId != null : !TYPE_ID_EDEFAULT.equals(typeId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME: return SofiaInstancePackage.NAMEABLE__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case SofiaInstancePackage.NAMEABLE__NAME: return SofiaInstancePackage.DATA_TYPE_INSTANCE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", idOfOrigin: ");
		result.append(idOfOrigin);
		result.append(", typeId: ");
		result.append(typeId);
		result.append(')');
		return result.toString();
	}

} //DataTypeInstanceImpl
