package eu.vicci.process.model.implementations.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.espertech.esper.event.bean.BeanEventBean;

import eu.vicci.process.devices.core.Sensor;
import eu.vicci.process.devices.events.SensorEvent;
import eu.vicci.process.devices.events.core.EventType;
import eu.vicci.process.model.implementation.tests.util.TestUtil;
import eu.vicci.process.model.sofia.EndDataPort;
import eu.vicci.process.model.sofia.SimpleType;
import eu.vicci.process.model.sofia.impl.SofiaFactoryImpl;
import eu.vicci.process.model.sofiainstance.DataTypeInstance;
import eu.vicci.process.model.sofiainstance.DoubleTypeInstance;
import eu.vicci.process.model.sofiainstance.EndDataPortInstance;
import eu.vicci.process.model.sofiainstance.StringTypeInstance;
import eu.vicci.process.model.sofiainstance.impl.custom.EndDataPortInstanceImplCustom;
import eu.vicci.process.model.sofiainstance.util.TriggeredEventWorker;

public class TriggeredEventWorkerTests {
	private static final String WRONG_SELECTION = "The value should not be in the selection.";

	/**
	 * Tests the replacement of the placeholders in the triggered event worker
	 * @throws Exception
	 */
	@Test
	public void replacePlaceholderTest() throws Exception {
		List<DataTypeInstance> startParameter = createStartParameter();	
		Method replaceMethod = TriggeredEventWorker.class
				.getDeclaredMethod("replacePlaceholder", String.class, List.class);	
		replaceMethod.setAccessible(true);
		Object returnValue = replaceMethod.invoke(null, originalEpl, startParameter);
		assertEquals("The EPL statement placeholders are not replaced correctly", replacedEpl, returnValue);
	}
	
	/**
	 * Tests the extraction of the selection vars in the epl statement.
	 * @throws Exception
	 */
	@Test
	public void getSelectionsTest() throws Exception {
		List<String> selections = getSelections(selectionEpl);
		assertEquals(WRONG_SELECTION, "temp", selections.get(0));
		assertEquals(WRONG_SELECTION, "loc", selections.get(1));
		assertEquals(WRONG_SELECTION, "somethingOther", selections.get(2));
	}
	
	/**
	 * Tests the extraction of the selection vars in the epl statement. Test for only one var.
	 * @throws Exception
	 */
	@Test
	public void getSingleSelectionsTest() throws Exception{
		List<String> selections = getSelections(replacedEpl);
		assertEquals(WRONG_SELECTION, "temp", selections.get(0));		
	}	

	@Test
	@SuppressWarnings("unchecked")
	public void getReturnedValuesTest() throws Exception{
		TriggeredEventWorker eventWorker = new TriggeredEventWorker();
		EventType eventType = new EventType("temperature", Double.class);
		Sensor sensor = new Sensor("test_sensor", "living room", "temperature", eventType, Double.class, "°C");		
		long timeStamp = System.currentTimeMillis();
		SensorEvent event = new SensorEvent(eventType, 22.2, timeStamp, sensor);		
		BeanEventBean bean = new BeanEventBean(event, null);
		BeanEventBean[] beans = { bean };	
		
		Field newDataField = TriggeredEventWorker.class.getDeclaredField("newData");
		newDataField.setAccessible(true);
		newDataField.set(eventWorker, beans);		
		
		Method getReturnValuesMethod = TriggeredEventWorker.class.getDeclaredMethod("getReturnedValues", String.class, List.class);
		getReturnValuesMethod.setAccessible(true);
		
		List<EndDataPortInstance> endports = createEndportList();
		
		Object returned = getReturnValuesMethod.invoke(eventWorker, selectionForReturneValues, endports);
		List<DataTypeInstance> returnValues = (List<DataTypeInstance>)returned;
		assertFalse("The returned values should not be empty", returnValues.isEmpty());
		DataTypeInstance dt1 = returnValues.get(0);
		DataTypeInstance dt2 = returnValues.get(1);
		
		assertEquals("false selection value received", 22.2, dt1.getValueAsObject());
		assertEquals("false selection value received", "test_sensor", dt2.getValueAsObject());
		
		assertTrue("Wrong Data Type Instance created", dt1 instanceof DoubleTypeInstance);
		assertTrue("Wrong Data Type Instance created", dt2 instanceof StringTypeInstance);
	}
	
	//Only one endport with value
	private static List<EndDataPortInstance> createEndportList(){
		List<EndDataPortInstance> endports = new ArrayList<>();
		EndDataPortInstance ep1 = createEndDataPortInstance("valuePort", "value", 
				SofiaFactoryImpl.eINSTANCE.createDoubleType());
		
		EndDataPortInstance ep2 = createEndDataPortInstance("uidPort", "uid", 
				SofiaFactoryImpl.eINSTANCE.createStringType());
		
		endports.add(ep1);	
		endports.add(ep2);		
		return endports;
	}
	
	private static EndDataPortInstance createEndDataPortInstance(String portName, String typeName, SimpleType type){
		EndDataPortInstance ep1 = new EndDataPortInstanceImplCustom();
		EndDataPort data = SofiaFactoryImpl.eINSTANCE.createEndDataPort();
		type.setName(typeName);
		data.setName(portName);
		data.setPortDatatype(type);
		ep1.setPortType(data);
		ep1.setName(portName);
		return ep1;		
	}
	
	@SuppressWarnings("unchecked")
	private static List<String> getSelections(String eplStmt) throws Exception{
		Method selectionMethod = TriggeredEventWorker.class.getDeclaredMethod("getSelection", String.class);
		selectionMethod.setAccessible(true);
		Object returned = selectionMethod.invoke(null, selectionEpl);
		List<String> selections = (List<String>)returned;	
		return selections;
	}
	
	private static List<DataTypeInstance> createStartParameter() throws Exception{
		DataTypeInstance data1 = TestUtil.createDataTypeInstance(StringTypeInstance.class, "temp");
		data1.setName("data1");
		DataTypeInstance data2 = TestUtil.createDataTypeInstance(DoubleTypeInstance.class, "22.2");
		data2.setName("data2");
		List<DataTypeInstance> list = new ArrayList<DataTypeInstance>();
		list.add(data1);
		list.add(data2);
		return list;
	}
	
	private static final String originalEpl = "select <{ data1 }> from SensorEvent where <{data1}>><{ data2 }>";
	
	private static final String replacedEpl = "select temp from SensorEvent where temp>22.2";
	
	private static final String selectionEpl = "select temp, loc, somethingOther FROM SensorEvent where temp>22.2";
	
	private static final String selectionForReturneValues = "select value, uid from SensorEvent where temp>20";
}
