/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import eu.vicci.process.graphiti.sofiagraphics.Color;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Style;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl#getFgcolor <em>Fgcolor</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl#getBgcolor <em>Bgcolor</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl#isFilled <em>Filled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StyleImpl extends MinimalEObjectImpl.Container implements Style {
	/**
	 * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final float LINE_WIDTH_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected float lineWidth = LINE_WIDTH_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFgcolor() <em>Fgcolor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFgcolor()
	 * @generated
	 * @ordered
	 */
	protected Color fgcolor;

	/**
	 * The cached value of the '{@link #getBgcolor() <em>Bgcolor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBgcolor()
	 * @generated
	 * @ordered
	 */
	protected Color bgcolor;

	/**
	 * The default value of the '{@link #isFilled() <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FILLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isFilled() <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFilled()
	 * @generated
	 * @ordered
	 */
	protected boolean filled = FILLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StyleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.STYLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getLineWidth() {
		return lineWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineWidth(float newLineWidth) {
		float oldLineWidth = lineWidth;
		lineWidth = newLineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.STYLE__LINE_WIDTH, oldLineWidth, lineWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getFgcolor() {
		if (fgcolor != null && fgcolor.eIsProxy()) {
			InternalEObject oldFgcolor = (InternalEObject)fgcolor;
			fgcolor = (Color)eResolveProxy(oldFgcolor);
			if (fgcolor != oldFgcolor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiagraphicsPackage.STYLE__FGCOLOR, oldFgcolor, fgcolor));
			}
		}
		return fgcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color basicGetFgcolor() {
		return fgcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFgcolor(Color newFgcolor) {
		Color oldFgcolor = fgcolor;
		fgcolor = newFgcolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.STYLE__FGCOLOR, oldFgcolor, fgcolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBgcolor() {
		if (bgcolor != null && bgcolor.eIsProxy()) {
			InternalEObject oldBgcolor = (InternalEObject)bgcolor;
			bgcolor = (Color)eResolveProxy(oldBgcolor);
			if (bgcolor != oldBgcolor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiagraphicsPackage.STYLE__BGCOLOR, oldBgcolor, bgcolor));
			}
		}
		return bgcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color basicGetBgcolor() {
		return bgcolor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBgcolor(Color newBgcolor) {
		Color oldBgcolor = bgcolor;
		bgcolor = newBgcolor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.STYLE__BGCOLOR, oldBgcolor, bgcolor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFilled() {
		return filled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilled(boolean newFilled) {
		boolean oldFilled = filled;
		filled = newFilled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.STYLE__FILLED, oldFilled, filled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.STYLE__LINE_WIDTH:
				return getLineWidth();
			case SofiagraphicsPackage.STYLE__FGCOLOR:
				if (resolve) return getFgcolor();
				return basicGetFgcolor();
			case SofiagraphicsPackage.STYLE__BGCOLOR:
				if (resolve) return getBgcolor();
				return basicGetBgcolor();
			case SofiagraphicsPackage.STYLE__FILLED:
				return isFilled();
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
			case SofiagraphicsPackage.STYLE__LINE_WIDTH:
				setLineWidth((Float)newValue);
				return;
			case SofiagraphicsPackage.STYLE__FGCOLOR:
				setFgcolor((Color)newValue);
				return;
			case SofiagraphicsPackage.STYLE__BGCOLOR:
				setBgcolor((Color)newValue);
				return;
			case SofiagraphicsPackage.STYLE__FILLED:
				setFilled((Boolean)newValue);
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
			case SofiagraphicsPackage.STYLE__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case SofiagraphicsPackage.STYLE__FGCOLOR:
				setFgcolor((Color)null);
				return;
			case SofiagraphicsPackage.STYLE__BGCOLOR:
				setBgcolor((Color)null);
				return;
			case SofiagraphicsPackage.STYLE__FILLED:
				setFilled(FILLED_EDEFAULT);
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
			case SofiagraphicsPackage.STYLE__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case SofiagraphicsPackage.STYLE__FGCOLOR:
				return fgcolor != null;
			case SofiagraphicsPackage.STYLE__BGCOLOR:
				return bgcolor != null;
			case SofiagraphicsPackage.STYLE__FILLED:
				return filled != FILLED_EDEFAULT;
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
		result.append(" (lineWidth: ");
		result.append(lineWidth);
		result.append(", filled: ");
		result.append(filled);
		result.append(')');
		return result.toString();
	}

} //StyleImpl
