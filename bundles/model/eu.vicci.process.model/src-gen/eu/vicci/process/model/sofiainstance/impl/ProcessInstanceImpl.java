/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.ProcessInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessInstanceImpl#getRunningForInstanceId <em>Running For Instance Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessInstanceImpl extends ProcessStepInstanceImpl implements ProcessInstance {
	/**
	 * The default value of the '{@link #getRunningForInstanceId() <em>Running For Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunningForInstanceId()
	 * @generated
	 * @ordered
	 */
	protected static final String RUNNING_FOR_INSTANCE_ID_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getRunningForInstanceId() <em>Running For Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunningForInstanceId()
	 * @generated
	 * @ordered
	 */
	protected String runningForInstanceId = RUNNING_FOR_INSTANCE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.PROCESS_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRunningForInstanceId() {
		return runningForInstanceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunningForInstanceId(String newRunningForInstanceId) {
		String oldRunningForInstanceId = runningForInstanceId;
		runningForInstanceId = newRunningForInstanceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID, oldRunningForInstanceId, runningForInstanceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean start(Map<String, DataTypeInstance> parameters) {
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID:
				return getRunningForInstanceId();
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
			case SofiaInstancePackage.PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID:
				setRunningForInstanceId((String)newValue);
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
			case SofiaInstancePackage.PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID:
				setRunningForInstanceId(RUNNING_FOR_INSTANCE_ID_EDEFAULT);
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
			case SofiaInstancePackage.PROCESS_INSTANCE__RUNNING_FOR_INSTANCE_ID:
				return RUNNING_FOR_INSTANCE_ID_EDEFAULT == null ? runningForInstanceId != null : !RUNNING_FOR_INSTANCE_ID_EDEFAULT.equals(runningForInstanceId);
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
		result.append(" (runningForInstanceId: ");
		result.append(runningForInstanceId);
		result.append(')');
		return result.toString();
	}

} //ProcessInstanceImpl
