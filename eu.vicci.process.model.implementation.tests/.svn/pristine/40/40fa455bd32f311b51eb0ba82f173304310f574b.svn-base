package eu.vicci.process.model.implementation.tests.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import eu.vicci.process.model.sofia.Comparator;
import eu.vicci.process.model.sofia.Condition;
import eu.vicci.process.model.sofia.SofiaFactory;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;
import eu.vicci.process.model.sofiainstance.ConditionInstance;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.StartDataPortInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;

public class TestUtil {
	private static final SofiaInstanceFactoryImplCustom SOFIA_I_FACTORY = SofiaInstanceFactoryImplCustom
			.getInstance();
	private static final SofiaFactory SOFIA_FACTORY = SofiaFactoryImpl.eINSTANCE;

	/**
	 * Returns a ConditionInstance with the specified Comperator, underlying
	 * DataTypeInstance and its values for the left and right side
	 * 
	 * @param comparator
	 * @param dataTypeInstanceClass
	 *            - the underlying DataInstance which to generate
	 * @param leftValue
	 *            - left value of the condition
	 * @param rightValue
	 *            - right value of the condition
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static ConditionInstance createConditionInstance(Comparator comparator,
			Class<? extends DataTypeInstance> dataTypeInstanceClass, String leftValue, String rightValue)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		ConditionInstance instance = SOFIA_I_FACTORY.createConditionInstance();
		Condition condition = SOFIA_FACTORY.createCondition();
		condition.setComparator(comparator);
		instance.setIfConditionType(condition);
		StartDataPortInstance leftPort = createStartDataPort(dataTypeInstanceClass, leftValue);
		StartDataPortInstance rightPort = createStartDataPort(dataTypeInstanceClass, rightValue);
		instance.setLeftSide(leftPort);
		instance.setRightSide(rightPort);
		return instance;
	}

	/**
	 * Creates a StartDataPortInstance with the specified underlying DataTypeInstance
	 * 
	 * @param dataTypeInstanceClass
	 *            - the underlying DataInstance which to generate
	 * @param valueAsString
	 *            - the value as string
	 * @return
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static StartDataPortInstance createStartDataPort(
			Class<? extends DataTypeInstance> dataTypeInstanceClass, String valueAsString)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		StartDataPortInstance instance = SOFIA_I_FACTORY.createStartDataPortInstance();

		DataTypeInstance dataTypeInstance = createDataTypeInstance(dataTypeInstanceClass, valueAsString);
		dataTypeInstance.parse(valueAsString);
		instance.setDataInstance(dataTypeInstance);
		return instance;
	}

	/**
	 * Creates a DataTypeInstance with the given value
	 * 
	 * @param dataTypeInstanceClass
	 *            - DataInstance Type which to generate
	 * @param valueAsString
	 *            value that will be parsed to the required DataType. If null - the value is not set
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public static <T extends DataTypeInstance> T createDataTypeInstance(Class<T> dataTypeInstanceClass,
			String valueAsString) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		String createMethod = "create" + dataTypeInstanceClass.getSimpleName();
		Method method = SOFIA_I_FACTORY.getClass().getMethod(createMethod);
		T dataTypeInstance = (T) method.invoke(SOFIA_I_FACTORY);
		if (valueAsString != null)
			dataTypeInstance.parse(valueAsString);
		return dataTypeInstance;
	}

}
