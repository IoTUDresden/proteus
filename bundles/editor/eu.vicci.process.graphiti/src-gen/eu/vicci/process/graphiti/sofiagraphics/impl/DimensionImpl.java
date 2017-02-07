/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl#isWrelative <em>Wrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl#isHrelative <em>Hrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl#isNoresize <em>Noresize</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DimensionImpl extends MinimalEObjectImpl.Container implements Dimension {
	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float WIDTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected float width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final float HEIGHT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected float height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #isWrelative() <em>Wrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWrelative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean WRELATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isWrelative() <em>Wrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isWrelative()
	 * @generated
	 * @ordered
	 */
	protected boolean wrelative = WRELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHrelative() <em>Hrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHrelative()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HRELATIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHrelative() <em>Hrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHrelative()
	 * @generated
	 * @ordered
	 */
	protected boolean hrelative = HRELATIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isNoresize() <em>Noresize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoresize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NORESIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNoresize() <em>Noresize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNoresize()
	 * @generated
	 * @ordered
	 */
	protected boolean noresize = NORESIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.DIMENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(float newWidth) {
		float oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.DIMENSION__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(float newHeight) {
		float oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.DIMENSION__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isWrelative() {
		return wrelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWrelative(boolean newWrelative) {
		boolean oldWrelative = wrelative;
		wrelative = newWrelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.DIMENSION__WRELATIVE, oldWrelative, wrelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHrelative() {
		return hrelative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHrelative(boolean newHrelative) {
		boolean oldHrelative = hrelative;
		hrelative = newHrelative;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.DIMENSION__HRELATIVE, oldHrelative, hrelative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNoresize() {
		return noresize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoresize(boolean newNoresize) {
		boolean oldNoresize = noresize;
		noresize = newNoresize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.DIMENSION__NORESIZE, oldNoresize, noresize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.DIMENSION__WIDTH:
				return getWidth();
			case SofiagraphicsPackage.DIMENSION__HEIGHT:
				return getHeight();
			case SofiagraphicsPackage.DIMENSION__WRELATIVE:
				return isWrelative();
			case SofiagraphicsPackage.DIMENSION__HRELATIVE:
				return isHrelative();
			case SofiagraphicsPackage.DIMENSION__NORESIZE:
				return isNoresize();
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
			case SofiagraphicsPackage.DIMENSION__WIDTH:
				setWidth((Float)newValue);
				return;
			case SofiagraphicsPackage.DIMENSION__HEIGHT:
				setHeight((Float)newValue);
				return;
			case SofiagraphicsPackage.DIMENSION__WRELATIVE:
				setWrelative((Boolean)newValue);
				return;
			case SofiagraphicsPackage.DIMENSION__HRELATIVE:
				setHrelative((Boolean)newValue);
				return;
			case SofiagraphicsPackage.DIMENSION__NORESIZE:
				setNoresize((Boolean)newValue);
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
			case SofiagraphicsPackage.DIMENSION__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case SofiagraphicsPackage.DIMENSION__HEIGHT:
				setHeight(HEIGHT_EDEFAULT);
				return;
			case SofiagraphicsPackage.DIMENSION__WRELATIVE:
				setWrelative(WRELATIVE_EDEFAULT);
				return;
			case SofiagraphicsPackage.DIMENSION__HRELATIVE:
				setHrelative(HRELATIVE_EDEFAULT);
				return;
			case SofiagraphicsPackage.DIMENSION__NORESIZE:
				setNoresize(NORESIZE_EDEFAULT);
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
			case SofiagraphicsPackage.DIMENSION__WIDTH:
				return width != WIDTH_EDEFAULT;
			case SofiagraphicsPackage.DIMENSION__HEIGHT:
				return height != HEIGHT_EDEFAULT;
			case SofiagraphicsPackage.DIMENSION__WRELATIVE:
				return wrelative != WRELATIVE_EDEFAULT;
			case SofiagraphicsPackage.DIMENSION__HRELATIVE:
				return hrelative != HRELATIVE_EDEFAULT;
			case SofiagraphicsPackage.DIMENSION__NORESIZE:
				return noresize != NORESIZE_EDEFAULT;
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
		result.append(" (width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", wrelative: ");
		result.append(wrelative);
		result.append(", hrelative: ");
		result.append(hrelative);
		result.append(", noresize: ");
		result.append(noresize);
		result.append(')');
		return result.toString();
	}

} //DimensionImpl
