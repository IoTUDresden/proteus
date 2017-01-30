/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.OpenHabSemanticInvoke;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Open Hab Semantic Invoke</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl#getQuery <em>Query</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl#getServerBaseAddress <em>Server Base Address</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.OpenHabSemanticInvokeImpl#isWithLatest <em>With Latest</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class OpenHabSemanticInvokeImpl extends InvokeImpl implements OpenHabSemanticInvoke {
	/**
	 * The default value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQuery() <em>Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQuery()
	 * @generated
	 * @ordered
	 */
	protected String query = QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getServerBaseAddress() <em>Server Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVER_BASE_ADDRESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getServerBaseAddress() <em>Server Base Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServerBaseAddress()
	 * @generated
	 * @ordered
	 */
	protected String serverBaseAddress = SERVER_BASE_ADDRESS_EDEFAULT;

	/**
	 * The default value of the '{@link #isWithLatest() <em>With Latest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithLatest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WITH_LATEST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWithLatest() <em>With Latest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWithLatest()
	 * @generated
	 * @ordered
	 */
	protected boolean withLatest = WITH_LATEST_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OpenHabSemanticInvokeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.OPEN_HAB_SEMANTIC_INVOKE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQuery(String newQuery) {
		String oldQuery = query;
		query = newQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__QUERY, oldQuery, query));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getServerBaseAddress() {
		return serverBaseAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServerBaseAddress(String newServerBaseAddress) {
		String oldServerBaseAddress = serverBaseAddress;
		serverBaseAddress = newServerBaseAddress;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS, oldServerBaseAddress, serverBaseAddress));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWithLatest() {
		return withLatest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWithLatest(boolean newWithLatest) {
		boolean oldWithLatest = withLatest;
		withLatest = newWithLatest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST, oldWithLatest, withLatest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__QUERY:
				return getQuery();
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS:
				return getServerBaseAddress();
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST:
				return isWithLatest();
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
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__QUERY:
				setQuery((String)newValue);
				return;
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS:
				setServerBaseAddress((String)newValue);
				return;
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST:
				setWithLatest((Boolean)newValue);
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
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__QUERY:
				setQuery(QUERY_EDEFAULT);
				return;
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS:
				setServerBaseAddress(SERVER_BASE_ADDRESS_EDEFAULT);
				return;
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST:
				setWithLatest(WITH_LATEST_EDEFAULT);
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
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__QUERY:
				return QUERY_EDEFAULT == null ? query != null : !QUERY_EDEFAULT.equals(query);
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__SERVER_BASE_ADDRESS:
				return SERVER_BASE_ADDRESS_EDEFAULT == null ? serverBaseAddress != null : !SERVER_BASE_ADDRESS_EDEFAULT.equals(serverBaseAddress);
			case SofiaPackage.OPEN_HAB_SEMANTIC_INVOKE__WITH_LATEST:
				return withLatest != WITH_LATEST_EDEFAULT;
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
		result.append(" (query: ");
		result.append(query);
		result.append(", serverBaseAddress: ");
		result.append(serverBaseAddress);
		result.append(", withLatest: ");
		result.append(withLatest);
		result.append(')');
		return result.toString();
	}

} //OpenHabSemanticInvokeImpl
