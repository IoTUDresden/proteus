/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.TriggeredEvent;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Triggered Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.TriggeredEventImpl#getEPLStatement <em>EPL Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TriggeredEventImpl extends EventImpl implements TriggeredEvent {
	/**
	 * The default value of the '{@link #getEPLStatement() <em>EPL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPLStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String EPL_STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEPLStatement() <em>EPL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEPLStatement()
	 * @generated
	 * @ordered
	 */
	protected String eplStatement = EPL_STATEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TriggeredEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.TRIGGERED_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEPLStatement() {
		return eplStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEPLStatement(String newEPLStatement) {
		String oldEPLStatement = eplStatement;
		eplStatement = newEPLStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.TRIGGERED_EVENT__EPL_STATEMENT, oldEPLStatement, eplStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.TRIGGERED_EVENT__EPL_STATEMENT:
				return getEPLStatement();
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
			case SofiaPackage.TRIGGERED_EVENT__EPL_STATEMENT:
				setEPLStatement((String)newValue);
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
			case SofiaPackage.TRIGGERED_EVENT__EPL_STATEMENT:
				setEPLStatement(EPL_STATEMENT_EDEFAULT);
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
			case SofiaPackage.TRIGGERED_EVENT__EPL_STATEMENT:
				return EPL_STATEMENT_EDEFAULT == null ? eplStatement != null : !EPL_STATEMENT_EDEFAULT.equals(eplStatement);
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
		result.append(" (EPLStatement: ");
		result.append(eplStatement);
		result.append(')');
		return result.toString();
	}

} //TriggeredEventImpl
