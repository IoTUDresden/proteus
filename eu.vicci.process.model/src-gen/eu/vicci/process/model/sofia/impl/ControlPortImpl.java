/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.ControlPort;
import eu.vicci.process.model.sofia.SofiaPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Control Port</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ControlPortImpl extends PortImpl implements ControlPort {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ControlPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.CONTROL_PORT;
	}

} //ControlPortImpl
