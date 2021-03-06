package eu.vicci.process.devices;

import eu.vicci.process.devices.core.Device;

public class Actuator extends Device {
	
	private String serviceName;

	public Actuator(String uid, String location, String serviceName) {
		super(uid, location);
		this.serviceName = serviceName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
}
