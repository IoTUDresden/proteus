/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gesture</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Gesture#getWidget <em>Widget</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getGesture()
 * @model
 * @generated
 */
public interface Gesture extends EObject {
	/**
	 * Returns the value of the '<em><b>Widget</b></em>' reference list.
	 * The list contents are of type {@link eu.vicci.process.graphiti.sofiagraphics.Widget}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Widget</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Widget</em>' reference list.
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getGesture_Widget()
	 * @model
	 * @generated
	 */
	EList<Widget> getWidget();

} // Gesture
