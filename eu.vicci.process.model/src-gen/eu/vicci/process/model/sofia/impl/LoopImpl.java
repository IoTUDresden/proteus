/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.Loop;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.StartDataPort;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.LoopImpl#getLoopCondition <em>Loop Condition</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.LoopImpl#getPortsCopyToStartsport <em>Ports Copy To Startsport</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LoopImpl extends CompositeStepImpl implements Loop {
	/**
	 * The cached value of the '{@link #getLoopCondition() <em>Loop Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopCondition()
	 * @generated
	 * @ordered
	 */
	protected Condition loopCondition;

	/**
	 * The cached value of the '{@link #getPortsCopyToStartsport() <em>Ports Copy To Startsport</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortsCopyToStartsport()
	 * @generated
	 * @ordered
	 */
	protected EMap<EndDataPort, StartDataPort> portsCopyToStartsport;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Condition getLoopCondition() {
		return loopCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLoopCondition(Condition newLoopCondition, NotificationChain msgs) {
		Condition oldLoopCondition = loopCondition;
		loopCondition = newLoopCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiaPackage.LOOP__LOOP_CONDITION, oldLoopCondition, newLoopCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopCondition(Condition newLoopCondition) {
		if (newLoopCondition != loopCondition) {
			NotificationChain msgs = null;
			if (loopCondition != null)
				msgs = ((InternalEObject)loopCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiaPackage.LOOP__LOOP_CONDITION, null, msgs);
			if (newLoopCondition != null)
				msgs = ((InternalEObject)newLoopCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiaPackage.LOOP__LOOP_CONDITION, null, msgs);
			msgs = basicSetLoopCondition(newLoopCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.LOOP__LOOP_CONDITION, newLoopCondition, newLoopCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<EndDataPort, StartDataPort> getPortsCopyToStartsport() {
		if (portsCopyToStartsport == null) {
			portsCopyToStartsport = new EcoreEMap<EndDataPort,StartDataPort>(SofiaPackage.Literals.END_DATA_PORT_TO_START_DATA_PORT_MAP, EndDataPortToStartDataPortMapImpl.class, this, SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT);
		}
		return portsCopyToStartsport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.LOOP__LOOP_CONDITION:
				return basicSetLoopCondition(null, msgs);
			case SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT:
				return ((InternalEList<?>)getPortsCopyToStartsport()).basicRemove(otherEnd, msgs);
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
			case SofiaPackage.LOOP__LOOP_CONDITION:
				return getLoopCondition();
			case SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT:
				if (coreType) return getPortsCopyToStartsport();
				else return getPortsCopyToStartsport().map();
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
			case SofiaPackage.LOOP__LOOP_CONDITION:
				setLoopCondition((Condition)newValue);
				return;
			case SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT:
				((EStructuralFeature.Setting)getPortsCopyToStartsport()).set(newValue);
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
			case SofiaPackage.LOOP__LOOP_CONDITION:
				setLoopCondition((Condition)null);
				return;
			case SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT:
				getPortsCopyToStartsport().clear();
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
			case SofiaPackage.LOOP__LOOP_CONDITION:
				return loopCondition != null;
			case SofiaPackage.LOOP__PORTS_COPY_TO_STARTSPORT:
				return portsCopyToStartsport != null && !portsCopyToStartsport.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //LoopImpl
