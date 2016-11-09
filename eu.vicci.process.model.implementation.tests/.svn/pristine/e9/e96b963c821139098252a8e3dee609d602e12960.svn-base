package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;

import org.junit.Ignore;
import org.junit.Test;

import eu.vicci.process.model.implementation.tests.util.TestUtil;
import eu.vicci.process.model.implementation.tests.util.TestsBase;
import eu.vicci.process.model.sofiainstance.BooleanTypeInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.IntegerTypeInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;

/**
 * Tests for the DataTypeInstance compareTo-Method
 */
public class DataTypeInstanceCompareToTests extends TestsBase {

	@Test
	public void stringTypeCompareToTest() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DataTypeInstance ab = TestUtil.createDataTypeInstance(StringTypeInstance.class, "ab");
		DataTypeInstance aa = TestUtil.createDataTypeInstance(StringTypeInstance.class, "aa");
		DataTypeInstance aA = TestUtil.createDataTypeInstance(StringTypeInstance.class, "aA");
		DataTypeInstance aa2 = TestUtil.createDataTypeInstance(StringTypeInstance.class, "aa");

		assertTrue("ab compareTo aa must return a value > 0", ab.compareTo(aa) > 0);
		assertTrue("aa compareTo aa must return 0", aa.compareTo(aa2) == 0);
		assertTrue("aA compareTo aa must return a value < 0", aA.compareTo(aa) < 0);
	}

	@Test
	public void intTypeCompareToTest() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DataTypeInstance int1 = TestUtil.createDataTypeInstance(IntegerTypeInstance.class, "1");
		DataTypeInstance int2 = TestUtil.createDataTypeInstance(IntegerTypeInstance.class, "2");
		DataTypeInstance int12 = TestUtil.createDataTypeInstance(IntegerTypeInstance.class, "1");

		assertTrue("1 compareTo 2 must return a value < 0", int1.compareTo(int2) < 0);
		assertTrue("1 compareTo 1 must return 0", int1.compareTo(int12) == 0);
		assertTrue("2 compareTo 1 must return a value > 0", int2.compareTo(int1) > 0);
	}

	@Test
	public void booleanTypeCompareToTest() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DataTypeInstance trueType = TestUtil.createDataTypeInstance(BooleanTypeInstance.class,
				"true");
		DataTypeInstance falseType = TestUtil.createDataTypeInstance(BooleanTypeInstance.class,
				"false");
		DataTypeInstance trueType2 = TestUtil.createDataTypeInstance(BooleanTypeInstance.class,
				"true");		
		
		assertTrue("true compareTo false must return a value > 0", trueType.compareTo(falseType) > 0);
		assertTrue("true compareTo true must return 0", trueType.compareTo(trueType2) == 0);
		assertTrue("false compareTo true must return a value < 0", falseType.compareTo(trueType) < 0);
	}
	
	@Test
	public void doubleTypeCompareToTest() throws Exception{
		DataTypeInstance d1 = TestUtil.createDataTypeInstance(DoubleTypeInstance.class, "22.1");
		DataTypeInstance d2 = TestUtil.createDataTypeInstance(DoubleTypeInstance.class, "22.2");
		DataTypeInstance d3 = TestUtil.createDataTypeInstance(DoubleTypeInstance.class, "22.1");
		
		assertTrue("22.1 is less than 22.2", d1.compareTo(d2) < 0);
		assertTrue("22.2 is greater than 22.1", d2.compareTo(d1) > 0);
		assertTrue("22.1 is equal to 22.1", d1.compareTo(d3) == 0);	
	}

	@Test
	@Ignore
	public void complexTypeCompareToTest() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void setTypeCompareToTest() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void listTypeCompareToTest() {
		fail("Not yet implemented");
	}

}
