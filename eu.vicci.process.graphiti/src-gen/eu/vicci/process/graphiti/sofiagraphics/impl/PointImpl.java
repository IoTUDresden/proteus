/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import eu.vicci.process.graphiti.sofiagraphics.Point;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl#getX <em>X</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl#getY <em>Y</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl#isXrelative <em>Xrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl#isYrelative <em>Yrelative</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PointImpl extends MinimalEObjectImpl.Container implements Point {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final float X_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected float x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final float Y_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected float y = Y_EDEFAULT;

	/**
	 * The default value of the '{@link #isXrelative() <em>Xrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXrelative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean XRELATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isXrelative() <em>Xrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isXrelative()
	 * @generated
	 * @ordered
	 */
	protected boolean xrelative = XRELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isYrelative() <em>Yrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isYrelative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean YRELATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isYrelative() <em>Yrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isYrelative()
	 * @generated
	 * @ordered
	 */
	protected boolean yrelative = YRELATIVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(float newX) {
		float oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.POINT__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(float newY) {
		float oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.POINT__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isXrelative() {
		return xrelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setXrelative(boolean newXrelative) {
		boolean oldXrelative = xrelative;
		xrelative = newXrelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.POINT__XRELATIVE, oldXrelative, xrelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isYrelative() {
		return yrelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYrelative(boolean newYrelative) {
		boolean oldYrelative = yrelative;
		yrelative = newYrelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.POINT__YRELATIVE, oldYrelative, yrelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.POINT__X:
				return getX();
			case SofiagraphicsPackage.POINT__Y:
				return getY();
			case SofiagraphicsPackage.POINT__XRELATIVE:
				return isXrelative();
			case SofiagraphicsPackage.POINT__YRELATIVE:
				return isYrelative();
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
			case SofiagraphicsPackage.POINT__X:
				setX((Float)newValue);
				return;
			case SofiagraphicsPackage.POINT__Y:
				setY((Float)newValue);
				return;
			case SofiagraphicsPackage.POINT__XRELATIVE:
				setXrelative((Boolean)newValue);
				return;
			case SofiagraphicsPackage.POINT__YRELATIVE:
				setYrelative((Boolean)newValue);
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
			case SofiagraphicsPackage.POINT__X:
				setX(X_EDEFAULT);
				return;
			case SofiagraphicsPackage.POINT__Y:
				setY(Y_EDEFAULT);
				return;
			case SofiagraphicsPackage.POINT__XRELATIVE:
				setXrelative(XRELATIVE_EDEFAULT);
				return;
			case SofiagraphicsPackage.POINT__YRELATIVE:
				setYrelative(YRELATIVE_EDEFAULT);
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
			case SofiagraphicsPackage.POINT__X:
				return x != X_EDEFAULT;
			case SofiagraphicsPackage.POINT__Y:
				return y != Y_EDEFAULT;
			case SofiagraphicsPackage.POINT__XRELATIVE:
				return xrelative != XRELATIVE_EDEFAULT;
			case SofiagraphicsPackage.POINT__YRELATIVE:
				return yrelative != YRELATIVE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", xrelative: ");
		result.append(xrelative);
		result.append(", yrelative: ");
		result.append(yrelative);
		result.append(')');
		return result.toString();
	}

} //PointImpl
