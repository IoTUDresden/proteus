/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import eu.vicci.process.graphiti.sofiagraphics.Alignment;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl#getText <em>Text</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl#getHalign <em>Halign</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl#getValign <em>Valign</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TextImpl extends WidgetImpl implements Text {
	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getHalign() <em>Halign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHalign()
	 * @generated
	 * @ordered
	 */
	protected static final Alignment HALIGN_EDEFAULT = Alignment.CENTER;

	/**
	 * The cached value of the '{@link #getHalign() <em>Halign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHalign()
	 * @generated
	 * @ordered
	 */
	protected Alignment halign = HALIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getValign() <em>Valign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValign()
	 * @generated
	 * @ordered
	 */
	protected static final Alignment VALIGN_EDEFAULT = Alignment.CENTER;

	/**
	 * The cached value of the '{@link #getValign() <em>Valign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValign()
	 * @generated
	 * @ordered
	 */
	protected Alignment valign = VALIGN_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SofiagraphicsPackage.Literals.TEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.TEXT__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alignment getHalign() {
		return halign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHalign(Alignment newHalign) {
		Alignment oldHalign = halign;
		halign = newHalign == null ? HALIGN_EDEFAULT : newHalign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.TEXT__HALIGN, oldHalign, halign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alignment getValign() {
		return valign;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValign(Alignment newValign) {
		Alignment oldValign = valign;
		valign = newValign == null ? VALIGN_EDEFAULT : newValign;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.TEXT__VALIGN, oldValign, valign));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SofiagraphicsPackage.TEXT__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SofiagraphicsPackage.TEXT__TEXT:
				return getText();
			case SofiagraphicsPackage.TEXT__HALIGN:
				return getHalign();
			case SofiagraphicsPackage.TEXT__VALIGN:
				return getValign();
			case SofiagraphicsPackage.TEXT__ATTRIBUTE_NAME:
				return getAttributeName();
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
			case SofiagraphicsPackage.TEXT__TEXT:
				setText((String)newValue);
				return;
			case SofiagraphicsPackage.TEXT__HALIGN:
				setHalign((Alignment)newValue);
				return;
			case SofiagraphicsPackage.TEXT__VALIGN:
				setValign((Alignment)newValue);
				return;
			case SofiagraphicsPackage.TEXT__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
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
			case SofiagraphicsPackage.TEXT__TEXT:
				setText(TEXT_EDEFAULT);
				return;
			case SofiagraphicsPackage.TEXT__HALIGN:
				setHalign(HALIGN_EDEFAULT);
				return;
			case SofiagraphicsPackage.TEXT__VALIGN:
				setValign(VALIGN_EDEFAULT);
				return;
			case SofiagraphicsPackage.TEXT__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
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
			case SofiagraphicsPackage.TEXT__TEXT:
				return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
			case SofiagraphicsPackage.TEXT__HALIGN:
				return halign != HALIGN_EDEFAULT;
			case SofiagraphicsPackage.TEXT__VALIGN:
				return valign != VALIGN_EDEFAULT;
			case SofiagraphicsPackage.TEXT__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
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
		result.append(" (text: ");
		result.append(text);
		result.append(", halign: ");
		result.append(halign);
		result.append(", valign: ");
		result.append(valign);
		result.append(", attributeName: ");
		result.append(attributeName);
		result.append(')');
		return result.toString();
	}

} //TextImpl
