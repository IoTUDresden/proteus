/**
 */
package eu.vicci.process.model.sofia.impl;

import eu.vicci.process.model.sofia.ComplexType;
import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.SofiaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Complex Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ComplexTypeImpl#getSubtypes <em>Subtypes</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.impl.ComplexTypeImpl#getSubreferences <em>Subreferences</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexTypeImpl extends DataTypeImpl implements ComplexType {
	/**
	 * The cached value of the '{@link #getSubtypes() <em>Subtypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtypes()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> subtypes;

	/**
	 * The cached value of the '{@link #getSubreferences() <em>Subreferences</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubreferences()
	 * @generated
	 * @ordered
	 */
	protected EList<DataType> subreferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiaPackage.Literals.COMPLEX_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getSubtypes() {
		if (subtypes == null) {
			subtypes = new EObjectContainmentWithInverseEList<DataType>(DataType.class, this, SofiaPackage.COMPLEX_TYPE__SUBTYPES, SofiaPackage.DATA_TYPE__BELONGS_TO);
		}
		return subtypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataType> getSubreferences() {
		if (subreferences == null) {
			subreferences = new EObjectResolvingEList<DataType>(DataType.class, this, SofiaPackage.COMPLEX_TYPE__SUBREFERENCES);
		}
		return subreferences;
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubtypes()).basicAdd(otherEnd, msgs);
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				return ((InternalEList<?>)getSubtypes()).basicRemove(otherEnd, msgs);
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				return getSubtypes();
			case SofiaPackage.COMPLEX_TYPE__SUBREFERENCES:
				return getSubreferences();
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				getSubtypes().clear();
				getSubtypes().addAll((Collection<? extends DataType>)newValue);
				return;
			case SofiaPackage.COMPLEX_TYPE__SUBREFERENCES:
				getSubreferences().clear();
				getSubreferences().addAll((Collection<? extends DataType>)newValue);
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				getSubtypes().clear();
				return;
			case SofiaPackage.COMPLEX_TYPE__SUBREFERENCES:
				getSubreferences().clear();
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
			case SofiaPackage.COMPLEX_TYPE__SUBTYPES:
				return subtypes != null && !subtypes.isEmpty();
			case SofiaPackage.COMPLEX_TYPE__SUBREFERENCES:
				return subreferences != null && !subreferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComplexTypeImpl
