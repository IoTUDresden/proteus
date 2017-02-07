/**
 */
package eu.vicci.process.graphiti.sofiagraphics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Text</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Text#getText <em>Text</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Text#getHalign <em>Halign</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Text#getValign <em>Valign</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Text#getAttributeName <em>Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getText()
 * @model
 * @generated
 */
public interface Text extends Widget {
	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getText_Text()
	 * @model required="true"
	 * @generated
	 */
	String getText();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

	/**
	 * Returns the value of the '<em><b>Halign</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.graphiti.sofiagraphics.Alignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Halign</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Halign</em>' attribute.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @see #setHalign(Alignment)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getText_Halign()
	 * @model
	 * @generated
	 */
	Alignment getHalign();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getHalign <em>Halign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Halign</em>' attribute.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @see #getHalign()
	 * @generated
	 */
	void setHalign(Alignment value);

	/**
	 * Returns the value of the '<em><b>Valign</b></em>' attribute.
	 * The literals are from the enumeration {@link eu.vicci.process.graphiti.sofiagraphics.Alignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valign</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valign</em>' attribute.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @see #setValign(Alignment)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getText_Valign()
	 * @model
	 * @generated
	 */
	Alignment getValign();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getValign <em>Valign</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valign</em>' attribute.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @see #getValign()
	 * @generated
	 */
	void setValign(Alignment value);

	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getText_AttributeName()
	 * @model
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

} // Text
