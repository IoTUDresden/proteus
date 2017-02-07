/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.OSGiInvoke;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OS Gi Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl#getServiceClassName <em>Service Class Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OSGiInvokeImpl#getBundleName <em>Bundle Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OSGiInvokeImpl extends InvokeImpl implements OSGiInvoke {
	/**
	 * The default value of the '{@link #getServiceClassName() <em>Service Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServiceClassName() <em>Service Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceClassName()
	 * @generated
	 * @ordered
	 */
	protected String serviceClassName = SERVICE_CLASS_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected static final String METHOD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMethodName() <em>Method Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodName()
	 * @generated
	 * @ordered
	 */
	protected String methodName = METHOD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected static final String PARAMETER_TYPES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected String parameterTypes = PARAMETER_TYPES_EDEFAULT;

	/**
	 * The default value of the '{@link #getBundleName() <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleName()
	 * @generated
	 * @ordered
	 */
	protected static final String BUNDLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBundleName() <em>Bundle Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBundleName()
	 * @generated
	 * @ordered
	 */
	protected String bundleName = BUNDLE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OSGiInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.OS_GI_INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServiceClassName() {
		return serviceClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceClassName(String newServiceClassName) {
		String oldServiceClassName = serviceClassName;
		serviceClassName = newServiceClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OS_GI_INVOKE__SERVICE_CLASS_NAME, oldServiceClassName, serviceClassName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodName(String newMethodName) {
		String oldMethodName = methodName;
		methodName = newMethodName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OS_GI_INVOKE__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getParameterTypes() {
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterTypes(String newParameterTypes) {
		String oldParameterTypes = parameterTypes;
		parameterTypes = newParameterTypes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OS_GI_INVOKE__PARAMETER_TYPES, oldParameterTypes, parameterTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBundleName() {
		return bundleName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBundleName(String newBundleName) {
		String oldBundleName = bundleName;
		bundleName = newBundleName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OS_GI_INVOKE__BUNDLE_NAME, oldBundleName, bundleName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.OS_GI_INVOKE__SERVICE_CLASS_NAME:
				return getServiceClassName();
			case SofiaPackage.OS_GI_INVOKE__METHOD_NAME:
				return getMethodName();
			case SofiaPackage.OS_GI_INVOKE__PARAMETER_TYPES:
				return getParameterTypes();
			case SofiaPackage.OS_GI_INVOKE__BUNDLE_NAME:
				return getBundleName();
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
			case SofiaPackage.OS_GI_INVOKE__SERVICE_CLASS_NAME:
				setServiceClassName((String)newValue);
				return;
			case SofiaPackage.OS_GI_INVOKE__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case SofiaPackage.OS_GI_INVOKE__PARAMETER_TYPES:
				setParameterTypes((String)newValue);
				return;
			case SofiaPackage.OS_GI_INVOKE__BUNDLE_NAME:
				setBundleName((String)newValue);
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
			case SofiaPackage.OS_GI_INVOKE__SERVICE_CLASS_NAME:
				setServiceClassName(SERVICE_CLASS_NAME_EDEFAULT);
				return;
			case SofiaPackage.OS_GI_INVOKE__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case SofiaPackage.OS_GI_INVOKE__PARAMETER_TYPES:
				setParameterTypes(PARAMETER_TYPES_EDEFAULT);
				return;
			case SofiaPackage.OS_GI_INVOKE__BUNDLE_NAME:
				setBundleName(BUNDLE_NAME_EDEFAULT);
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
			case SofiaPackage.OS_GI_INVOKE__SERVICE_CLASS_NAME:
				return SERVICE_CLASS_NAME_EDEFAULT == null ? serviceClassName != null : !SERVICE_CLASS_NAME_EDEFAULT.equals(serviceClassName);
			case SofiaPackage.OS_GI_INVOKE__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case SofiaPackage.OS_GI_INVOKE__PARAMETER_TYPES:
				return PARAMETER_TYPES_EDEFAULT == null ? parameterTypes != null : !PARAMETER_TYPES_EDEFAULT.equals(parameterTypes);
			case SofiaPackage.OS_GI_INVOKE__BUNDLE_NAME:
				return BUNDLE_NAME_EDEFAULT == null ? bundleName != null : !BUNDLE_NAME_EDEFAULT.equals(bundleName);
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
		result.append(" (serviceClassName: ");
		result.append(serviceClassName);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", parameterTypes: ");
		result.append(parameterTypes);
		result.append(", bundleName: ");
		result.append(bundleName);
		result.append(')');
		return result.toString();
	}

} //OSGiInvokeImpl
