/**
 */
package eu.vicci.process.graphiti.sofiagraphics.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import eu.vicci.process.graphiti.sofiagraphics.Alignment;
import eu.vicci.process.graphiti.sofiagraphics.Color;
import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.Ellipse;
import eu.vicci.process.graphiti.sofiagraphics.Gesture;
import eu.vicci.process.graphiti.sofiagraphics.Point;
import eu.vicci.process.graphiti.sofiagraphics.Polyline;
import eu.vicci.process.graphiti.sofiagraphics.Rectangle;
import eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle;
import eu.vicci.process.graphiti.sofiagraphics.Scene;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsFactory;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Style;
import eu.vicci.process.graphiti.sofiagraphics.Text;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SofiagraphicsFactoryImpl extends EFactoryImpl implements SofiagraphicsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SofiagraphicsFactory init() {
		try {
			SofiagraphicsFactory theSofiagraphicsFactory = (SofiagraphicsFactory)EPackage.Registry.INSTANCE.getEFactory(SofiagraphicsPackage.eNS_URI);
			if (theSofiagraphicsFactory != null) {
				return theSofiagraphicsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SofiagraphicsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiagraphicsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SofiagraphicsPackage.POINT: return createPoint();
			case SofiagraphicsPackage.DIMENSION: return createDimension();
			case SofiagraphicsPackage.RECTANGLE: return createRectangle();
			case SofiagraphicsPackage.ROUNDED_RECTANGLE: return createRoundedRectangle();
			case SofiagraphicsPackage.ELLIPSE: return createEllipse();
			case SofiagraphicsPackage.POLYLINE: return createPolyline();
			case SofiagraphicsPackage.TEXT: return createText();
			case SofiagraphicsPackage.SCENE: return createScene();
			case SofiagraphicsPackage.STYLE: return createStyle();
			case SofiagraphicsPackage.COLOR: return createColor();
			case SofiagraphicsPackage.GESTURE: return createGesture();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SofiagraphicsPackage.ALIGNMENT:
				return createAlignmentFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SofiagraphicsPackage.ALIGNMENT:
				return convertAlignmentToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point createPoint() {
		PointImpl point = new PointImpl();
		return point;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension createDimension() {
		DimensionImpl dimension = new DimensionImpl();
		return dimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rectangle createRectangle() {
		RectangleImpl rectangle = new RectangleImpl();
		return rectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RoundedRectangle createRoundedRectangle() {
		RoundedRectangleImpl roundedRectangle = new RoundedRectangleImpl();
		return roundedRectangle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ellipse createEllipse() {
		EllipseImpl ellipse = new EllipseImpl();
		return ellipse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Polyline createPolyline() {
		PolylineImpl polyline = new PolylineImpl();
		return polyline;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Text createText() {
		TextImpl text = new TextImpl();
		return text;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scene createScene() {
		SceneImpl scene = new SceneImpl();
		return scene;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Style createStyle() {
		StyleImpl style = new StyleImpl();
		return style;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color createColor() {
		ColorImpl color = new ColorImpl();
		return color;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Gesture createGesture() {
		GestureImpl gesture = new GestureImpl();
		return gesture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Alignment createAlignmentFromString(EDataType eDataType, String initialValue) {
		Alignment result = Alignment.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAlignmentToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiagraphicsPackage getSofiagraphicsPackage() {
		return (SofiagraphicsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SofiagraphicsPackage getPackage() {
		return SofiagraphicsPackage.eINSTANCE;
	}

} //SofiagraphicsFactoryImpl
