/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import eu.vicci.process.graphiti.sofiagraphics.Gesture;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Widget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Gesture</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.GestureImpl#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GestureImpl extends MinimalEObjectImpl.Container implements Gesture {
	/**
	 * The cached value of the '{@link #getWidget() <em>Widget</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidget()
	 * @generated
	 * @ordered
	 */
	protected EList<Widget> widget;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GestureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.GESTURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getWidget() {
		if (widget == null) {
			widget = new EObjectResolvingEList<Widget>(Widget.class, this, SofiagraphicsPackage.GESTURE__WIDGET);
		}
		return widget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.GESTURE__WIDGET:
				return getWidget();
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
			case SofiagraphicsPackage.GESTURE__WIDGET:
				getWidget().clear();
				getWidget().addAll((Collection<? extends Widget>)newValue);
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
			case SofiagraphicsPackage.GESTURE__WIDGET:
				getWidget().clear();
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
			case SofiagraphicsPackage.GESTURE__WIDGET:
				return widget != null && !widget.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GestureImpl
