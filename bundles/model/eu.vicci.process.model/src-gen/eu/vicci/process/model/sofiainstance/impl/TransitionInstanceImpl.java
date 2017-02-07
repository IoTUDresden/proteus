/**
 */
package eu.vicci.process.model.sofiainstance.impl;

import eu.vicci.process.model.sofia.Transition;

import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.MappingUtil;
import eu.vicci.process.model.sofiainstance.PortInstance;
import eu.vicci.process.model.sofiainstance.SofiaInstancePackage;
import eu.vicci.process.model.sofiainstance.TransitionInstance;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl#getTransitionType <em>Transition Type</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl#getSourcePortInstance <em>Source Port Instance</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofiainstance.impl.TransitionInstanceImpl#getTargetPortInstance <em>Target Port Instance</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionInstanceImpl extends InstanceIdentifiableImpl implements TransitionInstance {
	/**
	 * The cached value of the '{@link #getTransitionType() <em>Transition Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransitionType()
	 * @generated
	 * @ordered
	 */
	protected Transition transitionType;

	/**
	 * The cached value of the '{@link #getTargetPortInstance() <em>Target Port Instance</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPortInstance()
	 * @generated
	 * @ordered
	 */
	protected PortInstance targetPortInstance;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaInstancePackage.Literals.TRANSITION_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition getTransitionType() {
		if (transitionType != null && transitionType.eIsProxy()) {
			InternalEObject oldTransitionType = (InternalEObject)transitionType;
			transitionType = (Transition)eResolveProxy(oldTransitionType);
			if (transitionType != oldTransitionType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE, oldTransitionType, transitionType));
			}
		}
		return transitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transition basicGetTransitionType() {
		return transitionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransitionType(Transition newTransitionType) {
		Transition oldTransitionType = transitionType;
		transitionType = newTransitionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE, oldTransitionType, transitionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortInstance getSourcePortInstance() {
		if (eContainerFeatureID() != SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE) return null;
		return (PortInstance)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePortInstance(PortInstance newSourcePortInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourcePortInstance, SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePortInstance(PortInstance newSourcePortInstance) {
		if (newSourcePortInstance != eInternalContainer() || (eContainerFeatureID() != SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE && newSourcePortInstance != null)) {
			if (EcoreUtil.isAncestor(this, newSourcePortInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourcePortInstance != null)
				msgs = ((InternalEObject)newSourcePortInstance).eInverseAdd(this, SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES, PortInstance.class, msgs);
			msgs = basicSetSourcePortInstance(newSourcePortInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE, newSourcePortInstance, newSourcePortInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortInstance getTargetPortInstance() {
		if (targetPortInstance != null && targetPortInstance.eIsProxy()) {
			InternalEObject oldTargetPortInstance = (InternalEObject)targetPortInstance;
			targetPortInstance = (PortInstance)eResolveProxy(oldTargetPortInstance);
			if (targetPortInstance != oldTargetPortInstance) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, oldTargetPortInstance, targetPortInstance));
			}
		}
		return targetPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortInstance basicGetTargetPortInstance() {
		return targetPortInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPortInstance(PortInstance newTargetPortInstance, NotificationChain msgs) {
		PortInstance oldTargetPortInstance = targetPortInstance;
		targetPortInstance = newTargetPortInstance;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, oldTargetPortInstance, newTargetPortInstance);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPortInstance(PortInstance newTargetPortInstance) {
		if (newTargetPortInstance != targetPortInstance) {
			NotificationChain msgs = null;
			if (targetPortInstance != null)
				msgs = ((InternalEObject)targetPortInstance).eInverseRemove(this, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, PortInstance.class, msgs);
			if (newTargetPortInstance != null)
				msgs = ((InternalEObject)newTargetPortInstance).eInverseAdd(this, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, PortInstance.class, msgs);
			msgs = basicSetTargetPortInstance(newTargetPortInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE, newTargetPortInstance, newTargetPortInstance));
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
	public boolean execute(DataTypeInstance parameter) {
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
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourcePortInstance((PortInstance)otherEnd, msgs);
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				if (targetPortInstance != null)
					msgs = ((InternalEObject)targetPortInstance).eInverseRemove(this, SofiaInstancePackage.PORT_INSTANCE__IN_TRANSITION_INSTANCES, PortInstance.class, msgs);
				return basicSetTargetPortInstance((PortInstance)otherEnd, msgs);
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				return basicSetSourcePortInstance(null, msgs);
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				return basicSetTargetPortInstance(null, msgs);
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				return eInternalContainer().eInverseRemove(this, SofiaInstancePackage.PORT_INSTANCE__OUT_TRANSITION_INSTANCES, PortInstance.class, msgs);
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE:
				if (resolve) return getTransitionType();
				return basicGetTransitionType();
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				return getSourcePortInstance();
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				if (resolve) return getTargetPortInstance();
				return basicGetTargetPortInstance();
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE:
				setTransitionType((Transition)newValue);
				return;
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				setSourcePortInstance((PortInstance)newValue);
				return;
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				setTargetPortInstance((PortInstance)newValue);
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE:
				setTransitionType((Transition)null);
				return;
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				setSourcePortInstance((PortInstance)null);
				return;
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				setTargetPortInstance((PortInstance)null);
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
			case SofiaInstancePackage.TRANSITION_INSTANCE__TRANSITION_TYPE:
				return transitionType != null;
			case SofiaInstancePackage.TRANSITION_INSTANCE__SOURCE_PORT_INSTANCE:
				return getSourcePortInstance() != null;
			case SofiaInstancePackage.TRANSITION_INSTANCE__TARGET_PORT_INSTANCE:
				return targetPortInstance != null;
		}
		return super.eIsSet(featureID);
	}

} //TransitionInstanceImpl
