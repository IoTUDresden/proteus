/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.XMLRPCInvoke;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMLRPC Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl#getServerUri <em>Server Uri</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl#getMethodName <em>Method Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl#getStartParameterSequence <em>Start Parameter Sequence</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.XMLRPCInvokeImpl#getEndParameterSequence <em>End Parameter Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XMLRPCInvokeImpl extends InvokeImpl implements XMLRPCInvoke {
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
	 * The default value of the '{@link #getStartParameterSequence() <em>Start Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartParameterSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String START_PARAMETER_SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartParameterSequence() <em>Start Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartParameterSequence()
	 * @generated
	 * @ordered
	 */
	protected String startParameterSequence = START_PARAMETER_SEQUENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndParameterSequence() <em>End Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndParameterSequence()
	 * @generated
	 * @ordered
	 */
	protected static final String END_PARAMETER_SEQUENCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndParameterSequence() <em>End Parameter Sequence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndParameterSequence()
	 * @generated
	 * @ordered
	 */
	protected String endParameterSequence = END_PARAMETER_SEQUENCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMLRPCInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.XMLRPC_INVOKE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.XMLRPC_INVOKE__SERVER_URI, oldServerUri, serverUri));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.XMLRPC_INVOKE__METHOD_NAME, oldMethodName, methodName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getStartParameterSequence() {
		return startParameterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartParameterSequence(String newStartParameterSequence) {
		String oldStartParameterSequence = startParameterSequence;
		startParameterSequence = newStartParameterSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.XMLRPC_INVOKE__START_PARAMETER_SEQUENCE, oldStartParameterSequence, startParameterSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEndParameterSequence() {
		return endParameterSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndParameterSequence(String newEndParameterSequence) {
		String oldEndParameterSequence = endParameterSequence;
		endParameterSequence = newEndParameterSequence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.XMLRPC_INVOKE__END_PARAMETER_SEQUENCE, oldEndParameterSequence, endParameterSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.XMLRPC_INVOKE__SERVER_URI:
				return getServerUri();
			case SofiaPackage.XMLRPC_INVOKE__METHOD_NAME:
				return getMethodName();
			case SofiaPackage.XMLRPC_INVOKE__START_PARAMETER_SEQUENCE:
				return getStartParameterSequence();
			case SofiaPackage.XMLRPC_INVOKE__END_PARAMETER_SEQUENCE:
				return getEndParameterSequence();
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
			case SofiaPackage.XMLRPC_INVOKE__SERVER_URI:
				setServerUri((String)newValue);
				return;
			case SofiaPackage.XMLRPC_INVOKE__METHOD_NAME:
				setMethodName((String)newValue);
				return;
			case SofiaPackage.XMLRPC_INVOKE__START_PARAMETER_SEQUENCE:
				setStartParameterSequence((String)newValue);
				return;
			case SofiaPackage.XMLRPC_INVOKE__END_PARAMETER_SEQUENCE:
				setEndParameterSequence((String)newValue);
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
			case SofiaPackage.XMLRPC_INVOKE__SERVER_URI:
				setServerUri(SERVER_URI_EDEFAULT);
				return;
			case SofiaPackage.XMLRPC_INVOKE__METHOD_NAME:
				setMethodName(METHOD_NAME_EDEFAULT);
				return;
			case SofiaPackage.XMLRPC_INVOKE__START_PARAMETER_SEQUENCE:
				setStartParameterSequence(START_PARAMETER_SEQUENCE_EDEFAULT);
				return;
			case SofiaPackage.XMLRPC_INVOKE__END_PARAMETER_SEQUENCE:
				setEndParameterSequence(END_PARAMETER_SEQUENCE_EDEFAULT);
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
			case SofiaPackage.XMLRPC_INVOKE__SERVER_URI:
				return SERVER_URI_EDEFAULT == null ? serverUri != null : !SERVER_URI_EDEFAULT.equals(serverUri);
			case SofiaPackage.XMLRPC_INVOKE__METHOD_NAME:
				return METHOD_NAME_EDEFAULT == null ? methodName != null : !METHOD_NAME_EDEFAULT.equals(methodName);
			case SofiaPackage.XMLRPC_INVOKE__START_PARAMETER_SEQUENCE:
				return START_PARAMETER_SEQUENCE_EDEFAULT == null ? startParameterSequence != null : !START_PARAMETER_SEQUENCE_EDEFAULT.equals(startParameterSequence);
			case SofiaPackage.XMLRPC_INVOKE__END_PARAMETER_SEQUENCE:
				return END_PARAMETER_SEQUENCE_EDEFAULT == null ? endParameterSequence != null : !END_PARAMETER_SEQUENCE_EDEFAULT.equals(endParameterSequence);
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
		result.append(", startParameterSequence: ");
		result.append(startParameterSequence);
		result.append(", endParameterSequence: ");
		result.append(endParameterSequence);
		result.append(')');
		return result.toString();
	}

} //XMLRPCInvokeImpl
