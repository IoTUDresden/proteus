/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Widget</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getParent <em>Parent</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getStyle <em>Style</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getChild <em>Child</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPos <em>Pos</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getDim <em>Dim</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#isGestureOnly <em>Gesture Only</em>}</li>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPortYPosition <em>Port YPosition</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget()
 * @model abstract="true"
 * @generated
 */
public interface Widget extends EObject {
	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(Widget)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_Parent()
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getChild
	 * @model opposite="child" transient="false"
	 * @generated
	 */
	Widget getParent();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(Widget value);

	/**
	 * Returns the value of the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Style</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Style</em>' reference.
	 * @see #setStyle(Style)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_Style()
	 * @model
	 * @generated
	 */
	Style getStyle();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getStyle <em>Style</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Style</em>' reference.
	 * @see #getStyle()
	 * @generated
	 */
	void setStyle(Style value);

	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Widget}.
	 * It is bidirectional and its opposite is '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_Child()
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getParent
	 * @model opposite="parent" containment="true"
	 * @generated
	 */
	EList<Widget> getChild();

	/**
	 * Returns the value of the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos</em>' containment reference.
	 * @see #setPos(Point)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_Pos()
	 * @model containment="true"
	 * @generated
	 */
	Point getPos();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPos <em>Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' containment reference.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(Point value);

	/**
	 * Returns the value of the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dim</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dim</em>' containment reference.
	 * @see #setDim(Dimension)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_Dim()
	 * @model containment="true"
	 * @generated
	 */
	Dimension getDim();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getDim <em>Dim</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dim</em>' containment reference.
	 * @see #getDim()
	 * @generated
	 */
	void setDim(Dimension value);

	/**
	 * Returns the value of the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Gesture Only</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gesture Only</em>' attribute.
	 * @see #setGestureOnly(boolean)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_GestureOnly()
	 * @model
	 * @generated
	 */
	boolean isGestureOnly();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#isGestureOnly <em>Gesture Only</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gesture Only</em>' attribute.
	 * @see #isGestureOnly()
	 * @generated
	 */
	void setGestureOnly(boolean value);

	/**
	 * Returns the value of the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Port YPosition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port YPosition</em>' attribute.
	 * @see #setPortYPosition(float)
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getWidget_PortYPosition()
	 * @model
	 * @generated
	 */
	float getPortYPosition();

	/**
	 * Sets the value of the '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPortYPosition <em>Port YPosition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port YPosition</em>' attribute.
	 * @see #getPortYPosition()
	 * @generated
	 */
	void setPortYPosition(float value);

} // Widget
