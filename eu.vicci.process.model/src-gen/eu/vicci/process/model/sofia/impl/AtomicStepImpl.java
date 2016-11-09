/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.AtomicStep;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AtomicStepImpl extends ProcessStepImpl implements AtomicStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.ATOMIC_STEP;
	}

} //AtomicStepImpl
