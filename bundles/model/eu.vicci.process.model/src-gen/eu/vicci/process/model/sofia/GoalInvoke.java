/**
 */
package eu.vicci.process.model.sofia;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Goal Invoke</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link eu.vicci.process.model.sofia.GoalInvoke#getInvokeGoal <em>Invoke Goal</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.GoalInvoke#getQualities <em>Qualities</em>}</li>
 *   <li>{@link eu.vicci.process.model.sofia.GoalInvoke#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see eu.vicci.process.model.sofia.SofiaPackage#getGoalInvoke()
 * @model
 * @generated
 */
public interface GoalInvoke extends Invoke {
	/**
	 * Returns the value of the '<em><b>Invoke Goal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoke Goal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoke Goal</em>' attribute.
	 * @see #setInvokeGoal(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getGoalInvoke_InvokeGoal()
	 * @model
	 * @generated
	 */
	String getInvokeGoal();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.GoalInvoke#getInvokeGoal <em>Invoke Goal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invoke Goal</em>' attribute.
	 * @see #getInvokeGoal()
	 * @generated
	 */
	void setInvokeGoal(String value);

	/**
	 * Returns the value of the '<em><b>Qualities</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualities</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualities</em>' attribute list.
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getGoalInvoke_Qualities()
	 * @model
	 * @generated
	 */
	EList<String> getQualities();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Location</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see eu.vicci.process.model.sofia.SofiaPackage#getGoalInvoke_Location()
	 * @model
	 * @generated
	 */
	String getLocation();

	/**
	 * Sets the value of the '{@link eu.vicci.process.model.sofia.GoalInvoke#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

} // GoalInvoke
