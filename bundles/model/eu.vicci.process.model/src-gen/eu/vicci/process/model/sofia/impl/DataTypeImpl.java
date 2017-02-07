/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Identifiable;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataTypeImpl#getBelongsTo <em>Belongs To</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataTypeImpl#getMappings <em>Mappings</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataTypeImpl#getPortMembers <em>Port Members</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataTypeImpl extends NameableImpl implements DataType {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapping> mappings;

	/**
	 * The cached value of the '{@link #getPortMembers() <em>Port Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortMembers()
	 * @generated
	 * @ordered
	 */
	protected EList<DataPort> portMembers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.DATA_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.DATA_TYPE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType getBelongsTo() {
		if (eContainerFeatureID() != SofiaPackage.DATA_TYPE__BELONGS_TO) return null;
		return (ComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBelongsTo(ComplexType newBelongsTo, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBelongsTo, SofiaPackage.DATA_TYPE__BELONGS_TO, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBelongsTo(ComplexType newBelongsTo) {
		if (newBelongsTo != eInternalContainer() || (eContainerFeatureID() != SofiaPackage.DATA_TYPE__BELONGS_TO && newBelongsTo != null)) {
			if (EcoreUtil.isAncestor(this, newBelongsTo))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBelongsTo != null)
				msgs = ((InternalEObject)newBelongsTo).eInverseAdd(this, SofiaPackage.COMPLEX_TYPE__SUBTYPES, ComplexType.class, msgs);
			msgs = basicSetBelongsTo(newBelongsTo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.DATA_TYPE__BELONGS_TO, newBelongsTo, newBelongsTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectContainmentWithInverseEList<DataMapping>(DataMapping.class, this, SofiaPackage.DATA_TYPE__MAPPINGS, SofiaPackage.DATA_MAPPING__SOURCE);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataPort> getPortMembers() {
		if (portMembers == null) {
			portMembers = new EObjectWithInverseResolvingEList<DataPort>(DataPort.class, this, SofiaPackage.DATA_TYPE__PORT_MEMBERS, SofiaPackage.DATA_PORT__PORT_DATATYPE);
		}
		return portMembers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBelongsTo((ComplexType)otherEnd, msgs);
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappings()).basicAdd(otherEnd, msgs);
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPortMembers()).basicAdd(otherEnd, msgs);
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
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				return basicSetBelongsTo(null, msgs);
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				return ((InternalEList<?>)getMappings()).basicRemove(otherEnd, msgs);
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				return ((InternalEList<?>)getPortMembers()).basicRemove(otherEnd, msgs);
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
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				return eInternalContainer().eInverseRemove(this, SofiaPackage.COMPLEX_TYPE__SUBTYPES, ComplexType.class, msgs);
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
			case SofiaPackage.DATA_TYPE__ID:
				return getId();
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				return getBelongsTo();
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				return getMappings();
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				return getPortMembers();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SofiaPackage.DATA_TYPE__ID:
				setId((String)newValue);
				return;
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				setBelongsTo((ComplexType)newValue);
				return;
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends DataMapping>)newValue);
				return;
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				getPortMembers().clear();
				getPortMembers().addAll((Collection<? extends DataPort>)newValue);
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
			case SofiaPackage.DATA_TYPE__ID:
				setId(ID_EDEFAULT);
				return;
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				setBelongsTo((ComplexType)null);
				return;
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				getMappings().clear();
				return;
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				getPortMembers().clear();
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
			case SofiaPackage.DATA_TYPE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SofiaPackage.DATA_TYPE__BELONGS_TO:
				return getBelongsTo() != null;
			case SofiaPackage.DATA_TYPE__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
			case SofiaPackage.DATA_TYPE__PORT_MEMBERS:
				return portMembers != null && !portMembers.isEmpty();
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
		if (baseClass == Identifiable.class) {
			switch (derivedFeatureID) {
				case SofiaPackage.DATA_TYPE__ID: return SofiaPackage.IDENTIFIABLE__ID;
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
		if (baseClass == Identifiable.class) {
			switch (baseFeatureID) {
				case SofiaPackage.IDENTIFIABLE__ID: return SofiaPackage.DATA_TYPE__ID;
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //DataTypeImpl
