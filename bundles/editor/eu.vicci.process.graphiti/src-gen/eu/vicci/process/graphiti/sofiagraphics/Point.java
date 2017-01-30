/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Point#getX <em>X</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Point#getY <em>Y</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Point#isXrelative <em>Xrelative</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Point#isYrelative <em>Yrelative</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPoint()
 * @model
 * @generated
 */
public interface Point extends EObject {
	/**
	 * Returns the value of the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>X</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>X</em>' attribute.
	 * @see #setX(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPoint_X()
	 * @model
	 * @generated
	 */
	float getX();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Point#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(float value);

	/**
	 * Returns the value of the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Y</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Y</em>' attribute.
	 * @see #setY(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPoint_Y()
	 * @model
	 * @generated
	 */
	float getY();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Point#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(float value);

	/**
	 * Returns the value of the '<em><b>Xrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Xrelative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Xrelative</em>' attribute.
	 * @see #setXrelative(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPoint_Xrelative()
	 * @model
	 * @generated
	 */
	boolean isXrelative();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Point#isXrelative <em>Xrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Xrelative</em>' attribute.
	 * @see #isXrelative()
	 * @generated
	 */
	void setXrelative(boolean value);

	/**
	 * Returns the value of the '<em><b>Yrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yrelative</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yrelative</em>' attribute.
	 * @see #setYrelative(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPoint_Yrelative()
	 * @model
	 * @generated
	 */
	boolean isYrelative();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Point#isYrelative <em>Yrelative</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yrelative</em>' attribute.
	 * @see #isYrelative()
	 * @generated
	 */
	void setYrelative(boolean value);

} // Point
