/**
 */
package eu.vicci.process.model.sofia;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Human Task Use Case</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see eu.vicci.process.model.sofia.SofiaPackage#getHumanTaskUseCase()
 * @model
 * @generated
 */
public enum HumanTaskUseCase implements Enumerator {
	/**
	 * The '<em><b>UNIVERSAL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNIVERSAL_VALUE
	 * @generated
	 * @ordered
	 */
	UNIVERSAL(0, "UNIVERSAL", "UNIVERSAL"),

	/**
	 * The '<em><b>COFFEE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COFFEE_VALUE
	 * @generated
	 * @ordered
	 */
	COFFEE(1, "COFFEE", "COFFEE"),

	/**
	 * The '<em><b>HEATING</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEATING_VALUE
	 * @generated
	 * @ordered
	 */
	HEATING(2, "HEATING", "HEATING"),

	/**
	 * The '<em><b>ORDER</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORDER_VALUE
	 * @generated
	 * @ordered
	 */
	ORDER(3, "ORDER", "ORDER"),

	/**
	 * The '<em><b>PLANTS</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLANTS_VALUE
	 * @generated
	 * @ordered
	 */
	PLANTS(4, "PLANTS", "PLANTS"),

	/**
	 * The '<em><b>BELL</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELL_VALUE
	 * @generated
	 * @ordered
	 */
	BELL(5, "BELL", "BELL"),

	/**
	 * The '<em><b>HEALTH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HEALTH_VALUE
	 * @generated
	 * @ordered
	 */
	HEALTH(6, "HEALTH", "HEALTH");

	/**
	 * The '<em><b>UNIVERSAL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>UNIVERSAL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNIVERSAL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int UNIVERSAL_VALUE = 0;

	/**
	 * The '<em><b>COFFEE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>COFFEE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COFFEE
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int COFFEE_VALUE = 1;

	/**
	 * The '<em><b>HEATING</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEATING</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEATING
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEATING_VALUE = 2;

	/**
	 * The '<em><b>ORDER</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ORDER</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORDER
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int ORDER_VALUE = 3;

	/**
	 * The '<em><b>PLANTS</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>PLANTS</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLANTS
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int PLANTS_VALUE = 4;

	/**
	 * The '<em><b>BELL</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BELL</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BELL
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int BELL_VALUE = 5;

	/**
	 * The '<em><b>HEALTH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HEALTH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HEALTH
	 * @model
	 * @generated
	 * @ordered
	 */
	public static final int HEALTH_VALUE = 6;

	/**
	 * An array of all the '<em><b>Human Task Use Case</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final HumanTaskUseCase[] VALUES_ARRAY =
		new HumanTaskUseCase[] {
			UNIVERSAL,
			COFFEE,
			HEATING,
			ORDER,
			PLANTS,
			BELL,
			HEALTH,
		};

	/**
	 * A public read-only list of all the '<em><b>Human Task Use Case</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<HumanTaskUseCase> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Human Task Use Case</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HumanTaskUseCase get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HumanTaskUseCase result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Human Task Use Case</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HumanTaskUseCase getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			HumanTaskUseCase result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Human Task Use Case</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static HumanTaskUseCase get(int value) {
		switch (value) {
			case UNIVERSAL_VALUE: return UNIVERSAL;
			case COFFEE_VALUE: return COFFEE;
			case HEATING_VALUE: return HEATING;
			case ORDER_VALUE: return ORDER;
			case PLANTS_VALUE: return PLANTS;
			case BELL_VALUE: return BELL;
			case HEALTH_VALUE: return HEALTH;
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
	private HumanTaskUseCase(int value, String name, String literal) {
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
	
} //HumanTaskUseCase
