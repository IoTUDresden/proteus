/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rounded Rectangle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.RoundedRectangleImpl#getCorner <em>Corner</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoundedRectangleImpl extends RectangleImpl implements RoundedRectangle {
	/**
	 * The cached value of the '{@link #getCorner() <em>Corner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCorner()
	 * @generated
	 * @ordered
	 */
	protected Dimension corner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoundedRectangleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.ROUNDED_RECTANGLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getCorner() {
		return corner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCorner(Dimension newCorner, NotificationChain msgs) {
		Dimension oldCorner = corner;
		corner = newCorner;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER, oldCorner, newCorner);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCorner(Dimension newCorner) {
		if (newCorner != corner) {
			NotificationChain msgs = null;
			if (corner != null)
				msgs = ((InternalEObject)corner).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER, null, msgs);
			if (newCorner != null)
				msgs = ((InternalEObject)newCorner).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER, null, msgs);
			msgs = basicSetCorner(newCorner, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER, newCorner, newCorner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER:
				return basicSetCorner(null, msgs);
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
			case SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER:
				return getCorner();
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
			case SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER:
				setCorner((Dimension)newValue);
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
			case SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER:
				setCorner((Dimension)null);
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
			case SofiagraphicsPackage.ROUNDED_RECTANGLE__CORNER:
				return corner != null;
		}
		return super.eIsSet(featureID);
	}

} //RoundedRectangleImpl
