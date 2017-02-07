/**
 */
package eu.vicci.process.model.sofiainstance;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofia.Port;
import eu.vicci.process.model.sofia.ProcessStep;
import eu.vicci.process.model.sofia.Transition;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Mapping Util</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getMappingUtil()
 * @model
 * @generated
 */
public interface MappingUtil extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	PortInstance mapPort(Port port);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ProcessStepInstance mapProcessStep(ProcessStep processStep);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	TransitionInstance mapTransition(Transition transition);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void addProcessStepInstance(ProcessStepInstance instance);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	DataTypeInstance mapDataType(DataType dataType);

} // MappingUtil
