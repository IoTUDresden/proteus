/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.SeMiWaRequest;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Se Mi Wa Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.SeMiWaRequestImpl#getSSILStatement <em>SSIL Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SeMiWaRequestImpl extends AtomicStepImpl implements SeMiWaRequest {
	/**
	 * The default value of the '{@link #getSSILStatement() <em>SSIL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSILStatement()
	 * @generated
	 * @ordered
	 */
	protected static final String SSIL_STATEMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSSILStatement() <em>SSIL Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSSILStatement()
	 * @generated
	 * @ordered
	 */
	protected String ssilStatement = SSIL_STATEMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeMiWaRequestImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.SE_MI_WA_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSSILStatement() {
		return ssilStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSSILStatement(String newSSILStatement) {
		String oldSSILStatement = ssilStatement;
		ssilStatement = newSSILStatement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.SE_MI_WA_REQUEST__SSIL_STATEMENT, oldSSILStatement, ssilStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.SE_MI_WA_REQUEST__SSIL_STATEMENT:
				return getSSILStatement();
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
			case SofiaPackage.SE_MI_WA_REQUEST__SSIL_STATEMENT:
				setSSILStatement((String)newValue);
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
			case SofiaPackage.SE_MI_WA_REQUEST__SSIL_STATEMENT:
				setSSILStatement(SSIL_STATEMENT_EDEFAULT);
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
			case SofiaPackage.SE_MI_WA_REQUEST__SSIL_STATEMENT:
				return SSIL_STATEMENT_EDEFAULT == null ? ssilStatement != null : !SSIL_STATEMENT_EDEFAULT.equals(ssilStatement);
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
		result.append(" (SSILStatement: ");
		result.append(ssilStatement);
		result.append(')');
		return result.toString();
	}

} //SeMiWaRequestImpl
