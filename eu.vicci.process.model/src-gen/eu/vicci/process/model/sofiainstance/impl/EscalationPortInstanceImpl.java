/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.EscalationPortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Escalation Port Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.EscalationPortInstanceImpl#getEscalationReason <em>Escalation Reason</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EscalationPortInstanceImpl extends EndControlPortInstanceImpl implements EscalationPortInstance {
	/**
	 * The default value of the '{@link #getEscalationReason() <em>Escalation Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationReason()
	 * @generated
	 * @ordered
	 */
	protected static final String ESCALATION_REASON_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEscalationReason() <em>Escalation Reason</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationReason()
	 * @generated
	 * @ordered
	 */
	protected String escalationReason = ESCALATION_REASON_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EscalationPortInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.ESCALATION_PORT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEscalationReason() {
		return escalationReason;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscalationReason(String newEscalationReason) {
		String oldEscalationReason = escalationReason;
		escalationReason = newEscalationReason;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.ESCALATION_PORT_INSTANCE__ESCALATION_REASON, oldEscalationReason, escalationReason));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE__ESCALATION_REASON:
				return getEscalationReason();
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
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE__ESCALATION_REASON:
				setEscalationReason((String)newValue);
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
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE__ESCALATION_REASON:
				setEscalationReason(ESCALATION_REASON_EDEFAULT);
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
			case SofiaInstancePackage.ESCALATION_PORT_INSTANCE__ESCALATION_REASON:
				return ESCALATION_REASON_EDEFAULT == null ? escalationReason != null : !ESCALATION_REASON_EDEFAULT.equals(escalationReason);
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
		result.append(" (escalationReason: ");
		result.append(escalationReason);
		result.append(')');
		return result.toString();
	}

} //EscalationPortInstanceImpl
