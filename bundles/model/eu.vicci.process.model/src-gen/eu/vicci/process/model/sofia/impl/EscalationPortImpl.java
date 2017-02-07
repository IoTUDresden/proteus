/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.EscalationPort;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Escalation Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.EscalationPortImpl#getEscalationTime <em>Escalation Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EscalationPortImpl extends EndControlPortImpl implements EscalationPort {
	/**
	 * The default value of the '{@link #getEscalationTime() <em>Escalation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationTime()
	 * @generated
	 * @ordered
	 */
	protected static final long ESCALATION_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getEscalationTime() <em>Escalation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEscalationTime()
	 * @generated
	 * @ordered
	 */
	protected long escalationTime = ESCALATION_TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EscalationPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.ESCALATION_PORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getEscalationTime() {
		return escalationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEscalationTime(long newEscalationTime) {
		long oldEscalationTime = escalationTime;
		escalationTime = newEscalationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.ESCALATION_PORT__ESCALATION_TIME, oldEscalationTime, escalationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.ESCALATION_PORT__ESCALATION_TIME:
				return getEscalationTime();
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
			case SofiaPackage.ESCALATION_PORT__ESCALATION_TIME:
				setEscalationTime((Long)newValue);
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
			case SofiaPackage.ESCALATION_PORT__ESCALATION_TIME:
				setEscalationTime(ESCALATION_TIME_EDEFAULT);
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
			case SofiaPackage.ESCALATION_PORT__ESCALATION_TIME:
				return escalationTime != ESCALATION_TIME_EDEFAULT;
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
		result.append(" (escalationTime: ");
		result.append(escalationTime);
		result.append(')');
		return result.toString();
	}

} //EscalationPortImpl
