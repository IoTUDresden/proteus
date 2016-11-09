package eu.vicci.process.devices.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class SeMiWaListenerThread extends Thread implements Runnable {
		
	@Override
	public void run() {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("conf/semiwa.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				
//		this.createListenerNode("VicciProcessesListener", true);

		// Generates an example node in a background thread.
		
	}
	
	public SeMiWaListenerNodeThread createListenerNode(String uid, Boolean listener) {

		HashMap<String, String> dataSheet = new HashMap<String, String>();
		dataSheet.put("uid", uid);
		dataSheet.put("deviceName", "VICCI Process Engine");
		dataSheet.put("deviceUnit", "xsd:string");
		dataSheet.put("deviceType", "Process");
		SeMiWaListenerNodeThread node = new SeMiWaListenerNodeThread(dataSheet, null, listener);
		node.start();
		return node;
	}

	
}

