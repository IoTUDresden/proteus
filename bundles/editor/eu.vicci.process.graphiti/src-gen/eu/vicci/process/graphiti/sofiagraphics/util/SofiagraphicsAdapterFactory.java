/**
 */
package eu.vicci.process.graphiti.sofiagraphics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import eu.vicci.process.graphiti.sofiagraphics.Color;
import eu.vicci.process.graphiti.sofiagraphics.Dimension;
import eu.vicci.process.graphiti.sofiagraphics.Ellipse;
import eu.vicci.process.graphiti.sofiagraphics.Gesture;
import eu.vicci.process.graphiti.sofiagraphics.Point;
import eu.vicci.process.graphiti.sofiagraphics.Polyline;
import eu.vicci.process.graphiti.sofiagraphics.Rectangle;
import eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle;
import eu.vicci.process.graphiti.sofiagraphics.Scene;
import eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage;
import eu.vicci.process.graphiti.sofiagraphics.Style;
import eu.vicci.process.graphiti.sofiagraphics.Text;
import eu.vicci.process.graphiti.sofiagraphics.Widget;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.graphiti.sofiagraphics.SofiagraphicsPackage
 * @generated
 */
public class SofiagraphicsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SofiagraphicsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SofiagraphicsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SofiagraphicsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SofiagraphicsSwitch<Adapter> modelSwitch =
		new SofiagraphicsSwitch<Adapter>() {
			@Override
			public Adapter casePoint(Point object) {
				return createPointAdapter();
			}
			@Override
			public Adapter caseDimension(Dimension object) {
				return createDimensionAdapter();
			}
			@Override
			public Adapter caseWidget(Widget object) {
				return createWidgetAdapter();
			}
			@Override
			public Adapter caseRectangle(Rectangle object) {
				return createRectangleAdapter();
			}
			@Override
			public Adapter caseRoundedRectangle(RoundedRectangle object) {
				return createRoundedRectangleAdapter();
			}
			@Override
			public Adapter caseEllipse(Ellipse object) {
				return createEllipseAdapter();
			}
			@Override
			public Adapter casePolyline(Polyline object) {
				return createPolylineAdapter();
			}
			@Override
			public Adapter caseText(Text object) {
				return createTextAdapter();
			}
			@Override
			public Adapter caseScene(Scene object) {
				return createSceneAdapter();
			}
			@Override
			public Adapter caseStyle(Style object) {
				return createStyleAdapter();
			}
			@Override
			public Adapter caseColor(Color object) {
				return createColorAdapter();
			}
			@Override
			public Adapter caseGesture(Gesture object) {
				return createGestureAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Point <em>Point</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Point
	 * @generated
	 */
	public Adapter createPointAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Dimension
	 * @generated
	 */
	public Adapter createDimensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Widget
	 * @generated
	 */
	public Adapter createWidgetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Rectangle <em>Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Rectangle
	 * @generated
	 */
	public Adapter createRectangleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle <em>Rounded Rectangle</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.RoundedRectangle
	 * @generated
	 */
	public Adapter createRoundedRectangleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Ellipse <em>Ellipse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Ellipse
	 * @generated
	 */
	public Adapter createEllipseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Polyline <em>Polyline</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Polyline
	 * @generated
	 */
	public Adapter createPolylineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Text
	 * @generated
	 */
	public Adapter createTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Scene <em>Scene</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Scene
	 * @generated
	 */
	public Adapter createSceneAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Style
	 * @generated
	 */
	public Adapter createStyleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Color <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Color
	 * @generated
	 */
	public Adapter createColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link eu.vicci.process.graphiti.sofiagraphics.Gesture <em>Gesture</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see eu.vicci.process.graphiti.sofiagraphics.Gesture
	 * @generated
	 */
	public Adapter createGestureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SofiagraphicsAdapterFactory
