/**
 */
package eu.vicci.process.model.sofiainstance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getState()
 * @model
 * @generated
 */
public enum State implements Enumerator {
	/**
	 * The '<em><b>Active</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	ACTIVE(0, "active", "active"),

	/**
	 * The '<em><b>Inactive</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INACTIVE_VALUE
	 * @generated
	 * @ordered
	 */
	INACTIVE(1, "inactive", "inactive"),

	/**
	 * The '<em><b>Executing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTING_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTING(2, "executing", "executing"),

	/**
	 * The '<em><b>Executed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTED_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTED(3, "executed", "executed"),

	/**
	 * The '<em><b>Paused</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAUSED_VALUE
	 * @generated
	 * @ordered
	 */
	PAUSED(4, "paused", "paused"),

	/**
	 * The '<em><b>Stopped</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOPPED_VALUE
	 * @generated
	 * @ordered
	 */
	STOPPED(5, "stopped", "stopped"),

	/**
	 * The '<em><b>Failed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FAILED_VALUE
	 * @generated
	 * @ordered
	 */
	FAILED(6, "failed", "failed"),

	/**
	 * The '<em><b>Killed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #KILLED_VALUE
	 * @generated
	 * @ordered
	 */
	KILLED(7, "killed", "killed"),

	/**
	 * The '<em><b>Waiting</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WAITING_VALUE
	 * @generated
	 * @ordered
	 */
	WAITING(8, "waiting", "waiting"),

	/**
	 * The '<em><b>Undeployed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNDEPLOYED_VALUE
	 * @generated
	 * @ordered
	 */
	UNDEPLOYED(9, "undeployed", "undeployed"),

	/**
	 * The '<em><b>Escalated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ESCALATED_VALUE
	 * @generated
	 * @ordered
	 */
	ESCALATED(10, "escalated", "escalated"),

	/**
	 * The '<em><b>Deactivated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DEACTIVATED_VALUE
	 * @generated
	 * @ordered
	 */
	DEACTIVATED(11, "deactivated", "deactivated");

	/**
	 * The '<em><b>Active</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Active</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ACTIVE
	 * @model name="active"
	 * @generated
	 * @ordered
	 */
	public static final int ACTIVE_VALUE = 0;

	/**
	 * The '<em><b>Inactive</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inactive</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #INACTIVE
	 * @model name="inactive"
	 * @generated
	 * @ordered
	 */
	public static final int INACTIVE_VALUE = 1;

	/**
	 * The '<em><b>Executing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Executing</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXECUTING
	 * @model name="executing"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTING_VALUE = 2;

	/**
	 * The '<em><b>Executed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Executed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXECUTED
	 * @model name="executed"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTED_VALUE = 3;

	/**
	 * The '<em><b>Paused</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Paused</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAUSED
	 * @model name="paused"
	 * @generated
	 * @ordered
	 */
	public static final int PAUSED_VALUE = 4;

	/**
	 * The '<em><b>Stopped</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stopped</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOPPED
	 * @model name="stopped"
	 * @generated
	 * @ordered
	 */
	public static final int STOPPED_VALUE = 5;

	/**
	 * The '<em><b>Failed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Failed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FAILED
	 * @model name="failed"
	 * @generated
	 * @ordered
	 */
	public static final int FAILED_VALUE = 6;

	/**
	 * The '<em><b>Killed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Killed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #KILLED
	 * @model name="killed"
	 * @generated
	 * @ordered
	 */
	public static final int KILLED_VALUE = 7;

	/**
	 * The '<em><b>Waiting</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Waiting</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WAITING
	 * @model name="waiting"
	 * @generated
	 * @ordered
	 */
	public static final int WAITING_VALUE = 8;

	/**
	 * The '<em><b>Undeployed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Undeployed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNDEPLOYED
	 * @model name="undeployed"
	 * @generated
	 * @ordered
	 */
	public static final int UNDEPLOYED_VALUE = 9;

	/**
	 * The '<em><b>Escalated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Escalated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ESCALATED
	 * @model name="escalated"
	 * @generated
	 * @ordered
	 */
	public static final int ESCALATED_VALUE = 10;

	/**
	 * The '<em><b>Deactivated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Deactivated</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DEACTIVATED
	 * @model name="deactivated"
	 * @generated
	 * @ordered
	 */
	public static final int DEACTIVATED_VALUE = 11;

	/**
	 * An array of all the '<em><b>State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final State[] VALUES_ARRAY =
		new State[] {
			ACTIVE,
			INACTIVE,
			EXECUTING,
			EXECUTED,
			PAUSED,
			STOPPED,
			FAILED,
			KILLED,
			WAITING,
			UNDEPLOYED,
			ESCALATED,
			DEACTIVATED,
		};

	/**
	 * A public read-only list of all the '<em><b>State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<State> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static State get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			State result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static State getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			State result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static State get(int value) {
		switch (value) {
			case ACTIVE_VALUE: return ACTIVE;
			case INACTIVE_VALUE: return INACTIVE;
			case EXECUTING_VALUE: return EXECUTING;
			case EXECUTED_VALUE: return EXECUTED;
			case PAUSED_VALUE: return PAUSED;
			case STOPPED_VALUE: return STOPPED;
			case FAILED_VALUE: return FAILED;
			case KILLED_VALUE: return KILLED;
			case WAITING_VALUE: return WAITING;
			case UNDEPLOYED_VALUE: return UNDEPLOYED;
			case ESCALATED_VALUE: return ESCALATED;
			case DEACTIVATED_VALUE: return DEACTIVATED;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private State(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //State
