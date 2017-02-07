/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.Point;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Style;
import eu.vicci.process.graphiti.sofiagraphics.Widget;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getStyle <em>Style</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getChild <em>Child</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getPos <em>Pos</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getDim <em>Dim</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#isGestureOnly <em>Gesture Only</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl#getPortYPosition <em>Port YPosition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WidgetImpl extends MinimalEObjectImpl.Container implements Widget {
	/**
	 * The cached value of the '{@link #getStyle() <em>Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStyle()
	 * @generated
	 * @ordered
	 */
	protected Style style;

	/**
	 * The cached value of the '{@link #getChild() <em>Child</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChild()
	 * @generated
	 * @ordered
	 */
	protected EList<Widget> child;

	/**
	 * The cached value of the '{@link #getPos() <em>Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPos()
	 * @generated
	 * @ordered
	 */
	protected Point pos;

	/**
	 * The cached value of the '{@link #getDim() <em>Dim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDim()
	 * @generated
	 * @ordered
	 */
	protected Dimension dim;

	/**
	 * The default value of the '{@link #isGestureOnly() <em>Gesture Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGestureOnly()
	 * @generated
	 * @ordered
	 */
	protected static final boolean GESTURE_ONLY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isGestureOnly() <em>Gesture Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isGestureOnly()
	 * @generated
	 * @ordered
	 */
	protected boolean gestureOnly = GESTURE_ONLY_EDEFAULT;

	/**
	 * The default value of the '{@link #getPortYPosition() <em>Port YPosition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortYPosition()
	 * @generated
	 * @ordered
	 */
	protected static final float PORT_YPOSITION_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getPortYPosition() <em>Port YPosition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortYPosition()
	 * @generated
	 * @ordered
	 */
	protected float portYPosition = PORT_YPOSITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.WIDGET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Widget getParent() {
		if (eContainerFeatureID() != SofiagraphicsPackage.WIDGET__PARENT) return null;
		return (Widget)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Widget newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, SofiagraphicsPackage.WIDGET__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Widget newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != SofiagraphicsPackage.WIDGET__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, SofiagraphicsPackage.WIDGET__CHILD, Widget.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style getStyle() {
		if (style != null && style.eIsProxy()) {
			InternalEObject oldStyle = (InternalEObject)style;
			style = (Style)eResolveProxy(oldStyle);
			if (style != oldStyle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SofiagraphicsPackage.WIDGET__STYLE, oldStyle, style));
			}
		}
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style basicGetStyle() {
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStyle(Style newStyle) {
		Style oldStyle = style;
		style = newStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__STYLE, oldStyle, style));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getChild() {
		if (child == null) {
			child = new EObjectContainmentWithInverseEList<Widget>(Widget.class, this, SofiagraphicsPackage.WIDGET__CHILD, SofiagraphicsPackage.WIDGET__PARENT);
		}
		return child;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getPos() {
		return pos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPos(Point newPos, NotificationChain msgs) {
		Point oldPos = pos;
		pos = newPos;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__POS, oldPos, newPos);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPos(Point newPos) {
		if (newPos != pos) {
			NotificationChain msgs = null;
			if (pos != null)
				msgs = ((InternalEObject)pos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.WIDGET__POS, null, msgs);
			if (newPos != null)
				msgs = ((InternalEObject)newPos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.WIDGET__POS, null, msgs);
			msgs = basicSetPos(newPos, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__POS, newPos, newPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getDim() {
		return dim;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDim(Dimension newDim, NotificationChain msgs) {
		Dimension oldDim = dim;
		dim = newDim;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__DIM, oldDim, newDim);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDim(Dimension newDim) {
		if (newDim != dim) {
			NotificationChain msgs = null;
			if (dim != null)
				msgs = ((InternalEObject)dim).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.WIDGET__DIM, null, msgs);
			if (newDim != null)
				msgs = ((InternalEObject)newDim).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SofiagraphicsPackage.WIDGET__DIM, null, msgs);
			msgs = basicSetDim(newDim, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__DIM, newDim, newDim));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isGestureOnly() {
		return gestureOnly;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGestureOnly(boolean newGestureOnly) {
		boolean oldGestureOnly = gestureOnly;
		gestureOnly = newGestureOnly;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__GESTURE_ONLY, oldGestureOnly, gestureOnly));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getPortYPosition() {
		return portYPosition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPortYPosition(float newPortYPosition) {
		float oldPortYPosition = portYPosition;
		portYPosition = newPortYPosition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.WIDGET__PORT_YPOSITION, oldPortYPosition, portYPosition));
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
			case SofiagraphicsPackage.WIDGET__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Widget)otherEnd, msgs);
			case SofiagraphicsPackage.WIDGET__CHILD:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChild()).basicAdd(otherEnd, msgs);
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
			case SofiagraphicsPackage.WIDGET__PARENT:
				return basicSetParent(null, msgs);
			case SofiagraphicsPackage.WIDGET__CHILD:
				return ((InternalEList<?>)getChild()).basicRemove(otherEnd, msgs);
			case SofiagraphicsPackage.WIDGET__POS:
				return basicSetPos(null, msgs);
			case SofiagraphicsPackage.WIDGET__DIM:
				return basicSetDim(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SofiagraphicsPackage.WIDGET__PARENT:
				return eInternalContainer().eInverseRemove(this, SofiagraphicsPackage.WIDGET__CHILD, Widget.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.WIDGET__PARENT:
				return getParent();
			case SofiagraphicsPackage.WIDGET__STYLE:
				if (resolve) return getStyle();
				return basicGetStyle();
			case SofiagraphicsPackage.WIDGET__CHILD:
				return getChild();
			case SofiagraphicsPackage.WIDGET__POS:
				return getPos();
			case SofiagraphicsPackage.WIDGET__DIM:
				return getDim();
			case SofiagraphicsPackage.WIDGET__GESTURE_ONLY:
				return isGestureOnly();
			case SofiagraphicsPackage.WIDGET__PORT_YPOSITION:
				return getPortYPosition();
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
			case SofiagraphicsPackage.WIDGET__PARENT:
				setParent((Widget)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__STYLE:
				setStyle((Style)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__CHILD:
				getChild().clear();
				getChild().addAll((Collection<? extends Widget>)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__POS:
				setPos((Point)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__DIM:
				setDim((Dimension)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__GESTURE_ONLY:
				setGestureOnly((Boolean)newValue);
				return;
			case SofiagraphicsPackage.WIDGET__PORT_YPOSITION:
				setPortYPosition((Float)newValue);
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
			case SofiagraphicsPackage.WIDGET__PARENT:
				setParent((Widget)null);
				return;
			case SofiagraphicsPackage.WIDGET__STYLE:
				setStyle((Style)null);
				return;
			case SofiagraphicsPackage.WIDGET__CHILD:
				getChild().clear();
				return;
			case SofiagraphicsPackage.WIDGET__POS:
				setPos((Point)null);
				return;
			case SofiagraphicsPackage.WIDGET__DIM:
				setDim((Dimension)null);
				return;
			case SofiagraphicsPackage.WIDGET__GESTURE_ONLY:
				setGestureOnly(GESTURE_ONLY_EDEFAULT);
				return;
			case SofiagraphicsPackage.WIDGET__PORT_YPOSITION:
				setPortYPosition(PORT_YPOSITION_EDEFAULT);
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
			case SofiagraphicsPackage.WIDGET__PARENT:
				return getParent() != null;
			case SofiagraphicsPackage.WIDGET__STYLE:
				return style != null;
			case SofiagraphicsPackage.WIDGET__CHILD:
				return child != null && !child.isEmpty();
			case SofiagraphicsPackage.WIDGET__POS:
				return pos != null;
			case SofiagraphicsPackage.WIDGET__DIM:
				return dim != null;
			case SofiagraphicsPackage.WIDGET__GESTURE_ONLY:
				return gestureOnly != GESTURE_ONLY_EDEFAULT;
			case SofiagraphicsPackage.WIDGET__PORT_YPOSITION:
				return portYPosition != PORT_YPOSITION_EDEFAULT;
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
		result.append(" (gestureOnly: ");
		result.append(gestureOnly);
		result.append(", portYPosition: ");
		result.append(portYPosition);
		result.append(')');
		return result.toString();
	}

} //WidgetImpl
