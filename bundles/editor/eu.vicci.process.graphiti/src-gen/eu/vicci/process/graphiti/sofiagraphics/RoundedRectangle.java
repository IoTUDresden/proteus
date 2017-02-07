/**
 */
package eu.vicci.process.graphiti.sofiagraphics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rounded Rectangle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle#getCorner <em>Corner</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getRoundedRectangle()
 * @model
 * @generated
 */
public interface RoundedRectangle extends Rectangle {
	/**
	 * Returns the value of the '<em><b>Corner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Corner</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Corner</em>' containment reference.
	 * @see #setCorner(Dimension)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getRoundedRectangle_Corner()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Dimension getCorner();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle#getCorner <em>Corner</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Corner</em>' containment reference.
	 * @see #getCorner()
	 * @generated
	 */
	void setCorner(Dimension value);

} // RoundedRectangle
