package eu.vicci.process.server.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class LinuxBattery {	
	private static final String BAT_PATH = "/sys/class/power_supply";
	private static final String BAT_NAME = "BAT";
	private static final String BAT_CAP = "capacity";
	
	private File file;
	
	public LinuxBattery() {
		file = new File(BAT_PATH);
	}
	
	public boolean hasBattery(){
		if(!file.exists())
			return false;		
		return findFirstBat() != null;
	}
	
	/**
	 * Gets the Battery level of the battery which is found at first
	 * @return
	 */
	public Integer getBatteryLevel(){
		if(!file.exists())
			return null;
		
		String firstBat = findFirstBat();
		if(firstBat == null)
			return null;
		String cmd = "cat " + BAT_PATH + "/" + firstBat + "/" + BAT_CAP;
		
		Integer out = null;
		
		try {
			Process proc = Runtime.getRuntime().exec(cmd);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String value = stdInput.readLine();
			out = Integer.parseInt(value);	
		} catch (Exception e) {
			e.printStackTrace();
		} 
				
		return out;		
	}
	
	private String findFirstBat(){
		File[] files = file.listFiles();
		for (int i = 0; i < files.length; i++) {
			if(files[i].getName().startsWith(BAT_NAME))
				return files[i].getName();
		}
		return null;
	}

}
