/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getWidth <em>Width</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getHeight <em>Height</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isWrelative <em>Wrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isHrelative <em>Hrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isNoresize <em>Noresize</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension()
 * @model
 * @generated
 */
public interface Dimension extends EObject {
	/**
	 * Returns the value of the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Width</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Width</em>' attribute.
	 * @see #setWidth(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension_Width()
	 * @model
	 * @generated
	 */
	float getWidth();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getWidth <em>Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Width</em>' attribute.
	 * @see #getWidth()
	 * @generated
	 */
	void setWidth(float value);

	/**
	 * Returns the value of the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Height</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Height</em>' attribute.
	 * @see #setHeight(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension_Height()
	 * @model
	 * @generated
	 */
	float getHeight();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getHeight <em>Height</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Height</em>' attribute.
	 * @see #getHeight()
	 * @generated
	 */
	void setHeight(float value);

	/**
	 * Returns the value of the '<em><b>Wrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wrelative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wrelative</em>' attribute.
	 * @see #setWrelative(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension_Wrelative()
	 * @model
	 * @generated
	 */
	boolean isWrelative();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isWrelative <em>Wrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wrelative</em>' attribute.
	 * @see #isWrelative()
	 * @generated
	 */
	void setWrelative(boolean value);

	/**
	 * Returns the value of the '<em><b>Hrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Hrelative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Hrelative</em>' attribute.
	 * @see #setHrelative(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension_Hrelative()
	 * @model
	 * @generated
	 */
	boolean isHrelative();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isHrelative <em>Hrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hrelative</em>' attribute.
	 * @see #isHrelative()
	 * @generated
	 */
	void setHrelative(boolean value);

	/**
	 * Returns the value of the '<em><b>Noresize</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Noresize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Noresize</em>' attribute.
	 * @see #setNoresize(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getDimension_Noresize()
	 * @model default="false"
	 * @generated
	 */
	boolean isNoresize();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isNoresize <em>Noresize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Noresize</em>' attribute.
	 * @see #isNoresize()
	 * @generated
	 */
	void setNoresize(boolean value);

} // Dimension
