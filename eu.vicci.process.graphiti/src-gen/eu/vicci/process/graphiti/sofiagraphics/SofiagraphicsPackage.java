/**
 */
package eu.vicci.process.graphiti.sofiagraphics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsFactory
 * @model kind="package"
 * @generated
 */
public interface SofiagraphicsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sofiagraphics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://vicci.eu/sofiagraphics/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sofiagraphics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SofiagraphicsPackage eINSTANCE = eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl.init();

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl <em>Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getPoint()
	 * @generated
	 */
	int POINT = 0;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__Y = 1;

	/**
	 * The feature id for the '<em><b>Xrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__XRELATIVE = 2;

	/**
	 * The feature id for the '<em><b>Yrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT__YRELATIVE = 3;

	/**
	 * The number of structural features of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Wrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__WRELATIVE = 2;

	/**
	 * The feature id for the '<em><b>Hrelative</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__HRELATIVE = 3;

	/**
	 * The feature id for the '<em><b>Noresize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__NORESIZE = 4;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl <em>Widget</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getWidget()
	 * @generated
	 */
	int WIDGET = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__STYLE = 1;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__CHILD = 2;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__POS = 3;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__DIM = 4;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__GESTURE_ONLY = 5;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET__PORT_YPOSITION = 6;

	/**
	 * The number of structural features of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Widget</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WIDGET_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.RectangleImpl <em>Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.RectangleImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getRectangle()
	 * @generated
	 */
	int RECTANGLE = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__PARENT = WIDGET__PARENT;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__STYLE = WIDGET__STYLE;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__CHILD = WIDGET__CHILD;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__POS = WIDGET__POS;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__DIM = WIDGET__DIM;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__GESTURE_ONLY = WIDGET__GESTURE_ONLY;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE__PORT_YPOSITION = WIDGET__PORT_YPOSITION;

	/**
	 * The number of structural features of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECTANGLE_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.RoundedRectangleImpl <em>Rounded Rectangle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.RoundedRectangleImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getRoundedRectangle()
	 * @generated
	 */
	int ROUNDED_RECTANGLE = 4;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__PARENT = RECTANGLE__PARENT;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__STYLE = RECTANGLE__STYLE;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__CHILD = RECTANGLE__CHILD;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__POS = RECTANGLE__POS;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__DIM = RECTANGLE__DIM;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__GESTURE_ONLY = RECTANGLE__GESTURE_ONLY;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__PORT_YPOSITION = RECTANGLE__PORT_YPOSITION;

	/**
	 * The feature id for the '<em><b>Corner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE__CORNER = RECTANGLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rounded Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE_FEATURE_COUNT = RECTANGLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rounded Rectangle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUNDED_RECTANGLE_OPERATION_COUNT = RECTANGLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.EllipseImpl <em>Ellipse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.EllipseImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getEllipse()
	 * @generated
	 */
	int ELLIPSE = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__PARENT = WIDGET__PARENT;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__STYLE = WIDGET__STYLE;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__CHILD = WIDGET__CHILD;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__POS = WIDGET__POS;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__DIM = WIDGET__DIM;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__GESTURE_ONLY = WIDGET__GESTURE_ONLY;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE__PORT_YPOSITION = WIDGET__PORT_YPOSITION;

	/**
	 * The number of structural features of the '<em>Ellipse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ellipse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELLIPSE_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.PolylineImpl <em>Polyline</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.PolylineImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getPolyline()
	 * @generated
	 */
	int POLYLINE = 6;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__PARENT = WIDGET__PARENT;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__STYLE = WIDGET__STYLE;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__CHILD = WIDGET__CHILD;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__POS = WIDGET__POS;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__DIM = WIDGET__DIM;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__GESTURE_ONLY = WIDGET__GESTURE_ONLY;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__PORT_YPOSITION = WIDGET__PORT_YPOSITION;

	/**
	 * The feature id for the '<em><b>Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE__POINT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Polyline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Polyline</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POLYLINE_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl <em>Text</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getText()
	 * @generated
	 */
	int TEXT = 7;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__PARENT = WIDGET__PARENT;

	/**
	 * The feature id for the '<em><b>Style</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__STYLE = WIDGET__STYLE;

	/**
	 * The feature id for the '<em><b>Child</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__CHILD = WIDGET__CHILD;

	/**
	 * The feature id for the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__POS = WIDGET__POS;

	/**
	 * The feature id for the '<em><b>Dim</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__DIM = WIDGET__DIM;

	/**
	 * The feature id for the '<em><b>Gesture Only</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__GESTURE_ONLY = WIDGET__GESTURE_ONLY;

	/**
	 * The feature id for the '<em><b>Port YPosition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__PORT_YPOSITION = WIDGET__PORT_YPOSITION;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__TEXT = WIDGET_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Halign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__HALIGN = WIDGET_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Valign</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__VALIGN = WIDGET_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT__ATTRIBUTE_NAME = WIDGET_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_FEATURE_COUNT = WIDGET_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Text</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEXT_OPERATION_COUNT = WIDGET_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.SceneImpl <em>Scene</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SceneImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getScene()
	 * @generated
	 */
	int SCENE = 8;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__OBJECT = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__ROOT = 1;

	/**
	 * The feature id for the '<em><b>Point</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__POINT = 2;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__DIMENSION = 3;

	/**
	 * The feature id for the '<em><b>Color</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__COLOR = 4;

	/**
	 * The feature id for the '<em><b>Style</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__STYLE = 5;

	/**
	 * The feature id for the '<em><b>Gesture</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE__GESTURE = 6;

	/**
	 * The number of structural features of the '<em>Scene</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Scene</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCENE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl <em>Style</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 9;

	/**
	 * The feature id for the '<em><b>Line Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__LINE_WIDTH = 0;

	/**
	 * The feature id for the '<em><b>Fgcolor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FGCOLOR = 1;

	/**
	 * The feature id for the '<em><b>Bgcolor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__BGCOLOR = 2;

	/**
	 * The feature id for the '<em><b>Filled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE__FILLED = 3;

	/**
	 * The number of structural features of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Style</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STYLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.ColorImpl <em>Color</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.ColorImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getColor()
	 * @generated
	 */
	int COLOR = 10;

	/**
	 * The feature id for the '<em><b>R</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__R = 0;

	/**
	 * The feature id for the '<em><b>G</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__G = 1;

	/**
	 * The feature id for the '<em><b>B</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__B = 2;

	/**
	 * The feature id for the '<em><b>A</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR__A = 3;

	/**
	 * The number of structural features of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Color</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.GestureImpl <em>Gesture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.GestureImpl
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getGesture()
	 * @generated
	 */
	int GESTURE = 11;

	/**
	 * The feature id for the '<em><b>Widget</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GESTURE__WIDGET = 0;

	/**
	 * The number of structural features of the '<em>Gesture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GESTURE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Gesture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GESTURE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link eu.vicci.process.graphiti.sofiagraphics.Alignment <em>Alignment</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getAlignment()
	 * @generated
	 */
	int ALIGNMENT = 12;


	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Point</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point
	 * @generated
	 */
	EClass getPoint();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Point#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point#getX()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_X();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Point#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point#getY()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Y();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Point#isXrelative <em>Xrelative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Xrelative</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point#isXrelative()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Xrelative();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Point#isYrelative <em>Yrelative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Yrelative</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point#isYrelative()
	 * @see #getPoint()
	 * @generated
	 */
	EAttribute getPoint_Yrelative();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension#getWidth()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Width();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension#getHeight()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Height();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isWrelative <em>Wrelative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wrelative</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension#isWrelative()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Wrelative();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isHrelative <em>Hrelative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hrelative</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension#isHrelative()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Hrelative();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension#isNoresize <em>Noresize</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Noresize</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension#isNoresize()
	 * @see #getDimension()
	 * @generated
	 */
	EAttribute getDimension_Noresize();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Widget</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget
	 * @generated
	 */
	EClass getWidget();

	/**
	 * Returns the meta object for the container reference '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getParent()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Parent();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Style</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getStyle()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Style();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getChild()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Child();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPos <em>Pos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Pos</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getPos()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Pos();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getDim <em>Dim</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dim</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getDim()
	 * @see #getWidget()
	 * @generated
	 */
	EReference getWidget_Dim();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#isGestureOnly <em>Gesture Only</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gesture Only</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#isGestureOnly()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_GestureOnly();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Widget#getPortYPosition <em>Port YPosition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port YPosition</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget#getPortYPosition()
	 * @see #getWidget()
	 * @generated
	 */
	EAttribute getWidget_PortYPosition();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rectangle</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Rectangle
	 * @generated
	 */
	EClass getRectangle();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle <em>Rounded Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rounded Rectangle</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle
	 * @generated
	 */
	EClass getRoundedRectangle();

	/**
	 * Returns the meta object for the containment reference '{@link eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle#getCorner <em>Corner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Corner</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle#getCorner()
	 * @see #getRoundedRectangle()
	 * @generated
	 */
	EReference getRoundedRectangle_Corner();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Ellipse <em>Ellipse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ellipse</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Ellipse
	 * @generated
	 */
	EClass getEllipse();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Polyline <em>Polyline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Polyline</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Polyline
	 * @generated
	 */
	EClass getPolyline();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Polyline#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Point</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Polyline#getPoint()
	 * @see #getPolyline()
	 * @generated
	 */
	EReference getPolyline_Point();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Text</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text
	 * @generated
	 */
	EClass getText();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text#getText()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Text();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getHalign <em>Halign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Halign</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text#getHalign()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Halign();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getValign <em>Valign</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Valign</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text#getValign()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_Valign();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Text#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text#getAttributeName()
	 * @see #getText()
	 * @generated
	 */
	EAttribute getText_AttributeName();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Scene <em>Scene</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scene</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene
	 * @generated
	 */
	EClass getScene();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Object</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getObject()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Object();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getRoot()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Root();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getPoint <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Point</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getPoint()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Point();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dimension</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getDimension()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Dimension();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Color</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getColor()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Color();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Style</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getStyle()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Style();

	/**
	 * Returns the meta object for the containment reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Scene#getGesture <em>Gesture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gesture</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene#getGesture()
	 * @see #getScene()
	 * @generated
	 */
	EReference getScene_Gesture();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Style</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style
	 * @generated
	 */
	EClass getStyle();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getLineWidth <em>Line Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Width</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style#getLineWidth()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_LineWidth();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getFgcolor <em>Fgcolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Fgcolor</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style#getFgcolor()
	 * @see #getStyle()
	 * @generated
	 */
	EReference getStyle_Fgcolor();

	/**
	 * Returns the meta object for the reference '{@link eu.vicci.process.graphiti.sofiagraphics.Style#getBgcolor <em>Bgcolor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bgcolor</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style#getBgcolor()
	 * @see #getStyle()
	 * @generated
	 */
	EReference getStyle_Bgcolor();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Style#isFilled <em>Filled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filled</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style#isFilled()
	 * @see #getStyle()
	 * @generated
	 */
	EAttribute getStyle_Filled();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Color</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color
	 * @generated
	 */
	EClass getColor();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Color#getR <em>R</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>R</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color#getR()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_R();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Color#getG <em>G</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>G</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color#getG()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_G();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Color#getB <em>B</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>B</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color#getB()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_B();

	/**
	 * Returns the meta object for the attribute '{@link eu.vicci.process.graphiti.sofiagraphics.Color#getA <em>A</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>A</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color#getA()
	 * @see #getColor()
	 * @generated
	 */
	EAttribute getColor_A();

	/**
	 * Returns the meta object for class '{@link eu.vicci.process.graphiti.sofiagraphics.Gesture <em>Gesture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gesture</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Gesture
	 * @generated
	 */
	EClass getGesture();

	/**
	 * Returns the meta object for the reference list '{@link eu.vicci.process.graphiti.sofiagraphics.Gesture#getWidget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Widget</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Gesture#getWidget()
	 * @see #getGesture()
	 * @generated
	 */
	EReference getGesture_Widget();

	/**
	 * Returns the meta object for enum '{@link eu.vicci.process.graphiti.sofiagraphics.Alignment <em>Alignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Alignment</em>'.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
	 * @generated
	 */
	EEnum getAlignment();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SofiagraphicsFactory getSofiagraphicsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl <em>Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.PointImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getPoint()
		 * @generated
		 */
		EClass POINT = eINSTANCE.getPoint();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__X = eINSTANCE.getPoint_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__Y = eINSTANCE.getPoint_Y();

		/**
		 * The meta object literal for the '<em><b>Xrelative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__XRELATIVE = eINSTANCE.getPoint_Xrelative();

		/**
		 * The meta object literal for the '<em><b>Yrelative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POINT__YRELATIVE = eINSTANCE.getPoint_Yrelative();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.DimensionImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__WIDTH = eINSTANCE.getDimension_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__HEIGHT = eINSTANCE.getDimension_Height();

		/**
		 * The meta object literal for the '<em><b>Wrelative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__WRELATIVE = eINSTANCE.getDimension_Wrelative();

		/**
		 * The meta object literal for the '<em><b>Hrelative</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__HRELATIVE = eINSTANCE.getDimension_Hrelative();

		/**
		 * The meta object literal for the '<em><b>Noresize</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION__NORESIZE = eINSTANCE.getDimension_Noresize();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl <em>Widget</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.WidgetImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getWidget()
		 * @generated
		 */
		EClass WIDGET = eINSTANCE.getWidget();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__PARENT = eINSTANCE.getWidget_Parent();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__STYLE = eINSTANCE.getWidget_Style();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__CHILD = eINSTANCE.getWidget_Child();

		/**
		 * The meta object literal for the '<em><b>Pos</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__POS = eINSTANCE.getWidget_Pos();

		/**
		 * The meta object literal for the '<em><b>Dim</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WIDGET__DIM = eINSTANCE.getWidget_Dim();

		/**
		 * The meta object literal for the '<em><b>Gesture Only</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__GESTURE_ONLY = eINSTANCE.getWidget_GestureOnly();

		/**
		 * The meta object literal for the '<em><b>Port YPosition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WIDGET__PORT_YPOSITION = eINSTANCE.getWidget_PortYPosition();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.RectangleImpl <em>Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.RectangleImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getRectangle()
		 * @generated
		 */
		EClass RECTANGLE = eINSTANCE.getRectangle();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.RoundedRectangleImpl <em>Rounded Rectangle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.RoundedRectangleImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getRoundedRectangle()
		 * @generated
		 */
		EClass ROUNDED_RECTANGLE = eINSTANCE.getRoundedRectangle();

		/**
		 * The meta object literal for the '<em><b>Corner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUNDED_RECTANGLE__CORNER = eINSTANCE.getRoundedRectangle_Corner();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.EllipseImpl <em>Ellipse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.EllipseImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getEllipse()
		 * @generated
		 */
		EClass ELLIPSE = eINSTANCE.getEllipse();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.PolylineImpl <em>Polyline</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.PolylineImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getPolyline()
		 * @generated
		 */
		EClass POLYLINE = eINSTANCE.getPolyline();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POLYLINE__POINT = eINSTANCE.getPolyline_Point();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl <em>Text</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.TextImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getText()
		 * @generated
		 */
		EClass TEXT = eINSTANCE.getText();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__TEXT = eINSTANCE.getText_Text();

		/**
		 * The meta object literal for the '<em><b>Halign</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__HALIGN = eINSTANCE.getText_Halign();

		/**
		 * The meta object literal for the '<em><b>Valign</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__VALIGN = eINSTANCE.getText_Valign();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEXT__ATTRIBUTE_NAME = eINSTANCE.getText_AttributeName();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.SceneImpl <em>Scene</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SceneImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getScene()
		 * @generated
		 */
		EClass SCENE = eINSTANCE.getScene();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__OBJECT = eINSTANCE.getScene_Object();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__ROOT = eINSTANCE.getScene_Root();

		/**
		 * The meta object literal for the '<em><b>Point</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__POINT = eINSTANCE.getScene_Point();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__DIMENSION = eINSTANCE.getScene_Dimension();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__COLOR = eINSTANCE.getScene_Color();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__STYLE = eINSTANCE.getScene_Style();

		/**
		 * The meta object literal for the '<em><b>Gesture</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCENE__GESTURE = eINSTANCE.getScene_Gesture();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl <em>Style</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.StyleImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getStyle()
		 * @generated
		 */
		EClass STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em><b>Line Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__LINE_WIDTH = eINSTANCE.getStyle_LineWidth();

		/**
		 * The meta object literal for the '<em><b>Fgcolor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE__FGCOLOR = eINSTANCE.getStyle_Fgcolor();

		/**
		 * The meta object literal for the '<em><b>Bgcolor</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STYLE__BGCOLOR = eINSTANCE.getStyle_Bgcolor();

		/**
		 * The meta object literal for the '<em><b>Filled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STYLE__FILLED = eINSTANCE.getStyle_Filled();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.ColorImpl <em>Color</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.ColorImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getColor()
		 * @generated
		 */
		EClass COLOR = eINSTANCE.getColor();

		/**
		 * The meta object literal for the '<em><b>R</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__R = eINSTANCE.getColor_R();

		/**
		 * The meta object literal for the '<em><b>G</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__G = eINSTANCE.getColor_G();

		/**
		 * The meta object literal for the '<em><b>B</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__B = eINSTANCE.getColor_B();

		/**
		 * The meta object literal for the '<em><b>A</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLOR__A = eINSTANCE.getColor_A();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.impl.GestureImpl <em>Gesture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.GestureImpl
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getGesture()
		 * @generated
		 */
		EClass GESTURE = eINSTANCE.getGesture();

		/**
		 * The meta object literal for the '<em><b>Widget</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GESTURE__WIDGET = eINSTANCE.getGesture_Widget();

		/**
		 * The meta object literal for the '{@link eu.vicci.process.graphiti.sofiagraphics.Alignment <em>Alignment</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see eu.vicci.process.graphiti.sofiagraphics.Alignment
		 * @see eu.vicci.process.graphiti.sofiagraphics.impl.SofiagraphicsPackageImpl#getAlignment()
		 * @generated
		 */
		EEnum ALIGNMENT = eINSTANCE.getAlignment();

	}

} //SofiagraphicsPackage
