/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.LoadClassStep;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Load Class Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.LoadClassStepImpl#getDelegateClassName <em>Delegate Class Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LoadClassStepImpl extends AtomicStepImpl implements LoadClassStep {
	/**
	 * The default value of the '{@link #getDelegateClassName() <em>Delegate Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegateClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String DELEGATE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDelegateClassName() <em>Delegate Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelegateClassName()
	 * @generated
	 * @ordered
	 */
	protected String delegateClassName = DELEGATE_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoadClassStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.LOAD_CLASS_STEP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDelegateClassName() {
		return delegateClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelegateClassName(String newDelegateClassName) {
		String oldDelegateClassName = delegateClassName;
		delegateClassName = newDelegateClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.LOAD_CLASS_STEP__DELEGATE_CLASS_NAME, oldDelegateClassName, delegateClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.LOAD_CLASS_STEP__DELEGATE_CLASS_NAME:
				return getDelegateClassName();
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
			case SofiaPackage.LOAD_CLASS_STEP__DELEGATE_CLASS_NAME:
				setDelegateClassName((String)newValue);
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
			case SofiaPackage.LOAD_CLASS_STEP__DELEGATE_CLASS_NAME:
				setDelegateClassName(DELEGATE_CLASS_NAME_EDEFAULT);
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
			case SofiaPackage.LOAD_CLASS_STEP__DELEGATE_CLASS_NAME:
				return DELEGATE_CLASS_NAME_EDEFAULT == null ? delegateClassName != null : !DELEGATE_CLASS_NAME_EDEFAULT.equals(delegateClassName);
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
		result.append(" (delegateClassName: ");
		result.append(delegateClassName);
		result.append(')');
		return result.toString();
	}

} //LoadClassStepImpl
