/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.ProcessStep;

import eu.vicci.process.model.sofiainstance.Configuration;
import eu.vicci.process.model.sofiainstance.CpsState;
import eu.vicci.process.model.sofiainstance.ExecutionPermission;
import eu.vicci.process.model.sofiainstance.InstanceIdentifiable;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.ProcessStepInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.State;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Step Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getExecutionState <em>Execution State</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getCpsExecutionState <em>Cps Execution State</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getInstanceId <em>Instance Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getInstancenumber <em>Instancenumber</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getProcessStepType <em>Process Step Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getPermission <em>Permission</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getDelay <em>Delay</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getSubSteps <em>Sub Steps</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getProcessInstanceID <em>Process Instance ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getProcessModelID <em>Process Model ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#getModelID <em>Model ID</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.ProcessStepInstanceImpl#isCyberPhysical <em>Cyber Physical</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessStepInstanceImpl extends EObjectImpl implements ProcessStepInstance {
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
	 * The cached value of the '{@link #getProcessStepType() <em>Process Step Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessStepType()
	 * @generated
	 * @ordered
	 */
	protected ProcessStep processStepType;

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
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<PortInstance> ports;

	/**
	 * The cached value of the '{@link #getSubSteps() <em>Sub Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcessStepInstance> subSteps;

	/**
	 * The default value of the '{@link #getProcessInstanceID() <em>Process Instance ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessInstanceID()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESS_INSTANCE_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessInstanceID() <em>Process Instance ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessInstanceID()
	 * @generated
	 * @ordered
	 */
	protected String processInstanceID = PROCESS_INSTANCE_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcessModelID() <em>Process Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessModelID()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESS_MODEL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessModelID() <em>Process Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessModelID()
	 * @generated
	 * @ordered
	 */
	protected String processModelID = PROCESS_MODEL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getModelID() <em>Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelID()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelID() <em>Model ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelID()
	 * @generated
	 * @ordered
	 */
	protected String modelID = MODEL_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #isCyberPhysical() <em>Cyber Physical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCyberPhysical()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CYBER_PHYSICAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCyberPhysical() <em>Cyber Physical</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCyberPhysical()
	 * @generated
	 * @ordered
	 */
	protected boolean cyberPhysical = CYBER_PHYSICAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessStepInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.PROCESS_STEP_INSTANCE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE, oldCpsExecutionState, cpsExecutionState));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID, oldInstanceId, instanceId));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER, oldInstancenumber, instancenumber));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStep getProcessStepType() {
		if (processStepType != null && processStepType.eIsProxy()) {
			InternalEObject oldProcessStepType = (InternalEObject)processStepType;
			processStepType = (ProcessStep)eResolveProxy(oldProcessStepType);
			if (processStepType != oldProcessStepType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE, oldProcessStepType, processStepType));
			}
		}
		return processStepType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStep basicGetProcessStepType() {
		return processStepType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessStepType(ProcessStep newProcessStepType) {
		ProcessStep oldProcessStepType = processStepType;
		processStepType = newProcessStepType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE, oldProcessStepType, processStepType));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PERMISSION, oldPermission, permission));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__DELAY, oldDelay, delay));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PortInstance> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<PortInstance>(PortInstance.class, this, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS, SofiaInstancePackage.PORT_INSTANCE__PROCESS_STEP_INSTANCE);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcessStepInstance> getSubSteps() {
		if (subSteps == null) {
			subSteps = new EObjectContainmentEList<ProcessStepInstance>(ProcessStepInstance.class, this, SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS);
		}
		return subSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessInstanceID() {
		return processInstanceID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessInstanceID(String newProcessInstanceID) {
		String oldProcessInstanceID = processInstanceID;
		processInstanceID = newProcessInstanceID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID, oldProcessInstanceID, processInstanceID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcessModelID() {
		return processModelID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessModelID(String newProcessModelID) {
		String oldProcessModelID = processModelID;
		processModelID = newProcessModelID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID, oldProcessModelID, processModelID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelID() {
		return modelID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelID(String newModelID) {
		String oldModelID = modelID;
		modelID = newModelID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__MODEL_ID, oldModelID, modelID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCyberPhysical() {
		return cyberPhysical;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCyberPhysical(boolean newCyberPhysical) {
		boolean oldCyberPhysical = cyberPhysical;
		cyberPhysical = newCyberPhysical;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.PROCESS_STEP_INSTANCE__CYBER_PHYSICAL, oldCyberPhysical, cyberPhysical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean execute() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void stop() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void pause() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void kill() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
	public String configure(Configuration Configuration) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void escalate() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void resume() {
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPorts()).basicAdd(otherEnd, msgs);
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS:
				return ((InternalEList<?>)getSubSteps()).basicRemove(otherEnd, msgs);
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__EXECUTION_STATE:
				return getExecutionState();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE:
				return getCpsExecutionState();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID:
				return getInstanceId();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER:
				return getInstancenumber();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE:
				if (resolve) return getProcessStepType();
				return basicGetProcessStepType();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PERMISSION:
				return getPermission();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__DELAY:
				return getDelay();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				return getPorts();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS:
				return getSubSteps();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID:
				return getProcessInstanceID();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID:
				return getProcessModelID();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__MODEL_ID:
				return getModelID();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CYBER_PHYSICAL:
				return isCyberPhysical();
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__EXECUTION_STATE:
				setExecutionState((State)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE:
				setCpsExecutionState((CpsState)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID:
				setInstanceId((String)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER:
				setInstancenumber((Integer)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE:
				setProcessStepType((ProcessStep)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PERMISSION:
				setPermission((ExecutionPermission)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__DELAY:
				setDelay((Long)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends PortInstance>)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS:
				getSubSteps().clear();
				getSubSteps().addAll((Collection<? extends ProcessStepInstance>)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID:
				setProcessInstanceID((String)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID:
				setProcessModelID((String)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__MODEL_ID:
				setModelID((String)newValue);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CYBER_PHYSICAL:
				setCyberPhysical((Boolean)newValue);
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__EXECUTION_STATE:
				setExecutionState(EXECUTION_STATE_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE:
				setCpsExecutionState(CPS_EXECUTION_STATE_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID:
				setInstanceId(INSTANCE_ID_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER:
				setInstancenumber(INSTANCENUMBER_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE:
				setProcessStepType((ProcessStep)null);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PERMISSION:
				setPermission(PERMISSION_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__DELAY:
				setDelay(DELAY_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				getPorts().clear();
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS:
				getSubSteps().clear();
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID:
				setProcessInstanceID(PROCESS_INSTANCE_ID_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID:
				setProcessModelID(PROCESS_MODEL_ID_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__MODEL_ID:
				setModelID(MODEL_ID_EDEFAULT);
				return;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CYBER_PHYSICAL:
				setCyberPhysical(CYBER_PHYSICAL_EDEFAULT);
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
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__EXECUTION_STATE:
				return getExecutionState() != EXECUTION_STATE_EDEFAULT;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CPS_EXECUTION_STATE:
				return cpsExecutionState != CPS_EXECUTION_STATE_EDEFAULT;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID:
				return INSTANCE_ID_EDEFAULT == null ? instanceId != null : !INSTANCE_ID_EDEFAULT.equals(instanceId);
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER:
				return instancenumber != INSTANCENUMBER_EDEFAULT;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_STEP_TYPE:
				return processStepType != null;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PERMISSION:
				return permission != PERMISSION_EDEFAULT;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__DELAY:
				return delay != DELAY_EDEFAULT;
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PORTS:
				return ports != null && !ports.isEmpty();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__SUB_STEPS:
				return subSteps != null && !subSteps.isEmpty();
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_INSTANCE_ID:
				return PROCESS_INSTANCE_ID_EDEFAULT == null ? processInstanceID != null : !PROCESS_INSTANCE_ID_EDEFAULT.equals(processInstanceID);
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__PROCESS_MODEL_ID:
				return PROCESS_MODEL_ID_EDEFAULT == null ? processModelID != null : !PROCESS_MODEL_ID_EDEFAULT.equals(processModelID);
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__MODEL_ID:
				return MODEL_ID_EDEFAULT == null ? modelID != null : !MODEL_ID_EDEFAULT.equals(modelID);
			case SofiaInstancePackage.PROCESS_STEP_INSTANCE__CYBER_PHYSICAL:
				return cyberPhysical != CYBER_PHYSICAL_EDEFAULT;
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
				case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID: return SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCE_ID;
				case SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER: return SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCENUMBER;
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
				case SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCE_ID: return SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCE_ID;
				case SofiaInstancePackage.INSTANCE_IDENTIFIABLE__INSTANCENUMBER: return SofiaInstancePackage.PROCESS_STEP_INSTANCE__INSTANCENUMBER;
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
		result.append(", permission: ");
		result.append(permission);
		result.append(", delay: ");
		result.append(delay);
		result.append(", processInstanceID: ");
		result.append(processInstanceID);
		result.append(", processModelID: ");
		result.append(processModelID);
		result.append(", modelID: ");
		result.append(modelID);
		result.append(", cyberPhysical: ");
		result.append(cyberPhysical);
		result.append(')');
		return result.toString();
	}

} //ProcessStepInstanceImpl
