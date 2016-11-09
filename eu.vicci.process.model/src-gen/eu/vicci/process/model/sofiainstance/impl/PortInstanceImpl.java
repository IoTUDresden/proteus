/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.Port;

import eu.vicci.process.model.sofiainstance.CpsState;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.InstanceIdentifiable;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.Nameable;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.State;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getCpsExecutionState <em>Cps Execution State</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getInstanceId <em>Instance Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getInstancenumber <em>Instancenumber</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getPortType <em>Port Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getProcessStepInstance <em>Process Step Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getOutTransitionInstances <em>Out Transition Instances</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#isDecoupled <em>Decoupled</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getInTransitionInstances <em>In Transition Instances</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.PortInstanceImpl#getTypeId <em>Type Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PortInstanceImpl extends EObjectImpl implements PortInstance {
	/**
	 * The default value of the '{@link #getExecutionState() <em>Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionState()
	 * @generated
	 * @ordered
	 */
	protected static final State EXECUTION_STATE_EDEFAULT = State.ACTIVE;

	/**
	 * The default value of the '{@link #getCpsExecutionState() <em>Cps Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpsExecutionState()
	 * @generated
	 * @ordered
	 */
	protected static final CpsState CPS_EXECUTION_STATE_EDEFAULT = CpsState.FINISHED;

	/**
	 * The cached value of the '{@link #getCpsExecutionState() <em>Cps Execution State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCpsExecutionState()
	 * @generated
	 * @ordered
	 */
	protected CpsState cpsExecutionState = CPS_EXECUTION_STATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstanceId() <em>Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceId()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstanceId() <em>Instance Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstanceId()
	 * @generated
	 * @ordered
	 */
	protected String instanceId = INSTANCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstancenumber() <em>Instancenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstancenumber()
	 * @generated
	 * @ordered
	 */
	protected static final int INSTANCENUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInstancenumber() <em>Instancenumber</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstancenumber()
	 * @generated
	 * @ordered
	 */
	protected int instancenumber = INSTANCENUMBER_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPortType() <em>Port Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortType()
	 * @generated
	 * @ordered
	 */
	protected Port portType;

	/**
	 * The cached value of the '{@link #getOutTransitionInstances() <em>Out Transition Instances</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransitionInstances()
	 * @generated
	 * @ordered
	 */
	protected EList<TransitionInstance> outTransitionInstances;

	/**
	 * The default value of the '{@link #isDecoupled() <em>Decoupled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoupled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DECOUPLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDecoupled() <em>Decoupled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDecoupled()
	 * @generated
	 * @ordered
	 */
	protected boolean decoupled = DECOUPLED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInTransitionInstances() <em>In Transition Instances</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitionInstances()
	 * @generated
	 * @ordered
	 */
	protected TransitionInstance inTransitionInstances;

	/**
	 * The default value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTypeId() <em>Type Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeId()
	 * @generated
	 * @ordered
	 */
	protected String typeId = TYPE_ID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.PORT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State getExecutionState() {
		// TODO: implement this method to return the 'Execution State' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExecutionState(State newExecutionState) {
		// TODO: implement this method to set the 'Execution State' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CpsState getCpsExecutionState() {
		return cpsExecutionState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCpsExecutionState(CpsState newCpsExecutionState) {
		CpsState oldCpsExecutionState = cpsExecutionState;
		cpsExecutionState = newCpsExecutionState == null ? CPS_EXECUTION_STATE_EDEFAULT : newCpsExecutionState;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__CPS_EXECUTION_STATE, oldCpsExecutionState, cpsExecutionState));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstanceId() {
		return instanceId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstanceId(String newInstanceId) {
		String oldInstanceId = instanceId;
		instanceId = newInstanceId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID, oldInstanceId, instanceId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInstancenumber() {
		return instancenumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstancenumber(int newInstancenumber) {
		int oldInstancenumber = instancenumber;
		instancenumber = newInstancenumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER, oldInstancenumber, instancenumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getPortType() {
		if (portType != null && portType.eIsProxy()) {
			InternalEObject oldPortType = (InternalEObject)portType;
			portType = (Port)eResolveProxy(oldPortType);
			if (portType != oldPortType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE, oldPortType, portType));
			}
		}
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetPortType() {
		return portType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortType(Port newPortType) {
		Port oldPortType = portType;
		portType = newPortType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE, oldPortType, portType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStepInstance getProcessStepInstance() {
		if (eContainerFeatureID() != SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE) return null;
		return (ProcessStepInstance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessStepInstance(ProcessStepInstance newProcessStepInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProcessStepInstance, SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessStepInstance(ProcessStepInstance newProcessStepInstance) {
		if (newProcessStepInstance != eInternalContainer() || (eContainerFeatureID() != SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE && newProcessStepInstance != null)) {
			if (EcoreUtil.isAncestor(this, newProcessStepInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProcessStepInstance != null)
				msgs = ((InternalEObject)newProcessStepInstance).eInverseAdd(this, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS, ProcessStepInstance.class, msgs);
			msgs = basicSetProcessStepInstance(newProcessStepInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE, newProcessStepInstance, newProcessStepInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TransitionInstance> getOutTransitionInstances() {
		if (outTransitionInstances == null) {
			outTransitionInstances = new EObjectContainmentWithInverseEList<TransitionInstance>(TransitionInstance.class, this, SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES, SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE);
		}
		return outTransitionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDecoupled() {
		return decoupled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDecoupled(boolean newDecoupled) {
		boolean oldDecoupled = decoupled;
		decoupled = newDecoupled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__DECOUPLED, oldDecoupled, decoupled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionInstance getInTransitionInstances() {
		if (inTransitionInstances != null && inTransitionInstances.eIsProxy()) {
			InternalEObject oldInTransitionInstances = (InternalEObject)inTransitionInstances;
			inTransitionInstances = (TransitionInstance)eResolveProxy(oldInTransitionInstances);
			if (inTransitionInstances != oldInTransitionInstances) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, oldInTransitionInstances, inTransitionInstances));
			}
		}
		return inTransitionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionInstance basicGetInTransitionInstances() {
		return inTransitionInstances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInTransitionInstances(TransitionInstance newInTransitionInstances, NotificationChain msgs) {
		TransitionInstance oldInTransitionInstances = inTransitionInstances;
		inTransitionInstances = newInTransitionInstances;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, oldInTransitionInstances, newInTransitionInstances);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInTransitionInstances(TransitionInstance newInTransitionInstances) {
		if (newInTransitionInstances != inTransitionInstances) {
			NotificationChain msgs = null;
			if (inTransitionInstances != null)
				msgs = ((InternalEObject)inTransitionInstances).eInverseRemove(this, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, TransitionInstance.class, msgs);
			if (newInTransitionInstances != null)
				msgs = ((InternalEObject)newInTransitionInstances).eInverseAdd(this, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, TransitionInstance.class, msgs);
			msgs = basicSetInTransitionInstances(newInTransitionInstances, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, newInTransitionInstances, newInTransitionInstances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTypeId() {
		return typeId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeId(String newTypeId) {
		String oldTypeId = typeId;
		typeId = newTypeId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PORT_INSTANCE__TYPE_ID, oldTypeId, typeId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void deploy(MappingUtil mapper) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean activate(DataTypeInstance parameter) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void deactivate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProcessStepInstance((ProcessStepInstance)otherEnd, msgs);
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutTransitionInstances()).basicAdd(otherEnd, msgs);
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				if (inTransitionInstances != null)
					msgs = ((InternalEObject)inTransitionInstances).eInverseRemove(this, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, TransitionInstance.class, msgs);
				return basicSetInTransitionInstances((TransitionInstance)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				return basicSetProcessStepInstance(null, msgs);
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				return ((InternalEList<?>)getOutTransitionInstances()).basicRemove(otherEnd, msgs);
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				return basicSetInTransitionInstances(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				return eInternalContainer().eInverseRemove(this, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS, ProcessStepInstance.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaInstancePackage.PORT_INSTANCE__EXECUTION_STATE:
				return getExecutionState();
			case SofiaInstancePackage.PORT_INSTANCE__CPS_EXECUTION_STATE:
				return getCpsExecutionState();
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID:
				return getInstanceId();
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER:
				return getInstancenumber();
			case SofiaInstancePackage.PORT_INSTANCE__NAME:
				return getName();
			case SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE:
				if (resolve) return getPortType();
				return basicGetPortType();
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				return getProcessStepInstance();
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				return getOutTransitionInstances();
			case SofiaInstancePackage.PORT_INSTANCE__DECOUPLED:
				return isDecoupled();
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				if (resolve) return getInTransitionInstances();
				return basicGetInTransitionInstances();
			case SofiaInstancePackage.PORT_INSTANCE__TYPE_ID:
				return getTypeId();
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
			case SofiaInstancePackage.PORT_INSTANCE__EXECUTION_STATE:
				setExecutionState((State)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__CPS_EXECUTION_STATE:
				setCpsExecutionState((CpsState)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID:
				setInstanceId((String)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER:
				setInstancenumber((Integer)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__NAME:
				setName((String)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE:
				setPortType((Port)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				setProcessStepInstance((ProcessStepInstance)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				getOutTransitionInstances().clear();
				getOutTransitionInstances().addAll((Collection<? extends TransitionInstance>)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__DECOUPLED:
				setDecoupled((Boolean)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				setInTransitionInstances((TransitionInstance)newValue);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__TYPE_ID:
				setTypeId((String)newValue);
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
			case SofiaInstancePackage.PORT_INSTANCE__EXECUTION_STATE:
				setExecutionState(EXECUTION_STATE_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__CPS_EXECUTION_STATE:
				setCpsExecutionState(CPS_EXECUTION_STATE_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID:
				setInstanceId(INSTANCE_ID_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER:
				setInstancenumber(INSTANCENUMBER_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE:
				setPortType((Port)null);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				setProcessStepInstance((ProcessStepInstance)null);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				getOutTransitionInstances().clear();
				return;
			case SofiaInstancePackage.PORT_INSTANCE__DECOUPLED:
				setDecoupled(DECOUPLED_EDEFAULT);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				setInTransitionInstances((TransitionInstance)null);
				return;
			case SofiaInstancePackage.PORT_INSTANCE__TYPE_ID:
				setTypeId(TYPE_ID_EDEFAULT);
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
			case SofiaInstancePackage.PORT_INSTANCE__EXECUTION_STATE:
				return getExecutionState() != EXECUTION_STATE_EDEFAULT;
			case SofiaInstancePackage.PORT_INSTANCE__CPS_EXECUTION_STATE:
				return cpsExecutionState != CPS_EXECUTION_STATE_EDEFAULT;
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID:
				return INSTANCE_ID_EDEFAULT == null ? instanceId != null : !INSTANCE_ID_EDEFAULT.equals(instanceId);
			case SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER:
				return instancenumber != INSTANCENUMBER_EDEFAULT;
			case SofiaInstancePackage.PORT_INSTANCE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SofiaInstancePackage.PORT_INSTANCE__PORT_TYPE:
				return portType != null;
			case SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE:
				return getProcessStepInstance() != null;
			case SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES:
				return outTransitionInstances != null && !outTransitionInstances.isEmpty();
			case SofiaInstancePackage.PORT_INSTANCE__DECOUPLED:
				return decoupled != DECOUPLED_EDEFAULT;
			case SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES:
				return inTransitionInstances != null;
			case SofiaInstancePackage.PORT_INSTANCE__TYPE_ID:
				return TYPE_ID_EDEFAULT == null ? typeId != null : !TYPE_ID_EDEFAULT.equals(typeId);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InstanceIdentifiable.class) {
			switch (derivedFeatureID) {
				case SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID: return SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCE_ID;
				case SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER: return SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCENUMBER;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case SofiaInstancePackage.PORT_INSTANCE__NAME: return SofiaInstancePackage.NAMEABLE__NAME;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == InstanceIdentifiable.class) {
			switch (baseFeatureID) {
				case SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCE_ID: return SofiaInstancePackage.PORT_INSTANCE__INSTANCE_ID;
				case SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCENUMBER: return SofiaInstancePackage.PORT_INSTANCE__INSTANCENUMBER;
				default: return -1;
			}
		}
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case SofiaInstancePackage.NAMEABLE__NAME: return SofiaInstancePackage.PORT_INSTANCE__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (cpsExecutionState: ");
		result.append(cpsExecutionState);
		result.append(", instanceId: ");
		result.append(instanceId);
		result.append(", instancenumber: ");
		result.append(instancenumber);
		result.append(", name: ");
		result.append(name);
		result.append(", decoupled: ");
		result.append(decoupled);
		result.append(", typeId: ");
		result.append(typeId);
		result.append(')');
		return result.toString();
	}

} //PortInstanceImpl
