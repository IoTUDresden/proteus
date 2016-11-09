/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ProcessImpl#getDataTypeDefinitions <em>Data Type Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessImpl extends CompositeStepImpl implements eu.vicci.process.model.sofia.Process {
	/**
	 * The cached value of the '{@link #getDataTypeDefinitions() <em>Data Type Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataTypeDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> dataTypeDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.PROCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getDataTypeDefinitions() {
		if (dataTypeDefinitions == null) {
			dataTypeDefinitions = new EObjectContainmentEList<DataType>(DataType.class, this, SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS);
		}
		return dataTypeDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return ((InternalEList<?>)getDataTypeDefinitions()).basicRemove(otherEnd, msgs);
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return getDataTypeDefinitions();
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				getDataTypeDefinitions().clear();
				getDataTypeDefinitions().addAll((Collection<? extends DataType>)newValue);
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				getDataTypeDefinitions().clear();
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
			case SofiaPackage.PROCESS__DATA_TYPE_DEFINITIONS:
				return dataTypeDefinitions != null && !dataTypeDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcessImpl
