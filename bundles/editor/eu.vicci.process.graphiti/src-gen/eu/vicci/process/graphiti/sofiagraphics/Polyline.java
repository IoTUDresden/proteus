/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Polyline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link eu.vicci.process.graphiti.sofiagraphics.Polyline#getPoint <em>Point</em>}</li>
 * </ul>
 * </p>
 *
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPolyline()
 * @model
 * @generated
 */
public interface Polyline extends Widget {
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
	 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage#getPolyline_Point()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<Point> getPoint();

} // Polyline
