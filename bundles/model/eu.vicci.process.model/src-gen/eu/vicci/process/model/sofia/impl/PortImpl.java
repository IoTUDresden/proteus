/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.Nameable;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.Transition;

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
 * An implementation of the model object '<em><b>Port</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#getOutTransitions <em>Out Transitions</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#getProcessStep <em>Process Step</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#getInTransitions <em>In Transitions</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.PortImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PortImpl extends IdentifiableImpl implements Port {
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
	 * The cached value of the '{@link #getOutTransitions() <em>Out Transitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutTransitions()
	 * @generated
	 * @ordered
	 */
	protected EList<Transition> outTransitions;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInTransitions() <em>In Transitions</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInTransitions()
	 * @generated
	 * @ordered
	 */
	protected Transition inTransitions;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.PORT;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Transition> getOutTransitions() {
		if (outTransitions == null) {
			outTransitions = new EObjectContainmentWithInverseEList<Transition>(Transition.class, this, SofiaPackage.PORT__OUT_TRANSITIONS, SofiaPackage.TRANSITION__SOURCE_PORT);
		}
		return outTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessStep getProcessStep() {
		if (eContainerFeatureID() != SofiaPackage.PORT__PROCESS_STEP) return null;
		return (ProcessStep)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProcessStep(ProcessStep newProcessStep, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newProcessStep, SofiaPackage.PORT__PROCESS_STEP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessStep(ProcessStep newProcessStep) {
		if (newProcessStep != eInternalContainer() || (eContainerFeatureID() != SofiaPackage.PORT__PROCESS_STEP && newProcessStep != null)) {
			if (EcoreUtil.isAncestor(this, newProcessStep))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newProcessStep != null)
				msgs = ((InternalEObject)newProcessStep).eInverseAdd(this, SofiaPackage.PROCESS_STEP__PORTS, ProcessStep.class, msgs);
			msgs = basicSetProcessStep(newProcessStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__PROCESS_STEP, newProcessStep, newProcessStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getInTransitions() {
		if (inTransitions != null && inTransitions.eIsProxy()) {
			InternalEObject oldInTransitions = (InternalEObject)inTransitions;
			inTransitions = (Transition)eResolveProxy(oldInTransitions);
			if (inTransitions != oldInTransitions) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.PORT__IN_TRANSITIONS, oldInTransitions, inTransitions));
			}
		}
		return inTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetInTransitions() {
		return inTransitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInTransitions(Transition newInTransitions, NotificationChain msgs) {
		Transition oldInTransitions = inTransitions;
		inTransitions = newInTransitions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__IN_TRANSITIONS, oldInTransitions, newInTransitions);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInTransitions(Transition newInTransitions) {
		if (newInTransitions != inTransitions) {
			NotificationChain msgs = null;
			if (inTransitions != null)
				msgs = ((InternalEObject)inTransitions).eInverseRemove(this, SofiaPackage.TRANSITION__TARGET_PORT, Transition.class, msgs);
			if (newInTransitions != null)
				msgs = ((InternalEObject)newInTransitions).eInverseAdd(this, SofiaPackage.TRANSITION__TARGET_PORT, Transition.class, msgs);
			msgs = basicSetInTransitions(newInTransitions, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__IN_TRANSITIONS, newInTransitions, newInTransitions));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.PORT__DESCRIPTION, oldDescription, description));
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
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutTransitions()).basicAdd(otherEnd, msgs);
			case SofiaPackage.PORT__PROCESS_STEP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetProcessStep((ProcessStep)otherEnd, msgs);
			case SofiaPackage.PORT__IN_TRANSITIONS:
				if (inTransitions != null)
					msgs = ((InternalEObject)inTransitions).eInverseRemove(this, SofiaPackage.TRANSITION__TARGET_PORT, Transition.class, msgs);
				return basicSetInTransitions((Transition)otherEnd, msgs);
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
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				return ((InternalEList<?>)getOutTransitions()).basicRemove(otherEnd, msgs);
			case SofiaPackage.PORT__PROCESS_STEP:
				return basicSetProcessStep(null, msgs);
			case SofiaPackage.PORT__IN_TRANSITIONS:
				return basicSetInTransitions(null, msgs);
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
			case SofiaPackage.PORT__PROCESS_STEP:
				return eInternalContainer().eInverseRemove(this, SofiaPackage.PROCESS_STEP__PORTS, ProcessStep.class, msgs);
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
			case SofiaPackage.PORT__NAME:
				return getName();
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				return getOutTransitions();
			case SofiaPackage.PORT__OPTIONAL:
				return isOptional();
			case SofiaPackage.PORT__PROCESS_STEP:
				return getProcessStep();
			case SofiaPackage.PORT__IN_TRANSITIONS:
				if (resolve) return getInTransitions();
				return basicGetInTransitions();
			case SofiaPackage.PORT__DESCRIPTION:
				return getDescription();
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
			case SofiaPackage.PORT__NAME:
				setName((String)newValue);
				return;
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				getOutTransitions().clear();
				getOutTransitions().addAll((Collection<? extends Transition>)newValue);
				return;
			case SofiaPackage.PORT__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
			case SofiaPackage.PORT__PROCESS_STEP:
				setProcessStep((ProcessStep)newValue);
				return;
			case SofiaPackage.PORT__IN_TRANSITIONS:
				setInTransitions((Transition)newValue);
				return;
			case SofiaPackage.PORT__DESCRIPTION:
				setDescription((String)newValue);
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
			case SofiaPackage.PORT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				getOutTransitions().clear();
				return;
			case SofiaPackage.PORT__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
			case SofiaPackage.PORT__PROCESS_STEP:
				setProcessStep((ProcessStep)null);
				return;
			case SofiaPackage.PORT__IN_TRANSITIONS:
				setInTransitions((Transition)null);
				return;
			case SofiaPackage.PORT__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
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
			case SofiaPackage.PORT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SofiaPackage.PORT__OUT_TRANSITIONS:
				return outTransitions != null && !outTransitions.isEmpty();
			case SofiaPackage.PORT__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
			case SofiaPackage.PORT__PROCESS_STEP:
				return getProcessStep() != null;
			case SofiaPackage.PORT__IN_TRANSITIONS:
				return inTransitions != null;
			case SofiaPackage.PORT__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
				case SofiaPackage.PORT__NAME: return SofiaPackage.NAMEABLE__NAME;
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
				case SofiaPackage.NAMEABLE__NAME: return SofiaPackage.PORT__NAME;
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
		result.append(", optional: ");
		result.append(optional);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //PortImpl
