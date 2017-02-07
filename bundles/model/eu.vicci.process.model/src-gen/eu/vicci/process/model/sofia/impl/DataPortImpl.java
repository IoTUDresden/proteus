/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.DataMapping;
import eu.vicci.process.model.sofia.DataPort;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataPortImpl#getValue <em>Value</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataPortImpl#getPortDatatype <em>Port Datatype</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.DataPortImpl#getMappings <em>Mappings</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class DataPortImpl extends PortImpl implements DataPort {
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
	 * The cached value of the '{@link #getPortDatatype() <em>Port Datatype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortDatatype()
	 * @generated
	 * @ordered
	 */
	protected DataType portDatatype;

	/**
	 * The cached value of the '{@link #getMappings() <em>Mappings</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<DataMapping> mappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.DATA_PORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.DATA_PORT__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getPortDatatype() {
		if (portDatatype != null && portDatatype.eIsProxy()) {
			InternalEObject oldPortDatatype = (InternalEObject)portDatatype;
			portDatatype = (DataType)eResolveProxy(oldPortDatatype);
			if (portDatatype != oldPortDatatype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.DATA_PORT__PORT_DATATYPE, oldPortDatatype, portDatatype));
			}
		}
		return portDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetPortDatatype() {
		return portDatatype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPortDatatype(DataType newPortDatatype, NotificationChain msgs) {
		DataType oldPortDatatype = portDatatype;
		portDatatype = newPortDatatype;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaPackage.DATA_PORT__PORT_DATATYPE, oldPortDatatype, newPortDatatype);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortDatatype(DataType newPortDatatype) {
		if (newPortDatatype != portDatatype) {
			NotificationChain msgs = null;
			if (portDatatype != null)
				msgs = ((InternalEObject)portDatatype).eInverseRemove(this, SofiaPackage.DATA_TYPE__PORT_MEMBERS, DataType.class, msgs);
			if (newPortDatatype != null)
				msgs = ((InternalEObject)newPortDatatype).eInverseAdd(this, SofiaPackage.DATA_TYPE__PORT_MEMBERS, DataType.class, msgs);
			msgs = basicSetPortDatatype(newPortDatatype, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.DATA_PORT__PORT_DATATYPE, newPortDatatype, newPortDatatype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataMapping> getMappings() {
		if (mappings == null) {
			mappings = new EObjectResolvingEList<DataMapping>(DataMapping.class, this, SofiaPackage.DATA_PORT__MAPPINGS);
		}
		return mappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				if (portDatatype != null)
					msgs = ((InternalEObject)portDatatype).eInverseRemove(this, SofiaPackage.DATA_TYPE__PORT_MEMBERS, DataType.class, msgs);
				return basicSetPortDatatype((DataType)otherEnd, msgs);
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
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				return basicSetPortDatatype(null, msgs);
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
			case SofiaPackage.DATA_PORT__VALUE:
				return getValue();
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				if (resolve) return getPortDatatype();
				return basicGetPortDatatype();
			case SofiaPackage.DATA_PORT__MAPPINGS:
				return getMappings();
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
			case SofiaPackage.DATA_PORT__VALUE:
				setValue((String)newValue);
				return;
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				setPortDatatype((DataType)newValue);
				return;
			case SofiaPackage.DATA_PORT__MAPPINGS:
				getMappings().clear();
				getMappings().addAll((Collection<? extends DataMapping>)newValue);
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
			case SofiaPackage.DATA_PORT__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				setPortDatatype((DataType)null);
				return;
			case SofiaPackage.DATA_PORT__MAPPINGS:
				getMappings().clear();
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
			case SofiaPackage.DATA_PORT__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case SofiaPackage.DATA_PORT__PORT_DATATYPE:
				return portDatatype != null;
			case SofiaPackage.DATA_PORT__MAPPINGS:
				return mappings != null && !mappings.isEmpty();
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

} //DataPortImpl
