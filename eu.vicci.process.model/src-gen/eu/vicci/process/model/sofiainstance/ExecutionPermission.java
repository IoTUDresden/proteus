/**
 */
package eu.vicci.process.model.sofiainstance;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Execution Permission</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofiainstance.SofiaInstancePackage#getExecutionPermission()
 * @model
 * @generated
 */
public enum ExecutionPermission implements Enumerator {
	/**
	 * The '<em><b>Delayed</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DELAYED_VALUE
	 * @generated
	 * @ordered
	 */
	DELAYED(0, "delayed", "delayed"),

	/**
	 * The '<em><b>Denied</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DENIED_VALUE
	 * @generated
	 * @ordered
	 */
	DENIED(1, "denied", "denied"),

	/**
	 * The '<em><b>Granted</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GRANTED_VALUE
	 * @generated
	 * @ordered
	 */
	GRANTED(2, "granted", "granted"),

	/**
	 * The '<em><b>Synchronized</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZED_VALUE
	 * @generated
	 * @ordered
	 */
	SYNCHRONIZED(3, "synchronized", "synchronized");

	/**
	 * The '<em><b>Delayed</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Delayed</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DELAYED
	 * @model name="delayed"
	 * @generated
	 * @ordered
	 */
	public static final int DELAYED_VALUE = 0;

	/**
	 * The '<em><b>Denied</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Denied</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DENIED
	 * @model name="denied"
	 * @generated
	 * @ordered
	 */
	public static final int DENIED_VALUE = 1;

	/**
	 * The '<em><b>Granted</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Granted</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GRANTED
	 * @model name="granted"
	 * @generated
	 * @ordered
	 */
	public static final int GRANTED_VALUE = 2;

	/**
	 * The '<em><b>Synchronized</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Synchronized</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SYNCHRONIZED
	 * @model name="synchronized"
	 * @generated
	 * @ordered
	 */
	public static final int SYNCHRONIZED_VALUE = 3;

	/**
	 * An array of all the '<em><b>Execution Permission</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ExecutionPermission[] VALUES_ARRAY =
		new ExecutionPermission[] {
			DELAYED,
			DENIED,
			GRANTED,
			SYNCHRONIZED,
		};

	/**
	 * A public read-only list of all the '<em><b>Execution Permission</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ExecutionPermission> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Execution Permission</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ExecutionPermission get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionPermission result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Permission</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ExecutionPermission getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ExecutionPermission result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Execution Permission</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static ExecutionPermission get(int value) {
		switch (value) {
			case DELAYED_VALUE: return DELAYED;
			case DENIED_VALUE: return DENIED;
			case GRANTED_VALUE: return GRANTED;
			case SYNCHRONIZED_VALUE: return SYNCHRONIZED;
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
	private ExecutionPermission(int value, String name, String literal) {
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
	
} //ExecutionPermission
