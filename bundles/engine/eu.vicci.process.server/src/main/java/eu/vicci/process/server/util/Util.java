package eu.vicci.process.server.util;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

import org.apache.commons.lang3.SystemUtils;

import eu.vicci.process.model.util.configuration.ConfigProperties;
import eu.vicci.process.model.util.configuration.ConfigurationManager;

public class Util {	
	private static volatile boolean returnStaticBatteryLevel = false;
	private static volatile Integer staticBatteryLevel = 100;
	
	/**
	 * Allows to manipulate the returned battery level which can be received by {@link #getSystemBatteryStatus()}.
	 * If set to true, a static value is returned by {@link #getSystemBatteryStatus()}. The static value can be set via 
	 * {@link #setStaticBatteryLevel()}.
	 *</br> 
	 * If set to true, it also affects the value received by {@link #systemHasBattery()}, so always true is returned.
	 * </br>
	 * Default static battery level is {@link #staticBatteryLevel}.
	 * @param returnStatic
	 */
	public static void returnStaticBatteryLevel(boolean returnStatic){
		returnStaticBatteryLevel = returnStatic;				
	}
	
	/**
	 * Sets a static battery value. {@link #returnStaticBatteryLevel(boolean)} must be set to true, to return the static value.
	 * @param level
	 */
	public static void setStaticBatteryLevel(Integer level){
		staticBatteryLevel = level;		
	}
	
	/**
	 * Tries to get the IP, with the Filter specified in the config.
	 * E.g. Filter 192.168, will return the first IP match which starts with 192.168.
	 * 
	 * If no filter is specified, the value of <code>Inet4Address.getLocalHost().getHostAddress()</code> is returned.
	 * 
	 * @return null if no IP was found
	 */
	public static String getLocalIpWithFilter(){
		String filter = ConfigurationManager.getInstance().getConfigAsString(ConfigProperties.IP_FILTER);
		String ip = null;
		
		try {
			ip = loopIpAddresses(filter);
		} catch (UnknownHostException | SocketException e) {
			e.printStackTrace(); //if no IP was found, the error is handled on an other point
		}
		return ip;
	}
	
	/**
	 * Tries to get the battery status. Returns null if no battery could be detected or the system not have any battery.
	 * 
	 * Tested on:
	 * Win 10
	 * @return
	 */
	public static Integer getSystemBatteryStatus(){
		if(returnStaticBatteryLevel)
			return staticBatteryLevel;
		if(SystemUtils.IS_OS_WINDOWS)
			return getWindowsBattery();
		if (SystemUtils.IS_OS_UNIX)
			return getUnixBattery();
		if (SystemUtils.IS_OS_LINUX)
			return getLinuxBattery();		
		throw new RuntimeException("unsupported operating system");	
	}
	
	/**
	 * Checks if the given system has a battery.
	 * @return
	 */
	public static boolean systemHasBattery(){
		if(returnStaticBatteryLevel)
			return true;
		if(SystemUtils.IS_OS_WINDOWS)
			return windowsHasBattery();
		if (SystemUtils.IS_OS_LINUX)
			return linuxHasBattery();	
		if (SystemUtils.IS_OS_UNIX)
			return unixHasBattery();	
		throw new RuntimeException("unsupported operating system");	
	}
	
	
	private static boolean windowsHasBattery(){
		Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
		Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);	
		return batteryStatus.hasBattery();		
	}
	
	private static boolean linuxHasBattery(){
		return new LinuxBattery().hasBattery();
	}
	
	private static boolean unixHasBattery(){
		return new LinuxBattery().hasBattery();
	}
	
	private static Integer getWindowsBattery(){
		Kernel32.SYSTEM_POWER_STATUS batteryStatus = new Kernel32.SYSTEM_POWER_STATUS();
		Kernel32.INSTANCE.GetSystemPowerStatus(batteryStatus);	

		if(!batteryStatus.hasBattery())
			return null;
		return new Integer(batteryStatus.getBatteryLifePercentInt());
	}
	
	private static Integer getLinuxBattery(){
		return new LinuxBattery().getBatteryLevel();
	}
	
	private static Integer getUnixBattery(){
		return new LinuxBattery().getBatteryLevel();
	}
	
	private static String loopIpAddresses(String filter) throws UnknownHostException, SocketException {
		if(filter == null || filter.isEmpty()) return Inet4Address.getLocalHost().getHostAddress();
		
		Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
		    NetworkInterface n = e.nextElement();
		    Enumeration<InetAddress> ee = n.getInetAddresses();
		    while (ee.hasMoreElements())
		    {
		        InetAddress i = ee.nextElement();
		        String candidate = i.getHostAddress();
		        if(candidate.startsWith(filter))
		        	return candidate;
		    }
		}
		return null;
	}

}
