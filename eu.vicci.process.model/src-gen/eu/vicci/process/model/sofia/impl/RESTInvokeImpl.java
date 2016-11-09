/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.HTTPverb;
import eu.vicci.process.model.sofia.RESTInvoke;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>REST Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.RESTInvokeImpl#getHTTPMethod <em>HTTP Method</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.RESTInvokeImpl#getServerUri <em>Server Uri</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RESTInvokeImpl extends InvokeImpl implements RESTInvoke {
	/**
	 * The default value of the '{@link #getHTTPMethod() <em>HTTP Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHTTPMethod()
	 * @generated
	 * @ordered
	 */
	protected static final HTTPverb HTTP_METHOD_EDEFAULT = HTTPverb.PUT;

	/**
	 * The cached value of the '{@link #getHTTPMethod() <em>HTTP Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHTTPMethod()
	 * @generated
	 * @ordered
	 */
	protected HTTPverb httpMethod = HTTP_METHOD_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RESTInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.REST_INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HTTPverb getHTTPMethod() {
		return httpMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHTTPMethod(HTTPverb newHTTPMethod) {
		HTTPverb oldHTTPMethod = httpMethod;
		httpMethod = newHTTPMethod == null ? HTTP_METHOD_EDEFAULT : newHTTPMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.REST_INVOKE__HTTP_METHOD, oldHTTPMethod, httpMethod));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.REST_INVOKE__SERVER_URI, oldServerUri, serverUri));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.REST_INVOKE__HTTP_METHOD:
				return getHTTPMethod();
			case SofiaPackage.REST_INVOKE__SERVER_URI:
				return getServerUri();
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
			case SofiaPackage.REST_INVOKE__HTTP_METHOD:
				setHTTPMethod((HTTPverb)newValue);
				return;
			case SofiaPackage.REST_INVOKE__SERVER_URI:
				setServerUri((String)newValue);
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
			case SofiaPackage.REST_INVOKE__HTTP_METHOD:
				setHTTPMethod(HTTP_METHOD_EDEFAULT);
				return;
			case SofiaPackage.REST_INVOKE__SERVER_URI:
				setServerUri(SERVER_URI_EDEFAULT);
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
			case SofiaPackage.REST_INVOKE__HTTP_METHOD:
				return httpMethod != HTTP_METHOD_EDEFAULT;
			case SofiaPackage.REST_INVOKE__SERVER_URI:
				return SERVER_URI_EDEFAULT == null ? serverUri != null : !SERVER_URI_EDEFAULT.equals(serverUri);
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
		result.append(" (HTTPMethod: ");
		result.append(httpMethod);
		result.append(", ServerUri: ");
		result.append(serverUri);
		result.append(')');
		return result.toString();
	}

} //RESTInvokeImpl
