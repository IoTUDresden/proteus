package eu.vicci.process.model.sofiainstance.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import eu.vicci.process.model.sofia.DataType;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.SofiaInstanceFactoryImplCustom;

/**
 * Utility to generate data instances. Should be threading safe.
 * 
 * @author André Kühnert
 *
 */
public class DataTypeInstanceGenerator {
	private Map<String, Integer> dataInstanceNumbers = Collections.synchronizedMap(new HashMap<String, Integer>()); 
	
	private DataTypeInstanceGenerator() {	}
	
	public static DataTypeInstanceGenerator getInstance(){
		return GeneratorLoader.INSTANCE;
	}	
	
	public DataTypeInstance getNewDataTypeInstance(DataType dataType) {
		if(dataType == null)
			throw new IllegalArgumentException("the datatype of a port or a list should not be NULL. Check the process model");
		DataTypeInstance typeInstance = createDataTypeInstance(dataType);
		String id = dataType.getId();	
		int instanceNumber = generateInstanceNumber(dataType);
		typeInstance.setTypeId(id);
		typeInstance.setDataTypeType(dataType);
		typeInstance.setName(dataType.getName());
		typeInstance.setIdOfOrigin(id);
		typeInstance.setInstancenumber(instanceNumber);
		typeInstance.setInstanceId(id + "_Instance_" + instanceNumber);		
		return typeInstance;
	}
	
	private synchronized int generateInstanceNumber(DataType dataType){
		String id = dataType.getId();
		
		Integer out = dataInstanceNumbers.get(id);
		if(out == null)
			out = 1;
		else
			out++;
		dataInstanceNumbers.put(id, out);
		return out;
	}
	
	private DataTypeInstance createDataTypeInstance(DataType collectionItemType) {
		int lio = collectionItemType.getClass().getSimpleName().lastIndexOf("Impl");
		if (lio < 0)
			throw new IllegalArgumentException("can not find the correct factory method for "
					+ collectionItemType.getClass().getSimpleName());	
		String split = collectionItemType.getClass().getSimpleName().substring(0, lio);
		String methodName = "create".concat(split).concat("Instance");
		DataTypeInstance instance = null;				
		
		try {
			Method createMethod = SofiaInstanceFactoryImplCustom.class.getMethod(methodName);
			Object result = createMethod.invoke(SofiaInstanceFactoryImplCustom.getInstance());
			instance = (DataTypeInstance) result;
		} catch (NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("can not find the correct factory method for "
					+ collectionItemType.getClass().getSimpleName());	
		}
		return instance;
	}
	
	private static class GeneratorLoader{
		static DataTypeInstanceGenerator INSTANCE = new DataTypeInstanceGenerator();
	}

}
