package eu.vicci.process.model.implementations.tests;

import static eu.vicci.process.model.sofia.Comparator.DISTINCT;
import static eu.vicci.process.model.sofia.Comparator.EQUAL;
import static eu.vicci.process.model.sofia.Comparator.GREATER_THAN;
import static eu.vicci.process.model.sofia.Comparator.GREATER_THAN_OR_EQUAL;
import static eu.vicci.process.model.sofia.Comparator.SMALLER_THAN;
import static eu.vicci.process.model.sofia.Comparator.SMALLER_THAN_OR_EQUAL;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import eu.vicci.process.model.implementation.tests.util.TestUtil;
import eu.vicci.process.model.implementation.tests.util.TestsBase;
import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

/**
 * Tests for the ConditionInstance
 */
public class ConditionInstanceTests extends TestsBase {

	/**
	 * Tests the evaluate()-Method on underlying IntegerTypeInstance.
	 * 
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void conditionEvaluateIntegerTest() throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		ConditionInstance smallerThanTrue = createIntCondition(SMALLER_THAN, "1", "2");
		ConditionInstance smallerThanFalse = createIntCondition(SMALLER_THAN, "2", "1");
		ConditionInstance smallerEqualTrue = createIntCondition(SMALLER_THAN_OR_EQUAL, "1", "1");
		ConditionInstance smallerEqualTrue2 = createIntCondition(SMALLER_THAN_OR_EQUAL, "1", "2");
		ConditionInstance smallerEqualFalse = createIntCondition(SMALLER_THAN_OR_EQUAL, "2", "1");
		ConditionInstance greaterThanTrue = createIntCondition(GREATER_THAN, "2", "1");
		ConditionInstance greaterThanFalse = createIntCondition(GREATER_THAN, "1", "2");
		ConditionInstance greaterEqualTrue = createIntCondition(GREATER_THAN_OR_EQUAL, "2", "1");
		ConditionInstance greaterEqualTrue2 = createIntCondition(GREATER_THAN_OR_EQUAL, "1", "1");
		ConditionInstance greaterEqualFalse = createIntCondition(GREATER_THAN_OR_EQUAL, "1", "2");
		ConditionInstance equalsTrue = createIntCondition(EQUAL, "1", "1");
		ConditionInstance equalsFalse = createIntCondition(EQUAL, "2", "1");
		ConditionInstance distinctTrue = createIntCondition(DISTINCT, "2", "1");
		ConditionInstance distinctFalse = createIntCondition(DISTINCT, "1", "1");

		assertTrue("1 < 2", smallerThanTrue.evaluate());
		assertFalse("2 < 1", smallerThanFalse.evaluate());
		assertTrue("1 <= 1", smallerEqualTrue.evaluate());
		assertTrue("1 <= 2", smallerEqualTrue2.evaluate());
		assertFalse("2 <= 1", smallerEqualFalse.evaluate());
		assertTrue("2 > 1", greaterThanTrue.evaluate());
		assertFalse("1 > 2", greaterThanFalse.evaluate());
		assertTrue("2 >= 1", greaterEqualTrue.evaluate());
		assertTrue("1 >= 1", greaterEqualTrue2.evaluate());
		assertFalse("1 >= 2", greaterEqualFalse.evaluate());
		assertTrue("1 == 1", equalsTrue.evaluate());
		assertFalse("2 == 1", equalsFalse.evaluate());
		assertTrue("2 != 1", distinctTrue.evaluate());
		assertFalse("1 != 1", distinctFalse.evaluate());
	}

	/**
	 * Tests the evaluate()-Method on underlying StringTypeInstance.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void conditionEvaluateStringTest() throws NoSuchMethodException,
			InvocationTargetException, IllegalAccessException {
		ConditionInstance smallerThanTrue = createStringCondition(SMALLER_THAN, "aa", "ab");
		ConditionInstance smallerThanFalse = createStringCondition(SMALLER_THAN, "ab", "aa");
		ConditionInstance smallerEqualTrue = createStringCondition(SMALLER_THAN_OR_EQUAL, "aa", "aa");
		ConditionInstance smallerEqualTrue2 = createStringCondition(SMALLER_THAN_OR_EQUAL, "aa", "ab");
		ConditionInstance smallerEqualFalse = createStringCondition(SMALLER_THAN_OR_EQUAL, "ab", "aa");
		ConditionInstance greaterThanTrue = createStringCondition(GREATER_THAN, "ab", "aa");
		ConditionInstance greaterThanFalse = createStringCondition(GREATER_THAN, "aa", "ab");
		ConditionInstance greaterEqualTrue = createStringCondition(GREATER_THAN_OR_EQUAL, "ab", "aa");
		ConditionInstance greaterEqualTrue2 = createStringCondition(GREATER_THAN_OR_EQUAL, "aa", "aa");
		ConditionInstance greaterEqualFalse = createStringCondition(GREATER_THAN_OR_EQUAL, "aa", "ab");
		ConditionInstance equalsTrue = createStringCondition(EQUAL, "aa", "aa");
		ConditionInstance equalsFalse = createStringCondition(EQUAL, "ab", "aa");
		ConditionInstance distinctTrue = createStringCondition(DISTINCT, "ab", "aa");
		ConditionInstance distinctFalse = createStringCondition(DISTINCT, "aa", "aa");
		
		ConditionInstance smallerThanTrueCase = createStringCondition(SMALLER_THAN, "Aa", "aa");
		ConditionInstance smallerThanFalseCase = createStringCondition(SMALLER_THAN, "aa", "Aa");
		ConditionInstance greaterThanTrueCase = createStringCondition(GREATER_THAN, "ab", "aB");
		ConditionInstance equalsTrueCase = createStringCondition(EQUAL, "ab", "ab");
		ConditionInstance distinctTrueCase = createStringCondition(DISTINCT, "ab", "aB");

		assertTrue("aa < ab", smallerThanTrue.evaluate());
		assertFalse("ab < aa", smallerThanFalse.evaluate());
		assertTrue("aa <= aa", smallerEqualTrue.evaluate());
		assertTrue("aa <= ab", smallerEqualTrue2.evaluate());
		assertFalse("ab <= aa", smallerEqualFalse.evaluate());
		assertTrue("ab > aa", greaterThanTrue.evaluate());
		assertFalse("aa > ab", greaterThanFalse.evaluate());
		assertTrue("ab >= aa", greaterEqualTrue.evaluate());
		assertTrue("aa >= aa", greaterEqualTrue2.evaluate());
		assertFalse("aa >= ab", greaterEqualFalse.evaluate());
		assertTrue("aa == aa", equalsTrue.evaluate());
		assertFalse("ab == aa", equalsFalse.evaluate());
		assertTrue("ab != aa", distinctTrue.evaluate());
		assertFalse("aa != aa", distinctFalse.evaluate());
		
		assertTrue("Aa < aa", smallerThanTrueCase.evaluate());
		assertFalse("aa < Aa", smallerThanFalseCase.evaluate());
		assertTrue("ab > aB", greaterThanTrueCase.evaluate());
		assertTrue("ab == ab", equalsTrueCase.evaluate());
		assertTrue("ab != aB", distinctTrueCase.evaluate());
	}
	
	/**
	 * Tests the evaluate()-Method on underlying BooleanTypeInstance.
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@Test
	public void conditionEvaluateBooleanTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
		ConditionInstance smallerThanTrue = createBooleanCondition(SMALLER_THAN, "false", "true");
		ConditionInstance smallerThanFalse = createBooleanCondition(SMALLER_THAN, "true", "false");
		ConditionInstance smallerEqualTrue = createBooleanCondition(SMALLER_THAN_OR_EQUAL, "false", "false");
		ConditionInstance smallerEqualTrue2 = createBooleanCondition(SMALLER_THAN_OR_EQUAL, "false", "true");
		ConditionInstance smallerEqualFalse = createBooleanCondition(SMALLER_THAN_OR_EQUAL, "true", "false");
		ConditionInstance greaterThanTrue = createBooleanCondition(GREATER_THAN, "true", "false");
		ConditionInstance greaterThanFalse = createBooleanCondition(GREATER_THAN, "false", "true");
		ConditionInstance greaterEqualTrue = createBooleanCondition(GREATER_THAN_OR_EQUAL, "true", "false");
		ConditionInstance greaterEqualTrue2 = createBooleanCondition(GREATER_THAN_OR_EQUAL, "false", "false");
		ConditionInstance greaterEqualFalse = createBooleanCondition(GREATER_THAN_OR_EQUAL, "false", "true");
		ConditionInstance equalsTrue = createBooleanCondition(EQUAL, "false", "false");
		ConditionInstance equalsFalse = createBooleanCondition(EQUAL, "true", "false");
		ConditionInstance distinctTrue = createBooleanCondition(DISTINCT, "true", "false");
		ConditionInstance distinctFalse = createBooleanCondition(DISTINCT, "false", "false");
		assertTrue("false < true", smallerThanTrue.evaluate());
		assertFalse("true < false", smallerThanFalse.evaluate());
		assertTrue("false <= false", smallerEqualTrue.evaluate());
		assertTrue("false <= true", smallerEqualTrue2.evaluate());
		assertFalse("true <= false", smallerEqualFalse.evaluate());
		assertTrue("true > false", greaterThanTrue.evaluate());
		assertFalse("false > true", greaterThanFalse.evaluate());
		assertTrue("true >= false", greaterEqualTrue.evaluate());
		assertTrue("false >= false", greaterEqualTrue2.evaluate());
		assertFalse("false >= true", greaterEqualFalse.evaluate());
		assertTrue("false == false", equalsTrue.evaluate());
		assertFalse("true == false", equalsFalse.evaluate());
		assertTrue("true != false", distinctTrue.evaluate());
		assertFalse("false != false", distinctFalse.evaluate());		
	}
	
	private static ConditionInstance createBooleanCondition(Comparator comparator, String leftValue,
			String rightValue) throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException {
		return TestUtil.createConditionInstance(comparator, BooleanTypeInstance.class, leftValue,
				rightValue);
	}

	private static ConditionInstance createStringCondition(Comparator comparator, String leftValue,
			String rightValue) throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException {
		return TestUtil.createConditionInstance(comparator, StringTypeInstance.class, leftValue,
				rightValue);
	}

	private static ConditionInstance createIntCondition(Comparator comparator, String leftValue,
			String rightValue) throws NoSuchMethodException, InvocationTargetException,
			IllegalAccessException {
		return TestUtil.createConditionInstance(comparator, IntegerTypeInstance.class, leftValue,
				rightValue);
	}
}
