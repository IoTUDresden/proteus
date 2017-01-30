package eu.vicci.process.devices;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import eu.vicci.process.devices.core.Device;

public class DeviceManager {
	
	private static DeviceManager dm;
	private Map<String, Device> devices = Collections.synchronizedMap(new HashMap<String, Device>());
	
	private DeviceManager() {
	}
	
	public static synchronized DeviceManager getInstance() {
		if (dm == null) {
			dm = new DeviceManager();
		}
		return dm;
	}

	public Map<String, Device> getDevices() {
		return devices;
	}
	
	public void addDevice(Device device){
		devices.put(device.getUid(), device);
	}
	
	/**
	 * This will override existing devices, with the same uid.
	 * @param devices
	 */
	public void addDevices(List<? extends Device> devices){
		for (Device device : devices)
			this.devices.put(device.getUid(), device);		
	}
	
	/**
	 * Removes the old device if exists and put in the new device
	 * @param device
	 */
	public void updateDevice(Device device){
		devices.put(device.getUid(), device);
		
	}
	
	public Device removeDevice(Device device){
		return devices.remove(device.getUid());
	}
	
	public Device removeDevice(String uid){
		return devices.remove(uid);
	}
	
	/**
	 * Trys to get the Device with the given uid from the device manager
	 * @param uid
	 * @param clazz
	 * @return null if not present
	 */
	@SuppressWarnings("unchecked") //check is done
	public <T extends Device> T getDeviceIfRegistered(String uid, Class<T> clazz){		
		Device device = devices.get(uid);
		if(device == null || !device.getClass().equals(clazz))
			return null;
		return (T)device;
	}
}
