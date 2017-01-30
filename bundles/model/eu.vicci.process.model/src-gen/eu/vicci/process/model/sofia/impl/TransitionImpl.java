/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.Nameable;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.Transition;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.TransitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.TransitionImpl#getSourcePort <em>Source Port</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.TransitionImpl#getTargetPort <em>Target Port</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransitionImpl extends IdentifiableImpl implements Transition {
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
	 * The cached value of the '{@link #getTargetPort() <em>Target Port</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetPort()
	 * @generated
	 * @ordered
	 */
	protected Port targetPort;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.TRANSITION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.TRANSITION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getSourcePort() {
		if (eContainerFeatureID() != SofiaPackage.TRANSITION__SOURCE_PORT) return null;
		return (Port)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSourcePort(Port newSourcePort, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSourcePort, SofiaPackage.TRANSITION__SOURCE_PORT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourcePort(Port newSourcePort) {
		if (newSourcePort != eInternalContainer() || (eContainerFeatureID() != SofiaPackage.TRANSITION__SOURCE_PORT && newSourcePort != null)) {
			if (EcoreUtil.isAncestor(this, newSourcePort))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSourcePort != null)
				msgs = ((InternalEObject)newSourcePort).eInverseAdd(this, SofiaPackage.PORT__OUT_TRANSITIONS, Port.class, msgs);
			msgs = basicSetSourcePort(newSourcePort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.TRANSITION__SOURCE_PORT, newSourcePort, newSourcePort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port getTargetPort() {
		if (targetPort != null && targetPort.eIsProxy()) {
			InternalEObject oldTargetPort = (InternalEObject)targetPort;
			targetPort = (Port)eResolveProxy(oldTargetPort);
			if (targetPort != oldTargetPort) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.TRANSITION__TARGET_PORT, oldTargetPort, targetPort));
			}
		}
		return targetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port basicGetTargetPort() {
		return targetPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetPort(Port newTargetPort, NotificationChain msgs) {
		Port oldTargetPort = targetPort;
		targetPort = newTargetPort;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaPackage.TRANSITION__TARGET_PORT, oldTargetPort, newTargetPort);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetPort(Port newTargetPort) {
		if (newTargetPort != targetPort) {
			NotificationChain msgs = null;
			if (targetPort != null)
				msgs = ((InternalEObject)targetPort).eInverseRemove(this, SofiaPackage.PORT__IN_TRANSITIONS, Port.class, msgs);
			if (newTargetPort != null)
				msgs = ((InternalEObject)newTargetPort).eInverseAdd(this, SofiaPackage.PORT__IN_TRANSITIONS, Port.class, msgs);
			msgs = basicSetTargetPort(newTargetPort, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.TRANSITION__TARGET_PORT, newTargetPort, newTargetPort));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSourcePort((Port)otherEnd, msgs);
			case SofiaPackage.TRANSITION__TARGET_PORT:
				if (targetPort != null)
					msgs = ((InternalEObject)targetPort).eInverseRemove(this, SofiaPackage.PORT__IN_TRANSITIONS, Port.class, msgs);
				return basicSetTargetPort((Port)otherEnd, msgs);
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
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				return basicSetSourcePort(null, msgs);
			case SofiaPackage.TRANSITION__TARGET_PORT:
				return basicSetTargetPort(null, msgs);
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
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				return eInternalContainer().eInverseRemove(this, SofiaPackage.PORT__OUT_TRANSITIONS, Port.class, msgs);
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
			case SofiaPackage.TRANSITION__NAME:
				return getName();
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				return getSourcePort();
			case SofiaPackage.TRANSITION__TARGET_PORT:
				if (resolve) return getTargetPort();
				return basicGetTargetPort();
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
			case SofiaPackage.TRANSITION__NAME:
				setName((String)newValue);
				return;
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				setSourcePort((Port)newValue);
				return;
			case SofiaPackage.TRANSITION__TARGET_PORT:
				setTargetPort((Port)newValue);
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
			case SofiaPackage.TRANSITION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				setSourcePort((Port)null);
				return;
			case SofiaPackage.TRANSITION__TARGET_PORT:
				setTargetPort((Port)null);
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
			case SofiaPackage.TRANSITION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SofiaPackage.TRANSITION__SOURCE_PORT:
				return getSourcePort() != null;
			case SofiaPackage.TRANSITION__TARGET_PORT:
				return targetPort != null;
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
				case SofiaPackage.TRANSITION__NAME: return SofiaPackage.NAMEABLE__NAME;
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
				case SofiaPackage.NAMEABLE__NAME: return SofiaPackage.TRANSITION__NAME;
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
		result.append(')');
		return result.toString();
	}

} //TransitionImpl
