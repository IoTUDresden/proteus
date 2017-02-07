/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.ForLoop;
import eu.vicci.process.model.sofia.SofiaPackage;
import eu.vicci.process.model.sofia.StartDataPort;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ForLoopImpl#getLoopStepWidth <em>Loop Step Width</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForLoopImpl extends LoopImpl implements ForLoop {
	/**
	 * The cached value of the '{@link #getLoopStepWidth() <em>Loop Step Width</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopStepWidth()
	 * @generated
	 * @ordered
	 */
	protected StartDataPort loopStepWidth;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.FOR_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPort getLoopStepWidth() {
		if (loopStepWidth != null && loopStepWidth.eIsProxy()) {
			InternalEObject oldLoopStepWidth = (InternalEObject)loopStepWidth;
			loopStepWidth = (StartDataPort)eResolveProxy(oldLoopStepWidth);
			if (loopStepWidth != oldLoopStepWidth) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH, oldLoopStepWidth, loopStepWidth));
			}
		}
		return loopStepWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartDataPort basicGetLoopStepWidth() {
		return loopStepWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLoopStepWidth(StartDataPort newLoopStepWidth) {
		StartDataPort oldLoopStepWidth = loopStepWidth;
		loopStepWidth = newLoopStepWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH, oldLoopStepWidth, loopStepWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH:
				if (resolve) return getLoopStepWidth();
				return basicGetLoopStepWidth();
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
			case SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH:
				setLoopStepWidth((StartDataPort)newValue);
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
			case SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH:
				setLoopStepWidth((StartDataPort)null);
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
			case SofiaPackage.FOR_LOOP__LOOP_STEP_WIDTH:
				return loopStepWidth != null;
		}
		return super.eIsSet(featureID);
	}

} //ForLoopImpl
