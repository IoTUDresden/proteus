package eu.vicci.process.server.util.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.vicci.process.server.util.Util;

public class SystemBatteryTest {

	@Test
	public void systemBatteryTest() {
		Integer value = Util.getSystemBatteryStatus();
		if(value == null) assertFalse("error getting the current battery status", Util.systemHasBattery());
		else assertTrue("the battery value must be between 0 and 100 %", value >= 0 && value <= 100);	
		if(value != null) System.out.println("Battery Status: " + value + " %");
	}

}
