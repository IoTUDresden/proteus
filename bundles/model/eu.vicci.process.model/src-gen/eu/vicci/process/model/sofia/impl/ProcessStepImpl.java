/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.CompositeStep;
import eu.vicci.process.model.sofia.CpsStep;
import eu.vicci.process.model.sofia.Nameable;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#isCyberPhysical <em>Cyber Physical</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getGoal <em>Goal</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getEplQuery <em>Epl Query</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getControlProcessId <em>Control Process Id</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getControlProcess <em>Control Process</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getContext <em>Context</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getParentstep <em>Parentstep</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getType <em>Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessStepImpl#getResource <em>Resource</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ProcessStepImpl extends IdentifiableImpl implements ProcessStep {
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
	 * The default value of the '{@link #getGoal() <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected static final String GOAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGoal() <em>Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGoal()
	 * @generated
	 * @ordered
	 */
	protected String goal = GOAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getEplQuery() <em>Epl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEplQuery()
	 * @generated
	 * @ordered
	 */
	protected static final String EPL_QUERY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEplQuery() <em>Epl Query</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEplQuery()
	 * @generated
	 * @ordered
	 */
	protected String eplQuery = EPL_QUERY_EDEFAULT;

	/**
	 * The default value of the '{@link #getControlProcessId() <em>Control Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlProcessId()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTROL_PROCESS_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getControlProcessId() <em>Control Process Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlProcessId()
	 * @generated
	 * @ordered
	 */
	protected String controlProcessId = CONTROL_PROCESS_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getControlProcess() <em>Control Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlProcess()
	 * @generated
	 * @ordered
	 */
	protected eu.vicci.process.model.sofia.Process controlProcess;

	/**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected String context = CONTEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Port> ports;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected static final String RESOURCE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected String resource = RESOURCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.PROCESS_STEP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL, oldCyberPhysical, cyberPhysical));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getGoal() {
		return goal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGoal(String newGoal) {
		String oldGoal = goal;
		goal = newGoal;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__GOAL, oldGoal, goal));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEplQuery() {
		return eplQuery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEplQuery(String newEplQuery) {
		String oldEplQuery = eplQuery;
		eplQuery = newEplQuery;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__EPL_QUERY, oldEplQuery, eplQuery));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getControlProcessId() {
		return controlProcessId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlProcessId(String newControlProcessId) {
		String oldControlProcessId = controlProcessId;
		controlProcessId = newControlProcessId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID, oldControlProcessId, controlProcessId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public eu.vicci.process.model.sofia.Process getControlProcess() {
		if (controlProcess != null && controlProcess.eIsProxy()) {
			InternalEObject oldControlProcess = (InternalEObject)controlProcess;
			controlProcess = (eu.vicci.process.model.sofia.Process)eResolveProxy(oldControlProcess);
			if (controlProcess != oldControlProcess) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.PROCESS_STEP__CONTROL_PROCESS, oldControlProcess, controlProcess));
			}
		}
		return controlProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public eu.vicci.process.model.sofia.Process basicGetControlProcess() {
		return controlProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlProcess(eu.vicci.process.model.sofia.Process newControlProcess) {
		eu.vicci.process.model.sofia.Process oldControlProcess = controlProcess;
		controlProcess = newControlProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__CONTROL_PROCESS, oldControlProcess, controlProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__CONTEXT, oldContext, context));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeStep getParentstep() {
		if (eContainerFeatureID() != SofiaPackage.PROCESS_STEP__PARENTSTEP) return null;
		return (CompositeStep)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentstep(CompositeStep newParentstep, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentstep, SofiaPackage.PROCESS_STEP__PARENTSTEP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentstep(CompositeStep newParentstep) {
		if (newParentstep != eInternalContainer() || (eContainerFeatureID() != SofiaPackage.PROCESS_STEP__PARENTSTEP && newParentstep != null)) {
			if (EcoreUtil.isAncestor(this, newParentstep))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentstep != null)
				msgs = ((InternalEObject)newParentstep).eInverseAdd(this, SofiaPackage.COMPOSITE_STEP__SUB_STEPS, CompositeStep.class, msgs);
			msgs = basicSetParentstep(newParentstep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__PARENTSTEP, newParentstep, newParentstep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Port> getPorts() {
		if (ports == null) {
			ports = new EObjectContainmentWithInverseEList<Port>(Port.class, this, SofiaPackage.PROCESS_STEP__PORTS, SofiaPackage.PORT__PROCESS_STEP);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(String newResource) {
		String oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PROCESS_STEP__RESOURCE, oldResource, resource));
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
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentstep((CompositeStep)otherEnd, msgs);
			case SofiaPackage.PROCESS_STEP__PORTS:
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
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				return basicSetParentstep(null, msgs);
			case SofiaPackage.PROCESS_STEP__PORTS:
				return ((InternalEList<?>)getPorts()).basicRemove(otherEnd, msgs);
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
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				return eInternalContainer().eInverseRemove(this, SofiaPackage.COMPOSITE_STEP__SUB_STEPS, CompositeStep.class, msgs);
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
			case SofiaPackage.PROCESS_STEP__NAME:
				return getName();
			case SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL:
				return isCyberPhysical();
			case SofiaPackage.PROCESS_STEP__GOAL:
				return getGoal();
			case SofiaPackage.PROCESS_STEP__EPL_QUERY:
				return getEplQuery();
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID:
				return getControlProcessId();
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS:
				if (resolve) return getControlProcess();
				return basicGetControlProcess();
			case SofiaPackage.PROCESS_STEP__CONTEXT:
				return getContext();
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				return getParentstep();
			case SofiaPackage.PROCESS_STEP__PORTS:
				return getPorts();
			case SofiaPackage.PROCESS_STEP__TYPE:
				return getType();
			case SofiaPackage.PROCESS_STEP__DESCRIPTION:
				return getDescription();
			case SofiaPackage.PROCESS_STEP__RESOURCE:
				return getResource();
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
			case SofiaPackage.PROCESS_STEP__NAME:
				setName((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL:
				setCyberPhysical((Boolean)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__GOAL:
				setGoal((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__EPL_QUERY:
				setEplQuery((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID:
				setControlProcessId((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS:
				setControlProcess((eu.vicci.process.model.sofia.Process)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__CONTEXT:
				setContext((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				setParentstep((CompositeStep)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__PORTS:
				getPorts().clear();
				getPorts().addAll((Collection<? extends Port>)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__TYPE:
				setType((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case SofiaPackage.PROCESS_STEP__RESOURCE:
				setResource((String)newValue);
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
			case SofiaPackage.PROCESS_STEP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL:
				setCyberPhysical(CYBER_PHYSICAL_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__GOAL:
				setGoal(GOAL_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__EPL_QUERY:
				setEplQuery(EPL_QUERY_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID:
				setControlProcessId(CONTROL_PROCESS_ID_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS:
				setControlProcess((eu.vicci.process.model.sofia.Process)null);
				return;
			case SofiaPackage.PROCESS_STEP__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				setParentstep((CompositeStep)null);
				return;
			case SofiaPackage.PROCESS_STEP__PORTS:
				getPorts().clear();
				return;
			case SofiaPackage.PROCESS_STEP__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case SofiaPackage.PROCESS_STEP__RESOURCE:
				setResource(RESOURCE_EDEFAULT);
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
			case SofiaPackage.PROCESS_STEP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL:
				return cyberPhysical != CYBER_PHYSICAL_EDEFAULT;
			case SofiaPackage.PROCESS_STEP__GOAL:
				return GOAL_EDEFAULT == null ? goal != null : !GOAL_EDEFAULT.equals(goal);
			case SofiaPackage.PROCESS_STEP__EPL_QUERY:
				return EPL_QUERY_EDEFAULT == null ? eplQuery != null : !EPL_QUERY_EDEFAULT.equals(eplQuery);
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID:
				return CONTROL_PROCESS_ID_EDEFAULT == null ? controlProcessId != null : !CONTROL_PROCESS_ID_EDEFAULT.equals(controlProcessId);
			case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS:
				return controlProcess != null;
			case SofiaPackage.PROCESS_STEP__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
			case SofiaPackage.PROCESS_STEP__PARENTSTEP:
				return getParentstep() != null;
			case SofiaPackage.PROCESS_STEP__PORTS:
				return ports != null && !ports.isEmpty();
			case SofiaPackage.PROCESS_STEP__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case SofiaPackage.PROCESS_STEP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case SofiaPackage.PROCESS_STEP__RESOURCE:
				return RESOURCE_EDEFAULT == null ? resource != null : !RESOURCE_EDEFAULT.equals(resource);
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
		if (baseClass == Nameable.class) {
			switch (derivedFeatureID) {
				case SofiaPackage.PROCESS_STEP__NAME: return SofiaPackage.NAMEABLE__NAME;
				default: return -1;
			}
		}
		if (baseClass == CpsStep.class) {
			switch (derivedFeatureID) {
				case SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL: return SofiaPackage.CPS_STEP__CYBER_PHYSICAL;
				case SofiaPackage.PROCESS_STEP__GOAL: return SofiaPackage.CPS_STEP__GOAL;
				case SofiaPackage.PROCESS_STEP__EPL_QUERY: return SofiaPackage.CPS_STEP__EPL_QUERY;
				case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID: return SofiaPackage.CPS_STEP__CONTROL_PROCESS_ID;
				case SofiaPackage.PROCESS_STEP__CONTROL_PROCESS: return SofiaPackage.CPS_STEP__CONTROL_PROCESS;
				case SofiaPackage.PROCESS_STEP__CONTEXT: return SofiaPackage.CPS_STEP__CONTEXT;
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
		if (baseClass == Nameable.class) {
			switch (baseFeatureID) {
				case SofiaPackage.NAMEABLE__NAME: return SofiaPackage.PROCESS_STEP__NAME;
				default: return -1;
			}
		}
		if (baseClass == CpsStep.class) {
			switch (baseFeatureID) {
				case SofiaPackage.CPS_STEP__CYBER_PHYSICAL: return SofiaPackage.PROCESS_STEP__CYBER_PHYSICAL;
				case SofiaPackage.CPS_STEP__GOAL: return SofiaPackage.PROCESS_STEP__GOAL;
				case SofiaPackage.CPS_STEP__EPL_QUERY: return SofiaPackage.PROCESS_STEP__EPL_QUERY;
				case SofiaPackage.CPS_STEP__CONTROL_PROCESS_ID: return SofiaPackage.PROCESS_STEP__CONTROL_PROCESS_ID;
				case SofiaPackage.CPS_STEP__CONTROL_PROCESS: return SofiaPackage.PROCESS_STEP__CONTROL_PROCESS;
				case SofiaPackage.CPS_STEP__CONTEXT: return SofiaPackage.PROCESS_STEP__CONTEXT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", cyberPhysical: ");
		result.append(cyberPhysical);
		result.append(", goal: ");
		result.append(goal);
		result.append(", eplQuery: ");
		result.append(eplQuery);
		result.append(", controlProcessId: ");
		result.append(controlProcessId);
		result.append(", context: ");
		result.append(context);
		result.append(", type: ");
		result.append(type);
		result.append(", description: ");
		result.append(description);
		result.append(", resource: ");
		result.append(resource);
		result.append(')');
		return result.toString();
	}

} //ProcessStepImpl
