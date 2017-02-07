/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.SOAPInvoke;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SOAP Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl#getWsdlUri <em>Wsdl Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.SOAPInvokeImpl#getConfigFile <em>Config File</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SOAPInvokeImpl extends InvokeImpl implements SOAPInvoke {
	/**
	 * The default value of the '{@link #getServerUri() <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUri()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerUri() <em>Server Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerUri()
	 * @generated
	 * @ordered
	 */
	protected String serverUri = SERVER_URI_EDEFAULT;

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
	 * The default value of the '{@link #getWsdlUri() <em>Wsdl Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlUri()
	 * @generated
	 * @ordered
	 */
	protected static final String WSDL_URI_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWsdlUri() <em>Wsdl Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWsdlUri()
	 * @generated
	 * @ordered
	 */
	protected String wsdlUri = WSDL_URI_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfigFile() <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected static final String CONFIG_FILE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConfigFile() <em>Config File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigFile()
	 * @generated
	 * @ordered
	 */
	protected String configFile = CONFIG_FILE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SOAPInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.SOAP_INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerUri() {
		return serverUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerUri(String newServerUri) {
		String oldServerUri = serverUri;
		serverUri = newServerUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.SOAP_INVOKE__SERVER_URI, oldServerUri, serverUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.SOAP_INVOKE__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getWsdlUri() {
		return wsdlUri;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWsdlUri(String newWsdlUri) {
		String oldWsdlUri = wsdlUri;
		wsdlUri = newWsdlUri;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.SOAP_INVOKE__WSDL_URI, oldWsdlUri, wsdlUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getConfigFile() {
		return configFile;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfigFile(String newConfigFile) {
		String oldConfigFile = configFile;
		configFile = newConfigFile;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.SOAP_INVOKE__CONFIG_FILE, oldConfigFile, configFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.SOAP_INVOKE__SERVER_URI:
				return getServerUri();
			case SofiaPackage.SOAP_INVOKE__METHOD_NAME:
				return getMethodName();
			case SofiaPackage.SOAP_INVOKE__WSDL_URI:
				return getWsdlUri();
			case SofiaPackage.SOAP_INVOKE__CONFIG_FILE:
				return getConfigFile();
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
			case SofiaPackage.SOAP_INVOKE__SERVER_URI:
				setServerUri((String)newValue);
				return;
			case SofiaPackage.SOAP_INVOKE__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case SofiaPackage.SOAP_INVOKE__WSDL_URI:
				setWsdlUri((String)newValue);
				return;
			case SofiaPackage.SOAP_INVOKE__CONFIG_FILE:
				setConfigFile((String)newValue);
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
			case SofiaPackage.SOAP_INVOKE__SERVER_URI:
				setServerUri(SERVER_URI_EDEFAULT);
				return;
			case SofiaPackage.SOAP_INVOKE__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case SofiaPackage.SOAP_INVOKE__WSDL_URI:
				setWsdlUri(WSDL_URI_EDEFAULT);
				return;
			case SofiaPackage.SOAP_INVOKE__CONFIG_FILE:
				setConfigFile(CONFIG_FILE_EDEFAULT);
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
			case SofiaPackage.SOAP_INVOKE__SERVER_URI:
				return SERVER_URI_EDEFAULT == null ? serverUri != null : !SERVER_URI_EDEFAULT.equals(serverUri);
			case SofiaPackage.SOAP_INVOKE__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case SofiaPackage.SOAP_INVOKE__WSDL_URI:
				return WSDL_URI_EDEFAULT == null ? wsdlUri != null : !WSDL_URI_EDEFAULT.equals(wsdlUri);
			case SofiaPackage.SOAP_INVOKE__CONFIG_FILE:
				return CONFIG_FILE_EDEFAULT == null ? configFile != null : !CONFIG_FILE_EDEFAULT.equals(configFile);
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
		result.append(" (serverUri: ");
		result.append(serverUri);
		result.append(", methodName: ");
		result.append(methodName);
		result.append(", wsdlUri: ");
		result.append(wsdlUri);
		result.append(", configFile: ");
		result.append(configFile);
		result.append(')');
		return result.toString();
	}

} //SOAPInvokeImpl
