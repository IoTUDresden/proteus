/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessImpl#getDataTypeDefinitions <em>Data Type Definitions</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessImpl#getExecutionPeer <em>Execution Peer</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessImpl#isDistributed <em>Distributed</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessImpl#isRemoteExecuting <em>Remote Executing</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImpl extends CompositeStepImpl implements eu.vicci.process.model.sofia.Process {
	/**
	 * The cached value of the '{@link #getDataTypeDefinitions() <em>Data Type Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> dataTypeDefinitions;

	/**
	 * The default value of the '{@link #getExecutionPeer() <em>Execution Peer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionPeer()
	 * @generated
	 * @ordered
	 */
	protected static final String EXECUTION_PEER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExecutionPeer() <em>Execution Peer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionPeer()
	 * @generated
	 * @ordered
	 */
	protected String executionPeer = EXECUTION_PEER_EDEFAULT;

	/**
	 * The default value of the '{@link #isDistributed() <em>Distributed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistributed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISTRIBUTED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDistributed() <em>Distributed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDistributed()
	 * @generated
	 * @ordered
	 */
	protected boolean distributed = DISTRIBUTED_EDEFAULT;

	/**
	 * The default value of the '{@link #isRemoteExecuting() <em>Remote Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteExecuting()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REMOTE_EXECUTING_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRemoteExecuting() <em>Remote Executing</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRemoteExecuting()
	 * @generated
	 * @ordered
	 */
	protected boolean remoteExecuting = REMOTE_EXECUTING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDataTypeDefinitions() {
		if (dataTypeDefinitions == null) {
			dataTypeDefinitions = new EObjectContainmentEList<DataType>(DataType.class, this, SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS);
		}
		return dataTypeDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getExecutionPeer() {
		return executionPeer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionPeer(String newExecutionPeer) {
		String oldExecutionPeer = executionPeer;
		executionPeer = newExecutionPeer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS__EXECUTION_PEER, oldExecutionPeer, executionPeer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDistributed() {
		return distributed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistributed(boolean newDistributed) {
		boolean oldDistributed = distributed;
		distributed = newDistributed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS__DISTRIBUTED, oldDistributed, distributed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRemoteExecuting() {
		return remoteExecuting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemoteExecuting(boolean newRemoteExecuting) {
		boolean oldRemoteExecuting = remoteExecuting;
		remoteExecuting = newRemoteExecuting;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS__REMOTE_EXECUTING, oldRemoteExecuting, remoteExecuting));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return ((InternalEList<?>)getDataTypeDefinitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return getDataTypeDefinitions();
			case SofiaPackage.PROCESS__EXECUTION_PEER:
				return getExecutionPeer();
			case SofiaPackage.PROCESS__DISTRIBUTED:
				return isDistributed();
			case SofiaPackage.PROCESS__REMOTE_EXECUTING:
				return isRemoteExecuting();
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				getDataTypeDefinitions().clear();
				getDataTypeDefinitions().addAll((Collection<? extends DataType>)newValue);
				return;
			case SofiaPackage.PROCESS__EXECUTION_PEER:
				setExecutionPeer((String)newValue);
				return;
			case SofiaPackage.PROCESS__DISTRIBUTED:
				setDistributed((Boolean)newValue);
				return;
			case SofiaPackage.PROCESS__REMOTE_EXECUTING:
				setRemoteExecuting((Boolean)newValue);
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				getDataTypeDefinitions().clear();
				return;
			case SofiaPackage.PROCESS__EXECUTION_PEER:
				setExecutionPeer(EXECUTION_PEER_EDEFAULT);
				return;
			case SofiaPackage.PROCESS__DISTRIBUTED:
				setDistributed(DISTRIBUTED_EDEFAULT);
				return;
			case SofiaPackage.PROCESS__REMOTE_EXECUTING:
				setRemoteExecuting(REMOTE_EXECUTING_EDEFAULT);
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return dataTypeDefinitions != null && !dataTypeDefinitions.isEmpty();
			case SofiaPackage.PROCESS__EXECUTION_PEER:
				return EXECUTION_PEER_EDEFAULT == null ? executionPeer != null : !EXECUTION_PEER_EDEFAULT.equals(executionPeer);
			case SofiaPackage.PROCESS__DISTRIBUTED:
				return distributed != DISTRIBUTED_EDEFAULT;
			case SofiaPackage.PROCESS__REMOTE_EXECUTING:
				return remoteExecuting != REMOTE_EXECUTING_EDEFAULT;
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
		result.append(" (executionPeer: ");
		result.append(executionPeer);
		result.append(", distributed: ");
		result.append(distributed);
		result.append(", remoteExecuting: ");
		result.append(remoteExecuting);
		result.append(')');
		return result.toString();
	}

} //ProcessImpl
