/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Scene</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getObject <em>Object</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getRoot <em>Root</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getPoint <em>Point</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getDimension <em>Dimension</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getColor <em>Color</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getStyle <em>Style</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getGesture <em>Gesture</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene()
 * @model
 * @generated
 */
public interface Scene extends EObject {
	/**
	 * Returns the value of the '<em><b>Object</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Object()
	 * @model containment="true"
	 * @generated
	 */
	EList<Widget> getObject();

	/**
	 * Returns the value of the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' reference.
	 * @see #setRoot(Widget)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Root()
	 * @model
	 * @generated
	 */
	Widget getRoot();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getRoot <em>Root</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(Widget value);

	/**
	 * Returns the value of the '<em><b>Point</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Point}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Point</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Point</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Point()
	 * @model containment="true"
	 * @generated
	 */
	EList<Point> getPoint();

	/**
	 * Returns the value of the '<em><b>Dimension</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Dimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimension</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimension</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Dimension()
	 * @model containment="true"
	 * @generated
	 */
	EList<Dimension> getDimension();

	/**
	 * Returns the value of the '<em><b>Color</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Color}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Color</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Color</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Color()
	 * @model containment="true"
	 * @generated
	 */
	EList<Color> getColor();

	/**
	 * Returns the value of the '<em><b>Style</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Style}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Style()
	 * @model containment="true"
	 * @generated
	 */
	EList<Style> getStyle();

	/**
	 * Returns the value of the '<em><b>Gesture</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Gesture}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gesture</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gesture</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getScene_Gesture()
	 * @model containment="true"
	 * @generated
	 */
	EList<Gesture> getGesture();

} // Scene
