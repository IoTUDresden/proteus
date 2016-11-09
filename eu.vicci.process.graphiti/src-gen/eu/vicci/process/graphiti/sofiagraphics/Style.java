/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Style</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Style#getLineWidth <em>Line Width</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Style#getFgcolor <em>Fgcolor</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Style#getBgcolor <em>Bgcolor</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Style#isFilled <em>Filled</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getStyle()
 * @model
 * @generated
 */
public interface Style extends EObject {
	/**
	 * Returns the value of the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Width</em>' attribute.
	 * @see #setLineWidth(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getStyle_LineWidth()
	 * @model
	 * @generated
	 */
	float getLineWidth();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getLineWidth <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Width</em>' attribute.
	 * @see #getLineWidth()
	 * @generated
	 */
	void setLineWidth(float value);

	/**
	 * Returns the value of the '<em><b>Fgcolor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fgcolor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fgcolor</em>' reference.
	 * @see #setFgcolor(Color)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getStyle_Fgcolor()
	 * @model
	 * @generated
	 */
	Color getFgcolor();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getFgcolor <em>Fgcolor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fgcolor</em>' reference.
	 * @see #getFgcolor()
	 * @generated
	 */
	void setFgcolor(Color value);

	/**
	 * Returns the value of the '<em><b>Bgcolor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bgcolor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bgcolor</em>' reference.
	 * @see #setBgcolor(Color)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getStyle_Bgcolor()
	 * @model
	 * @generated
	 */
	Color getBgcolor();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getBgcolor <em>Bgcolor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bgcolor</em>' reference.
	 * @see #getBgcolor()
	 * @generated
	 */
	void setBgcolor(Color value);

	/**
	 * Returns the value of the '<em><b>Filled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filled</em>' attribute.
	 * @see #setFilled(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getStyle_Filled()
	 * @model default="false"
	 * @generated
	 */
	boolean isFilled();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Style#isFilled <em>Filled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filled</em>' attribute.
	 * @see #isFilled()
	 * @generated
	 */
	void setFilled(boolean value);

} // Style
