/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.GoalInvoke;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Goal Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.GoalInvokeImpl#getInvokeGoal <em>Invoke Goal</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.GoalInvokeImpl#getQualities <em>Qualities</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.GoalInvokeImpl#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GoalInvokeImpl extends InvokeImpl implements GoalInvoke {
	/**
	 * The default value of the '{@link #getInvokeGoal() <em>Invoke Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokeGoal()
	 * @generated
	 * @ordered
	 */
	protected static final String INVOKE_GOAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInvokeGoal() <em>Invoke Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokeGoal()
	 * @generated
	 * @ordered
	 */
	protected String invokeGoal = INVOKE_GOAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQualities() <em>Qualities</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualities()
	 * @generated
	 * @ordered
	 */
	protected EList<String> qualities;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GoalInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.GOAL_INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInvokeGoal() {
		return invokeGoal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInvokeGoal(String newInvokeGoal) {
		String oldInvokeGoal = invokeGoal;
		invokeGoal = newInvokeGoal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.GOAL_INVOKE__INVOKE_GOAL, oldInvokeGoal, invokeGoal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getQualities() {
		if (qualities == null) {
			qualities = new EDataTypeUniqueEList<String>(String.class, this, SofiaPackage.GOAL_INVOKE__QUALITIES);
		}
		return qualities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.GOAL_INVOKE__LOCATION, oldLocation, location));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.GOAL_INVOKE__INVOKE_GOAL:
				return getInvokeGoal();
			case SofiaPackage.GOAL_INVOKE__QUALITIES:
				return getQualities();
			case SofiaPackage.GOAL_INVOKE__LOCATION:
				return getLocation();
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
			case SofiaPackage.GOAL_INVOKE__INVOKE_GOAL:
				setInvokeGoal((String)newValue);
				return;
			case SofiaPackage.GOAL_INVOKE__QUALITIES:
				getQualities().clear();
				getQualities().addAll((Collection<? extends String>)newValue);
				return;
			case SofiaPackage.GOAL_INVOKE__LOCATION:
				setLocation((String)newValue);
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
			case SofiaPackage.GOAL_INVOKE__INVOKE_GOAL:
				setInvokeGoal(INVOKE_GOAL_EDEFAULT);
				return;
			case SofiaPackage.GOAL_INVOKE__QUALITIES:
				getQualities().clear();
				return;
			case SofiaPackage.GOAL_INVOKE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
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
			case SofiaPackage.GOAL_INVOKE__INVOKE_GOAL:
				return INVOKE_GOAL_EDEFAULT == null ? invokeGoal != null : !INVOKE_GOAL_EDEFAULT.equals(invokeGoal);
			case SofiaPackage.GOAL_INVOKE__QUALITIES:
				return qualities != null && !qualities.isEmpty();
			case SofiaPackage.GOAL_INVOKE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
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
		result.append(" (invokeGoal: ");
		result.append(invokeGoal);
		result.append(", qualities: ");
		result.append(qualities);
		result.append(", location: ");
		result.append(location);
		result.append(')');
		return result.toString();
	}

} //GoalInvokeImpl
