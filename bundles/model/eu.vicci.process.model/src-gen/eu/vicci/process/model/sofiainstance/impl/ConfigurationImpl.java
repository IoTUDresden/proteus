/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ConfigurationImpl#isDecoupleNextSteps <em>Decouple Next Steps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends InstanceIdentifiableImpl implements Configuration {
	/**
	 * The default value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected static final long DELAY_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getDelay() <em>Delay</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDelay()
	 * @generated
	 * @ordered
	 */
	protected long delay = DELAY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPermission() <em>Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermission()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionPermission PERMISSION_EDEFAULT = ExecutionPermission.DELAYED;

	/**
	 * The cached value of the '{@link #getPermission() <em>Permission</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPermission()
	 * @generated
	 * @ordered
	 */
	protected ExecutionPermission permission = PERMISSION_EDEFAULT;

	/**
	 * The default value of the '{@link #isDecoupleNextSteps() <em>Decouple Next Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoupleNextSteps()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECOUPLE_NEXT_STEPS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDecoupleNextSteps() <em>Decouple Next Steps</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoupleNextSteps()
	 * @generated
	 * @ordered
	 */
	protected boolean decoupleNextSteps = DECOUPLE_NEXT_STEPS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getDelay() {
		return delay;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDelay(long newDelay) {
		long oldDelay = delay;
		delay = newDelay;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONFIGURATION__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionPermission getPermission() {
		return permission;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPermission(ExecutionPermission newPermission) {
		ExecutionPermission oldPermission = permission;
		permission = newPermission == null ? PERMISSION_EDEFAULT : newPermission;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONFIGURATION__PERMISSION, oldPermission, permission));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecoupleNextSteps() {
		return decoupleNextSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoupleNextSteps(boolean newDecoupleNextSteps) {
		boolean oldDecoupleNextSteps = decoupleNextSteps;
		decoupleNextSteps = newDecoupleNextSteps;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.CONFIGURATION__DECOUPLE_NEXT_STEPS, oldDecoupleNextSteps, decoupleNextSteps));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.CONFIGURATION__DELAY:
				return getDelay();
			case SofiaInstancePackage.CONFIGURATION__PERMISSION:
				return getPermission();
			case SofiaInstancePackage.CONFIGURATION__DECOUPLE_NEXT_STEPS:
				return isDecoupleNextSteps();
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
			case SofiaInstancePackage.CONFIGURATION__DELAY:
				setDelay((Long)newValue);
				return;
			case SofiaInstancePackage.CONFIGURATION__PERMISSION:
				setPermission((ExecutionPermission)newValue);
				return;
			case SofiaInstancePackage.CONFIGURATION__DECOUPLE_NEXT_STEPS:
				setDecoupleNextSteps((Boolean)newValue);
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
			case SofiaInstancePackage.CONFIGURATION__DELAY:
				setDelay(DELAY_EDEFAULT);
				return;
			case SofiaInstancePackage.CONFIGURATION__PERMISSION:
				setPermission(PERMISSION_EDEFAULT);
				return;
			case SofiaInstancePackage.CONFIGURATION__DECOUPLE_NEXT_STEPS:
				setDecoupleNextSteps(DECOUPLE_NEXT_STEPS_EDEFAULT);
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
			case SofiaInstancePackage.CONFIGURATION__DELAY:
				return delay != DELAY_EDEFAULT;
			case SofiaInstancePackage.CONFIGURATION__PERMISSION:
				return permission != PERMISSION_EDEFAULT;
			case SofiaInstancePackage.CONFIGURATION__DECOUPLE_NEXT_STEPS:
				return decoupleNextSteps != DECOUPLE_NEXT_STEPS_EDEFAULT;
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
		result.append(" (delay: ");
		result.append(delay);
		result.append(", permission: ");
		result.append(permission);
		result.append(", decoupleNextSteps: ");
		result.append(decoupleNextSteps);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
